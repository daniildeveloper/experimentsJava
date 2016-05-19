package xmlEdu.SAXEdu;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Lama
 */
public class SAXModelBuilder extends DefaultHandler {

    Stack<Object> stack = new Stack<>();

    /**
     *
     * @param namespace
     * @param localname
     * @param qname
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String namespace,
            String localname,
            String qname,
            Attributes attributes) throws SAXException {
        //create new element and put into any attributes
        Object element;

        try {
            String classname = Character.toUpperCase(qname.charAt(0)) + qname.substring(1);
            element = Class.forName(classname).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            element = new StringBuffer();
        }

        for (int i = 0; i < attributes.getLength(); i++) {
            try {
                setProperty(attributes.getQName(i), element, attributes.getValue(i));
            } catch (SAXException | IllegalAccessException | NoSuchFieldException e) {
                throw new SAXException("Error: " + e);
            }
        }
        stack.push(element);
    }

    @Override
    public void endElement(String namespace,
            String localname,
            String qname)
            throws SAXException {
        //add elemrnt to parent
        if (stack.size() > 1) {
            Object element = stack.pop();

            try {
                setProperty(qname, stack.peek(), element);
            } catch (SAXException | IllegalAccessException | NoSuchFieldException e) {
                throw new SAXException("Error: " + e);
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int len) {
        //return string kontekst
        String text = new String(ch, start, len);

        if (text.trim().length() == 0) {
            return;
        }
        ((StringBuffer) stack.peek()).append(text);
    }

    /**
     * Используем для установки значений в объекты. Использует ревлексию для
     * поиска поля, совпадающего с именем тега в определенном объекте.
     *
     * @param name
     * @param target
     * @param value
     * @throws SAXException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    void setProperty(String name,
            Object target,
            Object value)
            throws SAXException, IllegalAccessException, NoSuchFieldException {
        Field field = target.getClass().getField(name);

        //преобразует значение в тип поля
        if (value instanceof StringBuffer) {
            value = value.toString();
        }

        if (field.getType() == Double.class) {
            value = Double.parseDouble(value.toString());
        }

        if (Enum.class.isAssignableFrom(field.getType())) {
            value = Enum.valueOf((Class<Enum>) field.getType(), String.valueOf(toString()));
        }

        //Применяет к полю
        if (field.getType() == value.getClass()) {
            field.set(target, value);
        } else if (Collection.class.isAssignableFrom(field.getType())) {
            Collection collection = (Collection) field.get(target);
            collection.add(value);
        } else {
            throw new RuntimeException("невозможно установить свойтво " + value.toString());
        }
    }

    public Object getModel() {
        return stack.pop();
    }

}

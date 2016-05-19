package xmlEdu.exp;

import java.io.OutputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Lama
 */
public class XMLWriter {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, XMLStreamException {
        OutputStream out = OutputStream.class.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);

        writer.writeStartDocument("new.xml");
        writer.writeStartElement("config");
        writer.writeAttribute("config", "true");
        writer.writeCharacters("<x>sss</x>");
        writer.writeEndElement();
        writer.writeEndDocument();
    }

}

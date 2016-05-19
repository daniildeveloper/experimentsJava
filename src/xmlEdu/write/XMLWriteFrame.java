package xmlEdu.write;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author Lama
 */
public class XMLWriteFrame extends JFrame {

    private RectangleComponent component;
    private JFileChooser chooser;

    public XMLWriteFrame() {
        chooser = new JFileChooser();

        //ввести компоненты в фрейм
        component = new RectangleComponent();
        add(component);

        //установить строку меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem newItem = new JMenuItem("New");
        menu.add(newItem);

        newItem.addActionListener(EventHandler.create(ActionListener.class, component, "newDrawing"));
        JMenuItem saveItem = new JMenuItem("Save with DOM/XSLT");
        menu.add(saveItem);
        saveItem.addActionListener(EventHandler.create(ActionListener.class, this, "saveDocument"));

        JMenuItem saveStAXItem = new JMenuItem("Save with SAX");
        menu.add(saveStAXItem);
        saveStAXItem.addActionListener(EventHandler.create(ActionListener.class, this, "saveStAX"));

        JMenuItem exititem = new JMenuItem("Exit app");
        menu.add(exititem);
        exititem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        pack();
    }

    public void saveDocument() throws TransformerConfigurationException, TransformerException, IOException {
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        Document doc = component.buildDocument();
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd");
        t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 20000802//EN");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        t.transform(new DOMSource(doc), new StreamResult(Files.newOutputStream(file.toPath())));
    }

    public void sveStAX() throws XMLStreamException, IOException {
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        XMLStreamWriter writer;
        writer = factory.createXMLStreamWriter(Files.newOutputStream(file.toPath()));
        try {
            component.writeDocument(writer);
        } finally {
            writer.close();
        }
    }
}

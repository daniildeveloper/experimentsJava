package xmlEdu.exp;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Lama
 */
public class XMLParser {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, URISyntaxException {
        URI url = new URI("/inventory.xml");
        String aPath = "src/xmlEdu/exp/inventory.xml";
        File f = new File(aPath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(f);

        Element root = (Element) document.getDocumentElement();

        Element name = (Element) root.getElementsByTagName("key").item(0);

//        Element nameGorilla = (Element) document.getElementById("horillaName");

//        String textName = name.getTextContent();
//        String a = nameGorilla.getAttribute("id");
        name.setTextContent("hey");
        document.createElement("new");
//        document.
        System.out.println(document.getXmlStandalone());
    }
}

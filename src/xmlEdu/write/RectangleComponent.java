package xmlEdu.write;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Класс описывающий работу с прямоугольниками.
 *
 * @author Lama
 */
public class RectangleComponent extends JComponent {

    /**
     * Ширина по умолчанию
     */
    private static final int DEFAULT_WIDTH = 300;

    /**
     * высота по умолчанию
     */
    private static final int DEFAULT_HEIGHT = 200;

    /**
     * список всех рестов
     */
    private List<Rectangle2D> rects;

    /**
     * ArrayList of all colors with some numbers as rects
     */
    private List<Color> colors;

    /**
     * genenerate random int
     */
    private Random generator;

    /**
     * Build the end xml document
     */
    private DocumentBuilder builder;

    /**
     * Create objects rect, colors, generator and builder.
     */
    public RectangleComponent() {
        rects = new ArrayList<>();
        colors = new ArrayList<>();
        generator = new Random();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RectangleComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * draw some random count of rectangles and put it into rects ArrayList
     */
    public void newDrawing() {
        int n = 10 + generator.nextInt(20);
        rects.clear();
        colors.clear();
        for (int i = 0; i <= n; i++) {
            int x = generator.nextInt(getWidth());
            int y = generator.nextInt(getHeight());

            int width = generator.nextInt(getWidth() - x);
            int height = generator.nextInt(getHeight() - y);

            rects.add(new Rectangle(x, y, width, height));

            int r = generator.nextInt(256);
            int g = generator.nextInt(256);
            int b = generator.nextInt(256);

            colors.add(new Color(r, g, b));
        }
        repaint();
    }

    /**
     * paint all rectangles with random colors
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        if (rects.isEmpty()) {
            newDrawing();
        }

        Graphics2D gd = (Graphics2D) g;

        //paint all rectangles
        for (int i = 0; i < rects.size(); i++) {
            gd.setPaint(colors.get(i));
            gd.fill(rects.get(i));
        }
    }

    /**
     * make ready xml document
     *
     * @return Document - ready document
     */
    public Document buildDocument() {
        String namespace = "http://www.w3.org/2000/svg";
        Document doc = builder.newDocument();
        Element svglement = doc.createElementNS(namespace, "svg");
        doc.appendChild(svglement);
        svglement.setAttribute("width", "" + getWidth());
        svglement.setAttribute("height", "" + getHeight());

        for (int i = 0; i < rects.size(); i++) {
            Color c = colors.get(i);
            Element rectElement = doc.createElementNS(namespace, "rect");
            Rectangle2D r = rects.get(i);
            rectElement.setAttribute("x", "" + r.getX());
            rectElement.setAttribute("y", "" + r.getY());
            rectElement.setAttribute("width", "" + r.getWidth());
            rectElement.setAttribute("height", "" + r.getHeight());
            rectElement.setAttribute("fill", "" + colorToString(c));
            svglement.appendChild(rectElement);
        }

        return doc;
    }

    /**
     * transform rgb color to hex string (format #fffff)
     *
     * @param c rgb-color
     * @return hex-color-string
     */
    private static String colorToString(Color c) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Integer.toHexString(c.getRGB() & 0xFFFFFF));
        while (buffer.length() < 6) {
            buffer.insert(0, '0');
        }
        buffer.insert(0, '#');
        return buffer.toString();
    }

    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void writeDocument(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartDocument();
        writer.writeDTD("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 20000802//EN\" "
                + "\"http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd\"");
        writer.writeStartElement("svg");
        writer.writeDefaultNamespace("http://w3.org/2000/svg");
        writer.writeAttribute("width", "" + getWidth());
        writer.writeAttribute("height", "" + getHeight());
        for (int i = 0; i < rects.size(); i++) {
            Color c = colors.get(i);
            Rectangle2D r = rects.get(i);
            writer.writeEmptyElement("rect");
            writer.writeAttribute("x", "" + r.getX());
            writer.writeAttribute("y", "" + r.getY());
            writer.writeAttribute("width", "" + r.getWidth());
            writer.writeAttribute("height", "" + getHeight());
            writer.writeAttribute("fill", colorToString(c));

        }

        writer.writeEndDocument();
    }
}

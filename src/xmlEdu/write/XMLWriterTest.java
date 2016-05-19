package xmlEdu.write;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Lama
 */
public class XMLWriterTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new XMLWriteFrame();
            frame.setTitle("XMLWriterTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

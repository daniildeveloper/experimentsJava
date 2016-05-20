package thread.applet;

import java.awt.Graphics;
import java.util.Date;

/**
 *
 * @author Lama
 */
public class Clock extends UpdateApplet {


    @Override
    public void paint(Graphics g) {
        g.drawString(new Date().toString(), 10, 25);
//        System.out.println(new Date().toString());
    }
}

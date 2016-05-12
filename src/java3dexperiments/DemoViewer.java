
package java3dexperiments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author Lama
 */
public class DemoViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        
        //slider to scroll horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);
        
        //slider to control vertical position
        JSlider pithSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pithSlider, BorderLayout.EAST);
        
        JPanel renderPanel;
        renderPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.BLUE);
                g2.fillRect(0, 0, getWidth(), getHeight());
                //rendering magic will be happen here
                //далее создаем тетраэдр. Для этого нужно всего 4 треугольника. Центр в начале координат. Треугольники добавляем в ArrayList
                List tris = new ArrayList<>();
                tris.add(new Triangle(new Vertex(100, 100, 100),
                        new Vertex(-100, -100, 100),
                        new Vertex(-100, 100, -100),
                        Color.white));
                tris.add(new Triangle(new Vertex(100, 100, 100),
                        new Vertex(-100, -100, 100),
                        new Vertex(100, -100, -100),
                        Color.RED));
                
                tris.add(new Triangle(new Vertex(-100, 100, -100),
                        new Vertex(100, -100, -100),
                        new Vertex(100, 100, 100),
                        Color.GREEN));
                
                tris.add(new Triangle(new Vertex(-100, 100, -100),
                        new Vertex(100, -100, -100),
                        new Vertex(-100, -100, 100),
                        Color.BLUE));
                
                //теперь добавим все то на экран
                g2.translate(getWidth()/2, getHeight()/2);
                g2.setColor(Color.white);
                Triangle t;
//                for( Object t : tris){
//                    Path2D path = new Path2D.Double();
//                    path.moveTo(t.v1.x, t.v1.y);
//                    path.lineTo(t.v2.x, t.v2.y);
//                    path.lineTo(t.v3.x, t.v3.y);
//                    path.closePath();
//                    g2.draw(path);
//                }
            }
        };
        
        pane.add(renderPanel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
        
        
    }

}

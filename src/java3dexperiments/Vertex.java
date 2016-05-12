
package java3dexperiments;

/**
 *Хранение наших координат.
 * @author Lama
 */
public class Vertex {
    /**
     * Координата x. Для перемещения вправо-влево
     */
    double x;
    
    /**
     * Координата у. Для перемещения вверх-вниз.
     */
    double y;
    
    /**
     * Координата z. Для перемещения вглубину - ближе или дальше от пользователя.
     */
    double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


}

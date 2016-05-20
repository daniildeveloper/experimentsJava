package thread.applet;

import java.applet.Applet;

/**
 * Прекращает свой поток когда апплет останавливается и воссоздает, когда
 * перезапускается.
 *
 *
 * start() и stop() - методы класса Applet
 *
 *
 * @author Lama
 */
public class UpdateApplet extends Applet implements Runnable {

    Thread thread;
    boolean running;
    int updateInternval = 1000;

    /**
     * Убеждаемся в отсутствии текущего исполняющего потока, проверяя метку
     * running и создаем ее для начала выполнения.
     */
    @Override
    public void run() {
        while (running) {
            repaint();
            try {
                Thread.sleep(updateInternval);
            } catch (InterruptedException e) {
                System.out.println("interrupted...");
                return;
            }
        }
    }

    @Override
    public void start() {
        System.out.println("Starting...");
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        System.out.println("stopping....");
        thread.interrupt();
        running = false;
    }


}

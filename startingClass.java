import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class startingClass extends Applet implements Runnable, KeyListener {

    // Initializes the application
    @Override
    public void init() {
        super.init();
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);

        Frame frame = (Frame)this.getParent().getParent();
        frame.setTitle("Insert Project Name Here");
    }

    // Starts the application by creating a thread. As long as the thread is running, the program will run
    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    // Stops the application by stopping the thread
    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void run() {
        while(true) {
            repaint();
            try {
                Thread.sleep(17);
            }
            catch (InterruptedException error) {
                System.out.println(error);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch(key.getKeyCode()) {
            case KeyEvent.VK_UP    : break;         // Player movement
            case KeyEvent.VK_DOWN  : break;         // Player movement
            case KeyEvent.VK_LEFT  : break;         // Player movement
            case KeyEvent.VK_RIGHT : break;         // Player movement
            case KeyEvent.VK_0     : break;         // Use item
            case KeyEvent.VK_1     : break;         // Toogle item
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        switch(key.getKeyCode()) {
            case KeyEvent.VK_UP    : break;         // Stop player movement
            case KeyEvent.VK_DOWN  : break;         // Stop player movement
            case KeyEvent.VK_LEFT  : break;         // Stop player movement
            case KeyEvent.VK_RIGHT : break;         // Stop player movement
            case KeyEvent.VK_0     : break;         // Stop using item
            case KeyEvent.VK_1     : break;         // Stop toggle item
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

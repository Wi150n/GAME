
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author BlakeAllen
 */
public class keyInput extends KeyAdapter {

    private boolean[] pressed = new boolean[4];
    private Handler handler;
    public float baseSpeed = (float) 5.0;

    public keyInput(Handler handler) {
        this.handler = handler;
        pressed[0] = false;
        pressed[1] = false;
        pressed[2] = false;
        pressed[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmp = handler.object.get(i);

            if (tmp.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    tmp.setSpeedY((int) (baseSpeed * -1));
                    pressed[0] = true;
                }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    tmp.setSpeedY((int) baseSpeed);
                    pressed[1] = true;
                }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    tmp.setSpeedX((int) (baseSpeed * -1));
                    pressed[2] = true;
                }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    tmp.setSpeedX((int) baseSpeed);
                    pressed[3] = true;
                }

            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmp = handler.object.get(i);

            if (tmp.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W){
                    pressed[0] = false;
                    //tmp.setSpeedY((0));
                }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    pressed[1] = false;
                    //tmp.setSpeedY((0));
                }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    //tmp.setSpeedX((0));
                    pressed[2] = false;
                }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    //tmp.setSpeedX((0));
                    pressed[3] = false;
                }
                if (!pressed[0] && !pressed[1]) {
                    tmp.setSpeedY(0);
                }
                if (!pressed[2] && !pressed[3]) {
                    tmp.setSpeedX(0);
                }
            }
        }
    }
}

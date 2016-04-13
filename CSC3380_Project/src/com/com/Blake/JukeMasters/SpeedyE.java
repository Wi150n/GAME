
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author BlakeAllen
 */
public class SpeedyE extends GameObject {

    private Handler handler;
    static int damage = 2;

    public SpeedyE(int x, int y, ID id, Handler handler, int Id) {
        super((int) x, (int) y, id, Id);
        this.handler = handler;
        speedX = 4;
        speedY = 4;

    }

    public void tick() {
        x += speedX;
        y += speedY;
        if (y <= 70 || y >= Game.HEIGHT - 47) {
            speedY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 26) {
            speedX *= -1;
        }

        x = Game.clamp((int) x, 0, Game.WIDTH - 26);
        y = Game.clamp((int) y, 70, Game.HEIGHT - 47);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 12, 12);
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 12, 12);
        g.setColor(Color.white);
        g.drawRect((int) x, (int) y, 12, 12);
    }
}

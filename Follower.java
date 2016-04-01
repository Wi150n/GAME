
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author BlakeAllen
 */
public class Follower extends GameObject {

    Handler handler;
    static int damage = 2;
    private GameObject player;
    float Xdiff, Ydiff,dis;
    float playerX;
    float playerY;

    public Follower(int x, int y, ID id, Handler handler, int Id) {
        super(x, y, id, Id);
        this.handler = handler;
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);
            }
        }
    }

    public void tick() {
        x += speedX;
        y += speedY;
        playerX = player.getX();
        playerY = player.getY();
		if(playerX > x && playerY == y){
		speedX = 1;
		}
		else if(playerX < x && playerY == y){
		speedX = -1;
		}
		else if(playerY > y && playerX == x){
		speedY = 1;
		}
		else if(playerY < y && playerX == x){
		speedY = -1;
		}
		if(playerY > y){
		speedY = 1;
		}
		if(playerY < y){
		speedY = -1;
		}
		if(playerX > x){
		speedX = 1;
		}
		if(playerX < x){
		speedX = -1;
		}
		if(playerX > x && playerY == y){
		speedX = 1;
		speedY = 0;
		}
		else if(playerX < x && playerY == y){
		speedX = -1;
		speedY = 0;
		}
		else if(playerY > y && playerX == x){
		speedY = 1;
		speedX = 0;
		}
		else if(playerY < y && playerX == x){
		speedY = -1;
		speedX = 0;
		}
		
        /*Xdiff = x - player.getX()- 8;
        Ydiff = y - player.getY() - 8;
        dis = (float) Math.sqrt(Math.pow(Xdiff,2) + Math.pow(Ydiff, 2));
        speedX = (float) ((-1.0 / dis) * Xdiff);
        speedY = (float) ((-1.0 / dis) * Ydiff);*/
        //x = Game.clamp((int) x, 0, Game.WIDTH - 26);
        //y = Game.clamp((int) y, 70, Game.HEIGHT - 47);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 12, 12);
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, 12, 12);
        g.setColor(Color.white);
        g.drawRect((int) x, (int) y, 12, 12);
    }
}

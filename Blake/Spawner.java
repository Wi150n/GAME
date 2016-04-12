import java.util.Random;

/**
 *
 * @author BlakeAllen
 */
public class Spawner {

    private Handler handler;
    private Hud hud;
    private int ScoreTmp = 1000;
    private Random rand = new Random();

    public Spawner(Handler handler, Hud hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        ScoreTmp++;
        if (ScoreTmp >= 250) {
            ScoreTmp = 0;
            hud.lvl(hud.getlvl() + 1);
            if (hud.getlvl()%4 == 0)
            	{
            	handler.add(new Follower(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.Follower, handler, handler.counter));
            	}
            if (hud.getlvl()%6 == 0) {
                handler.add(new Coin(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.Coin, handler, handler.counter));
                }
            
            if (hud.getlvl()%10 == 0) {
                handler.add(new Health(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.Health, handler, handler.counter));
                }
            if(hud.getlvl()%15 == 0){
            	handler.add(new Sheild(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.Sheild, handler, handler.counter));	
            }
            if (hud.getlvl()%2 == 0) {
                handler.add(new Enemy(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.Enemy, handler, handler.counter));
              }  
           
            if (hud.getlvl()%4 == 0) {
                handler.add(new SpeedyE(rand.nextInt(Game.WIDTH), rand.nextInt(Game.SPAWNABLE_AREA), ID.SpeedyE, handler, handler.counter));
            }    
            /* if (hud.getlvl() == 10) {
                handler.clearAll();
                handler.add(new Boss1((Game.WIDTH / 2) - 30, Game.HEIGHT / 2, ID.Boss1, handler, handler.counter));
            }
            if (hud.getlvl() > 10 && hud.getlvl() <= 15) {
                handler.add(new Enemy(rand.nextInt(Game.WIDTH), rand.nextInt(Game.HEIGHT), ID.Enemy, handler, handler.counter));
            }
            if (hud.getlvl() == 16) {
                handler.clearAll();
                handler.add(new Boss2((Game.WIDTH / 2) - 30, 70, ID.Boss2, handler, handler.counter));
            }*/
        }

    }
}

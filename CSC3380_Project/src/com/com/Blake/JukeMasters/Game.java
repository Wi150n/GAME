
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author BlakeAllen
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1020;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SPAWNABLE_AREA = HEIGHT-70;
    private Thread thread;
    private boolean working = false;
    private Handler handler= new Handler() ;
    private Random Rand= new Random();
    private Hud hud = new Hud();
    private Spawner spawn;
	int tickcounter = 0;
    public Game() {
        this.addKeyListener(new keyInput(handler));
        new Window(WIDTH, HEIGHT, "Gravity!", this);
        spawn = new Spawner(handler, hud);
        handler.add(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler, handler.counter));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        working = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            working = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 45.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (working) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (working) {
                render();
            }
            frames++;
          /*  if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS =>" + frames);
                //System.out.println(handler.object +" ,"+handler.counter);
                //System.out.println(Hud.HP);
                tickcounter = 0;
                frames = 0;
                
            }*/
        }
        stop();
    }

    private void tick() {
    	tickcounter++; 
      //  if(!paused){
        
        if(Hud.HP > 0 ){
        spawn.tick();
        handler.tick();
        hud.tick();
        }
        else{ 
        	handler.clearAll();
        	try{
        	thread.sleep(1000);
        	}
        	catch(Exception e){
        	System.out.println(e);
        	}
        	}
        
        //if(gameState == State.Game){
        //}else if(gameState == State.Menu){
        //menu.tick();
        //}
       // }
    }

    public void render() {
        BufferStrategy buff = this.getBufferStrategy();
        if (buff == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics gr = buff.getDrawGraphics();
        gr.setColor(Color.black);
        gr.fillRect(0, 0, WIDTH, HEIGHT);
        hud.render(gr);
        handler.render(gr);
        //if(gameState== State.Game){

        //}else if(gameState == State.Menu){
        //menu.render(gr);
        //}
        gr.dispose();
        buff.show();
    }

    public static float clamp(float x, float min, float max) {
        if (x >= max) {
            return x = max;
        } else if (x <= min) {
            return x = min;
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        //for(int i= 0; i< 5; i++){
        new Game();
        //}
    }
}

import java.applet.Applet;
import java.awt.*;

// The main program
public class game extends Applet implements Runnable, KeyListener {
	// The states of the game
	private boolean gameOver = false;
	private boolean gamePaused = false;

	// Keeps track of user input; up, down, left, right, use, and toggle
	private boolean[] pressed = new boolean[6];

	// Constructs the object
	public game() {
		init(); // Initializes the game
		// Some more stuff?
	}

	// Initializes the game, akin to opening the application
	@Override
	public void init() {
		super.init();
		setSize(800, 480);
		setBackground(Color.WHITE);
		setFocusable(true);

		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("CSC3380_PROJECT");
	}

	// Starts or restarts the game
	@Override
	public synchronized void start() {
		// Regen objects for start of game here
		Thread thread = new Thread() {
			@Override
			public void run() {
				run();
			}
		}
		thread.start();
	}

	// Maintains the game
	@Override
	private void run() {
		while(!gameOver) {
			if(!gamePaused) {
				update(); // updates the game
			}
			repaint(); // refreshs the display
			try {
				Thread.sleep(17); // Renders the game at 60fps
			}
			catch(InterruptedException error) {
				error.printStackTrace();
			}
		}
	}

	// Updates the game
	public void update() {
		// Something goes in here
	}

	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if(keyCode == KeyEvent.VK_UP) {
			pressed[0] = true;
			player.moveUp();
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			pressed[1] = true;
			player.moveDown();
		}
		if(keyCode == KeyEvent.VK_LEFT) {
			pressed[2] = true;
			player.moveLeft();
		}
		if(keyCode == KeyEvent.VK_RIGHT) {
			pressed[3] = true;
			player.moveRight();
		}
		if(keyCode == KeyEvent.VK_0) {
			pressed[4] = true;
			player.action();
		}
		if(keyCode == KeyEvent.VK_1) {
			pressed[5] = true;
			player.toggle();
		}
	}
}


// The following is the implementation of the class player
public class player {
	private int xPosition = 400;    // Player's x-position on the screen
	private int yPosition = 240;    // Player's y-position on the screen
	private double baseSpeed = 1.5; // Player's base speed
	private double xSpeed = 0;      // Player's x-component of their movement speed
	private double ySpeed = 0;      // Player's y-component of their movement speed
	private int health = 10;        // Player's health bar

	// Updates the player's position and movement
	public void updatePos() {

	}

	// Player's movement
	public void moveUp() {
		speedY = baseSpeed;
	}

	public void moveDown() {
		speedY = -1 * baseSpeed;
	}

	public void moveLeft() {
		speedX = baseSpeed;
	}

	public void moveRight() {
		speedX = -1 * baseSpeed;
	}

    public void moveUpLeft() {
        speedX = baseSpeed;
        speedY = baseSpeed;
    }

    public void moveUpRight() {
        speedX = -1 * baseSpeed;
        speedY = baseSpeed;
    }

    public void moveDownLeft() {
        speedX = baseSpeed;
        speedY = -1 * baseSpeed;
    }

    public void moveDownRight() {
        speedX = -1 * baseSpeed;
        speedY = -1 * baseSpeed;
    }

    // Player's action
    public void action() {
    	// Player will use item
    }

    public void toggle() {
    	// Player will toggle his items
    }
}

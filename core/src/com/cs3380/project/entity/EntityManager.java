package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;
import com.cs3380.project.screen.MenuScreen;
import com.cs3380.project.screen.ScreenManager;

public class EntityManager {
	
	private long startTime_Enemy;
	//private long startTime_Boss;
	private final Array<Entity> enemies = new Array<Entity>();
	private static final int MAX_ENEMY = 15;
	//private static final int MAX_BOSS = 1;
	private int enemyCounter;
	public final Player player;
	
	public EntityManager() {
		startTime_Enemy = TimeUtils.millis();
		//startTime_Boss = startTime_Enemy;
		player = new Player(new Vector2(510, 383), new Vector2(0, 0));
		addFollower();
		enemyCounter = 0;
	}
	
	// This continuously updates the objects' states
	public void update() {
		// Spawner for Enemy object; will spawn 15 in a set interval of ~5 seconds
		if(TimeUtils.timeSinceMillis(startTime_Enemy) > 5000 && enemyCounter <= MAX_ENEMY) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
			float speedX = MathUtils.random(-200, 200);
			float speedY = MathUtils.random(-200, 200);
			addEnemy(new Enemy(new Vector2(posX, posY), new Vector2(speedX, speedY)));
			startTime_Enemy = TimeUtils.millis();
		}
		
		for(Entity e : enemies) {
			if(e instanceof Follower) {
				((Follower) e).follow(player.getPosition());
				((Follower) e).setSpeed();
			}
			e.update();
		}
		
		player.update();
		checkCollisions();
		if(player.isDead()) {
			ScreenManager.setScreen(new MenuScreen());
		}
	}

	// This draws all the objects onto the screen
	public void render(SpriteBatch batch) {
		for(Entity e : enemies)
			e.render(batch);
		player.render(batch);
	}
	
	// Check for player-hostile_object collisions
	private void checkCollisions() {
		for(Enemy e : getEnemies()) {
			if((player.getBounds()).overlaps(e.getBounds())) {
				e.direction.rotate(180);
				player.dmgTaken(10);
			}
		}
		for(Follower f : getFollowers()) {
			if(player.getBounds().overlaps(f.getBounds())) {
				enemies.removeValue(f, false);
				player.dmgTaken(100);
			}
		}
	}
	
	// Add enemy
	public void addEnemy(Entity entity) {
		enemies.add(entity);
		enemyCounter++;
	}
	
	// Add follower
	public void addFollower() {
		float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
		float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
		float speedX = MathUtils.random(-200, 200);
		float speedY = MathUtils.random(-200, 200);
		enemies.add(new Follower(new Vector2(posX, posY), new Vector2(speedX, speedY)));
	}
	
	// Gets all the Enemy objects from the enemies array
	private Array<Enemy> getEnemies() {
		Array<Enemy> array = new Array<Enemy>();
		for(Entity e : enemies)
			if(e instanceof Enemy)
				array.add((Enemy) e);
		return array;
	}
	
	// Gets all the Follower objects from the enemies array
	private Array<Follower> getFollowers() {
		Array<Follower> array = new Array<Follower>();
		for(Entity e : enemies)
			if(e instanceof Follower)
				array.add((Follower) e);
		return array;
	}
	
}

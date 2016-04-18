package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class EntityManager {
	
	private long startTime;
	private final Array<Entity> enemies = new Array<Entity>();
	private static final int MAX_ENEMY = 15;
	private static final int MAX_FOLLOWER = 10;
	private int enemyCounter;
	private int followerCounter;
	private Vector2 playerPos;
	private boolean BOSS_SPAWNED = false;
	private final Player player;
	
	public EntityManager() {
		startTime = TimeUtils.millis();
		player = new Player(new Vector2(510, 383), new Vector2(0, 0));
		enemyCounter = 0;
		followerCounter = 0;
	}
	
	public void update() {
		if(TimeUtils.timeSinceMillis(startTime) > 3000 && enemyCounter <= MAX_ENEMY) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
			float speedX = MathUtils.random(-200, 200);
			float speedY = MathUtils.random(-200, 200);
			addEnemy(new Enemy(new Vector2(posX, posY), new Vector2(speedX, speedY)));
			startTime = TimeUtils.millis();
			enemyCounter++;
		}
		
		for(Entity e : enemies)
			e.update();
		
		player.update();
		checkCollisions();
	}

	public void render(SpriteBatch batch) {
		for(Entity e : enemies)
			e.render(batch);
		player.render(batch);
	}
	
	private void checkCollisions() {
		for(Enemy e : getEnemies()) {
			if((player.getBounds()).overlaps(e.getBounds())) {
				// Blake's work
			}
		}
	}
	
	public void addEnemy(Entity entity) {
		enemies.add(entity);
	}
	
	private Array<Enemy> getEnemies() {
		Array<Enemy> array = new Array<Enemy>();
		for(Entity e : enemies)
			if(e instanceof Enemy)
				array.add((Enemy) e);
		return array;
	}
	
	/*private Array<Follower> getFollowers() {
		Array<Enemy> array = new Array<Enemy>();
		for(Entity e : enemies)
			if(e instanceof Enemy)
				array.add((Enemy) e);
		return array;
	}*/
}

package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private final Array<Entity> entities = new Array<Entity>();
	private static final int MAX_ENEMY = 20;
	private static final int MAX_ENEMY_X = 10;
	private Vector2 playerPos; // continuosly update player pos in update, 
	private int spawned;
	// Timer
	private final Player player;
	
	public EntityManager() {
		player = new Player(new Vector2(510, 383), new Vector2(0, 0));
		for(int i = 0; i < amount; i++) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
			float speedX = MathUtils.random(-200, 200);
			float speedY = MathUtils.random(-200, 200);
			addEntity(new Enemy(new Vector2(posX, posY), new Vector2(speedX, speedY);
		}
	}
	
	public void update() {
		// if current timer % 50 => refer to line 19 to 23
		for(Entity e : entities)
			e.update();
		player.update();
	}

	public void render(SpriteBatch batch) {
		for(Entity e : entities)
			e.render(batch);
		player.render(batch);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
}

package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	
	public EntityManager(int amount) {
		player = new Player(new Vector2(510, 383), new Vector2(0, 0));
	}
	
	public void update() {
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

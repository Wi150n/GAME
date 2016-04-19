package com.cs3380.project.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Texture texture;
	protected Vector2 position;
	protected Vector2 direction;
	
	public Entity(Texture texture, Vector2 position, Vector2 direction) {
		this.texture = texture;
		this.position = position;
		this.direction = direction;
	}
	
	// Update the state of the object
	public abstract void update();
	
	// Draw the object on the screen
	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);
	}
	
	// Returns the position of the Entity
	public Vector2 getPosition() {
		return position;
	}
	
	// Boundary of the Entity itself
	public Rectangle getBounds() {
		return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
	}
	
	// Set direction of movement
	public void setDirection(float x, float y) {
		direction.set(x, y);
		direction.scl(Gdx.graphics.getDeltaTime());
	}
	
	// Boundary condition of all Entity object; prevents them from leaving the screen
	public boolean clamp(float minX, float minY, float maxX, float maxY) {
		boolean bool = true;
		if(position.x >= maxX && position.y >= maxY) {
			position.set(maxX, maxY);
		}
		else if(position.x <= minX && position.y <= minY) {
			position.set(minX, minY);
		}
		else if(position.x <= minX && position.y >= maxY) {
			position.set(minX, maxY);
		}
		else if(position.x >= maxX && position.y <= minY) {
			position.set(maxX, minY);
		}
		else if(position.x >= maxX) {
			position.set(maxX, position.y);
		}
		else if(position.x <= minX) {
			position.set(minX, position.y);
		}
		else if(position.y >= maxY) {
			position.set(position.x, maxY);
		}
		else if(position.y <= minY) {
			position.set(position.x, minY);
		}
		else {
			bool = false;
		}
		return bool;
	}
	
}

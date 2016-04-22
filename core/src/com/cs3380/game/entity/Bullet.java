package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.TextureManager;

public class Bullet extends Entity {
	
	public Bullet(Vector2 position) {
		super(TextureManager.BULLET, position, new Vector2(0, -2));
	}

	@Override
	public void update() {
		position.add(direction);
	}
	
	// Return true if bullet is off screen
	public boolean isOffScreen() {
	  return position.y <= 0;
	}

}

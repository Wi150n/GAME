package com.cs3380.project.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class Bullet extends Entity {
	
	public Bullet(Vector2 pos) {
		super(TextureManager.BULLET, pos, new Vector2(0, 2));
	}

	@Override
	public void update() {
		position.add(direction);
	}
	
	// Return true if bullet is off screen
	public boolean isOffScreen() {
	  return pos.y <= 0;
	}
	
}

package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.MainGame;
import com.cs3380.game.TextureManager;

public class Enemy extends Entity {
	
	public Enemy(Vector2 position, Vector2 direction) {
		super(TextureManager.ENEMY, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
		bounceOff();
	}
	
	// Makes Enemy bounce off the edge of the screen
	public void bounceOff() {
		if(clamp(0, 0, MainGame.WIDTH - TextureManager.ENEMY.getWidth(), MainGame.HEIGHT - TextureManager.ENEMY.getHeight()) && (position.x <= 0 || position.x >= MainGame.WIDTH - TextureManager.ENEMY.getWidth()))
			setDirection(-1*direction.x, direction.y);
		else if(clamp(0, 0, MainGame.WIDTH - TextureManager.ENEMY.getWidth(), MainGame.HEIGHT - TextureManager.ENEMY.getHeight()) && (position.y <= 0 || position.y >= MainGame.HEIGHT - TextureManager.ENEMY.getHeight()))
			setDirection(direction.x, -1*direction.y);
		direction.setLength(4);
	}
	
}

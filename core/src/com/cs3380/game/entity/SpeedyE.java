package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.MainGame;
import com.cs3380.game.TextureManager;

public class SpeedyE extends Entity {

	public SpeedyE(Vector2 position, Vector2 direction) {
		super(TextureManager.SPEEDY, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
		bounceOff();
	}
	
	// Same as enemy
	public void bounceOff() {
		if(clamp(0, 0, MainGame.WIDTH - TextureManager.SPEEDY.getWidth(), MainGame.HEIGHT - TextureManager.SPEEDY.getHeight()) && (position.x <= 0 || position.x >= MainGame.WIDTH - TextureManager.SPEEDY.getWidth()))
			setDirection(-1*direction.x, direction.y);
		else if(clamp(0, 0, MainGame.WIDTH - TextureManager.SPEEDY.getWidth(), MainGame.HEIGHT - TextureManager.SPEEDY.getHeight()) && (position.y <= 0 || position.y >= MainGame.HEIGHT - TextureManager.SPEEDY.getHeight()))
			setDirection(direction.x, -1*direction.y);
		direction.setLength(6);
	}
	
}

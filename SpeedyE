package com.cs3380.project.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class SpeedyE extends Entity {
	
	public SpeedyE(Vector2 pos, Vector2 dir) {
		super(TextureManager.SPEEDY, pos, dir);
	}

	@Override
	public void update() {
		position.add(direction);
		bounceOff();
	}
	
	// Same as enemy
	public void bounceOff() {
		if(clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30) && (position.x <= 0 || position.x >= MainGame.WIDTH -30))
			setDirection(-1*direction.x, direction.y);
		else if(clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30) && (position.y <= 0 || position.y >= MainGame.HEIGHT -30))
			setDirection(direction.x, -1*direction.y);
		direction.setLength(6);
	}
	
}

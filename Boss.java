package com.cs3380.project.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class Boss extends Entity {
	
	private int buffRate;
	private float startTime;
	private final EntityManager entityManager;
	
	public Boss(int bufferRate, EntityManager entityManager) {
		super(TextureManager.BOSS, new Vector2(MainGame.WIDTH/2 , MainGame.HEIGHT - TextureManager.BOSS.getHeight() - Hud distance, new Vector2(300, 0);
		this.bufferRate = bufferRate;
		this.entityManager = entityManager;
		startTime = TimeUtils.millis();
	}

	@Override
	public void update() {
		position.add(direction);
		bounceOff();
		if(((int)TimeUtils.timeSinceMillis(startTime))/1000 >= bufferRate)
			entityManager.addBullet(new Bullet(pos.cpy().add(TextureManager.BOSS.getWidth()/2, 0));
	}
	
	// Same as enemy
	public void bounceOff() {
		if(clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30) && (position.x <= 0 || position.x >= MainGame.WIDTH -30))
			setDirection(-1*direction.x, direction.y);
		else if(clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30) && (position.y <= 0 || position.y >= MainGame.HEIGHT -30))
			setDirection(direction.x, -1*direction.y);
		direction.setLength(5);
	}
	
}

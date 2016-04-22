package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.cs3380.game.MainGame;
import com.cs3380.game.TextureManager;

public class Boss extends Entity {
	
	private int bufferRate;
	private long startTime;
	private final EntityManager entityManager;

	public Boss(int bufferRate, EntityManager entityManager) {
		super(TextureManager.BOSS, new Vector2(MainGame.WIDTH/2, MainGame.HEIGHT - TextureManager.BOSS.getHeight()), new Vector2(300, 0));
		this.bufferRate = bufferRate;
		this.entityManager = entityManager;
		startTime = TimeUtils.millis();
	}

	@Override
	public void update() {
		position.add(direction);
		bounceOff();
		if(TimeUtils.timeSinceMillis(startTime) >= bufferRate*1000) {
			entityManager.addBullet(new Bullet(position.cpy().add(TextureManager.BOSS.getWidth()/2, 0)));
			startTime = TimeUtils.millis();
		}
	}
	
	// Same as enemy
	public void bounceOff() {
		if(clamp(0, 0, MainGame.WIDTH - TextureManager.BOSS.getWidth(), MainGame.HEIGHT - TextureManager.BOSS.getHeight()) && (position.x <= 0 || position.x >= MainGame.WIDTH - TextureManager.BOSS.getWidth()))
			setDirection(-1*direction.x, direction.y);
		else if(clamp(0, 0, MainGame.WIDTH - TextureManager.BOSS.getWidth(), MainGame.HEIGHT - TextureManager.BOSS.getHeight()) && (position.y <= 0 || position.y >= MainGame.HEIGHT - TextureManager.BOSS.getHeight()))
			setDirection(direction.x, -1*direction.y);
		direction.setLength(5);
	}

}

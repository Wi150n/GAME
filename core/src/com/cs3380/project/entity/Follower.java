package com.cs3380.project.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.cs3380.project.TextureManager;

public class Follower extends Entity {
	
	private long startTime;
	private float speed;
	private final static float MAX_SPEED = 5;
	
	public Follower(Vector2 pos, Vector2 dir) {
		super(TextureManager.FOLLOWER, pos , dir);
		startTime = TimeUtils.millis();
		speed = 1;
	}

	@Override
	public void update() {
		position.add(direction);
		setSpeed();
	}
	
	// The main movement of the follower; will follow the player
	public void follow(Vector2 pos) {
		setDirection(pos.x - position.x, pos.y - position.y);
		direction.setLength(speed);
	}
	
	public void setSpeed() {
		if(TimeUtils.timeSinceMillis(startTime) > 15000 && speed <= MAX_SPEED) {
			speed += 0.5;
			startTime = TimeUtils.millis();
		}
	}
	
}

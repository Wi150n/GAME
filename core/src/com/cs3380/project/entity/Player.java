package com.cs3380.project.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class Player extends Entity {
	
	private int HP;
	private String state;
	
	public Player(Vector2 position, Vector2 direction) {
		super(TextureManager.PLAYER, position, direction);
		HP = 1000;
		state = "alive";
	}

	@Override
	public void update() {
		position.add(direction);
		clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30);
	}
	
	// This method is for the touchpad interface
	public void setDirectionX(float x) {
		direction.x = x;
	}
	
	// This method is for the touchpad interface
	public void setDirectionY(float y) {
		direction.y = y;
	}
	
	// Keeps track of the damage taken
	public void dmgTaken(int dmg) {
		HP -= dmg;
		if(HP <= 0)
			state = "dead";
	}
	
	// Checks if player is dead
	public boolean isDead() {
		if(state.equals("dead"))
			return true;
		else
			return false;
	}

}

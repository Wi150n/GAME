package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.MainGame;
import com.cs3380.game.TextureManager;

public class Player extends Entity {
	
	private int HP;
	private int shield;
	private int score;
	private String state;
	
	public Player() {
		super(TextureManager.PLAYER, new Vector2(MainGame.WIDTH/2, MainGame.HEIGHT/2), new Vector2(0, 0));
		HP = 1000;
		state = "alive";
	}

	@Override
	public void update() {
		position.add(direction);
		clamp(0, 0, MainGame.WIDTH - TextureManager.PLAYER.getWidth(), MainGame.HEIGHT - TextureManager.PLAYER.getHeight());
	}
	
	// This method is for the touchpad interface
	public void setDirectionX(float x) {
		direction.x = x;
	}
	
	// This method is for the touchpad interface
	public void setDirectionY(float y) {
		direction.y = y;
	}
	
	// Returns the player's HP
	public Integer getHP() {
		return HP;
	}
	
	// Returns the player's shield
	public Integer getShield() {
		return shield;
	}
	
	// Returns the player's score
	public Integer getScore() {
		return score;
	}
	
	// Keeps track of the damage taken
	public void dmgTaken(int dmg) {
		HP -= dmg;
		if(HP <= 0)
			state = "dead";
	}
	
	// Heals the player's HP
	public void heal(int heal) {
		HP += heal;
		if(HP > 1000)
			HP = 1000;
	}
	
	// Keeps track of the player's shield
	public void shield(int shield) {
		this.shield = this.shield + shield;
		if(this.shield > 1000)
			this.shield = 1000;
	}
	
	// Keeps track of the player's score
	public void score(int score) {
		this.score = this.score + score;
	}
	
	// Checks if player is dead
	public boolean isDead() {
		if(state.equals("dead"))
			return true;
		else
			return false;
	}

}

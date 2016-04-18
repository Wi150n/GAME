package com.cs3380.project.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.MainGame;
import com.cs3380.project.TextureManager;

public class Player extends Entity{
	
	public Player(Vector2 position, Vector2 direction) {
		super(TextureManager.PLAYER, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
		clamp(0, 0, MainGame.WIDTH - 30, MainGame.HEIGHT - 30);
		
		// Player movement based on user input
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Keys.DPAD_UP))
			setDirection(-252, 252);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			setDirection(-252, -252);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Keys.DPAD_UP))
			setDirection(252, 252);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			setDirection(252, -252);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			setDirection(-300, 0);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			setDirection(300, 0);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			setDirection(0, 300);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			setDirection(0, -300);
		else
			setDirection(0, 0);
	}

}

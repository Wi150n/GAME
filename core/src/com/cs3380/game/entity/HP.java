package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.TextureManager;

public class HP extends Entity {

	public HP(Vector2 position) {
		super(TextureManager.HP, position, new Vector2(0, 0));
	}

	@Override
	public void update() {
		
	}

}

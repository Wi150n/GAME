package com.cs3380.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.cs3380.game.TextureManager;

public class Coin extends Entity {

	public Coin(Vector2 position) {
		super(TextureManager.COIN, position, new Vector2(0, 0));
	}

	@Override
	public void update() {
		
	}

}

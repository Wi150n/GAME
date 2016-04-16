package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity {

	public Enemy(Texture texture, Vector2 position, Vector2 direction) {
		super(texture, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
	}
	

}

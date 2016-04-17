package com.cs3380.project.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.TextureManager;

public class EnemyX extends Entity {

	public EnemyX(Vector2 position, Vector2 direction) {
		super(TextureManager.ENEMY_X, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
	}
	

}

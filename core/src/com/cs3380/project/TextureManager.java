package com.cs3380.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
	
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	
	public static Texture FOLLOWER = new Texture(Gdx.files.internal("follower.png"));
	
	//public static Texture BOSS = new Texture(Gdx.files.internal("boss.png"));
	
}
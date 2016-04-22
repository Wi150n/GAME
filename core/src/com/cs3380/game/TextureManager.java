package com.cs3380.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
	
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	
	public static Texture FOLLOWER = new Texture(Gdx.files.internal("follower.png"));
	
	public static Texture SPEEDY = new Texture(Gdx.files.internal("speedyE.png"));
	
	public static Texture BOSS = new Texture(Gdx.files.internal("boss.png"));
	
	public static Texture BULLET = new Texture(Gdx.files.internal("bullet.png"));
	
	public static Texture HP = new Texture(Gdx.files.internal("health.png"));
	
	public static Texture SHIELD = new Texture(Gdx.files.internal("shield.png"));
	
	public static Texture COIN = new Texture(Gdx.files.internal("coin.png"));
}

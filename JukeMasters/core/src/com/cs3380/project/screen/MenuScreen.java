package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.camera.OrthoCamera;

public class MenuScreen extends Screen{

	private OrthoCamera camera; // Need?
	Skin skin; // Edited; Github
	Stage stage; // Edited; Github
	
	@Override
	public void create() {
		camera  = new OrthoCamera(); // Need?
		skin = new Skin(Gdx.files.internal("ui.json");
		stage = new Stage()
		
	}
	
	@Override
	public void update() {
		camera.update();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		// render some stuff here
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	

}

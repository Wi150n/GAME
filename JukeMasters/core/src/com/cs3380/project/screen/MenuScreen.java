package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2; // this is a tester
import com.cs3380.project.camera.OrthoCamera;
import com.cs3380.project.entity.Player; // this is a tester

public class MenuScreen extends Screen{

	private OrthoCamera camera;
	
	@Override
	public void create() {
		camera  = new OrthoCamera();
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

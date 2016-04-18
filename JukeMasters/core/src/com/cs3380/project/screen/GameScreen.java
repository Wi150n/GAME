package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs3380.project.camera.OrthoCamera;
import com.cs3380.project.entity.EntityManager;

public class GameScreen extends Screen {

	private OrthoCamera camera;
	private EntityManager entityManager;
		
	@Override
	public void create() {
		camera  = new OrthoCamera();
		camera.resize();
		entityManager = new EntityManager();
	}
		
	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}
		
	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		// render some stuff here
		entityManager.render(batch);
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

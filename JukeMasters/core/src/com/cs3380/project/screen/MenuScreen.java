package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.cs3380.project.camera.OrthoCamera;

public class MenuScreen extends Screen{

	private OrthoCamera camera;
	Skin skin; // Edited; Github
	Stage stage; // Edited; Github
	
	@Override
	public void create() {
		camera  = new OrthoCamera();
		skin = new Skin(Gdx.files.internal("ui.json");
		stage = new Stage(new ScreenViewport());
		
		final TextButton button = new TextButton("PLAY", skin, "default");
		button.setWidth(200);
		button.setHeight(50);
		button.addListener(new ClickListener() {
			 @Override
			 public void clicked(InputEvent event, float x, float y) {
			 	ScreenManager.set
			 }
		});
		
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void update() {
		camera.update();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		//batch.setProjectionMatrix(camera.combined);
		//batch.begin();
		// render some stuff here
		//batch.end();
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

package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch; // I dont think we need this here...
import com.badlogic.gdx.math.Vector2; // I dont think we need this here...
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
		
		// The PLAY button, which starts the game when pressed
		final TextButton playButton = new TextButton("PLAY", skin, "default");
		playButton.setWidth(200);
		playButton.setHeight(50);
		playButton.addListener(new ClickListener() {
			 @Override
			 public void clicked(InputEvent event, float x, float y) {
			 	ScreenManager.setScreen(new GameScreen);
			 }
		});
		
		stage.addActor(playButton);
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

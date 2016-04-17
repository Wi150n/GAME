package com.cs3380.project.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs3380.project.camera.OrthoCamera; // Don't need? Need to add more classes

public class MenuScreen extends Screen implements InputProcessor {

	private OrthoCamera camera; // Don't need?
	private Skin skin;
	private Stage stage;
	private Table table;
	private TextButton playButton;
	private TextButton instrButton;
	private SpriteBatch batch;
	
	@Override
	public void create() {
		camera  = new OrthoCamera(); // Don't need?
		skin = new Skin(Gdx.files.internal("ui.json");
		stage = new Stage(new ScreenViewport());
		
		// The canvas for the buttons
		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center | Align.bottom);
		table.setPosition(0, Gdx.graphics.getHeight());
		
		// The buttons: PLAY, INSTR
		playButton = new TextButton("PLAY", skin);
		instrButton = new TextButton("INSTR", skin);
		
		table.padTop(30);
		table.add(playButton).padBottom(30);
		table.row();
		table.add(instrButton);
		
		stage.addActor(table);
		
		batch = new SpriteBatch();
		sprite = TextureManager.MENU_BACKGROUND;
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void update() {
		camera.update();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
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

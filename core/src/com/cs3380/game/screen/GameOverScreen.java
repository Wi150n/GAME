package com.cs3380.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs3380.game.camera.OrthoCamera;

public class GameOverScreen extends Screen implements InputProcessor {

	private OrthoCamera camera;
	
	private Skin buttonSkin;
	private Stage stage;
	private Table table;

	private TextButton againButton;
	private TextButton menuButton;

	@Override
	public void create() {
		camera  = new OrthoCamera();
		camera.resize();
		buttonSkin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());

		// The canvas for the buttons
		table = new Table();
		table.center();
		table.setFillParent(true);

		// The buttons: PLAY, INSTR
		againButton = new TextButton("PLAY AGAIN?", buttonSkin);	
		menuButton = new TextButton("BACK TO MAIN MENU", buttonSkin);
		
		againButton.getLabel().setFontScale(4, 4);
		menuButton.getLabel().setFontScale(4, 4);

		againButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.setScreen(new GameScreen());
			}
		});

		menuButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.setScreen(new MenuScreen());
			}
		});

		table.padTop(30);
		table.add(againButton).padBottom(30);
		table.row();
		table.add(menuButton);

		stage.addActor(table);

		InputMultiplexer input = new InputMultiplexer(stage, this);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void update() {
		camera.update();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}

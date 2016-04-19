package com.cs3380.project.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs3380.project.camera.OrthoCamera;
import com.cs3380.project.entity.EntityManager;

public class GameScreen extends Screen {

	private OrthoCamera camera;
	private Stage stage;
	private Touchpad touchpad;
	private TouchpadStyle touchpadStyle;
	private Skin touchpadSkin;
	private Drawable touchBackground;
	private Drawable touchKnob;
	private EntityManager entityManager;
		
	@Override
	public void create() {
		camera  = new OrthoCamera();
		camera.resize();
		
		// Create touchpad interface
		touchpadSkin = new Skin();
		touchpadSkin.add("touchBackground", new Texture(Gdx.files.internal("touchBackground.png")));
		touchpadSkin.add("touchKnob", new Texture(Gdx.files.internal("touchKnob.png")));
		touchpadStyle = new TouchpadStyle();
		touchBackground = touchpadSkin.getDrawable("touchBackground");
		touchKnob = touchpadSkin.getDrawable("touchKnob");
		touchpadStyle.background = touchBackground;
		touchpadStyle.knob = touchKnob;
		touchpad = new Touchpad(10, touchpadStyle);
		touchpad.setBounds(15, 15, 200, 200);
		
		// Set the stage for the touchpad
		stage = new Stage(new ScreenViewport());
		stage.addActor(touchpad);
		Gdx.input.setInputProcessor(stage);
		
		
		entityManager = new EntityManager();
	}
		
	@Override
	public void update() {
		camera.update();
		entityManager.player.setDirectionX(5*touchpad.getKnobPercentX());
		entityManager.player.setDirectionY(5*touchpad.getKnobPercentY());
		entityManager.update();
	}
		
	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.begin();
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

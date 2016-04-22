package com.cs3380.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs3380.game.camera.OrthoCamera;
import com.cs3380.game.entity.EntityManager;

public class GameScreen extends Screen {

	private OrthoCamera camera;
	private Skin skin;
	private Stage stage;
	
	private long startTime = TimeUtils.millis();
	private Integer score = 0;
	private Integer timeSec = 0, timeMin = 0;
	private Integer HP = 1000, Shield = 0;
	
	Table HUD;
	Label timeLabel;
	Label scoreLabel;
	Label HPLabel;
	Label ShieldLabel;
	
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
		touchpad.setBounds(50, 50, 300, 300);
		
		// Create HUD interface
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		HUD = new Table();
		HUD.top();
		HUD.setFillParent(true);
		
		timeLabel = new Label("Time: " + String.format("%02d", timeMin) + ":" + String.format("%02d", timeSec), skin);
		scoreLabel = new Label("Score: " + String.format("%06d", score), skin);
		HPLabel = new Label("HP: " + String.format("%04d", HP), skin);
		ShieldLabel = new Label("Shield: " + String.format("%04d", Shield), skin);
		
		timeLabel.setFontScale(3);
		scoreLabel.setFontScale(3);
		HPLabel.setFontScale(3);
		ShieldLabel.setFontScale(3);
		
		
		HUD.add(HPLabel).expandX().padTop(10);
		HUD.add(ShieldLabel).expandX().padTop(10);
		HUD.add(timeLabel).expandX().padTop(10);
		HUD.add(scoreLabel).expandX().padTop(10);
		
		// Set the stage for the touchpad and HUD
		stage = new Stage(new ScreenViewport());
		stage.addActor(touchpad);
		stage.addActor(HUD);
		Gdx.input.setInputProcessor(stage);
		
		entityManager = new EntityManager();
	}
		
	@Override
	public void update() {
		camera.update();
		entityManager.player.setDirectionX(5*touchpad.getKnobPercentX());
		entityManager.player.setDirectionY(5*touchpad.getKnobPercentY());
		entityManager.update();
		
		// Update HUD
		HP = entityManager.player.getHP();
		Shield = entityManager.player.getShield();
		score = entityManager.player.getScore();
		if((int)TimeUtils.timeSinceMillis(startTime) / 1000 >= 1) {
			timeSec++;
			startTime = TimeUtils.millis();
		}
		if(timeSec == 60) {
			timeSec = 0;
			timeMin++;
		}
		timeLabel.setText("Time: " + String.format("%02d", timeMin) + ":" + String.format("%02d", timeSec));
		scoreLabel.setText("Score: " + String.format("%06d", score));
		HPLabel.setText("HP: " + String.format("%04d", HP));
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

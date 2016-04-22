package com.cs3380.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.cs3380.game.MainGame;
import com.cs3380.game.TextureManager;
import com.cs3380.game.screen.GameOverScreen;
import com.cs3380.game.screen.ScreenManager;

public class EntityManager {
	
	private long startTime_Enemy, startTime_Speedy, startTime_Boss;
	private long startTime_HP, startTime_Shield, startTime_Coin;
	private final Array<Entity> enemies;
	private final Array<Entity> others;
	private static final int MAX_ENEMY = 15;
	private static final int MAX_SPEEDY = 5;
	private static final int MAX_BUFFER_RATE = 1;
	private boolean isBossSpawned = false;
	private int enemyCounter;
	private int speedyCounter;
	private int bufferRate;
	public final Player player;
	
	public EntityManager() {
		startTime_Enemy = TimeUtils.millis();
		startTime_Speedy = startTime_Enemy;
		startTime_Boss = startTime_Enemy;
		startTime_HP = startTime_Enemy;
		startTime_Shield = startTime_Enemy;
		startTime_Coin = startTime_Enemy;
		enemies = new Array<Entity>();
		others = new Array<Entity>();
		enemyCounter = 0;
		speedyCounter = 0;
		bufferRate = 3;
		player = new Player();
		addFollower();
	}
	
	// This continuously updates the objects' states
	public void update() {
		
		/* SPAWNER FOR HOSTILE OBJECTS: ENEMY, SPEEDYE, FOLLOWER, BOSS */
		/* =========================================================== */
		
		if(!isBossSpawned) {
			// Spawner for Enemy object; will spawn 15 in a set interval of ~10 seconds
			if(TimeUtils.timeSinceMillis(startTime_Enemy) > 5000 && enemyCounter <= MAX_ENEMY) {
				float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
				float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
				float speedX = MathUtils.random(-200, 200);
				float speedY = MathUtils.random(-200, 200);
				addEnemy(new Enemy(new Vector2(posX, posY), new Vector2(speedX, speedY).setLength(4)));
				startTime_Enemy = TimeUtils.millis();
			}
		
			// Spawner for SpeedyE object; will spawn 5 in a set interval of ~20 seconds
			if(TimeUtils.timeSinceMillis(startTime_Speedy) > 20000 && speedyCounter <= MAX_SPEEDY) {
				float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.SPEEDY.getWidth());
				float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.SPEEDY.getHeight());
				float speedX = MathUtils.random(-200, 200);
				float speedY = MathUtils.random(-200, 200);
				addSpeedy(new SpeedyE(new Vector2(posX, posY), new Vector2(speedX, speedY).setLength(6)));
				startTime_Speedy = TimeUtils.millis();
			}
			
			// Spawns the Boss object once every 5 minute interval
			if(TimeUtils.timeSinceMillis(startTime_Boss) > 300000) {
				enemies.clear();
				enemies.add(new Boss(bufferRate, this));
				if(bufferRate >= MAX_BUFFER_RATE)
					bufferRate--;
				isBossSpawned = true;
				startTime_Boss = TimeUtils.millis();
			}
		}
		else {
			if(TimeUtils.timeSinceMillis(startTime_Boss) > 60000) {
				enemies.clear();
				isBossSpawned = false;
				startTime_Boss = TimeUtils.millis();
			}
		}
		
		/* SPAWNER FOR MISCELLANEOUS OBJECTS: HP, SHIELD, COIN */
		/* =================================================== */
		
		// Spawner for HP object; will spawn in a set interval of 2 minutes
		if(TimeUtils.timeSinceMillis(startTime_HP) > 120000) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.HP.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.HP.getHeight());
			addMiscellaneous(new HP(new Vector2(posX, posY)));
			startTime_HP = TimeUtils.millis();
		}
		
		// Spawner for Shield object; will spawn in a set interval of 3 minutes
		if(TimeUtils.timeSinceMillis(startTime_Shield) > 180000) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.SHIELD.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.SHIELD.getHeight());
			addMiscellaneous(new Shield(new Vector2(posX, posY)));
			startTime_Shield = TimeUtils.millis();
		}
		
		// Spawner for Coin object; will spawn in a set interval of 5 seconds
		if(TimeUtils.timeSinceMillis(startTime_Coin) > 5000) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.COIN.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.COIN.getHeight());
			addMiscellaneous(new Coin(new Vector2(posX, posY)));
			startTime_Coin = TimeUtils.millis();
		}
		
		for(Entity e : enemies) {
			if(e instanceof Follower) {
				((Follower) e).follow(player.getPosition());
				((Follower) e).setSpeed();
			}
			e.update();
		}
		
		player.update();
		checkCollisions();
		
		if(player.isDead())
			ScreenManager.setScreen(new GameOverScreen());
	}

	// This draws all the objects onto the screen
	public void render(SpriteBatch batch) {
		for(Entity e : enemies)
			e.render(batch);
		for(Entity o : others)
			o.render(batch);
		player.render(batch);
	}
	
	// Check for player-hostile_object collisions
	private void checkCollisions() {
		for(Enemy e : getEnemies()) {
			if((player.getBounds()).overlaps(e.getBounds())) {
				e.direction.rotate(180);
				player.dmgTaken(10);
			}
		}
		
		for(Follower f : getFollowers()) {
			if(player.getBounds().overlaps(f.getBounds())) {
				enemies.removeValue(f, false);
				player.dmgTaken(100);
				addFollower();
			}
		}
		
		for(SpeedyE s : getSpeedyE()) {
			if(player.getBounds().overlaps(s.getBounds())) {
				s.direction.rotate(180);
				player.dmgTaken(200);
			}
		}
		
		for(Bullet b : getBullets()) {
			if(player.getBounds().overlaps(b.getBounds())) {
				enemies.removeValue(b, false);
				player.dmgTaken(5);
			}
		}
		
		if(isBossSpawned) {
			if(player.getBounds().overlaps(getBoss().getBounds()))
				player.dmgTaken(250);
		}
		
		for(HP hp : getHP()) {
			if(player.getBounds().overlaps(hp.getBounds())) {
				others.removeValue(hp, false);
				player.heal(500);
			}
		}
		
		for(Shield shield : getShields()) {
			if(player.getBounds().overlaps(shield.getBounds())) {
				others.removeValue(shield, false);
				player.shield(500);
			}
		}
		
		for(Coin coin : getCoins()) {
			if(player.getBounds().overlaps(coin.getBounds())) {
				others.removeValue(coin, false);
				player.score(1000);
			}
		}
	}
	
	// Add enemy
	public void addEnemy(Entity entity) {
		enemies.add(entity);
		enemyCounter++;
	}
	
	// Add follower
	public void addFollower() {
		float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
		float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
		float speedX = MathUtils.random(-200, 200);
		float speedY = MathUtils.random(-200, 200);
		enemies.add(new Follower(new Vector2(posX, posY), new Vector2(speedX, speedY)));
	}
	
	// Add speedy enemy
	public void addSpeedy(Entity entity) {
		enemies.add(entity);
		speedyCounter++;
	}
	
	// Add bullet
	public void addBullet(Entity entity) {
		enemies.add(entity);
	}
	
	// Add miscellaneous objects (HP, Shield, Coin)
	public void addMiscellaneous(Entity entity) {
		others.add(entity);
	}
	
	// Gets all the Enemy objects from the enemies array
	private Array<Enemy> getEnemies() {
		Array<Enemy> array = new Array<Enemy>();
		for(Entity e : enemies)
			if(e instanceof Enemy)
				array.add((Enemy) e);
		return array;
	}
	
	// Gets all the Follower objects from the enemies array
	private Array<Follower> getFollowers() {
		Array<Follower> array = new Array<Follower>();
		for(Entity e : enemies)
			if(e instanceof Follower)
				array.add((Follower) e);
		return array;
	}
	
	// Gets all the SpeedyE objects from the enemies array
	private Array<SpeedyE> getSpeedyE() {
		Array<SpeedyE> array = new Array<SpeedyE>();
		for(Entity e : enemies)
			if(e instanceof SpeedyE)
				array.add((SpeedyE) e);
		return array;
	}
	
	// Gets all the Bullet objects from the enemies array
	private Array<Bullet> getBullets() {
		Array<Bullet> array = new Array<Bullet>();
		for(Entity e : enemies)
			if(e instanceof Bullet)
				array.add((Bullet) e);
		return array;
	}
	
	// Gets the Boss object from the enemies array
	private Boss getBoss() {
		Boss boss = null;
		for(Entity e : enemies)
			if(e instanceof Boss)
				boss = (Boss) e;
		return boss;
	}
	
	// Gets all the HP objects from the others array
	private Array<HP> getHP() {
		Array<HP> array = new Array<HP>();
		for(Entity e : others)
			if(e instanceof HP)
				array.add((HP) e);
		return array;
	}
	
	// Gets all the Shield objects from the others array
	private Array<Shield> getShields() {
		Array<Shield> array = new Array<Shield>();
		for(Entity e : others)
			if(e instanceof Shield)
				array.add((Shield) e);
		return array;
	} 
	
	// Gets all the Coin objects from the others array
	private Array<Coin> getCoins() {
		Array<Coin> array = new Array<Coin>();
		for(Entity e : others)
			if(e instanceof Coin)
				array.add((Coin) e);
		return array;
	}
		
}

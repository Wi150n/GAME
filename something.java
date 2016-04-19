// Spawner for Follower object; will spawn 15 in a set interval of ~10 seconds
		if(TimeUtils.timeSinceMillis(startTime_Follower) > 25000 && followerCounter <= MAX_FOLLOWER) {
			float posX = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float posY = MathUtils.random(0, MainGame.HEIGHT - TextureManager.ENEMY.getHeight());
			float speedX = MathUtils.random(-200, 200);
			float speedY = MathUtils.random(-200, 200);
			addFollower(new Follower(new Vector2(posX, posY), new Vector2(speedX, speedY)));
			startTime_Follower = TimeUtils.millis();
		}

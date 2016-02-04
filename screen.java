package com.CSC3380_Project.framework;

// The screen class
public abstract class screen {
  protected final Game game;

  public screen(Game game) {
    this.game = game;
  }

  public abstract void update(float deltaTime);

  public abstract void paint(float deltaTime);

  public abstract void pause();

  public abstract void resume();

  public abstract void dispose();

  public abstract void backButton();    
}

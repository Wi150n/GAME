package com.CSC3380_Project.framework;

// The game interface
public interface game {
  public audio getAudio();

  public input getInput();

  public fileIO getFileIO();

  public graphics getGraphics();

  public void setScreen(Screen screen);

  public screen getCurrentScreen();

  public screen getInitScreen();
}

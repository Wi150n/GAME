package com.Blake.JukeMasters;

import com.CSC3380_Project.framework.Game;
import com.CSC3380_Project.framework.Graphics;
import com.CSC3380_Project.framework.Screen;
import com.CSC3380_Project.framework.Graphics.ImageFormat;

public class LoadingScreen extends Screen {
  public LoadingScreen(Game game) {
    super(game);
  }
  
  @Override
  public void update(float deltaTime) {
    Graphics g = game.getGraphics();
    Assets.menu = g.newImage("

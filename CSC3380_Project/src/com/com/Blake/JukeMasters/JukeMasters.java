package com.Blake.JukeMasters;

import com.CSC3380_Project.framework.Screen;
import com.CSC3380_Project.framework.implementation.AndroidGame;

public class JukeMasters extends AndroidGame {
  @Override
  public Screen getInitScreen() {
    return new LoadingScreen(this);
  }
  
  @Override
  public void onBackPressed() {
    getCurrentScreen().backButton();
  }
}

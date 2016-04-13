package com.LSU.JukeMasters;

import com.CSC3380_Project.framework.Screen;
import com.CSC3380_Project.framework.implementation.AndroidGame;

public class Game extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this); 
    }
}

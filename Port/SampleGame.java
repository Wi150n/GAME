// some package

// import some stuff

public class SampleGame extends AndroidGame {
  // This will load the loading screen
  @Override
  public Screen getInitScreen() {
    return new LoadingScreen(this);
  }
  
  
  // This is a method that will exit the application when it is loading; using the back button on Android
  @Override
  public void onBackPressed() {
    getCurrentScreen().backButton();
  }
}

// Things to note: screen size can be modified in the method onCreate of the AndroidGame class

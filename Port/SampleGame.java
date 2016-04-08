// some package

// import some stuff

public class SampleGame extends AndroidGame {
  @Override
  public Screen getInitScreen() {
    return new LoadingScreen(this);
  }
}

// Things to note: screen size can be modified in the method onCreate of the AndroidGame class

package com.CSC3380_Project.framework;

// The music interface for the audio interface
public interface music {
  public void play();

  public void stop();

  public void pause();

  public void setLooping(boolean looping);

  public void setVolume(float volume);

  public boolean isPlaying();

  public boolean isStopped();

  public boolean isLooping();

  public void dispose();

  void seekBegin();
}

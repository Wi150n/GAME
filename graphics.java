package com.CSC3380_Project.framework;

// The graphics interface
public interface graphics {
  public static enum ImageFormat {
      ARGB8888, ARGB4444, RGB565
  }

  public image newImage(String fileName, ImageFormat format);

  public void clearScreen(int color);

  public void drawLine(int x, int y, int x2, int y2, int color);

  public void drawRect(int x, int y, int width, int height, int color);

  public void drawImage(image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

  public void drawImage(image Image, int x, int y);

  void drawString(String text, int x, int y, Paint paint);

  public int getWidth();

  public int getHeight();

  public void drawARGB(int i, int j, int k, int l);
}

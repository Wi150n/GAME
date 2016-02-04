package com.CSC3380_Project.framework;

import com.CSC3380_Project.framework.graphics.ImageFormat;

// The image interface for the graphics interface
public interface image {
  public int getWidth();
  public int getHeight();
  public ImageFormat getFormat();
  public void dispose();
}

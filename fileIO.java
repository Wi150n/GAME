package com.CSC3380_Project.framework;

import java.io.*;
import android.content.SharedPreferences;

// The file input framework
public interface fileIO {
  public InputStream readFile(String file) throws IOException;

  public OutputStream writeFile(String file) throws IOException;

  public InputStream readAsset(String file) throws IOException;

  public SharedPreferences getSharedPref();
}

package pmp.solution.ExerciseA;

import pmp.filter.Source;
import pmp.interfaces.Readable;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class Input extends Source<String> implements Readable<String>, Runnable {

  private File _file;

  public Input(File file) {

    _file = file;
  }



  @Override
  public String read() throws StreamCorruptedException {

    StringBuilder fileContents = new StringBuilder((int)_file.length());
    Scanner scanner = null;
    try {
      scanner = new Scanner(_file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String lineSeparator = System.getProperty("line.separator");

    try {
      while(scanner.hasNextLine()) {
        fileContents.append(scanner.nextLine() + lineSeparator);
      }
      return fileContents.toString();
    } finally {
      scanner.close();
    }
  }
}







package pmp.solution.ExerciseB;

import pmp.filter.Source;
import pmp.interfaces.Readable;

import java.io.StreamCorruptedException;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class SourceCharStream extends Source<String> implements Readable<String>, Runnable {

  @Override
  public void run() {

  }

  @Override
  public String read() throws StreamCorruptedException {
    return null;
  }
}

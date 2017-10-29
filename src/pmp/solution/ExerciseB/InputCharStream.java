package pmp.solution.ExerciseB;

import pmp.filter.Source;
import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

import java.io.File;
import java.io.StreamCorruptedException;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class InputCharStream<S> extends Source<String> implements Readable<String>, Runnable {

  private File _file;
  private SimplePipe<String> _simplePipe;
  public InputCharStream(File file, SimplePipe<String> simplePipe) {
    file = _file;
    simplePipe = _simplePipe;
  }

  @Override
  public String read() throws StreamCorruptedException {

    return null;
  }
}

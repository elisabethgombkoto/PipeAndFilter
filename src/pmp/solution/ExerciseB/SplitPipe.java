package pmp.solution.ExerciseB;



import pmp.interfaces.IOable;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.io.StreamCorruptedException;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class SplitPipe<T> implements IOable<T, T> {

  private Writeable<T> _writeable;
  private Writeable<T> _writeable2;
  private Readable<T> _readable;

  public SplitPipe(Writeable<T> writeable, Writeable<T> writeable2) {
    _writeable = writeable;
    _writeable2 = writeable2;
  }

  public SplitPipe(Writeable<T> writeable) {
    _writeable = writeable;
  }

  public SplitPipe(Readable<T> readable) {
    _readable = readable;
  }

  /**
   * If the object is readable, it is a pull pipe.
   * If the object is writeable, it is a push pipe.
   *
   * @param iOable
   */
  public SplitPipe(IOable<T, T> iOable, boolean isPush) {
    if (isPush) {
      _writeable = iOable;
    } else {
      _readable = iOable;
    }
  }

  @Override
  public T read() throws StreamCorruptedException {
    return _readable.read();
  }

  @Override
  public void write(T value) throws StreamCorruptedException {
    _writeable.write(value);

    if (_writeable2 != null) {
      _writeable2.write(value);
    }
  }
}

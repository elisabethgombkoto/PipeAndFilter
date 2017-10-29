package pmp.solution.ExerciseB;

import pmp.interfaces.IOable;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.io.*;
import java.security.InvalidParameterException;

/**
 * Created by Elisabeth on 29.10.2017.
 *
 * class DoublePipe
 * Ist eine Pipe mit einem Eingang und zwei Ausgängen. Bei write wird daher der input an beide Ausgänge weitergeleitet.
 * @param <T>
 */
public class DoublePipe<T extends Serializable> implements IOable<T, T> {

  private Readable<T> m_Input = null;
  private Writeable<T> m_Output1 = null;
  private Writeable<T> m_Output2 = null;

  public DoublePipe(Readable<T> input) {
    if (input == null) {
      throw new InvalidParameterException("input filter can't be null!");
    }
    m_Input = input;
  }

  public DoublePipe(Writeable<T> output1, Writeable<T> output2) {
    if (output1 == null) {
      throw new InvalidParameterException("output filter1 can't be null!");
    }
    if (output2 == null) {
      throw new InvalidParameterException("output filter2 can't be null!");
    }
    m_Output1 = output1;
    m_Output2 = output2;
  }

  public DoublePipe(Readable<T> input, Writeable<T> output1, Writeable<T> output2) {
    if (output1 == null) {
      throw new InvalidParameterException("output filter can't be null!");
    }
    if (output2 == null) {
      throw new InvalidParameterException("output filter2 can't be null!");
    }
    if (input == null) {
      throw new InvalidParameterException("input filter can't be null!");
    }

    m_Output1 = output1;
    m_Output2 = output2;
    m_Input = input;
  }

  @Override
  public T read() throws StreamCorruptedException {
    if (m_Input == null)
      throw new InvalidParameterException("input filter can't be null!");

    return m_Input.read();
  }

  /**
   * write gibt den input weiter an beide Filter.
   *
   * @param input
   * @throws StreamCorruptedException
   */
  @Override
  public void write(T input) throws StreamCorruptedException {
    if (m_Output1 == null)
      throw new InvalidParameterException("output filter1 can't be null!");
    if (m_Output2 == null)
      throw new InvalidParameterException("output filter1 can't be null!");

    m_Output1.write(input);
    T inputCopy = copy(input);
    m_Output2.write(inputCopy);
  }

  /**
   * copy erstellt eine deep-Copy eines Objektes.
   *
   * @param orig
   * @return tiefe Kopie von orig
   */
  public T copy(T orig) {
    T deepCopy = null;
    try {
      // Objekt in ein byte-Array schreiben
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(bos);
      out.writeObject(orig);
      out.flush();
      out.close();

      // Kopie des Objektes aus dem byte-Array einlesen
      ObjectInputStream in = new ObjectInputStream(
          new ByteArrayInputStream(bos.toByteArray()));
      deepCopy = (T) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
    return deepCopy;
  }
}


package pmp.solution.ExerciseA;

import pmp.filter.Source;
import pmp.interfaces.Readable;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class Input extends Source<String> implements Readable<String>, Runnable{

  private String _path;

  public Input(String path) {

    _path = path;
  }

  public ArrayList<LineInGlossary> readFile() {

    ArrayList<LineInGlossary> lines = new ArrayList<LineInGlossary>();
    int lineindex=0;

    try (BufferedReader br = new BufferedReader(new FileReader(new File(_path)))) {

      while (this.read() != null) {
        String s = this.read();
        LineInGlossary line = new LineInGlossary(lineindex+1, s);
        lines.add(lineindex, line);
        lineindex++;
      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return lines;
  }

  @Override
  public String read() throws StreamCorruptedException {
    String s = null ;
    try (BufferedReader br = new BufferedReader(new FileReader(new File(_path)))) {

      while ((s = br.readLine()) != null) {
        s = br.readLine();

      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return s;
  }

}

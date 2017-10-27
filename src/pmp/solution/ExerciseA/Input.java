package pmp.solution.ExerciseA;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class Input {

  private String _path;

  public Input(String path) {

    _path = path;
  }

  public ArrayList<LineInGlossary> readFile() {

    ArrayList<LineInGlossary> lines = new ArrayList<LineInGlossary>();
    int lineindex=0;

    try (BufferedReader br = new BufferedReader(new FileReader(new File(_path)))) {
      String s;
      while ((s = br.readLine()) != null) {
        LineInGlossary line = new LineInGlossary(lineindex+1, s);
        lines.add(lineindex, line);
        lineindex++;

        //System.out.print(line.get_index());
       // System.out.println(line.get_string());
      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return lines;
  }
}

package pmp.solution.ExerciseA;

import java.io.*;
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

  public List<LineInGolossary> readFile() {
    List<LineInGolossary> lines = new ArrayList<LineInGolossary>();
    InputStream ins = null; // raw byte-stream
    Reader r = null; // cooked reader
    BufferedReader br = null; // buffered for readLine()


    try {
      String s;
      if (true) {
        String data = "#foobar\t1234\n#xyz\t5678\none\ttwo\n";
        ins = new ByteArrayInputStream(data.getBytes());
      } else {
        ins = new FileInputStream("textfile.txt");
      }
      r = new InputStreamReader(ins, "UTF-8"); // leave charset out for default
      br = new BufferedReader(r);
      int index = 0;

      while ((s = br.readLine()) != null) {
        LineInGolossary line = new LineInGolossary (index+1, s);
        lines.add(index, line);
      }
    }
    catch (Exception e)
    {
      System.err.println(e.getMessage()); // handle exception
    }
    finally {
      if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
      if (r != null) { try { r.close(); } catch(Throwable t) { /* ensure close happens */ } }
      if (ins != null) { try { ins.close(); } catch(Throwable t) { /* ensure close happens */ } }
    }
    return lines;
  }
}

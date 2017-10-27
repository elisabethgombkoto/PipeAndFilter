import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseA.LineInGlossary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 23.10.2017.
 */
public class Run {

  public static void main(String[] args) {
 String path = "C:\\Users\\Elisabeth\\IdeaProjects\\PipeAndFilter\\src\\pmp\\source\\test";
    Input input = new Input(path);
    ArrayList<LineInGlossary> list = input.readFile();

    for (int i=0; list.size()< i; i++)
    {
      if (list.isEmpty()) {
        System.out.print("empty");
      }else {
      LineInGlossary lg = list.get(i);
      System.out.print(lg.get_index());
      System.out.print(lg.get_string());
      }
    }

  }
}



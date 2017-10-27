import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseA.LineInGolossary;

import java.util.List;

/**
 * Created by Elisabeth on 23.10.2017.
 */
public class Run {

  public static void main(String[] args) {
 String path = "C:\\Users\\Elisabeth\\IdeaProjects\\PipeAndFilter\\src\\pmp\\source\\test";
    Input input = new Input(path);
    List<LineInGolossary> list = input.readFile();


    for (int i=0; list.size()< i; i++){
      System.out.print(list.get(i).get                            );
    }

  }
}



import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseA.LineInGlossary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Elisabeth on 23.10.2017.
 */
public class Run {

    private String sourcePath = "";
    private String destPath = "";

     public Run (){
         sourcePath = System.getProperty("user.dir") + "\\src\\pmp\\source\\test";
         destPath = System.getProperty("user.dir") + "\\src\\pmp\\source\\dest.txt";
     }

     public ArrayList<LineInGlossary> readSource(){
         Input input = new Input(sourcePath);
         ArrayList<LineInGlossary> list = input.readFile();
         return list;
     }

     public void print(){
         ArrayList<LineInGlossary> source = readSource();
         for (int i=0; source.size()< i; i++)
         {
             if (source.isEmpty()) {
                 System.out.print("empty");
             }else {
                 LineInGlossary lg = source.get(i);
                 System.out.print(lg.get_index());
                 System.out.print(lg.get_string());
             }
         }

     }

  public static void main(String[] args) {

      Run start = new Run();
      start.print();





  }
}



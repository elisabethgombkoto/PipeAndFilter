import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseA.LineInGlossary;
import pmp.solution.ExerciseA.LineNummberFilter;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Elisabeth on 23.10.2017.
 */
public class Run {
/*
    private String _sourcePath = "";
    private String _destPath = "";
    private String _work = "";


     public Run (String work){

         _sourcePath = System.getProperty("user.dir") + "\\src\\pmp\\source\\test";
         _destPath = System.getProperty("user.dir") + "\\src\\pmp\\source\\dest.txt";


         _work = work;
     }
 *
     public String readSource(){
         Input input = new Input(_sourcePath);
       LineNummberFilter lineNummberFilter = new LineNummberFilter(input)
       String list = null;
       try {
         list = input.read();
       } catch (StreamCorruptedException e) {

       }
       return list;
     }

     public void print(){
       String source = readSource();
       if (source.isEmpty()) {
         System.out.print("empty");
       }else {
         System.out.print(source);
       }
     }
*/
  public static void main(String[] args) throws StreamCorruptedException {

    Run run = new Run();
    ClassLoader classLoader = run.getClass().getClassLoader();
    File file = new File(classLoader.getResource("./pmp/source/test").getFile());
    Run start = new Run();
    Input input = new Input(file);
    LineNummberFilter lineNummberFilter = new LineNummberFilter(input);
    String[] sarray = lineNummberFilter.read();

    for (String s:sarray) {
      System.out.println(s);
    }

     /*
      System.out.println("Enter 'a' or 'b' ");
      Scanner scanner = new Scanner(System.in);
      String selected = scanner.nextLine();
      System.out.println("You selected " + selected);

      Run start = new Run(selected);


      start.print();

*/



  }
}



import pmp.solution.ExerciseA.*;

import java.io.File;
import java.io.StreamCorruptedException;
import java.util.List;

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
       LineSeparatorFilter lineNummberFilter = new LineSeparatorFilter(input)
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
    LineSeparatorFilter lineSepartorFilter = new LineSeparatorFilter(input);


    /*+++++++++++ Test for LineSeparator +++++++++++++++++++
    List<Line> lines = lineSepartorFilter.read();

    System.out.println("Der text hat: "+lines.size() + " lines" );

    for (Line line: lines){

      System.out.print(line.get_lineIndex() + " ");
      System.out.print(line.get_line() + "\n");
    }

*/
    SequenceOfWordsFilter sequenceOfWordsFilter = new SequenceOfWordsFilter(lineSepartorFilter);

    List<Line> lines = sequenceOfWordsFilter.read();

    System.out.println("Der text hat: "+lines.size() + " lines" );

    for (int i= 0; i<lines.size(); i++) {
      Line line = lines.get(i);
      System.out.print("Die "+line.get_lineIndex() + ". Line enthält: ");
      System.out.println(line.get_sequenceOfwords().size()+" Wörter.");
      for (int j= 0; j< line.get_sequenceOfwords(). size(); j++) {
        System.out.print(line.get_sequenceOfwords().get(j));
      }
      System.out.println(" --> get next line" + "\n");
    }

 /*
    CircularShiftFilter circularShiftFilter = new CircularShiftFilter(sequenceOfWordsFilter);



    List<Line> list = sequenceOfWordsFilter.read();
    System.out.print(list.size());
    for (Line s: list) {
      for (int i = 0; i<s.get_sequenceOfwords().size(); i++){
        String a = s.get_sequenceOfwords().get(i);
        System.out.print(s.get_lineIndex()+ " ");
        System.out.print(a + "\n");

      }

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



import pmp.solution.ExerciseA.*;

import java.io.File;
import java.io.StreamCorruptedException;
import java.util.List;

/**
 * Created by Elisabeth on 20.10.2017.
 */
public class Run {

  public static void main(String[] args) throws StreamCorruptedException {

    Run run = new Run();
    ClassLoader classLoader = run.getClass().getClassLoader();
    File file = new File(classLoader.getResource("./pmp/source/test").getFile());
    Run start = new Run();
    Input input = new Input(file);
    LineSeparatorFilter lineNummberFilter = new LineSeparatorFilter(input);
    SequenceOfWordsFilter sequenceOfWordsFilter = new SequenceOfWordsFilter(lineNummberFilter);

    CircularShiftFilter circularShiftFilter = new CircularShiftFilter(sequenceOfWordsFilter);
    AlphabeticallyOrderedCircularShifts alphabeticOrdered = new AlphabeticallyOrderedCircularShifts(circularShiftFilter);

    List<LineFromSequenceOfWords> list = alphabeticOrdered.read();

    for (LineFromSequenceOfWords s: list) {
      System.out.println();
        System.out.print("Index: " + s.get_lineIndex() + "   ");
      for (String a : s.get_sequenceOfwords() ) {

        System.out.print(a + " ");
      }
    }


     /*
      System.out.println("Enter 'a' or 'b' ");
      Scanner scanner = new Scanner(System.in);
      String selected = scanner.nextLine();
      System.out.println("You selected " + selected);

      Run start = new Run(selected);

        a
      start.print();

*/



  }
}



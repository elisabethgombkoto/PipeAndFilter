import pmp.bib.pipes.SimplePipe;
import pmp.solution.ExerciseA.*;
import pmp.solution.ExerciseB.LineConstructorFilter;
import pmp.solution.ExerciseB.WordConstructorFilter;
import pmp.solution.entities.LineFromSequenceOfWords;

import java.io.File;
import java.io.StreamCorruptedException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elisabeth on 23.10.2017.
 */
public class Run {
  String selected;
  ClassLoader classLoader;
  File file;
  Input input;
  LineSeparatorFilter lineNummberFilter;
  SequenceOfWordsFilter sequenceOfWordsFilter;
  CircularShiftFilter circularShiftFilter;
  AlphabeticallyOrderedCircularShifts alphabeticOrdered;

  public Run(String str){
    selected = str;
    try {
      runMethod();
    } catch (StreamCorruptedException e) {
      e.printStackTrace();
    }
  }

  private void runMethod() throws StreamCorruptedException {
    switch (selected){
      case "a": runA(); break;
      case "b": runB(); break;
      default: runA();
    }
  }

  private void runA() throws StreamCorruptedException {
    runInit();
    input = new Input(file);
    SimplePipe<String> sp1 = new SimplePipe<String>(input);

    lineNummberFilter = new LineSeparatorFilter(sp1);
    SimplePipe<String[]> sp2 = new SimplePipe<String[]>(lineNummberFilter);

    sequenceOfWordsFilter = new SequenceOfWordsFilter(sp2);
    SimplePipe<List<LineFromSequenceOfWords>> sp3 = new SimplePipe<List<LineFromSequenceOfWords>>(sequenceOfWordsFilter);

    circularShiftFilter = new CircularShiftFilter(sp3);
    SimplePipe<List<LineFromSequenceOfWords>> sp4 = new SimplePipe<List<LineFromSequenceOfWords>>((pmp.bib.interfaces.Readable<List<LineFromSequenceOfWords>>) circularShiftFilter);

    alphabeticOrdered = new AlphabeticallyOrderedCircularShifts(sp4);


    List<LineFromSequenceOfWords> list = alphabeticOrdered.read();

    for (LineFromSequenceOfWords s: list) {
      System.out.println();
      System.out.print("Index: " + s.get_lineIndex() + "   ");
      for (String a : s.get_sequenceOfwords() ) {

        System.out.print(a + " ");
      }
    }
  }

  private void runB() throws StreamCorruptedException {
    runInit();
    input = new Input(file);
    SimplePipe<String> pipeSource = new SimplePipe<>(input);

    WordConstructorFilter wordConstructorFilter = new WordConstructorFilter(pipeSource);
    SimplePipe<List<String>> pipeLineToWords = new SimplePipe<List<String>>(wordConstructorFilter);

    LineConstructorFilter lineConstructorFilter = new LineConstructorFilter(pipeLineToWords);
    SimplePipe<List<LineFromSequenceOfWords>> sp3 = new SimplePipe<List<LineFromSequenceOfWords>>(lineConstructorFilter);

    circularShiftFilter = new CircularShiftFilter(sp3);
    SimplePipe<List<LineFromSequenceOfWords>> sp4 = new SimplePipe<List<LineFromSequenceOfWords>>((pmp.bib.interfaces.Readable<List<LineFromSequenceOfWords>>) circularShiftFilter);

    alphabeticOrdered = new AlphabeticallyOrderedCircularShifts(sp4);

    List<LineFromSequenceOfWords> list = alphabeticOrdered.read();

    for (LineFromSequenceOfWords s: list) {
      System.out.println();
      System.out.print("Index: " + s.get_lineIndex() + "   ");
      for (String a : s.get_sequenceOfwords() ) {

        System.out.print(a + " ");
      }
    }
  }

  private void runInit(){
    classLoader = getClass().getClassLoader();
    file = new File(classLoader.getResource("./pmp/source/aliceInWonderland.txt").getFile());

  }

  public static void main(String[] args) throws StreamCorruptedException {
    System.out.println("Enter 'a' or 'b' ");
    Scanner scanner = new Scanner(System.in);
    String selected = scanner.nextLine();
    System.out.println("You selected " + selected);
    Run run = new Run(selected);

  }
}



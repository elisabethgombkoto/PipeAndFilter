import pmp.filter.Sink;
import pmp.pipes.SimplePipe;
import pmp.solution.ExerciseA.AlphabeticallyOrderedCircularShifts;
import pmp.solution.ExerciseA.CircularShiftFilter;
import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseA.LineFromSequenceOfWords;
import pmp.solution.ExerciseB.*;

import java.io.*;
import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class RunExerciseB {

  public static void main(String[] args) throws StreamCorruptedException {


    RunExerciseB run = new RunExerciseB();
    ClassLoader classLoader = run.getClass().getClassLoader();
    File file = new File(classLoader.getResource("./pmp/source/test").getFile());

    Input input = new Input(file);

    SimplePipe<String> pipeSource = new SimplePipe<>(input);
    WordConstructorFilter wordConstructorFilter = new WordConstructorFilter(pipeSource);

    SimplePipe<List<String>> pipeLineToWords = new SimplePipe<List<String>>(wordConstructorFilter);
    LineConstructorFilter lineConstructorFilter = new LineConstructorFilter(pipeLineToWords);

    /*Sink sink = new Sink(lineConstructorFilter);
    AlphabeticallyOrderedCircularShifts alpOrderedCircularShifts = new AlphabeticallyOrderedCircularShifts();
    CircularShiftFilter circularShiftFilter = new CircularShiftFilter(lineConstructorFilter, alpOrderedCircularShifts );
    DoublePipe<LineFromSequenceOfWords[]> mainPipe = new DoublePipe<LineFromSequenceOfWords[]>( sink, circularShiftFilter );

*/









  }
}

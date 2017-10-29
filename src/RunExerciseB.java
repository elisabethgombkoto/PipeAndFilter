import pmp.pipes.SimplePipe;
import pmp.solution.ExerciseA.Input;
import pmp.solution.ExerciseB.InputCharStream;
import pmp.solution.ExerciseB.WordConstructorFilter;

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

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    BufferedWriter bufferedWriter2 = null;


      bufferedReader = new BufferedReader(new FileReader(_sourceFile));
      bufferedWriter = new BufferedWriter(new FileWriter(_targetFile));
      bufferedWriter2 = new BufferedWriter(new FileWriter(_targetFile2));

      boolean isPush = true;
      Sink<List<WordSequence>> sink = new Sink<>(bufferedWriter);
      SinkB<WordSequence> sinkReformatedFile = new SinkB<>(bufferedWriter2);
      sinkReformatedFile.setAmountLineChars(_amountLineChars);
      sinkReformatedFile.setAlignment(_alignment);

      Pipe<List<WordSequence>> pipe4 = new Pipe<>(sink);
      ABCOrderFilter<List<WordSequence>> abcdf = new ABCOrderFilter<>((Writeable<List<WordSequence>>) pipe4);
      Pipe<List<WordSequence>> pipe3 = new Pipe<>(abcdf, isPush);
      CirculationFilter<WordSequence, List<WordSequence>> cf = new CirculationFilter<>(pipe3);
      cf.setSuppressedIndexWords(Arrays.asList(SUPPRESSED_WORDS));

      Pipe<WordSequence> subPipe2 = new Pipe(sinkReformatedFile);
      Pipe<WordSequence> subPipe1 = new Pipe(cf, isPush);
      SplitPipe<WordSequence> mainPipe = new SplitPipe<>(subPipe1, subPipe2);
      LineConstructorFilter<Word, WordSequence> lineConstructorFilter = new LineConstructorFilter<>(mainPipe);
      lineConstructorFilter.setWordsLimit(_lineLength);
      lineConstructorFilter.setAmountLineChars(_amountLineChars);
      lineConstructorFilter.setAlignment(_alignment);



      WordConstructorFilter<String> lf = new WordConstructorFilter<String>(pipe1);
      SimplePipe<String> pipe1 = new SimplePipe<String>(lf);

      InputCharStream<String> source = new InputCharStream(file, pipe1);
      source.read();

  }
}

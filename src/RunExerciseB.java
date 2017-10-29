import pmp.pipes.SimplePipe;
import pmp.solution.ExerciseB.CharToWordsFilter;
import pmp.solution.ExerciseB.IndexSink;
import pmp.solution.ExerciseB.Line;
import pmp.solution.ExerciseB.SourceCharStream;

import java.io.IOException;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class RunExerciseB {
  public static void runExerciseB(String sourcePath, String indexPath) throws IOException{
    IndexSink indexInFileFilter = new IndexSink(indexPath);

    SimplePipe<Line> wordsToLinePipe = new SimplePipe<Line>(indexInFileFilter);

    CharToWordsFilter charToWordsFilter = new CharToWordsFilter(wordsToLinePipe);
    SimplePipe<String> sourceCharPipe = new SimplePipe<String>(charToWordsFilter);

    SourceCharStream sourceCharStream = new SourceCharStream(sourcePath, sourceCharPipe);
    sourceCharStream.run();
  }

}

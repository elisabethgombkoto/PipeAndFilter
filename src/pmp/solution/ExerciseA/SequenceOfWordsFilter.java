package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class SequenceOfWordsFilter extends DataTransformationFilter2<String[], List<LineFromSequenceOfWords>> {


  public SequenceOfWordsFilter(Readable<String[]> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(String[] entity) {
    String[] words = null;
    List<LineFromSequenceOfWords> listOfLines = new ArrayList<>();
    for (String line : entity ) {
       words = line.split("/\\s*\\b\\s*/");
      LineFromSequenceOfWords myLine = new LineFromSequenceOfWords(words);
      listOfLines.add(myLine);
    }
    return listOfLines;
  }
}

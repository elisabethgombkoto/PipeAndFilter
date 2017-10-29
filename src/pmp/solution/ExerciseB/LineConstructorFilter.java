package pmp.solution.ExerciseB;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.solution.ExerciseA.LineFromSequenceOfWords;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class LineConstructorFilter extends DataTransformationFilter2<List<String>, List<LineFromSequenceOfWords>> {

  public LineConstructorFilter(Readable<List<String>> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(List<String> entity) {
    return null;
  }
}

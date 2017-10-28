package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Elisabeth on 28.10.2017.
 *
 * It shift the words in all lines,
 * that finally every words will be ones at the first place at the line
 */
public class CircularShiftFilter extends DataTransformationFilter2<List<LineFromSequenceOfWords>,List<LineFromSequenceOfWords>> {

  public CircularShiftFilter(Readable<List<LineFromSequenceOfWords>> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(List<LineFromSequenceOfWords> entity) {
    return null;
  }
}

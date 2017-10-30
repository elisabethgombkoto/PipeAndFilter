package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;
import pmp.solution.entities.LineFromSequenceOfWords;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Elisabeth on 29.10.2017.
 *
 * The next filter then orders the circular shifts alphabetically.
 */
public class AlphabeticallyOrderedCircularShifts extends DataTransformationFilter2<List<LineFromSequenceOfWords>,List<LineFromSequenceOfWords>> {

  public AlphabeticallyOrderedCircularShifts(Readable<List<LineFromSequenceOfWords>> input) throws InvalidParameterException {
    super(input);
  }
  public AlphabeticallyOrderedCircularShifts(Readable<List<LineFromSequenceOfWords>> input, Writeable<List<LineFromSequenceOfWords>> output) throws InvalidParameterException {
    super(input, output);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(List<LineFromSequenceOfWords> entity) {
         Collections.sort(entity);
    return entity;
  }
}

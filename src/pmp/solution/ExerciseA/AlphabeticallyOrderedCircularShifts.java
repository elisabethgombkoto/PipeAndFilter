package pmp.solution.ExerciseA;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
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

  @Override
  protected List<LineFromSequenceOfWords> process(List<LineFromSequenceOfWords> entity) {
         Collections.sort(entity);
    return entity;
  }
}

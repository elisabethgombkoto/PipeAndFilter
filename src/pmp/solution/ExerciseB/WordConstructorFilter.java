package pmp.solution.ExerciseB;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

import java.security.InvalidParameterException;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class WordConstructorFilter<S> extends DataTransformationFilter2<SimplePipe,String> {

  public WordConstructorFilter(Readable<SimplePipe> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected String process(SimplePipe entity) {
    return null;
  }
}

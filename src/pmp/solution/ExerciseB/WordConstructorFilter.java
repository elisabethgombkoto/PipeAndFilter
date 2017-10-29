package pmp.solution.ExerciseB;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class WordConstructorFilter extends DataTransformationFilter2<String,List<String>> {


  public WordConstructorFilter(Readable<String> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<String> process(String entity) {
    return null;
  }

}
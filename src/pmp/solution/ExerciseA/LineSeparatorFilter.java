package pmp.solution.ExerciseA;

import pmp.bib.filter.DataTransformationFilter2;
import pmp.bib.interfaces.Readable;

import java.security.InvalidParameterException;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class LineSeparatorFilter extends DataTransformationFilter2<String , String[]> {

  public LineSeparatorFilter(Readable<String> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected String[] process(String entity) {
      String text = new String(entity);
      String textStr[] = text.split("\\r\\n|\\n|\\r");
      return textStr;
  }
}

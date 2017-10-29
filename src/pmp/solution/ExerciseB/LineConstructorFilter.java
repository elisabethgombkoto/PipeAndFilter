package pmp.solution.ExerciseB;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.solution.ExerciseA.LineFromSequenceOfWords;

import java.security.InvalidParameterException;
import java.util.ArrayList;
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

    List<LineFromSequenceOfWords> lines = new ArrayList<>();
    int counter = 0;
    int lineIndex= 1;
    String[] str = null;
    for(int i = 0; i<entity.size(); i++){
      str[counter] = entity.get(i);
      if ((counter % 5)==0) {
        LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, str);
        lines.add(line);
        counter = 0;
        lineIndex++;
        str = null;
      }
      counter++;
    }
    return lines;
  }
}

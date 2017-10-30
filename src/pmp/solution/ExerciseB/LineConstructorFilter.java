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
    int counter = 1;
    int lineIndex= 1;
    String[] str = new String[4];
    for(int i = 0; i<entity.size(); i++){
      str[counter-1] = entity.get(i);
      if ((counter % 4) == 0) {
        LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, str);
        lines.add(line);
        counter = 1;
        lineIndex++;
        str = new String[6];
      }else{
        if(counter == entity.size()){
          LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, str);
          lines.add(line);
        }else {
          counter++;
        }
      }
    }
    LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, str);
    lines.add(line);
    return lines;
  }
}

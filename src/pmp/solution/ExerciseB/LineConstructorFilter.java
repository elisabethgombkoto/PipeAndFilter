package pmp.solution.ExerciseB;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.solution.entities.LineFromSequenceOfWords;

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
    List<String> strList = new ArrayList<>();
    for(int i = 0; i<entity.size(); i++){
      strList.add(counter-1,entity.get(i) ) ;
      if ((counter % 4) == 0) {
        String[] stockArr = new String[strList.size()];
        stockArr = strList.toArray(stockArr);
        LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, stockArr);
        lines.add(line);
        counter = 1;
        lineIndex++;
        strList = new ArrayList<>();
      }else{
        if(counter == entity.size()){
          String[] stockArr = new String[strList.size()];
          stockArr = strList.toArray(stockArr);
          LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, stockArr);
          lines.add(line);
        }else {
          counter++;
        }
      }
    }
    String[] stockArr = new String[strList.size()];
    stockArr = strList.toArray(stockArr);
    LineFromSequenceOfWords line = new LineFromSequenceOfWords(lineIndex, stockArr);
    lines.add(line);
    return lines;
  }
}

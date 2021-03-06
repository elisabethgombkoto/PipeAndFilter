package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 28.10.2017.
 *
 * It shift the words in all lines,
 * that finally every words will be ones at the first place at the line
 */
public class CircularShiftFilter extends DataTransformationFilter2<List<Line>,List<Line>> {

  public CircularShiftFilter(Readable<List<Line>> input) throws InvalidParameterException {
    super(input);
  }


  @Override
  protected List<Line> process(List<Line> entity) {

    List<Line> listOfShiftedLines = new ArrayList<>();
    for (int i = 0; i<entity.size(); i++){
      List<String> words = entity.get(i).get_sequenceOfwords();
      List<String> current = words;

      for (int j = 0; j<words.size(); j++){// so lange rufe ich die methode auf bis ich die line ende bin
        listOfShiftedLines.add(new Line(i, current));
        List<String> shiftedLines = shiftTheWordsToRight(current);
        current = shiftedLines;
      }
    }
    return listOfShiftedLines;
  }

  private List<String> shiftTheWordsToRight(List<String> currentWordsArray) {
    List<String > str = currentWordsArray;
    String temp = str.get(str.size()-1);
    for (int i = str.size()-2; i>-1; i--){
      str.add(i+1, str.get(i));
    }
    str.add(0, temp);
    return str;
/*
    List<String> str = Arrays.copyOf(currentWordsArray, currentWordsArray.length);
    String temp = str[str.length - 1];
    for (int i = str.length -2; i>-1; i--){
      str[i+1] = str[i];
    }
    str[0]= temp;
    return str;
*/
  }


}


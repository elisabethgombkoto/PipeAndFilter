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
public class CircularShiftFilter extends DataTransformationFilter2<List<LineFromSequenceOfWords>,List<LineFromSequenceOfWords>> {

  public CircularShiftFilter(Readable<List<LineFromSequenceOfWords>> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(List<LineFromSequenceOfWords> entity) {

    List<LineFromSequenceOfWords> listOfShiftedLines = new ArrayList<>();
    for (int i = 0; i<entity.size(); i++){
      String[] words = entity.get(i).get_sequenceOfwords();
      String[] current = words;

      for (int j = 0; j<words.length; j++){// so lange rufe ich die methode auf bis ich die line ende bin
        String[] shiftedLines = shiftTheWordsToRight(current);
        listOfShiftedLines.add(new LineFromSequenceOfWords(i, shiftedLines));
        current = shiftedLines;
      }
    }
    return listOfShiftedLines;
  }

  private String[] shiftTheWordsToRight(String[] currentWordsArray) {
    String temp = currentWordsArray[currentWordsArray.length - 1];
    for (int i = currentWordsArray.length -2; i>-1; i--){
      currentWordsArray[i+1] = currentWordsArray[i];
    }
    currentWordsArray[0]= temp;
    return currentWordsArray;
  }
}


package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.solution.entities.LineFromSequenceOfWords;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class SequenceOfWordsFilter extends DataTransformationFilter2<String[], List<LineFromSequenceOfWords>> {

  public SequenceOfWordsFilter(Readable<String[]> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(String[] entity) {
    String[] words = null;
    List<LineFromSequenceOfWords> listOfLines = new ArrayList<>();
    int lineIndex = 1;
    for (String line : entity ) {
      if(!line.isEmpty()) {   //leere lines werden nicht akzeptiert
        words = splitLineToWords(line);
        LineFromSequenceOfWords myLine = new LineFromSequenceOfWords(lineIndex, words);
        listOfLines.add(lineIndex - 1, myLine);
        lineIndex++;
      }
    }
    return listOfLines;
  }

  private String[] splitLineToWords(String line) {

    /**String[] result = new String[line.length()];
    char[] chars = line.toCharArray();
    StringBuilder st = null;
    int k = 0;
    int index = 0;
    while (k<chars.length-1) {
      if (Character.isLetter(chars[k])){
        while (Character.isLetter(chars[k]) && k<chars.length-1) {
          if (st != null) {
            st.append(chars[k]);
            k++;
          } else {
            st = new StringBuilder();
            st.append(chars[k]);
            k++;
          }
        }
        result[index] = st.toString();
        index++;
      }
      if (!Character.isLetter(chars[k]) && !Character.isSpaceChar(chars[k])) {
        st = new StringBuilder(chars[k]);
        System.out.println("NO LETTER darum Null  --  K= : "+ k);
        st.append(chars[k]);
        System.out.println("Char K = " + chars[k]);
        k++;
        result[index] = st.toString();
        index++;
        st = null;
      }
    }
     **/

    String[] result = line.split("\\W+");
    return result;
  }
}

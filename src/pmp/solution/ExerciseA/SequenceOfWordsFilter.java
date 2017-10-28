package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

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
       words = splitLineToWords(line);
      LineFromSequenceOfWords myLine = new LineFromSequenceOfWords(lineIndex, words);
      listOfLines.add(lineIndex-1, myLine);
    }
    return listOfLines;
  }

  private String[] splitLineToWords(String line) {

    String[] result = new String[line.length()];
    char[] chars = line.toCharArray();
    StringBuilder st = null;
    int k = 0;
    int index = 0;
    while (k<chars.length) {
      if (Character.isLetter(chars[k])){
        while (Character.isLetter(chars[k]) && k<chars.length) {
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
      if (!Character.isLetter(chars[k])) {
        st = new StringBuilder(chars[k]);
        st.append(chars[k]);
        k++;
        result[index] = st.toString();
        index++;
        st = null;
      }
    }
    return result;
  }
}

package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;
import pmp.solution.entities.LineFromSequenceOfWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.*;

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

  public CircularShiftFilter (Readable<List<LineFromSequenceOfWords>> input, Writeable<List<LineFromSequenceOfWords>> output){
    super(input, output);
  }

  @Override
  protected List<LineFromSequenceOfWords> process(List<LineFromSequenceOfWords> entity) {
    HashSet<String> stopWords = new HashSet<>(getStopwords());

    List<LineFromSequenceOfWords> listOfShiftedLines = new ArrayList<>();
    for (int i = 0; i<entity.size(); i++){
      String[] words = entity.get(i).get_sequenceOfwords();
      String[] current = words;

      for (int j = 0; j<words.length; j++){// so lange rufe ich die methode auf bis ich die line ende bin
        if(!stopWords.contains(current[0])) {  //wenn ein Stopwort am lineanfang vorkommt, wird keine line in die List geschrieben.
          listOfShiftedLines.add(new LineFromSequenceOfWords(entity.get(i).get_lineIndex(), current));
        }
          String[] shiftedLines = shiftTheWordsToRight(current);
          current = shiftedLines;

      }
    }
    return listOfShiftedLines;
  }

  private String[] shiftTheWordsToRight(String[] currentWordsArray) {
    String[] str = Arrays.copyOf(currentWordsArray, currentWordsArray.length);
    String temp = str[str.length - 1];
    for (int i = str.length -2; i>-1; i--){
      str[i+1] = str[i];
    }
    str[0]= temp;
    return str;
  }

  // Erstellt ein HashSet mit Stopwörter aus der Datei stopwords.txt
  private HashSet<String> getStopwords(){
    File file = new File(System.getProperty("user.dir") + "\\src\\pmp\\source\\stopwords.txt");

    Scanner sc = null;
    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    HashSet<String> stopWordsSet = new HashSet<>();
    while (sc.hasNext()) {
      stopWordsSet.add(sc.next().trim());
    }
    stopWordsSet.add("");
    return stopWordsSet;
  }


}


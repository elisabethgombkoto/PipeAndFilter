package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class SequenceOfWordsFilter extends DataTransformationFilter2<List<Line>, List<Line>> {


  public SequenceOfWordsFilter(Readable<List<Line>> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<Line> process(List<Line> entity) {
    List<String> words;
    List<Line> listOfLines = new ArrayList<>();
    int lineIndex = 1;
    for (int i=0; i < entity.size(); i++) {
      Line line = entity.get(i);
      if(line.get_line().isEmpty()){
        words = new ArrayList<>();
        words.add(new String(""));
      }else {
        words =  splitLineToWords(line);
      }
      Line myLine = new Line(lineIndex, words);
      listOfLines.add(lineIndex-1, myLine);
    }
    return listOfLines;
  }

  private List<String> splitLineToWords(Line line) {
    ArrayList<String> words = new ArrayList<>();
    StringBuilder st = null;
    for(int i = 0; i<line.get_line().toCharArray().length; i++){
      char c = line.get_line().toCharArray()[i];
      if(Character.isLetter(c)){  //is a letter
        if(st!=null){
          st.append(c);// if it is not null then include a letter
        }else {
          st = new StringBuilder().append(c);
        }
      }else { // is not a letter
        if(st!=null){ // but st include alredy something
          words.add(st.toString()); //put to array st
          st = new StringBuilder().append(c); //builed a new Stringbuilder whit the NOT letter char
          words.add(st.toString()); //put to array st
          st = null;// set st to null again
        }else {
          st = new StringBuilder().append(c); //builed a new Stringbuilder whit the NOT letter char
          words.add(st.toString()); //put to array st
          st = null;// set st to null again
        }
      }
    }
    if(st!=null){
      //put to array st whit the letters
      // if the last char is not a later then st is null
      // and we do not have to empty the st
      words.add(st.toString());
    }


   return words;
  }
}

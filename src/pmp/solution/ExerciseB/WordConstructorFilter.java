package pmp.solution.ExerciseB;

import pmp.bib.filter.DataTransformationFilter2;
import pmp.bib.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 29.10.2017.
 */
public class WordConstructorFilter extends DataTransformationFilter2<String,List<String>> {


  public WordConstructorFilter(Readable<String> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<String> process(String entity) {
    ArrayList<String> words = new ArrayList<>();
    StringBuilder st = null;
    for(int i = 0; i<entity.toCharArray().length; i++){
      char c = entity.toCharArray()[i];
      if(Character.isLetter(c)){  //is a letter
        if(st!=null){
          st.append(c);// if it is not null then include a letter
        }else {
          st = new StringBuilder().append(c);
        }
      }else { // is not a letter
        if(st!=null){ // but st include alredy some letter
          words.add(st.toString()); //put to array st in array
          st = null;
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
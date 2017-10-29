package pmp.solution.ExerciseA;

import java.util.List;

/**
 * Created by Elisabeth on 28.10.2017.
 * a line whit the words in this line
 */
public class LineFromSequenceOfWords implements Comparable<String[]>{

  private String[] _sequenceOfwords;
  private int _lineIndex;

  public LineFromSequenceOfWords(int lineIndex, String[] sequenceOfwords){
    _lineIndex = lineIndex;
    _sequenceOfwords = sequenceOfwords;
  }

 @Override//this function is required to sort a List of Objects
  public int compareTo(String[] other) {
    //as we will compare only strings, we need to compare them
   //in alphabetical order
   //es sollte hier nicht 0 hard codiert stehen
   int index =0;
   int compareInt = this._sequenceOfwords[0].compareTo(other[0]);
   if(compareInt < index) return -1; //the this._sequenceOfwords[0] firstWord in the list is "bigger"
   if(compareInt > index) return 1; //the other._sequenceOfwords[0] firstWord in the list is "bigger"
   return compareToAgain(index, other) ;
 }

  private int compareToAgain(int index, String[] other) {
    if(index+1 > this._sequenceOfwords.length ){// the to lines are identical
      return 0;
    }else {
      index = index++;
      int compareInt = this._sequenceOfwords[0].compareTo(other[0]);
      if(compareInt < index) return -1; //the this._sequenceOfwords[0] firstWord in the list is "bigger"
      if(compareInt > index) return 1; //the other._sequenceOfwords[0] firstWord in the list is "bigger"
      return compareToAgain(index, other) ;
    }
  }

  public int get_lineIndex() {
    return _lineIndex;
  }

  public void set_lineIndex(int _lineIndex) {
    this._lineIndex = _lineIndex;
  }

  public String[] get_sequenceOfwords() {
    return _sequenceOfwords;
  }

  public void set_sequenceOfwords(String[] _sequenceOfwords) {
    this._sequenceOfwords = _sequenceOfwords;
  }


}

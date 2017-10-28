package pmp.solution.ExerciseA;

import java.util.List;

/**
 * Created by Elisabeth on 28.10.2017.
 * a line whit the words in this line
 */
public class LineFromSequenceOfWords {

  private String[] _sequenceOfwords;
  private int _lineIndex;

  public LineFromSequenceOfWords(int lineIndex, String[] sequenceOfwords){
    _lineIndex = lineIndex;
    _sequenceOfwords = sequenceOfwords;
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

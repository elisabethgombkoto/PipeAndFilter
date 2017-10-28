package pmp.solution.ExerciseA;

import java.util.List;

/**
 * Created by Elisabeth on 28.10.2017.
 * a line whit the words in this line
 */
public class Line {

  private List<String> _sequenceOfwords;
  private int _lineIndex;
  private String _line;

  public Line(){};

  public Line(int lineIndex, List<String> sequenceOfwords){
    _lineIndex = lineIndex;
    _sequenceOfwords = sequenceOfwords;
  }

  public Line(int lineIndex, String line){
    _lineIndex = lineIndex;
    _line = line;
  }

  public String get_line() {
    return _line;
  }

  public void set_line(String _line) {
    this._line = _line;
  }

  public int get_lineIndex() {
    return _lineIndex;
  }

  public void set_lineIndex(int _lineIndex) {
    this._lineIndex = _lineIndex;
  }

  public List<String> get_sequenceOfwords() {
    return _sequenceOfwords;
  }

  public void set_sequenceOfwords(List<String> _sequenceOfwords) {
    this._sequenceOfwords = _sequenceOfwords;
  }

}

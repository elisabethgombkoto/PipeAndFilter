package pmp.solution.ExerciseA;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class LineInGlossary {

  private int _i;
  private String _s;

  public LineInGlossary(int i, String s) {
    _i=i;
    _s=s;
  }


  public int get_index() {
    return _i;
  }

  public String get_string() {
    return _s;
  }
}

package pmp.solution.ExerciseA;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elisabeth on 27.10.2017.
 */
public class LineSeparatorFilter extends DataTransformationFilter2<String , List<Line>> {

  public LineSeparatorFilter(Readable<String> input) throws InvalidParameterException {
    super(input);
  }

  @Override
  protected List<Line> process(String entity) {


    List<Line> text = new ArrayList<Line>();

    Scanner sc = new Scanner(entity);
    int lineIndex = 1;
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      Line line = new Line(lineIndex, s);
      text.add(line);
      lineIndex++;
    }
     return text;
  }
}

package stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPoint() {
    Point p1 = new Point(5, 5);
    Point p2 = new Point(5, 0);
    double expectedResult = 5;
    Assert.assertEquals(p1.distance(p1, p2), expectedResult);
  }

  @Test
  public void testPoint2() {
    Point p1 = new Point(-3, 4);
    Point p2 = new Point(5, 4);
    double expectedResult = 8;
    Assert.assertEquals(p1.distance(p1, p2), expectedResult);
  }

  @Test
  public void testPoint3() {
    Point p1 = new Point(5, -4);
    Point p2 = new Point(0, 8);
    double expectedResult = 13;
    Assert.assertEquals(p1.distance(p1, p2), expectedResult);
  }

  @Test
  public void testPoint4() {
    Point p1 = new Point(-3, 2);
    Point p2 = new Point(5, 8);
    double expectedResult = 10;
    Assert.assertEquals(p1.distance(p1, p2), expectedResult);
  }
}

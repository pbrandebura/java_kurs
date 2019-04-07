package stqa.ptf.sandbox;


public class DistanceBetweenPoints {
  public static void main(String[] args) {
    Point p1 = new Point(5, 3);
    Point p2 = new Point(2, 3);

    System.out.println("Distance between point A:(" + p1.x + ", " + p1.y + ") and point B:(" + p2.x + ", " + p2.y + ") is " + p1.distance(p1, p2));


  }
}
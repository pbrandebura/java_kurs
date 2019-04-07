package stqa.ptf.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("Patryk");

    Square s = new Square(8);
    System.out.println("Powierzchnia kwadratu o boku " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 3.5);
    System.out.println("Powierzchnia prostokata o bokach " + r.a + " i " + r.b + " = " + r.rectangle());
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");


  }


}
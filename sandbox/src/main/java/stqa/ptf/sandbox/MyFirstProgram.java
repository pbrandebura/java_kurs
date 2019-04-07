package stqa.ptf.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("Patryk");

    double len = 8;
    System.out.println("Powierzchnia kwadratu o boku " + len + " = " + area(len));


    double bok1 = 5;
    double bok2 = 3.5;
    System.out.println("Powierzchnia prostokata o bokach " + bok1 + " i " + bok2 + " = " + rectangle(bok1, bok2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");


  }

  public static double area(double l) {
    return l * l;
  }

  public static double rectangle(double a, double b) {
    return a * b;
  }


}

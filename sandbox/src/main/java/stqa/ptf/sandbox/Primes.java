package stqa.ptf.sandbox;

public class Primes {

  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < 2) {
      if (n % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static boolean isPrime(long n) {
    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    for (int i = 2; i < n/2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}

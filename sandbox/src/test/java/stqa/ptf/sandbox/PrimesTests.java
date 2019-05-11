package stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {
  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNoPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test
  public void testPrimeLong() {
    long l = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(l));
  }

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }
}

import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) throws IllegalArgumentException {
    // Prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first rational number: ");
    Rational r1 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));

    System.out.print("Enter the second second number: ");
    Rational r2 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));
    input.close();

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

class Rational extends Number implements Comparable<Rational> {
  // Data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  public Rational(BigInteger n, BigInteger d) {
    if (d.equals(BigInteger.ZERO)) {
      throw new IllegalArgumentException("Can't have zero in denominator");
    }

    numerator = n;
    denominator = d;
  }

  public static BigInteger gcd(BigInteger m, BigInteger n) {
    if (m.equals(BigInteger.ZERO)) {
      return n;
    }

    return Rational.gcd(m.mod(n), n);
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  @Override
  public int intValue() {
    return numerator.intValue() / denominator.intValue();
  }

  @Override
  public float floatValue() {
    return numerator.floatValue() / denominator.floatValue();
  }

  @Override
  public long longValue() {
    return numerator.longValue() / denominator.longValue();
  }

  @Override
  public int compareTo(Rational o) {
    if (this.doubleValue() > o.doubleValue()) {
      return 1;
    }

    if (this.doubleValue() < o.doubleValue()) {
      return -1;
    }

    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((Rational) other)).getNumerator().equals(BigInteger.ZERO)) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return new String(numerator + "/" + denominator);
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public Rational add(Rational rhs) {
    BigInteger n = numerator.multiply(rhs.denominator).add(rhs.numerator.multiply(denominator));
    return new Rational(n, denominator.multiply(rhs.denominator));
  }

  public Rational subtract(Rational rhs) {
    BigInteger n = numerator.multiply(rhs.denominator).subtract(rhs.numerator.multiply(denominator));
    return new Rational(n, denominator.multiply(rhs.denominator));
  }

  public Rational multiply(Rational rhs) {
    return new Rational(numerator.multiply(rhs.numerator), denominator.multiply(rhs.denominator));
  }

  public Rational divide(Rational rhs) {
    return new Rational(numerator.multiply(rhs.denominator), denominator.multiply(rhs.numerator));
  }

}

// (Use BigInteger for the Rational class)
// Redesign and implement the Rational class in LiveExample 13.13 using
// BigInteger for the numerator and denominator. Use the code at
// https://liveexample.pearsoncmg.com/test/Exercise13_15.txt
// to test your implementation. Here is a sample run:
// Sample Run
// Enter the first rational number: 3 454
// Enter the second second number: 7 2389
// 3/454 + 7/2389 = 10345/1084606
// 3/454 - 7/2389 = 3989/1084606
// 3/454 * 7/2389 = 21/1084606
// 3/454 / 7/2389 = 7167/3178
// 7/2389 is 0.0029300962745918793
// Class Name: Exercise13_15
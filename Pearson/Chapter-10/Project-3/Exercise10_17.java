import java.math.BigInteger;

public class Exercise10_17 {
  public static void main(String[] args) {
    long n = (long)Math.sqrt(Long.MAX_VALUE) + 1;

    System.out.println("The ten numbers are");
    for (int i = 0; i < 10; i++) {
      BigInteger t = BigInteger.valueOf(n++);
      System.out.println(t.multiply(t));
    }
  }
}
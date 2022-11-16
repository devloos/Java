import java.util.Scanner;

public class Exercise12_07 {
  public static int bin2Dec(String binNum) {
    String b = new StringBuilder(binNum).reverse().toString();
    int convert = 0;
    for (int c = 0; c < b.length(); c++) {
      int t = Integer.parseInt(String.valueOf(b.charAt(c)));
      if (t > 1 || t < 0) {
        System.out.println("Not a binary number: " + binNum);
        System.exit(0);
      }
      convert += Math.pow(2, c) * t;
    }
    return convert;
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    try {
      System.out.print("Enter a binary number: ");
      String binNum = cin.next();
      System.out.println(bin2Dec(binNum));
    } catch (NumberFormatException ex) {
      System.out.println(ex.getMessage());
    }
    cin.close();
  }
}

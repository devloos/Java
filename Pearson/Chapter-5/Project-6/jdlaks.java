import java.util.Scanner;

class Exercise05_47 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int sum = 0;

    System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
    String isbn = cin.nextLine();
    cin.close();

    if (isbn.length() < 12) {
      System.out.println(isbn + " is an invalid input");
    }

    for (int i = 0; i < isbn.length(); i++) {
      sum += (i % 2 == 0) ? 3 * (Integer.parseInt(String.valueOf(isbn.charAt(i)))) : Integer.parseInt(String.valueOf(isbn.charAt(i)));
    }

    final int result = 10 - sum % 10;

    if (result == 10) {
      System.out.println("The ISBN-13 number is " + isbn + 0);
      return;
    }

    System.out.println("The ISBN-13 number is " + isbn + result);
  }
}


// (Business: check ISBN-13)
// ISBN-13 is a new standard for identifying books. It uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. 
// The last digit d13 is a checksum, which is calculated from the other digits using the following formula:
// 10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12) % 10
// If the checksum is 10, replace it with 0. Your program should read the input as a string.
// Display “invalid input” if the input is incorrect.
// Sample Run 1
// Enter the first 12 digits of an ISBN-13 as a string: 978013213080
// The ISBN-13 number is 9780132130806
// Sample Run 2
// Enter the first 12 digits of an ISBN-13 as a string: 978013213079
// The ISBN-13 number is 9780132130790
// Sample Run 3
// Enter the first 12 digits of an ISBN-13 as a string: 97801320
// 97801320 is an invalid input
// Class Name: Exercise05_47
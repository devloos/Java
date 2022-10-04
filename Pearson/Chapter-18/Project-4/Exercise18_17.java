import java.util.Scanner;

public class Exercise18_17 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print("Enter a string: ");
    char[] s = cin.nextLine().toCharArray();
    System.out.print("Enter a character: ");
    char c = cin.next().charAt(0);
    cin.close();

    System.out.println(c + " appears " + count(s, c) + " times");
  }

  public static int count(char[] s, char c) {
    return count(s, c, s.length - 1);
  }

  public static int count(char[] s, char c, int h) {
    if (h < 0) return 0;
    if (s[h] == c) return 1 + count(s, c, h - 1);
    return count(s, c, h - 1);
  }
}

// (Occurrences of a specified character in an array)
// Write a recursive method that finds the number of occurrences of a specified character in an array. 
// You need to define the following two methods. The second one is a recursive helper method.
// public static int count(char[] chars, char ch)
// public static int count(char[] chars, char ch, int high) 
// Write a test program that prompts the user to enter a list of characters in one line, and a character, 
// and displays the number of occurrences of the character in the list.
// Sample Run
// Enter a string: Welcome to JavaEnter a character: ee appears 2 times
// Class Name:Exercise18_17
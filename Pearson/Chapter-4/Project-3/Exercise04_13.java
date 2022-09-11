import java.util.Scanner;

class Exercise04_13 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    char[] arr = {'a', 'e', 'i', 'o', 'u'};

    System.out.print("Enter a letter: ");
    final char letter = cin.nextLine().charAt(0);
    cin.close();
    if (!Character.isLetter(letter)) {
      System.out.println(letter + " is an invalid input");
      return;
    }
    if (Exercise04_13.inArray(arr, Character.toLowerCase(letter))) {
      System.out.println(letter + " is a vowel");
      return;
    }
    System.out.println(letter + " is a consonant");
  }
  private static boolean inArray(char[] arr, char ch) {
    for (final char c : arr) {
      if (ch == c) {
        return true;
      }
    }
    return false;
  }
}

// Vowel or consonant?) 
// Write a program that prompts the user to enter a letter and check whether the letter is a vowel or consonant.
// For a nonletter input, display invalid input.
// Sample Run 1
// Enter a letter: B
// B is a consonant
// Sample Run 2
// Enter a letter grade: a
// a is a vowel 
// Sample Run 3
// Enter a letter grade: #
// # is an invalid input
// Class Name: Exercise04_13
import java.util.Scanner;

class Exercise05_49 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int numberOfVowels = 0;
    int numberOfConsonant = 0;

    System.out.print("Enter a string: ");
    String string = cin.nextLine();
    for (int i = 0; i < string.length(); i++) {
      switch (Character.toUpperCase(string.charAt(i))) {
        case 'A': case 'E': case 'I': case 'O': case 'U': {
          ++numberOfVowels;
          break;
        }
        case ' ': break;
        default: {
          ++numberOfConsonant;
        }
      }
    }
    cin.close();

    System.out.println("The number of vowels is " + numberOfVowels);
    System.out.println("The number of consonants is " + numberOfConsonant);
  }
}

// (Count vowels and consonents)
// Assume letters A, E, I, O, and U as the vowels.
// Write a program that prompts the user to enter a string and displays the number of vowels and consonants in the string.
// Sample Run
// Enter a string: Programming is fun
// The number of vowels is 5
// The number of consonants is 11
// Class Name: Exercise05_49 
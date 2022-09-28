import java.util.Scanner;

public class Exercise07_01 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int studentNumber = cin.nextInt();
    int[] scores = new int[studentNumber];

    System.out.print("Enter " + studentNumber + " scores: ");
    for (int i = 0; i < studentNumber; i++)
      scores[i] = cin.nextInt();
    
    int best = 0;
    for (int score : scores) {
      if (score > best) best = score;
    }

    for (int i = 0; i < studentNumber; i++) {
      int remainder = best - scores[i];
      if (remainder <= 10) {
        printResult(i, scores[i], 'A');
      } else if (remainder <= 20) {
        printResult(i, scores[i], 'B');
      } else if (remainder <= 30) {
        printResult(i, scores[i], 'C');
      } else if (remainder <= 30) {
        printResult(i, scores[i], 'D');
      } else {
        printResult(i, scores[i], 'F');
      }
    }

    cin.close();
  }

  public static void printResult(int i, int score, char grade) {
    System.out.println("Student " + i + " score is " + score + " and grade is " + grade);
  }
}

// (Assign grades) 
// Write a program that reads student scores, gets the best score, and then assigns grades based on the following scheme:
// Grade is A if score is  ≥ best - 10
// Grade is B if score is  ≥ best - 20
// Grade is C if score is  ≥ best - 30
// Grade is D if score is  ≥ best - 40
// Grade is F otherwise.
// The program prompts the user to enter the total number of students, 
// then prompts the user to enter all of the scores, and concludes by displaying the grades.
// Sample Run
// Enter the number of students: 4
// Enter 4 scores: 40 55 70 58
// Student 0 score is 40 and grade is C
// Student 1 score is 55 and grade is B
// Student 2 score is 70 and grade is A
// Student 3 score is 58 and grade is B
// Class Name: Exercise07_01
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Exercise05_09 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Double> scores = new ArrayList<Double>();

    System.out.print("Enter the number of students: ");
    for (int i = cin.nextInt(); i > 0; i--) {
      System.out.print("Enter a student name: ");
      names.add(cin.next());
      System.out.print("Enter a student score: ");
      scores.add(cin.nextDouble());
    }

    final int MAX_INDEX = scores.indexOf(Collections.max(scores));

    System.out.println("Top two students: ");
    System.out.println(names.get(MAX_INDEX) + "'s score is " + scores.get(MAX_INDEX));
    scores.remove(MAX_INDEX);
    names.remove(MAX_INDEX);

    final int SECOND_MAX_INDEX = scores.indexOf(Collections.max(scores));
    System.out.println(names.get(SECOND_MAX_INDEX) + "'s score is " + scores.get(SECOND_MAX_INDEX));

    cin.close();
  }
}


// (Find the two highest scores) 
// Write a program that prompts the user to enter the number of students and each student’s name and score, 
// and finally displays the student with the highest score and the student with the second-highest score. 
// Use the next()method in the Scanner class to read a name rather than using the nextLine()method. Assume that the number of students is at least 2.
// Sample Run
// Enter the number of students: 5
// Enter a student name: Smith
// Enter a student score: 60
// Enter a student name: Jones
// Enter a student score: 96
// Enter a student name: Peterson
// Enter a student score: 85
// Enter a student name: Greenlaw
// Enter a student score: 98
// Enter a student name: Zhang
// Enter a student score: 95
// Top two students:
// Greenlaw's score is 98.0
// Jones's score is 96.0
// Class Name: Exercise05_09
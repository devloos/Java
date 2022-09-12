import java.util.Scanner;

class Exercise05_01 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int inputNum = 0;
    int positiveCount = 0;
    int negativeCount = 0;
    int total = 0;

    System.out.print("Enter an integer, the input ends if it is 0: ");
    inputNum = cin.nextInt();
    while (inputNum != 0) {
      if (inputNum < 0) {
        ++negativeCount;
      } else {
        ++positiveCount;
      }
      total += inputNum;
      inputNum = cin.nextInt();
    }
    cin.close();

    if (positiveCount <= 0 && negativeCount <= 0) {
      System.out.println("No numbers are entered except 0");
      return;
    }

    System.out.println("The number of positives is " + positiveCount);
    System.out.println("The number of negatives is " + negativeCount);
    System.out.println("The total is " + total);
    System.out.println("The average is " + ((double)total / (positiveCount + negativeCount)));
  }
}


// (Count positive and negative numbers and compute the average of numbers)
// Write a program that reads an unspecified number of integers, determines how many positive and negative 
// values have been read, and computes the total and average of the input values (not counting zeros). 
// Your program ends with the input 0. Display the average as a floating-point number.
// Sample Run 1
// Enter an integer, the input ends if it is 0: 1 2 -1 3 0
// The number of positives is 3
// The number of negatives is 1
// The total is 5.0
// The average is 1.25
// Sample Run 2
// Enter an integer, the input ends if it is 0: 0
// No numbers are entered except 0
// Sample Run 3
// Enter an integer, the input ends if it is 0: 2 3 4 5 0
// The number of positives is 4
// The number of negatives is 0
// The total is 14
// The average is 3.5
// Sample Run 4
// Enter an integer, the input ends if it is 0: -4 3 2 -1 0
// The number of positives is 2
// The number of negatives is 2
// The total is 0
// The average is 0.0
// Class Name: Exercise05_01
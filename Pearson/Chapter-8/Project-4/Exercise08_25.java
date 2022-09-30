import java.util.Scanner;

public class Exercise08_25 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    double[][] matrix = new double[3][3];
    System.out.println("Enter a 3-by-3 matrix row by row:");
    for (int row = 0; row < matrix.length; row++) 
      for (int col = 0; col < matrix[row].length; col++) 
        matrix[row][col] = cin.nextDouble();
    
    if (isMarkovMatrix(matrix)) {
      System.out.println("It is a Markov Matrix");
    } else {
      System.out.println("It is not a Markov Matrix");
    }

    cin.close();
  }

  public static boolean isMarkovMatrix(double[][] matrix) {
    int markovCol = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] < 0.0) return false;
      }
      if (sumColumn(matrix, markovCol) != 1.0) return false;
      markovCol++;
    }
    return true;
  }

  public static double sumColumn(double[][] matrix, int col) {
    double sum = 0;
    for (int row = 0; row < matrix.length; row++)
      sum += matrix[row][col];
    return sum;
  }
}

// (Markov matrix)
// An n by n matrix is called a positive Markov matrix if each element is positive and the sum of the elements in each column is 1. 
// Write the following method to check whether a matrix is a Markov matrix.
// public static boolean is Markov Matrix(double[][] m)
// Write a test program that prompts the user to enter a 3 by 3 matrix of double values and tests whether it is a Markov matrix. Here are sample runs:
// Sample Run 1
// Enter a 3-by-3 matrix row by row:
// 0.15 0.875 0.375
// 0.55 0.005 0.225
// 0.30 0.12 0.4
// It is a Markov matrix
// Sample Run 2
// Enter a 3-by-3 matrix row by row:
// 0.95 -0.875 0.375
// 0.65 0.005 0.225
// 0.30 0.22 -0.4
// It is not a Markov matrix
// Class Name: Exercise08_25
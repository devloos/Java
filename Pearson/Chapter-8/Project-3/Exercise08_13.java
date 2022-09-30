import java.util.Scanner;

public class Exercise08_13 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter the number of rows and columns of the array:");
    final int ROWS = cin.nextInt();
    final int COLS = cin.nextInt();

    double[][] matrix = new double[ROWS][COLS];
    System.out.print("Enter the array:");

    for (int row = 0; row < ROWS; row++)
      for (int col = 0; col < COLS; col++)
        matrix[row][col] = cin.nextDouble();

    int[] result = locateLargest(matrix);

    System.out.println("The location of the largest element is at (" + result[0] + ", " + result[1] + ")");

    cin.close();
  }

  public static int[] locateLargest(double[][] matrix) {
    // Default is origin
    int[] largestIndex = {0, 0};
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] > matrix[largestIndex[0]][largestIndex[1]]) {
          largestIndex[0] = row;
          largestIndex[1] = col;
        }
      }
    }
    return largestIndex;
  }
}

// (Locate the largest element)
// Write the following method that returns the location of the largest element in a two-dimensional array.
// public static int[] locateLargest(double[][] a)
// The return value is a one-dimensional array that contains two elements. 
// These two elements indicate the row and column indices of the largest element in the two-dimensional array. 
// If there are more than one largest element, return the smallest row index and then the smallest column index.
// Write a test program that prompts the user to enter a two-dimensional array and displays the location of the largest element in the array.
// Sample Run
// Enter the number of rows and columns of the array: 3 4 
// Enter the array:
// 23.5 35 2 10
// 4.5 3 45 3.5
// 35 44 5.5 9.6
// The location of the largest element is at (1, 2)
// Class Name: Exercise08_13
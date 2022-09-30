import java.util.Scanner;

public class Exercise08_01 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    double[][] matrix = new double[3][4];

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[i].length; j++)
        matrix[i][j] = cin.nextDouble();
    
    for (int i = 0; i < matrix[0].length; i++) {
      System.out.println("Sum of the elements at column " + i + " is " + sumColumn(matrix, i));
    }
    cin.close();
  }

  public static double sumColumn(double[][] array, int index) {
    double sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i][index];
    }
    return sum;
  }
}

// (Sum elements column by column)
// Write a method that returns the sum of all the elements in a specified column in a matrix using the following header:
// public static double sum Column(double[][] m, int column Index)
// Write a test program that reads a 3-by-4 matrix and displays the sum of each column.
// Samole Run
// Enter a 3-by-4 matrix row by row:
// 1.5 2 3 4
// 5.5 6 7 8
// 9.5 1 3 1
// Sum of the elements at column 0 is 16.5
// Sum of the elements at column 1 is 9.0
// Sum of the elements at column 2 is 13.0
// Sum of the elements at column 3 is 13.0
// Class Name: Exercise08_01
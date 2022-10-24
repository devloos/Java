import java.util.Scanner;

public class Exercise09_13 {
  public static Location locateLargest(double[][] matrix) {
    Location location = new Location(0, 0, matrix[0][0]);

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] > location.maxValue_) {
          location.row_ = row;
          location.col_ = col;
          location.maxValue_ = matrix[row][col];
        }
      }
    }

    return location;
  }
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns in the array: ");

    final int nRows = cin.nextInt();
    final int nCols = cin.nextInt();
    double[][] matrix = new double[nRows][nCols];

    System.out.println("Enter the array:");
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = cin.nextDouble();
      }
    }

    Location location = locateLargest(matrix);
    System.out.println("The largest element is " + location.maxValue_ + ", located at (" + location.row_ + ", " + location.col_ + ")");


    cin.close();
  }
};

class Location {
  public int row_ = 0;
  public int col_ = 0;
  public double maxValue_ = 0;

  public Location(int row, int col, double maxValue) {
    row_ = row;
    col_ = col;
    maxValue_ = maxValue;
  }
};

// (The Location class) 
// Design a class named Location for locating a maximal value and its location in a two-dimensional array.
// The class contains public data fields row,column, and maxValue that store the 
// maximal value and its indices in a two-dimensional array with row and column as int types and maxValue as a double type.
// Write the following method that returns the location of the largest element in a two-dimensional array:
// public static Location locateLargest(double[][] a)
// The return value is an instance of Location.
// Write a test program that prompts the user to enter a two-dimensional array and displays the location of the largest element in the array.
// If there are more than one largest element, find the location with the smallest row index and then the smallest column index.
// Sample Run
// Enter the number of rows and columns in the array:  3 4
// Enter the array:
// 23.5  35  2  10
// 4.5   3  45  3.5
// 35   44  5.5  9.6
// The largest element is 45, located at (1, 2)
// Class Name: Exercise09_13
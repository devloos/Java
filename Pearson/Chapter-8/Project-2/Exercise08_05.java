import java.util.Scanner;

public class Exercise08_05 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    double[][] matrix1 = new double[3][3];
    double[][] matrix2 = new double[3][3];
    double[][] result = new double[3][3];

    System.out.print("Enter matrix1: ");
    matrixInput(cin, matrix1);
    System.out.print("Enter matrix2: ");
    matrixInput(cin, matrix2);

    addMatrices(matrix1, matrix2, result);

    System.out.println("The addition of the matrices is");
    printMatrices(matrix1, matrix2, result);
    cin.close();
    System.exit(0);
  }

  public static void matrixInput(Scanner cin, double[][] matrix) {
    for (int row = 0; row < matrix.length; row++)
      for (int col = 0; col < matrix[row].length; col++) 
        matrix[row][col] = cin.nextDouble();
  }

  public static void addMatrices(double[][] matrix1, double[][] matrix2, double[][] result) {
    for (int row = 0; row < 3; row++)
      for (int col = 0; col < 3; col++)
        result[row][col] = matrix1[row][col] + matrix2[row][col];
  }

  public static void printMatrices(double[][] matrix1, double[][] matrix2, double[][] result) {
    for (int row = 0; row < 3; row++) {
      printRow(matrix1, row);
      if (row == 1) System.out.print("+");
      printRow(matrix2, row);
      if (row == 1) System.out.print("=");
      printRow(result, row);
      System.out.println();
    }
  }

  public static void printRow(double[][] matrix, int row) {
    for (int col = 0; col < matrix[row].length; col++) {
      System.out.print(matrix[row][col] + ((col + 1 < matrix[row].length) ? " " : ""));
    }
    System.out.print("\t");
  }
}
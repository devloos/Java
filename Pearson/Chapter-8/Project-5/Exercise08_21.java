import java.util.Scanner;

public class Exercise08_21 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter the number of cities: ");
    final int nCities = cin.nextInt();

    double[][] matrix = new double[nCities][2];
    System.out.print("Enter the coordinates of the cities: ");
    for (int row = 0; row < matrix.length; row++)
      for (int col = 0; col < 2; col++)
        matrix[row][col] = cin.nextDouble();
    
    double smallestSum = Double.MAX_VALUE;
    int smallestIndex = 0;
    for (int row = 0; row < matrix.length; row++) {
      double sum = 0;
      for (int i = 0; i < matrix.length; i++) {
        sum += Math.sqrt(Math.pow((matrix[i][0] - matrix[row][0]), 2) + Math.pow((matrix[i][1] - matrix[row][1]), 2));
      }
      if (sum < smallestSum) {
        smallestSum = sum;
        smallestIndex = row;
      }
    }

    System.out.println("The central city is at (" + matrix[smallestIndex][0] + ", " + matrix[smallestIndex][1] + ")");
    System.out.printf("The total distance to all other cities is %4.2f", smallestSum);

    cin.close();
  }
}

// (Central city) 
// Given a set of cities, the central city is the city that has the shortest total distance to all other cities.
// Write a program that prompts the user to enter the number of the cities and the locations of the cities (coordinates), 
// and finds the central city and its total distance to all other cities.
// Sample Run
// Enter the number of cities: 5
// Enter the coordinates of the cities:  2.5 5  5.1 3  1 9  5.4 54  5.5 2.1
// The central city is at (2.5, 5.0)
// The total distance to all other cities is 60.81
// Class Name: Exercise08_21
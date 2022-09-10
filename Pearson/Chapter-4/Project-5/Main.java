import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    final int HorizontalLimit = 10 / 2;
    final double VerticalLimit = 5.0 / 2;
    Scanner cin = new Scanner(System.in);

    System.out.print("Enter a point with two coordinates: ");
    double x = cin.nextDouble();
    double y = cin.nextDouble();

    // final double Distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    final String Response = (Math.abs(x) <= HorizontalLimit && Math.abs(y) <= VerticalLimit) ? " is in the rectangle" : " is not in the rectangle";

    System.out.print("Point (" + x + ", " + y + ")" + Response);
    cin.close();
  }
}

// Geometry: point in a rectangle?) 
// Write a program that prompts the user to enter a point (x, y) 
// and checks whether the point is within the rectangle centered at(0, 0) with width 10 and height 5.
// For example, (2, 2)is inside the rectangle and(6, 4) is outside the rectangle.
// (Hint: A point is in the rectangle if its horizontal distance to (0, 0) 
// is less than or equal to10 / 2 and its vertical distance to (0, 0) is less than or equal to 5.0 / 2.

// Sample Run 1
// Enter a point with two coordinates: 2 2
// Point (2.0, 2.0) is in the rectangle 

// Sample run 2
// Enter a point with two coordinates: 6 4
// Point (6.0, 4.0) is not in the rectangle

// Sample Run 3
// Enter a point with two coordinates: -5.1 -2.4 
// Point (-5.1, -2.4) is not in the rectangle 

// Sample Run 4
// Enter a point with two coordinates: -4.9 2.49
// Point (-4.9, 2.49) is in the rectangle 

// Sample Run 5
// Enter a point with two coordinates: -4.99 -2.499
// Point (-4.99, -2.499) is in the rectangle 
// Class Name: Exercise03_23

import java.util.Scanner;

class Exercise04_05 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int numberOfSides = 0;
    double sideLength = 0.0;


    System.out.print("Enter the number of sides: ");
    numberOfSides = cin.nextInt();
    System.out.print("Enter the length of the side: ");
    sideLength = cin.nextDouble();

    final double area = (numberOfSides * Math.pow(sideLength, 2)) / (4 * (Math.tan(Math.PI / numberOfSides)));

    System.out.println("The area of the polygon is " + area);

    cin.close();
  }
}

// (Geometry: area of a regular polygon) 
// A regular polygon is an n-sided polygon in which all sides are of the same length 
// and all angles have the same degree (i.e., the polygon is both equilateral and equiangular). 
// The formula for computing the area of a regular polygon is :
// area = n * s ^ 2 / (4 * tan(pi / n))
// Here, s is the length of a side.
// Write a program that prompts the user to enter the number of sides and their length, and displays its area.
// Sample Run
// Enter the number of sides: 5
// Enter the length of the side: 6.5
// The area of the polygon is 72.69017017488385
// Class Name: Exercise04_05
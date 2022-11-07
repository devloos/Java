import java.util.Scanner;

public class Exercise11_15 {

  public static double distance(Vector2 p1, Vector2 p2) {
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }

  public static double findRadius(Vector2[] coordinates) {
    // double largestDistance = 0.0;

    // for (int i = 1; i < coordinates.length; i++) {
    // double n = distance(coordinates[i - 1], coordinates[i]);

    // if (n > largestDistance) {
    // largestDistance = n;
    // }
    // }

    // return largestDistance / 2;

    return findLength(coordinates) / (2 * Math.tan(180.0 / coordinates.length));
  }

  public static double findLength(Vector2[] coordinates) {
    return distance(coordinates[0], coordinates[1]);
  }

  public static double findArea(int n, double length, double radius) {
    return ((double) n / 2) * length * radius;
  }

  public static double findApothem(Vector2[] coordinates, int n) {
    return findLength(coordinates) / (double) (2.0 * Math.tan(180.0 / n));
  }

  public static double findAreaUsingApothem(int n, double length, double apothem) {
    return (n * length * apothem) / 2.0;
  }

  public static double findAreaAnotherMethod(int n, double length) {
    return (1.0 / 4) * n * Math.pow(length, 2) * (1.0 / Math.tan(Math.PI / (double) n));
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print("Enter the number of points: ");
    final int N_POINTS = cin.nextInt();

    if (N_POINTS < 3) {
      System.out.println("NOT A POLYGON BYE!");
      System.exit(-1);
    }

    Vector2[] coordinates = new Vector2[N_POINTS];
    System.out.println("Enter the coordinates of the points: ");

    for (int i = 0; i < N_POINTS; i++) {
      coordinates[i] = new Vector2();
      coordinates[i].x = cin.nextDouble();
      coordinates[i].y = cin.nextDouble();
    }

    // final double RADIUS = findRadius(coordinates);
    // final double LENGTH = findLength(coordinates);
    // final double APOTHEM = findApothem(coordinates, N_POINTS);

    // https://www.geeksforgeeks.org/area-of-a-polygon-with-given-n-ordered-vertices/
    double area = 0;
    int j = N_POINTS - 1;
    for (int i = 0; i < N_POINTS; i++) {
      area += (coordinates[j].x + coordinates[i].x) * (coordinates[j].y - coordinates[i].y);
      j = i;
    }
    area = Math.abs(area / 2);
    System.out.printf("The total area is %5.3f", area);

    cin.close();
  }
};

class Vector2 {
  public double x = 0;
  public double y = 0;
};

// (Area of a convex polygon)
// A polygon is convex if it contains any line segment that connects two points
// of the polygon.
// Write a program that prompts the user to enter the number of points in a
// convex polygon,
// then enter the points clockwise, and display the area of the polygon.
// Sample Run
// Enter the number of points: 7
// Enter the coordinates of the points:
// -12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -5.5
// The total area is 244.575
// Class Name: Exercise11_15
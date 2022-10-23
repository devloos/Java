public class Exercise09_01 {
  public static void main(String[] args) {
    Rectangle rec1 = new Rectangle(4.0, 40.0);
    Rectangle rec2 = new Rectangle(3.5, 35.9);

    Rectangle.printTest(rec1);
    Rectangle.printTest(rec2);
  }
};

class Rectangle {
  private double width_ = 1;
  private double height_ = 1;

  public Rectangle() {}
  public Rectangle(double width, double height) {
    width_ = width;
    height_ = height;
  }

  public double getArea() {
    return width_ * height_;
  }

  public double getPerimeter() {
    return 2 * (width_ + height_);
  }

  public static void printTest(Rectangle rec) {
    System.out.println("The area of a rectangle with width " + rec.width_ + 
    " and height " + rec.height_ + " is " + rec.getArea());

    System.out.println("The perimeter of a rectangle is " + rec.getPerimeter());
  }
};


// (The Rectangle class) 
// Following the example of the Circle class in Section 9.2, 
// design a class named Rectangleto represent a rectangle.
// The class contains:
// - Two double data fields named width and height that specify the width and height of the rectangle. 
// The default values are 1 for both width and height.
// - A no-arg constructor that creates a default rectangle.
// - A constructor that creates a rectangle with the specified width and height.
// - A method named getArea() that returns the area of this rectangle.
// - A method named getPerimeter()that returns the perimeter.
// Draw the UML diagram for the class and then implement the class.
// Write a test program that creates two Rectangle objects—one with width 4 
// and height 40 and the other with width 3.5 and height 35.9.
// Display the width, height, area, and perimeter of each rectangle in this order.
// Sample Run
// The area of a rectangle with width 4.0 and height 40.0 is 160.0
// The perimeter of a rectangle is 88.0
// The area of a rectangle with width 3.5 and height 35.9 is 125.64999999999999
// The perimeter of a rectangle is 78.8
// Class Name: Exercise09_01

/**
 * @Author: Carlos Aguilera
 * @Date: 11-22-22
 * @id: 1152562
 * @brief
 * This is a program to exercise object oriented programming
 * I tried to touch the basics of what I learned in chapter 13
 * while still staying true to chapter 9
 * I have an abstract shape class that deals with one level 
 * of inheritance. Circle, Rectangle, and Square all inherit
 * from Shape and must implement getArea and getPerimeter.
 * Two functions to demo printing Area and Perimeter of all shapes
 */
import java.util.Scanner;

public class ExamFive {
  public static void demoArea(Circle c, Rectangle r, Square s) {
    System.out.println("Circle area: " + c.getArea());
    System.out.println("Square area: " + s.getArea());
    System.out.println("Rectangle area: " + r.getArea());
  }

  public static void demoPerimeter(Circle c, Rectangle r, Square s) {
    System.out.println("Circle perimeter: " + c.getPerimeter());
    System.out.println("Square perimeter: " + s.getPerimeter());
    System.out.println("Rectangle perimeter: " + r.getPerimeter());
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print(
        "Enter a SINGLE number. This will be used for the circle radius, the square's side, and one side of the rectangle: ");
    double single = cin.nextDouble();
    System.out.print("Enter the other side of the rectangle: ");
    double width = cin.nextDouble();

    cin.close();
    System.out.println();

    Circle c = new Circle(single);
    Rectangle r = new Rectangle(single, width);
    Square s = new Square(single);
    demoArea(c, r, s);
    System.out.println();
    demoPerimeter(c, r, s);
  }
};

// just for practice
abstract class Shape {
  public abstract double getPerimeter();

  public abstract double getArea();
};

class Rectangle extends Shape {
  private double length_ = 1.0;
  private double width_ = 1.0;

  public Rectangle() {
  }

  public Rectangle(double length, double width) throws IllegalArgumentException {
    validateArguments(length, width);
    length_ = length;
    width_ = width;
  }

  public double getLength() {
    return length_;
  }

  public void setLength(double length) throws IllegalArgumentException {
    validateArguments(length, width_);
    length_ = length;
  }

  public double getWidth() {
    return width_;
  }

  public void setWidth(double width) throws IllegalArgumentException {
    validateArguments(length_, width);
    width_ = width;
  }

  public double getPerimeter() {
    return (length_ * 2) + (width_ * 2);
  }

  public double getArea() {
    return length_ * width_;
  }

  // just quick validation on arguments
  private void validateArguments(double length, double width) throws IllegalArgumentException {
    if (length <= 0 || width <= 0) {
      throw new IllegalArgumentException("Length or width cannot be negative.");
    }
  }
}

class Square extends Shape {
  private double side_ = 1.0;

  public Square() {
  }

  public Square(double side) throws IllegalArgumentException {
    validateArguments(side);
    side_ = side;
  }

  public double getSideLength() {
    return side_;
  }

  public void setSideLength(double side) throws IllegalArgumentException {
    validateArguments(side);
    side_ = side;
  }

  public double getPerimeter() {
    return side_ * 4;
  }

  public double getArea() {
    return Math.pow(side_, 2);
  }

  // just quick validation on arguments
  private void validateArguments(double side) throws IllegalArgumentException {
    if (side <= 0) {
      throw new IllegalArgumentException("Side cannot be negative.");
    }
  }
}

class Circle extends Shape {
  private double radius_ = 1.0;

  public Circle() {
  }

  public Circle(double radius) throws IllegalArgumentException {
    validateArguments(radius);
    radius_ = radius;
  }

  public double getRadius() {
    return radius_;
  }

  public void setRadius(double radius) throws IllegalArgumentException {
    validateArguments(radius);
    radius_ = radius;
  }

  public double getPerimeter() {
    return 2 * Math.PI * radius_;
  }

  public double getArea() {
    return Math.PI * Math.pow(radius_, 2);
  }

  // just quick validation on arguments
  private void validateArguments(double radius) throws IllegalArgumentException {
    if (radius <= 0) {
      throw new IllegalArgumentException("Radius cannot be negative.");
    }
  }
}

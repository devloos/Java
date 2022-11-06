public class Exercise10_11 {
  public static void main(String[] args) {
    Circle2D c1 = new Circle2D(2.0, 2.0, 5.5);

    System.out.println(c1.getArea());
    System.out.println(c1.getPerimeter());
    System.out.println(c1.contains(3, 3));
    System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
  }
};

class Circle2D {
  private double x_ = 0.0f;
  private double y_ = 0.0f;
  private double radius_ = 1.0f;

  public Circle2D() {}

  public Circle2D(double x, double y, double radius) {
    x_ = x;
    y_ = y;
    radius_ = radius;
  }

  public double getArea() {
    return Math.PI * Math.pow(radius_, 2);
  }

  public double getPerimeter() {
    return 2 * Math.PI * radius_;
  }

  public boolean contains(double x, double y) {
    return distanceFromCenter(x, y) < radius_;
  }

  public boolean contains(Circle2D rhs) {
    return distanceFromCenter(rhs.x_, rhs.y_) < radius_ && rhs.radius_ < radius_;
  }

  public boolean overlaps(Circle2D rhs) {
    return distanceFromCenter(rhs.x_, rhs.y_) < radius_ + rhs.radius_;
  }

  private double distanceFromCenter(double x, double y) {
    return Math.sqrt(Math.pow((x_ - x), 2) + Math.pow((y_ - y), 2));
  }
};

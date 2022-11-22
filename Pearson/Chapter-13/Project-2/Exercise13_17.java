
/* You have to use the following template to submit to Revel.
   Note: To test the code using the CheckExerciseTool, you will submit entire code.
   To submit your code to Revel, you must only submit the code enclosed between
     // BEGIN REVEL SUBMISSION

     // END REVEL SUBMISSION
*/
import java.util.Scanner;

public class Exercise13_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first complex number: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    Complex c1 = new Complex(a, b);

    System.out.print("Enter the second complex number: ");
    double c = input.nextDouble();
    double d = input.nextDouble();
    Complex c2 = new Complex(c, d);

    System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
    System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
    System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
    System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
    System.out.println("|" + c1 + "| = " + c1.abs());

    Complex c3 = (Complex) c1.clone();
    System.out.println(c1 == c3);
    System.out.println(c3.getRealPart());
    System.out.println(c3.getImaginaryPart());
    Complex c4 = new Complex(4, -0.5);
    Complex[] list = { c1, c2, c3, c4 };
    java.util.Arrays.sort(list);
    System.out.println(java.util.Arrays.toString(list));

    input.close();
  }
}

// BEGIN REVEL SUBMISSION
class Complex implements Cloneable, Comparable<Complex> {
  private double a_ = 0.0;
  private double b_ = 0.0;

  public Complex(double a, double b) {
    a_ = a;
    b_ = b;
  }

  public Complex(double a) {
    a_ = a;
  }

  public Complex() {
    a_ = 0.0;
    b_ = 0.0;
  }

  @Override
  public String toString() {
    if (b_ == 0) {
      return a_ + "";
    }

    return a_ + " + " + b_ + "i";
  }

  @Override
  public int compareTo(Complex obj) {
    if (this.abs() > obj.abs()) {
      return 1;
    }

    if (this.abs() < obj.abs()) {
      return -1;
    }

    return 0;
  }

  @Override
  public Object clone() {
    return new Complex(a_, b_);
  }

  public String getRealPart() {
    return a_ + "";
  }

  public String getImaginaryPart() {
    return b_ + "";
  }

  public Complex add(Complex rhs) {
    return new Complex(a_ + rhs.a_, b_ + rhs.b_);
  }

  public Complex subtract(Complex rhs) {
    return new Complex(a_ - rhs.a_, b_ - rhs.b_);
  }

  public Complex multiply(Complex rhs) {
    return new Complex((a_ * rhs.a_) - (b_ * rhs.b_), (b_ * rhs.a_) + (a_ * rhs.b_));
  }

  public Complex divide(Complex rhs) {
    double den = Math.pow(rhs.a_, 2) + Math.pow(rhs.b_, 2);
    double real = ((a_ * rhs.a_) + (b_ * rhs.b_)) / den;
    double imag = ((b_ * rhs.a_) - (a_ * rhs.b_)) / den;
    return new Complex(real, imag);
  }

  public double abs() {
    return Math.sqrt(Math.pow(a_, 2) + Math.pow(b_, 2));
  }

}
// END REVEL SUBMISSION
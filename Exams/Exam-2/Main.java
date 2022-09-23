import java.util.Scanner;
import java.util.InputMismatchException;


class Main {
  public static void main(String[] args) {
    final int EXIT_SUCCESS = 0;
    Scanner cin = new Scanner(System.in);

    do {
      int loanAmount = loanAmountValidation(cin);
      if (loanAmount == EXIT_SUCCESS) {
        System.out.println("THANK YOU FOR USING THE MORTGAGE CALCULATOR!!");
        cin.close();
        System.exit(EXIT_SUCCESS);
      }

      double interestRate = doubleValidation("interest rate", cin);
      int term = termValidation(cin);

      displayInput(loanAmount, interestRate, term);

      displayResult(loanAmount, interestRate, term);
    } while (true);
  }

  public static int termValidation(Scanner cin) {
    String msg = "Please enter a positive integer for the term in years: ";
    final String errMsg = "RETRY: Please enter a positive integer for the term in years: ";
    boolean validated = false;
    int val = 0;
    do {
      try {
        System.out.print(msg);
        val = cin.nextInt();
        if (val <= 0) {
          throw new InputMismatchException();
        }
        validated = true;
      } catch (InputMismatchException e) {
        msg = errMsg;
        cin.nextLine();
      }
    } while (!validated);
    return val;
  }

  public static int loanAmountValidation(Scanner cin) {
    String msg = "Please enter a positive integer for the loan amount: ";
    final String errMsg = "RETRY: Please enter a positive integer for the loan amount: ";
    boolean validated = false;
    int val = 0;
    do {
      try {
        System.out.print(msg);
        val = cin.nextInt();
        if (val < 0) {
          throw new InputMismatchException();
        }
        validated = true;
      } catch (InputMismatchException e) {
        msg = errMsg;
        cin.nextLine();
      }
    } while (!validated);
    return val;
  }

  public static double doubleValidation(String output, Scanner cin) {
    String msg = "Please enter a positive number for the " + output + ": ";
    final String errMsg = "RETRY: Please enter a positive number for the " + output + ": ";
    boolean validated = false;
    double val = 0.0f;
    do {
      try {
        System.out.print(msg);
        val = cin.nextDouble();
        if (val <= 0) {
          throw new InputMismatchException();
        }
        validated = true;
      } catch (InputMismatchException e) {
        msg = errMsg;
        cin.nextLine();
      }
    } while (!validated);
    return val;
  }

  public static double calcMonthlyPayment(int loanAmount, double interestRate, int term) {
    interestRate /= 1200;
    term *= 12;
    return loanAmount * (interestRate * Math.pow((1 + interestRate), term)) / (double)(Math.pow((1 + interestRate), term) - 1);
  }

  public static void displayInput(int loanAmount, double interestRate, int term) {
    System.out.println("\nFor a loan with these characteristics:");
    System.out.printf("\t$\s\s%d \n", loanAmount);
    System.out.printf("\t%4.2f annual interest rate\n", interestRate);
    System.out.printf("\t%d year term\n", term);
  }

  public static void displayResult(int loanAmount, double interestRate, int term) {
    final double monthlyPayment = calcMonthlyPayment(loanAmount, interestRate, term);
    final double totalPaid = monthlyPayment * (term * 12);
    final double totalInterest = totalPaid - loanAmount;

    System.out.printf("\nThe Monthly Payment = $\s\s%4.2f \n", monthlyPayment);
    System.out.printf("The Total Amount Paid = $%4.2f \n", totalPaid);
    System.out.printf("The Total Interest Paid = $%4.2f \n\n\n", totalInterest);
  }
}
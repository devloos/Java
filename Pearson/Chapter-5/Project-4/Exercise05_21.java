import java.util.Scanner;

class Exercise05_21 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    double total = 0;

    System.out.print("Loan Amount: ");
    double loanAmount = cin.nextDouble();
    System.out.print("Number of Years: ");
    int years = cin.nextInt();

    System.out.println("Interest Rate     Monthly Payment    Total Payment");
    for (double i = 5.0; i <= 8.0; i += (1.0/8)) {
      total = (((i / 100) * years) + 1) * loanAmount;
      System.out.printf("%1.3f%%            %3.2f             %5.2f", i, (total - loanAmount)/12, total);
      System.out.println();
    }

    cin.close();
  }
}

// (Financial application: compare loans with various interest rates)
// Write a program that lets the user enter the loan amount and loan period in number of years 
// and displays the monthly and total payments for each 
// interest rate starting from 5% to 8%, with an increment of 1/8.
// Sample Run 
// Loan Amount: 10000
// Number of Years: 5
// Interest Rate      Monthly Payment     Total Payment
// 5.000%             188.71              11322.74
// 5.125%             189.29              11357.13
// 5.250%             189.86              11391.59
// ....
// 7.875%             202.17              12129.97
// 8.000%             202.76              12165.84
// Class Name: Exercise05_21

import java.util.Scanner;

public class Exercise06_07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("The amount invested: ");
        double investmentAmount = cin.nextDouble();
        System.out.print("Annual interest rate: ");
        double annualInterest = cin.nextDouble();
        cin.close();
        
        System.out.println("Year Future Value");
        for (int i = 1; i <= 30; i++) {
            System.out.printf("%d \t %4.2f \n", i, futureInvestmentValue(investmentAmount, annualInterest, i));
        }
    }
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
            return investmentAmount * Math.pow(1 + (monthlyInterestRate / 1200.0), years * 12);
    }
}

public class Exercise06_07 {
    public static void main(String[] args) {
        double sum = 0;
        System.out.println("i \t m(i)");
        for (int i = 1; i <= 20; i++) {
            sum += m(i);
            System.out.printf("%d \t %f \n", i, sum);
        }
    }
    public static double m(int i) {
        return (double)i / (i + 1);
    }
}

import java.util.Scanner;

public class Exercise06_23 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = cin.nextLine();
        System.out.print("Enter a character: ");
        char c = cin.nextLine().charAt(0);
        System.out.print("The number of occurrences of " + c + " in " + str + " is " + count(str, c));
        cin.close();
    }

    public static int count(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) count++;
        }
        return count;
    }
}

import java.util.Scanner;

public class Exercise06_07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter time in milliseconds: ");
        long millis = cin.nextLong();
        cin.close();
        System.out.println(convertMiilis(millis));
        System.exit(0);
    }

    public static String convertMiilis(long millis) {
        long hours = millis / 3600000;
        millis %= 3600000;
        long minutes = millis / 60000;
        millis %= 60000;
        long seconds = millis / 1000;

        return hours + ":" + minutes + ":" + seconds;
    }
}

import java.util.Scanner;

public class Exercise06_07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int num = cin.nextInt();
        System.out.print("Enter an width: ");
        int width = cin.nextInt();

        System.out.println("The formatted number is " + format(num, width));

        cin.close();

    }
    public static String format(int num, int width) {
        String n = Integer.toString(num);
        if (n.length() >= width) return n;

        int length = width - n.length();
        for (int i = 0; i < length; i++) {
            n = "0" + n;
        }

        return n;
    }
}
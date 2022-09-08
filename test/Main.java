// import java.util.Scanner;

// class Exercise03_11 {
//     public static void main(String[] args) {
//         Scanner cin = new Scanner(System.in);
        
//         System.out.print("Enter a month in the year (e.g., 1 for Jan): ");
//         int Month = cin.nextInt()-1;
//         System.out.print("Enter a year: ");
//         int Year = cin.nextInt();
        
//         String[] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//         Integer[] Days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

//         boolean isLeapYearFormulaOne = (Year % 4 == 0 && Year % 100 != 0);
//         boolean isLeapYearFormulaTwo = (Year % 4 == 0 && Year % 100 == 0 && Year % 400 == 0);

//         if (isLeapYearFormulaOne || isLeapYearFormulaTwo) {
//             System.out.println(Months[Month] + " " + Year + " has 29 days");
//             return;
//         }
        
//         System.out.println(Months[Month] + " " + Year + " has " + Days[Month] + " days");
//     }
// }

import java.util.Scanner;

class Exercise03_21 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        System.out.print("Enter year: (e.g., 2012): ");
        int Year = cin.nextInt();
        System.out.print("Enter month: 1-12: ");
        int Month = cin.nextInt();
        switch (Month) {
            case 1: {
                Month = 13;
                --Year;
                break;
            }
            case 2: {
                Month = 14;
                --Year;
                break;
            }
            default: {
                break;
            }
        }
        System.out.print("Enter the day of the month: 1-31: ");
        int Day = cin.nextInt();
        
        String[] WeekDays = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        // (q + 26(m+1)/10 + k + k/4 + j/4 + 5j) % 7
        Day = ((Day + 26 * (Month + 1) / 10) + (Year % 100) + (Year % 100) / 4 + (Year / 100) / 4 + 5 * (Year / 100)) % 7;
        System.out.print("Day of the week is " + WeekDays[Day]);
    }
    //public int Format(int & ) {
        
  //      res = (res == 1) ? 13 : res;
 //       res = (res == 2) ? 14 : res;
   //     return res;
   // }
}
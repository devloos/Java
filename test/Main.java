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
        Scanner input = new Scanner(System.in);

        int longest = 0;
        int count = 0;
        
        int len;

        while (input.hasNext()) {
            len = input.next().length();
            if (len == longest) {
                ++count;
            } else {
                count = 1;
            }
            longest = (len > longest) ? len : longest;
        }
    }
    //public int Format(int & ) {
        
  //      res = (res == 1) ? 13 : res;
 //       res = (res == 2) ? 14 : res;
   //     return res;
   // }
}
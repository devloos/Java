import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_13 {
  public static int indexOf(int startPos, Integer n, ArrayList<Integer> list) {
    for (int i = startPos; i < list.size(); i++) {
      if (list.get(i) == n) {
        return i;
      }
    }

    return -1;
  }

  public static void removeDuplicate(ArrayList<Integer> list) {
    for (int i = 0; i < list.size();) {
      int index = indexOf(i + 1, list.get(i), list);
      if (index != -1) {
        list.remove(index);
      } else {
        ++i;
      }
    }
  }

  public static void printResult(ArrayList<Integer> list) {
    System.out.print("The distinct integers are ");
    for (Integer n : list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();

    System.out.print("Enter ten integers: ");
    for (int i = 0; i < 10; i++) {
      list.add(cin.nextInt());
    }

    removeDuplicate(list);

    printResult(list);

    cin.close();
  }
};

// (Remove duplicates)
// Write a method that removes the duplicate elements from an array list of
// integers using the following header:
// public static void removeDuplicate(ArrayList<Integer> list)
// Write a test program that prompts the user to enter 10 integers to a list and
// displays the distinct integers in their input order separated by exactly one
// space.
// Sample Run 1
// Enter ten integers: 34 5 3 5 6 4 33 2 2 4
// The distinct integers are 34 5 3 6 4 33 2
// Sample Run 2
// Enter ten integers: 3 3 4 4 1 1 2 2 5 5
// The distinct integers are 3 4 1 2 5
// Sample Run 3
// Enter ten integers: 1 2 2 3 4 5 6 7 8 8
// The distinct integers are 1 2 3 4 5 6 7 8
// Sample Run 4
// Enter ten integers: 5 4 3 2 65 4 4 5 1 5
// The distinct integers are 5 4 3 2 65 1
// Class Name: Exercise11_13
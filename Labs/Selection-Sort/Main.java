import java.util.*;

public class Main {
public static void main(String[] args) {
  int[] array = {4, 13, 1, -3, 44, 12, 5, 3, 3, 5};
  System.out.println("ARRAY BEFORE SELECTION SORT: " + Arrays.toString(array));
  sort(array);
  System.out.println("ARRAY AFTER SELECTION SORT: " + Arrays.toString(array));
}

public static void sort(int[] array) {
  final int LEN = array.length;
  int smallestIndex = 0;

  for (int i = 0; i < LEN; i++) {
    smallestIndex = i;
    for (int j = i + 1; j < LEN; j++) {
      if (array[j] < array[smallestIndex]) {
        smallestIndex = j;
      }
    }

    if (smallestIndex != i) {
      int temp = array[i];
      array[i] = array[smallestIndex];
      array[smallestIndex] = temp;
    }
  }
}
}
import java.util.*;

class SumSlidingWindow {
  public static void main(String[] args) {
    int[] array = {2, 1, 3, 5, 15, 1, 4, 5, 6};
    int subArraySize = 3;
    System.out.println("The array: " + Arrays.toString(array));
    System.out.println("The largest sum is: " + largestSubArray(array, subArraySize));
  }

  public static int largestSubArray(int[] array, int subArraySize) {
    int largestSum = 0;
    int runningSum = 0;

    for (int i = 0; i <= array.length - subArraySize; i++) {

      runningSum += array[i];

      if (i >= subArraySize - 1) {
        if (runningSum > largestSum) {
          largestSum = runningSum;
        }
        runningSum -= array[i - subArraySize + 1];
      }
    }
    return largestSum;
  } 
}
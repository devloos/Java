import java.util.ArrayList;

class SlidingWindow {
  public static void main(String[] args) {
    final int windowRange = 5;
    double[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
    if (windowRange > arr.length) return;

    ArrayList<Double> output = new ArrayList<Double>();
    double sum = 0.0;
    final int arrRange = arr.length - windowRange + 1;

    // Set up
    for (int i = 0; i < windowRange; i++) {
      sum += arr[i];
    }
    output.add(sum / windowRange);

    // Algo
    for (int i = 1; i < arrRange; i++) {
      sum = sum - arr[i - 1] + arr[i + (windowRange - 1)];
      output.add(sum / windowRange);
    }

    // Print
    System.out.print("[ ");
    for (final Double avg : output) {
      System.out.print(avg + " ");
    }
    System.out.print("]");
  }
}
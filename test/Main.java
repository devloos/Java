public class Main {
  public static void main(String[] args) {
    final double SECONDS_IN_YEAR = 3.154e7;
    final double Birth = SECONDS_IN_YEAR / 7.0;
    final double Death = SECONDS_IN_YEAR / 13.0;
    final double Immigrant = SECONDS_IN_YEAR / 45.0;
    final double Total = (Birth - Death) + Immigrant;
    double Population = 312032486.0 + Total;

    System.out.println("Population after 1 year: " + Population);

    for (int i = 2; i <= 5; i++) {
      Population += Total;
      System.out.println("Population after " + i + " year: " + Population);
    }
  }
}

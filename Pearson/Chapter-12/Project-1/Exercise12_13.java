import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Exercise12_13 {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(new File(args[0]));
    int characters = 0;
    int words = 0;
    int lines = 0;
    while (input.hasNext()) {
      String line = input.nextLine();
      characters += line.length();

      Scanner s = new Scanner(line);
      while (s.hasNext()) {
        s.next();
        ++words;
      }
      s.close();
      ++lines;
    }
    System.out.println("File " + args[0] + " has");
    System.out.println(characters + " characters");
    System.out.println(words + " words");
    System.out.println(lines + " lines");
  }
}
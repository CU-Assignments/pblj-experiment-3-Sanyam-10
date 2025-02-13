import java.util.Scanner;

public class SquareRootCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number to calculate its square root: ");

    try {
      double number = scanner.nextDouble();
      if (number < 0) {
        throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
      }
      double squareRoot = Math.sqrt(number);
      System.out.println("The square root of " + number + " is " + squareRoot);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error: Please enter a valid number.");
    } finally {
      scanner.close();
    }
  }
}
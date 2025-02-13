import java.util.Scanner;

class InvalidPinException extends Exception {
  public InvalidPinException(String message) {
    super(message);
  }
}

class InsufficientBalanceException extends Exception {
  public InsufficientBalanceException(String message) {
    super(message);
  }
}

public class ATMWithdrawalSystem {
  private static final String CORRECT_PIN = "3192";
  private static double balance = 500000.00; // Initial balance

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your PIN: ");
    String enteredPin = scanner.nextLine();

    try {
      if (!enteredPin.equals(CORRECT_PIN)) {
        throw new InvalidPinException("Invalid PIN entered.");
      }

      System.out.print("Enter amount to withdraw: ");
      double amount = scanner.nextDouble();

      if (amount > balance) {
        throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
      }

      balance -= amount;
      System.out.println("Withdrawal successful! Please take your cash.");
    } catch (InvalidPinException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (InsufficientBalanceException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error: Please enter a valid amount.");
    } finally {
      System.out.println("Remaining balance: $" + balance);
      scanner.close();
    }
  }
}
package common.exception;

/**
 * This is the class for Invalid Transaction Amount Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class InvalidTransactionAmountException extends PaymentException {
  public InvalidTransactionAmountException() {
    super("ERROR: Invalid Transaction Amount!");
  }
}

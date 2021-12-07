package common.exception;

/**
 * This is the class for Invalid Card Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class InvalidCardException extends PaymentException {
  public InvalidCardException() {
    super("ERROR: Invalid card!");
  }
}

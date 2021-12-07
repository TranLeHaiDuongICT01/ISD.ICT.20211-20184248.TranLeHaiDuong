package common.exception;

/**
 * This is the class for Payment Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class PaymentException extends RuntimeException {
  public PaymentException(String message) {
    super(message);
  }
}

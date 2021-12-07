package common.exception;

/**
 * This is the class for Suspicious Transaction Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class SuspiciousTransactionException extends PaymentException {
  public SuspiciousTransactionException() {
    super("ERROR: Suspicious Transaction Report!");
  }
}

package common.exception;

/**
 * This is the class for Invalid Version Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class InvalidVersionException extends PaymentException {
  public InvalidVersionException() {
    super("ERROR: Invalid Version Information!");
  }
}

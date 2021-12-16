package common.exception;

/**
 * This is the class for Internal Server Error Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class InternalServerErrorException extends PaymentException {

  public InternalServerErrorException() {
    super("ERROR: Internal Server Error!");
  }

}
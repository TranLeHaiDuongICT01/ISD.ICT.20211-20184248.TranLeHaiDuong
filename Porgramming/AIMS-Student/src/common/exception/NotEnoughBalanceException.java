package common.exception;

/**
 * This is the class for Not Enough Balance Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class NotEnoughBalanceException extends PaymentException {

  public NotEnoughBalanceException() {
    super("ERROR: Not enough balance in card!");
  }

}

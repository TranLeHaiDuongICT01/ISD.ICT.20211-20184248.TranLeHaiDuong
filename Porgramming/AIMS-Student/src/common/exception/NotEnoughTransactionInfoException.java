package common.exception;

/**
 * This is the class for Not Enough Transaction Info Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class NotEnoughTransactionInfoException extends PaymentException {
  public NotEnoughTransactionInfoException() {
    super("ERROR: Not Enough Transcation Information");
  }
}

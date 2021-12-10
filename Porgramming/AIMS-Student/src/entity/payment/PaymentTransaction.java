package entity.payment;

/**
 * This is the class for object Payment Transaction.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("unused")
public class PaymentTransaction {
  private String errorCode;
  private CreditCard card;
  private String transactionId;
  private String transactionContent;
  private int amount;
  private String createdAt;

  /**
   * This is the constructor for the class PaymentTransaction.
   * <br>@param errorCode  the error code
   * <br>@param card  the credit card used {@link entity.payment.CreditCard}
   * <br>@param transactionId  the transaction id
   * <br>@param transactionContent  the content of transaction
   * <br>@param amount  the amount of money for transaction
   * <br>@param createdAt  the date of creation
   */
  public PaymentTransaction(String errorCode, CreditCard card, 
      String transactionId, String transactionContent,
      int amount, String createdAt) {
    super();
    this.errorCode = errorCode;
    this.card = card;
    this.transactionId = transactionId;
    this.transactionContent = transactionContent;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public String getErrorCode() {
    return errorCode;
  }
}

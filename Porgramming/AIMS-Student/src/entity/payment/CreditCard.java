package entity.payment;

/**
 * This is the class for object credit card.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("unused")
public class CreditCard {
  private String cardCode;
  private String owner;
  private int cvvCode;
  private String dateExpired;

  /**
   * This is the constructor for the class CreditCard.
   * <br>@param cardCode  the card code
   * <br>@param owner  the card holder name
   * <br>@param cvvCode  the card cvv code
   * <br>@param dateExpired  the card expiration date
   */
  public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
    super();
    this.cardCode = cardCode;
    this.owner = owner;
    this.cvvCode = cvvCode;
    this.dateExpired = dateExpired;
  }
}

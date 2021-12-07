package subsystem;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

/**
 * The {@code InterbankInterface} class is used to communicate with the.
 * {@link subsystem.InterbankSubsystem InterbankSubsystem} to make transaction
 * 
 * <br>@author hieud
 * 
 */
public interface InterbankInterface {

  /**
   * Pay order, and then return the payment transaction.
   * 
   * <br>@param card     - the credit card used for payment
   * <br>@param amount   - the amount to pay
   * <br>@param contents - the transaction contents
   * <br>@return {@link entity.payment.PaymentTransaction PaymentTransaction} - if the
   *         payment is successful
   * <br>@throws PaymentException      if responded with a pre-defined error code
   * <br>@throws UnrecognizedException if responded with an unknown error code or
   *                               something goes wrong
   */
  public abstract PaymentTransaction payOrder(CreditCard card, int amount, String contents)
      throws PaymentException, UnrecognizedException;

  /**
   * Refund, and then return the payment transaction.
   * 
   * <br>@param card     - the credit card which would be refunded to
   * <br>@param amount   - the amount to refund
   * <br>@param contents - the transaction contents
   * <br>@return {@link entity.payment.PaymentTransaction PaymentTransaction} - if the
   *         payment is successful
   * <br>@throws PaymentException      if responded with a pre-defined error code
   * <br>@throws UnrecognizedException if responded with an unknown error code or
   *                               something goes wrong
   */
  public abstract PaymentTransaction refund(CreditCard card, int amount, String contents)
      throws PaymentException, UnrecognizedException;

}

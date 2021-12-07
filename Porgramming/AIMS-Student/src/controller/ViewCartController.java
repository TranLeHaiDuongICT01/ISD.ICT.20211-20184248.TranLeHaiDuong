package controller;

import entity.cart.Cart;
import java.sql.SQLException;

/**
 * This class controls the flow of events when users view the Cart.
 * 
 * <br>@author nguyenlm
 */
public class ViewCartController extends BaseController {

  /**
   * This method checks the available products in Cart.
   * 
   * <br>@throws SQLException the sql exception {@link java.sql.SQLException}
   */
  public void checkAvailabilityOfProduct() throws SQLException {
    Cart.getCart().checkAvailabilityOfProduct();
  }

  /**
   * This method calculates the cart subtotal.
   * 
   * <br>@return subtotal
   */
  public int getCartSubtotal() {
    int subtotal = Cart.getCart().calSubtotal();
    return subtotal;
  }

}

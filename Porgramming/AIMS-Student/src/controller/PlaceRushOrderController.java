package controller;

/**
 * This is the class controlling rush order use case.
 * <br>@author ADMIN
 *
 */
public class PlaceRushOrderController extends PlaceOrderController {
  
  /**
   * This method validates expected time shipping.
   * <br>@param days  the number of days
   * <br>@return boolean
   */
  public boolean validateExpectedTime(int days) {
    if (days == 0 || days > 30) {
      return false;
    }
    return true;
  }
}

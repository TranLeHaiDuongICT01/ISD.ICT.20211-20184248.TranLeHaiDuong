package controller;

import common.exception.PlaceOrderException;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.order.OrderMedia;
import entity.order.RushOrder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;
import views.screen.popup.PopupScreen;

/**
 * This is the class controlling rush order use case.
 * <br>@author ADMIN
 *
 */
public class PlaceRushOrderController extends PlaceOrderController {
  
  /**
   * Just for logging purpose.
   */
  private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());
  
  @SuppressWarnings("unchecked")
  @Override
  public Order createOrder() throws SQLException {
    Order order = new Order();
    for (Object object : Cart.getCart().getListMedia()) {
      CartMedia cartMedia = (CartMedia) object;
      OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(), 
          cartMedia.getQuantity(), cartMedia.getPrice());
      order.getlstOrderMedia().add(orderMedia);
    }
    return new RushOrder(order.getlstOrderMedia());

  }
  
  
  @Override
  public int calculateShippingFee(Order order) {
    Random rand = new Random();
    RushOrder rushOrder = new RushOrder(order.getlstOrderMedia());
    if (!checkSupportedMedia(rushOrder)) {
      try {
        PopupScreen.error("No media chosen support rush order");
        System.out.println("No");
        throw new PlaceOrderException("No media chosen support rush order");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    int fees = (int) (((rand.nextFloat() * 10) / 100) * order.getAmount());
    fees += 100 * rushOrder.getListMediaSupportRushOrder().size();
    LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
    return fees;
  }
  
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
  
  /**
   * This method checks if there is any media that support rush order.
   * <br>@param days  the number of days
   * <br>@return boolean
   */
  public boolean checkSupportedMedia(Order order) {
    RushOrder rushOrder = new RushOrder(order.getlstOrderMedia());
    if (rushOrder.getListMediaSupportRushOrder().size() == 0) {
      return false;
    }
    return true;
  }
}

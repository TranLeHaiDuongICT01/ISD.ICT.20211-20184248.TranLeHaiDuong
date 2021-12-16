package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.order.OrderMedia;
import entity.order.RushOrder;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;


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
  
  @Override
  public int calculateShippingFee(Order order) {
    Random rand = new Random();
    RushOrder rushOrder = new RushOrder();
    rushOrder = (RushOrder) order;
    int fees = (int) (((rand.nextFloat() * 10) / 100) * order.getAmount());
    fees += 100 * rushOrder.getListMediaSupportRushOrder().size();
    LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
    return fees;
  }
}

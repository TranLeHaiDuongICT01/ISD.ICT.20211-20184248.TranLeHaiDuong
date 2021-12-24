package controller;

import common.exception.PlaceOrderException; 
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.logging.Logger;
import validateinformation.ValidateInfo;
import views.screen.popup.PopupScreen;

/**
 * This class controls the flow of place order usecase in our AIMS project.
 * 
 * <br>@author nguyenlm
 */
public class PlaceOrderController extends BaseController {

  /**
   * Just for logging purpose.
   */
  private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

  /**
   * This method checks the avalibility of product when user click PlaceOrder
   * button.
   * 
   * <br>@throws SQLException the SQL exception {@link java.sql.SQLException}
   */
  public void placeOrder() throws SQLException {
    Cart.getCart().checkAvailabilityOfProduct();
  }

  /**
   * This method creates the new Order based on the Cart.
   * 
   * <br>@return Order
   * <br>@throws SQLException the SQL exception {@link java.sql.SQLException}
   */
  @SuppressWarnings("unchecked")
  public Order createOrder() throws SQLException {
    Order order = new Order();
    for (Object object : Cart.getCart().getListMedia()) {
      CartMedia cartMedia = (CartMedia) object;
      OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(), 
          cartMedia.getQuantity(), cartMedia.getPrice());
      order.getlstOrderMedia().add(orderMedia);
    }
    return order;
  }

  /**
   * This method creates the new Invoice based on order.
   * 
   * <br>@param order the order class {@link entity.order.Order}
   * <br>@return Invoice
   */
  public Invoice createInvoice(Order order) {
    return new Invoice(order);
  }

  /**
   * This method takes responsibility for processing the shipping info from user.
   * 
   * <br>@param info the hash map information of delivery {@link java.util.HashMap}.
   * <br>@throws InterruptedException the interrupted exception
   *                              {@link java.lang.InterruptedException}
   * <br>@throws IOException          the IOE exception {@link java.io.IOException}
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException {
    LOGGER.info("Process Delivery Info");
    LOGGER.info(info.toString());
    validateDeliveryInfo(info);
  }

  /**
   * The method validates the info.
   * 
   * <br>@param info the hash map information of delivery {@link java.util.HashMap}
   * <br>@throws InterruptedException the interrupted exception
   *                              {@link java.lang.InterruptedException}
   * <br>@throws IOException          the IOE exception {@link java.io.IOException}
   */
  public void validateDeliveryInfo(HashMap<String, String> info) 
      throws InterruptedException, IOException {
    ValidateInfo validateInfo = new ValidateInfo();
    for (Entry<String, String> entry : info.entrySet()) {
      if (entry.getKey().equalsIgnoreCase("name")) {
        LOGGER.info("Validate " + entry.getKey() 
            + " in delivery info: \"" + entry.getValue() + "\"");
        if (!validateInfo.validateName(entry.getValue())) {
          PopupScreen.error("Invalid " + entry.getKey());
          throw new PlaceOrderException("Invalid " + entry.getKey());
        }
      }
      
      if (entry.getKey().equalsIgnoreCase("phone")) {
        LOGGER.info("Validate " + entry.getKey() 
            + " in delivery info: \"" + entry.getValue() + "\"");
        if (!validateInfo.validatePhoneNumber(entry.getValue())) {
          PopupScreen.error("Invalid " + entry.getKey());
          throw new PlaceOrderException("Invalid " + entry.getKey());
        }
      }
      
      if (entry.getKey().equalsIgnoreCase("address")) {
        LOGGER.info("Validate " + entry.getKey() 
            + " in delivery info: \"" + entry.getValue() + "\"");
        if (!validateInfo.validateAddress(entry.getValue())) {
          PopupScreen.error("Invalid " + entry.getKey());
          throw new PlaceOrderException("Invalid " + entry.getKey());
        }
      }
      
      if (entry.getKey().equalsIgnoreCase("province") && entry.getValue().equalsIgnoreCase("")) {
        PopupScreen.error("Please choose one province");
        throw new PlaceOrderException("Please choose one province");
      }
      
    }
  }

  /**
   * This method calculates the shipping fees of order.
   * 
   * <br>@param order the order class {@link entity.order.Order}
   * <br>@return shippingFee
   */
  public int calculateShippingFee(Order order) {
    Random rand = new Random();
    int fees = (int) (((rand.nextFloat() * 10) / 100) * order.getAmount());
    LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
    return fees;
  }
}

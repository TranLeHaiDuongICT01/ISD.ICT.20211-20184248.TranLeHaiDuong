package entity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.Configs;

/**
 * This is the class for object order.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("rawtypes")
public class Order {

  private int shippingFees;
  private List lstOrderMedia;
  private HashMap<String, String> deliveryInfo;

  public Order() {
    this.lstOrderMedia = new ArrayList<>();
  }

  public Order(List lstOrderMedia) {
    this.lstOrderMedia = lstOrderMedia;
  }

  
  @SuppressWarnings("unchecked")
  public void addOrderMedia(OrderMedia om) {
    this.lstOrderMedia.add(om);
  }

  public void removeOrderMedia(OrderMedia om) {
    this.lstOrderMedia.remove(om);
  }

  public List getlstOrderMedia() {
    return this.lstOrderMedia;
  }

  public void setlstOrderMedia(List lstOrderMedia) {
    this.lstOrderMedia = lstOrderMedia;
  }

  public void setShippingFees(int shippingFees) {
    this.shippingFees = shippingFees;
  }

  public int getShippingFees() {
    return shippingFees;
  }

  /**
   * This is a getter function of delivery info.
   * <br>@return HashMap  {@link java.util.HashMap}
   */
  public HashMap getDeliveryInfo() {
    HashMap<String, String> delivery = new HashMap<String, String>();
    delivery.putAll(deliveryInfo);
    return delivery;
  }

  @SuppressWarnings("unchecked")
  public void setDeliveryInfo(HashMap deliveryInfo) {
    this.deliveryInfo = deliveryInfo;
  }

  /**
   * This is the method to get total amount of price of all the media of the cart.
   * <br>@return int  the total amount of price
   */
  public int getAmount() {
    double amount = 0;
    for (Object object : lstOrderMedia) {
      OrderMedia om = (OrderMedia) object;
      amount += om.getPrice();
    }
    return (int) (amount + (Configs.PERCENT_VAT / 100) * amount);
  }

  /**
   * This is the method to get total amount of price of 
   * all the media of the cart that support rush order.
   * <br>@return int  the total amount of price
   */
  public int getNotSupportRushOrderAmount() {
    return 0;
  }
}

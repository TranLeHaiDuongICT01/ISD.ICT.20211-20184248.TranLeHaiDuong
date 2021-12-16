package entity.order;

import java.util.ArrayList;
import java.util.List;
import utils.Configs;

/**
 * This is class for rush order object.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings({"unused", "rawtypes"})
public class RushOrder extends Order {
  
  private List listMediaSupportRushOrder;
  private List listMediaNotSupportRushOrder;
  
  /**
   * This is the constructor of RushOrder class.
   */
  public RushOrder() {
    super();
    listMediaNotSupportRushOrder = new ArrayList();
    listMediaSupportRushOrder = new ArrayList();
  }
  
  /**
   * This is the constructor of RushOrder class.
   * <br>@param lstOrderMedia  The list of order media {@link entity.OrderMedia}
   */
  @SuppressWarnings("unchecked")
  public RushOrder(List lstOrderMedia) {
    super(lstOrderMedia);
    for (Object object : lstOrderMedia) {
      OrderMedia om = (OrderMedia) object;
      if (om.getMedia().isIfSupportRushOrder()) {
        listMediaSupportRushOrder.add(om);
      } else {
        listMediaNotSupportRushOrder.add(om);
      }
    }
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public void addOrderMedia(OrderMedia om) {
    if (om.getMedia().isIfSupportRushOrder()) {
      listMediaSupportRushOrder.add(om);
    } else {
      listMediaNotSupportRushOrder.add(om);
    }
  }
  
  @Override
  public void removeOrderMedia(OrderMedia om) {
    if (om.getMedia().isIfSupportRushOrder()) {
      listMediaSupportRushOrder.remove(om);
    } else {
      listMediaNotSupportRushOrder.remove(om);
    }
  }
  
  //  @Override
  //  public int getAmount() {
  //    // TODO Auto-generated method stub
  //    return super.getAmount();
  //  }

  public List getListMediaSupportRushOrder() {
    return listMediaSupportRushOrder;
  }

  public void setListMediaSupportRushOrder(List listMediaSupportRushOrder) {
    this.listMediaSupportRushOrder = listMediaSupportRushOrder;
  }

  public List getListMediaNotSupportRushOrder() {
    return listMediaNotSupportRushOrder;
  }

  public void setListMediaNotSupportRushOrder(List listMediaNotSupportRushOrder) {
    this.listMediaNotSupportRushOrder = listMediaNotSupportRushOrder;
  }
  
  @Override
  public int getNotSupportRushOrderAmount() {
    double amount = 0;
    for (Object object : listMediaNotSupportRushOrder) {
      OrderMedia om = (OrderMedia) object;
      amount += om.getPrice();
    }
    return (int) (amount + (Configs.PERCENT_VAT / 100) * amount);
  }
  
}

package entity.order;

import entity.media.Media;

/**
 * This is the class for the object OrderMedia.
 * <br>@author ADMIN
 *
 */
public class OrderMedia {

  private Media media;
  private int price;
  private int quantity;

  /**
   * This is the constructor for the class OrderMedia.
   * <br>@param media  the media object {@link entity.media.Media}
   * <br>@param quantity  the quantity chosen to order
   * <br>@param price  the price of the each media
   */
  public OrderMedia(Media media, int quantity, int price) {
    this.media = media;
    this.quantity = quantity;
    this.price = price;
  }

  @Override
  public String toString() {
    return "{" + "  media='" + media + "'" + ", "
        + "quantity='" + quantity + "'" + ", price='" + price + "'" + "}";
  }

  public Media getMedia() {
    return this.media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
  
  public boolean checkSupportRushOrder() {
    return this.media.isIfSupportRushOrder();
  }

}

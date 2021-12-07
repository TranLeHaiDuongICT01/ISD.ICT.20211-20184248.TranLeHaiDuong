package entity.cart;

import entity.media.Media;

/**
 * This is the class for the object CartMedia.
 * <br>@author ADMIN
 *
 */
public class CartMedia {

  private Media media;
  private int quantity;
  private int price;

  public CartMedia() {

  }

  /**
   * This is the constructor for the class CartMedia.
   * <br>@param media  the media object {@link entity.media.Media}
   * <br>@param cart  the cart object {@link entity.media.Media}
   * <br>@param quantity  the quantity of media in cart
   * <br>@param price  the price of media in cart
   */
  public CartMedia(Media media, Cart cart, int quantity, int price) {
    this.media = media;
    this.quantity = quantity;
    this.price = price;
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

  @Override
  public String toString() {
    return "{" + " media='" + media + "'" + ", quantity='" + quantity + "'" + "}";
  }

}

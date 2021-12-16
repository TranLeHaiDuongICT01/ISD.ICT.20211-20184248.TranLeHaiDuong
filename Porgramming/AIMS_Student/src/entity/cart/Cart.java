package entity.cart;

import common.exception.MediaNotAvailableException; 
import entity.media.Media;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**This is the class for the object Cart.
 * <br>@author ADMIN
 *
 */
public class Cart {

  private List<CartMedia> lstCartMedia;
  public static Cart cartInstance;

  /**
   * This is the method to get or create new cart instance.
   * <br>@return Cart
   */
  public static Cart getCart() {
    if (cartInstance == null) {
      cartInstance = new Cart();
    }
    return cartInstance;
  }

  private Cart() {
    lstCartMedia = new ArrayList<>();
  }

  public void addCartMedia(CartMedia cm) {
    lstCartMedia.add(cm);
  }

  public void removeCartMedia(CartMedia cm) {
    lstCartMedia.remove(cm);
  }

  @SuppressWarnings("rawtypes")
  public List getListMedia() {
    return lstCartMedia;
  }

  public void emptyCart() {
    lstCartMedia.clear();
  }

  /**
   * This is the method to get the number of media in cart.
   * <br>@return int
   */
  public int getTotalMedia() {
    int total = 0;
    for (Object obj : lstCartMedia) {
      CartMedia cm = (CartMedia) obj;
      total += cm.getQuantity();
    }
    return total;
  }

  /**
   * This is the method to get total price of all media in the cart.
   * <br>@return int
   */
  public int calSubtotal() {
    int total = 0;
    for (Object obj : lstCartMedia) {
      CartMedia cm = (CartMedia) obj;
      total += cm.getPrice() * cm.getQuantity();
    }
    return total;
  }

  /**
   * This is the method to check the availability of products in cart.
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public void checkAvailabilityOfProduct() throws SQLException {
    boolean allAvai = true;
    for (Object object : lstCartMedia) {
      CartMedia cartMedia = (CartMedia) object;
      int requiredQuantity = cartMedia.getQuantity();
      int availQuantity = cartMedia.getMedia().getQuantity();
      if (requiredQuantity > availQuantity) {
        allAvai = false;
      }
    }
    if (!allAvai) {
      throw new MediaNotAvailableException("Some media not available");
    }
  }

  /**
   * This is the method to check media id.
   * <br>@param media  the media object {@link entity.media.Media}
   * <br>@return CartMedia
   */
  public CartMedia checkMediaInCart(Media media) {
    for (CartMedia cartMedia : lstCartMedia) {
      if (cartMedia.getMedia().getId() == media.getId()) {
        return cartMedia;
      }
    }
    return null;
  }

}

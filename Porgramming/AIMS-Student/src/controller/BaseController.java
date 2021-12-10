package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import java.util.List;

/**
 * This class is the base controller for our AIMS project.
 * 
 * <br>@author nguyenlm
 */
public class BaseController {

  /**
   * The method checks whether the Media in Cart, if it were in, we will return
   * the CartMedia else return null.
   * 
   * <br>@param media the media class ({@link entity.media.Media}
   * <br>@return CartMedia or null
   */
  public CartMedia checkMediaInCart(Media media) {
    return Cart.getCart().checkMediaInCart(media);
  }

  /**
   * This method gets the list of items in cart.
   * 
   * <br>@return List[CartMedia]
   */
  @SuppressWarnings("rawtypes")
  public List getListCartMedia() {
    return Cart.getCart().getListMedia();
  }
}

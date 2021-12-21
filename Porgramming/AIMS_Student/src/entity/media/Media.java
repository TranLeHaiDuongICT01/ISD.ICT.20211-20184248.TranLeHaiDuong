package entity.media;

import entity.db.AimsDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import utils.Utils;

/**
 * The general media class, for another media it can be done by inheriting this class.
 * 
 * <br>@author nguyenlm
 */
public class Media {

  @SuppressWarnings("unused")
  private static Logger LOGGER = Utils.getLogger(Media.class.getName());

  protected Statement stm;
  protected int id;
  protected String title;
  protected String category;
  protected int value; // the real price of product (eg: 450)
  protected int price; // the price which will be displayed on browser (eg: 500)
  protected int quantity;
  protected String type;
  protected String imageUrl;
  protected boolean ifSupportRushOrder;

  /**
   * This is the constructor of Media class.
   * <br>@throws SQLException
   */
  public Media() throws SQLException {
    stm = AimsDb.getConnection().createStatement();
    // Initialize example
    ifSupportRushOrder = true;
  }

  /**
   * This is the constructor for the class Media.
   * <br>@param id  the media id
   * <br>@param title  the title name
   * <br>@param category  the category
   * <br>@param price  the price
   * <br>@param quantity  the quantity in stock
   * <br>@param type  the type
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public Media(int id, String title, String category, int price, 
      int quantity, String type) throws SQLException {
    this.id = id;
    this.title = title;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
    this.type = type;
    // Initialize example
    if (this.price > 60) {
      ifSupportRushOrder = true;
    } else {
      ifSupportRushOrder = false;
    }
    // stm = AimsDb.getConnection().createStatement();
  }

  /**
   * This is the method update and get the quantity of media in stock.
   * <br>@return int  the quantity of media in stock
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public int getQuantity() throws SQLException {
    int updatedQuantity = getMediaById(id).quantity;
    this.quantity = updatedQuantity;
    return updatedQuantity;
  }

  /**
   * This is the method to get media by id.
   * <br>@param id  the media id to get
   * <br>@return Media  the media entity {@link entity.media.Media}
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public Media getMediaById(int id) throws SQLException {
    String sql = "SELECT * FROM Media ;";
    Statement stm = AimsDb.getConnection().createStatement();
    ResultSet res = stm.executeQuery(sql);
    if (res.next()) {

      return new Media().setId(res.getInt("id")).setTitle(res.getString("title"))
          .setQuantity(res.getInt("quantity")).setCategory(res.getString("category"))
          .setMediaUrl(res.getString("imageUrl")).setPrice(res.getInt("price"))
          .setType(res.getString("type"))
          .setIfSupportRushOrder(res.getInt("price") > 60);
    }
    return null;
  }

  /**
   * This is the method to get all media from database.
   * <br>@return List  the list of Media
   * <br>@throws SQLException   {@link java.sql.SQLException}
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public List getAllMedia() throws SQLException {
    Statement stm = AimsDb.getConnection().createStatement();
    ResultSet res = stm.executeQuery("select * from Media");
    ArrayList medium = new ArrayList<>();
    while (res.next()) {
      Media media = new Media().setId(res.getInt("id")).setTitle(res.getString("title"))
          .setQuantity(res.getInt("quantity")).setCategory(res.getString("category"))
          .setMediaUrl(res.getString("imageUrl")).setPrice(res.getInt("price"))
          .setType(res.getString("type"))
          .setIfSupportRushOrder(res.getInt("price") > 60);
      medium.add(media);
    }
    return medium;
  }

  /**
   * This is the method to update the media.
   * <br>@param tbname  the table name in database
   * <br>@param id  the media id
   * <br>@param field  the media's field to update
   * <br>@param value  the value to update into
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public void updateMediaFieldById(String tbname, int id,
      String field, Object value) throws SQLException {
    Statement stm = AimsDb.getConnection().createStatement();
    if (value instanceof String) {
      value = "\"" + value + "\"";
    }
    stm.executeUpdate(" update " + tbname + " set" + " " 
        + field + "=" + value + " " + "where id=" + id + ";");
  }

  // getter and setter
  public int getId() {
    return this.id;
  }

  private Media setId(int id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public Media setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getCategory() {
    return this.category;
  }

  public Media setCategory(String category) {
    this.category = category;
    return this;
  }

  public int getPrice() {
    return this.price;
  }

  public Media setPrice(int price) {
    this.price = price;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public Media setMediaUrl(String url) {
    this.imageUrl = url;
    return this;
  }

  public Media setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public String getType() {
    return this.type;
  }

  public Media setType(String type) {
    this.type = type;
    return this;
  }
  
  public boolean isIfSupportRushOrder() {
    return ifSupportRushOrder;
  }

  public Media setIfSupportRushOrder(boolean ifSupportRushOrder) {
    this.ifSupportRushOrder = ifSupportRushOrder;
    return this;
  }

  @Override
  public String toString() {
    return "{" + " id='" + id + "'" + ", title='" + title + "'" + ", "
        + "category='" + category + "'" + ", price='" + price
        + "'" + ", quantity='" + quantity + "'" + ", type='" 
        + type + "'" + ", imageURL='" + imageUrl + "'" 
        + ", support rush order=" + "'" + ifSupportRushOrder + "'" + "}";
  }

}
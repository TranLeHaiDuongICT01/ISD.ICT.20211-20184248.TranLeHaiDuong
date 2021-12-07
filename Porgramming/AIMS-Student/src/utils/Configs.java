package utils;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * This is the global list of configs for the program.
 * <br>@author nguyenlm Contains the configs for AIMS Project
 */

public class Configs {

  // api constants
  public static final String GET_BALANCE_URL = "https://ecopark-system-api.herokuapp.com"
      + "/api/card/balance/118609_group1_2020";
  public static final String GET_VEHICLECODE_URL = "https://ecopark-system-api.herokuapp.com"
      + "/api/get-vehicle-code/1rjdfasdfas";
  public static final String PROCESS_TRANSACTION_URL = "https://ecopark-system-api.herokuapp.com"
      + "/api/card/processTransaction";
  public static final String RESET_URL = "https://ecopark-system-api.herokuapp.com" + "/api/card/reset";

  // demo data
  public static final String POST_DATA = "{" + " \"secretKey\": \"BUXj/7/gHHI=\" "
      + "," + " \"transaction\": {" + " \"command\": \"pay\" "
          + "," + " \"cardCode\": \"118609_group1_2020\" ," + " \"owner\": \"Group 1\" "
              + "," + " \"cvvCode\": \"185\" ," + " \"dateExpried\": \"1125\" "
                  + "," + " \"transactionContent\": \"Pei debt\" "
                      + "," + " \"amount\": 50000 " + "}" + "}";
  public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ey"
      + "JfaWQiOiIxMTg2MDlfZ3JvdXAxXzIwMjAiLCJpYXQiOjE1OTkxMT"
      + "k5NDl9.y81pBkM0pVn31YDPFwMGXXkQRKW5RaPIJ5WW5r9OW-Y";

  // database Configs
  public static final String DB_NAME = "aims";
  public static final String DB_USERNAME = System.getenv("DB_USERNAME");
  public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

  public static String CURRENCY = "VND";
  public static float PERCENT_VAT = 10;

  // static resource
  public static final String IMAGE_PATH = "assets/images";
  public static final String INVOICE_SCREEN_PATH = "/views/fxml/invoice.fxml";
  public static final String INVOICE_MEDIA_SCREEN_PATH = "/views/fxml/media_invoice.fxml";
  public static final String PAYMENT_SCREEN_PATH = "/views/fxml/payment.fxml";
  public static final String RESULT_SCREEN_PATH = "/views/fxml/result.fxml";
  public static final String SPLASH_SCREEN_PATH = "/views/fxml/splash.fxml";
  public static final String CART_SCREEN_PATH = "/views/fxml/cart.fxml";
  public static final String SHIPPING_SCREEN_PATH = "/views/fxml/shipping.fxml";
  public static final String CART_MEDIA_PATH = "/views/fxml/media_cart.fxml";
  public static final String HOME_PATH = "/views/fxml/home.fxml";
  public static final String HOME_MEDIA_PATH = "/views/fxml/media_home.fxml";
  public static final String POPUP_PATH = "/views/fxml/popup.fxml";

  public static Font REGULAR_FONT = Font.font("Segoe UI", 
      FontWeight.NORMAL, FontPosture.REGULAR, 24);

  public static String[] PROVINCES = { "Bac Giang", "Bac Kan", "Cao Bang", "Ha Giang", "Lang Son", 
      "Phu Tho", "Quang Ninh", "Thai Nguyen", "Tuyen Quang", "Yen Bai", "Dien Bien", "Hoa Binh", 
      "Lai Chau", "Son La", "Bac Ninh", "Ha Nam", "Hai Duong", "Hung Yen", "Nam Dinh", "Ninh Binh", 
      "Thai Binh", "Vinh Phuc", "Ha Noi", "Hai Phong", "Ha Tinh", "Nghe An", "Quang Binh", 
      "Quang Tri", "Thanh Hoa", "Thua Thien-Hue", "Dak Lak", "Dak Nong", "Gia Lai",
      "Kon Tum", "Lam Dong", "Binh Dinh", "Binh Thuan", "Khanh Hoa", "Ninh Thuan", 
      "Phu Yen", "Quang Nam", "Quang Ngai", "Da Nang", "Ba Ria-Vung Tau", "Binh Duong", 
      "Binh Phuoc", "Dong Nai", "Tay Ninh", "Ho Chi Minh", "An Giang", "Bac Lieu", "Ben Tre", 
      "Ca Mau", "Dong Thap", "Hau Giang", "Kien Giang", "Long An", "Soc Trang", "Tien Giang", 
      "Tra Vinh", "Vinh Long", "Can Tho" };
}

package entity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import utils.Utils;

/**
 * This is the class for connecting database.
 * <br>@author ADMIN
 *
 */
public class Aimsdb {

  private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
  private static Connection connect;

  /**
   * This is the method to get connection to database.
   * <br>@return Connection  {@link java.sql.Connection}
   */
  public static Connection getConnection() {
    if (connect != null) {
      return connect;
    }
    try {
      Class.forName("org.sqlite.JDBC");
      String url = "jdbc:sqlite:assets/db/aims.db";
      connect = DriverManager.getConnection(url);
      LOGGER.info("Connect database successfully");
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
    }
    return connect;
  }

  public static void main(String[] args) {
    Aimsdb.getConnection();
  }
}

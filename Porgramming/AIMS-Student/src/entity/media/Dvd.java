package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * This is the class for object Dvd.
 * <br>@author ADMIN
 *
 */
public class Dvd extends Media {

  String discType;
  String director;
  int runtime;
  String studio;
  String subtitles;
  Date releasedDate;
  String filmType;

  public Dvd() throws SQLException {

  }

  /**
   * This is the constructor for the class Dvd.
   * <br>@param id  the dvd id
   * <br>@param title  the dvd title
   * <br>@param category  the dvd category
   * <br>@param price  the price
   * <br>@param quantity  the quantity in stock
   * <br>@param type  the type
   * <br>@param discType  the disc type
   * <br>@param director  the director name
   * <br>@param runtime  the runtime
   * <br>@param studio  the studio name
   * <br>@param subtitles  the subtitles
   * <br>@param releasedDate  the release date
   * <br>@param filmType  the film type
   * <br>@throws SQLException  @{@link java.sql.SQLException}
   */
  public Dvd(int id, String title, String category, int price, int quantity, String type, 
      String discType, String director, int runtime, String studio, String subtitles, 
      Date releasedDate, String filmType) throws SQLException {
    super(id, title, category, price, quantity, type);
    this.discType = discType;
    this.director = director;
    this.runtime = runtime;
    this.studio = studio;
    this.subtitles = subtitles;
    this.releasedDate = releasedDate;
    this.filmType = filmType;
  }

  public String getDiscType() {
    return this.discType;
  }

  public Dvd setDiscType(String discType) {
    this.discType = discType;
    return this;
  }

  public String getDirector() {
    return this.director;
  }

  public Dvd setDirector(String director) {
    this.director = director;
    return this;
  }

  public int getRuntime() {
    return this.runtime;
  }

  public Dvd setRuntime(int runtime) {
    this.runtime = runtime;
    return this;
  }

  public String getStudio() {
    return this.studio;
  }

  public Dvd setStudio(String studio) {
    this.studio = studio;
    return this;
  }

  public String getSubtitles() {
    return this.subtitles;
  }

  public Dvd setSubtitles(String subtitles) {
    this.subtitles = subtitles;
    return this;
  }

  public Date getReleasedDate() {
    return this.releasedDate;
  }

  public Dvd setReleasedDate(Date releasedDate) {
    this.releasedDate = releasedDate;
    return this;
  }

  public String getFilmType() {
    return this.filmType;
  }

  public Dvd setFilmType(String filmType) {
    this.filmType = filmType;
    return this;
  }

  @Override
  public String toString() {
    return "{" + super.toString() + " discType='" + discType + "'" + ", "
        + "director='" + director + "'" + ", runtime='" + runtime + "'" + ", "
            + "studio='" + studio + "'" + ", subtitles='" + subtitles + "'" + ", releasedDate='"
        + releasedDate + "'" + ", filmType='" + filmType + "'" + "}";
  }

  @Override
  public Media getMediaById(int id) throws SQLException {
    String sql = "SELECT * FROM " + "aims.DVD " + "INNER JOIN aims.Media " + "ON Media.id = DVD.id "
        + "where Media.id = " + id + ";";
    ResultSet res = stm.executeQuery(sql);
    if (res.next()) {

      // from media table
      String title = "";
      String type = res.getString("type");
      int price = res.getInt("price");
      String category = res.getString("category");
      int quantity = res.getInt("quantity");

      // from DVD table
      String discType = res.getString("discType");
      String director = res.getString("director");
      int runtime = res.getInt("runtime");
      String studio = res.getString("studio");
      String subtitles = res.getString("subtitle");
      Date releasedDate = res.getDate("releasedDate");
      String filmType = res.getString("filmType");

      return new Dvd(id, title, category, price, quantity, type, discType, 
          director, runtime, studio, subtitles, releasedDate, filmType);

    } else {
      throw new SQLException();
    }
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List getAllMedia() {
    return null;
  }
}

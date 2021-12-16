package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * This is the class for object CD.
 * <br>@author ADMIN
 *
 */
public class Cd extends Media {

  String artist;
  String recordLabel;
  String musicType;
  Date releasedDate;

  public Cd() throws SQLException {

  }

  /**
   * This is the constructor for class Cd.
   * <br>@param id  the CD id
   * <br>@param title  the CD title
   * <br>@param category  the CD category
   * <br>@param price  the CD price
   * <br>@param quantity  the quantity in stock
   * <br>@param type  the type name
   * <br>@param artist  the artist name
   * <br>@param recordLabel  the record label
   * <br>param musicType  the music type
   * <br>@param releasedDate  the release date
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public Cd(int id, String title, String category, int price, int quantity, String type,
      String artist, String recordLabel, String musicType, Date releasedDate) throws SQLException {
    super(id, title, category, price, quantity, type);
    this.artist = artist;
    this.recordLabel = recordLabel;
    this.musicType = musicType;
    this.releasedDate = releasedDate;
  }

  public String getArtist() {
    return this.artist;
  }

  public Cd setArtist(String artist) {
    this.artist = artist;
    return this;
  }

  public String getRecordLabel() {
    return this.recordLabel;
  }

  public Cd setRecordLabel(String recordLabel) {
    this.recordLabel = recordLabel;
    return this;
  }

  public String getMusicType() {
    return this.musicType;
  }

  public Cd setMusicType(String musicType) {
    this.musicType = musicType;
    return this;
  }

  public Date getReleasedDate() {
    return this.releasedDate;
  }

  public Cd setReleasedDate(Date releasedDate) {
    this.releasedDate = releasedDate;
    return this;
  }

  @Override
  public String toString() {
    return "{" + super.toString() + " artist='" + artist + "'" + ", recordLabel='" + recordLabel 
        + "'" + "'" + ", musicType='" + musicType + "'" + ", "
            + "releasedDate='" + releasedDate + "'" + "}";
  }

  @Override
  public Media getMediaById(int id) throws SQLException {
    String sql = "SELECT * FROM " + "aims.CD " + "INNER JOIN aims.Media " 
        + "ON Media.id = CD.id " + "where Media.id = " + id + ";";
    ResultSet res = stm.executeQuery(sql);
    if (res.next()) {

      // from media table
      String title = "";
      String type = res.getString("type");
      int price = res.getInt("price");
      String category = res.getString("category");
      int quantity = res.getInt("quantity");

      // from CD table
      String artist = res.getString("artist");
      String recordLabel = res.getString("recordLabel");
      String musicType = res.getString("musicType");
      Date releasedDate = res.getDate("releasedDate");

      return new Cd(id, title, category, price, quantity, type, 
          artist, recordLabel, musicType, releasedDate);

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

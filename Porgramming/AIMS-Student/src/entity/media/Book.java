package entity.media;

import entity.db.Aimsdb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 * This is the class for the object Book.
 * <br>@author ADMIN
 *
 */
public class Book extends Media {

  String author;
  String coverType;
  String publisher;
  Date publishDate;
  int numOfPages;
  String language;
  String bookCategory;

  public Book() throws SQLException {

  }

  /**
   * This is the constructor for the class Book.
   * <br>@param id  the book id
   * <br>@param title  the book title
   * <br>@param category  the book category
   * <br>@param price  the book price
   * <br>@param quantity  the book quantity in stock
   * <br>@param type  the book type
   * <br>@param author  the book author name
   * <br>@param coverType  the book cover type
   * <br>@param publisher  the book publisher name
   * <br>@param publishDate  the book publish date
   * <br>@param numOfPages  the book number of pages
   * <br>@param language  the book language
   * <br>@param bookCategory  the book category
   * <br>@throws SQLException  {@link java.sql.SQLException}
   */
  public Book(int id, String title, String category, int price, int quantity, 
      String type, String author, String coverType, String publisher, Date publishDate, 
      int numOfPages, String language, String bookCategory) throws SQLException {
    super(id, title, category, price, quantity, type);
    this.author = author;
    this.coverType = coverType;
    this.publisher = publisher;
    this.publishDate = publishDate;
    this.numOfPages = numOfPages;
    this.language = language;
    this.bookCategory = bookCategory;
  }

  // getter and setter
  public int getId() {
    return this.id;
  }

  public String getAuthor() {
    return this.author;
  }

  public Book setAuthor(String author) {
    this.author = author;
    return this;
  }

  public String getCoverType() {
    return this.coverType;
  }

  public Book setCoverType(String coverType) {
    this.coverType = coverType;
    return this;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public Book setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

  public Date getPublishDate() {
    return this.publishDate;
  }

  public Book setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
    return this;
  }

  public int getNumOfPages() {
    return this.numOfPages;
  }

  public Book setNumOfPages(int numOfPages) {
    this.numOfPages = numOfPages;
    return this;
  }

  public String getLanguage() {
    return this.language;
  }

  public Book setLanguage(String language) {
    this.language = language;
    return this;
  }

  public String getBookCategory() {
    return this.bookCategory;
  }

  public Book setBookCategory(String bookCategory) {
    this.bookCategory = bookCategory;
    return this;
  }

  @Override
  public Media getMediaById(int id) throws SQLException {
    String sql = "SELECT * FROM " + "aims.Book " + "INNER JOIN aims.Media " 
        + "ON Media.id = Book.id " + "where Media.id = " + id + ";";
    Statement stm = Aimsdb.getConnection().createStatement();
    ResultSet res = stm.executeQuery(sql);
    if (res.next()) {

      // from Media table
      String title = "";
      String type = res.getString("type");
      int price = res.getInt("price");
      String category = res.getString("category");
      int quantity = res.getInt("quantity");

      // from Book table
      String author = res.getString("author");
      String coverType = res.getString("coverType");
      String publisher = res.getString("publisher");
      Date publishDate = res.getDate("publishDate");
      int numOfPages = res.getInt("numOfPages");
      String language = res.getString("language");
      String bookCategory = res.getString("bookCategory");

      return new Book(id, title, category, price, quantity, type, author, 
          coverType, publisher, publishDate, numOfPages, language, bookCategory);

    } else {
      throw new SQLException();
    }
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List getAllMedia() {
    return null;
  }

  @Override
  public String toString() {
    return "{" + super.toString() + " author='" + author + "'" + ", coverType='" + coverType + "'" 
        + ", publisher='" + publisher + "'" + ", publishDate='" + publishDate 
      + "'" + ", numOfPages='" + numOfPages + "'" + ", language='" + language + "'" + ", "
        + "bookCategory='" + bookCategory + "'" + "}";
  }
}

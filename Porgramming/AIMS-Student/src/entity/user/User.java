package entity.user;

/**
 * This is the class for object User.
 * <br>@author ADMIN
 *
 */
public class User {

  @SuppressWarnings("unused")
  private int id;
  private String name;
  private String email;
  private String address;
  private String phone;

  /**
   * This is the constructor for class User.
   * <br>@param id  the user id
   * <br>@param name  the user name
   * <br>@param email  the user email link
   * <br>@param address  the user address
   * <br>@param phone  the user phone number
   */
  public User(int id, String name, String email, String address, String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }

  // override toString method
  @Override
  public String toString() {
    return "{" + "  username='" + name + "'" + ", email='" + email + "'" + ", "
        + "address='" + address + "'" + ", phone='"
        + phone + "'" + "}";
  }

  // getter and setter
  public String getName() {
    return this.name;
  }

  public void setusername(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}

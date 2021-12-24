package validateinformation;

/**
 * Class used to validate information.
 * <br>@author ADMIN
 *
 */
public class ValidateInfo {
  /**
   * This is the method to validate phone number.
   * <br>@param phoneNumber  the string of phone number
   * <br>@return boolean
   */
  public boolean validatePhoneNumber(String phoneNumber) {
    if (phoneNumber.length() != 10) {
      return false;
    }
    if (!phoneNumber.startsWith("0")) {
      return false;
    }
    try {
      Integer.parseInt(phoneNumber);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * This is the method to validate name of user.
   * <br>@param phoneNumber  the string of user name
   * <br>@return boolean
   */
  public boolean validateName(String name) {
    // TODO: your work
    return name.matches("^[\\p{L} .'-]+$");
  }

  /**
   * This is the method to validate shipping address.
   * <br>@param phoneNumber  the string of shipping address
   * <br>@return boolean
   */
  public boolean validateAddress(String address) {
    return address.matches("\\d+\\s+[a-zA-Z]+");
  }
  
  /**
   * This method validates expected time shipping.
   * <br>@param days  the number of days
   * <br>@return boolean
   */
  public boolean validateExpectedTime(int days) {
    if (days == 0 || days > 30) {
      return false;
    }
    return true;
  }
}

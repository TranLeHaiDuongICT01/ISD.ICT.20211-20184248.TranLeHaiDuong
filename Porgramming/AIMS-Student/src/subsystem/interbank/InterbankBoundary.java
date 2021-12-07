package subsystem.interbank;

import common.exception.UnrecognizedException;
import utils.ApplicationProgrammingInterface;

/**
 * This is the class to request API to the bank.
 * <br>@author ADMIN
 *
 */
public class InterbankBoundary {

  String query(String url, String data) {
    String response = null;
    try {
      response = ApplicationProgrammingInterface.get(url, data);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      throw new UnrecognizedException();
    }
    return response;
  }

}

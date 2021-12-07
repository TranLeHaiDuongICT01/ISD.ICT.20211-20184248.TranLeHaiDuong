package common.exception;

/**
 * This is the class for Unrecognized Exception.
 * <br>@author ADMIN
 *
 */
@SuppressWarnings("serial")
public class UnrecognizedException extends RuntimeException {
  public UnrecognizedException() {
    super("ERROR: Something went wrowng!");
  }
}

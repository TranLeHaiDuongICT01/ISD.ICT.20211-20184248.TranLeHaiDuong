package testforplacerushordercontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.PlaceRushOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateNameTest {

  private PlaceRushOrderController placeRushOrderController;

  @BeforeEach
  void setUp() throws Exception {
    placeRushOrderController = new PlaceRushOrderController();
  }

  @ParameterizedTest
  @CsvSource({ "0123456789,true", "01234,false", "a123,false", "1234567890,false" })
  public void test(String phone, boolean expected) {
    // when
    boolean isValid = placeRushOrderController.validateName(phone);

    // then
    assertEquals(expected, isValid);
  }

}

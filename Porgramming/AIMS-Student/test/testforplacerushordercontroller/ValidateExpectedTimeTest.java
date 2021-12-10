package testforplacerushordercontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.PlaceRushOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateExpectedTimeTest {

  private PlaceRushOrderController placeRushOrderController;

  @BeforeEach
  void setUp() throws Exception {
    placeRushOrderController = new PlaceRushOrderController();
  }

  @ParameterizedTest
  @CsvSource({ "0,false", "5,true", "31,false" })
  void test(int days, boolean expected) {
    boolean isValid = placeRushOrderController.validateExpectedTime(days);
    assertEquals(expected, isValid);
  }

}

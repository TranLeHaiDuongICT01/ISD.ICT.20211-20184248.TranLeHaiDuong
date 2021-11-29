package TestForPlaceRushOrderController;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;
import controller.PlaceRushOrderController;

class validatePhoneNumberTest {
	private PlaceRushOrderController placeRushOrderController; 

	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
	@CsvSource({
		"0123456789,true",
		"01234,false",
		"a123,false",
		"1234567890,false"
	})
	public void test(String phone, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validatePhoneNumber(phone);
		
		//then
		assertEquals(expected, isValid);
	}

}

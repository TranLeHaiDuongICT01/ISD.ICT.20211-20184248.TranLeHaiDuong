package controller;

public class PlaceRushOrderController extends PlaceOrderController {
	public boolean validateExpectedTime(int days) {
		if(days==0||days>30) return false;
		return true;
	}
}

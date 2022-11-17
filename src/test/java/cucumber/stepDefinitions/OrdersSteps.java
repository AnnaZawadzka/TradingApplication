package cucumber.stepDefinitions;

import api.constants.OrderType;
import io.cucumber.java.en.When;

public class OrdersSteps {
	@When("^user \"([^\"]*)\" puts a \"([^\"]*)\" order for security \"([^\"]*)\" with a price of \"(\\d+)\" and quantity of \"(\\d+)\"$")
	public void user_puts_a_order_for_security_with_a_price_of_and_quantity_of
			(String user1, OrderType type, String security, int price1, int qty1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}

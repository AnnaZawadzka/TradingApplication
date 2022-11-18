package cucumber.stepDefinitions;

import api.constants.Context;
import api.constants.OrderType;
import api.service.OrderService;
import cucumber.TestContext;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrdersSteps {
	TestContext testContext;

	public OrdersSteps(TestContext context) {
		testContext = context;
	}

	@When("^user \"([^\"]*)\" puts a \"([^\"]*)\" order for security \"([^\"]*)\" with a price of \"(\\d+)\" and quantity of \"(\\d+)\"$")
	public void user_puts_a_order_for_security_with_a_price_of_and_quantity_of
			(String user, String type, String security, int price, int qty) {

		String securityId = testContext.scenarioContext.getContext(Context.findByValue(security))
				.toString();
		String userId = testContext.scenarioContext.getContext(Context.findByValue(user))
				.toString();

		new OrderService()
				.postTheOrder(price, qty, securityId, OrderType.valueOf(type), userId);
	}
}

package cucumber.stepDefinitions;

import api.constants.OrderType;
import api.dto.Security;
import api.dto.User;
import api.service.OrderService;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrdersSteps {
	private OrderService orderService;
	private ScenarioContext scenarioContext;

	public OrdersSteps(TestContext testContext) {
		orderService = testContext.getOrderService();
		scenarioContext = testContext.getScenarioContext();
	}

	@When("^user \"([^\"]*)\" puts a \"([^\"]*)\" order for security \"([^\"]*)\" with a price of \"(\\d+)\" and quantity of \"(\\d+)\"$")
	public void user_puts_a_order_for_security_with_a_price_of_and_quantity_of
			(String user, String type, String security, int price, int qty) {
		var securityId = ((Security) scenarioContext.getContext(security)).getId();

		var userId = ((User) scenarioContext.getContext(user)).getId();
		orderService
				.postTheOrder(price, qty, securityId, OrderType.valueOfType(type), userId);
	}
}

package cucumber;

import api.constants.Environment;
import api.service.OrderService;
import api.service.SecurityService;
import api.service.TradeService;
import api.service.UserService;
import lombok.Getter;

@Getter
public class TestContext {

	public ScenarioContext scenarioContext;
	private String BASE_URL = Environment.LOCAL.getBaseUrl();
	private OrderService orderService;
	private SecurityService securityService;
	private TradeService tradeService;
	private UserService userService;

	public TestContext() {
		orderService = new OrderService();
		securityService = new SecurityService();
		tradeService = new TradeService();
		userService = new UserService();
	}

//	public ScenarioContext getScenarioContext() {
//		return scenarioContext;
//	}

}

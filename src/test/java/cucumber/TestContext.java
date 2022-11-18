package cucumber;

import api.constants.Environment;
import api.service.OrderService;
import api.service.SecurityService;
import api.service.TradeService;
import api.service.UserService;

public class TestContext {

	//	public ScenarioContext scenarioContext;
	private String BASE_URL = Environment.LOCAL.getBaseUrl();
	private OrderService orderService;
	private SecurityService securityService;
	private TradeService tradeService;
	private UserService userService;
	private ScenarioContext scenarioContext;

	public TestContext() {
		orderService = new OrderService();
		securityService = new SecurityService();
		tradeService = new TradeService();
		userService = new UserService();
		scenarioContext = new ScenarioContext();
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public TradeService getTradeService() {
		return tradeService;
	}

	public UserService getUserService() {
		return userService;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}

package cucumber;

import api.service.OrderService;
import api.service.SecurityService;
import api.service.TradeService;
import api.service.UserService;

public class TestContext {

	private final OrderService orderService;
	private final SecurityService securityService;
	private final TradeService tradeService;
	private final UserService userService;
	private final ScenarioContext scenarioContext;

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

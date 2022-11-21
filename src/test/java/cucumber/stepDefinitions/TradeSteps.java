package cucumber.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;

import api.constants.ContextKey;
import api.dto.Order;
import api.service.TradeService;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.Then;

public class TradeSteps {

	private final TradeService tradeService;

	private final ScenarioContext scenarioContext;

	public TradeSteps(TestContext testContext) {
		tradeService = testContext.getTradeService();
		scenarioContext = testContext.getScenarioContext();
	}

	@Then("^a trade occurs with the price of \"(\\d+)\" and quantity of \"(\\d+)\"$")
	public void a_trade_occurs_with_the_price_of_and_quantity_of(int tradePrice, int tradeQty) {
		var orderBuyId = ((Order) scenarioContext.getContext(ContextKey.ORDER_BUY.key)).getId();
		var orderSellId = ((Order) scenarioContext.getContext(ContextKey.ORDER_SELL.key)).getId();
		var response = tradeService.getTradeByBuySellIdResponse(orderBuyId, orderSellId);
		assertEquals("Status code is 200", HttpStatus.SC_OK, response.getStatusCode());
		var tradeBuySell = tradeService.parseToTrade(response);
		assertEquals("Trade has a correct price", tradeBuySell.getPrice(),
				tradePrice, 0.1);
		assertEquals("Trade has a correct quantity", tradeBuySell.getQuantity(), tradeQty);
	}

	@Then("^a trade in not found$")
	public void a_trade_in_not_found() {
		var orderBuyId = ((Order) scenarioContext.getContext(ContextKey.ORDER_BUY.key)).getId();
		var orderSellId = ((Order) scenarioContext.getContext(ContextKey.ORDER_SELL.key)).getId();
		var response = tradeService.getTradeByBuySellIdResponse(orderBuyId, orderSellId);
		assertEquals("Status code is 404", HttpStatus.SC_NOT_FOUND, response.getStatusCode());
	}
}

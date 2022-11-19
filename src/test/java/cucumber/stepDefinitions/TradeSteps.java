package cucumber.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;

import api.dto.Order;
import api.dto.Trade;
import api.service.TradeService;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.Then;

public class TradeSteps {

	private TradeService tradeService;

	private ScenarioContext scenarioContext;

	public TradeSteps(TestContext testContext) {
		tradeService = testContext.getTradeService();
		scenarioContext = testContext.getScenarioContext();
	}

	@Then("^a trade occurs with the price of \"(\\d+)\" and quantity of \"(\\d+)\"$")
	public void a_trade_occurs_with_the_price_of_and_quantity_of(int tradePrice, int tradeQty) {
		var orderBuyId = ((Order) scenarioContext.getContext("buy")).getId();
		var orderSellId = ((Order) scenarioContext.getContext("sell")).getId();

		var response = tradeService.getTradeByBuySellId(orderBuyId, orderSellId);
		var tradeBuySell = response.getBody().as(Trade.class);
		assertEquals("Status code is 200", HttpStatus.SC_OK, response.getStatusCode());
		assertEquals("Trade has a correct price", tradeBuySell.getPrice(),
				response.getStatusCode());
		assertEquals("Trade has a correct quantity", tradeBuySell.getQuantity(), tradeQty);
	}
}

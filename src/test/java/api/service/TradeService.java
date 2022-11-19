package api.service;

import api.constants.TradingEndpoint;
import io.restassured.response.Response;

public class TradeService extends AbstractBaseService {

	public Response getTradeByBuySellId(String buyId, String sellId) {
		return pretendToBePostman()
				.pathParam("orderBuyId", buyId)
				.pathParam("orderSellId", sellId)
				.when()
				.get(TradingEndpoint.TRADE_BUY_SELL.getUrlFormat())
				.then()
				.extract()
				.response();
	}

}

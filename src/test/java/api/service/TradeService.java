package api.service;

import api.constants.TradingEndpoint;
import api.dto.Trade;
import io.restassured.response.Response;

public class TradeService extends AbstractBaseService {

	public Response getTradeByBuySellIdResponse(String buyId, String sellId) {
		return get(TradingEndpoint.TRADE_BUY_SELL, buyId, sellId);
	}

	public Trade parseToTrade(Response response) {
		return response.getBody().as(Trade.class);
	}
}

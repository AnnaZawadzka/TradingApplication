package api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TradingEndpoint {
	ORDERS("/api/orders"),
	ORDER("/api/orders/%d"),
	SECURITIES("/api/securities"),
	SECURITY("/api/securities/%d"),
	TRADES("/api/trades"),
	TRADE("/api/trades/%d"),
	TRADE_BUY_SELL("/api/trades/orderBuyId/{orderBuyId}/orderSellId/{orderSellId}"),
	USERS("/api/users"),
	USER("/api/users/%d");

	private final String urlFormat;

	public String getUrl(Environment envConfig, Object... params) {
		return envConfig.getBaseUrl() + getPath(params);
	}

	private String getPath(Object... params) {
		return String.format(urlFormat, params);
	}
}

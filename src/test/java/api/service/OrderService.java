package api.service;

import api.constants.OrderType;
import api.constants.TradingEndpoint;
import api.dto.Order;
import io.restassured.response.Response;

public class OrderService extends AbstractBaseService {

	public Response postTheOrder(int price, int quantity, String securityId, OrderType type,
			String userId) {
		var order = Order
				.builder()
				.price(price)
				.quantity(quantity)
				.securityId(securityId)
				.type(type)
				.userId(userId)
				.build();
		return post(TradingEndpoint.SECURITIES, order);
	}
}

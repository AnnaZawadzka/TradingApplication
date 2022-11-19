package api.service;

import api.constants.OrderType;
import api.constants.TradingEndpoint;
import api.dto.Order;
import io.restassured.response.Response;

public class OrderService extends AbstractBaseService {

	public Response createOrder(int price, int quantity, String securityId, OrderType type,
			String userId) {
		var order = Order
				.builder()
				.price(price)
				.quantity(quantity)
				.securityId(securityId)
				.type(type)
				.userId(userId)
				.fulfilled("false")
				.build();
		return post(TradingEndpoint.ORDERS, order);
	}

	public Order parseToOrder(Response response) {
		return response
				.getBody()
				.jsonPath()
				.getObject(".", Order.class);
	}
}

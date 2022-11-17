package api.service;

import api.constants.TradingEndpoint;
import api.dto.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserService extends AbstractBaseService {

	public RequestSpecification setUserPayload(String username, String password) {
		var user = User
				.builder()
				.username(username)
				.password(password)
				.build();
		return setBody(user);
	}

	public Response postTheUser(RequestSpecification requestSpecification) {
		return post(requestSpecification, TradingEndpoint.USERS);
	}
}

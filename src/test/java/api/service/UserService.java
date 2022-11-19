package api.service;

import java.util.List;
import java.util.Optional;

import api.constants.TradingEndpoint;
import api.dto.User;
import io.restassured.response.Response;

public class UserService extends AbstractBaseService {

	public User getOrCreateUser(String userName, String password) {
		Response response = get(TradingEndpoint.USERS);
		if (response.contentType().isBlank()) {
			createUser(userName, password);
			return getOrCreateUser(userName, password);
		}
		List<User> users = parseToUsers(response);
		Optional<User> user = getUserByName(users, userName);
		if (user.isPresent()) {
			return user.get();
		} else {
			createUser(userName, password);
			return getOrCreateUser(userName, password);
		}
	}

	public Response createUser(String userName, String password) {
		var security = User.builder()
				.username(userName)
				.password(password)
				.build();
		return post(TradingEndpoint.USERS, security);
	}

	private List<User> parseToUsers(Response response) {
		return response.jsonPath().getList(".", User.class);
	}

	private Optional<User> getUserByName(List<User> users, String userName) {
		return users.stream().filter(user -> user.getUsername().equals(userName))
				.findFirst();
	}
}

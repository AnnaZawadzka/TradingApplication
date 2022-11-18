package api.service;

import java.util.List;
import java.util.NoSuchElementException;

import api.constants.TradingEndpoint;
import api.dto.Security;
import api.dto.User;
import io.restassured.response.Response;

public class UserService extends AbstractBaseService {

	public static final TradingEndpoint USERS_URI = TradingEndpoint.USERS;

	public Response postTheUser(String username, String password) {
		var user = User
				.builder()
				.username(username)
				.password(password)
				.build();
		return post(USERS_URI, user);
	}

	public boolean checkIfUserExist(String name) {
		return getListOfUsers()
				.stream()
				.anyMatch(security -> security.getName().equals(name));
	}

	public List<Security> getListOfUsers() {
		return get(USERS_URI)
				.jsonPath()
				.getList(".", Security.class);
	}

	public String getUserIdByName(String name) {
		return getListOfUsers()
				.stream()
				.filter(user -> user
						.getName()
						.equals(name))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException(
						String.format("The object with name %s not found", name)))
				.getId();
	}
}

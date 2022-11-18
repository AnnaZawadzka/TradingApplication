package api.service;

import java.util.List;
import java.util.NoSuchElementException;

import api.constants.TradingEndpoint;
import api.dto.Security;
import io.restassured.response.Response;

public class SecurityService extends AbstractBaseService {

	public Response postTheSecurity(String name) {
		var security = Security
				.builder()
				.name(name)
				.build();
		return post(TradingEndpoint.SECURITIES, security);
	}

	public boolean checkIfSecurityExist(String name) {
		return getListOfSecurities()
				.stream()
				.anyMatch(security -> security.getName().equals(name));
	}

	public List<Security> getListOfSecurities() {
		return get(TradingEndpoint.SECURITIES)
				.jsonPath()
				.getList(".", Security.class);
	}

	public String getSecurityIdByName(String name) {
		return getListOfSecurities()
				.stream()
				.filter(security -> security
						.getName()
						.equals(name))
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException(
						String.format("The object with name %s not found", name)))
				.getId();
	}
}

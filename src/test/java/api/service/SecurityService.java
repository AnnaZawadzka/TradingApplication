package api.service;

import java.util.List;
import java.util.Optional;

import api.constants.TradingEndpoint;
import api.dto.Security;
import io.restassured.response.Response;

public class SecurityService extends AbstractBaseService {

	public Security getOrCreateSecurity(String securityName) {
		Response response = get(TradingEndpoint.SECURITIES);
		if (response.contentType().isBlank()) {
			createSecurity(securityName);
			return getOrCreateSecurity(securityName);
		}
		List<Security> securities = parseToSecurities(response);
		Optional<Security> security = getSecurityByName(securities, securityName);
		if (security.isPresent()) {
			return security.get();
		} else {
			createSecurity(securityName);
			return getOrCreateSecurity(securityName);
		}
	}

	private void createSecurity(String securityName) {
		var security = Security.builder().name(securityName).build();
		post(TradingEndpoint.SECURITIES, security);
	}

	private List<Security> parseToSecurities(Response response) {
		return response.jsonPath().getList(".", Security.class);
	}

	private Optional<Security> getSecurityByName(List<Security> securities, String securityName) {
		return securities.stream().filter(security -> security.getName().equals(securityName))
				.findFirst();
	}
}

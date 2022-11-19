package cucumber.stepDefinitions;

import api.dto.Security;
import api.dto.User;
import api.service.SecurityService;
import api.service.UserService;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommonSteps {

	private SecurityService securityService;
	private UserService userService;
	private ScenarioContext scenarioContext;

	public CommonSteps(TestContext testContext) {
		securityService = testContext.getSecurityService();
		userService = testContext.getUserService();
		scenarioContext = testContext.getScenarioContext();
	}

	@Given("^one security \"([^\"]*)\" and two users \"([^\"]*)\" and \"([^\"]*)\" exist$")
	public void one_security_and_two_users_and_exist(String securityName, String user1,
			String user2) {
		Security security = securityService.getOrCreateSecurity(securityName);
		scenarioContext.setContext(securityName, security);
		User diamond = userService.getOrCreateUser(user1, user1);
		scenarioContext.setContext(user1, diamond);
		User paper = userService.getOrCreateUser(user2, user2);
		scenarioContext.setContext(user2, paper);
	}
}

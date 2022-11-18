package cucumber.stepDefinitions;

import api.constants.Context;
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
	public void one_security_and_two_users_and_exist(String security, String user1, String user2) {
		if (securityService.checkIfSecurityExist(security))
			scenarioContext.setContext(Context.SECURITY_WSB_ID,
					securityService.getSecurityIdByName(security));
		else
			securityService.postTheSecurity(security);

		if (userService.checkIfUserExist(user1))
			scenarioContext.setContext(Context.USER_DIAMOND_ID,
					userService.getUserIdByName(user1));
		else
			userService.postTheUser(user1, user1);

		if (userService.checkIfUserExist(user2))
			scenarioContext.setContext(Context.USER_PAPER_ID,
					userService.getUserIdByName(user2));
		else
			userService.postTheUser(user2, user2);
	}
}

package cucumber.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;

import api.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserSteps {
	private final UserService userService = new UserService();
	private RequestSpecification requestSpecification;
	private Response response;

	@Given("^I have filled username with \"([^\"]*)\" and password with \"([^\"]*)\"$")
	public void i_have_filled_username_with_and_password_with(String username, String password) {
		requestSpecification = userService.setUserPayload(username, password);
	}

	@When("^I post the request$")
	public void i_post_the_request() {
		response = userService.postTheUser(requestSpecification);
	}

	@Then("^the user is created$")
	public void the_user_is_created() {
		assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
	}
}

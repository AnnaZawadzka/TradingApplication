package cucumber.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;

import api.service.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserSteps {
	private Response response;

	@When("^I have filled username with \"([^\"]*)\" and password with \"([^\"]*)\" and I post the request$")
	public void i_have_filled_username_with_and_password_with_and_i_post_the_request(
			String username, String password) {
		response = new UserService().postTheUser(username, password);
	}

	@Then("^the user is created$")
	public void the_user_is_created() {
		assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
	}
}

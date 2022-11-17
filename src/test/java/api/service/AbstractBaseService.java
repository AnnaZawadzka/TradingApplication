package api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import api.constants.Environment;
import api.constants.TradingEndpoint;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractBaseService {

	protected final Logger logger = LogManager.getLogger(this);
	private final Environment defaultEnv = Environment.LOCAL;

	protected RequestSpecification getRequestSpec() {
		var loggerPrintStream = IoBuilder.forLogger(logger).buildPrintStream();
		return RestAssured.given().baseUri(defaultEnv.getBaseUrl())
				.relaxedHTTPSValidation()
				.filter(RequestLoggingFilter.logRequestTo(loggerPrintStream))
				.filter(ResponseLoggingFilter.logResponseTo(loggerPrintStream))
				.log()
				.all()
				.response()
				.request();
	}

	protected RequestSpecification pretendToBePostman() {
		return getRequestSpec()
				.header("User-Agent", "PostmanRuntime/7.26.8")
				.accept(ContentType.ANY)
				.contentType(ContentType.JSON);
	}

	protected RequestSpecification setBody(Object object) {
		return pretendToBePostman().body(object);
	}

	protected Response get(RequestSpecification requestSpecification,
			TradingEndpoint tradingEndpoint) {
		return requestSpecification
				.get(tradingEndpoint.getUrl(defaultEnv))
				.then()
				.extract()
				.response();
	}

	protected Response get(TradingEndpoint tradingEndpoint) {
		return pretendToBePostman()
				.get(tradingEndpoint.getUrl(defaultEnv))
				.then()
				.extract()
				.response();
	}

	protected Response post(RequestSpecification requestSpecification,
			TradingEndpoint tradingEndpoint) {
		return requestSpecification
				.post(tradingEndpoint.getUrl(defaultEnv))
				.then()
				.extract()
				.response();
	}

	//	protected ResponseSpecification getResponseSpec() {
	//		return RestAssured.expect().response()
	//				.statusCode(HttpStatus.SC_OK);
	//	}

	//TODO: think if it's needed

	//		protected ExtractableResponse<? extends ResponseOptions<?>> get(String url,
	//				Map<String, ?> params) {
	//			return getRequestSpec()
	//					.params(params)
	//					.when()
	//					.get(url)
	//					.then()
	//					.spec(getResponseSpec())
	//					.extract();
	//		}

}

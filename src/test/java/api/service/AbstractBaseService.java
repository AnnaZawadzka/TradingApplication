package api.service;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import api.constants.Environment;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class AbstractBaseService {

	protected final Logger logger = LogManager.getLogger(this);
	private String defaultEnv = Environment.LOCAL.getBaseUrl();

	protected RequestSpecification getRequestSpec() {
		var loggerPrintStream = IoBuilder.forLogger(logger).buildPrintStream();
		return RestAssured.given().baseUri(defaultEnv)
				.relaxedHTTPSValidation()
				.filter(RequestLoggingFilter.logRequestTo(loggerPrintStream))
				.filter(ResponseLoggingFilter.logResponseTo(loggerPrintStream))
				.log()
				.all()
				.response()
				.spec(getResponseSpec())
				.request();
	}

	protected ResponseSpecification getResponseSpec() {
		return RestAssured.expect().response()
				.statusCode(HttpStatus.SC_OK);
	}

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

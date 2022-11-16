package api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Environment {
	LOCAL("http://localhost:8080"),
	TESTING("https://testing.env");

	private final String baseUrl;

	//TODO: handle some logger for Testing environment
}

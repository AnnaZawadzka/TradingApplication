package api.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@Builder
public class User {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;
	@NotBlank
	@ToString.Exclude
	String password;
	@NotBlank
	String username;
}

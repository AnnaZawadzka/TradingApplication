package api.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;
	@NotBlank
	@ToString.Exclude
	String password;
	@NotBlank
	String username;
}

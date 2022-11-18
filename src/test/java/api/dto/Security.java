package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
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
public class Security {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;

	@NotNull
	String name;
}

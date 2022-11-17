package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Security {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;
	@NotNull
	String name;
}

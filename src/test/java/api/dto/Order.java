package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import api.constants.OrderType;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;

	@NotNull
	String userId;

	@NotNull
	String securityId;

	@NotNull
	OrderType type;

	@NotNull
	double price;

	@NotNull
	int quantity;
}

package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import api.constants.OrderType;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@Builder
public class Order {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;

	String userId;

	String securityId;

	@NotNull
	OrderType type;

	@NotNull
	double price;

	@NotNull
	int quantity;

}

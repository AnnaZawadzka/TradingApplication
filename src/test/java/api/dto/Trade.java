package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@Builder
public class Trade {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;
	String orderSellId;
	String orderBuyId;

	@NotNull
	double price;

	@NotNull
	int quantity;
}

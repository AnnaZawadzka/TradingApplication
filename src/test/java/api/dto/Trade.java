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

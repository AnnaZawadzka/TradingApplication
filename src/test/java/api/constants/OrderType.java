package api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
	BUY("buy"),
	SELL("sell");

	private final String type;
}

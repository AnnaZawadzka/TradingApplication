package api.constants;

import lombok.Getter;

@Getter
public enum ContextKey {
	SECURITY_WSB("WSB"),
	USER_DIAMOND("Diamond"),
	USER_PAPER("Paper"),
	ORDER_BUY("buy"),
	ORDER_SELL("sell");

	public final String key;

	private ContextKey(String key) {
		this.key = key;
	}

	public static ContextKey valueOfKey(String key) {
		for (ContextKey contextKey : values()) {
			if (contextKey.key.equals(key)) {
				return contextKey;
			}
		}
		return null;
	}
}
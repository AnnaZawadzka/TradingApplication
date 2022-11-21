package api.constants;

public enum ContextKey {
	SECURITY_WSB("WSB"),
	SECURITY_A("A"),
	SECURITY_B("B"),
	USER_DIAMOND("Diamond"),
	USER_PAPER("Paper"),
	ORDER_BUY("buy"),
	ORDER_SELL("sell");

	public final String key;

	ContextKey(String key) {
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
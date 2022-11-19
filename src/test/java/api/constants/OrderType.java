package api.constants;

public enum OrderType {
	BUY("buy"),
	SELL("sell");

	private final String type;

	private OrderType(String type) {
		this.type = type;
	}

	public static OrderType valueOfType(String type) {
		for (OrderType orderType : values()) {
			if (orderType.type.equals(type)) {
				return orderType;
			}
		}
		return null;
	}
}

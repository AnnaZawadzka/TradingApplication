package api.constants;

public enum OrderType {
	BUY("buy"),
	SELL("sell");

	public final String type;

	OrderType(String type) {
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

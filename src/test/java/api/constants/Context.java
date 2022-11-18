package api.constants;

import lombok.Getter;

@Getter
public enum Context {
	SECURITY_WSB_ID,
	USER_DIAMOND_ID,
	USER_PAPER_ID;

	public static Context findByValue(String context) {
		for (Context contexts : values()) {
			if (contexts.name().equals(context)) {
				return contexts;
			}
		}
		return null;
	}
}

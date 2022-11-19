package cucumber;

import java.util.HashMap;
import java.util.Map;
import api.constants.ContextKey;

public class ScenarioContext {

	private Map<ContextKey, Object> scenarioContext;

	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}

	public void setContext(String key, Object value) {
		scenarioContext.put(ContextKey.valueOfKey(key), value);
	}

	public Object getContext(String key) {
		return scenarioContext.get(ContextKey.valueOfKey(key));
	}

	public Boolean isContains(String key) {
		return scenarioContext.containsKey(ContextKey.valueOfKey(key));
	}
}

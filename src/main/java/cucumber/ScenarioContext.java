package cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.Context;

public class ScenarioContext {
	
	private Map<String, Object> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext= new HashMap<>();
	}
	
	public  Object getScenarioContext(Context key) {
		return scenarioContext.get(key.toString());
	}

	public void setScenarioContext(Context key, Object value) {
		scenarioContext.put(key.toString(), value);
	}
	
	public Boolean isPresent(Context key) {
		return scenarioContext.containsKey(key.toString());
	}

 
}

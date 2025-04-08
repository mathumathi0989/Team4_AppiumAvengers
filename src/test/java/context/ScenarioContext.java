package context;

import java.util.HashMap;
import java.util.Map;

//ScenarioContext.java (Shared Data Management)

public class ScenarioContext {
	 private Map<String, Object> scenarioData;

	    public ScenarioContext() {
	        scenarioData = new HashMap<>();
	    }

	    public void setContext(String key, Object value) {
	        scenarioData.put(key, value);
	    }

	    public Object getContext(String key) {
	        return scenarioData.get(key);
	    }
	    
}

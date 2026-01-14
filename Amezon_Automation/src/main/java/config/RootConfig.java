package config;

import java.util.Map;

public class RootConfig {

	private String defaultEnv ;
	private Map<String, EnvironmentConfig> environments ;
	
	public String getDefaultEnv() {
		return defaultEnv ;
	}
	
	public Map<String, EnvironmentConfig> getEnvironments() {
		return environments ;
	}
}
 
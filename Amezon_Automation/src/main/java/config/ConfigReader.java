package config;

import java.io.InputStream;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ConfigReader - Utility class to load and provide environment configuration
 * Reads configuration from 'environmentConfig.json' using Jackson ObjectMapper
 * Supports environment selection via 'env' system property or default environment
 */
public class ConfigReader {
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static final String CONFIG_FILE = "environmentConfig.json";
	
	public static RootConfig config;
	
	// Static initializer block - loads configuration on class load
	static {
		loadConfiguration();
	}
	
	/**
	 * Private constructor to prevent instantiation of utility class
	 */
	private ConfigReader() {
		throw new AssertionError("Cannot instantiate utility class: ConfigReader");
	}
	
	/**
	 * Loads configuration from JSON file using Jackson ObjectMapper
	 * Handles IOExceptions and JSON parsing errors gracefully
	 */
	private static void loadConfiguration() {
		try (InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
			
			if (stream == null) {
				logger.error("Configuration file '{}' not found in classpath", CONFIG_FILE);
				throw new RuntimeException("Configuration file '" + CONFIG_FILE + "' not found");
			}
			
			ObjectMapper mapper = new ObjectMapper();
			config = mapper.readValue(stream, RootConfig.class);
			logger.info("Configuration loaded successfully from '{}'", CONFIG_FILE);
			
		} catch (Exception e) {
			logger.error("Failed to load configuration from file '{}': {}", CONFIG_FILE, e.getMessage(), e);
			throw new RuntimeException("Configuration loading failed", e);
		}
	}
	
	/**
	 * Retrieves the active environment configuration
	 * Checks 'env' system property first, falls back to default environment
	 * 
	 * @return EnvironmentConfig for the selected environment, or null if not found
	 */
	public static EnvironmentConfig getActiveEnvironment() {
		
		// Check if env is provided via system property
		String runtime = System.getProperty("env");
		
		// Use provided env or fall back to default
		String selectedEnv = (runtime != null) ? runtime : config.getDefaultEnv();
		
		logger.debug("Selected environment: {}", selectedEnv);
		logger.info("Loading configuration for environment: {}", selectedEnv);
		
		// Retrieve environment configuration
		Map<String, EnvironmentConfig> environments = config.getEnvironments();
		EnvironmentConfig environmentConfig = getEnvironmentOrNull(environments, selectedEnv);
		
		if (environmentConfig == null) {
			logger.error("Environment '{}' not found in configuration. Available environments: {}", 
					selectedEnv, environments.keySet());
		} else {
			logger.info("Environment '{}' loaded successfully", selectedEnv);
		}
		
		return environmentConfig;
	}
	
	/**
	 * Helper method to safely retrieve environment configuration
	 * Prevents NPE and provides cleaner null handling
	 * 
	 * @param environments Map of environment configurations
	 * @param envName Environment name to retrieve
	 * @return EnvironmentConfig if found, null otherwise
	 */
	private static EnvironmentConfig getEnvironmentOrNull(Map<String, EnvironmentConfig> environments, String envName) {
		if (environments == null || environments.isEmpty()) {
			logger.warn("Environments map is null or empty");
			return null;
		}
		
		EnvironmentConfig env = environments.get(envName);
		
		if (env == null) {
			logger.warn("Environment '{}' not found. Available: {}", envName, environments.keySet());
		}
		
		return env;
	}
	
}

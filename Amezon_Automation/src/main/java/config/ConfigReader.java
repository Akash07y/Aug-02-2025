package config;

import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigReader {

	public static RootConfig config ;
	
	static {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream("enviornmentConfig.json");
			config = mapper.readValue(stream, RootConfig.class) ;
		}
		catch(Exception e)
		{
			System.out.println("Failed to read the json");
			e.printStackTrace();
		}
	}
	
	public static EnvironmentConfig getActiveEnironment() {
		
		String runtime = System.getProperty("env") ;
		
		String selectEnv ;
		      // Turnary operator  ?  =>        varibale =  condition ?  True for Value : False for value   
		selectEnv = (runtime != null ) ? runtime :config.getDefaultEnv();

		System.out.println(" Selected enviroment is : " + selectEnv);
		
		Map<String, EnvironmentConfig> environments = config.getEnvironments() ;
		return environments.get(selectEnv) ;
	}
	
	
}

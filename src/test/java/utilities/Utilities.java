package utilities;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

	private static String propertyValue;

	private static Properties prop;


	public Utilities() {

		prop = new Properties();

	}

	public static String getAlertsProperties(String propertyName) throws IOException {

		InputStream is = Utilities.class.getResourceAsStream("alerts.properties");

		if (is != null) {

			prop.load(is);

			propertyValue = prop.getProperty(propertyName);

			return propertyValue;
		}

		return "";
	}

}
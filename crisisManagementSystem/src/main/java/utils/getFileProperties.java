package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//import org.testng.internal.PropertiesFile;

public class getFileProperties {
	
	/*this class contains all methods to read paramethers of some file*/
	
	/*public static void main(String args[]) throws IOException {
		getFileProperties archivo = new getFileProperties();
		System.out.println(archivo.getProperties("URLSANDBOX"));
	}*/
	
	private static Properties prop; 
	
	@SuppressWarnings("finally")
	public static String getTestProperties(String key) throws IOException {
		prop = new Properties();
		FileReader file = null;
		String returnKey = null;

		
		try {
			prop = new Properties();
			file = new FileReader("src/test/resources/Test.properties");
			prop.load(file);
			returnKey = prop.getProperty(key);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			file.close();
			return returnKey;
		}
	}
	
	@SuppressWarnings("finally")
	public static String getByElementsProperties(String key) throws IOException {
		prop = new Properties();
		FileReader file = null;
		String returnKey = null;

		
		try {
			prop = new Properties();
			file = new FileReader("src/main/resources/ByElements.properties");
			prop.load(file);
			returnKey = prop.getProperty(key);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			file.close();
			return returnKey;
		}
	}
	
}

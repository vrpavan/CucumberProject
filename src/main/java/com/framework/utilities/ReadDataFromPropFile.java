package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropFile {
	
	//Method to read data from property files (Example : Config.properties)
	public static Properties readProperties(String filename) {		
		Properties prop = null;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+filename);//to read the file
			prop = new Properties();
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return prop;		
	}

}

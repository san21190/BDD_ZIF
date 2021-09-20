package com.zifautomation.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	public Properties getProperty() throws IOException
	{
		FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {        	 
           // properties.load(new FileInputStream("resources/browser-config.properties"));
            properties.load(new FileInputStream(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
           
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;	
	}
	
	
	/*
	 * public Properties setProperty() throws IOException { //FileInputStream
	 * inputStream=null; Properties properties = new Properties(); try { //
	 * properties.load(new FileInputStream("resources/browser-config.properties"));
	 * properties.store(new
	 * FileOutputStream("resources/testdata-config.properties"), null);
	 * 
	 * } catch (Exception e) { System.out.println("Exception: " + e); } return
	 * properties; }
	 */


}

package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream("./ConfigurationAppData/commendata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String data = pro.getProperty(key);
		return data;
		
	}

}

package com.comcast.crm.generic.fileUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonParser;

public class JSonUtility {
	public String getDataFromJsonFile(String key) throws Exception, Exception, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("./ConfigurationAppData/appCommendata.json"));
		JSONObject map = (JSONObject)obj;
		String data=(String)map.get(key);
		return data;
	}

}

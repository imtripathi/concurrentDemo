package com.concurrent.demo.dataprocessing;

import java.util.HashMap;


public class DataProccessing {
	HashMap<String, String> syncHashMap =  new HashMap<String,String>();
	
   
   
	public String add(String key,String value) {
		try {
		syncHashMap.put(key, value);
		}catch(Exception e) {
			e.printStackTrace();
		}
 return syncHashMap.toString();
}}


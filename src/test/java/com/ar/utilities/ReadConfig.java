package com.ar.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties pro;		
	public ReadConfig() throws IOException
	{		
		pro=new Properties();		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		pro.load(fis);		
	}	
	
	public String getBaseUrl()
	{		
		String baseurl = pro.getProperty("baseUrl");
		return baseurl;		
	}
	public String getUsername()
	{		
		String username = pro.getProperty("username");
		return username;		
	}
	public String getPassword()
	{		
		String password = pro.getProperty("password");
		return password;		
	}	
}

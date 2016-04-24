package com.moon.common.util;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropUtils {
	private static final Logger log=LoggerFactory.getLogger(PropUtils.class);
	private static Properties props;
	private static InputStream inputStream;
	static{
		try{
			ClassLoader loader=PropUtils.class.getClassLoader();
			if(Objects.nonNull(loader))
				inputStream=loader.getResourceAsStream("recommend.properties");
			else
				inputStream=ClassLoader.getSystemResourceAsStream("recommend.properties");
			props=new Properties();
			props.load(inputStream);
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("PropUtils can not load recommend.properties...");
		}
	}
	private PropUtils(){
		
	}
	
	public static Properties getRecommendProperties(){
		return props;
	}
	
	public static String getRecomendValue(String key){
		return props.getProperty(key);
	}
	
}

package com.moon.kafka;

import java.util.Properties;

import com.moon.common.util.PropUtils;

import kafka.producer.ProducerConfig;

public final class KafkaUtils {
	private static ProducerConfig producerConfig;
	static{
		Properties props=new Properties();
		props.put("metadata.broker.list", KafkaUtils.getBrokers());
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		producerConfig=new ProducerConfig(props);
	}
	private KafkaUtils(){
		
	}
	public static String getViewTopics(){
		return PropUtils.getRecomendValue("kafka_menu_view_topics");
	}
	public static String getBrokers(){
		return PropUtils.getRecomendValue("brokers");
	}
	
	public static ProducerConfig getProducerConfig(){
		return producerConfig;
	}
}

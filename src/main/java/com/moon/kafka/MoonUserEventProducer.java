package com.moon.kafka;

import java.util.Properties;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
public class MoonUserEventProducer {
	private static final Logger LOG=LoggerFactory.getLogger(MoonUserEventProducer.class);
	private static final String topic="user_events";
	private static final String brokers="localhost:9092";
	private static final Properties props=new Properties();
	static{
		props.put("metadata.broker.list", brokers);
		props.put("serializer.class", "kafka.seriaizer.StringEncoder");
	}
	private static final ProducerConfig kafkaConfig=new ProducerConfig(props);
	private static final Producer<String,String> producer=new Producer<String,String>(kafkaConfig);
	
	public void sendMenuViewEvent(long userId,long menuId,long count){
		JSONObject event=new JSONObject();
		try{
			event.put("userId", userId);
			event.put("menuId", menuId);
			event.put("count", count);
			producer.send(new KeyedMessage<String,String>(topic,event.toString()));
		}catch(Exception e){
			e.printStackTrace();
			LOG.error("some exception occured when send message to kafka cluster",e.getCause());
		}
	}
}
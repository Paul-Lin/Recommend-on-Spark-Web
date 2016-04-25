package com.moon.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

public class MoonSimpleProducer {
	private Producer<String,String> producer=new Producer<String,String>(KafkaUtils.getProducerConfig());
	
	public void sendViewMenu(long userId,String event){
		producer.send(new KeyedMessage<String,String>(KafkaUtils.getViewTopics(),event));
	}
}
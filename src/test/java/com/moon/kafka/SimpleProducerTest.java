package com.moon.kafka;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class SimpleProducerTest {

	@Test
	public void testSimpleProducer() throws JSONException {
		MoonSimpleProducer producer=new MoonSimpleProducer();
		while(true){
			JSONObject event=new JSONObject();
			event.put("uid", "1111");
			event.put("os_type", "android");
			producer.sendViewMenu(1212,event.toString());
		}
		
	}

}

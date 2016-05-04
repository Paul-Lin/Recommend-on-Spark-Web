package com.moon.kafka;

import org.json.JSONException;
import org.junit.Test;

public class SimpleProducerTest {

	@Test
	public void testSimpleProducer() throws JSONException {
		MoonUserEventProducer producer=new MoonUserEventProducer();
		producer.sendMenuViewEvent(12, 12, 12);
	}

}

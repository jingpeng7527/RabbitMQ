package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.rabbitmq.listener.simple.auto-startup=false",
		"spring.rabbitmq.ssl.enabled=false"
})
class RabbitmqApplicationTests {

	@Test
	void contextLoads() {
	}

}

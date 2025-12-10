package com.allcompare.bingoastradirectwebservice.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import static org.mockito.Mockito.mock;



@RunWith(MockitoJUnitRunner.class)
class RabbitMQConfigTest {

	@Test
	void testRabbitTemplate_shouldReturn_wellConfiguredTemplate() {

		//Arrange
		ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
		//Act
		RabbitMQConfig rabbitMqConfig = new RabbitMQConfig();
		RabbitTemplate rabbitTemplate = rabbitMqConfig.rabbitTemplate(connectionFactory);

		//Assert
		Assertions.assertNotNull(rabbitTemplate, "RabbitMQ should not be null");
		Assertions.assertEquals(connectionFactory, rabbitTemplate.getConnectionFactory(), "Should equals to the overloaded Template");
        Assertions.assertInstanceOf(Jackson2JsonMessageConverter.class, rabbitTemplate.getMessageConverter(), "MessageConverter should be Jackson2JsonMessageConverter");
	}
}

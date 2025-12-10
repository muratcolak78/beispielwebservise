package com.allcompare.bingoastradirectwebservice.config;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
class WebClientConfigTest {

	@Test
	void testWebClientConfig_shouldReturn_wellConfiguredTemplate() {


		//Arrange
		WebClientConfig webClientConfig = new WebClientConfig();

		//Configure
		ReflectionTestUtils.setField(webClientConfig, "bufferSize", "1024");
		
		//Act
		WebClient webClient = webClientConfig.webClientPolicy();

		//Assert
		assertNotNull(webClient);
	}
}


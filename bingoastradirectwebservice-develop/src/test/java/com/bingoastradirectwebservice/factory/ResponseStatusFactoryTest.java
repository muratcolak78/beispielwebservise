package com.allcompare.bingoastradirectwebservice.factory;


import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;


@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ResponseStatusFactoryTest {

	private static final String USER = "testUser";
	@InjectMocks
	private ResponseStatusFactory responseStatusFactory;

	@Test
	void testNewResponseStatus_shouldReturn_newResponseStatusObject_withGivenParameters() {

		ReflectionTestUtils.setField(responseStatusFactory, "serviceUser", USER);

		//Arrange
		String infoMessage = "infoMessage";
		String path = "testPath";
		UUID contractId = UUID.randomUUID();
		String request = "Request";
		String response = "Response";


		//Act
		ResponseStatus responseStatus = responseStatusFactory.newResponseStatus(ResponseStatus.Status.OK, request, response, infoMessage, path, contractId);

		//Assert
		Assertions.assertNotNull(responseStatus);
		Assertions.assertEquals(infoMessage, responseStatus.getInfo());
		Assertions.assertEquals(path, responseStatus.getEndpointPath());
		Assertions.assertEquals(USER, responseStatus.getCreatedUser());
		Assertions.assertEquals(request, responseStatus.getRequestPayload());
		Assertions.assertEquals(response, responseStatus.getResponsePayload());
		Assertions.assertEquals(ResponseStatus.Status.OK, responseStatus.getStatus());
	}

}

package com.bingoastradirectwebservice.util;

import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import com.allcompare.bingoastradirectwebservice.testData.model.ResponseStatusTestData;
import com.allcompare.bingoastradirectwebservice.utils.JsonUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JsonUtilTest {
	@Test
	void parseObjectToJson_shouldReturn_null_withNullObject() {

		//Act & Assert
		assertNull(JsonUtil.parseObjectToJson(null));
	}

	@Test
	void testParseJsonToObject_shouldReturn_null_withNullClazz() {

		String testString = "TestString";
		//Act & Assert
		assertNull(JsonUtil.parseJsonToObject(testString, null));
	}

	@Test
	void testParseJsonToObject_shouldReturn_null_withBlankString() {

		//Act & Assert
		assertNull(JsonUtil.parseJsonToObject("", Map.class));
	}

	@Test
	void testParseJsonToObject_shouldReturn_nullWithError() {

		//Arrange
		String invalidJson = "invalidJson";

		//Act & Assert
		assertNull(JsonUtil.parseJsonToObject(invalidJson, Map.class));
	}

	@Test
	void testParseJsonToObject_shouldReturn_wellObject() {

		//Arrange
		ResponseStatus responseStatus = ResponseStatusTestData.setUpResponseStatus();
		String responseStatusString = JsonUtil.parseObjectToJson(responseStatus);

		//Act
		ResponseStatus mappingResult = JsonUtil.parseJsonToObject(responseStatusString, ResponseStatus.class);
		String resultString = JsonUtil.parseObjectToJson(mappingResult);

		boolean equality = resultString.equals(responseStatusString);

		//Assert
		assertTrue(equality);

	}
}

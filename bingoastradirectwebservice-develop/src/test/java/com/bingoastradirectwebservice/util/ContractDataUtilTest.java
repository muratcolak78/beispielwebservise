package com.allcompare.bingoastradirectwebservice.util;

import com.allcompare.bingoastradirectwebservice.model.PriceRequest;
import com.allcompare.bingoastradirectwebservice.model.Question;
import com.allcompare.bingoastradirectwebservice.utils.ContractDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ContractDataUtilTest {

	private PriceRequest mockPriceRequest;
	private Map<String, Object> mockDataMap;

	@BeforeEach
	void setUp() {
		// PriceRequest mockunu hazırla
		mockPriceRequest = Mockito.mock(PriceRequest.class);
		List<Question> questions = new ArrayList<>();

		Question question1 = new Question();
		question1.setName("testKey1");
		question1.setReturnValue("testValue1");

		Question question2 = new Question();
		question2.setName("testKey2");
		question2.setReturnValue("testValue2");

		questions.add(question1);
		questions.add(question2);

		when(mockPriceRequest.getQuestionList()).thenReturn(questions);

		mockDataMap = new HashMap<>();

		Map<String, String> questionData1 = new HashMap<>();
		questionData1.put("name", "testKey1");
		questionData1.put("returnValue", "testValue1");

		Map<String, String> questionData2 = new HashMap<>();
		questionData2.put("name", "testKey2");
		questionData2.put("returnValue", "testValue2");

		mockDataMap.put("q1", questionData1);
		mockDataMap.put("q2", questionData2);
	}

	@Test
	void getValue_WithPriceRequest_ShouldReturnCorrectValue() {
		// When
		String result1 = ContractDataUtil.getValue(mockPriceRequest, "testKey1");
		String result2 = ContractDataUtil.getValue(mockPriceRequest, "testKey2");
		String resultNonExistent = ContractDataUtil.getValue(mockPriceRequest, "nonExistentKey");

		// Then
		assertEquals("testValue1", result1);
		assertEquals("testValue2", result2);
		assertNull(resultNonExistent);
	}

	@Test
	void getValue_WithMap_ShouldReturnCorrectValue() {
		// When
		String result1 = ContractDataUtil.getValue(mockDataMap, "testKey1");
		String result2 = ContractDataUtil.getValue(mockDataMap, "testKey2");
		String resultNonExistent = ContractDataUtil.getValue(mockDataMap, "nonExistentKey");

		// Then
		assertEquals("testValue1", result1);
		assertEquals("testValue2", result2);
		assertNull(resultNonExistent);
	}

	@Test
	void getValue_WithMapContainingNonMapValue_ShouldHandleGracefully() {
		// Given
		mockDataMap.put("invalidEntry", "This is not a Map");

		// When
		String result = ContractDataUtil.getValue(mockDataMap, "testKey1");

		// Then
		assertEquals("testValue1", result);
	}

	@Test
	void getValue_WithMapMissingNameField_ShouldHandleGracefully() {
		// Given
		Map<String, String> incompleteData = new HashMap<>();
		incompleteData.put("returnValue", "someValue");
		mockDataMap.put("incomplete", incompleteData);

		// When
		String result = ContractDataUtil.getValue(mockDataMap, "testKey1");

		// Then
		assertEquals("testValue1", result);
	}

	@Test
	void getValue_WithUnsupportedType_ShouldThrowException() {
		// Given
		String unsupportedSource = "This is a string, not supported source type";

		// When & Then
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ContractDataUtil.getValue(unsupportedSource, "anyKey");
		});

		assertTrue(exception.getMessage().contains("Unsupported data source type"));
	}

	@Test
	void getValue_WithNullSource_ShouldThrowException() {
		// When & Then
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ContractDataUtil.getValue(null, "anyKey");
		});

		assertTrue(exception.getMessage().contains("Unsupported data source type: null"));
	}
}
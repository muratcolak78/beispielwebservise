package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class QuestionTest {
	@Test
	void testGettersAndSetters() {
		// Create an instance of Question
		Question question = new Question();

		// Set values using setters
		question.setUuid("12345");
		question.setName("Question 1");
		question.setReturnValue("Yes");
		question.setDefaultValue("No");
		question.setQuestionType(Question.QuestionType.ADDRESS);

		// Test getters
		assertEquals("12345", question.getUuid());
		assertEquals("Question 1", question.getName());
		assertEquals("Yes", question.getReturnValue());
		assertEquals("No", question.getDefaultValue());
		assertEquals(Question.QuestionType.ADDRESS, question.getQuestionType());
	}
	@Test
	void testEquals_shouldReturn_oneTimeFalseWithNull_and_true_withEquality() {
		// Create an instance of Question
		Question question = new Question();
		Question questionEquals = new Question();
		// Set values using setters
		boolean resultTrue = question.equals(questionEquals);
		boolean resultFalse = question.equals(null);
		assertTrue(resultTrue);
		assertFalse(resultFalse);
	}
	@Test
	void testToString() {
		// Create an instance of Question
		Question question = new Question();
		question.setUuid("12345");
		question.setName("Question 1");
		question.setReturnValue("Yes");
		question.setDefaultValue("No");
		question.setQuestionType(Question.QuestionType.ADDRESS);

		// Test toString method
		String expectedString = "Question{uuid='12345', name='Question 1', returnValue='Yes', defaultValue='No', questionType=ADDRESS}";
		assertEquals(expectedString, question.toString());
	}

	@Test
	void testEqualsAndHashCode() {
		// Create two instances of Question with the same values
		Question question1 = new Question();
		question1.setUuid("12345");
		question1.setName("Question 1");
		question1.setReturnValue("Yes");
		question1.setDefaultValue("No");
		question1.setQuestionType(Question.QuestionType.ADDRESS);

		Question question2 = new Question();
		question2.setUuid("12345");
		question2.setName("Question 1");
		question2.setReturnValue("Yes");
		question2.setDefaultValue("No");
		question2.setQuestionType(Question.QuestionType.ADDRESS);

		// Test equals and hashCode methods
		assertEquals(question1, question2);
		assertEquals(question1.hashCode(), question2.hashCode());

		question2.setUuid("23456");
		assertNotEquals(question1, question2);
		assertNotEquals(question1.hashCode(), question2.hashCode());
	}


	@Test
	void testEnumValuesAndLabels() {
		assertEquals(1, Question.QuestionType.LABEL.getValue());
		assertEquals("Label", Question.QuestionType.LABEL.getLabel());

		assertEquals(2, Question.QuestionType.TEXTBOX.getValue());
		assertEquals("Textfeld", Question.QuestionType.TEXTBOX.getLabel());

		assertEquals(3, Question.QuestionType.PERSON.getValue());
		assertEquals("Person", Question.QuestionType.PERSON.getLabel());

		assertEquals(4, Question.QuestionType.ADDRESS.getValue());
		assertEquals("Adresse", Question.QuestionType.ADDRESS.getLabel());

		assertEquals(5, Question.QuestionType.CURRENCY.getValue());
		assertEquals("Währung", Question.QuestionType.CURRENCY.getLabel());

		assertEquals(6, Question.QuestionType.POSTCODE.getValue());
		assertEquals("Postleitzahl", Question.QuestionType.POSTCODE.getLabel());

		assertEquals(7, Question.QuestionType.COINSURE.getValue());
		assertEquals("Mitversichern (coinsure)", Question.QuestionType.COINSURE.getLabel());

		assertEquals(8, Question.QuestionType.SELECT.getValue());
		assertEquals("Auswahl (select)", Question.QuestionType.SELECT.getLabel());

		assertEquals(9, Question.QuestionType.CONTRACTBEGIN.getValue());
		assertEquals("Vertragsbeginn (contractbegin)", Question.QuestionType.CONTRACTBEGIN.getLabel());

		assertEquals(10, Question.QuestionType.YESNO.getValue());
		assertEquals("Ja / Nein", Question.QuestionType.YESNO.getLabel());
	}

	@Test
	void testConstructorValues() {
		Question.QuestionType label = Question.QuestionType.LABEL;
		assertEquals(1, label.getValue());
		assertEquals("Label", label.getLabel());

		Question.QuestionType textbox = Question.QuestionType.TEXTBOX;
		assertEquals(2, textbox.getValue());
		assertEquals("Textfeld", textbox.getLabel());

		Question.QuestionType person = Question.QuestionType.PERSON;
		assertEquals(3, person.getValue());
		assertEquals("Person", person.getLabel());

		Question.QuestionType address = Question.QuestionType.ADDRESS;
		assertEquals(4, address.getValue());
		assertEquals("Adresse", address.getLabel());
	}

	@Test
	void testGetValue() {
		assertEquals(1, Question.QuestionType.LABEL.getValue());
		assertEquals(2, Question.QuestionType.TEXTBOX.getValue());
		assertEquals(3, Question.QuestionType.PERSON.getValue());
		assertEquals(4, Question.QuestionType.ADDRESS.getValue());
	}

	@Test
	void testGetLabel() {
		assertEquals("Label", Question.QuestionType.LABEL.getLabel());
		assertEquals("Textfeld", Question.QuestionType.TEXTBOX.getLabel());
		assertEquals("Person", Question.QuestionType.PERSON.getLabel());
		assertEquals("Adresse", Question.QuestionType.ADDRESS.getLabel());
	}

	@Test
	void testGetCaption_fromEnum_questionType() {

		Question.QuestionType questionType = Question.QuestionType.COINSURE;

		String caption = questionType.getCaption();

		assertEquals("COINSURE", caption);
	}

	@Test
	void testEquals_shouldReturn_true_withSameObjects() {

		//Arrange
		Question questionOne = new Question();
		Question questionTwo = new Question();

		//Act
		boolean equality = questionTwo.equals(questionOne);

		//Assert
		assertTrue(equality);
	}

	@Test
	void testEquals_shouldReturn_true_withItself() {

		//Arrange
		Question questionOne = new Question();

		//Act
		boolean equality = questionOne.equals(questionOne);

		//Assert
		assertTrue(equality);
	}
}

package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



class ProjectTest {
	@Test
	void testGettersAndSetters() {
		// Create an instance of Project
		Project project = new Project();

		// Set values using setters
		project.setUuid("12345");
		project.setName("My Project");

		// Test getters
		Assertions.assertEquals("12345", project.getUuid());
		Assertions.assertEquals("My Project", project.getName());
	}

	@Test
	void testToString() {
		// Create an instance of Project
		Project project = new Project();
		project.setUuid("12345");
		project.setName("My Project");

		// Test toString method
		String expectedString = "Project{uuid='12345', name='My Project'}";
		Assertions.assertEquals(expectedString, project.toString());
	}

	@Test
	void testEqualsAndHashCode() {
		// Create two instances of Project with the same values
		Project project1 = new Project();
		project1.setUuid("12345");
		project1.setName("My Project");

		Project project2 = new Project();
		project2.setUuid("12345");
		project2.setName("My Project");

		// Test equals and hashCode methods
		Assertions.assertEquals(project1, project2);
		Assertions.assertEquals(project1.hashCode(), project2.hashCode());
	}

	@Test
	void testEquals_shouldReturn_false_withNullValue() {

		//Arrange
		Project project = new Project();
		Project nullObject = null;

		//Act
		boolean result = project.equals(nullObject);

		//Assert
		assertFalse(result);
	}

	@Test
	void testEquals_shouldReturn_true_withSameObjects() {

		//Arrange
		Project projectOne = new Project();
		Project projectTwo = new Project();

		//Act
		boolean equality = projectTwo.equals(projectOne);

		//Assert
		assertTrue(equality);
	}

	@Test
	void testEquals_shouldReturn_true_withItself() {

		//Arrange
		Project projectOne = new Project();

		//Act
		boolean equality = projectOne.equals(projectOne);

		//Assert
		assertTrue(equality);
	}
}

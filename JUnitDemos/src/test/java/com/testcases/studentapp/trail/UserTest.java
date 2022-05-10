package com.testcases.studentapp.trail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.shristi.training.Calculator;
import com.shristi.training.User;

public class UserTest {
User user=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@BeforeEach
	public void setup() {
		user=new User();
		System.out.println("runs before each test case");
		
	}

	@Test
	void testGreat() {
		assertEquals("have a great day", user.greet());
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Great Day","have a great day","good day"})
	void testGreet(String message) {
		assertEquals(message, user.greet());
	}
	@ParameterizedTest
	@ValueSource(ints= {2,100,-870})
	void testNum(int num) {
		assertEquals(num, user.check());
	}
}

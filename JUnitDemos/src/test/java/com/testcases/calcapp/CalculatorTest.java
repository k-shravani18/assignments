package com.testcases.calcapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shristi.training.Calculator;

class CalculatorTest {

		Calculator calculator=null;
		@BeforeAll
		public static void init() {
			System.out.println("runs before all the test cases");
			
		}
		@BeforeEach
		public void setup() {
			calculator=new Calculator();
			System.out.println("runs before each test case");
			
		}
		@Test
		public void testAdd() {
			//call method to be added
//			int actualResult = calculator.sum(20,30);
//			int expected=50;
			//compare the actual value with the expected
			assertEquals(50, calculator.sum(20, 30),"expected output is 50");
		}
		@Test
		public void testGreetUser() {
			assertEquals("welcome SHRAVANI",calculator.greetUser("shravani"));
		}
		
		@Test
		public void testProduct() {
			assertEquals(20, calculator.product(4 ,5),"expected output 20");
		}
		@Test
		public void testDefference() {
			assertEquals(40, calculator.difference(60, 20),"expected output 40");
		}
		@AfterEach
		public void teardown() {
			System.out.println("runs after each test Case");
			
		}
		@AfterAll
		public static void cleanup() {
			System.out.println("runs after all");
		}
		

	


}

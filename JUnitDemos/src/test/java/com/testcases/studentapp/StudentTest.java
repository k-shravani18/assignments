package com.testcases.studentapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shristi.training.ExceedingNumException;
import com.shristi.training.InvalidNumException;
import com.shristi.training.NegValueException;
import com.shristi.training.NoValueException;
import com.shristi.training.Student;

class StudentTest {
	Student student=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student=new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student=null;
	}

	@Test
	@DisplayName("Testing positive values")
	void testTotalMarks() throws NegValueException, ExceedingNumException {
		assertEquals(260, student.totalMarks(80, 90, 90),"values do not match expected total is 260");
		
	}
	@Test
	@DisplayName("Testing negative values")
	void testNegTotalValues() {
		assertThrows(NegValueException.class, ()->student.totalMarks(-80, 70, 90));
	}
	@Test
	@DisplayName("Testing greater than 100")
	void testExceedValues() {
		assertThrows(ExceedingNumException.class, ()->student.totalMarks(200, 50, 900));
	}
	@Test
	@DisplayName("Testing grade A")
	void testGetGrade() throws InvalidNumException  {
		int marks[]= {90,90,95};
		String grade=student.getGrades(marks);
		assertEquals("A", grade,"Expecting A");
	}
	@Test
	@DisplayName("Testing grade B")
	void testGetGradeB() throws InvalidNumException  {
		int marks[]= {80,80,89};
		assertEquals("B", student.getGrades(marks),"Expecting B");

	}
	@Test
	@DisplayName("Testing grade C")
	void testGetGradeC() throws InvalidNumException  {
		int marks[]= {70,70,79};
		assertEquals("C",student.getGrades(marks),"Expecting C");

	}
	@Test
	@DisplayName("Testing grade D")
	void testGetGradeD() throws InvalidNumException  {
		int marks[]= {60,60,69};
		assertEquals("D", student.getGrades(marks),"Expecting D");

	}
	@Test
	@DisplayName("Testing grade E")
	void testGetGradeE() throws InvalidNumException  {
		int marks[]= {50,50,59};
		assertEquals("E",student.getGrades(marks),"Expecting E");

	}
	@Test
	@DisplayName("Testing grade F")
	void testGetGradeF() throws InvalidNumException  {
		int marks[]= {20,10,29};
		assertEquals("F", student.getGrades(marks),"Expecting F");

	}
	
}

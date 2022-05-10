package com.shristi.training;

public class Student {
	public int totalMarks(int marks1,int marks2,int marks3) throws NegValueException, ExceedingNumException
	{
		if(marks1<0 || marks2 <0 || marks3<0) {
			throw new NegValueException("marks should not be less than 0");
		}else if(marks1>100 || marks2>100 || marks3>100) {
			throw new ExceedingNumException("marks should not exceed 100");
		}
		return marks1+marks2+marks3;
	}
	// 90-A, 80-90 -B,70-
	public String getGrades(int[] marks) throws InvalidNumException {
		int sum=0;
		int avg=0;
		if(marks!=null) {
		for(int mark:marks) {
			if(mark<0||mark>100)
				throw new InvalidNumException("num should not less than 0 and greater than 100");
			sum+=mark;
		}
			avg=sum/marks.length;
			if(avg>90) {
				return "A";
			}else if(avg<90&&avg>80) {
				return "B";
			}else if(avg<80&&avg>70) {
				return "C";
			}else if(avg<70&&avg>60) {
				return "D";
			}else if(avg<60&&avg>50) {
				return "E";
			}else
				return "F";
		
		
	}
		return "no values";
}
}

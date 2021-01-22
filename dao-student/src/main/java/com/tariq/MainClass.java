package com.tariq;

import com.tariq.dao.StudentCRUDImpl;
import com.tariq.model.Student;

public class MainClass {

	public static void main(String[] args) {
		Student s1 = new Student("Charlie", "Brown", 9);
		StudentCRUDImpl sCImpl = new StudentCRUDImpl();
		sCImpl.addStudent(s1);
		s1 = sCImpl.getStudent(1);
		s1.setFirstName("James");
		sCImpl.updateStudent(s1);
		sCImpl.getStudent(1);
		sCImpl.deleteStudent(1);
		sCImpl.getStudent(1);
	}

}

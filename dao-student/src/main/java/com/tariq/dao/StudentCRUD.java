package com.tariq.dao;

import com.tariq.model.Student;

public interface StudentCRUD {
   public void addStudent(Student student);
   public Student getStudent(int id);
   public void updateStudent(Student student);
   public void deleteStudent(int id);
}

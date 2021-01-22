package com.tariq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tariq.database.DatabaseConnection;
import com.tariq.model.Student;

public class StudentCRUDImpl implements StudentCRUD {

	@Override
	public void addStudent(Student student) {
		try(Connection conn = DatabaseConnection.dbConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO student(firstname, lastname, age) VALUES(?, ?, ?)");
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setInt(3, student.getAge());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int id) {
		Student student = null;
		try(Connection conn = DatabaseConnection.dbConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("age"));
				System.out.println(student.toString());
			} else {
				System.out.println("No student returned for ID: " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		student.getId();
		try(Connection conn = DatabaseConnection.dbConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE student SET firstname = ?, lastname = ?, age = ? WHERE id = ?");
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setInt(3, student.getAge());
			stmt.setInt(4, student.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int id) {
		try(Connection conn = DatabaseConnection.dbConnection()) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

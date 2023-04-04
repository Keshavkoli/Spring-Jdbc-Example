package com.springjdbc;

import java.util.List;

public interface StudentDao {
// insert the data
	public int insert(Student stuent);

//update the data
	public int change(Student student);

	// delete the data
	public int delete(int studentId);

	// we get the single object

	public Student getStudent(int studentId);

	// we get the multiple object

	public List<Student> getAllStudents();
}

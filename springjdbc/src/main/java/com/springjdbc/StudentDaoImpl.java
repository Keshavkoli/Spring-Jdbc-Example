package com.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

//inserting data
	@Override
	public int insert(Student student) {
		String query = "insert into SpringJdbcTemplate(id,name,salary) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getSalary());
		return r;
	}

//updating data
	@Override
	public int change(Student student) {
		String query = "update SpringJdbcTemplate set name=? ,salary=? where id=?";
		int r1 = this.jdbcTemplate.update(query, student.getName(), student.getSalary(), student.getId());
		return r1;
	}

	// delete operations starts here
	@Override
	public int delete(int studentId) {
		String query = "delete from SpringJdbcTemplate where id=?";
		int r1 = this.jdbcTemplate.update(query, studentId);
		return r1;
	}

	// selecting single student data
	@Override
	public Student getStudent(int studentId) {
		String query11 = "select * from SpringJdbcTemplate where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query11, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		String query = "select * from SpringJdbcTemplate";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

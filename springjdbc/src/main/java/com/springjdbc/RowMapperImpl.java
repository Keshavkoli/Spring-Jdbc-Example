package com.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student =  new Student();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setSalary(rs.getFloat(3));
		return student;
	}

}

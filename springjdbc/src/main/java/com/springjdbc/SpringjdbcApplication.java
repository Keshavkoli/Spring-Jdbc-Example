package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringjdbcApplication {

	public static void main(String[] args) {
		System.out.println("-------programe Started-----------");
		// spring jdbc==> template
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml"); its xml based configuration 
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);// its the annotation based configuration
		
		// create a jdbc template class

//		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

		// INSERT QUERY

//		String query = "insert into SpringJdbcTemplate(id,name,salary) values(?,?,?)";

		// fire query

//		int result = template.update(query, 151, "mahesh", 20000);
//		System.out.println("number of records inserted...." + result);

		// insert query
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		Student student = new Student();
//		student.setId(14);
//		student.setName("Ramesh");
//		student.setSalary(6500);
//
//		int result1 = studentDao.insert(student);
//		System.out.println("Student added==>" + result1);

		// its the UPDATING the data code

//		Student student = new Student();
//		student.setId(100);
//		student.setName("updated the name");
//		student.setSalary(92000);
//		int result = studentDao.change(student);
//		System.out.println("data changed==>"+result);

		// DELETE OPERATION CODE
//		int result = studentDao.delete(100);
//		System.out.println("deleted==>"+result);

		// get the student from the database by passing the id 
//		Student student = studentDao.getStudent(14);
//		System.out.println("student==>"+student);

		// get all List of data from the database 
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
	}

}

package com.scu.springdata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.scu.springdata.dao.StudentDao;
import com.scu.springdata.domain.Student;

public class StudentDAOSpringJdbcImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询学生列表
	 */
	public List<Student> queryAll() {
		
		final List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student";
		jdbcTemplate.query(sql, new RowCallbackHandler(){

			public void processRow(ResultSet resultSet) throws SQLException {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				int age = resultSet.getInt("age"); 
				Student student = new Student();
				student.setId(id);
				student.setUsername(username);
				student.setAge(age);
				studentList.add(student);		
			}
			
		});
		return studentList;
	}

	/**
	 * 添加一个学生
	 */
	public void studentSave(Student student) {
		
		String sql = "insert into student(username, age) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getUsername(), student.getAge()});
	}

	/**
	 * 通过id查询学生
	 */
	public Student studentById(int id) {
		
		String sql = "select * from student where id = ?";
		final Student student = new Student();
		jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Student>(){

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				student.setId(rs.getInt("id"));
				student.setUsername(rs.getString("username"));
				student.setAge(rs.getInt("age"));
				return student;
			}
			
		});
		return student;
	}

}

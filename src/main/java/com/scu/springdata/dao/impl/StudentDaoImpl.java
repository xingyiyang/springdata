package com.scu.springdata.dao.impl;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.scu.springdata.dao.StudentDao;
import com.scu.springdata.domain.Student;
import com.scu.springdata.util.JDBCUtil;

/**
 * @author xing
 * @date 2017年6月15日
 * @time 下午9:57:04
 * studentdao的接口实现类
 */
public class StudentDaoImpl implements StudentDao{

	/* 
	 * 查询所有学生
	 */
	public List<Student> queryAll() {
		
		List<Student> studentList = new ArrayList<Student>(); 
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from student";
		
		try {
			connection = JDBCUtil.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			Student student = null;
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				int age = resultSet.getInt("age"); 
				student = new Student();
				student.setId(id);
				student.setUsername(username);
				student.setAge(age);
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(resultSet, statement, connection);
		}
		return studentList;
	}

	/* 
	 * 添加一个学生
	 */
	public void studentSave(Student student) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "insert into student(username,age) values(?,?)";
		
		try {
			connection = JDBCUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getUsername());
			statement.setInt(2, student.getAge());
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(resultSet, statement, connection);
		}
	}

	/**
	 * 通过id查找student
	 */
	public Student studentById(int id) {
		
        Student student = new Student(); 
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from student where id = ?";
		
		try {
			connection = JDBCUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if(resultSet == null){
				return null;
			}

			while(resultSet.next()){
				student.setId(resultSet.getInt("id"));
				student.setUsername(resultSet.getString("username"));
				student.setAge(resultSet.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(resultSet, statement, connection);
		}
		return student;
	}

}

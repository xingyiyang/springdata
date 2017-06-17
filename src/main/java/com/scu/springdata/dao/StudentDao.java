package com.scu.springdata.dao;

import java.util.List;

import com.scu.springdata.domain.Student;

/**
 * @author xing
 * @date 2017年6月15日
 * @time 下午9:54:08
 * studentdao接口
 */
public interface StudentDao {

	public List<Student> queryAll();
	
	public void studentSave(Student student);
	
	public Student studentById(int id);
}

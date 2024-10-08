package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.rewrite.RewriteCond;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.entity.Student;
import com.mysql.cj.protocol.Resultset;

public class StudentDao {
private Connection conn;
public StudentDao(Connection conn) {
	super();
	this.conn = conn;
}
public Boolean addStudent(Student student) {
	boolean f = false;
	try {
		String sql = "insert into crud(name,dob,address,qualification,email) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getFullname());
		ps.setString(2, student.getDob());
		ps.setString(3, student.getAddress());
		ps.setString(4, student.getQualification());
		ps.setString(5, student.getEmail());
		
		int i = ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	return f;
}
public List<Student> getAllStudent(){
	List<Student> list = new ArrayList<Student>();
	Student s = null;
	try {
		String sql = "select * from crud";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s = new Student();
			s.setId(rs.getInt(1));
			s.setFullname(rs.getString(2));
			s.setDob(rs.getString(3));
			s.setAddress(rs.getString(4));
			s.setQualification(rs.getString(5));
			s.setEmail(rs.getString(6));
			list.add(s);	
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return list;
}
public Student getStudent(int id) {
	Student s= null;

	try {
		String sql = "select * from crud where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s = new Student();
			s.setId(rs.getInt(1));
			s.setFullname(rs.getString(2));
		    s.setDob(rs.getString(3));
			s.setAddress(rs.getString(4));
			s.setQualification(rs.getString(5));
			s.setEmail(rs.getString(6));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
	}
	return s;
}

public boolean editStudent(Student student) {
	boolean f = false;
	try {
		String sql = "update  crud set name =?,dob=?,address=?,qualification=?,email=? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getFullname());
		ps.setString(2, student.getDob());
		ps.setString(3, student.getAddress());
		ps.setString(4, student.getQualification());
		ps.setString(5, student.getEmail());
		ps.setInt(6, student.getId());
		
		int i = ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	
	return f;
}

public boolean deleteStudent(int id) {
	boolean f = false;
	
	try {
		String url = "delete from crud where id =?";
		PreparedStatement ps = conn.prepareStatement(url);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		if(i==1) {
			f = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return f;
	
}







}
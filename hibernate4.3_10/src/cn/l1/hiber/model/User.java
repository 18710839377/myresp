package cn.l1.hiber.model;

import java.util.Date;

public class User {
	private Integer userId;
	
	private String uname;
	
	private Integer gender;
	
	private Date birthday;
	
	private Integer salary;
	

	
	
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", gender="
				+ gender + ", birthday=" + birthday + ", salary=" + salary
				+ "]";
	}

	

		
}

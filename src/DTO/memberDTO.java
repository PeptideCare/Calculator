package DTO;

public class memberDTO {
	private int id;
	private String password;
	private String name;
	private String department;
	private String major;
	private int schoolYear;
	
	public memberDTO(int id, String password, String name,  String department, String major, int schoolYear) {
		this.id = id;
		this.password = password;
		this.department = department;
		this.name = name;
		this.major = major;
		this.schoolYear = schoolYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	
}

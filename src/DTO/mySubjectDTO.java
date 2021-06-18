package DTO;

public class mySubjectDTO {
	
	private int userId;
	private int subjectCode;
	private String subjectName;
	private String classification;
	private int credit;
	
	public mySubjectDTO(int userId, int subjectCode, String subjectName, String classification, int credit) {
		this.userId = userId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.classification = classification;
		this.credit = credit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	

}

package DTO;

public class subjectDTO {
	private int code;   // �����ڵ�
	private String name;  // �����
	private String professorName;  // ������
	private int recommededYear;  // �����г�
	private String classification;  // �̼�����
	private String nameBefore18;  // ���� ���α���
	private int credit;  // ����
	private int hour; // �ü�
	private String className;  // �ش� �а�
	private String before18;  // 18�й� ���� ���� (true, false)
	
	public subjectDTO(int code, String name, String professorName, int recommededYear, String classification,
			String nameBefore18, int credit, int hour, String className, String before18) {
		this.code = code;
		this.name = name;
		this.professorName = professorName;
		this.recommededYear = recommededYear;
		this.classification = classification;
		this.nameBefore18 = nameBefore18;
		this.credit = credit;
		this.hour = hour;
		this.className = className;
		this.before18 = before18;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public int getRecommededYear() {
		return recommededYear;
	}

	public void setRecommededYear(int recommededYear) {
		this.recommededYear = recommededYear;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getNameBefore18() {
		return nameBefore18;
	}

	public void setNameBefore18(String nameBefore18) {
		this.nameBefore18 = nameBefore18;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBefore18() {
		return before18;
	}

	public void setBefore18(String before18) {
		this.before18 = before18;
	}
	
	
}

package DTO;

public class subjectDTO {
	private int code;   // 과목코드
	private String name;  // 과목명
	private String professorName;  // 교수명
	private int recommededYear;  // 권장학년
	private String classification;  // 이수구분
	private String nameBefore18;  // 교양 세부구분
	private int credit;  // 학점
	private int hour; // 시수
	private String className;  // 해당 학과
	private String before18;  // 18학버 이전 구분 (true, false)
	
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

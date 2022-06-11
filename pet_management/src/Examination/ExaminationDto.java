package Examination;

public class ExaminationDto {
	int examID;
	int memberID;
	String memberName;
	String examContent;
	int examCost;

	public ExaminationDto(int examID,int memberID,String memberName,String examContent,int examCost) {
		this.examID = examID;
		this.memberID = memberID;
		this.memberName = memberName;
		this.examContent = examContent;
		this.examCost = examCost;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getExamContent() {
		return examContent;
	}

	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}

	public int getExamCost() {
		return examCost;
	}

	public void setExamCost(int examCost) {
		this.examCost = examCost;
	}
	
}

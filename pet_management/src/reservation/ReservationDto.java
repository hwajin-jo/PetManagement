package reservation;

import java.sql.Timestamp;

//Dto(Data Transcation Object, 데이터베이스의 필드를 자바에서 읽고 쓰는 필드를 저장하는 클래스)
public class ReservationDto {
	
	int memberID;
	int reservationID;
	String memberName;
	String nextReserve;
	
	
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
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
	public String getNextReserve() {
		return nextReserve;
	}
	public void setNextReserve(String nextReserve) {
		this.nextReserve = nextReserve;
	}
	
	
	
	
}


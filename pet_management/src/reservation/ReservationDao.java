package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Dao(Data Access Object, 데이터베이스 연동하는 부분)

public class ReservationDao {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/petManage";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//	//등록 --원본!!
//	public void insertReserve(int reservationID, int memberID, String memberName, String nextReserve) {
//		// TODO Auto-generated method stub
//		try {
//			conn = DriverManager.getConnection(url, userid, password);
//			String query = "insert into petReservation(reservationID, memberID, memberName, nextReserve) values(?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, reservationID);
//			pstmt.setInt(2, memberID);
//			pstmt.setString(3, memberName);
//			pstmt.setString(4, nextReserve);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//	            conn.close();
//	            } catch (SQLException e) {
//	            	e.printStackTrace();
//	            }
//		}
//	}

	// 등록
	public int insertReserve(int memberID, String memberName, String nextReserve) {
		// TODO Auto-generated method stub
		int iCnt = 1;
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into petReservation(reservationID, memberID, memberName, nextReserve) values(null,?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			// pstmt.setInt(1, reservationID);
			pstmt.setInt(1, memberID);
			pstmt.setString(2, memberName);
			pstmt.setString(3, nextReserve);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			iCnt = 0;
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return iCnt;
	}

	// 수정
	public void updateReserve(int reservationID, int memberID, String nextReserve) {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update petReservation set nextReserve = ? where memberID=? and reservationID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nextReserve);
			pstmt.setInt(2, memberID);
			pstmt.setInt(3, reservationID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 삭제
	public void deleteReserve(int memberID, int reservationID) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from petReservation where memberID = ? and reservationID=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, reservationID);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("삭제 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 예약 조회 전 멤버ID를 선택하면 멤버이름 보여주기
	public ReservationDto searchMemberName(int memberID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationDto dto = new ReservationDto();

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select memberName from petMember where memberId= ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setMemberName(rs.getString(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	};

	// 회원아이디 콤보박스로 가져오기
	public ArrayList<ReservationDto> selectMemberID() {
		ArrayList<ReservationDto> list = new ArrayList<ReservationDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select memberID,memberName from petMember order by memberID";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReservationDto dto = new ReservationDto();
				dto.setMemberID(rs.getInt("MemberID"));
				dto.setMemberName(rs.getString("MemberName"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 회원아이디 선택해서 아이디에 대한 값 하나만 조회,
	public ReservationDto searchReserve(int memberID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationDto dto = new ReservationDto();

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from petReservation where memberID=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setReservationID(rs.getInt(1));
				dto.setMemberID(rs.getInt(2));
				dto.setMemberName(rs.getString(3));
				dto.setNextReserve(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 선택한 id의 예약목록 조회
	public ArrayList<ReservationDto> selectListReserve(int memberID) {
		ArrayList<ReservationDto> list = new ArrayList<ReservationDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from petReservation where memberID=(case when ?=0 then memberID else ? end) order by reservationID desc";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, memberID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReservationDto dto = new ReservationDto();
				dto.setMemberID(rs.getInt("MemberID"));
				dto.setReservationID(rs.getInt("ReservationID"));
				dto.setMemberName(rs.getString("MemberName"));
				dto.setNextReserve(rs.getString("NextReserve"));
				list.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

}

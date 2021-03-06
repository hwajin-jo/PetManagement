package member;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/petManage";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertMember(int memberID, String memberName, String memberSpecies, String hostName, String hostPhoneNum, String visitReason) {
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into petMember(memberID, memberName, memberSpecies, hostName, hostPhoneNum, visitReason) values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			pstmt.setString(2, memberName);
			pstmt.setString(3, memberSpecies);
			pstmt.setString(4, hostName);
			pstmt.setString(5, hostPhoneNum);
			pstmt.setString(6, visitReason);
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
	} // end insetMember

	public void updateMember(int memberID, String memberName, String memberSpecies, String hostName, String hostPhoneNum, String visitReason) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update petMember set memberName = ?, memberSpecies = ?, hostName = ?, hostPhoneNum = ?, visitReason = ? where memberID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(6, memberID);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberSpecies);
			pstmt.setString(3, hostName);
			pstmt.setString(4, hostPhoneNum);
			pstmt.setString(5, visitReason);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("���� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
                e.printStackTrace();
            }
		}	
	} // end updateMember

	public void deleteMember(int memberID) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from petMember where memberID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			int result = pstmt.executeUpdate();
			if ( result == 1 ) {
				System.out.println("���� ����");
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
        	
	} // end deleteMember

	public MemberDto searchMember(String hostName) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    MemberDto dto = new MemberDto();
	    
	    try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from petMember where hostName = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, hostName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setMemberID(rs.getInt(1));
				dto.setMemberName(rs.getString(2));
				dto.setMemberSpecies(rs.getString(3));
				dto.setHostName(rs.getString(4));
				dto.setHostPhoneNum(rs.getString(5));
				dto.setVisitReason(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

            try {
                if(rs != null) { rs.close();}
                if(pstmt != null) {pstmt.close();}
                if(conn != null) {conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
		return dto;
	} // end searchMember

	public ArrayList<MemberDto> selectMember() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     
	 	 try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from petMember";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMemberID(rs.getInt("memberID"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberSpecies(rs.getString("memberSpecies"));
				dto.setHostName(rs.getString("hostName"));
				dto.setHostPhoneNum(rs.getString("hostPhoneNum"));
				dto.setVisitReason(rs.getString("visitReason"));
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
	} // end selectMember

	

}

package Examination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import member.MemberDto;

public class ExaminationDao {
	
	String driver ="com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/petmanage";
	String userid ="root";
	String password ="1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	public void registerEx(int memberID, String memberName, String examContent, String examCost) {
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into examination values (null,?,?,?,?)";
	//		insert into examination(examId, memberID, memberName, examContent, examCost) values (null,003,'모모','골절','18000');
			pstmt = conn.prepareStatement(query);
		//	pstmt.setInt(1, examID);
		//	pstmt.setInt(5, examID);
			pstmt.setInt(1, memberID);
			pstmt.setString(2, memberName);
			pstmt.setString(3, examContent);
			pstmt.setString(4, examCost);
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
	} // end registerEx 등록하기
	
	
	
	public ExaminationDto searchEx(int examID) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ExaminationDto dto = new ExaminationDto();
	    
	    try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from examination where examID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, examID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setExamID(rs.getInt(1));
				dto.setMemberID(rs.getInt(2));
				dto.setMemberName(rs.getString(3));
				dto.setExamContent(rs.getString(4));
				dto.setExamCost(rs.getString(5));
				
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

	public ExaminationDto searchExbyMemberID(int memberID) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ExaminationDto dto = new ExaminationDto();
	    
	    try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select * from examination where memberID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setExamID(rs.getInt(1));
				dto.setMemberID(rs.getInt(2));
				dto.setMemberName(rs.getString(3));
				dto.setExamContent(rs.getString(4));
				dto.setExamCost(rs.getString(5));
				
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
	} // end searchExbyMemberID


	public ArrayList<ExaminationDto> selectEx(int examID) {
		ArrayList<ExaminationDto> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, userid, password);
            String query = "select * from examination where examID =?";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            pstmt.setInt(1, examID);
            while (rs.next()) {
            	ExaminationDto dto = new ExaminationDto();
                dto.setExamID(rs.getInt("examID"));
                dto.setMemberID(rs.getInt("memberID"));
                dto.setMemberName(rs.getString("memberName"));
                dto.setExamContent(rs.getString("examContent"));
                dto.setExamCost(rs.getString("examCost"));
                list.add(dto);
            }
        } catch (SQLException e) {
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

		
	}//end selectEx

	public ArrayList<ExaminationDto> selectExBymemberID(int memberID) {
		ArrayList<ExaminationDto> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, userid, password);
            
            String query = "select * from examination where memberID =?";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            pstmt.setInt(1, memberID);
 
            while (rs.next()) {
            	ExaminationDto dto = new ExaminationDto();
                dto.setExamID(rs.getInt("examID"));
                dto.setMemberID(rs.getInt("memberID"));
                dto.setMemberName(rs.getString("memberName"));
                dto.setExamContent(rs.getString("examContent"));
                dto.setExamCost(rs.getString("examCost"));
                list.add(dto);
            }
        } catch (SQLException e) {
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

		
	}//end selectExBymemberID

	public void deleteEx(int memberID, int examID) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from examination where memberID = ? and examID=?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, examID);
			int result = pstmt.executeUpdate();
			if ( result == 1 ) {
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
		
	}//deleteEx
	
	
	public void updateEx(int examID,String memberName, String examContent,String examCost) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update examination set memberName = ?, examContent = ?, examCost =?  where examID = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(4, examID);
			pstmt.setString(1, memberName);
			pstmt.setString(2, examContent);
			pstmt.setString(3, examCost);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("수정 성공");
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
	} // end updateEx



	public ArrayList<ExaminationDto> selectEx() {
		ArrayList<ExaminationDto> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, userid, password);
            String query = "select * from examination";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	ExaminationDto dto = new ExaminationDto();
                dto.setExamID(rs.getInt("examID"));
                dto.setMemberID(rs.getInt("memberID"));
                dto.setMemberName(rs.getString("memberName"));
                dto.setExamContent(rs.getString("examContent"));
                dto.setExamCost(rs.getString("examCost"));
                list.add(dto);
            }
        } catch (SQLException e) {
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

	}//end selectEx
	
	
	
}
package manager;

import java.sql.*;

public class ManagerDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/petManage";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	String managerID;
//    String managerPWD ;
	
	public int login(String managerID, String managerPWD) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userid,password);
			String query = "select managerID,managerPWD from managerLogin where managerID= ? and managerPWD = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, managerID);
			pstmt.setString(2, managerPWD);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
		} 
		return 0;
			
		} catch ( SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}	//end login 
	
	
	
}
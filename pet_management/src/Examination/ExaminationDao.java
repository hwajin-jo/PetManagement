package Examination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExaminationDao {
	
	String driver ="com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/petmanage";
	String userid ="root";
	String password ="1234";
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	
}

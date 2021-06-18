package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.mySubjectDTO;

public class mySubjectDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "c##jsp";
	String pw = "tiger";
	
	public mySubjectDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Select
	
	public ArrayList<mySubjectDTO> select(int Id) {
		
		ArrayList<mySubjectDTO> list = new ArrayList<mySubjectDTO>();
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT * FROM mysubject WHERE userId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Id);
			res = pstmt.executeQuery();
			
			
			while(res.next()) {
				int userId = res.getInt("userid");
				int subjectCode = res.getInt("subjectcode");
				String subjectName = res.getString("subjectname");
				String classification = res.getString("classification");
				int credit = res.getInt("credit");
				
				
				mySubjectDTO mysubject = new mySubjectDTO(userId, subjectCode, subjectName, classification, credit);
				list.add(mysubject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	// Insert
	
	public ArrayList<mySubjectDTO> insert(int userId, int subjectCode, String subjectName, String classification, int credit) {
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "INSERT INTO mysubject VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, subjectCode);
			pstmt.setString(3, subjectName);
			pstmt.setString(4, classification);
			pstmt.setInt(5, credit);
						
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(userId + "님이 수업을 등록 하셨습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}

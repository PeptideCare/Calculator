package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.subjectDTO;

public class subjectDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "c##jsp";
	String pw = "tiger";
	
	public subjectDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Select
	
	public ArrayList<subjectDTO> select(int Code) {
		
		ArrayList<subjectDTO> list = new ArrayList<subjectDTO>();
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT * FROM subject WHERE code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Code);
			res = pstmt.executeQuery();
			
			
			while(res.next()) {
				int code = res.getInt("code");
				String name = res.getString("name");
				String professorName = res.getString("professorname");
				int recommededYear = res.getInt("year");
				String classification = res.getString("classification");
				String nameBefore18 = res.getString("namebefore");
				int credit = res.getInt("credit");
				int hour = res.getInt("hour");
				String className = res.getString("classname");
				String before18 = res.getString("before18");
				
				
				subjectDTO subject = new subjectDTO(code, name, professorName, recommededYear, classification, nameBefore18, credit, hour, className, before18);
				list.add(subject);
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
	
	public ArrayList<subjectDTO> insert(int code, String name, String professorName, int recommededYear, String classification,
			String nameBefore18, int credit, int hour, String className, String before18) {
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "INSERT INTO subject VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, name);
			pstmt.setString(3, professorName);
			pstmt.setInt(4, recommededYear);
			pstmt.setString(5, classification);
			pstmt.setString(6, nameBefore18);
			pstmt.setInt(7, credit);
			pstmt.setInt(8, hour);
			pstmt.setString(9, className);
			pstmt.setString(10, before18);
						
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(name + "의 과목이 등록되었습니다.");
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
	// delete
	
	public ArrayList<subjectDTO> delete(int code, String name) {
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "delete from subject where code = ? and name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, name);
						
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(name + "의 과목이 삭제되었습니다.");
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

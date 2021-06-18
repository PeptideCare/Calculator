package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.memberDTO;

public class memberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "c##jsp";
	String pw = "tiger";
	
	public memberDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Select
	
	public ArrayList<memberDTO> select(int Id) {
		
		ArrayList<memberDTO> list = new ArrayList<memberDTO>();
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Id);
			res = pstmt.executeQuery();
			
			
			while(res.next()) {
				int id = res.getInt("id");
				String password = res.getString("password");
				String name = res.getString("name");
				String department = res.getString("department");
				String major = res.getString("major");
				int schoolYear = res.getInt("schoolyear");
				
				memberDTO member = new memberDTO(id, password, name, department, major, schoolYear);
				list.add(member);
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
	
	public ArrayList<memberDTO> insert(int Id, String password, String name, String department, String major, int schoolYear) {
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, department);
			pstmt.setString(5, major);
			pstmt.setInt(6, schoolYear);
						
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(Id + "님이 회원가입을 하셨습니다.");
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
	
	public ArrayList<memberDTO> update(int Id, String department, String major, int schoolYear){
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			
			String sql = "UPDATE member SET department = ?,  major = ?, schoolYear = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, department);
			pstmt.setString(2, major);
			pstmt.setInt(3, schoolYear);
			pstmt.setInt(4, Id);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(Id + "님이 회원정보를 변경하였습니다.");
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

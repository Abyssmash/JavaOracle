package _1_MyFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodList {
	ArrayList <FoodDTO> foodinfo = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	FoodList(){
		init();
		insert();
		while(true) {
			System.out.println("내가 좋아하는 음식");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식삭제");
			System.out.println("3. 음식 수정");
			System.out.println("4. 음식 전체보기");
			int num = in.nextInt();
			in.nextLine();
				if(num == 1) {
					create();
				}else if(num == 2) {
					delete();
				}else if(num == 3) {
					update();
				}else if(num == 4) {
					read();
				}else {
					break;
				}
			}
	}
	private void init() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	private void insert() {
		// TODO Auto-generated method stub
		FoodDTO f = new FoodDTO();
		f.setFoodName(null);
		f.setFoodType(null);
		f.setFoodTR(null);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
					,"system","11111111");
			String sql = "insert into FoodDTO values(?,?,?,default)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getFoodName());
			pstmt.setString(2, f.getFoodType());
			pstmt.setString(3, f.getFoodTR());
			int result = pstmt.executeUpdate();
			if(result == 0) {
				conn.rollback();
			}else {
				conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(Exception e2) {
					
				}
			}
		}
	}
	private void create() {
		try {
			System.out.println("좋아하는 음식");
			System.out.println("입력");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(result != null) {
				
			}
		}
		
	}
	private void delete() {
		
	}
	private void update() {
		
	}
	private void read() {
		
	}
}

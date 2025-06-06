package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CSDL {
	private static Connection ketNoi;
	private static final String  url ="jdbc:mysql://localhost:3308/ql_bansua?useUnicode=true&characterEncoding=UTF-8&useSSL=false";

	public static Connection getketNoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ketNoi = DriverManager.getConnection(url,"root","");
			return ketNoi;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
			
		}

	}
//	public static void main(String[]args) throws SQLException{
//		
//		Connection kn = getketNoi();
//		if(kn == null)
//			System.out.print("Kết nối thất bại");
//		else 
//			System.out.print("Kết nối thành công");
//		
//		
//		Statement stm ;
//		ResultSet rs ;
//		String sql = "select s.Ten_sua,h.Ten_hang_sua,l.Ten_loai,s.Trong_luong,s.Don_gia from sua s "+
//				 "inner join hang_sua h on h.Ma_hang_sua=s.Ma_hang_sua "+
//			     "inner join loai_sua l on l.Ma_loai_sua=s.Ma_loai_sua";
//		stm = kn.createStatement();
//		rs = stm.executeQuery(sql);
//		String ab ="",ac=""; 
//		while(rs.next()) {
//			ab=rs.getString("Ten_sua");
//			ac=rs.getString("Ten_hang_sua");
//			System.out.println(ab + " "+ ac);
//		}
//	
//	}

}

//select s.Ten_sua,h.Ten_hang_sua,l.Ten_loai,s.Trong_luong,s.Don_gia from sua s
//inner join hang_sua h on h.Ma_hang_sua=s.Ma_hang_sua
//inner join loai_sua l on l.Ma_loai_sua=s.Ma_loai_sua;
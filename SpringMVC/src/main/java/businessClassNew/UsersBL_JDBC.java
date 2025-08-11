package businessClassNew;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import JavaBeans.LoaiSua;
import JavaBeans.Users;

public class UsersBL_JDBC {
	private static  JdbcTemplate jdbc = CSDL2.getJdbc();
	 public static List<Users> getAll() {
	        String sql = "SELECT * FROM system_users";
	        return jdbc.query(sql, new RowMapper<Users>() {
	            @Override
	            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Users ls = new Users();
	                ls.setUsername(rs.getString("username"));
	                ls.setUser_id(rs.getString("user_id"));
	                ls.setStatus(rs.getString("status"));
	                ls.setPassword_hash(rs.getString("password_hash"));
	                ls.setRole(rs.getString("role"));
	                ls.setCreated_by(rs.getString("created_by"));
	                ls.setUpdated_by(rs.getString("updated_by"));
	                ls.setDeleted_by(rs.getString("deleted_by"));
	                return ls;
	            }
	        });
	    }
	 public static Users getUsersByName(String ml) {
		 String sql = "select * from  system_users where username = ?";
		 return jdbc.queryForObject(sql, new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int numRow) throws SQLException {
				Users ot = new Users();
				ot.setUsername(rs.getString("username"));
				ot.setUser_id(rs.getString("user_id"));
				ot.setStatus(rs.getString("status"));
				ot.setPassword_hash(rs.getString("password_hash"));
				ot.setRole(rs.getString("role"));
				ot.setCreated_by(rs.getString("created_by"));
				ot.setUpdated_by(rs.getString("updated_by"));
				ot.setDeleted_by(rs.getString("deleted_by"));
				return ot;
			}
		 }, ml);
	 }
	 public static int countUser() {
		 String sql = "select count(*) as stg from system_users";
		 
		 return jdbc.queryForObject(sql, new RowMapper<Integer>() {
			 @Override
			 public Integer mapRow(ResultSet rs , int numRow) throws SQLException {
				 return rs.getInt("stg");
			 }
		 });
		 
		 
	 }
//	 public static void main (String [] args ) {
//	 
//	 List<Users> ds = getAll();
//	 ds.forEach(at->System.out.println(at.getUser_id()  + " - " +at.getUsername()));
// }
}

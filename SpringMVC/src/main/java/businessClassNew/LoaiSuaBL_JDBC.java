package businessClassNew;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import JavaBeans.LoaiSua;

public class LoaiSuaBL_JDBC {

	private static  JdbcTemplate jdbc = CSDL2.getJdbc();
	 public static List<LoaiSua> getAll() {
	        String sql = "SELECT * FROM loai_sua";
	        return jdbc.query(sql, new RowMapper<LoaiSua>() {
	            @Override
	            public LoaiSua mapRow(ResultSet rs, int rowNum) throws SQLException {
	                LoaiSua ls = new LoaiSua();
	                ls.setMaLoai(rs.getString("ma_loai"));
	                ls.setTenLoai(rs.getString("ten_loai"));
	                return ls;
	            }
	        });
	    }
	 
	 public static LoaiSua getLoaiSuaByID (int id) {
		 String sql = "select * from  loai_sua where ma_loai_sua = ?";
		 return jdbc.queryForObject(sql, new RowMapper<LoaiSua>() {

			@Override
			public LoaiSua mapRow(ResultSet rs, int numRow) throws SQLException {
				LoaiSua ot = new LoaiSua();
				ot.setMaLoai(rs.getString("ma_loai"));
				ot.setTenLoai(rs.getString("ten_loai"));
				return ot;
			}
		 }, id);
	 }
	 public static int countLoaiSua() {
		 String sql = "select count(1) as stg  from loai_sua";
		 return jdbc.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int numRow) throws SQLException {
				
				return rs.getInt("stg");
			}
			 
		 });
	 }
//	 public static void main (String [] args ) {
//		 
//		 List<LoaiSua> ds = getAll();
//		 ds.forEach(at->System.out.println(at.getMaTen()  + " - " +at.getTenLoai()));
//	 }
}

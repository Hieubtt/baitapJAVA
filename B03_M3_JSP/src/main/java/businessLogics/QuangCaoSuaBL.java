package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javabeans.Sua;


public class QuangCaoSuaBL {
	public static List<Sua> docTatCa(){
		List<Sua> ds = new ArrayList<>();
		String sql = "select * from sua";
		try (Connection kn = CSDL.getketNoi()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Sua s = new Sua();
				s.setDonGia(rs.getInt("Don_gia"));
				s.setTrongLuong(rs.getInt("Trong_luong"));
				s.setHinhAnh(rs.getString("Hinh"));
				s.setThanhPhanDD(rs.getString("TP_Dinh_Duong"));
				s.setMaLoai(rs.getString("Ma_loai_sua"));
				s.setMaHang(rs.getString("Ma_hang_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaSua(rs.getString("Ma_sua"));
				s.setLoiIch(rs.getString("Loi_ich"));
				ds.add(s); /// add vào list
			}
			return ds;
		} catch (Exception e) {
			return null;
		}
		
	}
	public static void main(String[] args) {
		List<Sua> ds = docTatCa();
		ds.forEach(s ->System.out.println(s.getHinhAnh()));
	}
}





package businessClassNew;

import JavaBeans.HangSua;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hv
 */
public class HangSuaBL {
    public static List<HangSua> DocTatCa(){
        List<HangSua> dshs = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from hang_sua");
            dshs = new ArrayList<>();
            while(rs.next()){
                HangSua hs = new HangSua();
                hs.setMaHang(rs.getString("ma_hang_sua"));
                hs.setTenHang(rs.getString("ten_hang_sua"));
                hs.setDiaChi(rs.getString("dia_chi"));
                hs.setDienThoai(rs.getString("dien_thoai"));
                hs.setEmail(rs.getString("email"));
                dshs.add(hs);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dshs;
    }
    public static HangSua DocTheoMaHang(String maHang){
        HangSua hs = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from hang_sua where ma_hang_sua='"+maHang+"'");
            while(rs.next()){
                hs = new HangSua();
                hs.setMaHang(rs.getString("ma_hang_sua"));
                hs.setTenHang(rs.getString("ten_hang_sua"));
                hs.setDiaChi(rs.getString("dia_chi"));
                hs.setDienThoai(rs.getString("dien_thoai"));
                hs.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return hs;
    }
}

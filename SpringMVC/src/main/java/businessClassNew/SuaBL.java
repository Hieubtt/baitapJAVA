
package businessClassNew;
import JavaBeans.Sua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SuaBL {
    public static List<Sua> DocTatCa(){
        List<Sua> dsSua = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from sua");
            dsSua = new ArrayList<>();
            while(rs.next()){
                Sua s = new Sua();
                s.setMaSua(rs.getString("ma_sua"));
                s.setTenSua(rs.getString("ten_sua"));
                s.setMaLoai(rs.getString("ma_loai_sua"));
                s.setMaHang(rs.getString("ma_hang_sua"));
                s.setTrongLuong(rs.getInt("trong_luong"));
                s.setDonGia(rs.getInt("don_gia"));
                s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                s.setLoiIch(rs.getString("loi_ich"));
                s.setHinh(rs.getString("hinh"));
                dsSua.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dsSua;
    }
    public static List<Sua> TimTheoTen(String tenSua){
        List<Sua> dsSua = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from sua where ten_sua like '%"+tenSua+"%'");
            dsSua = new ArrayList<>();
            while(rs.next()){
                Sua s = new Sua();
                s.setMaSua(rs.getString("ma_sua"));
                s.setTenSua(rs.getString("ten_sua"));
                s.setMaLoai(rs.getString("ma_loai_sua"));
                s.setMaHang(rs.getString("ma_hang_sua"));
                s.setTrongLuong(rs.getInt("trong_luong"));
                s.setDonGia(rs.getInt("don_gia"));
                s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                s.setLoiIch(rs.getString("loi_ich"));
                s.setHinh(rs.getString("hinh"));
                dsSua.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dsSua;
    }
    public static List<Sua> TimTheoLoaiHangTen(String maLoai, String maHang, String tenSua){
        List<Sua> dsSua = null;
        try (Connection con = CSDL.LayKetNoi()){
            PreparedStatement pst = con.prepareStatement("select * from sua where ma_loai_sua = ? and ma_hang_sua=? and ten_sua like ?");
            pst.setString(1,maLoai);
            pst.setString(2,maHang);
            pst.setString(3,"%"+tenSua+"%");
            ResultSet rs = pst.executeQuery();
            dsSua = new ArrayList<>();
            while(rs.next()){
                Sua s = new Sua();
                s.setMaSua(rs.getString("ma_sua"));
                s.setTenSua(rs.getString("ten_sua"));
                s.setMaLoai(rs.getString("ma_loai_sua"));
                s.setMaHang(rs.getString("ma_hang_sua"));
                s.setTrongLuong(rs.getInt("trong_luong"));
                s.setDonGia(rs.getInt("don_gia"));
                s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
                s.setLoiIch(rs.getString("loi_ich"));
                s.setHinh(rs.getString("hinh"));
                dsSua.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dsSua;
    }
}

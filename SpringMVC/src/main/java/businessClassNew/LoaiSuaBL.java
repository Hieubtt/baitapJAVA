package businessClassNew;

import JavaBeans.LoaiSua;
import JavaBeans.Sua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hv
 */
public class LoaiSuaBL {
    public static List<LoaiSua> DocTatCa(){
        List<LoaiSua> dsls = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua");
            dsls = new ArrayList<>();
            while(rs.next()){
                LoaiSua ls = new LoaiSua();
                ls.setMaLoai(rs.getString("ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_loai"));
                dsls.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsls;
    }
    public static int them(LoaiSua ls) {
    	String sql = "insert into loai_sua (ma_loai_sua,ten_loai) values(?,?)";
    	
    	try (Connection kn = CSDL.LayKetNoi()){
            PreparedStatement pst = kn.prepareStatement(sql);
            
            pst.setString(1,ls.getMaLoai());
            pst.setString(2,ls.getTenLoai());
            return pst.executeUpdate();
            }
         catch (Exception ex) {
            return 0;
        }
    	
    }
    public static int capnhat(LoaiSua ls) {
    	String sql = "UPDATE loai_sua SET ten_loai = ? WHERE ma_loai_sua = ?";
    	
    	try (Connection kn = CSDL.LayKetNoi()){
            PreparedStatement pst = kn.prepareStatement(sql);
            
            pst.setString(1,ls.getTenLoai());
            pst.setString(2,ls.getMaLoai());
            return pst.executeUpdate();
            }
         catch (Exception ex) {
        	ex.printStackTrace(); 
            return 0;
        }
    	
    }
    public static int xoaLoaiSua(LoaiSua ls) {
    	String sql = "DELETE FROM loai_sua WHERE ma_loai_sua = ?";
    	
    	try (Connection kn = CSDL.LayKetNoi()){
            PreparedStatement pst = kn.prepareStatement(sql);
            
            pst.setString(1,ls.getMaLoai());
            ///pst.setString(2,ls.getMaLoai());
            return pst.executeUpdate();
            }
         catch (Exception ex) {
        	ex.printStackTrace(); 
            return 0;
        }
    	
    }
//    public class TestRun {
//        public static void main(String[] args) {
//            System.out.println("Chạy được rồi nè");
//        }
//    }
    
    public static List<LoaiSua> TimTheoLoaiSua(String LoaiSua){
        List<LoaiSua> dsLoai = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua where loai_sua like '%"+LoaiSua+"%'");
            dsLoai = new ArrayList<>();
            while(rs.next()){
            	LoaiSua ls = new LoaiSua();
                ls.setMaLoai(rs.getString("Ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_sua"));
                dsLoai.add(ls);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dsLoai;
    }
    
    public static List<LoaiSua> TimTheoLoaiSuaAll(){
        List<LoaiSua> dsLoai = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua order by Ten_loai  limit 10 ");
            dsLoai = new ArrayList<>();
            while(rs.next()){
            	LoaiSua ls = new LoaiSua();
                ls.setMaLoai(rs.getString("Ma_loai_sua"));
                ls.setTenLoai(rs.getString("Ten_loai"));
                dsLoai.add(ls);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dsLoai;
    }
    
//    public static void main(String args[]) {
//    	LoaiSua ls = new LoaiSua();
//    	ls.setMaLoai("AA");
//    	ls.setTenLoai("hehehuhu111");	
//    	capnhat(ls);
//    	
//    }
}

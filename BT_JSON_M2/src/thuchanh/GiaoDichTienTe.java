package thuchanh;

import java.time.LocalDate;

import org.json.simple.JSONObject;

public class GiaoDichTienTe extends GiaoDich {
	private String loaiTien;
    private double tiGia;
    private String loai; // "mua" hoặc "ban"

    public GiaoDichTienTe(String maGD, int soLuong, String loaiTien, double tiGia, String loai) {
        super(maGD, soLuong);
        this.loaiTien = loaiTien;
        this.tiGia = tiGia;
        this.loai = loai;
    }

    @Override
    public double thanhTien() {
        return soLuong * tiGia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loại tiền: " + loaiTien + ", Tỷ giá: " + tiGia + ", Loại: " + loai + ", Thành tiền: " + thanhTien();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("NgayGiaoDich", this.NgayGD);
        obj.put("Loai", "tiente");
        obj.put("maGD", maGD);
        obj.put("soLuong", soLuong);
        obj.put("loaiTien", loaiTien);
        obj.put("tiGia", tiGia);
        obj.put("loaiGiaoDich", loai);
        obj.put("thanhTien", thanhTien());
        return obj;
    }
}

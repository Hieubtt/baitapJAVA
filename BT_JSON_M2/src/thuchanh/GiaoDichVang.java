package thuchanh;

import org.json.simple.JSONObject;

public class GiaoDichVang extends GiaoDich {

	private String loaiVang;
    private double donGia;

    public GiaoDichVang(String maGD, int soLuong, String loaiVang, double donGia) {
        super(maGD, soLuong);
        this.loaiVang = loaiVang;
        this.donGia = donGia;
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loại vàng: " + loaiVang + ", Đơn giá: " + donGia + ", Thành tiền: " + thanhTien();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("NgayGiaoDich", this.NgayGD);
        obj.put("loai", "vang");
        obj.put("maGD", maGD);
        obj.put("soLuong", soLuong);
        obj.put("loaiVang", loaiVang);
        obj.put("donGia", donGia);
        obj.put("thanhTien", thanhTien());
        return obj;
    }

}

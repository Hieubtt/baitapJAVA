package thuchanh;

import java.time.LocalDate;

public abstract class GiaoDich {
    protected String maGD;
    protected int soLuong;
    protected LocalDate NgayGD = LocalDate.now();

    public GiaoDich(String maGD, int soLuong) {
        this.maGD = maGD;
        this.soLuong = soLuong;
    }

    public abstract double thanhTien();
    public abstract org.json.simple.JSONObject toJSON();

    @Override
    public String toString() {
        return "Mã GD: " + maGD + ", Số lượng: " + soLuong + ", Ngày Giao Dịch: " + NgayGD;
    }
}
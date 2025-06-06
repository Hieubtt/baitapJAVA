package javabeans;

import java.io.Serializable;

public class Sua implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String hinhAnh;
	private String LoiIch;
	private String thanhPhanDD;
	private int donGia;
	private int trongLuong;
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public Sua(String hinhAnh, String loiIch, String thanhPhanDD, int donGia, int trongLuong, String maLoai,
			String maHang, String tenSua, String maSua) {
		super();
		this.hinhAnh = hinhAnh;
		LoiIch = loiIch;
		this.thanhPhanDD = thanhPhanDD;
		this.donGia = donGia;
		this.trongLuong = trongLuong;
		this.maLoai = maLoai;
		this.maHang = maHang;
		this.tenSua = tenSua;
		this.maSua = maSua;
	}
	public Sua() {
		super();
	}
	public String getLoiIch() {
		return LoiIch;
	}
	public void setLoiIch(String loiIch) {
		LoiIch = loiIch;
	}
	public String getThanhPhanDD() {
		return thanhPhanDD;
	}
	public void setThanhPhanDD(String thanhPhanDD) {
		this.thanhPhanDD = thanhPhanDD;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenSua() {
		return tenSua;
	}
	public void setTenSua(String tenSua) {
		this.tenSua = tenSua;
	}
	public String getMaSua() {
		return maSua;
	}
	public void setMaSua(String maSua) {
		this.maSua = maSua;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String maLoai;
	private String maHang;
	private String tenSua;
	private String maSua;
	
	

}

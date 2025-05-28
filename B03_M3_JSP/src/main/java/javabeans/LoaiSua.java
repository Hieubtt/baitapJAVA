package javabeans;

import java.io.Serializable;
// thực thi giao tiếp Serializable
public class LoaiSua implements Serializable{
	private static final long serialVersionUID = 1L;
	private String maLoaiSua;
	private String tenLoaiSua;
	public String getMaLoaiSua() {
		return maLoaiSua;
	}
	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}
	public String getTenLoaiSua() {
		return tenLoaiSua;
	}
	public LoaiSua(String maLoaiSua, String tenLoaiSua) {
		super();
		this.maLoaiSua = maLoaiSua;
		this.tenLoaiSua = tenLoaiSua;
	}
	public LoaiSua() {
		super();
	}
	public void setTenLoaiSua(String tenLoaiSua) {
		this.tenLoaiSua = tenLoaiSua;
	}
}

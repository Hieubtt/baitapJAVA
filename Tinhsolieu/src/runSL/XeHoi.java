package runSL;

public class XeHoi implements DongCo, PhuongTienGT {
	String tenXe;
	String hangsanXuat;
	
	public String getTenXe() {
		return tenXe;
	}

	public XeHoi(String tenXe, String hangsanXuat) {
		super();
		this.tenXe = tenXe;
		this.hangsanXuat = hangsanXuat;
	}

	public XeHoi() {
		super();
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getHangsanXuat() {
		return hangsanXuat;
	}

	public void setHangsanXuat(String hangsanXuat) {
		this.hangsanXuat = hangsanXuat;
	}

	@Override
	public double tinhVanToc(double QuangDuong, double ThoiGian) {
		// TODO Auto-generated method stub
		return QuangDuong/ThoiGian;
	}

	@Override
	public double tinhTieuThuNhienLieu(double QuangDuong, double SoLit) {
		// TODO Auto-generated method stub
		return QuangDuong/SoLit;
	}

}

package runSL;

public class TauThuy implements DongCo, PhuongTienGT {
	double trongLuong;
	int sucTai;
	double vanTocxuoiDong;
	double vanTocnguocDong;
	double nhienLieuTieuHao;
	
	public TauThuy() {
		super();
	}

	public TauThuy(double trongLuong, int sucTai, double vanTocxuoiDong, double vanTocnguocDong,
			double nhienLieuTieuHao) {
		super();
		this.trongLuong = trongLuong;
		this.sucTai = sucTai;
		this.vanTocxuoiDong = vanTocxuoiDong;
		this.vanTocnguocDong = vanTocnguocDong;
		this.nhienLieuTieuHao = nhienLieuTieuHao;
	}

	public double getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(double trongLuong) {
		this.trongLuong = trongLuong;
	}

	public int getSucTai() {
		return sucTai;
	}

	public void setSucTai(int sucTai) {
		this.sucTai = sucTai;
	}

	public double getVanTocxuoiDong() {
		return vanTocxuoiDong;
	}

	public void setVanTocxuoiDong(double vanTocxuoiDong) {
		this.vanTocxuoiDong = vanTocxuoiDong;
	}

	public double getVanTocnguocDong() {
		return vanTocnguocDong;
	}

	public void setVanTocnguocDong(double vanTocnguocDong) {
		this.vanTocnguocDong = vanTocnguocDong;
	}

	public double getNhienLieuTieuHao() {
		return nhienLieuTieuHao;
	}

	public void setNhienLieuTieuHao(double nhienLieuTieuHao) {
		this.nhienLieuTieuHao = nhienLieuTieuHao;
	}

	@Override
	public double tinhVanToc(double QuangDuong, double ThoiGian) {
		// TODO Auto-generated method stub
		return (QuangDuong/ThoiGian) + this.vanTocxuoiDong - this.vanTocnguocDong
				;
	}

	@Override
	public double tinhTieuThuNhienLieu(double QuangDuong, double SoLit) {
		// TODO Auto-generated method stub
		return QuangDuong/(SoLit - this.nhienLieuTieuHao);
	}

}

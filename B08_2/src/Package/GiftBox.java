package Package;

public class GiftBox {

	public String hinhDang;
	public String mauSac;
	
	public String getHinhDang() {
		return hinhDang;
	}
	public void setHinhDang(String hinhDang) {
		this.hinhDang = hinhDang;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public int getPhilamHop() {
		return philamHop;
	}
	final int philamHop=10000;

	public GiftBox(String hinhDang, String mauSac) {
		super();
		this.hinhDang = hinhDang;
		this.mauSac = mauSac;
		
	}
	class Gift {
		public String Ten;
		public double trongLuong;
		
		final int donGia = 200;
		public void setTen(String Ten) {
			this.Ten = hinhDang;
		}
		public String getTen() {
			return Ten;
		}
		
		public void settrongLuong(Double trongLuong) {
			this.Ten = hinhDang;
		}
		public Double gettrongLuong() {
			
			return trongLuong;
		}
		
		public Gift(String ten, Double trongLuong) {
			super();
			Ten = ten;
			this.trongLuong = (trongLuong!=null)? trongLuong : 0.0;
		}
		
		public double tinhTienGui () {
			return this.trongLuong*this.donGia + GiftBox.this.philamHop;
			
		}
		
	}
	
}

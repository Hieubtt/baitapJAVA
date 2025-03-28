package thuchanh;

import java.io.Serializable;

public class Users  implements Serializable{

	String UserName;
	String Tel;
	String hinhAnh;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public Users() {
		super();
	}
	public Users(String userName, String tel, String hinhAnh) {
		super();
		UserName = userName;
		Tel = tel;
		this.hinhAnh = hinhAnh;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String toString() {
        return "Users{name='" + UserName + "', phone='" + Tel + "', linkhinh='" + hinhAnh + "'}";
    }
}

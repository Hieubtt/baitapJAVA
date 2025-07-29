package JavaBeans;

import java.io.Serializable;
import java.security.Timestamp;

public class Users implements Serializable{
	private String deleted_by ;
	private String updated_by ;
	private Timestamp updated_at;
	private Timestamp deleted_at ;
	private String created_by ;
	private Timestamp created_at ;
	private String status ;
	private String role ;
	public String getDeleted_by() {
		return deleted_by;
	}
	public void setDeleted_by(String deleted_by) {
		this.deleted_by = deleted_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public Users() {
		super();
		this.deleted_by = deleted_by;
		this.updated_by = updated_by;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.created_by = created_by;
		this.created_at = created_at;
		this.status = status;
		this.role = role;
		this.password_hash = password_hash;
		this.username = username;
		this.user_id = user_id;
	}
	public Timestamp getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	private String password_hash;
	private String username ;
	private String user_id ;
}

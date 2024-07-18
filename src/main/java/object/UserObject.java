package object;

public class UserObject {
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_pass;
	private int user_phone;
	private String user_address;
	private String user_img;
	private String user_date;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(int user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	@Override
	public String toString() {
		return "UserObject [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", user_phone=" + user_phone + ", user_address=" + user_address
				+ ", user_img=" + user_img + ", user_date=" + user_date + "]";
	}
	
	public UserObject(int user_id, String user_name, int user_phone) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
	}
	
	public UserObject() {
		
	}



}


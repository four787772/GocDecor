package object;

public class CustomerObject {
	private int customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_pass;
	private int customer_phone;
	private String customer_address;
	private String customer_img;
	private String customer_date;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_pass() {
		return customer_pass;
	}
	public void setCustomer_pass(String customer_pass) {
		this.customer_pass = customer_pass;
	}
	public int getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(int customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_img() {
		return customer_img;
	}
	public void setCustomer_img(String customer_img) {
		this.customer_img = customer_img;
	}
	public String getCustomer_date() {
		return customer_date;
	}
	public void setCustomer_date(String customer_date) {
		this.customer_date = customer_date;
	}
	@Override
	public String toString() {
		return "CustomerObject [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email="
				+ customer_email + ", customer_pass=" + customer_pass + ", customer_phone=" + customer_phone
				+ ", customer_address=" + customer_address + ", customer_img=" + customer_img + ", customer_date="
				+ customer_date + "]";
	}
	
	
}

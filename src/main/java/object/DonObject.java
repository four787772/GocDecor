package object;

public class DonObject {
	private int order_id; 
	private int order_makh; 
	private String order_namekh; 
	private int order_sdt; 
	private int order_masp; 
	private String order_namesp; 
	private int order_number; 
	private int order_pricesp; 
	private int order_pricefinaly;
	private String order_address;
	private String order_note;
	private String order_date;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
	public int getOrder_makh() {
		return order_makh;
	}
	public void setOrder_makh(int order_makh) {
		this.order_makh = order_makh;
	}
	public String getOrder_namekh() {
		return order_namekh;
	}
	public void setOrder_namekh(String order_namekh) {
		this.order_namekh = order_namekh;
	}
	public int getOrder_sdt() {
		return order_sdt;
	}
	public void setOrder_sdt(int order_sdt) {
		this.order_sdt = order_sdt;
	}
	public String getOrder_namesp() {
		return order_namesp;
	}
	
	public int getOrder_masp() {
		return order_masp;
	}
	public void setOrder_masp(int order_masp) {
		this.order_masp = order_masp;
	}
	public void setOrder_namesp(String order_namesp) {
		this.order_namesp = order_namesp;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public int getOrder_pricesp() {
		return order_pricesp;
	}
	public void setOrder_pricesp(int order_pricesp) {
		this.order_pricesp = order_pricesp;
	}
	public int getOrder_pricefinaly() {
		return order_pricefinaly;
	}
	public void setOrder_pricefinaly(int order_pricefinaly) {
		this.order_pricefinaly = order_pricefinaly;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_note() {
		return order_note;
	}
	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "DonObject [order_id=" + order_id + ", order_makh=" + order_makh + ", order_namekh=" + order_namekh
				+ ", order_sdt=" + order_sdt + ", order_namesp=" + order_namesp + ", order_number=" + order_number
				+ ", order_pricesp=" + order_pricesp + ", order_pricefinaly=" + order_pricefinaly + ", order_address="
				+ order_address + ", order_note=" + order_note + ", order_date=" + order_date + "]";
	}
	
	
	
	
	
	
	
}

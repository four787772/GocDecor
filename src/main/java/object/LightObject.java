package object;

public class LightObject extends CategoryObject {
	public int light_id;
	public String light_name;
	public int light_price;
	public int light_pricelegal;
	public int light_percen;
	public String light_material;
	public String light_color;
	public String light_size;
	public String light_state;
	public String light_img;
	public int rating;
	public int sales_count;
	public double light_revenue;

	public LightObject(int light_id, String light_name, int light_price, String light_material, String light_color,
			String light_size, String light_state, String light_img, int category_id, int rating, int sales_count, double light_revenue) {
		super(category_id);
		this.light_id = light_id;
		this.light_name = light_name;
		this.light_price = light_price;
		this.light_material = light_material;
		this.light_color = light_color;
		this.light_size = light_size;
		this.light_state = light_state;
		this.light_img = light_img;
		this.rating = rating;
		this.sales_count = sales_count;
		this.light_revenue = light_revenue;
	}

	public LightObject() {

	}

	public int getLight_id() {
		return light_id;
	}

	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}

	public String getLight_name() {
		return light_name;
	}

	public void setLight_name(String light_name) {
		this.light_name = light_name;
	}

	public int getLight_price() {
		return light_price;
	}

	public void setLight_price(int light_price) {
		this.light_price = light_price;
	}

	
	
	public int getLight_pricelegal() {
		return light_pricelegal;
	}

	public void setLight_pricelegal(int light_pricelegal) {
		this.light_pricelegal = light_pricelegal;
	}

	public int getLight_percen() {
		return light_percen;
	}

	public void setLight_percen(int light_percen) {
		this.light_percen = light_percen;
	}

	public String getLight_material() {
		return light_material;
	}

	public void setLight_material(String light_material) {
		this.light_material = light_material;
	}

	public String getLight_color() {
		return light_color;
	}

	public void setLight_color(String light_color) {
		this.light_color = light_color;
	}

	public String getLight_size() {
		return light_size;
	}

	public void setLight_size(String light_size) {
		this.light_size = light_size;
	}

	public String getLight_state() {
		return light_state;
	}

	public void setLight_state(String light_state) {
		this.light_state = light_state;
	}

	public String getLight_img() {
		return light_img;
	}

	public void setLight_img(String light_img) {
		this.light_img = light_img;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getSales_count() {
		return sales_count;
	}

	public void setSales_count(int sales_count) {
		this.sales_count = sales_count;
	}
	
	

	public double getLight_revenue() {
		return light_revenue;
	}

	public void setLight_revenue(double light_revenue) {
		this.light_revenue = light_revenue;
	}

	@Override
	public String toString() {
		return "LightObject [light_id=" + light_id + ", light_name=" + light_name + ", light_price=" + light_price
				+ ", light_pricelecal=" + light_pricelegal + ", light_percen=" + light_percen + ", light_material="
				+ light_material + ", light_color=" + light_color + ", light_size=" + light_size + ", light_state="
				+ light_state + ", light_img=" + light_img + ", rating=" + rating + ", sales_count=" + sales_count
				+ ", light_revenue=" + light_revenue + "]";
	}

	
}
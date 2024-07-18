package object;

public class RatingObject extends UserObject {

	public int rating_id;
	public int vote;
	public int light_id;
	public String rating_description;
	public RatingObject(int user_id, String user_name, int user_phone, int rating_id, int vote, int light_id,
			String rating_description) {
		super(user_id, user_name, user_phone);
		this.rating_id = rating_id;
		this.vote = vote;
		this.rating_description = rating_description;
	}
	public RatingObject(int user_id, String user_name, int user_phone) {
		super(user_id, user_name, user_phone);
	}
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public String getRating_description() {
		return rating_description;
	}
	public void setRating_description(String rating_description) {
		this.rating_description = rating_description;
	}
	
	
	public int getLight_id() {
		return light_id;
	}
	public void setLight_id(int light_id) {
		this.light_id = light_id;
	}
	@Override
	public String toString() {
		return "RatingObject [rating_id=" + rating_id + ", vote=" + vote + ",light_id="+light_id+", rating_description=" + rating_description
				+ ", User_id=" + getUser_id() + ", getUser_name()=" + getUser_name() + ", getUser_phone()="
				+ getUser_phone() + "]";
	}
	
	public RatingObject() {
		
	}
	
}

package object;

public class BlogObject {
	public int blog_id;
	public String blog_title;
	public String blog_description;
	public String blog_img;
	
	public BlogObject(int blog_id, String blog_title, String blog_description, String blog_img) {
		super();
		this.blog_id = blog_id;
		this.blog_title = blog_title;
		this.blog_description = blog_description;
		this.blog_img = blog_img;
	}

	public BlogObject() {
		super();
	}

	@Override
	public String toString() {
		return "BlogObject [blog_id=" + blog_id + ", blog_title=" + blog_title + ", blog_description="
				+ blog_description + ", blog_img="+blog_img+"]";
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_description() {
		return blog_description;
	}

	public void setBlog_description(String blog_description) {
		this.blog_description = blog_description;
	}

	public String getBlog_img() {
		return blog_img;
	}

	public void setBlog_img(String blog_img) {
		this.blog_img = blog_img;
	}
	
	
	
	
	
}

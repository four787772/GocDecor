package blog;

import java.util.ArrayList;

import object.BlogObject;
import util.ConnectionPool;

public interface BlogFunction {
	public boolean addBlog(BlogObject item);

	public boolean editBlog(BlogObject item);

	public boolean delBlog(BlogObject item);

	public BlogObject getBlog(int id);

	public ArrayList<BlogObject> getBlogs();

	public ConnectionPool getCP();

	public void releaseConnection();
}

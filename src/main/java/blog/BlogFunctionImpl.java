package blog;

import java.sql.Connection;
import object.*;
import util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class BlogFunctionImpl implements BlogFunction {
	private Connection con;
	private ConnectionPool cp;

	public BlogFunctionImpl(ConnectionPool cp) {
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}
		// xin ket noi
		try {
			this.con = this.cp.getConnection("User");
			// cham dut che do thuc thu tu dong cua ket noi
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean exe(PreparedStatement pre) {
		if (pre != null) {
			// pre da duoc bien dich va truyen day du gia tri cho tham so
			try {
				int result = pre.executeUpdate();
				// neu thuc thi cau lenh SQL khong thanh cong
				if (result == 0) {
					// Khôi phục trạng thái SQL về thời điểm chưa thực thi
					this.con.rollback();
					return false;
				}
				// xac nhan thuc thi SQL thanh cong
				this.con.commit();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			} finally {
				// giải phóng tài nguyên sql, nhưng có thể tái sử dụng sau khi đóng kết nối
				pre = null;
			}
		}
		return false;
	}

	@Override
	public boolean addBlog(BlogObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO blog (");
		sql.append("blog_title, blog_description, blog_img)");
		sql.append("VALUES(?,?,?)");

		// bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getBlog_title());
			pre.setString(2, item.getBlog_description());
			pre.setString(3, item.getBlog_img());

			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean editBlog(BlogObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE blog SET ");
		sql.append("blog_title=?, blog_description=?, blog_img=?");
		sql.append(" WHERE blog_id=?");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getBlog_title());
			pre.setString(2, item.getBlog_description());
			pre.setString(3, item.getBlog_img());
			pre.setInt(4, item.getBlog_id());
			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delBlog(BlogObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM blog WHERE blog_id = ?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getBlog_id());

			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public BlogObject getBlog(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM blog WHERE (blog_id=?)";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			BlogObject item = null;
			if (rs != null) {
				if (rs.next()) {
					item = new BlogObject();
					item.setBlog_id(rs.getInt("blog_id"));
					item.setBlog_title(rs.getString("blog_title"));
					item.setBlog_description(rs.getString("blog_description"));
					item.setBlog_img(rs.getString("blog_img"));

				}
			}
			return item;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

//	@Override
//	public ArrayList<BlogObject> getBlogs(BlogObject similar, int at, byte total) {
//		// TODO Auto-generated method stub
//		return null;
//		
//	}
//	

	@Override
	public ArrayList<BlogObject> getBlogs() {
		ArrayList<BlogObject> results = new ArrayList<>();
		String sql = "SELECT * FROM blog";

		// Sử dụng try-with-resources để tự động đóng PreparedStatement và ResultSet
		try (PreparedStatement pre = this.con.prepareStatement(sql); ResultSet rs = pre.executeQuery()) {
			while (rs.next()) {
				BlogObject item = new BlogObject();
				item.setBlog_id(rs.getInt("blog_id"));
				item.setBlog_title(rs.getString("blog_title"));
				item.setBlog_description(rs.getString("blog_description"));
				item.setBlog_img(rs.getString("blog_img"));
				results.add(item);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return results;
	}

	@Override
	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		// TODO Auto-generated method stub
		try {
			this.cp.releaseConnection(this.con, "User");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BlogFunction lf = new BlogFunctionImpl(null);

////		test cho hàm add
//		BlogObject nItem = new BlogObject();
//		nItem.setBlog_title("DenTest");
//		nItem.setBlog_description("test");
//		boolean results = lf.addBlog(nItem);
//		System.out.println(results);

////		Test cho hàm edit
//		BlogObject BlogObject = new BlogObject();
//        BlogObject.setBlog_id(8); // Replace with actual Blog ID
//        BlogObject.setBlog_title("Updated Blog Name");
//        BlogObject.setBlog_description("edit"); // Replace with updated price
//                try {
//            boolean success = lf.editBlog(BlogObject);
//            if (success) {
//                System.out.println("Den da duoc cap nhat thanh cong!");
//            } else {
//                System.out.println("Cap nhat den khong thanh cong");
//            }
//        } catch (Exception e) {
//            System.err.println("Loi cap nhat den: ");
//            e.printStackTrace();
//        }

////		Test cho hàm del
//		BlogObject BlogObject = new BlogObject();
//        BlogObject.setBlog_id(8); // Replace with actual Blog ID
//        // Attempt to delete the Blog using delBlog
//        try {
//            boolean success = lf.delBlog(BlogObject);
//            if (success) {
//                System.out.println("Da xoa den thanh cong!");
//            } else {
//                System.out.println("Xoa den khong thanh cong.");
//            }
//        } catch (Exception e) {
//            System.err.println("Loi xoa den:");
//            e.printStackTrace();
//        }

		BlogObject item = lf.getBlog(2);
		System.out.println(item);

////		Test cho hàm lấy danh sách Blog
//		ArrayList<BlogObject> gitem1 = lf.getBlogs();
//		System.out.println(gitem1);
//		

	}

}

package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.UserObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class UserFunctionImpl implements UserFunction{

private Connection con;

    private ConnectionPool cp;

    public UserFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
        	this.cp = new ConnectionPoolImpl();
//            cp = new ConnectionPoolImpl();
        } else {
        	this.cp = cp;
        }

        //Xin kết nối
        try {
            this.con = this.cp.getConnection("User");

            //Chấm dứt chế độ thực thi tự động của kết nối
            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean exe(PreparedStatement pre) {
        if (pre != null) {
            // pre đã được biên dịch và truyền đầy đủ giá trị cho tham số
            try {
                int result = pre.executeUpdate();
                if (result == 0) {
                    this.con.rollback();
                    return false;
                }

                // Xác nhận thực thi sau cùng
                this.con.commit();
                return true;

            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();

                try {
                    this.con.rollback();
                } catch (SQLException e1) {
                    // TODO: handle exception
                    e1.printStackTrace();
                }
            } finally {
                pre = null;
            }
        }
        return false;
    }


	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tbnuser(");
        sql.append("user_name, user_email, user_pass, user_phone, user_address, user_img, user_date)");
        sql.append("VALUES(?, ?, ?,?,?,?,?)");

        // Biên dịch
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getUser_name());
            pre.setString(2, item.getUser_email());
            pre.setString(3, item.getUser_pass());
            pre.setInt(4, item.getUser_phone());
            pre.setString(5, item.getUser_address());
            pre.setString(6, item.getUser_img());
            pre.setString(7, item.getUser_date());
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
	public boolean editUser(UserObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tbnuser SET ");
        sql.append("user_name = ?, user_email = ?, user_pass = ?, user_phone = ?, user_address = ?, user_img = ?, user_date = ?");
        sql.append("WHERE user_id = ?");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getUser_name());
            pre.setString(2, item.getUser_email());
            pre.setString(3, item.getUser_pass());
            pre.setInt(4, item.getUser_phone());
            pre.setString(5, item.getUser_address());
            pre.setString(6, item.getUser_img());
            pre.setString(7, item.getUser_date());
            pre.setInt(8, item.getUser_id());

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
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbnuser WHERE user_id = ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getUser_id());

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
	public UserObject getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbnuser WHERE user_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();

            UserObject item = null;
            if (rs != null) {
            	if (rs.next()) {
            		item = new UserObject();
                    item.setUser_id(rs.getInt("user_id"));
                    item.setUser_name(rs.getString("user_name"));
                    item.setUser_email(rs.getString("user_email"));
                    item.setUser_pass(rs.getString("user_pass"));
                    item.setUser_phone(rs.getInt("user_phone"));
                    item.setUser_address(rs.getString("user_address"));
                    item.setUser_img(rs.getString("user_img"));
                    item.setUser_date(rs.getString("user_date"));
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

	@Override
	public UserObject getUser(String username, String password) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM tbnuser WHERE (user_name = ?) AND (user_pass = ?)";
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            pre.setString(1, username);
	            pre.setString(2, password);

	            ResultSet rs = pre.executeQuery();

	            UserObject item = null;
	            if (rs != null) {
	            	if (rs.next()) {
	            		item = new UserObject();
	                    item.setUser_id(rs.getInt("user_id"));
	                    item.setUser_name(rs.getString("user_name"));
	                    item.setUser_email(rs.getString("user_email"));
	                    item.setUser_pass(rs.getString("user_pass"));
	                    item.setUser_phone(rs.getInt("user_phone"));
	                    item.setUser_address(rs.getString("user_address"));
	                    item.setUser_img(rs.getString("user_img"));
	                    item.setUser_date(rs.getString("user_date"));
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

	@Override
	public ArrayList<UserObject> getUsers(UserObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		 ArrayList<UserObject> results = new ArrayList<>();
	        UserObject item = null;

	        String sql = "SELECT * FROM tbnuser";
	        sql += " ";
	        sql += "ORDER BY user_id DESC ";
	        sql += "LIMIT " + at + ", " + total;

	        //Biên dịch câu lệnh
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            //Lấy ra tập bản ghi
	            ResultSet rs = pre.executeQuery();
	            if (rs != null) {
	                while (rs.next()) {
	                    item = new UserObject();
	                    item.setUser_id(rs.getInt("user_id"));
	                    item.setUser_name(rs.getString("user_name"));
	                    item.setUser_email(rs.getString("user_email"));
	                    item.setUser_pass(rs.getString("user_pass"));
	                    item.setUser_phone(rs.getInt("user_phone"));
	                    item.setUser_address(rs.getString("user_address"));
	                    item.setUser_img(rs.getString("user_img"));
	                    item.setUser_date(rs.getString("user_date"));
	                    results.add(item);
	                }
	                rs.close();
	            }

	        } catch (SQLException e) {// TODO Auto-generated catch block
	            e.printStackTrace();

	            //Nếu câu lệnh sql có lỗi thì trở lại trạng thái an toàn của kết nối
	            try {
	                this.con.rollback();
	            } catch (SQLException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        }

	        return results;
	}

	@Override
	public ArrayList<UserObject> getAccount() {
		// TODO Auto-generated method stub
		ArrayList<UserObject> results = new ArrayList<>();
        UserObject item = null;

        String sql = "SELECT user_name, user_pass FROM tbluser";

        //Biên dịch câu lệnh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //Lấy ra tập bản ghi
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item = new UserObject();
                    item.setUser_name(rs.getString("user_name"));
                    item.setUser_pass(rs.getString("user_pass"));

                    results.add(item);
                }
                rs.close();
            }

        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();

            //Nếu câu lệnh sql có lỗi thì trở lại trạng thái an toàn của kết nối
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        return results;
	}

	public static void main(String[] args) {
        UserFunction uf = new UserFunctionImpl(null);


        UserObject user = uf.getUser("Mung", "12345");
        user.setUser_address("Yen Phuc");
		System.out.println(user);

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

}

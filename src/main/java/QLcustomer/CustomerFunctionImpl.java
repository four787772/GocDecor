package QLcustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.CustomerObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class CustomerFunctionImpl implements CustomerFunction{
	
	private Connection con;

    private ConnectionPool cp;

    public CustomerFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
        	this.cp = new ConnectionPoolImpl();
//            cp = new ConnectionPoolImpl();
        } else {
        	this.cp = cp;
        }

        //Xin kết nối
        try {
            this.con = this.cp.getConnection("Customer");

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
	public boolean addCustomer(CustomerObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO customer(");
        sql.append("customer_name, customer_email, customer_pass, customer_phone, customer_address, customer_img, customer_date)");
        sql.append("VALUES(?, ?, ?,?,?,?,?)");

        // Biên dịch
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getCustomer_name());
            pre.setString(2, item.getCustomer_email());
            pre.setString(3, item.getCustomer_pass());
            pre.setInt(4, item.getCustomer_phone());
            pre.setString(5, item.getCustomer_address());
            pre.setString(6, item.getCustomer_img());
            pre.setString(7, item.getCustomer_date());
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
	public boolean editCustomer(CustomerObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("UPDATE customer SET ");
        sql.append("customer_name = ?, customer_email = ?, customer_pass = ?, customer_phone = ?, customer_address = ?, customer_img = ?, customer_date = ?");
        sql.append("WHERE customer_id = ?");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getCustomer_name());
            pre.setString(2, item.getCustomer_email());
            pre.setString(3, item.getCustomer_pass());
            pre.setInt(4, item.getCustomer_phone());
            pre.setString(5, item.getCustomer_address());
            pre.setString(6, item.getCustomer_img());
            pre.setString(7, item.getCustomer_date());
            pre.setInt(8, item.getCustomer_id());

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
	public boolean delCustomer(CustomerObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customer WHERE customer_id = ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getCustomer_id());

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
	public CustomerObject getCustomer(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer WHERE customer_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();

            CustomerObject item = null;
            if (rs != null) {
            	if (rs.next()) {
            		item = new CustomerObject();
                    item.setCustomer_id(rs.getInt("customer_id"));
                    item.setCustomer_name(rs.getString("customer_name"));
                    item.setCustomer_email(rs.getString("customer_email"));
                    item.setCustomer_pass(rs.getString("customer_pass"));
                    item.setCustomer_phone(rs.getInt("customer_phone"));
                    item.setCustomer_address(rs.getString("customer_address"));
                    item.setCustomer_img(rs.getString("customer_img"));
                    item.setCustomer_date(rs.getString("customer_date"));
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
	public CustomerObject getCustomer(String Customername, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer WHERE (customer_name = ?) AND (customer_pass = ?)";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, Customername);
            pre.setString(2, password);

            ResultSet rs = pre.executeQuery();

            CustomerObject item = null;
            if (rs != null) {
            	if (rs.next()) {
            		item = new CustomerObject();
                    item.setCustomer_id(rs.getInt("customer_id"));
                    item.setCustomer_name(rs.getString("customer_name"));
                    item.setCustomer_email(rs.getString("customer_email"));
                    item.setCustomer_pass(rs.getString("customer_pass"));
                    item.setCustomer_phone(rs.getInt("customer_phone"));
                    item.setCustomer_address(rs.getString("customer_address"));
                    item.setCustomer_img(rs.getString("customer_img"));
                    item.setCustomer_date(rs.getString("customer_date"));
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
	public ArrayList<CustomerObject> getCustomers(CustomerObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		ArrayList<CustomerObject> results = new ArrayList<>();
        CustomerObject item = null;

        String sql = "SELECT * FROM customer";
        sql += " ";
        sql += "ORDER BY customer_id DESC ";
        sql += "LIMIT " + at + ", " + total;

        //Biên dịch câu lệnh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //Lấy ra tập bản ghi
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item = new CustomerObject();
                    item.setCustomer_id(rs.getInt("customer_id"));
                    item.setCustomer_name(rs.getString("customer_name"));
                    item.setCustomer_email(rs.getString("customer_email"));
                    item.setCustomer_pass(rs.getString("customer_pass"));
                    item.setCustomer_phone(rs.getInt("customer_phone"));
                    item.setCustomer_address(rs.getString("customer_address"));
                    item.setCustomer_img(rs.getString("customer_img"));
                    item.setCustomer_date(rs.getString("customer_date"));
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
	public ArrayList<CustomerObject> getAccount() {
		// TODO Auto-generated method stub
		ArrayList<CustomerObject> results = new ArrayList<>();
        CustomerObject item = null;

        String sql = "SELECT customer_name, customer_pass FROM customer";

        //Biên dịch câu lệnh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //Lấy ra tập bản ghi
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    item = new CustomerObject();
                    item.setCustomer_name(rs.getString("customer_name"));
                    item.setCustomer_pass(rs.getString("customer_pass"));

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
        CustomerFunction uf = new CustomerFunctionImpl(null);


        CustomerObject user = new CustomerObject();
        user.setCustomer_id(2);
        user.setCustomer_name("Nhung");
        user.setCustomer_email("h");
        user.setCustomer_pass("22222");
        user.setCustomer_phone(24597486);
        user.setCustomer_address("ddd");
        user.setCustomer_img("");
        user.setCustomer_date("");
        boolean user1 = uf.addCustomer(user);
        
		System.out.println(user1);

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
			this.cp.releaseConnection(this.con, "Customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

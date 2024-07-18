package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.DealObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class ProductFunctionImpl implements ProductFunction{

	private Connection con;

    private ConnectionPool cp;

    public ProductFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
        	this.cp = new ConnectionPoolImpl();
        	// cp = new ConnectionPoolImpl();
        } else {
        	this.cp = cp;
        }

        //Xin kết nối
        try {
            this.con = this.cp.getConnection("Product");

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
	public boolean addDeal(DealObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO light(");
        sql.append("light_name, light_price,");
        sql.append("light_percen, light_material, light_color,");
        sql.append(" light_size, light_state, light_img)");
        sql.append("VALUES(?,?,?,?,?,?,?,?)");

        // Biên dịch
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getLight_name());
            pre.setInt(2, item.getLight_price());

            pre.setInt(3, item.getLight_percen());
            pre.setString(4, item.getLight_material());
            pre.setString(5, item.getLight_color());
            pre.setString(6, item.getLight_size());
            pre.setString(7, item.getLight_state());
            pre.setString(8, item.getLight_img());
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
	public boolean editDeal(DealObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("UPDATE light SET ");
        sql.append("light_name = ?, light_price = ?,");
        sql.append("light_percen = ?, light_material = ?, light_color = ?,");
        sql.append(" light_size = ?, light_state = ?, light_img = ? ");
        sql.append(" WHERE light_id = ?");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, item.getLight_name());
            pre.setInt(2, item.getLight_price());

            pre.setInt(3, item.getLight_percen());
            pre.setString(4, item.getLight_material());
            pre.setString(5, item.getLight_color());
            pre.setString(6, item.getLight_size());
            pre.setString(7, item.getLight_state());
            pre.setString(8, item.getLight_img());
            pre.setInt(9, item.getLight_id());
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
	public boolean delDeal(DealObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM light WHERE light_id = ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getLight_id());

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
	public DealObject getDeal(int id) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM light WHERE light_id = ?";
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            pre.setInt(1, id);

	            ResultSet rs = pre.executeQuery();

	            DealObject item = null;
	            if (rs != null) {
	            	if (rs.next()) {
	            		item = new DealObject();
	                    item.setLight_id(rs.getInt("light_id"));
	                    item.setLight_name(rs.getString("light_name"));
	                    item.setLight_price(rs.getInt("light_price"));
	                    item.setLight_pricelegal(rs.getInt("light_pricelegal"));
	                    item.setLight_percen(rs.getInt("light_percen"));
	                    item.setLight_material(rs.getString("light_material"));
	                    item.setLight_size(rs.getString("light_size"));
	                    item.setLight_color(rs.getString("light_color"));
	                    item.setSales_count(rs.getInt("sales_count"));
	                    item.setLight_state(rs.getString("light_state"));
	                    item.setLight_img(rs.getString("light_img"));
	                    
	                   
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
	public ArrayList<DealObject> getAccount() {
		// TODO Auto-generated method stub
		 ArrayList<DealObject> results = new ArrayList<>();
	        DealObject item = null;

	        String sql = "SELECT * FROM light";

	        //Biên dịch câu lệnh
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            //Lấy ra tập bản ghi
	            ResultSet rs = pre.executeQuery();
	            if (rs != null) {
	                while (rs.next()) {
	                    item = new DealObject();
	                    item.setLight_id(rs.getInt("light_id"));
	                    item.setLight_name(rs.getString("light_name"));
	                    item.setLight_price(rs.getInt("light_price"));
	                    item.setLight_pricelegal(rs.getInt("light_pricelegal"));
	                    item.setLight_percen(rs.getInt("light_percen"));
	                    item.setLight_material(rs.getString("light_material"));
	                    item.setLight_size(rs.getString("light_size"));
	                    item.setLight_color(rs.getString("light_color"));
	                    item.setSales_count(rs.getInt("sales_count"));
	                    item.setLight_state(rs.getString("light_state"));
	                    item.setLight_img(rs.getString("light_img"));
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
		 ProductFunction uf = new ProductFunctionImpl(null);

		 	DealObject nItem = new DealObject();
			nItem.setLight_name("hoa");
			nItem.setLight_price(111);

			nItem.setLight_percen(20000000);
			nItem.setLight_material("hoa loi");
			nItem.setLight_size("hoa loi");
			nItem.setLight_img("hoa loi");
			nItem.setLight_color("hoa loi");
			nItem.setLight_state("hoa loi");
			boolean results = uf.editDeal(nItem);

			if (!results) {
					System.out.println("Thêm KHÔNG THÀNH CÔNG");
				}

			ArrayList<DealObject> dealList = uf.getAccount(); // Lấy danh sách giao dịch

	    // Hiển thị danh sách giao dịch
	    for (DealObject deal : dealList) {
	        System.out.println(deal);
	    }
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
			this.cp.releaseConnection(this.con, "Product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

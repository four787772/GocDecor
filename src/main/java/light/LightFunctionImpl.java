package light;

import java.sql.Connection;



import object.*;

import util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class LightFunctionImpl implements LightFunction {
	private Connection con;
	private ConnectionPool cp;

	public LightFunctionImpl(ConnectionPool cp) {
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
	public boolean addLight(LightObject item) {
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
	public boolean editLight(LightObject item) {
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
	public boolean delLight(LightObject item) {
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
	public LightObject getLight(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM light WHERE (light_id=?)";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			LightObject item = null;
			if (rs != null) {
				if (rs.next()) {
					item = new LightObject();
					item.setLight_id(rs.getInt("light_id"));
					item.setLight_name(rs.getString("light_name"));
					item.setLight_price(rs.getInt("light_price"));
					item.setLight_pricelegal(rs.getInt("light_pricelegal"));
                    item.setLight_percen(rs.getInt("light_percen"));
					item.setLight_material(rs.getString("light_material"));
					item.setLight_color(rs.getString("light_color"));
					item.setLight_size(rs.getString("light_size"));
					item.setLight_state(rs.getString("light_state"));
					item.setLight_img(rs.getString("light_img"));
					item.setCategory_id(rs.getInt("category_id"));
					item.setRating(rs.getInt("rating"));
					item.setSales_count(rs.getInt("sales_count"));
					item.setLight_revenue(rs.getDouble("light_revenue"));
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
//	public ArrayList<LightObject> getLights(LightObject similar, int at, byte total) {
//		// TODO Auto-generated method stub
//		return null;
//		
//	}
//	
	@Override
	public ArrayList<LightObject> getLights(int category_id) {
		ArrayList<LightObject> results = new ArrayList<>();
		String sql = "SELECT * FROM light WHERE category_id = ?";

		// Sử dụng try-with-resources để tự động đóng PreparedStatement và ResultSet
		try (PreparedStatement pre = this.con.prepareStatement(sql)) {
			pre.setInt(1, category_id);

			try (ResultSet rs = pre.executeQuery()) {
				while (rs.next()) {
					LightObject item = new LightObject();
					item.setLight_id(rs.getInt("light_id"));
					item.setLight_name(rs.getString("light_name"));
					item.setLight_price(rs.getInt("light_price"));
					item.setLight_pricelegal(rs.getInt("light_pricelegal"));
                    item.setLight_percen(rs.getInt("light_percen"));
					item.setLight_material(rs.getString("light_material"));
					item.setLight_color(rs.getString("light_color"));
					item.setLight_size(rs.getString("light_size"));
					item.setLight_state(rs.getString("light_state"));
					item.setLight_img(rs.getString("light_img"));
					item.setCategory_id(rs.getInt("category_id"));
					item.setRating(rs.getInt("rating"));
					item.setSales_count(rs.getInt("sales_count"));
					item.setLight_revenue(rs.getDouble("light_revenue"));
					results.add(item);
				}
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
	public ArrayList<LightObject> getLights() {
		ArrayList<LightObject> results = new ArrayList<>();
		String sql = "SELECT * FROM light";

		// Sử dụng try-with-resources để tự động đóng PreparedStatement và ResultSet
		try (PreparedStatement pre = this.con.prepareStatement(sql); ResultSet rs = pre.executeQuery()) {
			while (rs.next()) {
				LightObject item = new LightObject();
				item.setLight_id(rs.getInt("light_id"));
				item.setLight_name(rs.getString("light_name"));
				item.setLight_price(rs.getInt("light_price"));
				item.setLight_pricelegal(rs.getInt("light_pricelegal"));
                item.setLight_percen(rs.getInt("light_percen"));
				item.setLight_material(rs.getString("light_material"));
				item.setLight_color(rs.getString("light_color"));
				item.setLight_size(rs.getString("light_size"));
				item.setLight_state(rs.getString("light_state"));
				item.setLight_img(rs.getString("light_img"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setRating(rs.getInt("rating"));
				item.setSales_count(rs.getInt("sales_count"));
				item.setLight_revenue(rs.getDouble("light_revenue"));
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
	public ArrayList<LightObject> get5MaxRevenue() {
		// TODO Auto-generated method stub
		ArrayList<LightObject> list = new ArrayList<>();
		String sql = "SELECT * FROM light ORDER BY light_revenue DESC LIMIT 5";
		try (PreparedStatement pre = this.con.prepareStatement(sql); ResultSet rs = pre.executeQuery()) {
			while (rs.next()) {
				LightObject item = new LightObject();
				item.setLight_id(rs.getInt("light_id"));
				item.setLight_name(rs.getString("light_name"));
				item.setLight_price(rs.getInt("light_price"));
				item.setLight_pricelegal(rs.getInt("light_pricelegal"));
                item.setLight_percen(rs.getInt("light_percen"));
				item.setLight_material(rs.getString("light_material"));
				item.setLight_color(rs.getString("light_color"));
				item.setLight_size(rs.getString("light_size"));
				item.setLight_state(rs.getString("light_state"));
				item.setLight_img(rs.getString("light_img"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setRating(rs.getInt("rating"));
				item.setSales_count(rs.getInt("sales_count"));
				item.setLight_revenue(rs.getDouble("light_revenue"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<LightObject> get5MaxSales_count() {
		// TODO Auto-generated method stub
		ArrayList<LightObject> list = new ArrayList<>();
		String sql = "SELECT * FROM light ORDER BY sales_count DESC LIMIT 5";
		try (PreparedStatement pre = this.con.prepareStatement(sql); ResultSet rs = pre.executeQuery()) {
			while (rs.next()) {
				LightObject item = new LightObject();
				item.setLight_id(rs.getInt("light_id"));
				item.setLight_name(rs.getString("light_name"));
				item.setLight_price(rs.getInt("light_price"));
				item.setLight_pricelegal(rs.getInt("light_pricelegal"));
                item.setLight_percen(rs.getInt("light_percen"));
				item.setLight_material(rs.getString("light_material"));
				item.setLight_color(rs.getString("light_color"));
				item.setLight_size(rs.getString("light_size"));
				item.setLight_state(rs.getString("light_state"));
				item.setLight_img(rs.getString("light_img"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setRating(rs.getInt("rating"));
				item.setSales_count(rs.getInt("sales_count"));
				item.setLight_revenue(rs.getDouble("light_revenue"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return list;
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
	
	@Override
	public ArrayList<LightObject> getAccount() {
		// TODO Auto-generated method stub
		 ArrayList<LightObject> results = new ArrayList<>();
	        LightObject item = null;

	        String sql = "SELECT * FROM light";

	        //Biên dịch câu lệnh
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            //Lấy ra tập bản ghi
	            ResultSet rs = pre.executeQuery();
	            if (rs != null) {
	                while (rs.next()) {
	                	item = new LightObject();
	    				item.setLight_id(rs.getInt("light_id"));
	    				item.setLight_name(rs.getString("light_name"));
	    				item.setLight_price(rs.getInt("light_price"));
	    				item.setLight_pricelegal(rs.getInt("light_pricelegal"));
	                    item.setLight_percen(rs.getInt("light_percen"));
	    				item.setLight_material(rs.getString("light_material"));
	    				item.setLight_color(rs.getString("light_color"));
	    				item.setLight_size(rs.getString("light_size"));
	    				item.setLight_state(rs.getString("light_state"));
	    				item.setLight_img(rs.getString("light_img"));
	    				item.setCategory_id(rs.getInt("category_id"));
	    				item.setRating(rs.getInt("rating"));
	    				item.setSales_count(rs.getInt("sales_count"));
	    				item.setLight_revenue(rs.getDouble("light_revenue"));
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
		LightFunction lf = new LightFunctionImpl(null);

	 	LightObject nItem = new LightObject();
		nItem.setLight_name("hoa");
		nItem.setLight_price(111);
		nItem.setLight_percen(20000000);
		nItem.setLight_material("hoa loi");
		nItem.setLight_size("hoa loi");
		nItem.setLight_img("hoa loi");
		nItem.setLight_color("hoa loi");
		nItem.setLight_state("hoa loi");
		boolean results = lf.addLight(nItem);

		if (!results) {
				System.out.println("Thêm KHÔNG THÀNH CÔNG");
			}

		ArrayList<LightObject> dealList = lf.getAccount(); // Lấy danh sách giao dịch

    // Hiển thị danh sách giao dịch
    for (LightObject deal : dealList) {
        System.out.println(deal);
    }

////		test cho hàm add
//		LightObject nItem = new LightObject();
//		nItem.setLight_name("DenTest");
//		nItem.setLight_price(200000);
//		nItem.setLight_material("Nhựa");
//		nItem.setLight_color("Đen");
//		nItem.setLight_size("23*12cm");
//		nItem.setLight_state("Hết hàng");
//		nItem.setCategory_id(2);
//		boolean results = lf.addLight(nItem);
//		System.out.println(results);

//		Test cho hàm edit
//		LightObject lightObject = new LightObject();
//        lightObject.setLight_id(64); // Replace with actual light ID
//        lightObject.setLight_name("Updated Light Name");
//        lightObject.setLight_price(200000); // Replace with updated price
//        lightObject.setLight_material("Updated Material");
//        lightObject.setLight_color("Updated Color");
//        lightObject.setLight_size("Updated Size");
//        lightObject.setLight_state("Updated State");
//        lightObject.setLight_img("Updated Image URL");
//        lightObject.setCategory_id(1); // Replace with updated category ID
//        // Attempt to edit the light using editLight
//        try {
//            boolean success = lf.editLight(lightObject);
//            if (success) {
//                System.out.println("Den da duoc cap nhat thanh cong!");
//            } else {
//                System.out.println("Cap nhat den khong thanh cong");
//            }
//        } catch (Exception e) {
//            System.err.println("Loi cap nhat den: ");
//            e.printStackTrace();
//        }
//		

//		Test cho hàm del
//		LightObject lightObject = new LightObject();
//        lightObject.setLight_id(66); // Replace with actual light ID
//        // Attempt to delete the light using delLight
//        try {
//            boolean success = lf.delLight(lightObject);
//            if (success) {
//                System.out.println("Da xoa den thanh cong!");
//            } else {
//                System.out.println("Xoa den khong thanh cong.");
//            }
//        } catch (Exception e) {
//            System.err.println("Loi xoa den:");
//            e.printStackTrace();
//        }

		// Test cho hàm lấy danh sách light theo category_id
//		ArrayList<LightObject> gitem = lf.getLights(4);
//		System.out.println(gitem);
////		
//		
		LightObject item = lf.getLight(20);
		System.out.println(item);

//		Test cho hàm lấy danh sách light
		ArrayList<LightObject> gitem1 = lf.get5MaxRevenue();
		System.out.println(gitem1);
//		

	}

	@Override
	public ArrayList<LightObject> searchProducts(String query) {
		// TODO Auto-generated method stub
		ArrayList<LightObject> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = cp.getConnection(query); // Lấy connection từ ConnectionPool
            String sql = "SELECT * FROM light WHERE light_name LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + query + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                LightObject dealObject = new LightObject();
                dealObject.setLight_id(rs.getInt("light_id"));
                dealObject.setLight_name(rs.getString("light_name"));
                dealObject.setLight_img(rs.getString("light_img"));
                dealObject.setLight_percen(rs.getInt("light_percen"));
                dealObject.setLight_price(rs.getInt("light_price"));
                dealObject.setLight_pricelegal(rs.getInt("light_pricelegal"));
                list.add(dealObject);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        } finally {
            try {
                // Giải phóng tài nguyên
                if (rs != null) {
					rs.close();
				}
                if (ps != null) {
					ps.close();
				}
                if (conn != null)
				 {
					cp.releaseConnection(conn, query); // Trả connection vào ConnectionPool
				}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
	
	}

	




}

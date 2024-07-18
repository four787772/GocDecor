package Donhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import object.DonObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class DonFunctionImpl implements DonFunction{
	private Connection con;

    private ConnectionPool cp;

    public DonFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
        	this.cp = new ConnectionPoolImpl();
        	// cp = new ConnectionPoolImpl();
        } else {
        	this.cp = cp;
        }

        //Xin kết nối
        try {
            this.con = this.cp.getConnection("Don");

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
	public boolean addDon(DonObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO donhang(");
        sql.append("order_makh, order_namekh, order_sdt, order_masp, order_namesp, ");
        sql.append("order_number, order_pricesp, order_address, order_note) ");
        sql.append("VALUES(?,?,?,?,?,?,?,?,?)");

        // Biên dịch
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getOrder_makh());
            pre.setString(2, item.getOrder_namekh());
            pre.setInt(3, item.getOrder_sdt());
            pre.setInt(4, item.getOrder_masp());
            pre.setString(5, item.getOrder_namesp());
            pre.setInt(6, item.getOrder_number());
            pre.setInt(7, item.getOrder_pricesp());
            pre.setString(8, item.getOrder_address());
            pre.setString(9, item.getOrder_note());
            /*pre.setString(8, item.getOrder_date());*/
            
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
	public boolean editDon(DonObject item) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
        sql.append("UPDATE donhang SET ");
        sql.append("order_makh = ?, order_namekh = ?, order_sdt = ?, order_namesp = ?, ");
        sql.append("order_number = ?, order_pricesp = ?, order_address = ?, order_note = ?");
        sql.append(" WHERE order_id = ?");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getOrder_makh());
            pre.setString(2, item.getOrder_namekh());
            pre.setInt(3, item.getOrder_sdt());
            pre.setString(4, item.getOrder_namesp());
            pre.setInt(5, item.getOrder_number());
            pre.setInt(6, item.getOrder_pricesp());
            pre.setString(7, item.getOrder_address());
            pre.setString(8, item.getOrder_note());
           /* pre.setString(8, item.getOrder_date());*/
            pre.setInt(9, item.getOrder_id());
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
	public boolean delDon(DonObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM donhang WHERE order_id = ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, item.getOrder_id());

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
	public DonObject getDon(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donhang WHERE order_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();

            DonObject item = null;
            if (rs != null) {
            	if (rs.next()) {
            		item = new DonObject();
                    item.setOrder_id(rs.getInt("order_id"));
                    item.setOrder_makh(rs.getInt("order_makh"));
                    item.setOrder_namekh(rs.getString("order_namekh"));
                    item.setOrder_sdt(rs.getInt("order_sdt"));
                    item.setOrder_masp(rs.getInt("order_masp"));
                    item.setOrder_namesp(rs.getString("order_namesp"));
                    item.setOrder_number(rs.getInt("order_number"));
                    item.setOrder_pricesp(rs.getInt("order_pricesp"));
                    item.setOrder_address(rs.getString("order_address"));
                    item.setOrder_note(rs.getString("order_note"));
                    item.setOrder_date(rs.getString("order_date"));
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
	public DonObject getDonFull(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donhang WHERE order_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();

            DonObject item = null;
            if (rs != null) {
            	if (rs.next()) {
            		item = new DonObject();
                    item.setOrder_id(rs.getInt("order_id"));
                    item.setOrder_makh(rs.getInt("order_makh"));
                    item.setOrder_namekh(rs.getString("order_namekh"));
                    item.setOrder_sdt(rs.getInt("order_sdt"));
                    item.setOrder_masp(rs.getInt("order_masp"));
                    item.setOrder_namesp(rs.getString("order_namesp"));
                    item.setOrder_number(rs.getInt("order_number"));
                    item.setOrder_pricesp(rs.getInt("order_pricesp"));
                    item.setOrder_pricefinaly(rs.getInt("order_pricefinaly"));
                    item.setOrder_address(rs.getString("order_address"));
                    item.setOrder_note(rs.getString("order_note"));
                    item.setOrder_date(rs.getString("order_date"));
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
	public ArrayList<DonObject> getAccount() {
		// TODO Auto-generated method stub
		 ArrayList<DonObject> results = new ArrayList<>();
	        DonObject item = null;

	        String sql = "SELECT * FROM donhang";

	        //Biên dịch câu lệnh
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            //Lấy ra tập bản ghi
	            ResultSet rs = pre.executeQuery();
	            if (rs != null) {
	                while (rs.next()) {
	                    item = new DonObject();
	                    item.setOrder_id(rs.getInt("order_id"));
	                    item.setOrder_makh(rs.getInt("order_makh"));
	                    item.setOrder_namekh(rs.getString("order_namekh"));
	                    item.setOrder_sdt(rs.getInt("order_sdt"));
	                    item.setOrder_masp(rs.getInt("order_masp"));
	                    item.setOrder_namesp(rs.getString("order_namesp"));
	                    item.setOrder_number(rs.getInt("order_number"));
	                    item.setOrder_pricesp(rs.getInt("order_pricesp"));
	                    item.setOrder_pricefinaly(rs.getInt("order_pricefinaly"));
	                    item.setOrder_address(rs.getString("order_address"));
	                    item.setOrder_note(rs.getString("order_note"));
	                    item.setOrder_date(rs.getString("order_date"));
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
	public ArrayList<DonObject> getAccountFull() {
		// TODO Auto-generated method stub
		 ArrayList<DonObject> results = new ArrayList<>();
	        DonObject item = null;

	        String sql = "SELECT * FROM donhang";

	        //Biên dịch câu lệnh
	        try {
	            PreparedStatement pre = this.con.prepareStatement(sql);
	            //Lấy ra tập bản ghi
	            ResultSet rs = pre.executeQuery();
	            if (rs != null) {
	                while (rs.next()) {
	                    item = new DonObject();
	                    item.setOrder_id(rs.getInt("order_id"));
	                    item.setOrder_makh(rs.getInt("order_makh"));
	                    item.setOrder_namekh(rs.getString("order_namekh"));
	                    item.setOrder_sdt(rs.getInt("order_sdt"));
	                    item.setOrder_masp(rs.getInt("order_masp"));
	                    item.setOrder_namesp(rs.getString("order_namesp"));
	                    item.setOrder_number(rs.getInt("order_number"));
	                    item.setOrder_pricesp(rs.getInt("order_pricesp"));
	                    item.setOrder_pricefinaly(rs.getInt("order_pricefinaly"));
	                    item.setOrder_address(rs.getString("order_address"));
	                    item.setOrder_note(rs.getString("order_note"));
	                    item.setOrder_date(rs.getString("order_date"));
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
		 DonFunction uf = new DonFunctionImpl(null);
		 
	
			ArrayList<DonObject> list1 = uf.getAccountFull(); // Lấy danh sách giao dịch

	    // Hiển thị danh sách giao dịch
			List<Integer> matrix1 = new ArrayList<>();
			for(DonObject item : list1) {
				if (!matrix1.contains(item.getOrder_number())) {
	                matrix1.add(item.getOrder_number());
	            }
			}
			
			
			int n = matrix1.size();
			
			int[] matrix5 = new int[n];
			for (int i = 0; i < n; i++) {
	            Set<Integer> uniqueCustomers1 = new HashSet<>();
	            int targetQuantity = matrix1.get(i);

	            for (DonObject item1 : list1) {
	                if (item1.getOrder_number() == targetQuantity) {
	                    uniqueCustomers1.add(item1.getOrder_id());
	                }
	            }
	            matrix5[i] = uniqueCustomers1.size();
			}

			
			int[] matrix2 = new int[n];
			for (int i = 0; i < n; i++) {
	            Set<Integer> uniqueCustomers = new HashSet<>();
	            int targetQuantity = matrix1.get(i);

	            for (DonObject item1 : list1) {
	                if (item1.getOrder_number() == targetQuantity) {
	                    uniqueCustomers.add(item1.getOrder_makh());
	                }
	            }
	            matrix2[i] = uniqueCustomers.size();
			}

			Integer[] matrix3 = matrix1.toArray(new Integer[matrix1.size()]);
			
			double[] matrix4 = new double[matrix3.length];

			for (int i = 0; i < matrix3.length; i++) {
			    matrix4[i] = matrix3[i] * 0.24;
			    matrix4[i] = matrix4[i] * matrix5[i] * 0.24;
			}
			
			
			int maxsl = matrix3[0]; // Giả sử phần tử đầu tiên là giá trị lớn nhất

			for (int i = 1; i < matrix3.length; i++) {
			    if (matrix3[i] > maxsl) {
			        maxsl = matrix3[i]; // Cập nhật giá trị max nếu tìm thấy phần tử lớn hơn
			    }
			}
			System.out.print("matrix5:");
		    for (int value : matrix5) {
		        System.out.print(value);
		    }
		    System.out.println("matrix3:");
		    for (int value : matrix3) {
		        System.out.print(value);
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

package rating;
import java.sql.Connection;
import object.*;
import util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class RatingFunctionImpl {
	private Connection con;
	private ConnectionPool cp;
	
	
	
	public RatingFunctionImpl(ConnectionPool cp) {
		if(cp == null) {
			this.cp = new ConnectionPoolImpl();
		}else {
			this.cp = cp;
		}
		//xin ket noi  
		try {
			this.con = this.cp.getConnection("User");
			//cham dut che do thuc thu tu dong cua ket noi
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean exe (PreparedStatement pre) {
		if(pre != null) {
			//pre da duoc bien dich va truyen day du gia tri cho tham so
			try {
				int result = pre.executeUpdate();
				//neu thuc thi cau lenh SQL khong thanh cong
				if(result == 0) {
					//Khôi phục trạng thái SQL về thời điểm chưa thực thi
					this.con.rollback();
					return false;
				}
				//xac nhan thuc thi SQL thanh cong
				this.con.commit();
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
				try {
                    this.con.rollback();
                } catch (SQLException e1) {
                    // TODO: handle exception
                    e1.printStackTrace();
                }
			} finally {
				//giải phóng tài nguyên sql, nhưng có thể tái sử dụng sau khi đóng kết nối
				pre = null;
			}
		}
		return false;
	}
	
	
	public boolean addRating(RatingObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO rating (");
		sql.append("user_id, light_id, user_name, user_phone,");
		sql.append("vote, rating_description)");
		sql.append("VALUES(?,?, ?,?,?, ?)");
		
		//bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setInt(1, item.getUser_id());
			pre.setInt(2, item.getLight_id());
			pre.setString(3, item.getUser_name());
			pre.setInt(4, item.getUser_phone());
			pre.setInt(5, item.getVote());
			pre.setString(6, item.getRating_description());
			
			return this.exe(pre);
		}catch (SQLException e) {
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

	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp; 
	}

	public void releaseConnection() {
		// TODO Auto-generated method stub
		try {
			this.cp.releaseConnection(this.con, "User");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<RatingObject> getRatings() {
	    ArrayList<RatingObject> results = new ArrayList<>();
	    String sql = "SELECT * FROM rating";

	    // Sử dụng try-with-resources để tự động đóng PreparedStatement và ResultSet
	    try (PreparedStatement pre = this.con.prepareStatement(sql);
	         ResultSet rs = pre.executeQuery()) {
	        while (rs.next()) {
	            RatingObject item = new RatingObject();
	            item.setRating_id(rs.getInt("rating_id"));
	            item.setUser_id(rs.getInt("user_id"));
	            item.setLight_id(rs.getInt("light_id"));
	            item.setUser_name(rs.getString("user_name"));
	            item.setUser_phone(rs.getInt("user_phone"));
	            item.setVote(rs.getInt("vote"));
	            item.setRating_description(rs.getString("rating_description"));
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
	
	public static void main(String[] args) {
		RatingFunctionImpl lf = new RatingFunctionImpl(null);
		
//		test cho hàm add
		RatingObject nItem = new RatingObject();
		nItem.setUser_id(98);
		nItem.setUser_name("DenTest");
		nItem.setVote(3);
		nItem.setRating_description("Nhựa");
		
		boolean results = lf.addRating(nItem);
		System.out.println(results);
		System.out.println(nItem);
		
		ArrayList<RatingObject> item = lf.getRatings();
		System.out.println(item);
		
		
    }

	

	
	
	
}

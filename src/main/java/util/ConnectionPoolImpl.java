package util;

import java.sql.*;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {
	private String driver;
	private String username;
	private String password;
	private String url;
//	luu cac con vao stack de quan ly
	private Stack<Connection> pool;

	public ConnectionPoolImpl() {
		// xac dinh trinh dieu khien
		this.driver = "com.mysql.cj.jdbc.Driver";

		// nap trinh dieu khien, bao dam la da tai trinh dieu khien ket noi jdbc truoc
		// khi su dung no de ket noi sql
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// xac dinh tai khoan lam viec
		this.username = "four";
		this.password = "Abcd1234";

		// xac dinh duong dan thuc thi
		this.url = "jdbc:mysql://localhost:3306/gocdecore";

		// cap phat bo nho cho pool
		this.pool = new Stack<>();
	}

	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub
		if (this.pool.isEmpty()) {
			System.out.println(objectName + " da khoi tao 1 ket noi moi.");
			return DriverManager.getConnection(this.url, this.username, this.password);
		} else {
			System.out.println(objectName + " da lay ra 1 ket noi");
			return this.pool.pop();
		}
	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(objectName + " da tra lai ket noi.");
		this.pool.push(con);
	}

	// giai phong pool
	protected void finalized() throws Throwable {
		this.pool.clear();
		this.pool = null;
		System.out.println("Cpool da duoc dong lai cho CPool moi ra doi.");
	}

}

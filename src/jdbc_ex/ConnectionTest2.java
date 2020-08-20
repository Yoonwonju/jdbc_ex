package jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest2 {
	public static void main(String[] args) {
		connection_oracle();
	}

	private static void connection_oracle() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false";
		String user = "exam";
		String pwd = "rootroot";

		try (Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT DEPT_NO , DEPT_NAME, FLOOR FROM DEPARTMENT d");) {
			while (rs.next()) {
				int deptNo = rs.getInt("DEPT_NO");
				String deptName = rs.getString("DEPT_NAME");
				int floor = rs.getInt("FLOOR");
				System.out.printf("%d %s %d%n", deptNo, deptName, floor);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}


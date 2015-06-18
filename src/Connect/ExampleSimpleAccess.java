package Connect;
import java.sql.*;

public class ExampleSimpleAccess {

	public static void main(String[] args) { 

		String url = "jdbc:mysql://62.79.16.16:3306/grp17";
		String dbName = "grp17";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "grp17";
		String password = "rfkcFb5y";

		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url, userName, password);

			Statement st = conn.createStatement();
//			st.executeUpdate("insert into test(id) value (33);");

			System.out.println(st.executeQuery("select id from test where id=22;"));
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
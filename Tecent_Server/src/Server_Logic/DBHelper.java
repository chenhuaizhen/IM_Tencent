package Server_Logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String url = 
			"jdbc:mysql://127.0.0.1:3306/user?characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "";
	private static Connection con = null;
	static{
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			con = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection(){
		return con;
	}
}

package dbtuil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {

	static DBUtil dbUtil; 
			
	private DBUtil() {
		
	}
	
	public static DBUtil getInstance() {
		if(dbUtil==null) {
			dbUtil = new DBUtil();
		}
		
		return dbUtil;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/board/serverTimezone=UTC";
		String id = "ssafy";
		String pw = "ssafy";
		
		
		return DriverManager.getConnection(url,id,pw);
		
	}
	
	
	
	public static void closeAll(AutoCloseable... autocloses) throws Exception {
		
		for(AutoCloseable autoclose:autocloses) {
			if(autoclose!=null) {
				autoclose.close();
			}
		}
	}
}

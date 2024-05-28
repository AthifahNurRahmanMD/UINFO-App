package UINFO.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//untuk membangun koneksi, that's why ada nama file database tifaa
public class DbConfig {
    private static final String URL = "jdbc:sqlite:UKTUH.db";

	public static Connection connect() {
    	Connection conn = null;
    	try {
        	conn = DriverManager.getConnection(URL);
        	System.out.println("Koneksi berhasil ke SQLite.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return conn;
	}
}

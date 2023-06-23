package com.hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperaConexion() throws SQLException {
		
		String urlSQL = "jdbc:mysql://localhost/hotel?useTimeZone=true&serveTimeZone=UTC";
		String usuarioSQL = "root";
		String passSQL = "1234";
		
			return DriverManager.getConnection(urlSQL, usuarioSQL,passSQL);
		}

}

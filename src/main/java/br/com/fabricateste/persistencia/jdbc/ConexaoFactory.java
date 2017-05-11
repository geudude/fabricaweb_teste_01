package br.com.fabricateste.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		
		//retorna o link pro banco/nomedobanco, usuario, senha
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","login","senha");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//relancando a exception
			throw new RuntimeException(e);
		}
	}
	
}

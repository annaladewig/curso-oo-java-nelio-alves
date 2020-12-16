package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	//Método para conectar com o Banco de Dados.
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//Método para fechar a conexão com o Banco de Dados.
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//Método auxiliar para carregar os dados (propriedades do banco de dados) que estão salvos no arquivo db.properties.
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	// Método para fechar o Statement.
	public static void closeStatemente(Statement st) {
		if (st != null) { //Ou seja, no caso de ele estar instanciado.
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Método para fechar o ResultSet.
		public static void closeResultSet(ResultSet rs) {
			if (rs != null) { //Ou seja, no caso de ele estar instanciado.
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
		}
}

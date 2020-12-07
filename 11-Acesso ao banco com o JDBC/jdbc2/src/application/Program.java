package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
			
public class Program {	// PROGRAMA PARA RECUPERAR DADOS

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;	// Serve para você montar um comando SQL para ser executado.
		ResultSet rs = null;	// Um objeto contendo o resultado da consulta em formato de tabela.
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement(); //Instancia o objeto do tipo Statement.
			
			rs = st.executeQuery("SELECT * FROM department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{	
			//Como são recursos externos, não controlados pela JVM, é importante fechá-los manualmente.
			DB.closeResultSet(rs);
			DB.closeStatemente(st);
			DB.closeConnection();
		}
	}

}

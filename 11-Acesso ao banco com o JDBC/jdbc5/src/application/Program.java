package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;
import db.DbIntegrityException;

public class Program {	 // PROGRAMA PARA ALTERAR DADOS

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;  // Objeto que permite você montar a sua consulta SQL deixando os parâmetros para colocar depois.
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
			
			st.setInt(1, 2);

			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffected);
		} 
		catch (Exception e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatemente(st);
			DB.closeConnection();
		}
	}
}

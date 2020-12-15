package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Program {	 // PROGRAMA PARA ALTERAR DADOS

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;  // Objeto que permite voc� montar a sua consulta SQL deixando os par�metros para colocar depois.
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)"
					);
			
			st.setDouble(1, 200.00);  // O n�mero � 1 porque vai substituir a 1� interroga��o.
			st.setInt(2, 2);		  // O n�mero � 2 porque vai substituir a 2� interroga��o.
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffected);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatemente(st);
			DB.closeConnection();
		}
	}
}

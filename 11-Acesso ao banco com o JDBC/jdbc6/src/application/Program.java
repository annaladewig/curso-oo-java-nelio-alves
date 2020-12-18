package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {	 // PROGRAMA PARA ALTERAR DADOS

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false); // Para não confirmar as operações automaticamente. Todas as operações vão ficar pendentes de uma confirmação explicita do programador.
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			//Simulação de erro no meio da transação.
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error.");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
		
			conn.commit(); // Assim, todo o bloco acima fica protegido por uma lógica de transação.
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
		} 
		catch (Exception e) {
			try {
				conn.rollback(); // Volta a transação, o BD volta ao estado inicial.
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatemente(st);
			DB.closeConnection();
		}
	}
}

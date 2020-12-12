package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {	 // PROGRAMA PARA INSERIR DADOS

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;	// Objeto que permite voc� montar a sua consulta SQL deixando os par�metros para colocar depois.
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", // A interroga��o vai ser o Place Holder, � um lugar aonde depois voc� vai colocar o valor. 
					Statement.RETURN_GENERATED_KEYS
					);
			
			st.setString(1, "Carl Purple"); // O 1 � o index da 1� interroga��o.
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.00);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate(); // O resultado dessa opera��o � um inteiro indicando quantas linhas foram alteradas.
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); 
				while (rs.next()) {
					int id = rs.getInt(1); // O 1 � para indicar que eu quero o valor da 1� coluna.
					System.out.println("Done! Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatemente(st);
			DB.closeConnection();
		}
	}
}

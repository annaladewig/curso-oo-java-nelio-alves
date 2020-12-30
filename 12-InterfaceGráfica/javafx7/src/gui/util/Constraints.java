package gui.util;

import javafx.scene.control.TextField;

// Classe de Limita��es, com m�todos para adicionar um Listener nos controles e assim controlar os controles.
public class Constraints {
	
	//Listener � uma fun��o para ser executada quando o controle sofrer alguma modifica��o ou intera��o com o usu�rio.
	
	//Verifica se o valor n�o � nulo e se ele atende a express�o regular que, nesse caso, verifica se o valor � diferente de inteiro. Se sim, n�o vai aceitar a modifica��o no texto. 
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {  //obs (observable) � uma refer�ncia para o controle.
			if (newValue != null && !newValue.matches("\\d*")) { //A letra d representa um d�gito e o * representa qualquer quantidade.
				txt.setText(oldValue);
			}
		});
	}
	//Verifica se o valor n�o � nulo e se ele atende a express�o regular que, nesse caso, verifica se o tamanho do novo valor � maior que o tamanho m�ximo. Se sim, n�o vai aceitar a modifica��o no texto.
	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	//Verifica se o valor n�o � nulo e se ele atende a express�o regular que, nesse caso, verifica se o valor � diferente de double. Se sim, n�o vai aceitar a modifica��o no texto. 
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) { //A express�o regular teste se tem uma quantidade de d�gitos, depois um ponto (opcional), depois outra quantidade de d�gitos.
				txt.setText(oldValue);
			}
		});
	}
}
package gui.util;

import javafx.scene.control.TextField;

// Classe de Limitações, com métodos para adicionar um Listener nos controles e assim controlar os controles.
public class Constraints {
	
	//Listener é uma função para ser executada quando o controle sofrer alguma modificação ou interação com o usuário.
	
	//Verifica se o valor não é nulo e se ele atende a expressão regular que, nesse caso, verifica se o valor é diferente de inteiro. Se sim, não vai aceitar a modificação no texto. 
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {  //obs (observable) é uma referência para o controle.
			if (newValue != null && !newValue.matches("\\d*")) { //A letra d representa um dígito e o * representa qualquer quantidade.
				txt.setText(oldValue);
			}
		});
	}
	//Verifica se o valor não é nulo e se ele atende a expressão regular que, nesse caso, verifica se o tamanho do novo valor é maior que o tamanho máximo. Se sim, não vai aceitar a modificação no texto.
	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	//Verifica se o valor não é nulo e se ele atende a expressão regular que, nesse caso, verifica se o valor é diferente de double. Se sim, não vai aceitar a modificação no texto. 
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) { //A expressão regular teste se tem uma quantidade de dígitos, depois um ponto (opcional), depois outra quantidade de dígitos.
				txt.setText(oldValue);
			}
		});
	}
}
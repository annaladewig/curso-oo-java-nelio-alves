package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {

	@FXML
	private Button btTest;

	@FXML
	public void onBtTestAction() {
		Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.INFORMATION);
		// O AlertType é um tipo enumerado. Dependendo da escolha do tipo, a figura muda.
		// Para deixar mais limpo visualmente, você pode deixar o Header como null.
	}
}

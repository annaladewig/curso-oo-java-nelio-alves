package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application { // Existem tamb�m os m�todos init e stop (para coisas que voc� quer que aconte�am antes da aplica��o iniciar ou depois dela encerrar).
	@Override
	public void start(Stage primaryStage) { // M�todo obrigat�rio. Traz como argumento o Palco, que � um objeto criado automaticamente pelo JavaFx.
		try {
			BorderPane root = new BorderPane(); // Cria um objeto de Painel.
			Scene scene = new Scene(root,400,400); // Cria uma Cena.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //Pega os estilos do arquivo css, no caso de voc� querer formatar a tela personalizada. 
			primaryStage.setScene(scene); // "Adiciona" a cena ao Palco Principal.
			primaryStage.show(); // Mostra na tela do computador o conte�do do Palco.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); // M�todo est�tico da Classe Application que serve para iniciar a aplica��o JavaFx.
	}
}

/*Para rodar, � necess�rio fazer uma configura��o de build. 
 * Bot�o direito no projeto -> Run As -> Run Configurations -> Arguments -> VM Arguments e escrever:
 * --module-path C:\java-libs\javafx-sdk-11.0.2\lib --add-modules=javafx.fxml,javafx.controls
 * O endere�o � o endere�o onde est� a biblioteca do JavaFx.
 */
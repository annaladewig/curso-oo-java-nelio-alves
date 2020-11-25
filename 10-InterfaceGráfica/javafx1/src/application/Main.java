package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application { // Existem também os métodos init e stop (para coisas que você quer que aconteçam antes da aplicação iniciar ou depois dela encerrar).
	@Override
	public void start(Stage primaryStage) { // Método obrigatório. Traz como argumento o Palco, que é um objeto criado automaticamente pelo JavaFx.
		try {
			BorderPane root = new BorderPane(); // Cria um objeto de Painel.
			Scene scene = new Scene(root,400,400); // Cria uma Cena.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //Pega os estilos do arquivo css, no caso de você querer formatar a tela personalizada. 
			primaryStage.setScene(scene); // "Adiciona" a cena ao Palco Principal.
			primaryStage.show(); // Mostra na tela do computador o conteúdo do Palco.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); // Método estático da Classe Application que serve para iniciar a aplicação JavaFx.
	}
}

/*Para rodar, é necessário fazer uma configuração de build. 
 * Botão direito no projeto -> Run As -> Run Configurations -> Arguments -> VM Arguments e escrever:
 * --module-path C:\java-libs\javafx-sdk-11.0.2\lib --add-modules=javafx.fxml,javafx.controls
 * O endereço é o endereço onde está a biblioteca do JavaFx.
 */
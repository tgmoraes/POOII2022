package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// definindo os controls
			Label lblNome = new Label("Nome: ");
			Label lblMsg = new Label("Olá...");
			Label lblCabecalho = new Label("Meu primeiro sistema JavaFX :D");
			TextField txtNome = new TextField();
			Button btnOk = new Button("ok");
			// definindo acao do botao
			btnOk.setOnAction(e -> {
				String msg = String.format("Olá %s !", txtNome.getText());
				lblMsg.setText(msg);
			});
			
			//criando panes
			BorderPane root = new BorderPane();
			HBox cima = new HBox();
			VBox meio = new VBox();

			// define o class do CSS
			lblMsg.getStyleClass().add("msg");
			lblCabecalho.getStyleClass().add("texto");
			cima.getStyleClass().add("box");
			meio.getStyleClass().add("box");
			lblNome.getStyleClass().add("texto");

			//montando os panes
			cima.getChildren().addAll(lblNome, txtNome);
			meio.getChildren().addAll(cima, lblMsg, btnOk);

			
			root.setTop(lblCabecalho);
			root.setCenter(meio);
			
			//codigo auto gerado: cria scena, carrega css, seta ascena e mostra!
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

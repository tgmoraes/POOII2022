package br.edu.ifrs.osorio.parte5TesteFXmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Ideia;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;

    @Override
    public void start(Stage sta)  {
        stage = sta;
        HashMap<String, Object> dados = new HashMap<>();
        stage.setUserData(dados);
    	carregaTela("listaIdeias");
    	stage.show();
    }

	public static void carregaTela(String view) {
		App.carregaTela(view, null, null);
	}
	public static void carregaTela(String view, Object valor,String chave) {
		try{
			addDados(valor, chave);
			Scene scene = new Scene(loadFXML(view), 640, 480);
			stage.setScene(scene);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void addDados(Object valor, String chave) {
		if(valor!=null) {
			var dados = (HashMap<String,Object>)stage.getUserData();
			dados.put(chave, valor);
		}
	}
	public static Object getDados(String chave) {
		var dados = (HashMap<String,Object>)stage.getUserData();
		return dados.get(chave);
	}
	public static Object tiraDados(String chave) {
		var dados = (HashMap<String,Object>)stage.getUserData();
		return dados.remove(chave);
	}
    private static Parent loadFXML(String fxml) throws IOException {
    	fxml = "/views/"+fxml+".fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }



}
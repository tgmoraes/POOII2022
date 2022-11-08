package br.edu.ifrs.osorio.parte5TesteFXmaven.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.edu.ifrs.osorio.parte5TesteFXmaven.App;
import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Ideia;
import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Urgencia;
import br.edu.ifrs.osorio.parte5TesteFXmaven.persistencia.IdeiaDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroIdeiaController implements Initializable{

    @FXML private ComboBox<String> selUrgencia;
    @FXML private TextArea txtDescricao;
    @FXML private TextField txtTitulo;
    private Ideia ideia;

    @FXML 
    void handleSalvar(ActionEvent event) {
    	IdeiaDAO idao = new IdeiaDAO();
    	if(this.isAlterar()) {
    		this.ideia.setDescricao(this.txtDescricao.getText());
    		this.ideia.setTitulo(this.txtTitulo.getText());
    		this.ideia.setUrgencia(Urgencia.getUrgencia(this.selUrgencia.getValue()));
    		idao.alterar(this.ideia);
    	}else {
    		Ideia i = new Ideia(this.txtDescricao.getText(),
    						this.txtTitulo.getText(),
    						Urgencia.getUrgencia(this.selUrgencia.getValue()));
    		idao.inserir(i);
    	}
    	App.carregaTela("listaIdeias");
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
    	App.carregaTela("listaIdeias");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		var lista = Stream.of(Urgencia.values())
				.map(urg -> urg.toString())
				.collect(Collectors.toList());
		this.selUrgencia.getItems().addAll(lista);
		
		Platform.runLater(()->verificaTelaEdicao());
	}
	private void verificaTelaEdicao() {
		this.ideia = (Ideia)App.tiraDados("ideiaAlterar");
		if(this.isAlterar()) {
			this.txtTitulo.setText(this.ideia.getTitulo());
			this.txtDescricao.setText(this.ideia.getDescricao());
			this.selUrgencia.setValue(this.ideia.getUrgencia().toString());
			System.out.println(this.ideia);
		}
	}
	private boolean isAlterar() {
		return this.ideia!=null;
	}

}




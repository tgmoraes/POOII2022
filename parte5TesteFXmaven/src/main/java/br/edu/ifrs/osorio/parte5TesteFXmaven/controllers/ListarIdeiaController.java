package br.edu.ifrs.osorio.parte5TesteFXmaven.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifrs.osorio.parte5TesteFXmaven.App;
import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Ideia;
import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Urgencia;
import br.edu.ifrs.osorio.parte5TesteFXmaven.persistencia.IdeiaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarIdeiaController implements Initializable{

    @FXML private TableColumn<Ideia, Integer> clmId;
    @FXML private TableColumn<Ideia, String> clmTitulo;
    @FXML private TableColumn<Ideia, Urgencia> clmUrgencia;
    @FXML private TableView<Ideia> tabIdeias;
    
    private void carregaTable() {
    	IdeiaDAO idao = new IdeiaDAO();
    	ObservableList<Ideia> listaIdeias;
    	listaIdeias = FXCollections.observableList(idao.listar(10, 0));
    	this.tabIdeias.setItems(listaIdeias);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregaTable();
		clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
		clmTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		clmUrgencia.setCellValueFactory(new PropertyValueFactory<>("urgencia"));
		
	}
	
	@FXML
    void handleNovaIdeia(ActionEvent event) throws IOException {
		App.carregaTela("telaCadastrar");
    }
	@FXML
    void handleAlteraIdeia(ActionEvent event) {
		Ideia idSel = this.tabIdeias.getSelectionModel().getSelectedItem();
		if(idSel!=null) {
			App.addDados( idSel, "ideiaAlterar");
			App.carregaTela("telaCadastrar");
			//opcao as duas linhas de cima
			//App.carregaTela("telaCadastrar", idSel, "ideiaAlterar");
			
		} else {
			alertaIdeiaNaoSelecionada();
		}

    }

	public void alertaIdeiaNaoSelecionada() {
		Alert alerta = new Alert(AlertType.WARNING);
		alerta.setContentText("Você não selecionou uma ideia!");
		alerta.setTitle("Atenção");
		alerta.setHeaderText("Ideia não selecionada!");
		alerta.show();
	}

	@FXML
	void handleApagaIdeia(ActionEvent event) {
		Ideia idSel = this.tabIdeias.getSelectionModel().getSelectedItem();
		if(idSel!=null) {
			String msg  = String.format("Você realmente deseja apagar a ideia %s!",
					idSel.getTitulo());
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setContentText(msg);
			alerta.setTitle("Atenção");
			alerta.setHeaderText("Apagando ideia!");
			var result = alerta.showAndWait();
			if( result.get() == ButtonType.OK) {
				IdeiaDAO idao = new IdeiaDAO();
				idao.deletar(idSel.getId());
				App.carregaTela("listaIdeias");
			}
			
		} else {
			alertaIdeiaNaoSelecionada();
		}
	}
}

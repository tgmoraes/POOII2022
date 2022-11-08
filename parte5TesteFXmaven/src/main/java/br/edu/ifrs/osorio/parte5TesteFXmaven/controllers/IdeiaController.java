package br.edu.ifrs.osorio.parte5TesteFXmaven.controllers;

import br.edu.ifrs.osorio.parte5TesteFXmaven.model.Ideia;
import br.edu.ifrs.osorio.parte5TesteFXmaven.persistencia.IdeiaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class IdeiaController {

    @FXML   private Label lblDescricao;
    @FXML   private Label lblTitulo;
    @FXML   private Label lblUrgencia;
    @FXML   private TextField txtId;

    @FXML
    void handleBuscar(ActionEvent event) {
    	IdeiaDAO idao = new IdeiaDAO();
    	int id = Integer.parseInt(txtId.getText());
    	Ideia ideia = idao.buscar(id);
    	lblTitulo.setText(ideia.getTitulo());
    	lblDescricao.setText(ideia.getDescricao());
    	lblUrgencia.setText(ideia.getUrgencia().name());
    }

}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaExceptionController implements Initializable{
	@FXML
	private Label lblMensagem;
	@FXML
	private Button buttonOkTelaException;


	private TelaExceptionApp telaExceptionApp;

	public void setPopUp(TelaExceptionApp telaExceptionApp){
		this.setTelaExceptionApp(telaExceptionApp);
	}

	public TelaExceptionApp getTelaExceptionApp() {
		return telaExceptionApp;
	}
	public void setTelaExceptionApp(TelaExceptionApp telaExceptionApp) {
		this.telaExceptionApp = telaExceptionApp;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		buttonOkTelaException.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				((Node) event.getSource()).getScene().getWindow().hide();


		}
		});

}
}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FlyRoadsMenuController implements Initializable {

	@FXML
	private MenuItem MenuIntemCadastrosUsuario;
	@FXML
	private MenuItem MenuIntemCadastrosEmpresas;
	@FXML
	private MenuItem MenuIntemCadastrosPassagens;
	@FXML
	private MenuItem MenuIntemNegociosVendas;
	@FXML
	private MenuItem MenuIntemRelatoriosQTDdePassagens;
	@FXML
	private MenuItem MenuIntemRelatoriosQTDdeUsuarios;
	@FXML
	private MenuItem MenuIntemRelatoriosQTDdeEmpresas;
	@FXML
	private AnchorPane anchorPanePrincipal;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
    public void MenuItemCadastrosUsuario() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("AnchorPaneCadastroUsuario.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

}

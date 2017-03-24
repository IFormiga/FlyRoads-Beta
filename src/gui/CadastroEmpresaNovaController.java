package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.EmpresaJaExisteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocio.Empresa;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;

public class CadastroEmpresaNovaController implements Initializable {

	@FXML
	TextField textFieldNomeNovaEmpresa;
	@FXML
	TextField textFieldRamoNovaEmpresa;
	@FXML
	TextField textFieldCnpjNovaEmpresa;
	@FXML
	PasswordField senhaFieldNovaEmpresa;
	@FXML
	TextField textFieldDicaSenhaNovaEmpresa;
	@FXML
	private AnchorPane anchorP;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();
	@FXML
	Button buttonSalvarNovaEmpresa;
	private Main main;




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.main = Main.getInstance();
		buttonSalvarNovaEmpresa.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonSalvarNovaEmpresa){
						String nome = new String(textFieldNomeNovaEmpresa.getText());
						String ramo = new String(textFieldRamoNovaEmpresa.getText());
						String cnpj = new String(textFieldCnpjNovaEmpresa.getText());
						String senha = new String(senhaFieldNovaEmpresa.getText());
						String dicasenha = new String(textFieldDicaSenhaNovaEmpresa.getText());

						Empresa empresa = new Empresa(nome,cnpj,ramo,senha,dicasenha);
						try {
							fachada.cadastrarEmpresa(empresa);
						} catch (EmpresaJaExisteException e) {
							// TODO Auto-generated catch block
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Empresa ja existe");
							alert.show();
						}



						//get reference to the button's stage
				        stage = (Stage) buttonSalvarNovaEmpresa.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonSalvarNovaEmpresa.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/CadastroEmpresaNova.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(IOException e){
				e.printStackTrace();
			}catch(NumberFormatException e){
				  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaException.fxml"));
					Parent root1 = null;
					try {
						root1 = (Parent) fxmlLoader.load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initStyle(StageStyle.UNDECORATED);
					stage.setTitle("FlyRoads");
					stage.setScene(new Scene(root1));
					stage.show();
			  }
		}
		});


	}

}

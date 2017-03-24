package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.UsuarioJaExisteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;

public class CadastroUsuarioNovoController implements Initializable {


	@FXML
	TextField textFieldCadastroNovoNome;
	@FXML
	TextField textFieldCadastroNovoCpf;
	@FXML
	TextField textFieldCadastroNovaIdade;
	@FXML
	TextField textFieldCadastroNovoEndereço;
	@FXML
	TextField textFieldCadastroNovoSexo;
	@FXML
	TextField textFieldCadastroNovaSenha;
	@FXML
	TextField textFieldCadastroNovaDicaSenha;
	@FXML
	private AnchorPane anchorP;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();
	@FXML
	Button buttonSalvarCadastroUsuarioNovo;
	private Main main;





	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.main = Main.getInstance();
		buttonSalvarCadastroUsuarioNovo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonSalvarCadastroUsuarioNovo){
						String nome = new String(textFieldCadastroNovoNome.getText());
						String cpf = new String(textFieldCadastroNovoCpf.getText());
						String idade = new String(textFieldCadastroNovaIdade.getText());
						String endereço = new String(textFieldCadastroNovoEndereço.getText());
						String sexo = new String(textFieldCadastroNovoSexo.getText());
						String senha = new String(textFieldCadastroNovaSenha.getText());
						String dicasenha = new String(textFieldCadastroNovaDicaSenha.getText());
//CADE AS EXCEPTION DE USUARIO
						Usuario user = new Usuario(nome,cpf,idade,endereço,sexo,senha,dicasenha);
						try {
							fachada.cadastrarUsuario(user);
						} catch (UsuarioJaExisteException e) {
							// TODO Auto-generated catch block
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Usuario ja existe");
							alert.show();
						}



						//get reference to the button's stage
				        stage = (Stage) buttonSalvarCadastroUsuarioNovo.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonSalvarCadastroUsuarioNovo.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/CadastroUsuarioNovo.fxml"));
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

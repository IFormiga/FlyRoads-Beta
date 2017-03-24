package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.EmpresaNaoExisteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.TryNode;
import negocio.Empresa;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;
import javafx.scene.layout.VBox;
import exceptions.UsuarioNaoExisteException;

public class FlyRoadsTelaPrincipalController implements Initializable {


	@FXML
	TextField textFieldCpfUsuario;
	@FXML
	PasswordField senhaFieldUsuario;
	@FXML
	TextField textFieldCnpjEmpresa;
	@FXML
	PasswordField senhaFieldEmpresa;
	@FXML
	Button buttonEntrarUsuario;
	@FXML
	Button buttonCadastrarNovoUsuario;
	@FXML
	Button buttonCadastrarNovaEmpresa;
	@FXML
	Button buttonEnviarEmpresa;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();

	private Parent root;

	@FXML
	private AnchorPane anchorP;
	private Main main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stube
		this.main = Main.getInstance();
		buttonCadastrarNovoUsuario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonCadastrarNovoUsuario) {
						// get reference to the button's stage
						stage = (Stage) buttonCadastrarNovoUsuario.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/CadastroUsuarioNovo.fxml"));
					} else {
						stage = (Stage) buttonCadastrarNovoUsuario.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
					}
					// create a new scene with root and set the stage
					Scene scene = new Scene(root);
					stage.setScene(scene);
					main.changeStage(stage);

				} catch (IOException e) {
					e.printStackTrace();
				}


			}
		});

		buttonEntrarUsuario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				try {
					String cpf = new String(textFieldCpfUsuario.getText());
					String senha = new String(senhaFieldUsuario.getText());
					Usuario user = null;

						try {
							user = fachada.procurarUsuario(cpf);
						} catch (UsuarioNaoExisteException e) {
							// TODO Auto-generated catch block
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Usuario não existe");
							alert.show();
						}



					user.verificaHierarquia(senha);

					if (user.getCpf().equals(cpf)){
						if(user.getSenha().equals(senha)){
						if (user.getConfirmacao()) {
							if (event.getSource() == buttonEntrarUsuario) {
								// get reference to the button's stage
								stage = (Stage) buttonEntrarUsuario.getScene().getWindow();
								// load up OTHER FXML document
								root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuUsuarioMaster.fxml"));
							}
						} else {
							if (event.getSource() == buttonEntrarUsuario) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setContentText("Digite algum campo");
								alert.show();
								// get reference to the button's stage
								stage = (Stage) buttonEntrarUsuario.getScene().getWindow();
								// load up OTHER FXML document
								root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
							}
						}

					}else{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("Senha Incorreta");
						alert.show();
					}
					}else{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("Digite algum campo");
						alert.show();
					}
					Scene scene = new Scene(root);
					stage.setScene(scene);
					main.changeStage(stage);
				}
				catch (IOException e) {
					e.printStackTrace();
				}


			}
		});

		buttonCadastrarNovaEmpresa.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonCadastrarNovaEmpresa) {
						// get reference to the button's stage
						stage = (Stage) buttonCadastrarNovaEmpresa.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/CadastroEmpresaNova.fxml"));
					} else {
						stage = (Stage) buttonCadastrarNovaEmpresa.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
					}
					// create a new scene with root and set the stage
					Scene scene = new Scene(root);
					stage.setScene(scene);
					main.changeStage(stage);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		buttonEnviarEmpresa.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;

					if (event.getSource() == buttonEnviarEmpresa) {
						String cnpj = new String(textFieldCnpjEmpresa.getText());
						String senha = new String(senhaFieldEmpresa.getText());
						Empresa empresa = null;
						try {


								try {
									empresa = fachada.procurarEmpresa(cnpj);
								} catch (EmpresaNaoExisteException e) {
									// TODO Auto-generated catch block
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setContentText("Empresa nao existe");
									alert.show();
								}

							if (empresa.getCnpj().equals(cnpj)){
								if (empresa.getSenha().equals(senha)) {
									if (empresa.getRamo().equals("Ônibus")) {
										// get reference to the button's stage
										stage = (Stage) buttonEnviarEmpresa.getScene().getWindow();
										// load up OTHER FXML document
										root = FXMLLoader
												.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
									} else if (empresa.getRamo().equals("Avião")) {

										stage = (Stage) buttonEnviarEmpresa.getScene().getWindow();
										// load up OTHER FXML document
										root = FXMLLoader
												.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
									} else if (empresa.getRamo().equals("Master")) {
										stage = (Stage) buttonEnviarEmpresa.getScene().getWindow();
										// load up OTHER FXML document
										root = FXMLLoader
												.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaMaster.fxml"));

									}
									else{
										Alert alert = new Alert(Alert.AlertType.ERROR);
										alert.setContentText("Digite algum campo");
										alert.show();
									}

								}else{
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setContentText("Senha Incorreta");
									alert.show();
									stage = (Stage) buttonEnviarEmpresa.getScene().getWindow();
									root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
								}
							}

							Scene scene = new Scene(root);
							stage.setScene(scene);
							main.changeStage(stage);


						// create a new scene with root and set the stage


				}
					catch (IOException e) {
					e.printStackTrace();
				}

			}
			}
		});

	}

	public void setApp(Main main) {
		this.main = main;
	}

}

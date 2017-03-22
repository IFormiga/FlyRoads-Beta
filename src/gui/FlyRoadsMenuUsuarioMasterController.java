package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;
import negocio.ViagemOnibus;
import negocio.Voo;


public class FlyRoadsMenuUsuarioMasterController implements Initializable {

	@FXML
	private TableView<Usuario> tableViewUsuarioMenuMaster;
	@FXML
	private TableColumn<Usuario, String> tableCollumCpf;
	@FXML
	private TableColumn<Usuario,String> tableCollumUsuarios;

	@FXML
	private Button buttonAlterarMenuUsuarioMaster;
	@FXML
	private Button buttonRemoverMenuUsuarioMaster;
	@FXML
	private Button buttonVoltarMenuUsuarioMaster;

	@FXML
	private TextField textFieldNomeMenuUsuarioMaster;
	@FXML
	private TextField textFieldCpfMenuUsuarioMaster;
	@FXML
	private TextField textFieldEndereçoMenuUsuarioMaster;
	@FXML
	private TextField textFieldIdadeMenuUsuarioMaster;
	@FXML
	private TextField textFieldSexoMenuUsuarioMaster;

	private List<Usuario> listaUsuarios;
	private ObservableList<Usuario> obslistaUsuarios;


	private IFlyRoads fachada = FlyRoadsFachada.getInstance();
	private Main main;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		this.main = Main.getInstance();
		tableViewUsuarioMenuMaster.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewUsuario(newValue));
		carregarTableViewUsuarioMenuMaster();

		buttonAlterarMenuUsuarioMaster.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					Usuario user = tableViewUsuarioMenuMaster.getSelectionModel().getSelectedItem();
					if(user!= null && user instanceof Usuario){
						String nome = textFieldNomeMenuUsuarioMaster.getText();
						String cpf = textFieldCpfMenuUsuarioMaster.getText();
						String endereço = textFieldEndereçoMenuUsuarioMaster.getText();
						String sexo = textFieldSexoMenuUsuarioMaster.getText();
						String idade = textFieldIdadeMenuUsuarioMaster.getText();
						Usuario useralterado = new Usuario(nome,cpf,idade,endereço,sexo,user.getSenha(),user.getDica());
						fachada.alterarUsuario(useralterado);
					}

					if(event.getSource()==buttonAlterarMenuUsuarioMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonAlterarMenuUsuarioMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuUsuarioMaster.fxml"));
				    } else {
						stage = (Stage) buttonAlterarMenuUsuarioMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuUsuarioMaster.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(IOException e){
				e.printStackTrace();
			}


		}
		});

		buttonRemoverMenuUsuarioMaster.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{

					Usuario user = tableViewUsuarioMenuMaster.getSelectionModel().getSelectedItem();
					if(user!= null && user instanceof Usuario){
						String nome = textFieldNomeMenuUsuarioMaster.getText();
						String cpf = textFieldCpfMenuUsuarioMaster.getText();
						String endereço = textFieldEndereçoMenuUsuarioMaster.getText();
						String sexo = textFieldSexoMenuUsuarioMaster.getText();
						String idade = textFieldIdadeMenuUsuarioMaster.getText();
						Usuario useralterado = new Usuario(nome,cpf,idade,endereço,sexo,user.getSenha(),user.getDica());
						fachada.removerUsuario(useralterado.getCpf());
					}
					if(event.getSource()==buttonRemoverMenuUsuarioMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonRemoverMenuUsuarioMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuUsuarioMaster.fxml"));
				    } else {
						stage = (Stage) buttonRemoverMenuUsuarioMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuUsuarioMasterfxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(IOException e){
				e.printStackTrace();
			}


		}
		});

		buttonVoltarMenuUsuarioMaster.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonVoltarMenuUsuarioMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonVoltarMenuUsuarioMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonVoltarMenuUsuarioMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(IOException e){
				e.printStackTrace();
			}


		}
		});

	}

	public void carregarTableViewUsuarioMenuMaster() {
		listaUsuarios = fachada.listaUsuarios();
        obslistaUsuarios = FXCollections.observableArrayList(this.listaUsuarios);
        //obslistaUsuarios.addAll(this.listaUsuarios);
        tableViewUsuarioMenuMaster.setItems(obslistaUsuarios);
        tableCollumUsuarios.setCellValueFactory(new PropertyValueFactory<>("Usuários"));
		tableCollumCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
	}
	 public void selecionarItemTableViewUsuario(Usuario user){
	        if (user != null) {
	        	textFieldNomeMenuUsuarioMaster.setText(user.getNome());
	        	textFieldSexoMenuUsuarioMaster.setText(user.getSexo());
	        	textFieldIdadeMenuUsuarioMaster.setText(user.getIdade());
	        	textFieldEndereçoMenuUsuarioMaster.setText(user.getEndereço());
	        	textFieldCpfMenuUsuarioMaster.setText(user.getCpf());
	        	textFieldCpfMenuUsuarioMaster.editableProperty().set(false);
	        } else {
	        	textFieldNomeMenuUsuarioMaster.setText("");
	        	textFieldSexoMenuUsuarioMaster.setText("");
	        	textFieldIdadeMenuUsuarioMaster.setText("");
	        	textFieldEndereçoMenuUsuarioMaster.setText("");
	        	textFieldCpfMenuUsuarioMaster.setText("");
	        }
	 }

}

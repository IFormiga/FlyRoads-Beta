package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;

public class AnchorPaneCadastroUsuarioController implements Initializable{
	@FXML
	private TableView<Usuario> tableViewUsuario;
	@FXML
	private TableColumn<Usuario,String> TableCollumNome;
	@FXML
	private TableColumn<Usuario,String> TableCollumCPF;
	@FXML
	private Label LabelUsuarioNome;
	@FXML
	private Label LabelUsuarioSexo;
	@FXML
	private Label LabelUsuarioIdade;
	@FXML
	private Label LabelUsuarioEndereço;
	@FXML
	private Button ButtonRemover;
	@FXML
	private Button ButtonAlterar;
	@FXML
	private Button ButtonInserir;

	private List<Usuario> listaUsuarios;
	private ObservableList<Usuario> obslistaUsuarios;
	private IFlyRoads fachada = FlyRoadsFachada.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTableViewUsuario();
		tableViewUsuario.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewUsuario(newValue));
	}

	public void carregarTableViewUsuario() {
        TableCollumNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableCollumCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        listaUsuarios = fachada.listaUsuarios();

        obslistaUsuarios = FXCollections.observableArrayList(listaUsuarios);
        tableViewUsuario.setItems(obslistaUsuarios);
    }

	 public void selecionarItemTableViewUsuario(Usuario user){
	        if (user != null) {
	            LabelUsuarioNome.setText(String.valueOf(user.getNome()));
	            LabelUsuarioSexo.setText(user.getSexo());
	            LabelUsuarioIdade.setText(user.getIdade());
	            LabelUsuarioEndereço.setText(user.getEndereço());
	        } else {
	        	LabelUsuarioNome.setText("");
	            LabelUsuarioSexo.setText("");
	            LabelUsuarioIdade.setText("");
	            LabelUsuarioEndereço.setText("");
	        }
	 }

}

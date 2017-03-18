package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Usuario;
import negocio.ViagemOnibus;
import negocio.Voo;

public class FlyRoadsMenuEmpresaControllerMaster implements Initializable {
	@FXML
	private TableView<ViagemOnibus> tableViewOnibusMenuMaster;
	@FXML
	private TableView<Voo> tableViewAviaoMenuMaster;
	@FXML
	private TableColumn<ViagemOnibus, String> tableCollumViagensOnibus;
	@FXML
	private TableColumn<Voo,String> tableCollumViagensAvião;
	@FXML
	private Label labelCodigoMenuMaster;
	@FXML
	private Label labelOrigemMenuMaster;
	@FXML
	private Label labelDestinoMenuMaster;



	@FXML
	private Button buttonAlterarMenuMaster;
	@FXML
	private Button buttonRemoverMenuMaster;

	private List<ViagemOnibus> listaOnibus;
	private ObservableList<ViagemOnibus> obslistaOnibus;
	private List<Voo> listavoo;
	private ObservableList<Voo> obslistavoo;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();
	private Main main;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		carregarTableViewViagemOnibus();
		carregarTableViewViagemAviao();
		this.main = Main.getInstance();
		tableViewOnibusMenuMaster.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewViagemOnibus(newValue));
		tableViewAviaoMenuMaster.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewViagemVoo(newValue));

		buttonAlterarMenuMaster.setOnAction(new EventHandler<ActionEvent>(){
//implementando
			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{



					if(event.getSource()==buttonAlterarMenuMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonAlterarMenuMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/CadastroUsuarioNovo.fxml"));
				    } else {
						stage = (Stage) buttonAlterarMenuMaster.getScene().getWindow();
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

	public void carregarTableViewViagemOnibus() {
		tableCollumViagensOnibus.setCellValueFactory(new PropertyValueFactory<>("Viagens Ônibus"));


        listaOnibus = fachada.listaViagensOnibus();


        obslistaOnibus = FXCollections.observableArrayList(listaOnibus);
        tableViewOnibusMenuMaster.setItems(obslistaOnibus);



	}
	public void carregarTableViewViagemAviao() {
		tableCollumViagensAvião.setCellValueFactory(new PropertyValueFactory<>("Viagens Avião"));


        listavoo = fachada.listaVoos();


        obslistavoo = FXCollections.observableArrayList(listavoo);
        tableViewAviaoMenuMaster.setItems(obslistavoo);



	}

	 public void selecionarItemTableViewViagemOnibus(ViagemOnibus viagem){
	        if (viagem != null) {
	        	labelCodigoMenuMaster.setText(viagem.getCodigo());
	        	labelOrigemMenuMaster.setText(viagem.getOrigem());
	        	labelDestinoMenuMaster.setText(viagem.getDestino());

	        } else {
	        	labelCodigoMenuMaster.setText("");
	        	labelOrigemMenuMaster.setText("");
	        	labelDestinoMenuMaster.setText("");
	        }
	 	}


	 public void selecionarItemTableViewViagemVoo(Voo voo){
		        if (voo != null) {
		        	labelCodigoMenuMaster.setText(voo.getCodigoDoVoo());
		        	labelOrigemMenuMaster.setText(voo.getOrigem());
		        	labelDestinoMenuMaster.setText(voo.getDestino());

		        } else {
		        	labelCodigoMenuMaster.setText("");
		        	labelOrigemMenuMaster.setText("");
		        	labelDestinoMenuMaster.setText("");
		        }

	 	}

}

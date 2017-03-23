package gui;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.Passagem;
import negocio.PassagemOnibus;
import negocio.Usuario;
import negocio.Voo;

public class FlyRoadsMenuVendasViagemOnibusController implements Initializable {


	@FXML
	private TableView<Passagem> tableViewMenuVendasViagemOnibus;
	@FXML
	private TableColumn<PassagemOnibus,String> tableCollumEmpresaMenuVendasViagemOnibus;
	@FXML
	private TableColumn<PassagemOnibus,String> tableCollumOrigemMenuVendasViagemOnibus;
	@FXML
	private TableColumn<PassagemOnibus,String> tableCollumDestinoMenuVendasViagemOnibus;
	@FXML
	private ComboBox<String> comboBoxAssentosMenuVendasViagemOnibus;
	@FXML
	private TextField textFieldValorMenuVendasViagemOnibus;
	@FXML
	private TextField textFieldCpfMenuVendasViagemOnibus;
	@FXML
	private TextField textFieldNumCartaoMenuVendasViagemOnibus;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();

	@FXML
	private Button ButtonComprar;
	@FXML
	private Button ButtonVoltar;

	List<Passagem> listaPassagem;
	List<Passagem> listaPaOnibus;
	ObservableList<Passagem> obslistaPaOnibus;

	 List<String> listaAssento;
	 ObservableList<String> obslistaOArrayAssento;
	private Main main;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		carregarTableViewViagemOnibus();
		this.main = Main.getInstance();
		tableViewMenuVendasViagemOnibus.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewMenuVendasViagemOnibus(newValue));
		do{
			carregarComboBoxAssentoViagemOnibus();
		}
		while(tableViewMenuVendasViagemOnibus.getSelectionModel().getSelectedItem() != null);



	}

	public void carregarTableViewViagemOnibus() {
		tableCollumEmpresaMenuVendasViagemOnibus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getViagem().getNome()));
		System.out.println("linha1");
		tableCollumOrigemMenuVendasViagemOnibus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getViagem().getOrigem()));
		System.out.println("linha2");
		tableCollumDestinoMenuVendasViagemOnibus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getViagem().getDestino()));
		System.out.println("linha3");

        listaPassagem = fachada.listaPassagens();

        for (Passagem passagem : listaPassagem) {
			if(passagem instanceof PassagemOnibus){

				listaPaOnibus.add(passagem);
			}
		}


       obslistaPaOnibus = FXCollections.observableArrayList(listaPaOnibus);
        tableViewMenuVendasViagemOnibus.setItems(obslistaPaOnibus);
}

	public void carregarComboBoxAssentoViagemOnibus(){
		Passagem passagemO = tableViewMenuVendasViagemOnibus.getSelectionModel().getSelectedItem();
			
         String[] arrayAssento = passagemO.getViagem().getAssentos();
        listaAssento = Arrays.asList(arrayAssento);
         obslistaOArrayAssento = FXCollections.observableArrayList(listaAssento);
        	comboBoxAssentosMenuVendasViagemOnibus.setItems(obslistaOArrayAssento);

    }
	public void selecionarItemTableViewMenuVendasViagemOnibus(PassagemOnibus passagemO){
        if (passagemO != null) {
        	textFieldValorMenuVendasViagemOnibus.setText(passagemO.getPreço());
        	textFieldValorMenuVendasViagemOnibus.editableProperty().set(false);
        } else {

        }
 }

}

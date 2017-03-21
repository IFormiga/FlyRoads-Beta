package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import exceptions.JaExisteVooNesseHorarioException;
import exceptions.ViagemEmAndamentoException;
import exceptions.ViagemOnibusNaoExisteException;
import exceptions.VooJaExisteException;
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
import javafx.scene.control.Label;
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
	private TextField textFieldCodigoMenuMaster;
	@FXML
	private TextField textFieldOrigemMenuMaster;
	@FXML
	private TextField textFieldDestinoMenuMaster;
	@FXML
	private TextField textFieldNomeMenuMaster;
	@FXML
	private TextField textFieldDiaSaidaMenuMaster;
	@FXML
	private TextField textFieldMesSaidaMenuMaster;
	@FXML
	private TextField textFieldAnoSaidaMenuMaster;
	@FXML
	private TextField textFieldDiaChegadaMenuMaster;
	@FXML
	private TextField textFieldMesChegadaMenuMaster;
	@FXML
	private TextField textFieldAnoChegadaMenuMaster;
	@FXML
	private TextField textFieldHoraSaidaMenuMaster;
	@FXML
	private TextField textFieldMinutoSaidaMenuMaster;
	@FXML
	private TextField textFieldHoraChegadaMenuMaster;
	@FXML
	private TextField textFieldMinutoChegadaMenuMaster;
	@FXML
	private TableColumn<Voo, String> tableCollumCodigoViagemAvião;
	@FXML
	private TableColumn<ViagemOnibus, String> tableCollumCodigoViagemOnibus;



	@FXML
	private Button buttonAlterarMenuMaster;
	@FXML
	private Button buttonRemoverMenuMaster;
	@FXML
	private Button buttonVoltarMenuMaster;

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
					ViagemOnibus viagem = tableViewOnibusMenuMaster.getSelectionModel().getSelectedItem();
					Voo voo = tableViewAviaoMenuMaster.getSelectionModel().getSelectedItem();
					if(viagem!= null && viagem instanceof ViagemOnibus){
						String nome = textFieldNomeMenuMaster.getText();
						String codigo = textFieldCodigoMenuMaster.getText();
						String origem = textFieldOrigemMenuMaster.getText();
						String destino = textFieldDestinoMenuMaster.getText();
						String diasaida = textFieldDiaSaidaMenuMaster.getText();
						int dsaida = Integer.parseInt(diasaida);
						String messaida = textFieldMesSaidaMenuMaster.getText();
						int msaida = Integer.parseInt(messaida);
						String anosaida = textFieldAnoSaidaMenuMaster.getText();
						int asaida = Integer.parseInt(anosaida);
						String diachegada = textFieldDiaChegadaMenuMaster.getText();
						int dchegada = Integer.parseInt(diachegada);
						String meschegada = textFieldMesChegadaMenuMaster.getText();
						int mchegada = Integer.parseInt(meschegada);
						String anochegada = textFieldAnoChegadaMenuMaster.getText();
						int achegada = Integer.parseInt(anochegada);

						String horasaida = textFieldHoraSaidaMenuMaster.getText();
						int hsaida = Integer.parseInt(horasaida);
						String minutosaida = textFieldMinutoSaidaMenuMaster.getText();
						int minsaida = Integer.parseInt(minutosaida);

						String horachegada = textFieldHoraChegadaMenuMaster.getText();
						int hchegada = Integer.parseInt(horachegada);

						String minutochegada = textFieldMinutoChegadaMenuMaster.getText();
						int minchegada = Integer.parseInt(minutochegada);

						ViagemOnibus valterada = new ViagemOnibus(nome,codigo,origem,destino,hsaida,minsaida,hchegada,minchegada,asaida,msaida,dsaida,achegada,mchegada,dchegada);

						fachada.alterarViagemOnibus(valterada);
					}
					else if(voo!= null && voo instanceof Voo){
						String nome = textFieldNomeMenuMaster.getText();
						String codigo = textFieldCodigoMenuMaster.getText();
						String origem = textFieldOrigemMenuMaster.getText();
						String destino = textFieldDestinoMenuMaster.getText();
						String diasaida = textFieldDiaSaidaMenuMaster.getText();
						int dsaida = Integer.parseInt(diasaida);
						String messaida = textFieldMesSaidaMenuMaster.getText();
						int msaida = Integer.parseInt(messaida);
						String anosaida = textFieldAnoSaidaMenuMaster.getText();
						int asaida = Integer.parseInt(anosaida);
						String diachegada = textFieldDiaChegadaMenuMaster.getText();
						int dchegada = Integer.parseInt(diachegada);
						String meschegada = textFieldMesChegadaMenuMaster.getText();
						int mchegada = Integer.parseInt(meschegada);
						String anochegada = textFieldAnoChegadaMenuMaster.getText();
						int achegada = Integer.parseInt(anochegada);

						String horasaida = textFieldHoraSaidaMenuMaster.getText();
						int hsaida = Integer.parseInt(horasaida);
						String minutosaida = textFieldMinutoSaidaMenuMaster.getText();
						int minsaida = Integer.parseInt(minutosaida);

						String horachegada = textFieldHoraChegadaMenuMaster.getText();
						int hchegada = Integer.parseInt(horachegada);

						String minutochegada = textFieldMinutoChegadaMenuMaster.getText();
						int minchegada = Integer.parseInt(minutochegada);

						Voo vooalterado = new Voo(hsaida,minsaida,hchegada,minchegada,origem,destino,asaida,msaida,dsaida,achegada,mchegada,dchegada,codigo,nome);

							fachada.alterarVoo(vooalterado);


					}


					if(event.getSource()==buttonAlterarMenuMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonAlterarMenuMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaMaster.fxml"));
				    } else {
						stage = (Stage) buttonAlterarMenuMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaMaster.fxml"));
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

		buttonRemoverMenuMaster.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{

					ViagemOnibus viagem = tableViewOnibusMenuMaster.getSelectionModel().getSelectedItem();
					Voo voo = tableViewAviaoMenuMaster.getSelectionModel().getSelectedItem();
					if(viagem!= null && viagem instanceof ViagemOnibus){
						String nome = textFieldNomeMenuMaster.getText();
						String codigo = textFieldCodigoMenuMaster.getText();
						String origem = textFieldOrigemMenuMaster.getText();
						String destino = textFieldDestinoMenuMaster.getText();
						String diasaida = textFieldDiaSaidaMenuMaster.getText();
						int dsaida = Integer.parseInt(diasaida);
						String messaida = textFieldMesSaidaMenuMaster.getText();
						int msaida = Integer.parseInt(messaida);
						String anosaida = textFieldAnoSaidaMenuMaster.getText();
						int asaida = Integer.parseInt(anosaida);
						String diachegada = textFieldDiaChegadaMenuMaster.getText();
						int dchegada = Integer.parseInt(diachegada);
						String meschegada = textFieldMesChegadaMenuMaster.getText();
						int mchegada = Integer.parseInt(meschegada);
						String anochegada = textFieldAnoChegadaMenuMaster.getText();
						int achegada = Integer.parseInt(anochegada);

						String horasaida = textFieldHoraSaidaMenuMaster.getText();
						int hsaida = Integer.parseInt(horasaida);
						String minutosaida = textFieldMinutoSaidaMenuMaster.getText();
						int minsaida = Integer.parseInt(minutosaida);

						String horachegada = textFieldHoraChegadaMenuMaster.getText();
						int hchegada = Integer.parseInt(horachegada);

						String minutochegada = textFieldMinutoChegadaMenuMaster.getText();
						int minchegada = Integer.parseInt(minutochegada);

						ViagemOnibus vremover = new ViagemOnibus(nome,codigo,origem,destino,hsaida,minsaida,hchegada,minchegada,asaida,msaida,dsaida,achegada,mchegada,dchegada);
                         try {
							fachada.removerViagemOnibus(vremover.getCodigo());
						} catch (ViagemEmAndamentoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ViagemOnibusNaoExisteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else if(voo!= null && voo instanceof Voo){
						String nome = textFieldNomeMenuMaster.getText();
						String codigo = textFieldCodigoMenuMaster.getText();
						String origem = textFieldOrigemMenuMaster.getText();
						String destino = textFieldDestinoMenuMaster.getText();
						String diasaida = textFieldDiaSaidaMenuMaster.getText();
						int dsaida = Integer.parseInt(diasaida);
						String messaida = textFieldMesSaidaMenuMaster.getText();
						int msaida = Integer.parseInt(messaida);
						String anosaida = textFieldAnoSaidaMenuMaster.getText();
						int asaida = Integer.parseInt(anosaida);
						String diachegada = textFieldDiaChegadaMenuMaster.getText();
						int dchegada = Integer.parseInt(diachegada);
						String meschegada = textFieldMesChegadaMenuMaster.getText();
						int mchegada = Integer.parseInt(meschegada);
						String anochegada = textFieldAnoChegadaMenuMaster.getText();
						int achegada = Integer.parseInt(anochegada);

						String horasaida = textFieldHoraSaidaMenuMaster.getText();
						int hsaida = Integer.parseInt(horasaida);
						String minutosaida = textFieldMinutoSaidaMenuMaster.getText();
						int minsaida = Integer.parseInt(minutosaida);

						String horachegada = textFieldHoraChegadaMenuMaster.getText();
						int hchegada = Integer.parseInt(horachegada);

						String minutochegada = textFieldMinutoChegadaMenuMaster.getText();
						int minchegada = Integer.parseInt(minutochegada);

						Voo vremover = new Voo(hsaida,minsaida,hchegada,minchegada,origem,destino,asaida,msaida,dsaida,achegada,mchegada,dchegada,codigo,nome);

							fachada.removerVoo(vremover);


					}



					if(event.getSource()==buttonRemoverMenuMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonRemoverMenuMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaMaster.fxml"));
				    } else {
						stage = (Stage) buttonRemoverMenuMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FFlyRoadsMenuEmpresaMaster.fxml"));
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

		buttonVoltarMenuMaster.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonVoltarMenuMaster){
				        //get reference to the button's stage
				        stage = (Stage) buttonVoltarMenuMaster.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonVoltarMenuMaster.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaMaster.fxml"));
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
		tableCollumCodigoViagemOnibus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));

        listaOnibus = fachada.listaViagensOnibus();


        obslistaOnibus = FXCollections.observableArrayList(listaOnibus);
        tableViewOnibusMenuMaster.setItems(obslistaOnibus);



	}
	public void carregarTableViewViagemAviao() {

		tableCollumViagensAvião.setCellValueFactory(new PropertyValueFactory<Voo,String>("Viagens Avião"));
		tableCollumCodigoViagemAvião.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoDoVoo()));

        listavoo = fachada.listaVoos();


        obslistavoo = FXCollections.observableArrayList(listavoo);
        tableViewAviaoMenuMaster.setItems(obslistavoo);



	}

	 public void selecionarItemTableViewViagemOnibus(ViagemOnibus viagem){
	        if (viagem != null) {
	        	textFieldCodigoMenuMaster.setText(viagem.getCodigo());
	        	textFieldCodigoMenuMaster.editableProperty().set(false);
	        	textFieldOrigemMenuMaster.setText(viagem.getOrigem());
	        	textFieldDestinoMenuMaster.setText(viagem.getDestino());
	        	textFieldNomeMenuMaster.setText(viagem.getNome());

	        	String diasaida = Integer.toString(viagem.getDataorigem().getDayOfMonth());
	        	textFieldDiaSaidaMenuMaster.setText(diasaida);

	        	String messaida = Integer.toString(viagem.getDataorigem().getMonthValue());
	        	textFieldMesSaidaMenuMaster.setText(messaida);
	        	String anosaida = Integer.toString(viagem.getDataorigem().getYear());
	        	textFieldAnoSaidaMenuMaster.setText(anosaida);

	        	String diachegada = Integer.toString(viagem.getDatachegada().getDayOfMonth());
	        	textFieldDiaChegadaMenuMaster.setText(diachegada);
	        	String meschegada = Integer.toString(viagem.getDatachegada().getMonthValue());
	        	textFieldMesChegadaMenuMaster.setText(meschegada);
	        	String anochegada = Integer.toString(viagem.getDatachegada().getYear());
	        	textFieldAnoChegadaMenuMaster.setText(anochegada);


	        	String horasaida = Integer.toString(viagem.getSaida().getHour());
	        	textFieldHoraSaidaMenuMaster.setText(horasaida);
	        	String minutosaida = Integer.toString(viagem.getSaida().getMinute());
	        	textFieldMinutoSaidaMenuMaster.setText(minutosaida);

	        	String horachegada = Integer.toString(viagem.getChegada().getHour());
	        	textFieldHoraChegadaMenuMaster.setText(horachegada);
	        	String minutochegada = Integer.toString(viagem.getChegada().getMinute());
	        	textFieldMinutoChegadaMenuMaster.setText(minutochegada);









	        } else {

	        	textFieldCodigoMenuMaster.setText("");
	        	textFieldOrigemMenuMaster.setText("");
	        	textFieldDestinoMenuMaster.setText("");
	        	textFieldNomeMenuMaster.setText("");

	        	textFieldDiaSaidaMenuMaster.setText("");

	        	textFieldMesSaidaMenuMaster.setText("");

	        	textFieldAnoSaidaMenuMaster.setText("");


	        	textFieldDiaChegadaMenuMaster.setText("");

	        	textFieldMesChegadaMenuMaster.setText("");

	        	textFieldAnoChegadaMenuMaster.setText("");



	        	textFieldHoraSaidaMenuMaster.setText("");

	        	textFieldMinutoSaidaMenuMaster.setText("");


	        	textFieldHoraChegadaMenuMaster.setText("");

	        	textFieldMinutoChegadaMenuMaster.setText("");

	        }
	 	}


	 public void selecionarItemTableViewViagemVoo(Voo voo){
		        if (voo != null) {
		        	textFieldCodigoMenuMaster.setText(voo.getCodigoDoVoo());
		        	textFieldCodigoMenuMaster.editableProperty().set(false);
		        	textFieldOrigemMenuMaster.setText(voo.getOrigem());
		        	textFieldDestinoMenuMaster.setText(voo.getDestino());
		        	textFieldNomeMenuMaster.setText(voo.getNomeEmpresa());

		        	String diasaida = Integer.toString(voo.getDataOrigem().getDayOfMonth());
		        	textFieldDiaSaidaMenuMaster.setText(diasaida);

		        	String messaida = Integer.toString(voo.getDataOrigem().getMonthValue());
		        	textFieldMesSaidaMenuMaster.setText(messaida);
		        	String anosaida = Integer.toString(voo.getDataOrigem().getYear());
		        	textFieldAnoSaidaMenuMaster.setText(anosaida);

		        	String diachegada = Integer.toString(voo.getDataChegada().getDayOfMonth());
		        	textFieldDiaChegadaMenuMaster.setText(diachegada);
		        	String meschegada = Integer.toString(voo.getDataChegada().getMonthValue());
		        	textFieldMesChegadaMenuMaster.setText(meschegada);
		        	String anochegada = Integer.toString(voo.getDataChegada().getYear());
		        	textFieldAnoChegadaMenuMaster.setText(anochegada);


		        	String horasaida = Integer.toString(voo.getSaida().getHour());
		        	textFieldHoraSaidaMenuMaster.setText(horasaida);
		        	String minutosaida = Integer.toString(voo.getSaida().getMinute());
		        	textFieldMinutoSaidaMenuMaster.setText(minutosaida);

		        	String horachegada = Integer.toString(voo.getChegada().getHour());
		        	textFieldHoraChegadaMenuMaster.setText(horachegada);
		        	String minutochegada = Integer.toString(voo.getChegada().getMinute());
		        	textFieldMinutoChegadaMenuMaster.setText(minutochegada);

		        } else {

		        	textFieldCodigoMenuMaster.setText("");
		        	textFieldOrigemMenuMaster.setText("");
		        	textFieldDestinoMenuMaster.setText("");
		        	textFieldNomeMenuMaster.setText("");

		        	textFieldDiaSaidaMenuMaster.setText("");

		        	textFieldMesSaidaMenuMaster.setText("");

		        	textFieldAnoSaidaMenuMaster.setText("");


		        	textFieldDiaChegadaMenuMaster.setText("");

		        	textFieldMesChegadaMenuMaster.setText("");

		        	textFieldAnoChegadaMenuMaster.setText("");



		        	textFieldHoraSaidaMenuMaster.setText("");

		        	textFieldMinutoSaidaMenuMaster.setText("");


		        	textFieldHoraChegadaMenuMaster.setText("");

		        	textFieldMinutoChegadaMenuMaster.setText("");
		        }

	 	}

}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ViagemOnibusJaExisteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.ViagemOnibus;

public class FlyRoadsMenuEmpresaOnibusController implements Initializable {



    @FXML
    TextField textFieldNomeViagemOnibus;
	@FXML
	TextField textFieldCodigoViagemOnibus;
	@FXML
	TextField textFieldOrigemViagemOnibus;
	@FXML
	TextField textFieldDestinoViagemOnibus;
	@FXML
	TextField textFieldHoraSaidaViagemOnibus;
	@FXML
	TextField textFieldMinutoSaidaViagemOnibus;

	@FXML
	TextField textFieldHoraChegadaViagemOnibus;
	@FXML
	TextField textFieldMinutoChegadaViagemOnibus;
	@FXML
	TextField textFieldDiaSaidaViagemOnibus;
	@FXML
	TextField textFieldMesSaidaViagemOnibus;
	@FXML
	TextField textFieldAnoSaidaViagemOnibus;

	@FXML
	TextField textFieldDiaChegadaViagemOnibus;
	@FXML
	TextField textFieldMesChegadaViagemOnibus;
	@FXML
	TextField textFieldAnoChegadaViagemOnibus;

	@FXML
	Button buttonSalvarViagemOnibus;
	@FXML
	Button buttonLimparCamposViagemOnibus;
	@FXML
	Button buttonVoltarTelaPrincipalViagemOnibus;
	private Main main;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.main = Main.getInstance();

		buttonSalvarViagemOnibus.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonSalvarViagemOnibus){
				        String nome = new String(textFieldNomeViagemOnibus.getText());
						String codigo = new String(textFieldCodigoViagemOnibus.getText());
				        String origem = new String(textFieldOrigemViagemOnibus.getText());
				        String destino = new String(textFieldDestinoViagemOnibus.getText());
				        String horasaida = new String(textFieldHoraSaidaViagemOnibus.getText());
				        int hsaida = Integer.parseInt(horasaida);
				        String minutosaida = new String(textFieldMinutoSaidaViagemOnibus.getText());
				        int minsaida = Integer.parseInt(minutosaida);
				        String horachegada = new String(textFieldHoraChegadaViagemOnibus.getText());
				        int hchegada = Integer.parseInt(horachegada);
				        String minutochegada = new String(textFieldMinutoChegadaViagemOnibus.getText());
				        int minchegada = Integer.parseInt(minutochegada);
				        String diasaida = new String(textFieldDiaSaidaViagemOnibus.getText());
				        int dsaida = Integer.parseInt(diasaida);
				        String messaida = new String(textFieldMesSaidaViagemOnibus.getText());
				        int msaida = Integer.parseInt(messaida);
				        String anosaida = new String(textFieldAnoSaidaViagemOnibus.getText());
				        int asaida = Integer.parseInt(anosaida);
				        String diachegada = new String(textFieldDiaChegadaViagemOnibus.getText());
				        int dchegada = Integer.parseInt(diachegada);
				        String meschegada = new String(textFieldMesChegadaViagemOnibus.getText());
				        int mchegada = Integer.parseInt(meschegada);
				        String anochegada = new String(textFieldAnoChegadaViagemOnibus.getText());
				        int achegada = Integer.parseInt(anochegada);





						ViagemOnibus viagem = new ViagemOnibus(nome,codigo,origem,destino,hsaida,minsaida,hchegada,minchegada,asaida,msaida,dsaida,achegada,mchegada,dchegada);
						try {
							fachada.CadastrarViagemOnibus(viagem);
						} catch (ViagemOnibusJaExisteException e) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Cadastre outra viagem, essa ja existe");
							alert.show();
							
						}





						//get reference to the button's stage
				        stage = (Stage) buttonSalvarViagemOnibus.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
				    } else {
						stage = (Stage) buttonSalvarViagemOnibus.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
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

		buttonLimparCamposViagemOnibus.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonLimparCamposViagemOnibus){


						 textFieldCodigoViagemOnibus.clear();

						 textFieldOrigemViagemOnibus.clear();

						 textFieldDestinoViagemOnibus.clear();

						 textFieldHoraSaidaViagemOnibus.clear();

						 textFieldMinutoSaidaViagemOnibus.clear();


						 textFieldHoraChegadaViagemOnibus.clear();

						 textFieldMinutoChegadaViagemOnibus.clear();

						 textFieldDiaSaidaViagemOnibus.clear();

						 textFieldMesSaidaViagemOnibus.clear();

						 textFieldAnoSaidaViagemOnibus.clear();


						 textFieldDiaChegadaViagemOnibus.clear();

						  textFieldMesChegadaViagemOnibus.clear();

						 textFieldAnoChegadaViagemOnibus.clear();

						//get reference to the button's stage
				        stage = (Stage) buttonLimparCamposViagemOnibus.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
				    } else {
						stage = (Stage) buttonLimparCamposViagemOnibus.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
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

		buttonVoltarTelaPrincipalViagemOnibus.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonVoltarTelaPrincipalViagemOnibus){
				        //get reference to the button's stage
				        stage = (Stage) buttonVoltarTelaPrincipalViagemOnibus.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonVoltarTelaPrincipalViagemOnibus.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaOnibus.fxml"));
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



}

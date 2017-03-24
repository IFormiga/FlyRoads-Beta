package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.JaExisteVooNesseHorarioException;
import exceptions.ViagemOnibusJaExisteException;
import exceptions.VooJaExisteException;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocio.FlyRoadsFachada;
import negocio.IFlyRoads;
import negocio.ViagemOnibus;
import negocio.Voo;

public class FlyRoadsMenuEmpresaAviaoController implements Initializable {

	@FXML
    TextField textFieldNomeVoo;
	@FXML
	TextField textFieldCodigoVoo;
	@FXML
	TextField textFieldOrigemVoo;
	@FXML
	TextField textFieldDestinoVoo;
	@FXML
	TextField textFieldHoraSaidaVoo;
	@FXML
	TextField textFieldMinutoSaidaVoo;

	@FXML
	TextField textFieldHoraChegadaVoo;
	@FXML
	TextField textFieldMinutoChegadaVoo;
	@FXML
	TextField textFieldDiaSaidaVoo;
	@FXML
	TextField textFieldMesSaidaVoo;
	@FXML
	TextField textFieldAnoSaidaVoo;

	@FXML
	TextField textFieldDiaChegadaVoo;
	@FXML
	TextField textFieldMesChegadaVoo;
	@FXML
	TextField textFieldAnoChegadaVoo;

	@FXML
	Button buttonSalvarVoo;
	@FXML
	Button buttonLimparCamposVoo;
	@FXML
	Button buttonVoltarTelaPrincipalVoo;
	private Main main;

	private IFlyRoads fachada = FlyRoadsFachada.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = Main.getInstance();

		buttonSalvarVoo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonSalvarVoo){
				        String nome = new String(textFieldNomeVoo.getText());
						String codigo = new String(textFieldCodigoVoo.getText());
				        String origem = new String(textFieldOrigemVoo.getText());
				        String destino = new String(textFieldDestinoVoo.getText());
				        String horasaida = new String(textFieldHoraSaidaVoo.getText());
				        int hsaida = Integer.parseInt(horasaida);
				        String minutosaida = new String(textFieldMinutoSaidaVoo.getText());
				        int minsaida = Integer.parseInt(minutosaida);
				        String horachegada = new String(textFieldHoraChegadaVoo.getText());
				        int hchegada = Integer.parseInt(horachegada);
				        String minutochegada = new String(textFieldMinutoChegadaVoo.getText());
				        int minchegada = Integer.parseInt(minutochegada);
				        String diasaida = new String(textFieldDiaSaidaVoo.getText());
				        int dsaida = Integer.parseInt(diasaida);
				        String messaida = new String(textFieldMesSaidaVoo.getText());
				        int msaida = Integer.parseInt(messaida);
				        String anosaida = new String(textFieldAnoSaidaVoo.getText());
				        int asaida = Integer.parseInt(anosaida);
				        String diachegada = new String(textFieldDiaChegadaVoo.getText());
				        int dchegada = Integer.parseInt(diachegada);
				        String meschegada = new String(textFieldMesChegadaVoo.getText());
				        int mchegada = Integer.parseInt(meschegada);
				        String anochegada = new String(textFieldAnoChegadaVoo.getText());
				        int achegada = Integer.parseInt(anochegada);



				        	Voo voo = new Voo(hsaida,minsaida,hchegada,minchegada,origem,destino,asaida,msaida,dsaida,achegada,mchegada,dchegada,codigo,nome);


								try {
									fachada.cadastrarVoo(voo);
								} catch (JaExisteVooNesseHorarioException e) {
									// TODO Auto-generated catch block
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setContentText("Ja Existe Voo Nesse Horario");
									alert.show();
								}
									catch (VooJaExisteException e) {
								// TODO: handle exception
										Alert alert = new Alert(Alert.AlertType.ERROR);
										alert.setContentText("Voo Ja Existe, Cadastre Outro");
										alert.show();

									}


						//get reference to the button's stage
				        stage = (Stage) buttonSalvarVoo.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
					}else {
						stage = (Stage) buttonSalvarVoo.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
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

		buttonLimparCamposVoo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonLimparCamposVoo){


						 textFieldCodigoVoo.clear();

						 textFieldOrigemVoo.clear();

						 textFieldDestinoVoo.clear();

						 textFieldHoraSaidaVoo.clear();

						 textFieldMinutoSaidaVoo.clear();


						 textFieldHoraChegadaVoo.clear();

						 textFieldMinutoChegadaVoo.clear();

						 textFieldDiaSaidaVoo.clear();

						 textFieldMesSaidaVoo.clear();

						 textFieldAnoSaidaVoo.clear();


						 textFieldDiaChegadaVoo.clear();

						  textFieldMesChegadaVoo.clear();

						 textFieldAnoChegadaVoo.clear();

						//get reference to the button's stage
				        stage = (Stage) buttonLimparCamposVoo.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
				    } else {
						stage = (Stage) buttonLimparCamposVoo.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
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

		buttonVoltarTelaPrincipalVoo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonVoltarTelaPrincipalVoo){
				        //get reference to the button's stage
				        stage = (Stage) buttonVoltarTelaPrincipalVoo.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
				    } else {
						stage = (Stage) buttonVoltarTelaPrincipalVoo.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuEmpresaAviao.fxml"));
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

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FlyRoadsMenuOpçoesController implements Initializable {

	@FXML
	Button buttonMenuOpçoesViagensOnibus;
	@FXML
	Button buttonMenuOpçoesViagensAviao;
	@FXML
	Button buttonMenuOpçoesVoltar;


	private Main main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = Main.getInstance();

		buttonMenuOpçoesViagensOnibus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOpçoesViagensOnibus) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOpçoesViagensOnibus.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuVendasViagensOnibus.fxml"));
					} else {
						stage = (Stage) buttonMenuOpçoesViagensOnibus.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOpçoesViagem.fxml"));
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


		buttonMenuOpçoesViagensAviao.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOpçoesViagensAviao) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOpçoesViagensAviao.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuVendasViagensAviao.fxml"));
					} else {
						stage = (Stage)buttonMenuOpçoesViagensAviao.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOpçoesViagem.fxml"));
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

		buttonMenuOpçoesVoltar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOpçoesVoltar) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOpçoesVoltar.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
					} else {
						stage = (Stage)buttonMenuOpçoesVoltar.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOpçoesViagem.fxml"));
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







	}

}

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

public class FlyRoadsMenuOp�oesController implements Initializable {

	@FXML
	Button buttonMenuOp�oesViagensOnibus;
	@FXML
	Button buttonMenuOp�oesViagensAviao;
	@FXML
	Button buttonMenuOp�oesVoltar;


	private Main main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = Main.getInstance();

		buttonMenuOp�oesViagensOnibus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOp�oesViagensOnibus) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOp�oesViagensOnibus.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuVendasViagensOnibus.fxml"));
					} else {
						stage = (Stage) buttonMenuOp�oesViagensOnibus.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOp�oesViagem.fxml"));
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


		buttonMenuOp�oesViagensAviao.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOp�oesViagensAviao) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOp�oesViagensAviao.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuVendasViagensAviao.fxml"));
					} else {
						stage = (Stage)buttonMenuOp�oesViagensAviao.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOp�oesViagem.fxml"));
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

		buttonMenuOp�oesVoltar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try {
					if (event.getSource() == buttonMenuOp�oesVoltar) {
						// get reference to the button's stage
						stage = (Stage) buttonMenuOp�oesVoltar.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
					} else {
						stage = (Stage)buttonMenuOp�oesVoltar.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/FlyRoadsMenuOp�oesViagem.fxml"));
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

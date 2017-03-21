package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaExceptionApp extends Application {

	private Stage primaryStage;
	private BorderPane rootScene;

	private static TelaExceptionApp instance;

	public static TelaExceptionApp getInstance(){
		if(instance == null){
			instance = new TelaExceptionApp();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FlyRoads");
		this.rootScene = new BorderPane();

		Scene scene = new Scene(rootScene, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String [] args){
		launch(args);
	}
	public void carregarTelaPopUp(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TelaExceptionApp.class.getResource("/gui/view/TelaException.fxml"));
			BorderPane pane = (BorderPane) loader.load();

			this.rootScene.setCenter(pane);
			TelaExceptionController telaExceptionController = loader.getController();
			telaExceptionController.setPopUp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

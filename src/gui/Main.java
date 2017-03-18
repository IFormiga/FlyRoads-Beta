package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootScene;
	private static Main instance;
	public static Main getInstance(){
		if (instance == null){
			instance = new Main();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) {
			this.primaryStage = primaryStage;
			this.rootScene = new BorderPane();
			Scene scene = new Scene(rootScene, 600, 400);

			this.primaryStage.setTitle("Sistema FlyRoads");
			primaryStage.setScene(scene);
			primaryStage.show();
			carregaTelaLogin();
	}

	public void carregaTelaLogin(){
		try{
			// carrega o panel de contas no centro da tela principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/gui/FlyRoadsPrincipal.fxml"));
			VBox vbox  = (VBox) loader.load();

			this.rootScene.setCenter(vbox);
			FlyRoadsTelaPrincipalController telaPrincipal = loader.getController();
			telaPrincipal.setApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void changeStage(Stage stage){
		this.primaryStage = stage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}

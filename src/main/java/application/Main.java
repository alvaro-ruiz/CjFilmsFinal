package application;
	
import controller.loginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Clase main de la aplicación
 * @author Alvaro y Francis
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		  FXMLLoader loader = new FXMLLoader();
	      loader.setLocation(Main.class.getResource("/view/PantallaLogin.fxml"));
	      Pane vent = (Pane) loader.load();
	      Scene scene = new Scene(vent);
	      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	      loginController control = loader.getController();
	      control.setStage(primaryStage);
	      primaryStage.setTitle("CjFilms");
	      primaryStage.setScene(scene);
	      primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

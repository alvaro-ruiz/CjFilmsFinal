package controller;

import Utils.GestorSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Usuarios;

public class UsuarioController {


    @FXML
    private Button cerrarSesion;

    @FXML
    private Button editarUsuario;
    
    @FXML
    private Button guardaUsuario;
    
    @FXML
    private Label nombreUsuario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtSalidaContrasenia;

    @FXML
    private TextField txtSalidaCorreo;

    @FXML
    private TextField txtSalidaNombre;

    @FXML
    private TextField txtSalidaNumeroTlf;

	private Stage stage;
	
	private Usuarios usuarioActivo;
	
	 @FXML
	    void initialize() {
		 editarUsuario.setVisible(true);
		 guardaUsuario.setVisible(false);
		 usuarioActivo = GestorSQL.searchUsuario(GestorSQL.getUsuarioActivo());
		 txtNombreUsuario.setText(usuarioActivo.getUsuario());
		 txtSalidaCorreo.setText(usuarioActivo.getCorreo());
		 txtSalidaContrasenia.setText(usuarioActivo.getPassword());
		 txtSalidaNombre.setText(usuarioActivo.getUsuario());
		 txtSalidaNumeroTlf.setText(usuarioActivo.getNumeroTlf());
		 
	 }

    @FXML
    void editUsuario(ActionEvent event) {
    	txtSalidaContrasenia.setEditable(true);
    	txtSalidaCorreo.setEditable(true);
    	txtSalidaNombre.setEditable(true);
    	txtSalidaNumeroTlf.setEditable(true);
    	editarUsuario.setVisible(false);
    	guardaUsuario.setVisible(true);
    	
    }
    
    @FXML
    void guardaUsuario(ActionEvent event) {
    	try {
    		Usuarios user = new Usuarios(txtSalidaNombre.getText(), txtSalidaCorreo.getText(), txtSalidaContrasenia.getText());
    		user.setNumeroTlf(txtSalidaNumeroTlf.getText());
    		GestorSQL.updateUsuario(user);
        	txtSalidaContrasenia.setEditable(false);
        	txtSalidaCorreo.setEditable(false);
        	txtSalidaNombre.setEditable(false);
        	txtSalidaNumeroTlf.setEditable(false);
        	editarUsuario.setVisible(true);
        	guardaUsuario.setVisible(false);
        	GestorSQL.setUsuarioActivo(txtSalidaNombre.getText());
    	} catch (Exception e) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Al guardar el Usuario");
      	    alert.showAndWait();
		}
    	
    }

    @FXML
    void showAniadePelicula(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaAniadePelicula.fxml"));
 	     	Pane vent = (Pane) loader.load();
 	     	Scene scene = new Scene(vent);
 	     	Stage stage = new Stage();
 	     	AniadeController controller = loader.getController();
 	     	controller.setStage(stage);
 	     	stage.setTitle("CjFilms");
 	  	    stage.setScene(scene);
 	  	    stage.show();
 	  	    this.stage.close();
 		 } catch (Exception e) {
 			Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Esa funcionalidad no esta disponible");
      	    alert.showAndWait();
 		}
    }

    @FXML
    void showBiblioteca(MouseEvent event) {
    	try {
 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaBiblioteca.fxml"));
 	     	Pane vent = (Pane) loader.load();
 	     	Scene scene = new Scene(vent);
 	     	Stage stage = new Stage();
 	     	BibliotecaController controller = loader.getController();
 	     	controller.setStage(stage);
 	     	stage.setTitle("CjFilms");
 	  	    stage.setScene(scene);
 	  	    stage.show();
 	  	    this.stage.close();
 		 } catch (Exception e) {
 			Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Esa funcionalidad no esta disponible");
      	    alert.showAndWait();
 		}
    }

    @FXML
    void showBuscar(MouseEvent event) {
    	try {
 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaBuscador.fxml"));
 	     	Pane vent = (Pane) loader.load();
 	     	Scene scene = new Scene(vent);
 	     	Stage stage = new Stage();
 	     	buscadorController controller = loader.getController();
 	     	controller.setStage(stage);
 	     	stage.setTitle("CjFilms");
 	  	    stage.setScene(scene);
 	  	    stage.show();
 	  	    this.stage.close();
 		 } catch (Exception e) {
 			Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Esa funcionalidad no esta disponible");
      	    alert.showAndWait();
 		}
    }

    @FXML
    void showInicio(MouseEvent event) {
    	try {
 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaPrincipal.fxml"));
 	     	Pane vent = (Pane) loader.load();
 	     	Scene scene = new Scene(vent);
 	     	Stage stage = new Stage();
 	     	PrincipalController controller = loader.getController();
 	     	controller.setStage(stage);
 	     	stage.setTitle("CjFilms");
 	  	    stage.setScene(scene);
 	  	    stage.show();
 	  	    this.stage.close();
 		 } catch (Exception e) {
 			Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Esa funcionalidad no esta disponible");
      	    alert.showAndWait();
 		}
    }

    @FXML
    void showLogin(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaLogin.fxml"));
       	 	Pane vent = (Pane) loader.load();
       	 	Scene scene = new Scene(vent);
       	 	Stage stage = new Stage();
       	 	loginController controller = loader.getController();
       	 	controller.setStage(stage);
       	 	stage.setTitle("CjFilms");
    	    stage.setScene(scene);
    	    stage.show();
    	    this.stage.close();
    	} catch (Exception e) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Esa funcionalidad no esta disponible");
      	    alert.showAndWait();
		}
    }
    
    public void setStage(Stage stage) {
		this.stage = stage;
	}

}

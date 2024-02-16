package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Utils.GestorSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import models.Usuarios;


public class registerController {

    @FXML
    private Button btnRegister;
    
    @FXML
    private Button btnSalir;

    @FXML
    private ImageView logoPagina;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword1;

    @FXML
    private TextField txtPassword2;

    @FXML
    private TextField txtUser;

	private Stage stage;
	
	/**
	 * Oculta el campo de texto RepeatPassword
	 * @param event
	 */
	 @FXML
    void oculataRepeatPassword(MouseEvent event) {
		 txtPassword2.setText("");
    }
 
 	/**
	 * Oculta el campo de texto Email
	 * @param event
	 */
    @FXML
    void ocultaEmail(MouseEvent event) {
    	txtEmail.setText("");
    }

    /**
	 * Oculta el campo de texto Password
	 * @param event
	 */
    @FXML
    void ocultaPassword(MouseEvent event) {
    	txtPassword1.setText("");
    }
    
    /**
	 * Oculta el campo de texto Usuario
	 * @param event
	 */
    @FXML
    void ocultaUser(MouseEvent event) {
    	txtUser.setText("");
    }
	
	/**
	 * Este metodo comprueba que las contraseñas sean iguales, crea el objeto usuario lo guarda y muestra el loging
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void userRegister(ActionEvent event) throws IOException {
    	if (!txtUser.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtPassword1.getText().isEmpty()) {
    		if (Usuarios.compruebaPassword(txtPassword1.getText(), txtPassword2.getText())) {
    	   		 Usuarios usuario = GestorSQL.searchUsuario(txtUser.getText());
    	   		 if (usuario == null) {
    	   			 Usuarios user = new Usuarios(txtUser.getText(), txtEmail.getText(), txtPassword1.getText());
    	   			 GestorSQL.insertUsuario(user);
    	   			 showloging();
    	   		 } else {
    	   			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	      	     alert.setTitle("Error");
    	      	     alert.setHeaderText("Error: Creacion de usuario");
    	      	     alert.setContentText("Ese usuario ya existe");
    	      	     alert.showAndWait();
    	   		 }
    	   		 
    	   	 } else {
    	   		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	   	     alert.setTitle("Error");
    	   	     alert.setHeaderText("Error: Creacion de usuario");
    	   	     alert.setContentText("Las contraseñas deben ser iguales");
    	   	     alert.showAndWait();
    	   	 }
    	} else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   	     alert.setTitle("Error");
	   	     alert.setHeaderText("Error: Creacion de usuario");
	   	     alert.setContentText("No puede heber campos vacios");
	   	     alert.showAndWait();
    	}
    }
    
    /**
     * Muestra la pantalla de Login
     * @param event
     * @throws IOException
     */
    @FXML
    void showLogin(ActionEvent event) throws IOException {
    	showloging();
    }
    
    // Este metodo muestra el loging
    private void showloging() throws IOException {
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
    	
    }
    
    // Establece el Stage
	public void setStage(Stage stage) {
		this.stage = stage;
	} 
	
	public void setText() {
		txtPassword2.setText("Repeat Password");
		txtEmail.setText("Email");
		txtPassword1.setText("Password");
		txtUser.setText("User");
	}

}
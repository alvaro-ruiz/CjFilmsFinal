package controller;

import java.io.IOException;

import Utils.GestorSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Usuarios;

public class loginController {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsuario;
    
    @FXML
    private Label lblPassword;

	private Stage stage;

    @FXML
    void loging(ActionEvent event) {
    	try {
    		if (compruebaUsuario()) {
    			showNext();
    			GestorSQL.setUsuarioActivo(txtUsuario.getText());
    		} else {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
          	    alert.setTitle("Error");
          	    alert.setHeaderText("Error: ");
          	    alert.setContentText("Password o user incorrecto");
          	    alert.showAndWait();
          	    setCadena();
          	    
    		}
    	} catch (Exception e) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Password o user incorrecto");
      	    alert.showAndWait();
      	    setCadena();
		}
    	
    }
    
    @FXML
    void vaciaPassword(MouseEvent event) {
    	lblPassword.setText("");
    	txtPassword.setText("");
    }

    @FXML
    void vaciaUser(MouseEvent event) {
    	txtUsuario.setText("");
    }
    

    void setCadena() {
    	lblPassword.setText("Password");
    	txtUsuario.setText("User");
    	txtPassword.setText("");
    }
    
    @FXML
    void showRegister(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaRegister.fxml"));
	   	 	Pane vent = (Pane) loader.load();
	   	 	Scene scene = new Scene(vent);
	   	 	Stage stage = new Stage();
	   	 	registerController controller = loader.getController();
	   	 	controller.setStage(stage);
	   	 	stage.setTitle("CjFilms");
		     stage.setScene(scene);
		     stage.show();
		     this.stage.close();
    	} catch (Exception e) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Reinice la aplicacion");
      	    alert.showAndWait();
		}
    	
    }
    
 // Establece el stage
  	public void setStage(Stage Stage) {
  		this.stage = Stage;
  	}
  	
  	/**
  	 * Este metodo abre otra pagina
  	 * @throws IOException
  	 */
  	private void showNext() throws IOException {
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
  	}
    /**
 	 * Este metodo comprueba que el usuario exista en la base de datos
 	 * @return true si existe, false si no existe;
 	 */
 	public boolean compruebaUsuario() {
 		String usuario = txtUsuario.getText();
 		String password = txtPassword.getText();
 		Usuarios user = GestorSQL.searchUsuario(usuario);
 		if (usuario.compareTo(user.getUsuario()) == 0) {
 			if (password.compareTo(user.getPassword()) == 0) {
 				return true;
 			} else {
 				return false;
 			}
 		} else {
 			return false;
 		}
 	}
}

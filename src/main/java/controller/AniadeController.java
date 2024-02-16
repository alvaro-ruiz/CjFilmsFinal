package controller;

import java.io.IOException;

import Utils.GestorSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Pelicula;

public class AniadeController {

    @FXML
    private TextArea TxtAActores;

    @FXML
    private TextArea TxtADescripcion;

    @FXML
    private TextArea TxtADirectores;

    @FXML
    private TextArea TxtAGeneros;

    @FXML
    private TextArea TxtAPlataforma;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtCompañia;

    @FXML
    private TextField txtTitulo;

	private Stage stage;
	
	@FXML
    void desaparedeTexto(MouseEvent event) {
		txtAnio.setText("");
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

	/**
  	 * Este metodo abre pagina Principal
  	 */
    @FXML
    void showPrincipal(MouseEvent event) {
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
    void filmAdd(ActionEvent event) {
    	String titulo = txtTitulo.getText();
    	if (!titulo.isEmpty()) {
    		Pelicula peli = GestorSQL.searchPelicula(txtTitulo.getText());
    		if (peli == null){
    			Pelicula film = new Pelicula(titulo);
    			
    			if (!txtAnio.getText().isEmpty()) {
    				film.setAnio(txtAnio.getText());
    			}
    			
    			if (!txtCompañia.getText().isEmpty()) {
    				film.setCompañia(txtCompañia.getText());
    			}
    			
    			if (!TxtAActores.getText().isEmpty()) {
    				film.setActor(TxtAActores.getText());
    			}
    			
    			if (!TxtADescripcion.getText().isEmpty()) {
    				film.setDescripcion(TxtADescripcion.getText());
    			}
    			if (!TxtADirectores.getText().isEmpty()) {
    				film.setDirector(TxtADirectores.getText());
    			}
    			
    			if (!TxtAGeneros.getText().isEmpty()) {
    				film.setGenero(TxtAGeneros.getText());
    			}
    			
    			if (!TxtAPlataforma.getText().isEmpty()) {
    				film.setPlataforma(TxtAPlataforma.getText());
    			}
    			if (GestorSQL.insertPelicula(film)) {
    				try {
    					showPrincipal();
    				}catch (Exception e) {
    					Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		      	    alert.setTitle("Error");
    		      	    alert.setHeaderText("Error: ");
    		      	    alert.setContentText("Algo a ocurrido");
    		      	    alert.showAndWait();
    		      	    txtAnio.setText("(2024-12-31)");
					}
    				
    			}
    		} else {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
          	    alert.setTitle("Error");
          	    alert.setHeaderText("Error: ");
          	    alert.setContentText("Pelicula ya en base de datos");
          	    alert.showAndWait();
    		}
    	} else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setTitle("Error");
      	    alert.setHeaderText("Error: ");
      	    alert.setContentText("Se tienen que rellenar los campos obligatorios");
      	    alert.showAndWait();
    	}

    }
    
	// Establece el stage
	public void setStage(Stage Stage) {
		this.stage = Stage;
	}
	
	@FXML
    void showUsuario(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaUsuario.fxml"));
     	Pane vent = (Pane) loader.load();
     	Scene scene = new Scene(vent);
     	Stage stage = new Stage();
     	UsuarioController controller = loader.getController();
     	controller.setStage(stage);
     	stage.setTitle("CjFilms");
  	    stage.setScene(scene);
  	    stage.show();
  	    this.stage.close();
    }
	
	/**
  	 * Este metodo abre pagina Principal
  	 * @throws IOException
  	 */
  	private void showPrincipal() throws IOException {
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

}

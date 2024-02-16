package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import models.Movie;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import com.google.gson.Gson;

import Utils.GestorSQL;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Controlador para la vista de la biblioteca.
 */
public class BibliotecaController {

    @FXML
    private ScrollPane scrollGuardadas;

    @FXML
    private ScrollPane scrollVistas;

	private Stage stage;
	
	/**
     * Método para mostrar la PanatallaAniadePelicula.
     * @param event Evento del mouse que desencadena la acción.
     */
	@FXML
    void showAniadePelicula(MouseEvent event) throws IOException {
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
    }
	
	/**
     * Método para mostrar la ventana de PantallaBuscador.
     * @param event Evento del mouse que desencadena la acción.
     */
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
     * Método para mostrar la ventana de PanatallaPrincipal.
     * @param event Evento del mouse que desencadena la acción.
     */
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
    
    /**
     * Método para mostrar la ventana de Usuario.
     * @param event Evento del mouse que desencadena la acción.
     */
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
     * Método para inicializar la vista de la biblioteca.
     * Este método se llama automáticamente después de que la vista y sus elementos FXML hayan sido cargados.
     * En este método se cargan y muestran las películas guardadas y vistas.
     */
    @FXML
    public void initialize(){
    	Movie[] datosPeliVistas= getInfoMovies(GestorSQL.searchAllPeliculaGuardadas());
        HBox VistasBox;
        Movie[] datosPeliGuardadas = getInfoMovies(GestorSQL.searchAllPeliculaVistas());
        HBox GuardadasBox;
        try {
          //Populares
            VistasBox = imprimirPeliculas(datosPeliVistas);
            scrollVistas.setContent(VistasBox);
            //Recientes
            GuardadasBox = imprimirPeliculas(datosPeliGuardadas);
            scrollGuardadas.setContent(GuardadasBox);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene información sobre una película a partir de la API de themoviedb.org.
     *
     * @param ids Array de IDs de películas.
     * @return Información de las películas obtenida de la API.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private static Movie[] getInfoMovies(int[] ids) {
        Movie[] movies = new Movie[ids.length];
        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();

        for (int i = 0; i < ids.length; i++) {
            Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/" + ids[i] + "?language=es-ES&api_key=bef30369a404f9a1a923bc48ffbc00bc")
                .get()
                .addHeader("accept", "application/json")
                .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Error en la solicitud: " + response);
                }

                String responseBody = response.body().string();
                movies[i] = gson.fromJson(responseBody, Movie.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return movies;
    }
    
    /**
     * Establece la ventana principal.
     * @param stage La ventana principal.
     */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
	// Método privado para imprimir las imágenes y títulos de las películas en un HBox.
    /**
     * Imprime las imágenes y títulos de las películas en un HBox.
     * @param peliculas Arreglo de películas a imprimir.
     * @return El HBox con las imágenes y títulos de las películas.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private HBox imprimirPeliculas(Movie[] peliculas) throws IOException {
    	// Se crea un HBox para contener las imágenes y títulos de los actores.
    	HBox hbox = new HBox();
    	hbox.setSpacing(5);
    	// Se itera sobre el arreglo de actores para crear y agregar las imágenes y títulos al HBox.
    	for (int i = 0; i < peliculas.length; i++) {
        String imageUrl = "https://image.tmdb.org/t/p/w500/" + peliculas[i].getPoster_path();

        // Se crea una ImageView para mostrar la imagen del actor.
        ImageView imageView = new ImageView();
        Image image = new Image(imageUrl);
        imageView.setImage(image);
        imageView.setFitWidth(130); // Establece el ancho deseado
        imageView.setFitHeight(195); // Establece la altura deseada

        // Se crea un VBox para contener la imagen y el nombre del actor.
        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView);
        vbox.setSpacing(10); // Espacio entre la imagen y el nombre

        // Se añade el VBox al HBox.
        hbox.getChildren().add(vbox);

        // Se agrega una función de clic a la ImageView para cada actor
        final int index = i; // Necesario para acceder al índice en la función de clic
        imageView.setOnMouseClicked(event -> {
            // Aquí puedes realizar la acción que deseas al hacer clic en la imagen
            System.out.println("Has hecho clic en la imagen de la peli: " + peliculas[index].getTitle());
            menuController.id = peliculas[index].getId();
            showRegister(event);
        });
        }

        // Se devuelve el HBox con las imágenes y títulos de los actores.
        return hbox;
    }
    
    /**
     * Método para mostrar la ventana del menu
     * @param event Evento del mouse que desencadena la acción.
     */
    void showRegister(MouseEvent event) {
        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
            Pane vent = (Pane) loader.load();
            Scene scene = new Scene(vent);
            Stage stage = new Stage();
            menuController controller = loader.getController();
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

}

package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.InfoPeli;
import models.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.Cast;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import models.Usuarios;

public class PrincipalController {
	
	private final String KEY_API = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZWYzMDM2OWE0MDRmOWExYTkyM2JjNDhmZmJjMDBiYyIsInN1YiI6IjY1NzgxNTM4YWY1OGNiMDEyMzZjNTI1MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bCxvNQumYvyL9RcsBFeumwiVcdcUIWmhdApZAFLI1oA";
	private Stage stage;
	@FXML
    private Button busca;

    @FXML
    private TextField buscador;

    @FXML
    private ScrollPane scrollPopulares;

    @FXML
    private ScrollPane scrollRecientes;

    @FXML
    private ScrollPane scrollValoradas;

    @FXML
    void buscar(ActionEvent event) {

    }
    
    // Establece el stage
    public void setStage(Stage Stage) {
      this.stage = Stage;
    }
    
    @FXML
    void showUsuario(MouseEvent event) {
    	
    	try {
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
		 } catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	    alert.setTitle("Error");
     	    alert.setHeaderText("Error: ");
     	    alert.setContentText("Esa funcionalidad no esta disponible");
     	    alert.showAndWait();
		}
    }
    
    @FXML
    void showAniadePelicula(MouseEvent event) throws IOException {
		
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
    void goUrl(MouseEvent event) {
    	URL url=null;
    	try {
    	    url = new URL("https://es.restaurantguru.com/AMIGO-KEBAB-Malaga/menu");
    	    try {
    	        Desktop.getDesktop().browse(url.toURI());
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    } catch (URISyntaxException e) {
    	        e.printStackTrace();
    	    }
    	} catch (MalformedURLException e1) {
    	    e1.printStackTrace();
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
    public void initialize() throws IOException {
        // Aquí puedes llamar a los métodos que desees ejecutar al iniciar la vista
    	InfoPeli infoPopulares = getInfoPopulares();
        Movie[] datosPeliPopu = infoPopulares.getResults();
        InfoPeli infoRecientes = getInfoRecientes();
        Movie[] datosPeliRecientes = infoRecientes.getResults();
        InfoPeli infoValoradas = getInfoValoradas();
        Movie[] datosValoradas = infoValoradas.getResults();
        // Se llama al método imprimirPeliculas para obtener el HBox con las imágenes y títulos de los actores.
        HBox popularesBox;
        HBox recientesBox;
        HBox valoradasBox;
        try {
        	//Populares
            popularesBox = imprimirPeliculas(datosPeliPopu);
            scrollPopulares.setContent(popularesBox);
            //Recientes
            recientesBox = imprimirPeliculas(datosPeliRecientes);
            scrollRecientes.setContent(recientesBox);
            //Mejor Valoradas
            valoradasBox = imprimirPeliculas(datosValoradas);
            scrollValoradas.setContent(valoradasBox);
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    private InfoPeli getInfoPopulares() throws IOException {
    	OkHttpClient client = new OkHttpClient();

    	Request request = new Request.Builder()
    			  .url("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1")
    			  .get()
    			  .addHeader("accept", "application/json")
    			  .addHeader("Authorization", "Bearer " + KEY_API)
    			  .build();

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verifica si la solicitud fue exitosa (código de estado 200)
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }

            // Obtiene el cuerpo de la respuesta
            String responseBody = response.body().string();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto Movie
            Gson gson = new Gson();
            return gson.fromJson(responseBody, InfoPeli.class);
        }
    }
    
    private InfoPeli getInfoRecientes() throws IOException {

    	OkHttpClient client = new OkHttpClient();

    	Request request = new Request.Builder()
    	  .url("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1")
    	  .get()
    	  .addHeader("accept", "application/json")
    	  .addHeader("Authorization", "Bearer " + KEY_API)
    	  .build();

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verifica si la solicitud fue exitosa (código de estado 200)
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }

            // Obtiene el cuerpo de la respuesta
            String responseBody = response.body().string();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto Movie
            Gson gson = new Gson();
            return gson.fromJson(responseBody, InfoPeli.class);
        }
    }
    
    private InfoPeli getInfoValoradas() throws IOException {
    	OkHttpClient client = new OkHttpClient();

    	Request request = new Request.Builder()
    	  .url("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1")
    	  .get()
    	  .addHeader("accept", "application/json")
    	  .addHeader("Authorization", "Bearer " + KEY_API)
    	  .build();

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verifica si la solicitud fue exitosa (código de estado 200)
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }

            // Obtiene el cuerpo de la respuesta
            String responseBody = response.body().string();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto Movie
            Gson gson = new Gson();
            return gson.fromJson(responseBody, InfoPeli.class);
        }
    }
    
    // Método para imprimir las imágenes y títulos de las películas en un HBox.
    HBox imprimirPeliculas(Movie[] peliculas) throws IOException {
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
            imageView.setFitWidth(200); // Establece el ancho deseado
            imageView.setFitHeight(300); // Establece la altura deseada

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
                showMenu(event);
            });
        }

        // Se devuelve el HBox con las imágenes y títulos de los actores.
        return hbox;
    }
    
    void showMenu(MouseEvent event) {
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


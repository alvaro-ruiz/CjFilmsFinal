package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import models.*;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import java.io.IOException;

public class buscadorController {
	
	// Claves de la API y URL para acceder a la información de películas
    private static final String KEY_API = "bef30369a404f9a1a923bc48ffbc00bc";
    private static final String URL_MOVIE = "https://api.themoviedb.org/3/search/movie";
    private Stage stage;
    
    @FXML
    private Pane BuscarPorFiltros;

    @FXML
    private CheckBox adultos;

    @FXML
    private Button busca;

    @FXML
    private Button buscaPorFiltros;

    @FXML
    private TextField buscador;

    @FXML
    private ComboBox<String> comboGeneros;

    @FXML
    private ScrollPane scrollPeliculas;

    @FXML
    private CheckBox vistas;
    
    @FXML
    private DatePicker estreno;
    
    Genres[] genresArray = {
    		new Genres(28, "Acción"),
            new Genres(12, "Aventura"),
            new Genres(16, "Animación"),
            new Genres(35, "Comedia"),
            new Genres(80, "Crimen"),
            new Genres(99, "Documental"),
            new Genres(18, "Drama"),
            new Genres(10751, "Familia"),
            new Genres(14, "Fantasía"),
            new Genres(36, "Historia"),
            new Genres(27, "Terror"),
            new Genres(10402, "Música"),
            new Genres(9648, "Misterio"),
            new Genres(10749, "Romance"),
            new Genres(878, "Ciencia ficción"),
            new Genres(10770, "Película de TV"),
            new Genres(53, "Suspense"),
            new Genres(10752, "Bélica"),
            new Genres(37, "Western")
        };
    
    Map<String, Integer> mapaIdGenres;
    
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

    
    @FXML
    public void initialize() throws IOException{        
    	// Definir los valores
        mapaIdGenres = new HashMap<>();	
    	mapaIdGenres.put("Acción", 28);
        mapaIdGenres.put("Aventura", 12);
        mapaIdGenres.put("Animación", 16);
        mapaIdGenres.put("Comedia", 35);
        mapaIdGenres.put("Crimen", 80);
        mapaIdGenres.put("Documental", 99);
        mapaIdGenres.put("Drama", 18);
        mapaIdGenres.put("Familia", 10751);
        mapaIdGenres.put("Fantasía", 14);
        mapaIdGenres.put("Historia", 36);
        mapaIdGenres.put("Terror", 27);
        mapaIdGenres.put("Música", 10402);
        mapaIdGenres.put("Misterio", 9648);
        mapaIdGenres.put("Romance", 10749);
        mapaIdGenres.put("Ciencia ficción", 878);
        mapaIdGenres.put("Película de TV", 10770);
        mapaIdGenres.put("Suspense", 53);
        mapaIdGenres.put("Bélica", 10752);
        mapaIdGenres.put("Western", 37);
        
    	// Convertir el array en ObservableList
        ObservableList<String> listaGeneros = FXCollections.observableArrayList();
        for (Genres genres : genresArray) {
			listaGeneros.add(genres.getName());
		}
        // Asignar la lista de géneros al ComboBox
        comboGeneros.setItems(listaGeneros);
        
        comboGeneros.getSelectionModel().selectFirst();        
    }
    
    @FXML
    void buscar(ActionEvent event) {
    	// Obtiene la palabra de búsqueda desde el campo de texto
        String palabraBusqueda = buscador.getText();
        if (!palabraBusqueda.isEmpty()) {
            try {
                // Obtiene la información de la película mediante la API 
                InfoPeli datosPeli = getInfoMovie(palabraBusqueda);
                Movie[] results = datosPeli.getResults();
                // Crear el VBox que contiene las filas de imágenes de películas
                VBox vboxPrincipal = imprimirPeliculas(results);
                scrollPeliculas.setContent(vboxPrincipal);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @FXML
    void buscarFiltros(ActionEvent event) {
    	// Obtiene la palabra de búsqueda desde el campo de texto
        String palabraBusqueda = buscador.getText();
        if (!palabraBusqueda.isEmpty()) {
            try {
            	System.out.println(comboGeneros.getValue());
            	System.out.println(Integer.toString(mapaIdGenres.get(comboGeneros.getValue())));
                // Obtiene la información de la película mediante la API 
                InfoPeli datosPeli = getInfoMovieFiltrada();
                Movie[] results = datosPeli.getResults();
                // Crear el VBox que contiene las filas de imágenes de películas
                VBox vboxPrincipal = imprimirPeliculas(results);
                scrollPeliculas.setContent(vboxPrincipal);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //
    private InfoPeli getInfoMovieFiltrada() throws IOException {
    	OkHttpClient client = new OkHttpClient();
    	String url;
    	
    	if (estreno.getValue() == null ) {
    		url = "https://api.themoviedb.org/3/discover/movie?include_adult="+ Boolean.toString(adultos.isSelected()) +"&language=es-ES&page=1&with_genres=" + Integer.toString(mapaIdGenres.get(comboGeneros.getValue())) + "&api_key=bef30369a404f9a1a923bc48ffbc00bc";
    	} else if (Integer.toString(mapaIdGenres.get(comboGeneros.getValue())) == null || (Integer.toString(mapaIdGenres.get(comboGeneros.getValue()))) == "0" && estreno.getValue() == null) {
    		url = "https://api.themoviedb.org/3/discover/movie?include_adult="+ Boolean.toString(adultos.isSelected()) +"&language=es-ES&page=1&api_key=bef30369a404f9a1a923bc48ffbc00bc";
    	} else {
    		url = "https://api.themoviedb.org/3/discover/movie?include_adult="+ Boolean.toString(adultos.isSelected()) +"&language=es-ES&page=1&release_date.gte=" + estreno.getValue().toString().replace('/', '-') +"&with_genres=" + Integer.toString(mapaIdGenres.get(comboGeneros.getValue())) + "&api_key=bef30369a404f9a1a923bc48ffbc00bc";
    	}
    	Request request = new Request.Builder()
    			  .url(url)
    			  .get()
    			  .addHeader("accept", "application/json")
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
    
    private static void añadeComboBoxConArray(Genres[] opciones) {
        // Crear un ObservableList a partir del array
        ObservableList<Genres> items = FXCollections.observableArrayList(opciones);
        // Crear el ChoiceBox y asignarle el ObservableList
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        
        
    }
    
    /**
     * Obtiene información sobre una película a partir de la API de themoviedb.org.
     *
     * @param palabraBusqueda Término de búsqueda para la película.
     * @return Información de la película obtenida de la API.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private InfoPeli getInfoMovie(String palabraBuscada) throws IOException {
        // Construye la URL de la API con la clave y la palabra de búsqueda
        String apiUrl = String.format("%s?api_key=%s&query=%s&language=es-ES", URL_MOVIE, KEY_API, palabraBuscada);
        //"https://api.themoviedb.org/3/movie/movie_id?language=en-US"
        // Crea un cliente OkHttp
        OkHttpClient client = new OkHttpClient();

        // Crea una solicitud HTTP con la URL construida
        Request request = new Request.Builder()
                .url(apiUrl)
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
    
    // Método para imprimir las imágenes de las películas en filas de 5 hacia abajo.
    VBox imprimirPeliculas(Movie[] peliculas) throws IOException {
    	// Se crea un VBox para contener todas las filas de imágenes de las películas.
        VBox vboxPrincipal = new VBox();
        vboxPrincipal.setSpacing(10);

        // Se itera sobre el arreglo de películas.
        for (int i = 0; i < peliculas.length; i += 4) {
            // Se crea un HBox para contener una fila de imágenes de películas.
            HBox hboxFila = new HBox();
            hboxFila.setSpacing(10);

            // Se itera sobre las películas en la fila actual.
            for (int j = i; j < Math.min(i + 4, peliculas.length); j++) {
                String imageUrl = "https://image.tmdb.org/t/p/w500/" + peliculas[j].getPoster_path();

                // Se crea una ImageView para mostrar la imagen de la película.
                ImageView imageView = new ImageView();
                Image image = new Image(imageUrl);
                imageView.setImage(image);
                imageView.setFitWidth(242); // Establece el ancho deseado
                imageView.setFitHeight(365); // Establece la altura deseada

                // Se agrega la ImageView al HBox de la fila actual.
                hboxFila.getChildren().add(imageView);

                // Se agrega una función de clic a la ImageView para cada película
                final int index = j; // Necesario para acceder al índice en la función de clic
                imageView.setOnMouseClicked(event -> {
                    // Aquí puedes realizar la acción que deseas al hacer clic en la imagen
                    System.out.println("Has hecho clic en la imagen de la peli: " + peliculas[index].getTitle());
                    menuController.id = peliculas[index].getId();
                    menuController.id = peliculas[index].getId();
                    showRegister(event);
                });
            }

            // Se agrega el HBox de la fila actual al VBox principal.
            vboxPrincipal.getChildren().add(hboxFila);
        }

        // Se devuelve el VBox principal con todas las filas de imágenes de las películas.
        return vboxPrincipal;
    }
    
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

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

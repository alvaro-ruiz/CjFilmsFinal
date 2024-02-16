package Utils;

import java.util.List;

import org.hibernate.Session;

import models.Pelicula;
import models.PeliculasGuardadas;
import models.PeliculasVistas;
import models.Usuarios;
import dao.PeliculaDaoImpl;
import dao.PeliculasGuardadasDaoImpl;
import dao.PeliculasVistasDaoImpl;
import dao.UsuarioDaoImpl;

public class GestorSQL {
	
	private static boolean iniciado = false;
	private static Session session;
	private static UsuarioDaoImpl usuario;
	private static PeliculaDaoImpl pelicula;
	private static PeliculasVistasDaoImpl peliculaVista;
	private static PeliculasGuardadasDaoImpl peliculaGuardadas;
	private static String usuarioActivo;
	
	public GestorSQL() {
		iniciar();
	}
	
	/**
	 * @return the session
	 */
	public static Session getSession() {
		return session;
	}

	/**
	 * @return the usuarioActivo
	 */
	public static String getUsuarioActivo() {
		return usuarioActivo;
	}

	/**
	 * @param usuario the usuarioActivo to set
	 */
	public static void setUsuarioActivo(String usuario) {
		usuarioActivo = usuario;
	}

	/**
	 * Metodo que inserta Usuarios en la base de datos que se pasa por parametros
	 * @param user
	 * @return true, si se guarda bien en la base de datos, false si no se a podido guardar
	 */
	public static boolean insertUsuario(Usuarios user) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			usuario.insertUsuario(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Metodo que inserta el Usuarios en la base de datos que se pasa por parametros
	 * @param user
	 * @return true, si se guarda bien en la base de datos, false si no se a podido guardar
	 */
	public static boolean updateUsuario(Usuarios user) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			usuario.updateusuario(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Metodo que busca un usuario en la base de datos
	 * @param name, usuario que quieres buscar
	 * @return the Usuario
	 */
	public static Usuarios searchUsuario(String name) {
		if (iniciado == false) {
			iniciar();
		}
		
		Usuarios user = usuario.getUsuarioByName(name);
		return user;
		
	}
	
	/**
	 * Metodo que inserta Peliculas en la base de datos que se pasa por parametros
	 * @param Pelicula film
	 * @return true, si se guarda bien en la base de datos, false si no se a podido guardar
	 */
	public static boolean insertPelicula(Pelicula film) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			pelicula.insertPelicula(film);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
	/**
	 * Metodo que busca una pelicula en la base de datos
	 * @param titulo, de la pelicula que se busca
	 * @return the pelicula
	 */
	public static Pelicula searchPelicula(String titulo) {
		if (iniciado == false) {
			iniciar();
		}
		
		Pelicula film = pelicula.getPeliculaByTitulo(titulo);
		return film;
		
	}
	
	
	/**
	 * Metodo que busca una pelicula vista en la base de datos
	 * @param id, de la pelicula que se busca
	 * @return the peliculaVista
	 */
	public static PeliculasVistas searchPeliculaVista(int id) {
		if (iniciado == false) {
			iniciar();
		}
		
		PeliculasVistas film = peliculaVista.getPeliculasVistasById(id);
		return film;
	}
	
	/**
	 * Metodo que inserta PeliculasVistas en la base de datos que se pasa por parametros
	 * @param film
	 * @return true, si se guarda bien en la base de datos, false si no se a podido guardar
	 */
	public static boolean insertPeliculaVista(PeliculasVistas film) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			peliculaVista.insertPeliculaVista(film);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Metodo que elimina de la base de datos la pelicula que se pasa por parametro
	 * @param film, que se va a eliminar
	 * @return true si se borro correctamente, false si no se borro
	 */
	public static boolean deletePeliculaVista(PeliculasVistas film) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			peliculaVista.deletePeliculaVista(film);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Metodo que devuelve todos los ids de las pelis que has guardado
	 * @return salida int[]
	 */
	public static int[] searchAllPeliculaGuardadas() {
		if (iniciado == false) {
			iniciar();
		}
		List<PeliculasGuardadas> lista = peliculaGuardadas.searchAll();
		int[] salida = new int[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			salida[i] = lista.get(i).getId();
		}
		return salida;
	}
	
	/**
	 * Metodo que devuelve todos los ids de las pelis que has guardado
	 * @return salida int[]
	 */
	public static int[] searchAllPeliculaVistas() {
		if (iniciado == false) {
			iniciar();
		}
		List<PeliculasVistas> lista = peliculaVista.searchAll();
		int[] salida = new int[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			salida[i] = lista.get(i).getId();
		}
		return salida;
	}
	
	/**
	 * Metodo que busca la peliculas por id de la base de datos de PeiculasGuardadas
	 * @param id
	 * @return the pelicula guardadad
	 */
	public static PeliculasGuardadas searchPeliculaGuardadas(int id) {
		if (iniciado == false) {
			iniciar();
		}
		
		PeliculasGuardadas film = peliculaGuardadas.getPeliculasGuardadasById(id);
		return film;
	}
	
	/**
	 * Metodo que inserta peliculas Guardadas en la base de datos que se pasa por parametros
	 * @param peliculasGuardadas
	 * @return true, si se guarda bien en la base de datos, false si no se a podido guardar
	 */
	public static boolean insertPeliculaGuardadas(PeliculasGuardadas film) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			peliculaGuardadas.insertPeliculaGuardadas(film);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Metodo que elimina de la base de datos la pelicula que se pasa por parametro
	 * @param film, que se va a eliminar
	 * @return true si se borro correctamente, false si no se borro
	 */
	public static boolean deletePeliculaGuardadas(PeliculasGuardadas film) {
		if (iniciado == false) {
			iniciar();
		}
		try {
			peliculaGuardadas.deletePeliculaGuardadas(film);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Inicializa todos los elementos que se usa
	 */
	private static void iniciar() {
		HibernateUtils.buildSessionFactory();
		session = HibernateUtils.openSesion();
		usuario = new UsuarioDaoImpl(session);
		pelicula = new PeliculaDaoImpl(session);
		peliculaVista = new PeliculasVistasDaoImpl(session);
		peliculaGuardadas = new PeliculasGuardadasDaoImpl(session);
	}
	
	/**
	 * Cierra los elementos de hibernate
	 */
	public static void closeall() {
		HibernateUtils.closeAll(session);
	}

	
}

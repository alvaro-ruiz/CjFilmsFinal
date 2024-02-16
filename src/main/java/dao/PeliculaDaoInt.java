package dao;

import models.Pelicula;

/**
 * Clase interfaz de PeliculaDao	
 * @author Alvaro y Francis
 *
 */
public interface PeliculaDaoInt extends CommonDaoInt<Pelicula> {
	
	/**
	 * Devuelve la pelicula que esta en la base de datos con ese titulo
	 * @param titulo de la pelicula que quieres buscar 
	 * @return the pelicula
	 */
	public Pelicula getPeliculaByTitulo(String titulo);

}

package dao;

import models.Usuarios;

/**
 * Clase interfaz de UsuarioDao	
 * @author Alvaro y Francis
 *
 */
public interface UsuarioDaoInt extends CommonDaoInt<Usuarios> {
	
	/**
	 * Devuelve el usuario esta en la base de datos con el ese nombre
	 * @param name del usuario que quieres buscar 
	 * @return the Usuario
	 */
	public Object getUsuarioByName(String name);
	
	/**
	 * Clase para saber si existe un usuario con ese nombre
	 * @param name
	 * @return true si existe, false si no existe
	 */
	public boolean existByName(String name);

}

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PeliculasVistas {

    @Id
    @Column(name = "id_pelicula")
    private int id;

    @Column(name = "nombre_usuario")
    private String usuario;

    @Column (name= "titulo_pelicula")
    private String pelicula;
    
    public PeliculasVistas() {
    	
    }
    
    public PeliculasVistas(int id_pelicula) {
    	this.id = id_pelicula;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the pelicula
	 */
	public String getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	    // Getters y setters
    
}

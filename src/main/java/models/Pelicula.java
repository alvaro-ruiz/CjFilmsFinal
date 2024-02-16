package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pelicula {

	@Id
	@Column(name = "Titulo")
	private String titulo;
	
	@Column(name = "id_pelicula")
	private String id_pelicula;
	
	@Column(name = "Año")
	private String anio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "cartel")
	private String cartel;
	
	@Column(name = "valoracion")
	private String valoracion;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "actor")
	private String actor;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "compañia")
	private String compañia;
	
	@Column(name = "plataforma")
	private String plataforma;
	
	public Pelicula() {
		
	}
	
	public Pelicula(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the id_pelicula
	 */
	public String getId_pelicula() {
		return id_pelicula;
	}

	/**
	 * @param id_pelicula the id_pelicula to set
	 */
	public void setId_pelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the cartel
	 */
	public String getCartel() {
		return cartel;
	}

	/**
	 * @param cartel the cartel to set
	 */
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}

	/**
	 * @return the valoracion
	 */
	public String getValoracion() {
		return valoracion;
	}

	/**
	 * @param valoracion the valoracion to set
	 */
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the compañia
	 */
	public String getCompañia() {
		return compañia;
	}

	/**
	 * @param compañia the compañia to set
	 */
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	/**
	 * @return the plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma the plataforma to set
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
	
}

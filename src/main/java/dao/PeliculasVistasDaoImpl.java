package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import models.PeliculasGuardadas;
import models.PeliculasVistas;

public class PeliculasVistasDaoImpl extends CommonDaoImpl<PeliculasVistas> {

	private Session session;

	public PeliculasVistasDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	public void insertPeliculaVista(PeliculasVistas film) {
		super.insert(film);
	}
	
	public void deletePeliculaVista(PeliculasVistas film) {
		super.delete(film);
	}
	
	public PeliculasVistas getPeliculasVistasById(int id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (PeliculasVistas) session.createQuery("FROM PeliculasVistas WHERE id_pelicula='" + id + "'").uniqueResult();
	}
	
	public List<PeliculasVistas> searchAll() {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		// Devuelve los empleados con ese nombre
		return session.createQuery("FROM PeliculasVistas").list();
	}

}

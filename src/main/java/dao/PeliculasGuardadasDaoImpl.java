package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import models.PeliculasGuardadas;

public class PeliculasGuardadasDaoImpl extends CommonDaoImpl<PeliculasGuardadas> {
	
	private Session session;
	
	public PeliculasGuardadasDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	public void insertPeliculaGuardadas(PeliculasGuardadas film) {
		super.insert(film);
	}
	
	public void deletePeliculaGuardadas(PeliculasGuardadas film) {
		super.delete(film);
	}
	
	public PeliculasGuardadas getPeliculasGuardadasById(int id) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (PeliculasGuardadas) session.createQuery("FROM PeliculasGuardadas WHERE id_pelicula='" + id + "'").uniqueResult();
	}
	
	public List<PeliculasGuardadas> searchAll() {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		// Devuelve los empleados con ese nombre
		return session.createQuery("FROM PeliculasGuardadas").list();
	}

}

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import models.Pelicula;
import models.Usuarios;

public class PeliculaDaoImpl extends CommonDaoImpl<Pelicula> implements PeliculaDaoInt {

	private Session session;

	public PeliculaDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	public void insertPelicula(Pelicula pelicula) {
		super.insert(pelicula);
	}

	@Override
	public void update(Pelicula paramT) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pelicula getPeliculaByTitulo(String titulo) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Pelicula) session.createQuery("FROM Pelicula WHERE titulo='" + titulo + "'").uniqueResult();
	}

}

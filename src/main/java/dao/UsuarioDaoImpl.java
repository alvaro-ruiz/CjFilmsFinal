package dao;

import java.util.List;

import models.Usuarios;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class UsuarioDaoImpl extends CommonDaoImpl<Usuarios> implements UsuarioDaoInt {

	private Session session;
	
	public UsuarioDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	public void insertUsuario(Usuarios user) {
		super.insert(user);
	}
	
	public void updateusuario(Usuarios user) {
		super.update(user);
	}
	
	@Override
	public Usuarios getUsuarioByName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Usuarios) session.createQuery("FROM Usuarios WHERE nombre_usuario='" + name + "'").uniqueResult();
	}
	
	@Override
	public boolean existByName(String name) {
		try {
			session.createQuery("FROM Usuarios WHERE nombre_usuario = '" + name + "'").uniqueResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

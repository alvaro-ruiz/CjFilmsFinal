package Utils;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	/**
	 * Esta clase crea la Session factory
	 */
		public static void buildSessionFactory() {
			if (sessionFactory == null) {
				StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
				sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
			}
		}
		
		/**
		 * Este metodo abre la session
		 */
		public static Session openSesion() {
			Session	session = sessionFactory.openSession();
			return session;
		}
		
		/**
		 * Inicia la transaccion
		 * @param la ssesion en la que queremos iniciar las transaccion
		 */
		public static void initTransaccion(Session session) {
			session.getTransaction().begin();
		}
		
		/**
		 * Commit transaccion
		 * @param la sesion que vamos a realiar un commit
		 */
		public static void comitTransaccion(Session session) {
			session.getTransaction().commit();
		}
		
		/**
		 * Cierra la sesion
		 * @param la sesion que vamos a cerrar
		 */
		public static void closeAll(Session session) {
			closeSession(session);
			closeSessionFactory();
		}
		
		private static void closeSession(Session session) {
			if (session != null) {
				session.close();
			}
		}
		
		private static void closeSessionFactory() {
			if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
				sessionFactory.close();
			}
		}

}

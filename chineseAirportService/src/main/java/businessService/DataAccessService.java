package businessService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DataAccessService {
	private SessionFactory sessionFactory;
	protected Session session;
	private DataAccessService(){
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	private static DataAccessService dataAccessServiceInstance = new DataAccessService();
	public static DataAccessService getDataAccessServiceInstance(){
		return dataAccessServiceInstance;
	}
	
	public void openSession(){
		session = sessionFactory.openSession();
	}
	
	public void save(Object objectToSave){
		session.beginTransaction();
		session.saveOrUpdate(objectToSave);
		session.getTransaction().commit();
	}
	
	public void delete(Object objectToDelete){
		session.beginTransaction();
		session.delete(objectToDelete);
		session.getTransaction().commit();
	}
	
	public void closeSession(){
		if (session.isOpen()){
			session.close();
		}
	}
}

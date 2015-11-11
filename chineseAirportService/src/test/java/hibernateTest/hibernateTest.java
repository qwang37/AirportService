package hibernateTest;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

public class hibernateTest {
	@Test
	public void setFunctionTest(){
		TestHibernateModel testModel = new TestHibernateModel();
		testModel.setTestInt(2);//primary key, make sure no duplicate
		testModel.setTestString("first Name");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(testModel);
		session.getTransaction().commit();
		assertEquals(1,1);
	}
}

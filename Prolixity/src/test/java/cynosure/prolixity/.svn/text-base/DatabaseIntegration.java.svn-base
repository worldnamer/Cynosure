package cynosure.prolixity;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.*;

public class DatabaseIntegration
{
	protected static SessionFactory sm_factory;

	protected Session m_session;
	
	@BeforeClass
	public static void startDatabase() {
		sm_factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@Before
	public void connnect() {
		m_session = sm_factory.getCurrentSession();
	}
	
	public void disconnect() {
		if (m_session.isConnected()) {
			m_session.close();
		}
	}
	
	@AfterClass
	public static void closeDatabase() {
		sm_factory.close();
	}
}

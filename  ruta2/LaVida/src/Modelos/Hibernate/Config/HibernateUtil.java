package Modelos.Hibernate.Config;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil{

	private static SessionFactory sessionFactory= buildSessionFactory() ;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();     
            return new Configuration().configure().buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

	/*public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}*/

	public static Session openSession() throws HibernateException {
		// TODO Auto-generated method stub
	
	        return sessionFactory.openSession();
	}
	
	
/*	 private static final SessionFactory sessionFactory;
	    static {
	       
	      AnnotationConfiguration cfg2 = new AnnotationConfiguration();
	       
	        try { 
	           
	        	sessionFactory = cfg2.configure("hibernate.cfg.xml").buildSessionFactory();
	        	//	sessionFactory = cfg2.configure(new File("hibernate.cfg.xml")).buildSessionFactory();
	          
	        } catch (Throwable ex) {
	            ex.printStackTrace();
	            throw new ExceptionInInitializerError(ex);
	        }

	    }

	    public static Session openSession() throws HibernateException {
	        return sessionFactory.openSession();
	    }*/
}



/*import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	//private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();     
            return new Configuration().configure().buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	private static final SessionFactory sessionFactory;
    static {
       
      AnnotationConfiguration cfg2 = new AnnotationConfiguration();
       
        try { 
           
        	sessionFactory = cfg2.configure("hibernate.cfg.xml").buildSessionFactory();
        	//	sessionFactory = cfg2.configure(new File("hibernate.cfg.xml")).buildSessionFactory();
          
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static Session openSession() throws HibernateException {
        return sessionFactory.openSession();
    }*/


	/*public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}*/

//}

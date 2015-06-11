package Modelos.Hibernate.Daos;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Modelos.HistorialDeuda;
import Modelos.Hibernate.Config.HibernateUtil;
public class HistorialDeudaDao {

	
	private HibernateUtil sesionPostgres;

	public List<HistorialDeuda> obtenerTodos() throws Exception {            
  
		List<HistorialDeuda> datos = new ArrayList<HistorialDeuda>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<HistorialDeuda>) em.createCriteria(HistorialDeuda.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public void actualizarHistorial(HistorialDeuda dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();  
		Transaction tx = null;  
		try {    
			tx = em.beginTransaction();
			em.update(dato);   
			tx.commit();  
		} catch (Exception e) {  
			tx.rollback();            
			e.printStackTrace();
			throw e;
		} finally {  
			em.close();  
		} 
	}
	
}

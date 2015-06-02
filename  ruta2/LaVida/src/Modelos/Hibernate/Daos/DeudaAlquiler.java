package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Hibernate.Config.HibernateUtil;

public class DeudaAlquiler {

		
	private HibernateUtil sesionPostgres;
		
		
		public void agregarDeuda(DeudaAlquiler dato) throws Exception{
			@SuppressWarnings("static-access")
			Session em = sesionPostgres.openSession();  
			Transaction tx = null;  
			try {    
				tx = em.beginTransaction();
				em.save( dato);   
				tx.commit();  
			} catch (Exception e) {  
				tx.rollback();            
				e.printStackTrace();
				throw e;
			} finally {  
				em.close();  
			} 
		}

		public DeudaAlquiler obtenerDeuda(int id) throws Exception{		 
			@SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    DeudaAlquiler dato = null;        
	            try{
	                dato = (DeudaAlquiler) sesion.get(DeudaAlquiler.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
		}


		public void eliminarDeuda(DeudaAlquiler dato) throws Exception{		 
			@SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
			Transaction tx = null;  
			try {  
				tx = sesion.beginTransaction();  
				sesion.delete(dato);  
				tx.commit();  
	       
			} catch (Exception e) {  
				tx.rollback();  
	       
				throw new Exception(e.getMessage(), e.getCause());
			} finally {  
				sesion.close();  
			}  
		}

		public void actualizarDeuda(DeudaAlquiler dato) throws Exception{
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

		public List<DeudaAlquiler> obtenerTodos() throws Exception {            
	  
			List<DeudaAlquiler> datos = new ArrayList<DeudaAlquiler>();  
			Session em = sesionPostgres.openSession();  	
			try {  	
				datos =  (List<DeudaAlquiler>) em.createCriteria(DeudaAlquiler.class).list();             
			} catch (Exception e) {             
	   
				throw new Exception(e.getMessage(),e.getCause());
			} finally {  
				em.close();  
			} 
	   
			return datos; 
		}	
		
		
	
	

}

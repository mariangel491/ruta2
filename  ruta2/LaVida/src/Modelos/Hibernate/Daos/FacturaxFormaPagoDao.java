package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.FacturaxFormaPago;
import Modelos.Hibernate.Config.HibernateUtil;

public class FacturaxFormaPagoDao {

private HibernateUtil sesionPostgres;
	
	
	public void agregarFormaPago(FacturaxFormaPago dato) throws Exception{
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

	public FacturaxFormaPago obtenerFormaPago(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
		FacturaxFormaPago dato = null;        
            try{
                dato = (FacturaxFormaPago) sesion.get(FacturaxFormaPago.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarFormaPago(int posi, FacturaxFormaPago dato) throws Exception{		 
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

	public void actualizarFormaPago(int posi, FacturaxFormaPago dato) throws Exception{
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

	public List<FacturaxFormaPago> obtenerTodos() throws Exception {            
  
		List<FacturaxFormaPago> datos = new ArrayList<FacturaxFormaPago>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<FacturaxFormaPago>) em.createCriteria(FacturaxFormaPago.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public FacturaxFormaPago buscarPorCodForma(String cod) throws Exception {
		for (FacturaxFormaPago factxformaPago : obtenerTodos())
			if (factxformaPago.getId().equals(cod))
				return factxformaPago;
		return null;
	}
	

}

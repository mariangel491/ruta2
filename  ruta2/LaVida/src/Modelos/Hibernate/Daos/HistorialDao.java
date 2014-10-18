package Modelos.Hibernate.Daos;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Modelos.Alquiler;
import Modelos.Historial;
import Modelos.Hibernate.Config.HibernateUtil;

public class HistorialDao   {
	
	
private HibernateUtil sesionPostgres;
	
	public void agregarHistorial(Historial dato) throws Exception{
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
	
	public Historial obtenerHistorial(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    Historial dato = null;        
	            try{
	                dato = (Historial) sesion.get(Historial.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
	}
	
	
	public List<Historial> obtenerTodos() throws Exception {            
      
		List<Historial> datos = new ArrayList<Historial>();  
	  Session em = sesionPostgres.openSession();  	
        try {  	
	    datos =  (List<Historial>) em.createCriteria(Historial.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	public Historial buscarPorCodHistorial(String codHistorial) throws Exception {
		for (Historial historial : obtenerTodos())
			if (historial.getCodHistorial().equals(codHistorial))
				return historial;
		return null;
	}

	public boolean encontrarCodHistorial(String codHistorial) throws Exception {
		if (buscarPorCodHistorial(codHistorial) == null)
			return false;
		return true;
	}
	
	public Historial buscarPorFecha(Date fecha) throws Exception {
		for (Historial historial : obtenerTodos())
			if (historial.getFecha().equals(fecha))
				return historial;
		return null;
	}

	public boolean encontrarFecha(Date fecha) throws Exception {
		if (buscarPorFecha(fecha) == null)
			return false;
		return true;
	}
	
	public Historial buscarPorCodIngreso(String codIngreso) throws Exception {
		for (Historial historial : obtenerTodos())
			if (historial.getIngresos().equals(codIngreso))
				return historial;
		return null;
	}
	/*NOTA: NO ESTOY SEGURA SI ASI LO HACE LA BUSQUEDA DENTRO DEL ARRAYS... HAY QUE PROBARLO */
	
	
	public boolean encontrarCodIngreso(String codIngreso) throws Exception {
		if (buscarPorCodIngreso(codIngreso) == null)
			return false;
		return true;
	}

	
}

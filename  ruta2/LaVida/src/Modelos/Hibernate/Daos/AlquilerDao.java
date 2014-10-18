package Modelos.Hibernate.Daos;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Modelos.Alquiler;
import Modelos.Hibernate.Config.HibernateUtil;


public class AlquilerDao {
	
	
private HibernateUtil sesionPostgres;
	
	public void agregarAlquiler(Alquiler dato) throws Exception{
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
	
	public Alquiler obtenerAlquiler(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    Alquiler dato = null;        
	            try{
	                dato = (Alquiler) sesion.get(Alquiler.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
	}
	
	
	public void eliminarAlquiler(int posi, Alquiler dato) throws Exception{		 
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
	
	public void actualizarAlquiler(int posi, Alquiler dato) throws Exception{
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
	
	public List<Alquiler> obtenerTodos() throws Exception {            
      
		List<Alquiler> datos = new ArrayList<Alquiler>();  
	  Session em = sesionPostgres.openSession();  	
        try {  	
	    datos =  (List<Alquiler>) em.createCriteria(Alquiler.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	public List<Alquiler> getLocalesNombre(String dato) {
		List<Alquiler> resultado = new ArrayList<Alquiler>();
		Session em =sesionPostgres.openSession();

		try{			
			resultado = em.createCriteria(Alquiler.class).add(Restrictions.like("nombre",dato)).list();
			
     	}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	
	public Alquiler buscarPorCodAlquiler(String codAlquiler) throws Exception {
		for (Alquiler alquiler : obtenerTodos())
			if (alquiler.getCodAlquiler().equals(codAlquiler))
				return alquiler;
		return null;
	}

	public boolean encontrar(String codAlquiler) throws Exception {
		if (buscarPorCodAlquiler(codAlquiler) == null)
			return false;
		return true;
	}

	
	public Alquiler buscarPorCodLocal(String codLocal) throws Exception {
		for (Alquiler alquiler : obtenerTodos())
			if (alquiler.getCodLocal().equals(codLocal))
				return alquiler;
		return null;
	}

	public boolean encontrarLocal(String codLocal) throws Exception {
		if (buscarPorCodLocal(codLocal) == null)
			return false;
		return true;
	}
	
	public Alquiler buscarPorInquilino(String codInquilino) throws Exception {
		for (Alquiler alquiler : obtenerTodos())
			if (alquiler.getCodInquilino().equals(codInquilino))
				return alquiler;
		return null;
	}

	public boolean encontrarInquilino(String codInquilino) throws Exception {
		if (buscarPorInquilino(codInquilino) == null)
			return false;
		return true;
	}
}

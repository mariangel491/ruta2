package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Alquiler;
import Modelos.CuentaAhorro;
import Modelos.Hibernate.Config.HibernateUtil;

public class CuentaAhorroDao {
	
private HibernateUtil sesionPostgres;
	
	public void agregarTransaccion(CuentaAhorro dato) throws Exception{
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
	
	public CuentaAhorro obtenerTransaccion(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    CuentaAhorro dato = null;        
	            try{
	                dato = (CuentaAhorro) sesion.get(CuentaAhorro.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
	}
	
	
	public void eliminarTransaccion(int posi, CuentaAhorro dato) throws Exception{		 
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
	
	public void actualizarTransaccion(int posi, CuentaAhorro dato) throws Exception{
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
	
	public List<CuentaAhorro> obtenerTodos() throws Exception {            
      
		List<CuentaAhorro> datos = new ArrayList<CuentaAhorro>();  
	  Session em = sesionPostgres.openSession();  	
        try {  	
	    datos =  (List<CuentaAhorro>) em.createCriteria(CuentaAhorro.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}

	public CuentaAhorro buscarPorNroCuenta(String nroCuenta) throws Exception {
		for (CuentaAhorro ctaahorro : obtenerTodos())
			if (ctaahorro.getNro_cuenta().equals(nroCuenta))
				return ctaahorro;
		return null;
	}

	public boolean encontrar(String nroCuenta) throws Exception {
		if (buscarPorNroCuenta(nroCuenta) == null)
			return false;
		return true;
	}
}

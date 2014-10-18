package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Deuda;
import Modelos.Hibernate.Config.HibernateUtil;

public class DeudaDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarEgresos(Deuda dato) throws Exception{
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

	public Deuda obtenerEgresos(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Deuda dato = null;        
            try{
                dato = (Deuda) sesion.get(Deuda.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarEgresos(int posi, Deuda dato) throws Exception{		 
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

	public void actualizarEgresos(int posi, Deuda dato) throws Exception{
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

	public List<Deuda> obtenerTodos() throws Exception {            
  
		List<Deuda> datos = new ArrayList<Deuda>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Deuda>) em.createCriteria(Deuda.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public Deuda buscarPorCodEgreso(String codDeuda) throws Exception {
		for (Deuda deuda : obtenerTodos())
			if (deuda.getCodigo().equals(codDeuda))
				return deuda;
		return null;
	}

	public boolean encontrar(String codDeuda) throws Exception {
		if (buscarPorCodEgreso(codDeuda) == null)
			return false;
		return true;
	}

}

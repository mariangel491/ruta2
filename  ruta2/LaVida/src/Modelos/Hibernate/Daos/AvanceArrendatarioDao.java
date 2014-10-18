package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import Modelos.AvanceArrendatario;
import Modelos.Hibernate.Config.HibernateUtil;

public class AvanceArrendatarioDao {

private HibernateUtil sesionPostgres;
	
	
	public void agregarAvance(AvanceArrendatario dato) throws Exception{
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

	public AvanceArrendatario obtenerAvance(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
		AvanceArrendatario dato = null;        
            try{
                dato = (AvanceArrendatario) sesion.get(AvanceArrendatario.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarAvance(int posi, AvanceArrendatario dato) throws Exception{		 
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

	public void actualizarAvance(int posi, AvanceArrendatario dato) throws Exception{
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

	public List<AvanceArrendatario> obtenerTodos() throws Exception {            
  
		List<AvanceArrendatario> datos = new ArrayList<AvanceArrendatario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<AvanceArrendatario>) em.createCriteria(AvanceArrendatario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public List<AvanceArrendatario> obtenerTodosxSocio(boolean prueba) throws Exception {            
		  
		List<AvanceArrendatario> datos = new ArrayList<AvanceArrendatario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<AvanceArrendatario>) em.createCriteria(AvanceArrendatario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	

	public AvanceArrendatario buscarPorCodAvance(String codAvance) throws Exception {
		for (AvanceArrendatario avance : obtenerTodos())
			if (avance.getCodAvance().equals(codAvance))
				return avance;
		return null;
	}

	public boolean encontrar(String codAvance) throws Exception {
		if (buscarPorCodAvance(codAvance) == null)
			return false;
		return true;
	}

	
	public AvanceArrendatario buscarPorCodArrendatario(String codArrendatario) throws Exception {
		for (AvanceArrendatario avance : obtenerTodos())
			if (avance.getArrendatario().equals(codArrendatario))
				return avance;
		return null;
	}

	public boolean encontrarCod(String codArrendatario) throws Exception {
		if (buscarPorCodArrendatario(codArrendatario) == null)
			return false;
		return true;
	}
}

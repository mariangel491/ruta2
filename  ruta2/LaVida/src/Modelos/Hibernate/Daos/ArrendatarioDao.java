package Modelos.Hibernate.Daos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Arrendatario;
import Modelos.Hibernate.Config.HibernateUtil;

public class ArrendatarioDao {
	
	private HibernateUtil sesionPostgres;
	
	
	public void agregarArrendatario(Arrendatario dato) throws Exception{
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

	public Arrendatario obtenerArrendatario(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Arrendatario dato = null;        
            try{
                dato = (Arrendatario) sesion.get(Arrendatario.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarArrendatario(int posi, Arrendatario dato) throws Exception{		 
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

	public void actualizarArrendatario(int posi, Arrendatario dato) throws Exception{
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

	public List<Arrendatario> obtenerTodos() throws Exception {            
  
		List<Arrendatario> datos = new ArrayList<Arrendatario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Arrendatario>) em.createCriteria(Arrendatario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public Arrendatario buscarPorCedulaArrendatario(String cedulaArrendatario) {
		Arrendatario arrendatario = null;  
		Session em = sesionPostgres.openSession();  	
		try {  	
			arrendatario =  (Arrendatario)em.createQuery("from Arrendatario where cedula='"+cedulaArrendatario+"'").uniqueResult();
		} catch (Exception e) {             
			em.cancelQuery();

		} finally {  
			em.close();  
		} 
   
		return arrendatario; 
	}

	public boolean encontrar(String codArren) throws Exception {
		if (buscarPorCedulaArrendatario(codArren) == null)
			return false;
		return true;
	}

	public Arrendatario buscarPorCedulaArrendatario(Integer codArren) throws Exception {
		for (Arrendatario arrendatario : obtenerTodos())
			if (arrendatario.getCedula().equals(codArren))
				return arrendatario;
		return null;
	}

	public boolean encontrar(Integer codArren) throws Exception {
		if (buscarPorCedulaArrendatario(codArren) == null)
			return false;
		return true;
	}

}

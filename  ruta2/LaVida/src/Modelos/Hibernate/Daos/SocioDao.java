package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Socio;
import Modelos.Hibernate.Config.HibernateUtil;

public class SocioDao  {
	
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarSocio(Socio dato) throws Exception{
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

	public Socio obtenerSocio(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Socio dato = null;        
            try{
                dato = (Socio) sesion.get(Socio.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarSocio(int posi, Socio dato) throws Exception{		 
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

	public void actualizarSocio(Socio dato) throws Exception{
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

	public List<Socio> obtenerTodos() throws Exception {            
  
		List<Socio> datos = new ArrayList<Socio>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Socio>) em.createCriteria(Socio.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public Socio buscarPorNroSocio(String nroSocio) throws Exception {
		for (Socio socio : obtenerTodos())
			if (socio.getNroSocio().equals(nroSocio))
				return socio;
		return null;
	}

	public boolean encontrar(String nroSocio) throws Exception {
		if (buscarPorNroSocio(nroSocio) == null)
			return false;
		return true;
	}
	
	
	public Socio buscarPorCedula(String cedula) throws Exception {
		for (Socio socio : obtenerTodos())
			if (socio.getCedula().equals(cedula))
				return socio;
		return null;
	}

	public boolean encontrarCed(String cedula) throws Exception {
		if (buscarPorCedula(cedula) == null)
			return false;
		return true;
	}
	

}

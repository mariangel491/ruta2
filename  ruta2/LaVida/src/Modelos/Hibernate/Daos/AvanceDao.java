package Modelos.Hibernate.Daos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Avance;
import Modelos.Hibernate.Config.HibernateUtil;


public class AvanceDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarAvance(Avance dato) throws Exception{
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

	public Avance obtenerAvance(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Avance dato = null;        
            try{
                dato = (Avance) sesion.get(Avance.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarAvance(int posi, Avance dato) throws Exception{		 
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

	public void actualizarAvance(int posi, Avance dato) throws Exception{
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

	public List<Avance> obtenerTodos() throws Exception {            
  
		List<Avance> datos = new ArrayList<Avance>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Avance>) em.createCriteria(Avance.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public List<Avance> ObtenerPorSocios(String cod) throws Exception{
		List<Avance> avancexsoc= new ArrayList<Avance>();
		
		for(Avance avance: obtenerTodos())
			if(avance.getSocio().getNroSocio().equals(cod))
				avancexsoc.add(avance);
		return avancexsoc;
		
	}
	
	public Avance buscarPorCodAvance(String codAvance) throws Exception {
		for (Avance avance : obtenerTodos())
			if (avance.getCodAvance().equals(codAvance))
				return avance;
		return null;
	}


	public Avance buscarPorCedulaAvance(String cedAvance) throws Exception {
		for (Avance avance : obtenerTodos())
			if (avance.getCedula().equals(cedAvance))
				return avance;
		return null;
	}
	
	public boolean encontrarPorCedula(String cedAvance) throws Exception {
		if (buscarPorCedulaAvance(cedAvance) == null)
			return false;
		return true;
	}
	
	public boolean encontrar(String codAvance) throws Exception {
		if (buscarPorCodAvance(codAvance) == null)
			return false;
		return true;
	}

	
	public Avance buscarPorCodSocio(String codSocio) throws Exception {
		for (Avance avance : obtenerTodos())
			if (avance.getSocio().equals(codSocio))
				return avance;
		return null;
	}

	public boolean encontrarCod(String codSocio) throws Exception {
		if (buscarPorCodSocio(codSocio) == null)
			return false;
		return true;
	}

	
}

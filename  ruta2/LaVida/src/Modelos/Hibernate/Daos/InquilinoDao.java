package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Inquilino;
import Modelos.Hibernate.Config.HibernateUtil;

public class InquilinoDao  {
	
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarInquilino(Inquilino dato) throws Exception{
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

	public Inquilino obtenerInquilino(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Inquilino dato = null;        
            try{
                dato = (Inquilino) sesion.get(Inquilino.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarInquilino(int posi, Inquilino dato) throws Exception{		 
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

	public void actualizarInquilino(int posi, Inquilino dato) throws Exception{
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

	public List<Inquilino> obtenerTodos() throws Exception {            
  
		List<Inquilino> datos = new ArrayList<Inquilino>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Inquilino>) em.createCriteria(Inquilino.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	
	public Inquilino buscarPorCodInquilino(String codInquilino) throws Exception {
		for (Inquilino inquilino : obtenerTodos())
			if (inquilino.getCodInquilino().equals(codInquilino))
				return inquilino;
		return null;
	}

	public boolean encontrar(String codInquilino) throws Exception {
		if (buscarPorCodInquilino(codInquilino) == null)
			return false;
		return true;
	}
	

	public Inquilino buscarPorRif(String rif) {
		Inquilino inquilino = null;  
		Session em = sesionPostgres.openSession();  	
		try {  	
			inquilino =  (Inquilino)em.createQuery("from Inquilino where rif='"+rif+"'").uniqueResult();
		} catch (Exception e) {             
			em.cancelQuery();

		} finally {  
			em.close();  
		} 
   
		return inquilino; 
	}
	
	public Inquilino buscarPorCedula(String cedula){
		Inquilino inquilino = null;  
		Session em = sesionPostgres.openSession();  	
		try {  	
			inquilino =  (Inquilino)em.createQuery("from Inquilino where cedula='"+cedula+"'").uniqueResult();
		} catch (Exception e) {             
			em.cancelQuery();

		} finally {  
			em.close();  
		} 
   
		return inquilino; 
	}

}

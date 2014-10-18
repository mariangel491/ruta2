package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



import Modelos.Subsidio;
import Modelos.Hibernate.Config.HibernateUtil;

public class SubsidioDao{
	
	private HibernateUtil sesionPostgres;
	
	public void agregarSubsidio(Subsidio dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();  
		Transaction tx = null;  
		try {    
			tx = (em).beginTransaction();
			(em).save( dato);   
			tx.commit();  
		} catch (Exception e) {  
			tx.rollback();            
			e.printStackTrace();
			throw e;
		} finally {  
			em.close();  
		} 
	}

	public Subsidio obtenerSubsidio(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
		Subsidio dato = null;        
            try{
                dato = (Subsidio) (sesion).get(Subsidio.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarSubsidio(int posi, Subsidio dato) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
		Transaction tx = null;  
		try {  
			tx = (sesion).beginTransaction();  
			(sesion).delete(dato);  
			tx.commit();  
       
		} catch (Exception e) {  
			tx.rollback();  
       
			throw new Exception(e.getMessage(), e.getCause());
		} finally {  
			sesion.close();  
		}  
	}

	public void actualizarSubsidio(int posi, Subsidio dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();  
		Transaction tx = null;  
		try {    
			tx = (em).beginTransaction();
			(em).update(dato);   
			tx.commit();  
		} catch (Exception e) {  
			tx.rollback();            
			e.printStackTrace();
			throw e;
		} finally {  
			em.close();  
		} 
	}

	public List<Subsidio> obtenerTodos() throws Exception {            
  
		List<Subsidio> datos = new ArrayList<Subsidio>();  
		Session em = HibernateUtil.openSession();  	
		try {  	
			datos =  (List<Subsidio>) (em).createCriteria(Subsidio.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}

	public Subsidio buscarCodSocio(String codSocio) throws Exception {
		for (Subsidio subsidio : obtenerTodos())
			if (subsidio.getSocio().getNroSocio().equals(codSocio))
				return subsidio;
		return null;
	}

	public boolean encontrar(String codSocio) throws Exception {
		if (buscarCodSocio(codSocio) == null)
			return false;
		return true;
	}

}

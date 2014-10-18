package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import Modelos.Local;
import Modelos.Hibernate.Config.HibernateUtil;


public class LocalDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarLocal(Local dato) throws Exception{
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

	public Local obtenerLocal(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Local dato = null;        
            try{
                dato = (Local) (sesion).get(Local.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarLocal(int posi, Local dato) throws Exception{		 
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

	public void actualizarLocal(int posi, Local dato) throws Exception{
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

	public List<Local> obtenerTodos() throws Exception {            
  
		List<Local> datos = new ArrayList<Local>();  
		Session em = HibernateUtil.openSession();  	
		try {  	
			datos =  (List<Local>) (em).createCriteria(Local.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}

	public Local buscarCodLocal(String codLocal) throws Exception {
		for (Local local : obtenerTodos())
			if (local.getCodLocal().equals(codLocal))
				return local;
		return null;
	}

	public boolean encontrar(String codLocal) throws Exception {
		if (buscarCodLocal(codLocal) == null)
			return false;
		return true;
	}
	
}

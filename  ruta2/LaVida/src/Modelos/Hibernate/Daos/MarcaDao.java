package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Marca;
import Modelos.Hibernate.Config.HibernateUtil;

public class MarcaDao {
	

	private HibernateUtil sesionPostgres;
	
	
	public void agregarMarca(Marca dato) throws Exception{
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

	public Marca obtenerMarca(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Marca dato = null;        
            try{
                dato = (Marca) sesion.get(Marca.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarMarca(int posi, Marca dato) throws Exception{		 
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

	public void actualizarMarca(int posi, Marca dato) throws Exception{
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

	public List<Marca> obtenerTodos() throws Exception {            
  
		List<Marca> datos = new ArrayList<Marca>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Marca>) em.createCriteria(Marca.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	

	public Marca buscarPorNombre(String nombre) throws Exception {
		for (Marca marca : obtenerTodos())
			if (marca.getDescripcion().equals(nombre))
				return marca;
		return null;
	}

	public boolean encontrar(String nombre) throws Exception {
		if (buscarPorNombre(nombre) == null)
			return false;
		return true;
	}

}

package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Deuda;
import Modelos.Hibernate.Config.HibernateUtil;

public class DeudaDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarDeuda(Deuda dato) throws Exception{
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

	public Deuda obtenerDeuda(int id) throws Exception{		 
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


	public void eliminarDeuda(Deuda dato) throws Exception{		 
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

	public void actualizarDeuda(Deuda dato) throws Exception{
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
	
	public List<Deuda> obtenerDeudasActivasPorSocio(String nroSocio){
		List<Deuda> datos = new ArrayList<Deuda>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			for(int i=0;i<this.obtenerTodos().size(); i++) {
				if(this.obtenerTodos().get(i).getSocio().getNroSocio().equals(nroSocio)){
					if(this.obtenerTodos().get(i).getStatus().equals("A"))
						datos.add(this.obtenerTodos().get(i));
				}
			}          
		} catch (Exception e) {             

		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public Deuda buscarPorCodDeuda(String codDeuda) throws Exception {
		for (Deuda deuda : obtenerTodos())
			if (deuda.getCodigo().equals(codDeuda))
				return deuda;
		return null;
	}

	public boolean encontrar(String codDeuda) throws Exception {
		if (buscarPorCodDeuda(codDeuda) == null)
			return false;
		return true;
	}

}

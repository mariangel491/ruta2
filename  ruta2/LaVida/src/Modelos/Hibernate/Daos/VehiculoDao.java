package Modelos.Hibernate.Daos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Vehiculo;
import Modelos.Hibernate.Config.HibernateUtil;

public class VehiculoDao  {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarVehiculo(Vehiculo dato) throws Exception{
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

	public Vehiculo obtenerVehiculo(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Vehiculo dato = null;        
            try{
                dato = (Vehiculo) sesion.get(Vehiculo.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarVehiculo(int posi, Vehiculo dato) throws Exception{		 
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

	public void actualizarVehiculo(int posi, Vehiculo dato) throws Exception{
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

	public List<Vehiculo> obtenerTodos() throws Exception {            
  
		List<Vehiculo> datos = new ArrayList<Vehiculo>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Vehiculo>) em.createCriteria(Vehiculo.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public List<Vehiculo> obtenerTodosxSocio(boolean prueba) throws Exception {            
		  
		List<Vehiculo> datos = new ArrayList<Vehiculo>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Vehiculo>) em.createCriteria(Vehiculo.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public Vehiculo buscarPorPlaca(String placa) throws Exception {
		for (Vehiculo vehiculo : obtenerTodos())
			if (vehiculo.getPlaca().equals(placa))
				return vehiculo;
		return null;
	}

	public boolean encontrar(String placa) throws Exception {
		if (buscarPorPlaca(placa) == null)
			return false;
		return true;
	}

	
	public Vehiculo buscarPorSocio(String nroSocio) throws Exception {
		for (Vehiculo vehiculo : obtenerTodos())
			if (vehiculo.getPlaca().equals(nroSocio))
				return vehiculo;
		return null;
	}

	public boolean encontrarPorSocio(String nroSocio) throws Exception {
		if (buscarPorSocio(nroSocio) == null)
			return false;
		return true;
	}
	
}

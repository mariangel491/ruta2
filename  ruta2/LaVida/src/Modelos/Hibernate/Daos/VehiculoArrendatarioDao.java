package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.VehiculoArrendatario;
import Modelos.Hibernate.Config.HibernateUtil;

public class VehiculoArrendatarioDao {

private HibernateUtil sesionPostgres;
	
	
	public void agregarVehiculoArren(VehiculoArrendatario dato) throws Exception{
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

	public VehiculoArrendatario obtenerVehiculoArren(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    VehiculoArrendatario dato = null;        
            try{
                dato = (VehiculoArrendatario) sesion.get(VehiculoArrendatario.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarVehiculoArren(int posi, VehiculoArrendatario dato) throws Exception{		 
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

	public void actualizarVehiculo(VehiculoArrendatario dato) throws Exception{
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

	public List<VehiculoArrendatario> obtenerTodos() throws Exception {            
  
		List<VehiculoArrendatario> datos = new ArrayList<VehiculoArrendatario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<VehiculoArrendatario>) em.createCriteria(VehiculoArrendatario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public List<VehiculoArrendatario> obtenerTodosxArrendatario(String ced) throws Exception {            
		  
		List<VehiculoArrendatario> datos = new ArrayList<VehiculoArrendatario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<VehiculoArrendatario>) em.createCriteria(VehiculoArrendatario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}
	
	public VehiculoArrendatario buscarPorPlaca(String placa) throws Exception {
		for (VehiculoArrendatario vehiculo : obtenerTodos())
			if (vehiculo.getPlaca().equals(placa))
				return vehiculo;
		return null;
	}

	public boolean encontrar(String placa) throws Exception {
		if (buscarPorPlaca(placa) == null)
			return false;
		return true;
	}

	public VehiculoArrendatario buscarPorArrendatario(String cod) throws Exception {
		for (VehiculoArrendatario vehiculo : obtenerTodos())
			if (vehiculo.getArrendatario().getCedula().equals(cod))
				return vehiculo;
		return null;
	}

	public boolean encontrarPorArrendatario(String codArren) throws Exception {
		if (buscarPorArrendatario(codArren) == null)
			return false;
		return true;
	}
}

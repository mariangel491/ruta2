package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.FormaPago;
import Modelos.Hibernate.Config.HibernateUtil;

public class FormaPagoDao  {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarFormaPago(FormaPago dato) throws Exception{
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

	public FormaPago obtenerFormaPago(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    FormaPago dato = null;        
            try{
                dato = (FormaPago) sesion.get(FormaPago.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarFormaPago(int posi, FormaPago dato) throws Exception{		 
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

	public void actualizarFormaPago(int posi, FormaPago dato) throws Exception{
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

	public List<FormaPago> obtenerTodos() throws Exception {            
  
		List<FormaPago> datos = new ArrayList<FormaPago>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<FormaPago>) em.createCriteria(FormaPago.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public FormaPago buscarPorCodForma(String codForma) throws Exception {
		for (FormaPago formaPago : obtenerTodos())
			if (formaPago.getCodForma().equals(codForma))
				return formaPago;
		return null;
	}
	
	public FormaPago buscarPoDescrip(String nombre) throws Exception {
		for (FormaPago formaPago : obtenerTodos())
			if (formaPago.getNombre().equalsIgnoreCase(nombre))
				return formaPago;
		return null;
	}
	
	public boolean encontrarNombre(String nombre) throws Exception{
		if(buscarPoDescrip(nombre)==null)
			return false;
		return true;
	}

	public boolean encontrar(String codForma) throws Exception {
		if (buscarPorCodForma(codForma) == null)
			return false;
		return true;
	}

}

package Modelos.Hibernate.Daos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Beneficiario;
import Modelos.Hibernate.Config.HibernateUtil;

public class BeneficiarioDao  {
	
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarBeneficiario(Beneficiario dato) throws Exception{
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

	public Beneficiario obtenerBeneficiario(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Beneficiario dato = null;        
            try{
                dato = (Beneficiario) sesion.get(Beneficiario.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarBeneficiario(int posi, Beneficiario dato) throws Exception{		 
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

	public void actualizarBeneficiario(int posi, Beneficiario dato) throws Exception{
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

	public List<Beneficiario> obtenerTodos() throws Exception {            
  
		List<Beneficiario> datos = new ArrayList<Beneficiario>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Beneficiario>) em.createCriteria(Beneficiario.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	
	public Beneficiario buscarPorCedula(String cedBeneficiario) throws Exception {
		for (Beneficiario beneficiario : obtenerTodos())
			if (beneficiario.getCedBeneficiario().equals(cedBeneficiario))
				return beneficiario;
		return null;
	}

	public boolean encontrar(String cedBeneficiario) throws Exception {
		if (buscarPorCedula(cedBeneficiario) == null)
			return false;
		return true;
	}
	
	public Beneficiario buscarPorSocio(String nroSocio) throws Exception {
		for (Beneficiario beneficiario : obtenerTodos())
			if (beneficiario.getSocio().equals(nroSocio))
				return beneficiario;
		return null;
	}

	public boolean encontrarPorSocio(String nroSocio) throws Exception {
		if (buscarPorCedula(nroSocio) == null)
			return false;
		return true;
	}

}

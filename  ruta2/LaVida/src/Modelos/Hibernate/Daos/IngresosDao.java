package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Arrendatario;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Socio;
import Modelos.Hibernate.Config.HibernateUtil;

public class IngresosDao  {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarIngresos(Ingresos dato) throws Exception{
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

	public Ingresos obtenerIngresos(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Ingresos dato = null;        
            try{
                dato = (Ingresos) sesion.get(Ingresos.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarIngresos(int posi, Ingresos dato) throws Exception{		 
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

	public void actualizarIngresos(int posi, Ingresos dato) throws Exception{
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

	public List<Ingresos> obtenerTodos() throws Exception {            
  
		List<Ingresos> datos = new ArrayList<Ingresos>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Ingresos>) em.createCriteria(Ingresos.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public Ingresos buscarPorCodIngreso(String codIngreso) throws Exception {
		for (Ingresos ingresos : obtenerTodos())
			if (ingresos.getCodIngreso().equals(codIngreso))
				return ingresos;
		return null;
	}

	public boolean encontrar(String codIngreso) throws Exception {
		if (buscarPorCodIngreso(codIngreso) == null)
			return false;
		return true;
	}
	
	public List<Ingresos> obtenerIngresosPorTipos(String tipoFacturado) throws Exception {  
		
		  String condicion="";
		  if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
			  condicion = " where clasificacion in('"+Ingresos.TIPO_INGRESO_RUTA+"','"+Ingresos.TIPO_INGRESO_FONDO_DE_CHOQUE+"')";
		  }
		  else if(tipoFacturado.equalsIgnoreCase(Inquilino.TIPO_FACTURADO_INQUILINO)){
			  condicion = " where clasificacion in('"+Ingresos.TIPO_INGRESO_ALQUILER+"')";
		  }
		  else if(tipoFacturado.equalsIgnoreCase(Arrendatario.TIPO_FACTURADO_ARRENDATARIO)){
			  condicion = " where clasificacion in('"+Ingresos.TIPO_INGRESO_RUTA+"')";
		  }
		  
		List<Ingresos> datos = new ArrayList<Ingresos>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Ingresos>) em.createQuery("from Ingresos "+condicion+" order by descripcion asc").list();    

		} catch (Exception e) {             
 
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
 
		return datos; 
	}	
	
	
	public Ingresos obtenerIngresosPorDescripcion(String tipoFacturado) throws Exception {  
		  
		Ingresos ingreso = new Ingresos();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			ingreso =  (Ingresos) em.createQuery("from Ingresos where descripcion='"+tipoFacturado.trim()+"'").uniqueResult();

		} catch (Exception e) {             

			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 

		return ingreso; 
	}	

}

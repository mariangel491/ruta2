package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Arrendatario;
import Modelos.Egresos;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Socio;
import Modelos.Hibernate.Config.HibernateUtil;

public class EgresosDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarEgresos(Egresos dato) throws Exception{
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

	public Egresos obtenerEgresos(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Egresos dato = null;        
            try{
                dato = (Egresos) sesion.get(Egresos.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarEgresos(int posi, Egresos dato) throws Exception{		 
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

	public void actualizarEgresos(int posi, Egresos dato) throws Exception{
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

	public List<Egresos> obtenerTodos() throws Exception {            
  
		List<Egresos> datos = new ArrayList<Egresos>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Egresos>) em.createCriteria(Egresos.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public Egresos buscarPorCodEgreso(String codEgreso) throws Exception {
		for (Egresos egresos : obtenerTodos())
			if (egresos.getCodEgreso().equals(codEgreso))
				return egresos;
		return null;
	}

	public boolean encontrar(String codEgreso) throws Exception {
		if (buscarPorCodEgreso(codEgreso) == null)
			return false;
		return true;
	}
	
	public List<Egresos> obtenerEgresosPorTipo(String tipoFacturado) throws Exception {  
		
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
		  
		List<Egresos> datos = new ArrayList<Egresos>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Egresos>) em.createQuery("from Egresos "+condicion+" order by descripcion asc").list();    

		} catch (Exception e) {             

			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 

		return datos; 
	}	
	
	public Egresos obtenerEgresosPorDescripcion(String tipoFacturado) throws Exception {  
		  
		Egresos egreso = new Egresos();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			egreso =  (Egresos) em.createQuery("from Egresos where descripcion='"+tipoFacturado.trim()+"'").uniqueResult();

		} catch (Exception e) {             

			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 

		return egreso; 
	}	

}

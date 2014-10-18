package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;






import Modelos.DetalleFactura;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;


public class DetalleFacturaDao  {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarDetalleFactura(DetalleFactura dato) throws Exception{
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

	public DetalleFactura obtenerDetalleFactura(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    DetalleFactura dato = null;        
            try{
                dato = (DetalleFactura) sesion.get(DetalleFactura.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarDetalleFactura(int posi, DetalleFactura dato) throws Exception{		 
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

	public void actualizarDetalleFactura(int posi, DetalleFactura dato) throws Exception{
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

	public List<DetalleFactura> obtenerTodos() throws Exception {            
  
		List<DetalleFactura> datos = new ArrayList<DetalleFactura>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<DetalleFactura>) em.createCriteria(DetalleFactura.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	

	public DetalleFactura buscarPorCodDetalle(String codDetalleFactura) throws Exception {
		for (DetalleFactura detalle : obtenerTodos())
			if (detalle.getCoddetalle().equals(codDetalleFactura))
				return detalle;
		return null;
	}

	public boolean encontrarCodDetalle(String codDetalleFactura) throws Exception {
		if (buscarPorCodDetalle(codDetalleFactura) == null)
			return false;
		return true;
	}
	
	public DetalleFactura buscarPorCodFactura(String codFactura) throws Exception {
		for (DetalleFactura detalle : obtenerTodos())
			if (detalle.getCodFactura().equals(codFactura))
				return detalle;
		return null;
	}

	public boolean encontrarCodFactura(String codFactura) throws Exception {
		if (buscarPorCodFactura(codFactura) == null)
			return false;
		return true;
	}
	
	public String buscarUltimoNumeroDetalleFactura() {
		// TODO Auto-generated method stub
		Integer coddetalle = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(coddetalle) as integer) from DetalleFactura";

		try {
			List<Integer> lista =   em.createSQLQuery(sqlQuery).list(); 
			if(null != lista.get(0)){
				coddetalle = lista.get(0);
			}
			else{
				coddetalle=1;
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		return Utilidades.completar(coddetalle.toString(),"0", 10,true);
	}

}
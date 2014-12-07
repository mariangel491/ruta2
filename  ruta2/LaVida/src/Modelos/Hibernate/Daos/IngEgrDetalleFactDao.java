package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.IEDetalleFactura;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class IngEgrDetalleFactDao {

private HibernateUtil sesionPostgres;
	
	
	public void agregarDetalle(IEDetalleFactura dato) throws Exception{
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

	public List<IEDetalleFactura> obtenerTodos() throws Exception {            
  
		List<IEDetalleFactura> datos = new ArrayList<IEDetalleFactura>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<IEDetalleFactura>) em.createCriteria(IEDetalleFactura.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public String buscarUltimoNumeroDetalleFactura() {
		// TODO Auto-generated method stub
		Integer coddetalle = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(iddetalle) as integer) from iedetallefactura";

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

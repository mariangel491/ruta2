package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class PrestamosDao {
	
private HibernateUtil sesionPostgres;
	
	
	public void agregarPrestamos(Prestamos dato) throws Exception{
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

	public Prestamos obtenerPrestamos(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Prestamos dato = null;        
            try{
                dato = (Prestamos) sesion.get(Prestamos.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarPrestamos(int posi, Prestamos dato) throws Exception{		 
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

	public void actualizarPrestamos(int posi, Prestamos dato) throws Exception{
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

	public List<Prestamos> obtenerTodos() throws Exception {            
  
		List<Prestamos> datos = new ArrayList<Prestamos>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Prestamos>) em.createCriteria(Prestamos.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}

	public Prestamos buscarPorNroSocio(Integer nroSocio) throws Exception {
		for (Prestamos prestamos : obtenerTodos())
			if (prestamos.getNroSocio().equals(nroSocio))
				return prestamos;
		return null;
	}

	public boolean encontrar(Integer nroSocio) throws Exception {
		if (buscarPorNroSocio(nroSocio) == null)
			return false;
		return true;
	}
	
	public String buscarUltimoNumeroPrestamo() {
		// TODO Auto-generated method stub
		Integer codigoPrestamo = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(codigoprestamo) as integer) from Prestamo";

		try {
			List<Integer> lista =   em.createSQLQuery(sqlQuery).list(); 
			if(null != lista.get(0)){
				codigoPrestamo = lista.get(0);
			}
			else{
				codigoPrestamo=1;
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		return Utilidades.completar(codigoPrestamo.toString(),"0", 10,true);
	}
	
	public List buscarPorSocioYDescripcion(String codSocio, String descripcion) {
		// TODO Auto-generated method stub
		List<String> listaAux = new ArrayList<String>();
		Session em = sesionPostgres.openSession();  
		String Query = "select p.codigoprestamo from Prestamo p where p.codigosocio='"+codSocio+"' and upper(p.descripcion) ='"+descripcion.toUpperCase()+"' "+
						" and p.montoprestamo <0 and p.montoprestamo <= (select max(p2.montoprestamo)  from Prestamo p2 where p2.codigosocio='"+codSocio+"' and upper(p2.descripcion) ='"+descripcion.toUpperCase()+"')";

		try {

			listaAux =   em.createSQLQuery(Query).list(); 

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);

		}

		return listaAux;
	}
	
	public Prestamos buscarPorCodigoPrestamo(String codigoprestamo) {
		Prestamos prestamos = null;  
		Session em = sesionPostgres.openSession();  	
		try {  	
			prestamos =  (Prestamos)em.createQuery("from Prestamos where codigoprestamo='"+codigoprestamo+"'").uniqueResult();
		} catch (Exception e) {             
			em.cancelQuery();

		} finally {  
			em.close();  
		} 
   
		return prestamos; 
	}
	
	public boolean encontrarPrestamo(String codigoprestamo) throws Exception {
		if (buscarPorCodigoPrestamo(codigoprestamo) == null)
			return false;
		return true;
	}
	
}

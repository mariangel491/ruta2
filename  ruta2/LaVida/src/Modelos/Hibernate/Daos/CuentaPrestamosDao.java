package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;







import Modelos.CuentaPrestamos;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class CuentaPrestamosDao {

private HibernateUtil sesionPostgres;
	
	public void agregarTransaccion(CuentaPrestamos dato) throws Exception{
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
	
	public CuentaPrestamos obtenerTransaccion(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    CuentaPrestamos dato = null;        
	            try{
	                dato = (CuentaPrestamos) sesion.get(CuentaPrestamos.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
	}
	
	
	public void eliminarTransaccion(int posi, CuentaPrestamos dato) throws Exception{		 
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
	
	public void actualizarTransaccion(int posi, CuentaPrestamos dato) throws Exception{
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
	
	public List<CuentaPrestamos> obtenerTodos() throws Exception {            
      
		List<CuentaPrestamos> datos = new ArrayList<CuentaPrestamos>();  
	  Session em = sesionPostgres.openSession();  	
        try {  	
	    datos =  (List<CuentaPrestamos>) em.createCriteria(CuentaPrestamos.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}

	
	public String buscarUltimoNumeroTramsaccionCuentaFondoChoque() {
		// TODO Auto-generated method stub
		Integer nrotransaccion = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(nrotransaccion) as integer) from cuentaprestamos";

		try {
			List<Integer> lista =   em.createSQLQuery(sqlQuery).list(); 
			if(null != lista.get(0)){
				nrotransaccion = lista.get(0);
			}
			else{
				nrotransaccion=1;
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		return Utilidades.completar(nrotransaccion.toString(),"0", 10,true);
	}
	
/*	
	  public List<Contacto> obtenListaContactos() throws HibernateException 
	    { 
	        List<Contacto> listaContactos = null;  

	        try 
	        { 
	            iniciaOperacion(); 
	            listaContactos = sesion.createQuery("from Contacto").list(); 
	        } finally 
	        { 
	            sesion.close(); 
	        }  

	        return listaContactos; 
	    } */
	
	public List<CuentaPrestamos> MovimientosPrestamos(String CodPrestamo) throws Exception{
		List<CuentaPrestamos> prestSoc= null;
		
		 Session em = sesionPostgres.openSession();  	
	        try {  	
		   prestSoc= em.createQuery("from CuentaPrestamos where status='A'"
		    		+ " and codprestamo= :CodPrestamo ").setParameter("CodPrestamo", CodPrestamo).list();
	        	
		   
	        }  finally {  
	          em.close();  
	        } 
	        return prestSoc; 
		
	}
}

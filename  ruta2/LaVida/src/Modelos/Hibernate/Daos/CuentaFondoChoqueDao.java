package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.CuentaFondoChoque;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class CuentaFondoChoqueDao {
	
private HibernateUtil sesionPostgres;
	
	public void agregarTransaccion(CuentaFondoChoque dato) throws Exception{
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
	
	public CuentaFondoChoque obtenerTransaccion(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    CuentaFondoChoque dato = null;        
	            try{
	                dato = (CuentaFondoChoque) sesion.get(CuentaFondoChoque.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
	}
	
	
	public void eliminarTransaccion(int posi, CuentaFondoChoque dato) throws Exception{		 
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
	
	public void actualizarTransaccion(int posi, CuentaFondoChoque dato) throws Exception{
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
	
	public List<CuentaFondoChoque> obtenerTodos() throws Exception {            
      
		List<CuentaFondoChoque> datos = new ArrayList<CuentaFondoChoque>();  
	  Session em = sesionPostgres.openSession();  	
        try {  	
	    datos =  (List<CuentaFondoChoque>) em.createCriteria(CuentaFondoChoque.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}

	public CuentaFondoChoque buscarPorNroCuenta(String nroCuenta) throws Exception {
		for (CuentaFondoChoque ctaahorro : obtenerTodos())
			if (ctaahorro.getNro_cuenta().equals(nroCuenta))
				return ctaahorro;
		return null;
	}

	public boolean encontrar(String nroCuenta) throws Exception {
		if (buscarPorNroCuenta(nroCuenta) == null)
			return false;
		return true;
	}
	
	public String buscarUltimoNumeroTramsaccionCuentaFondoChoque() {
		// TODO Auto-generated method stub
		Integer nrotransaccion = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(nrotransaccion) as integer) from cuentafondochoque";

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

}

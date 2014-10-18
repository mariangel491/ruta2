package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import Modelos.Alquiler;
import Modelos.Ruta;
import Modelos.Hibernate.Config.HibernateUtil;

public class RutaDao {
	
	private HibernateUtil sesionPostgres;
	
	
	public Ruta obtenerRuta(String id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Ruta dato = null;        
            try{
                dato = (Ruta) sesion.get(Ruta.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	
	public List<Ruta> obtenerTodos() throws Exception {            
		  
		List<Ruta> datos = new ArrayList<Ruta>();  
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Ruta>) em.createCriteria(Ruta.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos;  
	}
	
	public Ruta buscarPorCodRuta(String rif) throws Exception {
		for (Ruta ruta : obtenerTodos())
			if (ruta.getRif().equals(rif))
				return ruta;
		return null;
	}
	
	/*public Ruta obtenerStringRuta() throws Exception {
		// TODO Auto-generated method stub
		 @SuppressWarnings("static-access")
			Session em = sesionPostgres.openSession();  
		    Ruta dato = null;  
		    if(this.obtenerRuta(0).getRif()=="J-306-902686")
		    try {  	
				dato =  (Ruta) em.get(Ruta.class, null);             
			} catch (Exception e) {             
	   
				throw new Exception(e.getMessage(),e.getCause());
			} finally {  
				em.close();  
			} 
	   
			return dato; 
	}
*/

	public boolean encontrar(String rif) throws Exception {
		if (buscarPorCodRuta(rif) == null)
			return false;
		return true;
	}


/*	public Ruta obtenerStringRuta() throws Exception { 
		// TODO Auto-generated method stub
		 @SuppressWarnings("static-access")
			Session em = sesionPostgres.openSession();  
		    Ruta dato = null;  
		    if(this.obtenerRuta(0).getRif()=="J306902686")
		    try {  	
				dato =  (Ruta) em.createCriteria(Ruta.class);             
			} catch (Exception e) {             
	   
				throw new Exception(e.getMessage(),e.getCause());
			} finally {  
				em.close();  
			} 
	   
			return dato; 
	}*/
}

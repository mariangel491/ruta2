package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Caja;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class CajaDao {
		
		private HibernateUtil sesionPostgres;
			
			public void agregarTransaccion(Caja dato) throws Exception{
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
			
			public Caja obtenerTransaccion(int id) throws Exception{		 
				    @SuppressWarnings("static-access")
					Session sesion = sesionPostgres.openSession();  
				    Caja dato = null;        
			            try{
			                dato = (Caja) sesion.get(Caja.class,  id);
			            } catch (Exception e) {  
			            e.printStackTrace();
			           
			            throw new Exception(e.getMessage(),e.getCause());
			            }  finally {  
			                sesion.close();  
			            }  
			           
				    return dato;
			}
			
			
			public void eliminarTransaccion(int posi,Caja dato) throws Exception{		 
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
			
			public void actualizarTransaccion(Caja dato) throws Exception{
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
			
			public List<Caja> obtenerTodos() throws Exception {            
		      
				List<Caja> datos = new ArrayList<Caja>();  
			  Session em = sesionPostgres.openSession();  	
		        try {  	
			    datos =  (List<Caja>) em.createCriteria(Caja.class).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}

			public String buscarUltimoNumeroTramsaccionCaja() {
				// TODO Auto-generated method stub
				Integer nrotransaccion = new Integer(0);
				Session em = sesionPostgres.openSession();  
				String sqlQuery = "select 1 + cast(max(nrotransaccion) as integer) from caja";

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

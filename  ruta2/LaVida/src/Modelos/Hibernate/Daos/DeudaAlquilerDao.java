package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Arrendatario;
import Modelos.DeudaAlquiler;
import Modelos.Inquilino;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;

public class DeudaAlquilerDao {

		
	private HibernateUtil sesionPostgres;
		
	public void agregarDeuda(DeudaAlquiler dato) throws Exception{
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

		public DeudaAlquiler obtenerDeuda(int id) throws Exception{		 
			@SuppressWarnings("static-access")
			Session sesion = sesionPostgres.openSession();  
		    DeudaAlquiler dato = null;        
	            try{
	                dato = (DeudaAlquiler) sesion.get(DeudaAlquiler.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
	           
		    return dato;
		}


		public void eliminarDeuda(DeudaAlquiler dato) throws Exception{		 
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

		public void actualizarDeuda(DeudaAlquiler dato) throws Exception{
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

		public List<DeudaAlquiler> obtenerTodos() throws Exception {            
	  
			List<DeudaAlquiler> datos = new ArrayList<DeudaAlquiler>();  
			Session em = sesionPostgres.openSession();  	
			try {  	
				datos =  (List<DeudaAlquiler>) em.createCriteria(DeudaAlquiler.class).list();             
			} catch (Exception e) {             
	   
				throw new Exception(e.getMessage(),e.getCause());
			} finally {  
				em.close();  
			} 
	   
			return datos; 
		}	
		
		public String buscarUltimoNumeroDeudaA() {
			// TODO Auto-generated method stub
			Integer numeroCompra = new Integer(0);
			Session em = sesionPostgres.openSession();  
			String sqlQuery = "select 1 + cast(max(coddeuda) as integer) from DeudaAlquiler";

			try {
				List<Integer> lista =   em.createSQLQuery(sqlQuery).list(); 
				if(null != lista.get(0)){
					numeroCompra = lista.get(0);
				}
				else{
					numeroCompra=1;
				}

			} catch (Exception e) {
				// TODO: handle exception

			}

			return Utilidades.completar(numeroCompra.toString(),"0", 10,true);
		}

		public List<DeudaAlquiler> buscarDeudasAlquileres(String codInquilino) {
			
			List<DeudaAlquiler> lista = new ArrayList<DeudaAlquiler>();
			Session em = sesionPostgres.openSession();  	
			try {  	
				lista =  (List<DeudaAlquiler>)em.createQuery("from deudaalquiler where codinquilino='"+codInquilino+"'").list();
			} catch (Exception e) {             
				em.cancelQuery();

			} finally {  
				em.close();  
			} 
	   
			return lista; 
		}
	
	

}

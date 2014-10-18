package Modelos.Hibernate.Daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Arrendatario;
import Modelos.DetalleFactura;
import Modelos.Egresos;
import Modelos.Factura;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Socio;
import Modelos.Hibernate.Config.HibernateUtil;
import Utilidades.Utilidades;
import Vistas.VistaFactura;

public class FacturaDao  {
	
private HibernateUtil sesionPostgres;
	
private IngresosDao ingDao= new IngresosDao();
private EgresosDao egDao= new EgresosDao();
private SocioDao socioDao = new SocioDao();
private RutaDao rutaDao = new RutaDao();
private DetalleFacturaDao detalleFacturaDao = new DetalleFacturaDao();
private PrestamosDao prestamosDao = new PrestamosDao();
private InquilinoDao inquilinoDao = new InquilinoDao();
private ArrendatarioDao arrendatarioDao = new ArrendatarioDao();
	
	public void agregarFactura(Factura dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();  
		Transaction tx = null;  
		try {    
			tx = em.beginTransaction();
			em.saveOrUpdate(dato);   
			tx.commit();  
		} catch (Exception e) {  
			tx.rollback();            
			e.printStackTrace();
			throw e;
		} finally {  
			em.close();  
		} 
	}

	public Factura obtenerFactura(int id) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();  
	    Factura dato = null;        
            try{
                dato = (Factura) sesion.get(Factura.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
	}


	public void eliminarFactura(int posi, Factura dato) throws Exception{		 
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

	public void actualizarFactura(int posi, Factura dato) throws Exception{
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

	public List<Factura> obtenerTodos() throws Exception {            
  
		List<Factura> datos = new ArrayList<Factura>();  
		Session em = sesionPostgres.openSession();  	
		try {  	
			datos =  (List<Factura>) em.createCriteria(Factura.class).list();             
		} catch (Exception e) {             
   
			throw new Exception(e.getMessage(),e.getCause());
		} finally {  
			em.close();  
		} 
   
		return datos; 
	}	
	
	public Factura buscarPorNroFactura(String nroFactura) throws Exception {
		for (Factura factura : obtenerTodos())
			if (factura.getNroFactura()==nroFactura)
				return factura;
		return null;
	}

	public boolean encontrar(String nroFactura) throws Exception {
		if (buscarPorNroFactura(nroFactura) == null)
			return false;
		return true;
	}
	

	
	public String buscarUltimoNumeroFactura() {
		// TODO Auto-generated method stub
		Integer numeroCompra = new Integer(0);
		Session em = sesionPostgres.openSession();  
		String sqlQuery = "select 1 + cast(max(nroFactura) as integer) from Factura";

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
	
	

}
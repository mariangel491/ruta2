package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vistas.VistaFactura;
import Modelos.Arrendatario;
import Modelos.CuentaAlquiler;
import Modelos.CuentaFondoChoque;
import Modelos.CuentaIngresos;
import Modelos.CuentaPrestamos;
import Modelos.DetalleFactura;
import Modelos.Factura;
import Modelos.FormaPago;
import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Socio;
import Modelos.Ingresos;
import Modelos.Egresos;
import Modelos.Local;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.CuentaAlquilerDao;
import Modelos.Hibernate.Daos.CuentaFondoChoqueDao;
import Modelos.Hibernate.Daos.CuentaIngresosDao;
import Modelos.Hibernate.Daos.CuentaPrestamosDao;
import Modelos.Hibernate.Daos.DetalleFacturaDao;
import Modelos.Hibernate.Daos.EgresosDao;
import Modelos.Hibernate.Daos.FacturaDao;
import Modelos.Hibernate.Daos.FormaPagoDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.PrestamosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Modelos.Hibernate.Daos.SocioDao;

public class ControladorFactura implements ActionListener, KeyListener{
	
	private VistaFactura vfactura;
	private SocioDao socioDao= new SocioDao();
	private IngresosDao ingDao = new IngresosDao();
	private EgresosDao egDao = new EgresosDao();
	private RutaDao rutaDao = new RutaDao();
	private FacturaDao facturaDao = new FacturaDao();
	private DetalleFacturaDao detalleFacturaDao = new DetalleFacturaDao();
	private InquilinoDao inquilinoDao = new InquilinoDao();
	private ArrendatarioDao arrendatarioDao = new ArrendatarioDao();
	private PrestamosDao prestamosDao = new PrestamosDao();
	private CuentaAlquilerDao cuentaAlquilerDao = new CuentaAlquilerDao();
	private CuentaFondoChoqueDao cuentaFondoChoqueDao = new CuentaFondoChoqueDao();
	private CuentaIngresosDao cuentaIngresosDao = new CuentaIngresosDao();
	private CuentaPrestamos cuentaPrestamos = new CuentaPrestamos();
	private CuentaPrestamosDao cuentaPrestamosDao = new CuentaPrestamosDao();
	private FormaPagoDao formaPagoDao = new FormaPagoDao();


	
	public ControladorFactura(){
		/*vfactura = new VistaFactura();
		vfactura= VistaFactura.obtenerInstancia();
		vfactura.setLocationRelativeTo(null);
		vfactura.setVisible(true);
		vfactura.agregarListener(this);
		vfactura.agregarKey(this);*/
	}
	
	

	public void BuscarSocioCed() throws Exception{
		String cedula= vfactura.getTxtCed();	
		vfactura.BloquearCampos();
				
				for(int i=0; i<socioDao.obtenerTodos().size();i++)
				{
					if(socioDao.obtenerTodos().get(i).getCedula().equals(cedula)){
						vfactura.setTxtNombSocio(socioDao.obtenerTodos().get(i).getNombre());
						vfactura.setTxtNroSocio(socioDao.obtenerTodos().get(i).getNroSocio());
						vfactura.setTxtApellido(socioDao.obtenerTodos().get(i).getApellido());
						}
				}

	}
	
	public void BuscarSocioPorNro(){
		
		String nroSocio= vfactura.getTxtNroSocio();
		vfactura.BloquearCampos();
		try {
			for(int i=0; i<socioDao.obtenerTodos().size();i++)
			{
				if(socioDao.obtenerTodos().get(i).getNroSocio().equals(nroSocio)){
					vfactura.setTxtCedulaSocio(socioDao.obtenerTodos().get(i).getCedula().toString());
					vfactura.setTxtNombSocio(socioDao.obtenerTodos().get(i).getNombre());
					vfactura.setTxtApellido(socioDao.obtenerTodos().get(i).getApellido());
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
	  
		if(ae.getActionCommand().equalsIgnoreCase("A�adir")){
			
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Procesar")){
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Salir")){
			vfactura.cerrarVentana();
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			BuscarSocioPorNro();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedula")){
			try {
				BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  	}
	
public DefaultTableModel agregarIngresoEgresoATabla(Object[] objetosSeleccionados, JComboBox tipoFactura, JTable jTableIngresosXFactura, Double montoEgreso,Object objetoPrestamoPendiente){
		
		DefaultTableModel modeloDeLaTabla=(DefaultTableModel)jTableIngresosXFactura.getModel();
		Ingresos ingreso; 
		Egresos egreso; 
		for (int i = 0; i < objetosSeleccionados.length; i++) {

			if(tipoFactura.getSelectedItem().toString().equalsIgnoreCase(VistaFactura.TIPO_DE_FACTURA_INGRESOS)){
				ingreso  = new Ingresos();
				try {
					ingreso = ingDao.obtenerIngresosPorDescripcion((String)objetosSeleccionados[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object[] datosDeLaFila = {ingreso.getCodIngreso(),ingreso.getDescripcion(),ingreso.getMonto()/*montoEgreso.toString()*/, ingreso.getClasifIngreso(),(String)objetoPrestamoPendiente};
				 modeloDeLaTabla.addRow(datosDeLaFila);
			}
			else if(tipoFactura.getSelectedItem().toString().equalsIgnoreCase(VistaFactura.TIPO_DE_FACTURA_EGRESOS)){
				egreso = new Egresos();
				try {
					egreso = egDao.obtenerEgresosPorDescripcion((String)objetosSeleccionados[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object[] datosDeLaFila = {egreso.getCodEgreso(),egreso.getDescripcion(),montoEgreso.toString(), egreso.getClasificacion(),objetoPrestamoPendiente};
				 modeloDeLaTabla.addRow(datosDeLaFila);
			}	     
	       
		}
		return modeloDeLaTabla;

	}
	

public String guardarFacturaEgreso(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal){
	
	 String valorMensaje="";
	 Factura factura = new Factura();
	 String montoString ="";
	 String clasificacion="";
	 try {

		 
		 factura.setMontoTotal(Float.valueOf(montoTotal) * -1);
		 factura.setFechaEmision(new Date(System.currentTimeMillis()));
		 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
			 factura.setNroSocio(socioDao.buscarPorNroSocio(campoId));	 
		 }
		 else if(tipoFacturado.equalsIgnoreCase(Inquilino.TIPO_FACTURADO_INQUILINO)){
			 factura.setInquilino(inquilinoDao.buscarPorRif(campoId));
		 }
		 else if(tipoFacturado.equalsIgnoreCase(Arrendatario.TIPO_FACTURADO_ARRENDATARIO)){
			 factura.setArrendatario(arrendatarioDao.buscarPorCedulaArrendatario(cedula));
		 }
		 
		 factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
		 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
		 facturaDao.agregarFactura(factura);

	 
		 Set<DetalleFactura> listaDetalleFactura = new HashSet<DetalleFactura>();

		 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
		 {
			 Prestamos prestamo = new Prestamos();
			 DetalleFactura detalleFactura = new DetalleFactura();
			 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
			 detalleFactura.setCodFactura(factura);
		 
			 Egresos egreso = new Egresos();
			 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
			 {

				if (a==0){
					egreso.setCodEgreso(lista.getValueAt(i ,a).toString());
				}
				else if(a==1){
					egreso.setDescripcion(lista.getValueAt(i ,a).toString());
				}
				else if(a==2){
					montoString = new String();
					montoString = (String)lista.getValueAt(i ,a);						
				}
				else if(a==3){
					clasificacion = lista.getValueAt(i ,a).toString();
				}
				detalleFactura.setEgresos(egreso);
			 }

			 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
			 
			 if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_ALQUILER)){
				 CuentaAlquiler cuentaAlquiler = new CuentaAlquiler();
				 cuentaAlquiler.setFactura(factura);
				 cuentaAlquiler.setDescripTransac(egreso.getDescripcion());
				 cuentaAlquiler.setFecha(new Date(System.currentTimeMillis()));
				 cuentaAlquiler.setMontoTransaccion(Float.valueOf(montoString) * -1);
				 cuentaAlquiler.setStatus("A");
				 cuentaAlquiler.setNro_cuenta(cuentaAlquilerDao.buscarUltimoNumeroTramsaccionCuentaAlquiler());
				 cuentaAlquilerDao.agregarTransaccion(cuentaAlquiler);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_FONDO_DE_CHOQUE)){
				 CuentaFondoChoque cuentaFondoChoque = new CuentaFondoChoque();
				 cuentaFondoChoque.setFactura(factura);
				 cuentaFondoChoque.setDescripTransac(egreso.getDescripcion());
				 cuentaFondoChoque.setFecha(new Date(System.currentTimeMillis()));
				 cuentaFondoChoque.setMontoTransaccion(Float.valueOf(montoString) * -1);
				 cuentaFondoChoque.setStatus("A");	
				 cuentaFondoChoque.setNro_cuenta(cuentaFondoChoqueDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
				 cuentaFondoChoqueDao.agregarTransaccion(cuentaFondoChoque);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_RUTA)){
				
				 CuentaIngresos cuentaIngresos= new CuentaIngresos();
				 cuentaIngresos.setFactura(factura);
				 cuentaIngresos.setDescripTransac(egreso.getDescripcion());
				 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
				 cuentaIngresos.setMontoTransaccion(Float.valueOf(montoString) * -1);
				 cuentaIngresos.setStatus("A");	
				 cuentaIngresos.setNro_cuenta(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
				 cuentaIngresos.setTipo("GASTO");
				 cuentaIngresosDao.agregarTransaccion(cuentaIngresos);
				 
			}
		 
		 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO) && (egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_OTROS_PRESTAMO) || egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE))){
			 prestamo.setCodPrestamo(prestamosDao.buscarUltimoNumeroPrestamo());
			 prestamo.setStatus('A');
			 prestamo.setNroSocio(factura.getNroSocio());
			 prestamo.setFechaEmision(new Date(System.currentTimeMillis()));
			 prestamo.setDescripcion(egreso.getDescripcion());
			 prestamo.setMonto(Float.valueOf(montoString) * -1);
			 prestamosDao.agregarPrestamos(prestamo);
			 
			 cuentaPrestamos = new CuentaPrestamos();
			 cuentaPrestamos.setPrestamo(prestamo);
			 cuentaPrestamos.setDescripTransac(egreso.getDescripcion());
			 cuentaPrestamos.setFecha(new Date(System.currentTimeMillis()));
			 cuentaPrestamos.setMontoTransaccion(Float.valueOf(montoString) * -1);
			 cuentaPrestamos.setFactura(factura);
			 cuentaPrestamos.setStatus("A");
			 cuentaPrestamos.setNro_cuenta(cuentaPrestamosDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
			 cuentaPrestamosDao.agregarTransaccion(cuentaPrestamos);

			 
		 }

	 }
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
	 }	

	return factura.getNroFactura();
	
}

public String guardarFacturaIngreso(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal,List<String> listaFormaPago){
	
	 String valorMensaje="";
	 Factura factura = new Factura();
	 String montoString ="";
	 String clasificacion="";
	 String codigoPrestamo="";
	 try {

		 
		 factura.setMontoTotal(Float.valueOf(montoTotal));
		 factura.setFechaEmision(new Date(System.currentTimeMillis()));
		 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
			 factura.setNroSocio(socioDao.buscarPorNroSocio(campoId));	 
		 }
		 else if(tipoFacturado.equalsIgnoreCase(Inquilino.TIPO_FACTURADO_INQUILINO)){
			 factura.setInquilino(inquilinoDao.buscarPorRif(campoId));
		 }
		 else if(tipoFacturado.equalsIgnoreCase(Arrendatario.TIPO_FACTURADO_ARRENDATARIO)){
			 factura.setArrendatario(arrendatarioDao.buscarPorCedulaArrendatario(cedula));
		 }
		 
		 factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
		 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
		 facturaDao.agregarFactura(factura);

	 
		 Set<DetalleFactura> listaDetalleFactura = new HashSet<DetalleFactura>();

		 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
		 {

			 DetalleFactura detalleFactura = new DetalleFactura();
			 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
			 detalleFactura.setCodFactura(factura);
		 
			 Ingresos ingreso = new Ingresos();
			 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
			 {

				if (a==0){
					ingreso.setCodIngreso(lista.getValueAt(i ,a).toString());
				}
				else if(a==1){
					ingreso.setDescripcion(lista.getValueAt(i ,a).toString());
				}
				else if(a==2){
					montoString = new String();
					montoString = (String)lista.getValueAt(i ,a);						
				}
				else if(a==3){
					clasificacion = lista.getValueAt(i ,a).toString();
				}
				else if(a==4){
					if(null!=lista.getValueAt(i ,a)){
						codigoPrestamo = lista.getValueAt(i ,a).toString();
					}
					
				}
				detalleFactura.setIngreso(ingreso);
				
			 }

			 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
			 
//			 for (Iterator iterator = listaFormaPago.iterator(); iterator.hasNext();) {
//				String formaPagoDesc = (String) iterator.next();
//				FormaPago formaPago = new FormaPago();
//				
//				formaPago = formaPagoDao.buscarPorDescripcion(formaPagoDesc);
//				
//			}
			 
			 if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_ALQUILER)){
				 CuentaAlquiler cuentaAlquiler = new CuentaAlquiler();
				 cuentaAlquiler.setFactura(factura);
				 cuentaAlquiler.setDescripTransac(ingreso.getDescripcion());
				 cuentaAlquiler.setFecha(new Date(System.currentTimeMillis()));
				 cuentaAlquiler.setMontoTransaccion(Float.valueOf(montoString));
				 cuentaAlquiler.setStatus("A");
				 cuentaAlquiler.setNro_cuenta(cuentaAlquilerDao.buscarUltimoNumeroTramsaccionCuentaAlquiler());
				 cuentaAlquilerDao.agregarTransaccion(cuentaAlquiler);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_FONDO_DE_CHOQUE) || clasificacion.equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE)){
				 CuentaFondoChoque cuentaFondoChoque = new CuentaFondoChoque();
				 cuentaFondoChoque.setFactura(factura);
				 cuentaFondoChoque.setDescripTransac(ingreso.getDescripcion());
				 cuentaFondoChoque.setFecha(new Date(System.currentTimeMillis()));
				 cuentaFondoChoque.setMontoTransaccion(Float.valueOf(montoString));
				 cuentaFondoChoque.setStatus("A");	
				 cuentaFondoChoque.setNro_cuenta(cuentaFondoChoqueDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
				 cuentaFondoChoqueDao.agregarTransaccion(cuentaFondoChoque);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_RUTA)){
				
				 CuentaIngresos cuentaIngresos= new CuentaIngresos();
				 cuentaIngresos.setFactura(factura);
				 cuentaIngresos.setDescripTransac(ingreso.getDescripcion());
				 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
				 cuentaIngresos.setMontoTransaccion(Float.valueOf(montoString));
				 cuentaIngresos.setStatus("A");	
				 cuentaIngresos.setNro_cuenta(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
				 cuentaIngresos.setTipo("GASTO");
				 cuentaIngresosDao.agregarTransaccion(cuentaIngresos);
				 
			}
		 
		 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO) && (ingreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_OTROS_PRESTAMO) || ingreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE))){
//			 prestamo.setCodPrestamo(prestamosDao.buscarUltimoNumeroPrestamo());
//			 prestamo.setStatus('A');
//			 prestamo.setNroSocio(factura.getNroSocio());
//			 prestamo.setFechaEmision(new Date(System.currentTimeMillis()));
//			 prestamo.setDescripcion(ingreso.getDescripcion());
//			 prestamo.setMonto(Float.valueOf(montoString));
//			 prestamosDao.agregarPrestamos(prestamo);
			 
			 cuentaPrestamos = new CuentaPrestamos();
			 cuentaPrestamos.setPrestamo(prestamosDao.buscarPorCodigoPrestamo(codigoPrestamo));
			 cuentaPrestamos.setDescripTransac(ingreso.getDescripcion());
			 cuentaPrestamos.setFecha(new Date(System.currentTimeMillis()));
			 cuentaPrestamos.setMontoTransaccion(Float.valueOf(montoString));
			 cuentaPrestamos.setFactura(factura);
			 cuentaPrestamos.setStatus("A");
			 cuentaPrestamos.setNro_cuenta(cuentaPrestamosDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
			 cuentaPrestamosDao.agregarTransaccion(cuentaPrestamos);

			 
		 }

	 }
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
	 }	

	return factura.getNroFactura();
	
}

//public String guardarFacturaIngreso(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal){
//	
//	
//	 String valorMensaje="";
//	 Factura factura = new Factura();
//	 factura.setMontoTotal(Float.valueOf(montoTotal));
//	 factura.setFechaEmision(new Date(System.currentTimeMillis()));
//	 factura.setNroSocio(socioDao.buscarPorNroSocio(campoId));
//	
//	 try {
//		factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
//	 } catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	 }
//	 
//	 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
//	 
//	 try {
//		 facturaDao.agregarFactura(factura);
//	 } catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		valorMensaje="Se ha producido un Error al Guardar Factura";
//	 }
//	 
//	 Set<DetalleFactura> listaDetalleFactura = new HashSet<DetalleFactura>();
//
//	 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
//	 {
//		 DetalleFactura detalleFactura = new DetalleFactura();
//		 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
//		 detalleFactura.setCodFactura(factura);
//		 
//		 Ingresos ingreso = new Ingresos();
//		 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
//		 {
//
//			if (a==0){
//				ingreso.setCodIngreso(lista.getValueAt(i ,a).toString());
//			}
//			else if(a==1){
//				ingreso.setDescripcion(lista.getValueAt(i ,a).toString());
//			}
//			detalleFactura.setIngreso(ingreso);
//			
//		 }
//
//	
//		 try {
//			 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
//		 } catch (Exception e) {
//			 // TODO Auto-generated catch block
//			 e.printStackTrace();
//			 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
//		 }
//	 }
//
//	return factura.getNroFactura();
//	
//}


public List<String> consultarIngresoEnPrestamo(String codSocio, String descripcion){
	
	List<String> lista = prestamosDao.buscarPorSocioYDescripcion(codSocio, descripcion);

	return lista;
	
}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!Character.isDigit(e.getKeyChar()))
			e.consume();
	}
}
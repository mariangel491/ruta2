package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.common.collect.LinkedListModel;

import Modelos.Arrendatario;
import Modelos.CuentaAlquiler;
import Modelos.CuentaFondoChoque;
import Modelos.CuentaIngresos;
import Modelos.CuentaPrestamos;
import Modelos.DetalleFactura;
import Modelos.Egresos;
import Modelos.Factura;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Socio;
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
import Vistas.VistaFac;



public class ControladorFac implements ActionListener, KeyListener{
	
	private VistaFac vFactura = new VistaFac();
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
	
	private List<String> listaPrestamosIngresos = new ArrayList<String>();
	LinkedListModel<String> listaModeloAux=new LinkedListModel<>();
	
	
	public ControladorFac(){
		vFactura = new VistaFac();
		vFactura= VistaFac.obtenerInstancia();
		vFactura.setLocationRelativeTo(null);
		vFactura.setVisible(true);
		vFactura.agregarListener(this);
		vFactura.agregarKey(this);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getActionCommand().equalsIgnoreCase("Añadir")){
			this.AgregarElemento();
			
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Procesar")){
			
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			//vFactura.mensajeAlerta(mensaje);
			
		
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Quitar")){
			this.Quitar();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Salir")){
			
			vFactura.cerrarVentana();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			
				this.BuscarSocioPorNro();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedula")){
			try {
				BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
					
		
	}
	
	
	public void mouseClicked(MouseEvent evt) {
		//TODO add your code for jListIngresos.mouseClicked
//	
		System.out.println("si se hace");
		if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
			if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
				listaPrestamosIngresos = consultarIngresoEnPrestamo(vFactura.getTxtNroSocio(), vFactura.getjListIngresos().getSelectedValue().toString());	
				if(null!= listaPrestamosIngresos){
					listaModeloAux=new LinkedListModel<>();
					for (Iterator iterator = listaPrestamosIngresos.iterator(); iterator.hasNext();) {
						String prestamos = (String)iterator.next();
						listaModeloAux.add(prestamos);
					}
					
					vFactura.getjListPrestamosPendientes().setModel(listaModeloAux);
				}
						
			}
		}
	}
	
	public void llenartxtmonto(Ingresos ing){
		vFactura.setTxtMontoIngresoEgreso(String.valueOf(ing.getMonto()));
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (!Character.isDigit(arg0.getKeyChar()))
			arg0.consume();
		
	}
	
	
	
	
	public void BuscarSocioCed() throws Exception{
		
		Socio socio =null;
		Inquilino inquilino =null;
		Arrendatario arrendatario=null;
		if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_SOCIO)){
			try {
				socio = socioDao.buscarPorCedula(vFactura.getTxtCed().trim());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vFactura.llenarCamposSocio(socio);
		}
		else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_INQUILINO)){
			inquilino = inquilinoDao.buscarPorCedula(vFactura.getTxtCed().trim());
			vFactura.llenarCamposInquilino(inquilino);
		}
		else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_ARRENDATARIO)){
			arrendatario = arrendatarioDao.buscarPorCedulaArrendatario(vFactura.getTxtCed().trim());
			vFactura.llenarCamposArrendatario(arrendatario);
		}
		
	}
		
	
	public void Quitar() {
		// TODO Auto-generated method stub
		vFactura.removerElementoTablaIngresoXFactura();
		vFactura.sumarMontoTablaIngresoXFactura();
		
	}
	
	
	public void BuscarSocioPorNro(){
		
		Socio socio =null;
		Inquilino inquilino =null;
		if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_SOCIO)){
			try {
				socio = socioDao.buscarPorNroSocio(vFactura.getTxtNroSocio().trim());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vFactura.llenarCamposSocio(socio);
		}
		else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_INQUILINO)){
			inquilino = inquilinoDao.buscarPorRif(vFactura.getTxtNroSocio().trim());
			vFactura.llenarCamposInquilino(inquilino);
		}
	}

	public void AgregarElemento() {
		Double monto = 0.0;
		
	
		if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_INGRESOS)){
				if(!vFactura.getTxtMontoIngresoEgreso().equals(0.0)){
							
			if(!vFactura.getjListPrestamosPendientes().isSelectionEmpty()){
				vFactura.getjTableIngresosXFactura().setModel(this.agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(),monto,vFactura.getjListPrestamosPendientes().getSelectedValue()));
			}
			else{
				vFactura.getjTableIngresosXFactura().setModel(agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(),monto,null));
			}
			vFactura.getjTableIngresosXFactura().getModel();
			vFactura.getjListIngresos().clearSelection();
			vFactura.setTxtMontoIngresoEgreso("");
			vFactura.sumarMontoTablaIngresoXFactura();	/////REVISAR SI LO TRAIGO AL CONTROLADOR/////
			}
				
		}
		else {
			if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_EGRESOS)){
				if(null == vFactura.getTxtMontoIngresoEgreso() || "".equals(vFactura.getTxtMontoIngresoEgreso()))
					
					JOptionPane.showMessageDialog(null, "Debe seleccionar un Monto", "Atención!", JOptionPane.ERROR_MESSAGE);
				
				else{
								monto = Double.parseDouble(vFactura.getTxtMontoIngresoEgreso());
								
					if(!vFactura.getjListPrestamosPendientes().isSelectionEmpty()){
						vFactura.getjTableIngresosXFactura().setModel(this.agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(), monto,vFactura.getjListPrestamosPendientes().getSelectedValue()));
						}
						else{
							vFactura.getjTableIngresosXFactura().setModel(agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(), monto,null));
							}
						vFactura.getjTableIngresosXFactura().getModel();
						vFactura.getjListIngresos().clearSelection();
						vFactura.setTxtMontoIngresoEgreso("");
						vFactura.sumarMontoTablaIngresoXFactura();	/////REVISAR SI LO TRAIGO AL CONTROLADOR/////
					}
				  }
		}
}
	
	
	public DefaultTableModel agregarIngresoEgresoATabla(Object[] objetosSeleccionados, String tipoFactura, JTable jTableIngresosXFactura, Double montoEgreso,Object objetoPrestamoPendiente){
		
		DefaultTableModel modeloDeLaTabla=(DefaultTableModel)jTableIngresosXFactura.getModel();
		Ingresos ingreso; 
		Egresos egreso; 
		for (int i = 0; i < objetosSeleccionados.length; i++) {

			if(tipoFactura.equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS))
			{
				ingreso  = new Ingresos();
				float ccs=0;
				try {
					ingreso = ingDao.obtenerIngresosPorDescripcion((String)objetosSeleccionados[i]);
					ccs = ingreso.getMonto();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				System.out.println(ccs);
				System.out.println(String.valueOf(ccs)+"aqui");
				if(ccs!=0)
				{
					System.out.println(ccs+"por el if");

					///	vFactura.setTxtMontoIngresoEgreso(String.valueOf(ccs));
			
				
					Object[] datosDeLaFila = {ingreso.getCodIngreso(),ingreso.getDescripcion(),ingreso.getMonto()/*montoEgreso.toString()*/, ingreso.getClasifIngreso(),(String)objetoPrestamoPendiente};
					modeloDeLaTabla.addRow(datosDeLaFila);
				}else
				{
				
							System.out.println(ccs+"por el else");
							if(null == vFactura.getTxtMontoIngresoEgreso() || "".equals(vFactura.getTxtMontoIngresoEgreso()))
								
								JOptionPane.showMessageDialog(null, "Debe seleccionar un Monto", "Atención!", JOptionPane.ERROR_MESSAGE);
			
							else 
					{
						montoEgreso= Double.parseDouble(vFactura.getTxtMontoIngresoEgreso());
						System.out.println(montoEgreso);
						Object[] datosDeLaFila = {ingreso.getCodIngreso(),ingreso.getDescripcion(),montoEgreso.toString(), ingreso.getClasifIngreso(),(String)objetoPrestamoPendiente};
						 modeloDeLaTabla.addRow(datosDeLaFila);
					}
				}
			}
			else if(tipoFactura.equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_EGRESOS)){
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

public void ProcesarFac() {
	// TODO Auto-generated method stub
	if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
		
		List<String> listaFormaPago = new ArrayList<String>();
		
		/*if(jRadioButtonEfectivo.isSelected()){
			listaFormaPago.add(jRadioButtonEfectivo.getText());
		}
		else if(jRadioButtonCheque.isSelected()){
			listaFormaPago.add(jRadioButtonCheque.getText());
		}
		else if(jRadioButtonTransfe.isSelected()){
			listaFormaPago.add(jRadioButtonTransfe.getText());
		}
		else if(jRadioButtonDeposito.isSelected()){
			listaFormaPago.add(jRadioButtonDeposito.getText());
		}
		else if(jRadioButtonSubsidio.isSelected()){
			listaFormaPago.add(jRadioButtonSubsidio.getText());
		}*/

		String mensaje = guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal(),listaFormaPago);
	//	txtNroFactura.setText(mensaje);
		JOptionPane.showMessageDialog(null,"Se ha generado su Factura con exito. Numero de Factura: "+mensaje);
		
	}
	else if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_EGRESOS)){
		String mensaje = guardarFacturaEgreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
		//txtNroFactura.setText(mensaje);
		JOptionPane.showMessageDialog(null,"Se ha generado su Factura con exito. Numero de Factura: "+mensaje);
	}
	vFactura.limpiarTodo();
	//getDatos();
	
}


public List<String> consultarIngresoEnPrestamo(String codSocio, String descripcion){
	
	List<String> lista = prestamosDao.buscarPorSocioYDescripcion(codSocio, descripcion);

	return lista;
	
}

	
}

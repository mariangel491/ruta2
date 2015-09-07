package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.common.collect.LinkedListModel;
import com.lowagie.text.ListItem;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.CuentaAlquiler;
import Modelos.CuentaFondoChoque;
import Modelos.CuentaIngresos;
import Modelos.CuentaPrestamos;
import Modelos.DetalleFactura;
import Modelos.Egresos;
import Modelos.Factura;
import Modelos.FacturaxFormaPago;
import Modelos.FormaPago;
import Modelos.IEDetalleFactura;
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
import Modelos.Hibernate.Daos.FacturaxFormaPagoDao;
import Modelos.Hibernate.Daos.FormaPagoDao;
import Modelos.Hibernate.Daos.IngEgrDetalleFactDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.PrestamosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaFac;



public class ControladorFacturaResp implements ActionListener, KeyListener, FocusListener{
	
	private VistaFac vFactura = new VistaFac();
	
	//DAOS
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
	private CuentaPrestamosDao cuentaPrestamosDao = new CuentaPrestamosDao();
	private FormaPagoDao formaPagoDao = new FormaPagoDao();
	private FacturaxFormaPagoDao factFPDao= new FacturaxFormaPagoDao();
	private IngEgrDetalleFactDao IEFDao= new IngEgrDetalleFactDao();
	
	//MODELOS
	private CuentaPrestamos cuentaPrestamos = new CuentaPrestamos();
	private FacturaxFormaPago factFP= new FacturaxFormaPago();
	private IEDetalleFactura ieDetFac= new IEDetalleFactura();
	
	
	//LISTAS
	private List<String> listaPrestamosIngresos = new ArrayList<String>();
	LinkedListModel<String> listaModeloAux=new LinkedListModel<>();
	private Set<FormaPago> formasPagoSeleccionadas= new LinkedHashSet<>();
	private Set<Ingresos> ingresosFactura= new LinkedHashSet<Ingresos>();
	private Set<Egresos> egresosFactura= new LinkedHashSet<Egresos>();

	
	
	 List<FormaPago> list= new ArrayList<>();
	
	private float totalFP=0, montDep=0, montoEf=0, montoTrasnf=0, montoSub=0, montoCheque=0;
	
	
	public ControladorFacturaResp() {
		// TODO Auto-generated constructor stub

		vFactura = new VistaFac();
		vFactura= VistaFac.obtenerInstancia();
		vFactura.setLocationRelativeTo(null);
		vFactura.setVisible(true);
		vFactura.agregarListener(this);
		vFactura.agregarKey(this);
		vFactura.agregarFocusListener(this);
		vFactura.OcultarCamposFormaPago();
	}
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getActionCommand().equalsIgnoreCase("Añadir")){
			this.AgregarElemento();
			
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Procesar")){
			
			this.Procesar();
			//this.guardarFacturaEgreso(vFactura.getCmbTipoFacturado(), vFactura.getTxtNroSocio(), vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
			//this.guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), vFactura.getTxtCed(),vFactura.getjTableIngresosXFactura(),vFactura.getTxtMontoTotal());
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			this.CalcularTotalFormaPago();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Quitar")){
			this.Quitar();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Salir")){
			
			vFactura.cerrarVentana();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
				try {
					this.BuscarSocioPorNro();
					//vFactura.BuscarSubsidio(vFactura.getTxtNroSocio());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedula")){
			try {
				BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(ae.getActionCommand().equalsIgnoreCase("total")){
			System.out.println("totaaaal");
			this.CalcularTotalFormaPago();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckEfectivo")){
			vFactura.CheckEfectivo();
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheck")){
			vFactura.OcultarCheckEfectivo();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckSubsidio")){
			vFactura.CheckSubsidio();
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckSubsidio")){
			vFactura.OcultarCheckSubsidio();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckTransferencia")){
			vFactura.CheckTransferencia();
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckTransferencia")){
			vFactura.OcultarCheckTransferencia();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckDeposito")){
			vFactura.CheckDeposito();
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckDeposito")){
			vFactura.OcultarCheckDeposito();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckSubsidio")){
			vFactura.CheckSubsidio();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckSubsidio")){
			vFactura.OcultarCheckSubsidio();
		}else if(ae.getActionCommand().equalsIgnoreCase("CheckCheque")){
			vFactura.CheckCheque();
		}else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckCheque")){
			vFactura.OcultarCheckCheque();
		}
					
		
	}
	
	
	public void mouseClicked(MouseEvent evt) {
		//TODO add your code for jListIngresos.mouseClicked
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
		System.out.println("cantidad "+ vFactura.getJSpinnerCantidad().getValue());
	
		if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_INGRESOS)){
				if(!vFactura.getTxtMontoIngresoEgreso().equals(0.0)){
							
			if(!vFactura.getjListPrestamosPendientes().isSelectionEmpty()){
				vFactura.getjTableIngresosXFactura().setModel(this.agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), 
															vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(),monto, 
															Integer.valueOf(String.valueOf(vFactura.getJSpinnerCantidad().getValue())),
															vFactura.getjListPrestamosPendientes().getSelectedValue()));
			}
			else{
				vFactura.getjTableIngresosXFactura().setModel(agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), 
															vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(),monto,
															Integer.valueOf(String.valueOf(vFactura.getJSpinnerCantidad().getValue())),null));
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
						vFactura.getjTableIngresosXFactura().setModel(this.agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(), monto,0,vFactura.getjListPrestamosPendientes().getSelectedValue()));
						}
						else{
							vFactura.getjTableIngresosXFactura().setModel(agregarIngresoEgresoATabla(vFactura.getjListIngresos().getSelectedValues(), vFactura.getCmbTipoFactu(), vFactura.getjTableIngresosXFactura(), monto,null,0));
							}
						vFactura.getjTableIngresosXFactura().getModel();
						vFactura.getjListIngresos().clearSelection();
						vFactura.setTxtMontoIngresoEgreso("");
						vFactura.sumarMontoTablaIngresoXFactura();	/////REVISAR SI LO TRAIGO AL CONTROLADOR/////
					}
				  }
		}
}
	
	
	public DefaultTableModel agregarIngresoEgresoATabla(Object[] objetosSeleccionados, String tipoFactura, JTable jTableIngresosXFactura,
														Double montoEgreso, Integer cant,Object objetoPrestamoPendiente){
		
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
				
					if(ccs!=0)
					{
						Object[] datosDeLaFila = {ingreso.getCodIngreso(),ingreso.getDescripcion(),ingreso.getMonto()/*montoEgreso.toString()*/,
								ingreso.getClasifIngreso(), cant.toString(),(String)objetoPrestamoPendiente};
						modeloDeLaTabla.addRow(datosDeLaFila);
					}else
					{
								if(null == vFactura.getTxtMontoIngresoEgreso() || "".equals(vFactura.getTxtMontoIngresoEgreso()))
									
									JOptionPane.showMessageDialog(null, "Debe seleccionar un Monto", "Atención!", JOptionPane.ERROR_MESSAGE);
				
								else 
						{
							montoEgreso= Double.parseDouble(vFactura.getTxtMontoIngresoEgreso());
							Object[] datosDeLaFila = {ingreso.getCodIngreso(),ingreso.getDescripcion(),montoEgreso.toString(), 
														ingreso.getClasifIngreso(), cant.toString(),(String)objetoPrestamoPendiente};
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
	
	public FormaPago BuscarDescripFP(String descrip) throws Exception{
		if(formaPagoDao.encontrarNombre(descrip)!=false)
			return formaPagoDao.buscarPoDescrip(descrip);
		return null;
	}
	
	
	public String GenerarCodigoFacxFP () throws Exception{
		return "FFP"+factFPDao.obtenerTodos().size();
	}

	public void GuardarFormaPagoFactura() throws Exception{
	formasPagoSeleccionadas=new HashSet<>();
	if(vFactura.getCheckCheque().isSelected()==true)
	{
		formasPagoSeleccionadas.add(this.BuscarDescripFP("Cheque"));
		montoCheque= Float.parseFloat(vFactura.getTxtCheque().getText());
	}
	if(vFactura.getCheckDeposito().isSelected()==true){
		formasPagoSeleccionadas.add(BuscarDescripFP("Deposito"));
		montDep= Float.parseFloat(vFactura.getTxtDepositoo().getText());
	}
	if(vFactura.getCheckEfectivo().isSelected()==true){
		formasPagoSeleccionadas.add(BuscarDescripFP("Efectivo"));
		montoEf = Float.parseFloat(vFactura.getTxtEfectivoo().getText());
		
	}
	if(vFactura.getCheckSubsidio().isSelected()==true){
		formasPagoSeleccionadas.add(BuscarDescripFP("Subsidio"));
		montoSub=Float.parseFloat(vFactura.getTxtSubsidios().getText());
	}
	if(vFactura.getCheckTransferencia().isSelected()==true){
		formasPagoSeleccionadas.add(BuscarDescripFP("Transferencia"));
		montoTrasnf=Float.parseFloat(vFactura.getTxtTransferencias().getText());
	}	

}

public void ComprobarTotales(Double montoTotal, Double montoFP){
	if(montoFP<montoTotal)
		JOptionPane.showMessageDialog(null,"El monto es insuficiente","Atencion!",
				JOptionPane.INFORMATION_MESSAGE);
}
	
public String guardarFacturaEgreso(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal){
	
	 String valorMensaje="";
	 Factura factura = new Factura();
	 String clasificacion="";
	 Float montoDouble = (float) 0;
	 	
	 try {
		 this.GuardarFormaPagoFactura();		 
		 
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
		// factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
		 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());	
		 
		 if(formasPagoSeleccionadas.size()==0)
			 JOptionPane.showMessageDialog(null,"Debe seleccionar al menos una formaPago","Atencion!",
						JOptionPane.INFORMATION_MESSAGE);
			 
		 facturaDao.agregarFactura(factura);
		 
		//Para guardar la forma de pago.
		 String nom="";
		 Object[] array = formasPagoSeleccionadas.toArray();
					
		 for (int i=0; i< array.length;i++){
			 	factFP= new FacturaxFormaPago();
				FormaPago fp=(FormaPago) array[i];
				factFP.setFormaPago(fp);
				factFP.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
				factFP.setFecha(new Date());
				factFP.setId(this.GenerarCodigoFacxFP());
				
				nom= formaPagoDao.buscarPorCodForma(fp.getCodForma()).getNombre();
								
			   if(nom.equals("Cheque"))
					 factFP.setMonto(montoCheque);
				 if(nom.equals("Deposito"))
					factFP.setMonto(montDep);
				 if(nom.equals("Efectivo"))
					 factFP.setMonto(montoEf);
				 if(nom.equals("Subsidio"))	
					factFP.setMonto(montoSub);
				 if(nom.equals("Transferencia"))
					 factFP.setMonto(montoTrasnf);
			
				 factFPDao.agregarFormaPago(factFP);
		 }
					
		List<Float> monto= new ArrayList<>();
		 Egresos egreso = new Egresos();
		  monto= new ArrayList<Float>();
		  
		 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
		 {
			 Egresos eg=new Egresos();
			 
			 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
			 {
				if (a==0){
					eg.setCodEgreso(lista.getValueAt(i ,a).toString());
				}
				else if(a==1){
					eg.setDescripcion(lista.getValueAt(i ,a).toString());
				}
				else if(a==2){
					montoDouble = (float) 0;
					montoDouble = Float.valueOf((String) lista.getValueAt(i ,a));	
				}
				else if(a==3){
					clasificacion = lista.getValueAt(i ,a).toString();
				}
				
				egresosFactura.add(eg);
				monto.add(i, montoDouble);			
			 } 
		 }	 
		 
		 Prestamos prestamo = new Prestamos();
		 
		 //PARA AGREGAR EL DETALLE
		 DetalleFactura detalleFactura = new DetalleFactura();
		 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
		 detalleFactura.setCodFactura(factura);
		 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
		 
		 //PARA LOS EGRESOS Y SUS MONTOS
		 Object[] arrayEgresos= egresosFactura.toArray();
		 Egresos otroEgre= new Egresos();
		 Float alquiler=(float) 0, fc=(float) 0,ruta=(float) 0;
		 for (int i=0; i< arrayEgresos.length;i++)
		 {
			
			 ieDetFac= new IEDetalleFactura();
			 Egresos eg = (Egresos) arrayEgresos[i];
			
			   ieDetFac.setIddetalle(IEFDao.buscarUltimoNumeroDetalleFactura());
			   ieDetFac.setDf(detalleFacturaDao.buscarPorCodDetalle(detalleFactura.getCoddetalle()));
			   ieDetFac.setCantidad(0);
			   otroEgre=egDao.obtenerEgresos(eg.getCodEgreso());
			   ieDetFac.setEg(egDao.obtenerEgresos(eg.getCodEgreso()));
			   ieDetFac.setMonto(monto.get(i));
			 
			 IEFDao.agregarDetalle(ieDetFac);
			 clasificacion= otroEgre.getClasificacion();
			 if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_ALQUILER))
			 {
				 alquiler+=monto.get(i);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_FONDO_DE_CHOQUE))
			 {
				 fc+= monto.get(i);
			 }
			 else if(clasificacion.equalsIgnoreCase(Egresos.CLASIFICACION_EGRESO_RUTA))
			  {
				 ruta+=monto.get(i);
			  }
			 
		 
		 }//Fin del for
		 System.out.println("alq "+alquiler+"fc "+ fc+ " ruta "+ ruta);
		
			if(alquiler!=0)
			{
				 CuentaAlquiler cuentaAlquiler = new CuentaAlquiler();
				 cuentaAlquiler.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
				// cuentaAlquiler.setDescripTransac(egreso.getDescripcion());
				 cuentaAlquiler.setDescripTransac("Alquiler");
				 cuentaAlquiler.setFecha(new Date(System.currentTimeMillis()));
				 cuentaAlquiler.setMontoTransaccion(Float.valueOf(alquiler) * -1);
				 cuentaAlquiler.setStatus("A");
				 cuentaAlquiler.setNro_cuenta(cuentaAlquilerDao.buscarUltimoNumeroTramsaccionCuentaAlquiler());
				 cuentaAlquilerDao.agregarTransaccion(cuentaAlquiler);
			 }
			if(fc!=0)
			  {
				 CuentaFondoChoque cuentaFondoChoque = new CuentaFondoChoque();
				 cuentaFondoChoque.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
				 //cuentaFondoChoque.setDescripTransac(egreso.getDescripcion());
				 cuentaFondoChoque.setDescripTransac("Fondo de Choque");
				 cuentaFondoChoque.setFecha(new Date(System.currentTimeMillis()));
				 cuentaFondoChoque.setMontoTransaccion(Float.valueOf(fc) * -1);
				 cuentaFondoChoque.setStatus("A");	
				 cuentaFondoChoque.setNro_cuenta(cuentaFondoChoqueDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
				 cuentaFondoChoqueDao.agregarTransaccion(cuentaFondoChoque);
			 }
			if(ruta!=0)
			   {
				   CuentaIngresos cuentaIngresos= new CuentaIngresos();
				 cuentaIngresos.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
				 //cuentaIngresos.setDescripTransac(egreso.getDescripcion());
				 cuentaIngresos.setDescripTransac("Ruta");
				 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
				 cuentaIngresos.setMontoTransaccion(Float.valueOf(ruta) * -1);
				 cuentaIngresos.setStatus("A");	
				 cuentaIngresos.setNro_transaccion(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
				 cuentaIngresos.setTipo("GASTO");
				 cuentaIngresosDao.agregarTransaccion(cuentaIngresos); 
			   }
		 
			  
			 /* if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO) && (egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_OTROS_PRESTAMO) || egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE))){
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

			 
		 }*/

	 
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
	 }	

	return factura.getNroFactura();
	
	
}


public String guardarFacturaIngreso(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal){
	
	 String valorMensaje="";
	 Factura factura = new Factura();
	// String montoString ="";
	 String clasificacion="";
	 String codigoPrestamo="";
	 Float montoIng = (float) 0;
	 Integer cant = 0;
	 try {

		 this.GuardarFormaPagoFactura();
		
		 
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
		 
		// factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
		 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
		 facturaDao.agregarFactura(factura);
		 
		 ////////////////////////////////////////MetodoFormaPago///////////////////////////
		 String nom="";
		 Object[] array = formasPagoSeleccionadas.toArray();
		 System.out.println("tamaño   "+ array.length);
			
		 for (int i=0; i< array.length;i++){
			 	factFP= new FacturaxFormaPago();
				FormaPago fp=(FormaPago) array[i];
				factFP.setFormaPago(fp);
				factFP.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
				factFP.setFecha(new Date());
				factFP.setId(this.GenerarCodigoFacxFP());
				
				nom= formaPagoDao.buscarPorCodForma(fp.getCodForma()).getNombre();
				
				System.out.println("fp  "+nom);
				
				System.out.println(nom.equals("Cheque"));
				
			   if(nom.equals("Cheque"))
					 factFP.setMonto(montoCheque);
				 if(nom.equals("Deposito"))
					factFP.setMonto(montDep);
				 if(nom.equals("Efectivo"))
					 factFP.setMonto(montoEf);
				 if(nom.equals("Subsidio"))	
					factFP.setMonto(montoSub);
				 if(nom.equals("Transferencia"))
					 factFP.setMonto(montoTrasnf);
			
				 factFPDao.agregarFormaPago(factFP);
		 }

	 
			List<Float> monto= new ArrayList<>();
			 Ingresos ingreso = new Ingresos();
			  List<Integer> cantidad= new ArrayList<Integer>();
			  
			 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
			 {
				 Ingresos in = new Ingresos();
				 
				 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
				 {
					if (a==0){
						in.setCodIngreso((lista.getValueAt(i ,a).toString()));
					}
					else if(a==1){
						in.setDescripcion(lista.getValueAt(i ,a).toString());
					}
					else if(a==2){
						montoIng = (float) 0;
						montoIng = (Float) lista.getValueAt(i ,a);	
					}
					else if(a==3){
						clasificacion = lista.getValueAt(i ,a).toString();
					}else if(a==4){
						
						cant= Integer.valueOf(lista.getValueAt(i ,a).toString());
					}
					
					ingresosFactura.add(in);
					monto.add(i, montoIng);	
					cantidad.add(i, cant);
				 } 
			 }	 
			 
			 Prestamos prestamo = new Prestamos();
			 
			 //PARA AGREGAR EL DETALLE
			 DetalleFactura detalleFactura = new DetalleFactura();
			 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
			 detalleFactura.setCodFactura(factura);
			 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
			 
			 //PARA LOS EGRESOS Y SUS MONTOS
			 Object[] arrayIngresos= ingresosFactura.toArray();
			 Float alquiler=(float) 0, fc=(float) 0,ruta=(float) 0;
			 
			 
			 for (int i=0; i< arrayIngresos.length;i++)
			 {
				 ieDetFac= new IEDetalleFactura();
				 Ingresos ing = (Ingresos) arrayIngresos[i];
				
				   ieDetFac.setIddetalle(IEFDao.buscarUltimoNumeroDetalleFactura());
				   ieDetFac.setDf(detalleFacturaDao.buscarPorCodDetalle(detalleFactura.getCoddetalle()));
				   ieDetFac.setCantidad(cantidad.get(i));
				   ieDetFac.setIng(ingDao.obtenerIngresos(ing.getCodIngreso()));
				   ieDetFac.setMonto(monto.get(i));
				 
				 IEFDao.agregarDetalle(ieDetFac);
				 
				 clasificacion= ing.getClasifIngreso();
				 System.out.println("clasif" + clasificacion+ " "+Ingresos.TIPO_INGRESO_ALQUILER);
				 if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_ALQUILER))
				 {
					 alquiler+=monto.get(i);
				 }
				 else if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_FONDO_DE_CHOQUE))
				 {
					 fc+= monto.get(i);
				 }
				 else if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_RUTA))
				 {
					 ruta+=monto.get(i);
				 }
			 }
			 		 
			 if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_ALQUILER))
			 {
				 CuentaAlquiler cuentaAlquiler = new CuentaAlquiler();
				 cuentaAlquiler.setFactura(factura);
				 cuentaAlquiler.setDescripTransac(ingreso.getDescripcion());
				 cuentaAlquiler.setFecha(new Date(System.currentTimeMillis()));
				 cuentaAlquiler.setMontoTransaccion(Float.valueOf(alquiler));
				 cuentaAlquiler.setStatus("A");
				 cuentaAlquiler.setNro_cuenta(cuentaAlquilerDao.buscarUltimoNumeroTramsaccionCuentaAlquiler());
				 cuentaAlquilerDao.agregarTransaccion(cuentaAlquiler);
			 }
			 else if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_FONDO_DE_CHOQUE) 
					 || clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_FONDO_DE_CHOQUE))
			 {
				 CuentaFondoChoque cuentaFondoChoque = new CuentaFondoChoque();
				 cuentaFondoChoque.setFactura(factura);
				 cuentaFondoChoque.setDescripTransac(ingreso.getDescripcion());
				 cuentaFondoChoque.setFecha(new Date(System.currentTimeMillis()));
				 cuentaFondoChoque.setMontoTransaccion(Float.valueOf(fc));
				 cuentaFondoChoque.setStatus("A");	
				 cuentaFondoChoque.setNro_cuenta(cuentaFondoChoqueDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
				 cuentaFondoChoqueDao.agregarTransaccion(cuentaFondoChoque);
			 }
			 else if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_RUTA))
			 {
				 CuentaIngresos cuentaIngresos= new CuentaIngresos();
				 cuentaIngresos.setFactura(factura);
				 cuentaIngresos.setDescripTransac(ingreso.getDescripcion());
				 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
				 cuentaIngresos.setMontoTransaccion(Float.valueOf(ruta));
				// cuentaIngresos.setMontoTransaccion(Float.valueOf(montoString));
				 cuentaIngresos.setStatus("A");	
				 cuentaIngresos.setNro_transaccion(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
				 cuentaIngresos.setTipo("GASTO");
				 cuentaIngresosDao.agregarTransaccion(cuentaIngresos);
				 
			}
		 
		 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO) && 
				 (ingreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_OTROS_PRESTAMO) 
						 || ingreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE))){
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
			// cuentaPrestamos.setMontoTransaccion(Float.valueOf(montoString));
			 cuentaPrestamos.setFactura(factura);
			 cuentaPrestamos.setStatus("A");
			 cuentaPrestamos.setNro_transaccion(cuentaPrestamosDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
			 cuentaPrestamosDao.agregarTransaccion(cuentaPrestamos);

			 
		 }
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
	 }	

	return factura.getNroFactura();
	
}


public void Procesar() {
	
	if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
		
		//this.guardarFacturaEgreso(vFactura.getCmbTipoFacturado(), vFactura.getTxtNroSocio(), vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
		this.guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), 
		vFactura.getTxtCed(),vFactura.getjTableIngresosXFactura(),vFactura.getTxtMontoTotal());
		
	}
	else
		if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_EGRESOS)){
			
			this.guardarFacturaEgreso(vFactura.getCmbTipoFacturado(), vFactura.getTxtNroSocio(), 
			vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
			//this.guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), vFactura.getTxtCed(),vFactura.getjTableIngresosXFactura(),vFactura.getTxtMontoTotal());
		}
		
	vFactura.limpiarTodo();
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

		//String mensaje = guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal(),listaFormaPago);
	//	txtNroFactura.setText(mensaje);
	//	JOptionPane.showMessageDialog(null,"Se ha generado su Factura con exito. Numero de Factura: "+mensaje);
		
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

public void mensajeError(){
	JOptionPane.showMessageDialog(null,"Debe llenar campo monto, para cada forma de pago seleccionada","Atencion!",
			JOptionPane.INFORMATION_MESSAGE);
}

public void CalcularTotalFormaPago(){
		totalFP=0;
		if(vFactura.getCheckEfectivo().isSelected()==true)
		{
			if("".equals(vFactura.getTxtEfectivoo().getText()) || null == vFactura.getTxtEfectivoo().getText())
			{
				this.mensajeError();
			}
			else if(vFactura.getTxtEfectivoo().getText()!=null)
			{
				totalFP= totalFP+Float.parseFloat(vFactura.getTxtEfectivoo().getText());
				vFactura.setTxtTotal(String.valueOf(totalFP));
			}
		}
		
		if(vFactura.getCheckCheque().isSelected()==true)
		{
			if("".equals(vFactura.getTxtCheque().getText()) || null == vFactura.getTxtCheque().getText())
			{
				this.mensajeError();
			}
			else if(vFactura.getTxtCheque().getText()!=null)
			{
				totalFP= totalFP+Float.parseFloat(vFactura.getTxtCheque().getText());
				vFactura.setTxtTotal(String.valueOf(totalFP));
			}
		}
		
		if(vFactura.getCheckDeposito().isSelected()==true)
		{
			if("".equals(vFactura.getTxtDepositoo().getText()) || null == vFactura.getTxtDepositoo().getText())
			{
				this.mensajeError();
			}
			else if(vFactura.getTxtDepositoo().getText()!=null)
			{
				totalFP= totalFP+Float.parseFloat(vFactura.getTxtDepositoo().getText());
				vFactura.setTxtTotal(String.valueOf(totalFP));
			}
		}
		
		if(vFactura.getCheckSubsidio().isSelected()==true)
		{
			if("".equals(vFactura.getTxtSubsidios().getText()) || null == vFactura.getTxtSubsidios().getText())
			{
				this.mensajeError();
			}
			else if(vFactura.getTxtSubsidios().getText()!=null)
			{
				this.comprobarSubsidio();
				totalFP= totalFP+Float.parseFloat(vFactura.getTxtSubsidios().getText());
				vFactura.setTxtTotal(String.valueOf(totalFP));
			}
		}
		
		if(vFactura.getCheckTransferencia().isSelected()==true)
		{
			if("".equals(vFactura.getTxtTransferencias().getText()) || null == vFactura.getTxtTransferencias().getText())
			{
				this.mensajeError();
			}
			else if(vFactura.getTxtTransferencias().getText()!=null)
			{
				totalFP= totalFP+Float.parseFloat(vFactura.getTxtTransferencias().getText());
				vFactura.setTxtTotal(String.valueOf(totalFP));
			}
		}
		
		
	}



	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		this.CalcularTotalFormaPago();
		//this.comprobarSubsidio();
	}
	
	//PARA COMPROBAR EL TOTAL DISPONIBLE DEL SOCIO, CON EL INGRESADO
	public void comprobarSubsidio(){
		float totalSubsidio=Float.parseFloat(vFactura.getTxtMontoDispo().getText());
		  if(totalSubsidio!=0.0)
		  {
			  if(!"".equals(vFactura.getTxtSubsidios().getText()) || null != vFactura.getTxtSubsidios().getText()){
				  if(Float.parseFloat(vFactura.getTxtSubsidios().getText())>totalSubsidio)
				  {
					  JOptionPane.showMessageDialog(null,"Monto Insuficiente","Atencion!",
								JOptionPane.INFORMATION_MESSAGE);
					  vFactura.getTxtSubsidios().setText("0");
				  }
			  }
		  }
	}
	


	
}


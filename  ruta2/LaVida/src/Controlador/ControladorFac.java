package Controlador;

import java.awt.HeadlessException;
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

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.common.collect.LinkedListModel;
import com.lowagie.text.ListItem;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.Caja;
import Modelos.CuentaAlquiler;
import Modelos.CuentaFondoChoque;
import Modelos.CuentaGeneral;
import Modelos.CuentaIngresos;
import Modelos.CuentaPrestamos;
import Modelos.DetalleFactura;
import Modelos.Deuda;
import Modelos.DeudaAlquiler;
import Modelos.Egresos;
import Modelos.Factura;
import Modelos.FacturaxFormaPago;
import Modelos.FormaPago;
import Modelos.IEDetalleFactura;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Ruta;
import Modelos.Socio;
import Modelos.Subsidio;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.CajaDao;
import Modelos.Hibernate.Daos.CuentaAlquilerDao;
import Modelos.Hibernate.Daos.CuentaFondoChoqueDao;
import Modelos.Hibernate.Daos.CuentaIngresosDao;
import Modelos.Hibernate.Daos.CuentaPrestamosDao;
import Modelos.Hibernate.Daos.DetalleFacturaDao;
import Modelos.Hibernate.Daos.DeudaAlquilerDao;
import Modelos.Hibernate.Daos.DeudaDao;
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
import Modelos.Hibernate.Daos.SubsidioDao;
import Vistas.VistaFac;



public class ControladorFac implements ActionListener, KeyListener, FocusListener{
	
	
	
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
	//private CuentaGeneralDao cuentaGralDao= new CuentaGeneral();
	private FormaPagoDao formaPagoDao = new FormaPagoDao();
	private FacturaxFormaPagoDao factFPDao= new FacturaxFormaPagoDao();
	private IngEgrDetalleFactDao IEFDao= new IngEgrDetalleFactDao();
	private SubsidioDao subDao= new SubsidioDao();
	private PrestamosDao prestDao= new PrestamosDao();
	private DeudaDao deudaDao= new DeudaDao();
	private CajaDao cajaDao= new CajaDao();
	private DeudaAlquilerDao deudaAlqDao= new DeudaAlquilerDao();
	
	//MODELOS
	private CuentaPrestamos cuentaPrestamos = new CuentaPrestamos();
	private CuentaIngresos cuentaIngresos= new CuentaIngresos();
	private FacturaxFormaPago factFP= new FacturaxFormaPago();
	private IEDetalleFactura ieDetFac= new IEDetalleFactura();
	private Caja caja= new Caja();
	
	
	//LISTAS
	private List<String> listaPrestamosIngresos = new ArrayList<String>();
	LinkedListModel<String> listaModeloAux=new LinkedListModel<>();
	private Set<FormaPago> formasPagoSeleccionadas= new LinkedHashSet<>();
	private Set<Ingresos> ingresosFactura= new LinkedHashSet<Ingresos>();
	private Set<Prestamos> prestamosFactura= new LinkedHashSet<Prestamos>();
	private Set<Egresos> egresosFactura= new LinkedHashSet<Egresos>();
	private Set<Deuda> deudasFactura=new LinkedHashSet<Deuda>();
	private List<Prestamos> listPrestamosXSocio= new ArrayList<Prestamos>();
	private List<Deuda> listDeudasXSocio= new ArrayList<Deuda>();
	private List<DeudaAlquiler> listDeudasXInquilino= new ArrayList<DeudaAlquiler>();
	
	
	 List<FormaPago> list= new ArrayList<>();
	
	private float totalFP=0, montDep=0, montoEf=0, montoTrasnf=0, montoSub=0, montoCheque=0, montoDeuda=0;
	private String nroTrasnf= "",nroCheque="", nroDeposito="";

	
	
	public ControladorFac(){
		vFactura = new VistaFac();
		vFactura= VistaFac.obtenerInstancia();
		vFactura.setLocationRelativeTo(null);
		vFactura.setVisible(true);
		vFactura.agregarListener(this);
		vFactura.agregarKey(this);
		vFactura.agregarFocusListener(this);
		vFactura.OcultarCamposFormaPago();
		vFactura.ocultarTablas();
		vFactura.setTxtNroFactura(facturaDao.buscarUltimoNumeroFactura());
		vFactura.BloquearCamposBusq();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getActionCommand().equalsIgnoreCase("Añadir"))
		{
			this.agregarElemento();
			vFactura.limpiarCantSplit();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Procesar"))
		{
			this.Procesar();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Limpiar"))
		{
			vFactura.limpiarTodo();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Quitar"))
		{
			this.Quitar();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Salir"))
		{
			vFactura.cerrarVentana();	
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Buscar"))
		{
			vFactura.limpiarTablaDeudas();
				try {
					this.BuscarSocioPorNro();
					this.BuscarSubsidio(vFactura.getTxtNroSocio());
					this.BuscarPrestamos(vFactura.getTxtNroSocio());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
		else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedula"))
		{
			try {
				BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getActionCommand().equalsIgnoreCase("total"))
		{
			this.CalcularTotalFormaPago();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("CheckEfectivo"))
		{
			vFactura.CheckEfectivo();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheck"))
		{
			vFactura.OcultarCheckEfectivo();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("CheckSubsidio"))
		{
			vFactura.CheckSubsidio();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("OcultarCheckSubsidio"))
		{
			vFactura.OcultarCheckSubsidio();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("CheckTransferencia")){
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
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedSocTeclado")){
			try {
				BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarXNroSocio")){
			
			
				vFactura.limpiarTablaDeudas();
				try {
					this.BuscarSocioPorNro();
					this.BuscarSubsidio(vFactura.getTxtNroSocio());
					this.BuscarPrestamos(vFactura.getTxtNroSocio());
					//this.BuscarDeudas();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}else if(ae.getActionCommand().equalsIgnoreCase("annadirDeuda")){
			this.agregarElemento();
		}else if(ae.getActionCommand().equalsIgnoreCase("AnnadirPrestamos")){
			
			if(null == vFactura.getTxtNroSocio() || "".equals(vFactura.getTxtNroSocio()))
			{
				JOptionPane.showMessageDialog(null, "Ingrese número de socio", "Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				ControladorPrestamo controP= new ControladorPrestamo(vFactura);
			}
		}else if(ae.getActionCommand().equalsIgnoreCase("MontoDeudaP")){
			if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_PRESTAMOS))
				this.CalcularDeudaRestante();
			else
			{
				this.agregarElemento();
			}
		}
					
		
	}
	
	
	public void mouseClicked(MouseEvent evt) {
		//TODO add your code for jListIngresos.mouseClicked
		if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
			if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
				//listaPrestamosIngresos = consultarIngresoEnPrestamo(vFactura.getTxtNroSocio(), vFactura.getjListIngresos().getSelectedValue().toString());	
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
				this.BuscarDeudas();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vFactura.llenarCamposSocio(socio);
		}
		else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_INQUILINO))
		{
				if(vFactura.getTxtCed().trim()!=null)
				{
					if(inquilinoDao.encontrarInquilinoCedula(vFactura.getTxtCed().trim())==true)
					{
						inquilino = inquilinoDao.buscarPorCedula(vFactura.getTxtCed().trim());	
						
						this.BuscarDeudasAlquiler(inquilino.getCodInquilino());
						vFactura.llenarCamposInquilino(inquilino);			
					}	
					else
						JOptionPane.showMessageDialog(null,"No se encontró resultado","Atención",
								JOptionPane.INFORMATION_MESSAGE);
				}			
			
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
	
	
	public void BuscarSocioPorNro() {
		
		Socio socio =null;
		Inquilino inquilino =null;
		if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_SOCIO)){
			try {
				if(vFactura.getTxtNroSocio()!=null)
					socio = socioDao.buscarPorNroSocio(vFactura.getTxtNroSocio().trim());
					this.BuscarDeudas();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vFactura.llenarCamposSocio(socio);
		}
		else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_INQUILINO))
		{
			try {
				if(inquilinoDao.encontrarInquilinoRif(vFactura.getTxtNroSocio().trim())==true)
				{
					inquilino = inquilinoDao.buscarPorRif(vFactura.getTxtNroSocio());
					this.BuscarDeudasAlquiler(inquilino.getCodInquilino());
					vFactura.llenarCamposInquilino(inquilino);
				}	
				else
					JOptionPane.showMessageDialog(null,"No se encontró resultado","Atención",
							JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	//PARA AÑADIR UN ELEMENTO DE DEUDA A LA INFORMACION DE LA FACTURA
public void agregarElemento()
{		
	if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_INGRESOS))
		{
			Ingresos ing= new Ingresos();
			Prestamos p = new Prestamos();
			Deuda d= new Deuda();
			DeudaAlquiler da= new DeudaAlquiler();
			
			try 
			{	
				if(vFactura.getjListIngresos().getSelectedIndex()>0)//PARA SABER SI UN ELEMNTO DEL JLIST FUE SELECCIONADO
				{
					ing= ingDao.obtenerIngresosPorDescripcion(vFactura.getjListIngresos().getSelectedValue().toString());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			//VERIFICANDO QUE SEA UNA DEUDA LO QUE SE DESEA A;ADIR A LA INF. DE LA FACTURA.
			if(null == vFactura.getTxtMontoIngresoEgreso() || "".equals(vFactura.getTxtMontoIngresoEgreso())){
				if(vFactura.getJTableDeudasPorSocio().getSelectionModel().getLeadSelectionIndex()>=0)
				{
					if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_SOCIO))
					{	
						d=this.AnnadirDeudas();
						vFactura.agregarFilaIngresos(d.getCodigo(), d.getDescripcion(), String.valueOf(d.getMonto()), "Ingresos", "0");	
						d=null;
						vFactura.getJTableDeudasPorSocio().getSelectionModel().setLeadSelectionIndex(-1);	
					}
					else if(vFactura.getCmbTipoFacturado().equalsIgnoreCase(vFactura.TIPO_FACTURADO_INQUILINO))
					{
						da=this.AnnadirDeudasAlquiler();
						vFactura.agregarFilaIngresos(da.getCodigo(), da.getDescripcion(), String.valueOf(da.getMonto()), "Ingresos", "0");	
						da=null;
						vFactura.getJTableDeudasPorSocio().getSelectionModel().setLeadSelectionIndex(-1);
					}
				}else
					JOptionPane.showMessageDialog(null,"Debe llenar el campo monto","Atención", JOptionPane.INFORMATION_MESSAGE);
			}
			else	
			{
				if(vFactura.getjListIngresos().getSelectedIndex()>0)
				{
					vFactura.agregarFilaIngresos(ing.getCodIngreso(), ing.getDescripcion(), vFactura.getTxtMontoIngresoEgreso(), 
							ing.getClasifIngreso(), vFactura.getJSpinnerCantidad().getValue().toString());
				}else
				{
					vFactura.agregarFilaIngresos(p.getCodPrestamo(), p.getDescripcion(),
												vFactura.getTxtMontoIngresoEgreso(), "Prestamo", "0");
				}
			}
				
		}//FIN DEL IF TIPO INGRESOS
		else if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_EGRESOS))
		{
				Egresos egre= new Egresos();
				try {
					if(vFactura.getjListIngresos().getSelectedIndex()>0)
						egre = egDao.obtenerEgresosPorDescripcion(vFactura.getjListIngresos().getSelectedValue().toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					if(null == vFactura.getTxtMontoIngresoEgreso() || "".equals(vFactura.getTxtMontoIngresoEgreso()))
						JOptionPane.showMessageDialog(null, "Debe llenar el campo monto", "Atención!", JOptionPane.ERROR_MESSAGE);
					else
							vFactura.agregarFilaEgresos(egre.getCodEgreso(), egre.getDescripcion(),
									vFactura.getTxtMontoIngresoEgreso(), egre.getClasificacion());			
				
		}else if(vFactura.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_PRESTAMOS)){
			 Prestamos p= new Prestamos();
			 if(vFactura.getjTablePrestamosXFactura().getSelectionModel().getLeadSelectionIndex()>=0){
				 p= this.AnnadirPrestamos();
				 if(Float.parseFloat(vFactura.getTxtMontoIngresoEgreso())>0)
				 {
					 vFactura.agregarFilaPrestIng(p.getCodPrestamo(), p.getDescripcion(),vFactura.getTxtMontoIngresoEgreso());
					 vFactura.setTxtMontoAdeudado("");
				 }else 
					 JOptionPane.showMessageDialog(null, "El monto debe ser mayor que cero", "Atención!", JOptionPane.ERROR_MESSAGE);
			 }		 
		}
		
	//LIMPIAR LOS CAMPOS UNA VEZ GUARDADA LA FACTURA
		vFactura.getjListIngresos().clearSelection();
		vFactura.getjTablePrestamosXFactura().clearSelection();
		vFactura.getJTableDeudasPorSocio().clearSelection();
		vFactura.setTxtMontoIngresoEgreso("");
		vFactura.sumarMontoTablaIngresoXFactura();
		vFactura.DesbCampos();
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

//PARA COMPROBAR QUE EL TOTAL DE LA FACTURA NO SEA MENOR AL ESTIMADO
public boolean comprobarMonto(){
	float montoFP= Float.parseFloat(vFactura.getTxtTotal2().getText());
	float montoLista=Float.parseFloat(vFactura.getTxtMontoTotal());
	if(montoFP<montoLista){
		JOptionPane.showMessageDialog(null,"Monto a pagar Insuficiente","Atencion!",
				JOptionPane.INFORMATION_MESSAGE);
		return true;}
	else 
		return false;
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
	
	public String GenerarCodigoFacxFP () throws Exception{
		return "FFP"+factFPDao.obtenerTodos().size();
	}
	
	public FormaPago BuscarDescripFP(String descrip) throws Exception{
		if(formaPagoDao.encontrarNombre(descrip)!=false)
			return formaPagoDao.buscarPoDescrip(descrip);
		return null;
	}
	
	public void GuardarFormaPagoFactura() throws Exception{
		formasPagoSeleccionadas=new HashSet<>();
		if(vFactura.getCheckCheque().isSelected()==true)
		{
			formasPagoSeleccionadas.add(this.BuscarDescripFP("Cheque"));
			montoCheque= Float.parseFloat(vFactura.getTxtCheque().getText());
			nroCheque= vFactura.getTxtNroCheqe().getText();
		}
		if(vFactura.getCheckDeposito().isSelected()==true){
			formasPagoSeleccionadas.add(BuscarDescripFP("Deposito"));
			montDep= Float.parseFloat(vFactura.getTxtDepositoo().getText());
			nroDeposito= vFactura.getTxtNroDep().getText();
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
			nroTrasnf= vFactura.getTxtNroTransferencias().getText();
		}	
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
				 if(inquilinoDao.buscarPorRif(campoId)!=null)
					 factura.setInquilino(inquilinoDao.buscarPorRif(campoId));
				 else
					 factura.setInquilino(inquilinoDao.buscarPorCedula(campoId));
				 
			 }
			 else if(tipoFacturado.equalsIgnoreCase(Arrendatario.TIPO_FACTURADO_ARRENDATARIO))
			 {
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
									
				   if(nom.equals("Cheque")){
					   factFP.setMonto(montoCheque);
					   factFP.setNroFP(nroCheque);
				   } 
					 if(nom.equals("Deposito")){
						 factFP.setMonto(montDep);
						 	factFP.setNroFP(nroDeposito);
					 }
					 if(nom.equals("Efectivo"))
						 factFP.setMonto(montoEf);
					 
					 if(nom.equals("Subsidio"))	
						factFP.setMonto(montoSub);
					
					 if(nom.equals("Transferencia")){
						 factFP.setMonto(montoTrasnf);
						 factFP.setNroFP(nroTrasnf);
					 }
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
			 
				  
				 /* if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO) && (egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_OTROS_PRESTAMO) 
				  * || egreso.getDescripcion().equalsIgnoreCase(Egresos.TIPO_EGRESO_PRESTAMO_FONDO_DE_CHOQUE))){
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
		 facturaDao= new FacturaDao();
		
		// String montoString ="";
		 String clasificacion="";
		 String codigoPrestamo="";
		 Float montoIng = (float) 0;
		 Float montoPrest= (float) 0;
		 Integer cant = 0;
		 try {

			 this.GuardarFormaPagoFactura();
			
			 factura.setMontoTotal(Float.valueOf(montoTotal));
			 factura.setFechaEmision(new Date(System.currentTimeMillis()));
			 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
				 factura.setNroSocio(socioDao.buscarPorNroSocio(campoId));	 
			 }
			 else if(tipoFacturado.equalsIgnoreCase(Inquilino.TIPO_FACTURADO_INQUILINO)){
				 if(inquilinoDao.buscarPorRif(campoId)==null)
					 factura.setInquilino(inquilinoDao.buscarPorCedula(campoId));
				 else
					 factura.setInquilino(inquilinoDao.buscarPorRif(campoId));
			 }
			 else if(tipoFacturado.equalsIgnoreCase(Arrendatario.TIPO_FACTURADO_ARRENDATARIO)){
				
				 factura.setArrendatario(arrendatarioDao.buscarCedula(campoId));
			 }
			 
			 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
			
			 facturaDao.agregarFactura(factura);
			 
			 ////////////////////////////////////////MetodoFormaPago///////////////////////////
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
					
				   if(nom.equals("Cheque")){
					   factFP.setMonto(montoCheque);
					   factFP.setNroFP(nroCheque);
				   }
						 
					 if(nom.equals("Deposito")){
						 factFP.setMonto(montDep);
						 factFP.setNroFP(nroDeposito);
					 }
						
					 if(nom.equals("Efectivo")){
						 factFP.setMonto(montoEf);
						 caja.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
						 caja.setFecha(new Date(System.currentTimeMillis()));
						 caja.setMontoTransaccion(montoEf);
						 caja.setNro_cuenta(cajaDao.buscarUltimoNumeroTramsaccionCaja());
						 caja.setStatus("ND");
						 cajaDao.agregarTransaccion(caja);
					 }
						
					 if(nom.equals("Subsidio"))	
						factFP.setMonto(montoSub);
					 if(nom.equals("Transferencia")){
						 factFP.setMonto(montoTrasnf);
						 factFP.setNroFP(nroTrasnf);
					 }
						 
				
					 factFPDao.agregarFormaPago(factFP);
			 }

		 
				List<Float> monto= new ArrayList<>();
				List<Float> montoPrestamos= new ArrayList<Float>();
				//List<Float>montoDeudas=new ArrayList<Float>();
				
				Ingresos ingreso = new Ingresos();
				List<Integer> cantidad= new ArrayList<Integer>();
				String tipo="";
				
				 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
				 {
					 Ingresos in = new Ingresos();
					 Prestamos prest= new Prestamos();
					// String tipo="";
					 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
					 {
						if (a==0){
							if(lista.getValueAt(i, a).toString().charAt(0)=='I')
							{
								tipo="I";
								in.setCodIngreso((lista.getValueAt(i ,a).toString()));	
							}
							else if(lista.getValueAt(i, a).toString().charAt(0)=='P')
							{
								tipo="P";
								System.out.println("codigo prestamos  "+lista.getValueAt(i, a).toString());
								prest=prestDao.buscarPorCodigoPrestamo(lista.getValueAt(i, a).toString());
								prestamosFactura.add(prest);							
							
								
							}else if(lista.getValueAt(i, a).toString().charAt(0)=='D'){
								tipo="D";
								deudasFactura.add(deudaDao.buscarPorCodDeuda(lista.getValueAt(i, a).toString()));
							}
						}
						else if(a==1){
							if(tipo=="I")
								in.setDescripcion(lista.getValueAt(i ,a).toString());
						}
						else if(a==2){
							if(tipo=="I"){
								montoIng = (float) 0;
								montoIng = Float.valueOf(lista.getValueAt(i ,a).toString());	
							}
							if(tipo=="P"){
								montoPrest= (float) 0;
								montoPrest= Float.valueOf(lista.getValueAt(i ,a).toString());
							}
							
						}
						else if(a==3){
							if(tipo=="I")
								clasificacion = lista.getValueAt(i ,a).toString();
						}else if(a==4){
							if(tipo=="I")
								cant= Integer.valueOf(lista.getValueAt(i ,a).toString());
						}
	
					} 
					 
					 if(tipo=="I"){
						
							ingresosFactura.add(in);
							monto.add(ingresosFactura.size()-1, montoIng);	
							cantidad.add(ingresosFactura.size()-1, cant);
					}else if(tipo=="P")
							{
								montoPrestamos.add(prestamosFactura.size()-1,montoPrest);
							}
				 }	 
				 
				// Prestamos prestamo = new Prestamos();
				 
				 //PARA AGREGAR EL DETALLE
				 DetalleFactura detalleFactura = new DetalleFactura();
				 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
				 detalleFactura.setCodFactura(factura);
				 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
				 
				 //PARA LOS EGRESOS Y SUS MONTOS
				 Object[] arrayIngresos= ingresosFactura.toArray();
				 Float alquiler=(float) 0, fc=(float) 0,ruta=(float) 0;
				String tipoIng="";
				 if(arrayIngresos.length>0){
				 for (int i=0; i< arrayIngresos.length;i++)
				 {
					 ieDetFac= new IEDetalleFactura();
					 Ingresos ing = (Ingresos) arrayIngresos[i];
					 tipoIng= ing.getCodIngreso();
					 
					   ieDetFac.setIddetalle(IEFDao.buscarUltimoNumeroDetalleFactura());
					   ieDetFac.setDf(detalleFacturaDao.buscarPorCodDetalle(detalleFactura.getCoddetalle()));
					   ieDetFac.setCantidad(cantidad.get(i));
					   ieDetFac.setIng(ingDao.obtenerIngresos(ing.getCodIngreso()));
					   ieDetFac.setMonto(monto.get(i));
					
					 IEFDao.agregarDetalle(ieDetFac);
					 
					 clasificacion=ingDao.obtenerIngresos(ing.getCodIngreso()).getClasifIngreso();
					
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
				 }
				 
				 Object[] arrayPrestamos= prestamosFactura.toArray();
				 if(arrayPrestamos.length>0){
				 for (int i=0; i< arrayPrestamos.length;i++)
				 {
					 ieDetFac= new IEDetalleFactura();
					// Prestamos p= (Prestamos) arrayPrestamos[i];
					 					
					   ieDetFac.setIddetalle(IEFDao.buscarUltimoNumeroDetalleFactura());
					   ieDetFac.setDf(detalleFacturaDao.buscarPorCodDetalle(detalleFactura.getCoddetalle()));
					   ieDetFac.setCantidad(1);
					   ieDetFac.setIng(ingDao.buscarPorCodIngreso("I0014"));
					   ieDetFac.setMonto(montoPrestamos.get(i));
					
					 IEFDao.agregarDetalle(ieDetFac);
				 	}
				 }
			
				 if(prestamosFactura.size()>0){
				 	
					for(int i=0; i<arrayPrestamos.length; i++){
						 Prestamos pres= (Prestamos) arrayPrestamos[i];
						 cuentaPrestamos = new CuentaPrestamos();
						 cuentaPrestamos.setPrestamo(prestamosDao.buscarPorCodigoPrestamo(pres.getCodPrestamo()));
						 cuentaPrestamos.setDescripTransac(pres.getDescripcion());
						 cuentaPrestamos.setFecha(new Date(System.currentTimeMillis()));
						 cuentaPrestamos.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
						 cuentaPrestamos.setStatus("A");
						 cuentaPrestamos.setMontoTransaccion(montoPrestamos.get(i));
						 cuentaPrestamos.setNro_transaccion(cuentaPrestamosDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
						 cuentaPrestamosDao.agregarTransaccion(cuentaPrestamos);
						
					}
				}
				 
				 
				 if(deudasFactura.size()>0){
					 Object[] arrayDeudas= deudasFactura.toArray();
					 for(int i=0;i<arrayDeudas.length; i++){
						 Deuda deuda= (Deuda) arrayDeudas[i];
						 cuentaIngresos = new CuentaIngresos();
						 cuentaIngresos.setDescripTransac(deuda.getDescripcion());
						 cuentaIngresos.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
						 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
						 cuentaIngresos.setMontoTransaccion(deuda.getMonto());
						 cuentaIngresos.setNro_transaccion(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
						 cuentaIngresos.setStatus("C");
						 cuentaIngresos.setTipo("Ingresos");
						 
						 cuentaIngresosDao.agregarTransaccion(cuentaIngresos);
						 deuda.setStatus("C");
						 deudaDao.actualizarDeuda(deuda);
					 }
				 }
				 		 
				 if(clasificacion.equalsIgnoreCase(Ingresos.TIPO_INGRESO_ALQUILER))
				 {
					 CuentaAlquiler cuentaAlquiler = new CuentaAlquiler();
					 cuentaAlquiler.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
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
					 cuentaFondoChoque.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
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
					 cuentaIngresos.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
					 cuentaIngresos.setDescripTransac(ingreso.getDescripcion());
					 cuentaIngresos.setFecha(new Date(System.currentTimeMillis()));
					 cuentaIngresos.setMontoTransaccion(Float.valueOf(ruta));
					// cuentaIngresos.setMontoTransaccion(Float.valueOf(montoString));
					 cuentaIngresos.setStatus("A");	
					 cuentaIngresos.setNro_transaccion(cuentaIngresosDao.buscarUltimoNumeroTramsaccionCuentaIngresos());
					 cuentaIngresos.setTipo("GASTO");
					 cuentaIngresosDao.agregarTransaccion(cuentaIngresos);
					 
				}

		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 valorMensaje="Se ha producido un Error al Guardar Detalle de la Factura";
		 }	

		 vFactura.limpiarTodo();
		 prestamosFactura.removeAll(deudasFactura);
		 deudasFactura.removeAll(deudasFactura);
		 ingresosFactura.removeAll(ingresosFactura);
		 
		return factura.getNroFactura();
		
	}
	
	public String guardarFacturaPrestamo(String tipoFacturado, String campoId, String cedula, JTable lista, String montoTotal){
			
		 Factura factura = new Factura();
		// String montoString ="";
		 String clasificacion="";
		 Float montoIng = (float) 0;
		 Float montoPrest= (float) 0;
		 Integer cant = 0;
		 try {

			 this.GuardarFormaPagoFactura();
			
			 
			 factura.setMontoTotal(Float.valueOf(montoTotal));
			 factura.setFechaEmision(new Date(System.currentTimeMillis()));
			 if(tipoFacturado.equalsIgnoreCase(Socio.TIPO_FACTURADO_SOCIO)){
				 factura.setNroSocio(socioDao.buscarPorNroSocio(campoId));	 
			 }
			// factura.setCodRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
			 factura.setNroFactura(facturaDao.buscarUltimoNumeroFactura());		 
			
			 facturaDao.agregarFactura(factura);
			 
			 ////////////////////////////////////////MetodoFormaPago///////////////////////////
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
					 if(nom.equals("Efectivo")){
						 factFP.setMonto(montoEf);
						 caja.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
						 caja.setFecha(new Date(System.currentTimeMillis()));
						 caja.setMontoTransaccion(montoEf);
						 caja.setNro_cuenta(cajaDao.buscarUltimoNumeroTramsaccionCaja());
						 caja.setStatus("ND");
						 cajaDao.agregarTransaccion(caja);
					 }
						
					 if(nom.equals("Subsidio"))	
						factFP.setMonto(montoSub);
					 if(nom.equals("Transferencia"))
						 factFP.setMonto(montoTrasnf);
				
					 factFPDao.agregarFormaPago(factFP);
			 }
		 
			 List<Float> montoPrestamos= new ArrayList<Float>();
			/* if(vFactura.getListaPrestamos().size()<0)
			 {*/
				
				 for(int i=0; i<lista.getRowCount(); i++) //recorro las filas
				 {
					 Prestamos prest= new Prestamos();
					
					 for(int a=0; a<lista.getColumnCount(); a++) //recorro las columnas
					 {
						if (a==0){	
						 if(lista.getValueAt(i, a).toString().charAt(0)=='P')
							{
							 
							 	String cod= lista.getValueAt(i, a).toString();
							 	if (prestDao.encontrarPrestamo(cod)==true)
							 		prest=prestDao.buscarPorCodigoPrestamo(cod);
							 	else
							 	{
							 		prest.setCodPrestamo(lista.getValueAt(i, a).toString());
							 		prest.setDescripcion(lista.getValueAt(i, 1).toString());
							 		prest.setFechaEmision(new Date(System.currentTimeMillis()));
							 		prest.setMonto(Float.parseFloat(lista.getValueAt(i, 2).toString()));
							 		prest.setNroSocio(socioDao.buscarPorNroSocio(campoId));
							 		prest.setStatus('A');
							 		prestDao.agregarPrestamos(prest);
							 	}
								
								prestamosFactura.add(prest);
								
							}
						}
						if(a==2){
								montoPrest= (float) 0;
								montoPrest= Float.valueOf(lista.getValueAt(i ,a).toString());
								montoPrestamos.add(prestamosFactura.size()-1,montoPrest);
						}
					} 			
				 }				 
				 
				// Prestamos prestamo = new Prestamos();
				 
				 //PARA AGREGAR EL DETALLE
				 DetalleFactura detalleFactura = new DetalleFactura();
				 detalleFactura.setCoddetalle(detalleFacturaDao.buscarUltimoNumeroDetalleFactura());
				 detalleFactura.setCodFactura(factura);
				 detalleFacturaDao.agregarDetalleFactura(detalleFactura);
				 
				 //PARA LOS PRESTAMOS Y SUS MONTOS				 
				 Object[] arrayPrestamos= prestamosFactura.toArray();
				 if(arrayPrestamos.length>0){
				 for (int i=0; i< arrayPrestamos.length;i++)
				 {
					 ieDetFac= new IEDetalleFactura();					 					
					   ieDetFac.setIddetalle(IEFDao.buscarUltimoNumeroDetalleFactura());
					   ieDetFac.setDf(detalleFacturaDao.buscarPorCodDetalle(detalleFactura.getCoddetalle()));
					   ieDetFac.setCantidad(1);
					   ieDetFac.setIng(ingDao.buscarPorCodIngreso("I0014"));
					   ieDetFac.setMonto(montoPrestamos.get(i));
					
					 IEFDao.agregarDetalle(ieDetFac);
				 	}
				 }
				
				 if(prestamosFactura.size()>0){
					for(int i=0; i<arrayPrestamos.length; i++){
						 Prestamos pres= (Prestamos) arrayPrestamos[i];
				
						 cuentaPrestamos = new CuentaPrestamos();
						 cuentaPrestamos.setPrestamo(prestamosDao.buscarPorCodigoPrestamo(pres.getCodPrestamo()));
						 cuentaPrestamos.setDescripTransac(pres.getDescripcion());
						 cuentaPrestamos.setFecha(new Date(System.currentTimeMillis()));
						 cuentaPrestamos.setFactura(facturaDao.obtenerFactura(factura.getNroFactura()));
						 cuentaPrestamos.setStatus("A");
						 cuentaPrestamos.setMontoTransaccion(montoPrestamos.get(i));
						 cuentaPrestamos.setNro_transaccion(cuentaPrestamosDao.buscarUltimoNumeroTramsaccionCuentaFondoChoque());
						 cuentaPrestamosDao.agregarTransaccion(cuentaPrestamos);
						
					}
				}	

		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 String valorMensaje = "Se ha producido un Error al Guardar Detalle de la Factura";
		 }	

		 //vFactura.limpiarTodo();
		 prestamosFactura.removeAll(deudasFactura);
		 deudasFactura.removeAll(deudasFactura);
		 ingresosFactura.removeAll(ingresosFactura);
		 
		return factura.getNroFactura();
		
	}


	public void Procesar() {
		if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
			
			if(vFactura.getTxtNroSocio()==null || "".equals(vFactura.getTxtNroSocio())){
				this.guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtCed(), 
						vFactura.getTxtCed(),vFactura.getjTableIngresosXFactura(),vFactura.getTxtMontoTotal());
			}else{
				this.guardarFacturaIngreso(vFactura.getCmbTipoFacturado(),vFactura.getTxtNroSocio(), 
						vFactura.getTxtCed(),vFactura.getjTableIngresosXFactura(),vFactura.getTxtMontoTotal());
			}
			
		}
		else
			if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_EGRESOS)){
				
				this.guardarFacturaEgreso(vFactura.getCmbTipoFacturado(), vFactura.getTxtNroSocio(), 
				vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
				
			}
		else if(vFactura.getCmbTipoFactu().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_PRESTAMOS)){
			this.guardarFacturaPrestamo(vFactura.getCmbTipoFacturado(), vFactura.getTxtNroSocio(), 
				vFactura.getTxtCed(), vFactura.getjTableIngresosXFactura(), vFactura.getTxtMontoTotal());
		}
			
		vFactura.limpiarTodo();
	}
	
	
	public void BuscarSubsidio(String nroSocio) throws Exception{
		Double montoTotal=(double) 0;
		for(int i=0;i<subDao.obtenerTodos().size();i++)
		{
			Subsidio sub= new Subsidio();
			sub=subDao.obtenerTodos().get(i);
			if(sub.getSocio().getNroSocio().equals(nroSocio)){
				montoTotal= montoTotal+subDao.obtenerTodos().get(i).getMonto();
			}
		}
		vFactura.getTxtMontoDispo().setText(String.valueOf(montoTotal));
	
	}
	
	
	
	public void BuscarPrestamos(String nroSocio) throws Exception
	{
		List<CuentaPrestamos> listPrest= new ArrayList<CuentaPrestamos>();
		List<Prestamos> prestamos= new ArrayList<Prestamos>();
		Float monto=(float) 0;
		prestamos=prestamosDao.obtenerTodos();
		for(int i=0;i<prestamos.size();i++)
		{
			Prestamos otroPrest= prestamos.get(i);
			listPrest=cuentaPrestamosDao.MovimientosPrestamos(otroPrest.getCodPrestamo());
			monto=(float) 0;
			if(listPrest.size()>0)
			{	
				for(int j=0;j<listPrest.size();j++)
				{
					monto= monto+listPrest.get(j).getMontoTransaccion();	
				}
			}
			if(otroPrest.getNroSocio().getNroSocio().equals(nroSocio) && otroPrest.getStatus()=='A'){
				if(otroPrest.getMonto()-monto!=0)
				{
				listPrestamosXSocio.add(otroPrest);
				vFactura.agregarFilaPrestamos(otroPrest.getDescripcion(), Float.toString(otroPrest.getMonto()),
						Float.toString(otroPrest.getMonto()-monto));
				}
			}
		}
	}
	
	public void BuscarDeudas() throws Exception{
		
		List<Deuda> deudasSocio=deudaDao.obtenerDeudasActivasPorSocio(vFactura.getTxtNroSocio());
		System.out.println(deudasSocio.size()+" deudaaas cantidad");
		if(deudasSocio.size()>0)
		{
			for(int i=0;i<deudasSocio.size();i++){

				Deuda d= new Deuda();
				d=deudasSocio.get(i);
				listDeudasXSocio.add(d);
				vFactura.agregarFilaDeudas(d.getCodigo(),d.getDescripcion(),d.getFecha().toString() ,Float.toString(d.getMonto()));
			}
		}
	}
	
	public void BuscarDeudasAlquiler(String codigo) throws Exception{
		
		DeudaAlquiler d=new DeudaAlquiler();
		int contador=0;
		
		for(int i=0;i<deudaAlqDao.obtenerTodos().size();i++){
			if(deudaAlqDao.obtenerTodos().get(i).getInquilino().getCodinquilino().equals(codigo)){
				++contador;
				
				listDeudasXInquilino.add(deudaAlqDao.obtenerTodos().get(i));
				d=deudaAlqDao.obtenerTodos().get(i);
				
				vFactura.agregarFilaDeudas(d.getCodigo(),d.getDescripcion(),d.getFecha().toString() ,Float.toString(d.getMonto()));
			
			}
		}	
	}
	
	public DeudaAlquiler AnnadirDeudasAlquiler(){
		DeudaAlquiler d= new DeudaAlquiler();
		
		for(int i=0; i<listDeudasXInquilino.size();i++){
			if(listDeudasXInquilino.get(i).getCodigo().equals(vFactura.filaDeudaAlq()))
				d= listDeudasXInquilino.get(i);
			
		}
		return d;
	}
	
	public Prestamos AnnadirPrestamos(){
		Prestamos prestamo= new Prestamos();
		
		for(int i=0; i<listPrestamosXSocio.size();i++)
		{
			if(listPrestamosXSocio.get(i).getDescripcion().equals(vFactura.filaPrestamos()))
				prestamo=listPrestamosXSocio.get(i);
		}
		return prestamo;
		
	}
	
	public Deuda AnnadirDeudas(){
		Deuda d= new Deuda();
		for(int i=0; i<listDeudasXSocio.size();i++){
			if(listDeudasXSocio.get(i).getCodigo().equals(vFactura.filaDeuda()))
				d= listDeudasXSocio.get(i);
		}
		return d;
	}
	
	public void CalcularDeudaRestante(){
		
		if(null!= vFactura.getTxtMontoIngresoEgreso() && 
			 Float.parseFloat(vFactura.filaMontoDeuda()) >= Float.parseFloat(vFactura.getTxtMontoIngresoEgreso()))
		{
			montoDeuda=Float.parseFloat(vFactura.filaMontoDeuda());
			vFactura.setTxtMontoAdeudado(String.valueOf(montoDeuda-
										Float.parseFloat(vFactura.getTxtMontoIngresoEgreso())));
		}
		else
		{ 
			JOptionPane.showMessageDialog(null,"El monto abonado no debe ser superior a la deuda","Atencion!",
					JOptionPane.INFORMATION_MESSAGE);
			vFactura.setTxtMontoIngresoEgreso("");
		}
	}
	

	
}

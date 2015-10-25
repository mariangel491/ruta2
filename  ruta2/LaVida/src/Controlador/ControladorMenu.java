package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import Modelos.Avance;
import Modelos.Deuda;
import Modelos.DeudaAlquiler;
import Modelos.HistorialDeuda;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Local;
import Modelos.Socio;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.DeudaAlquilerDao;
import Modelos.Hibernate.Daos.DeudaDao;
import Modelos.Hibernate.Daos.HistorialDeudaDao;
import Modelos.Hibernate.Daos.HistorialDeudaDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.LocalDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.*;

public class ControladorMenu implements ActionListener{

	mnuPrincipal menu;
	
	menuAlquiler mnuAlquiler;
	
	//Controladores
	ControladorAlquiler alquiler;
	ControladorAvance avance;
	ControladorAvanceArrendatario avanceArrendatario;
	ControladorInquilino inquilino;
	ControladorPrestamo prestamo;
	ControladorRegistrarLocal local;
	ControladorSocio socio;
	//ControladorDeuda deuda;
	ControladorArrendatario arrendatario;
	ControladorVehiculo vehiculo;
	ControladorIngresos ingresos;
	ControladorEgresos egresos;
	ControladorBeneficiario beneficiario;
	ControladorCargarMontoIng cargarMontosIngresos;
	ControladorFac factura;
	ControladorSubsidio controladorSubsidio;
	ControladorDepositosCaja depositosCaja;
	VistaFac vFactura;
	private Connection con;
	
	//Para cargar las deudas de los socios y alquileres
	private DeudaDao deudaDao= new DeudaDao();
	private AvanceDao avanceDao= new AvanceDao();
	private IngresosDao ingDao= new IngresosDao();
	private SocioDao socioDao= new SocioDao();
	private HistorialDeudaDao historialD= new HistorialDeudaDao();
	
	private InquilinoDao inqDao= new InquilinoDao();
	private DeudaAlquilerDao deudaAlqDao= new DeudaAlquilerDao();
	
	private int mayorAnno=0, mayorMes=0;
	//PARA LOS REPORTES
	//ControladorReporte controReporSocio;
	
	public ControladorMenu() {
		super();
		// TODO Auto-generated constructor stub
		menu = new mnuPrincipal();
		menu.agregarListener(this);
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setTitle("Menu Principal");
		this.cargarDeudaTodosSocios();
		cargarDeudaAlquileres();
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDRuta2","postgres","postgres");
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equalsIgnoreCase("Subsidio"))
		{
			controladorSubsidio = new ControladorSubsidio();
		}else
		if (ae.getActionCommand().equalsIgnoreCase("Local"))
		{
		   local = new ControladorRegistrarLocal();
	    }
		else if (ae.getActionCommand().equalsIgnoreCase("Avance"))
	    {
			String resp= ae.getActionCommand();
			avance= new ControladorAvance(resp);
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Inquilino"))
	    {
		   
				try {
					inquilino= new ControladorInquilino();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		else  if (ae.getActionCommand().equalsIgnoreCase("Egresos"))
	    {
	        egresos= new ControladorEgresos();
		}
		else  if (ae.getActionCommand().equalsIgnoreCase("Arrendatario"))
	    {
	        arrendatario = new ControladorArrendatario();
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Avance Arrendatario"))
	    {
	        //VistaArrendatario vArrendatario = new VistaArrendatario();
			String resp= ae.getActionCommand();
			avanceArrendatario = new ControladorAvanceArrendatario();
	      
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Vehiculo Arrendatario"))
	    {
	        //VistaArrendatario vArrendatario = new VistaArrendatario();
			String resp= ae.getActionCommand();
			vehiculo = new ControladorVehiculo(resp);
	      
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Factura"))
	    {
	       factura = new ControladorFac();
		//	vFactura= new VistaFactura();
	      
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Alquiler"))
	    {
	        alquiler = new ControladorAlquiler();
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Socio"))
	    {
	        socio = new ControladorSocio();
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Vehiculo"))
	    {
			String resp= ae.getActionCommand();
	        vehiculo = new ControladorVehiculo(resp);
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Prestamo"))
	    {
	        prestamo = new ControladorPrestamo();
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Ingresos"))
		{
			ingresos = new ControladorIngresos();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("Beneficiario"))
		{
			beneficiario = new ControladorBeneficiario();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("CargarIngresos"))
		{
			cargarMontosIngresos= new ControladorCargarMontoIng();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("ReporteSocio"))
		{
		
			String ruta=new File("").getAbsolutePath() + "/src/Reportes/ReporteSocios.jrxml";
			try {
				JasperReport reporte = JasperCompileManager.compileReport(ruta);
				JasperPrint print = JasperFillManager.fillReport(reporte, null, con);
				JasperViewer.viewReport(print, false);
			} catch (JRException JRException){
				JOptionPane.showMessageDialog(null, "Error al crear el reporte", "Advertencia!", 0);
			}
		}
		else if(ae.getActionCommand().equalsIgnoreCase("CargarMontoSubsidio"))
		{
			controladorSubsidio = new ControladorSubsidio();
		}
		else if(ae.getActionCommand().equalsIgnoreCase("DepositoCaja"))
		{
			depositosCaja= new ControladorDepositosCaja();
		}
	}
   
	
	//**************METODOSSSS PARA CARGAR LAS DEUDAS DE LOS SOCIOSSSSSS************************
	
	public String GenerarCodigoDeuda(){
		
		int cantDeuda;
		try {
			cantDeuda = deudaDao.obtenerTodos().size()+1;
		
			if(cantDeuda<10)
			{
				return ("D000"+cantDeuda);			
			}else if(cantDeuda<100)
			{
				 return ("D00"+cantDeuda);
			}else if(cantDeuda<1000)
			{
				return("D0"+cantDeuda);
			}else{
				return("D"+cantDeuda);
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public void cargarDeudaTodosSocios(){
		try {
		Deuda deuda= new Deuda();
		Ingresos ing= new Ingresos();
		int cont=0;		
		int fin=socioDao.obtenerTodos().size();
		
		Date fechaHoy= new Date(System.currentTimeMillis());
		
		mayorAnno=historialD.obtenerTodos().get(0).getFechaSocio().getYear();
		mayorMes=historialD.obtenerTodos().get(0).getFechaSocio().getMonth();
		ing=ingDao.buscarPorCodIngreso("I0001");
		
		if(fechaHoy.getMonth()>this.mayorMes)
		{	
			if(fechaHoy.getYear()>=this.mayorAnno)
			{
				while(cont<fin){
					Socio socio=new Socio();
					socio=socioDao.obtenerTodos().get(cont);
										
						deuda.setFecha(fechaHoy);
						deuda.setMonto(ing.getMonto());
						deuda.setSocio(socio);
						deuda.setCodigo(this.GenerarCodigoDeuda());
						deuda.setDescripcion(ing.getDescripcion());
						deuda.setStatus("A");
						deuda.setIngreso(ing.getCodIngreso());
						
						deudaDao.agregarDeuda(deuda);		
					cont++;
				}this.DeudaConductorSoc();
			}		
		}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	
	public void DeudaConductorSoc(){
		Deuda deuda= new Deuda();
		Date f= new Date(System.currentTimeMillis());
		int contador=0;
		try {
			Ingresos ing=ingDao.buscarPorCodIngreso("I0002");
			List<Socio> listaSocios= new ArrayList<Socio>();
			List<Avance> listaAvance= new ArrayList<Avance>();
			listaSocios=socioDao.obtenerTodos();
			listaAvance= avanceDao.obtenerTodos();
			Socio socio= new Socio();
			for(int i=0; i<listaSocios.size();i++)
			{
				if(listaSocios.get(i).isTiene()==true)
				{
					contador=0;
					socio = listaSocios.get(i);
					for(int j=0; j<listaAvance.size();j++)
					{
						if(listaAvance.get(j).getSocio().getNroSocio().equals(socio.getNroSocio())){
							contador++;	
						}
					}
					if(contador>0)
					{
						deuda.setFecha(f);
						deuda.setMonto(ing.getMonto()*contador);
						deuda.setSocio(socio);
						deuda.setCodigo(this.GenerarCodigoDeuda());
						deuda.setDescripcion(ing.getDescripcion());
						deuda.setStatus("A");
						deuda.setIngreso(ing.getCodIngreso());
						deudaDao.agregarDeuda(deuda);
					}
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	//**************METODOSSSS PARA CARGAR LAS DEUDAS DE LOS ALQUILEEEREEES************************
	
	public void cargarDeudaAlquileres(){
		try {
		Date fecha = new Date(System.currentTimeMillis());
		DeudaAlquiler deuda= new DeudaAlquiler();
		Ingresos ing, ing2, ing3= new Ingresos();
		int cont=0;		
		int fin=inqDao.obtenerTodos().size();
		
		mayorAnno=historialD.obtenerTodos().get(0).getFechaSocio().getYear();
		mayorMes=historialD.obtenerTodos().get(0).getFechaSocio().getMonth();
		
		ing=ingDao.buscarPorCodIngreso("I0026");
		ing2=ingDao.buscarPorCodIngreso("I0027");
		ing3=ingDao.buscarPorCodIngreso("I0028");
	
		if(fecha.getMonth()>this.mayorMes)
		{	
			if(fecha.getYear()>=this.mayorAnno)
			{
				while(cont<fin){
					Inquilino inq= new Inquilino();
					inq=inqDao.obtenerTodos().get(cont);
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing.getDescripcion(), fecha, inq, ing.getMonto(), "A");
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing2.getDescripcion(), fecha, inq, ing2.getMonto(), "A");
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing3.getDescripcion(), fecha, inq, ing3.getMonto(), "A");
					cont++;
				}
			}		
		}		
			HistorialDeuda h= historialD.obtenerTodos().get(0);
			h.setFechaSocio(fecha);
			historialD.actualizarHistorial(h);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	
	}
	
	public void alquileres(String codigo, String descripcion, Date fecha, Inquilino inquilino, Float monto, String status){
		DeudaAlquiler d= new DeudaAlquiler();
		
		d.setCodigo(codigo);
		d.setDescripcion(descripcion);
		d.setFecha(fecha);
		d.setInquilino(inquilino);
		d.setMonto(monto);
		d.setStatus(status);
	
		try {
			deudaAlqDao.agregarDeuda(d);
			deudaAlqDao= new DeudaAlquilerDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

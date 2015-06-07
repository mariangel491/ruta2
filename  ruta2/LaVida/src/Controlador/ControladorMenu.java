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
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Local;
import Modelos.Socio;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.DeudaAlquilerDao;
import Modelos.Hibernate.Daos.DeudaDao;
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
	
	private InquilinoDao inqDao= new InquilinoDao();
	private DeudaAlquilerDao deudaAlqDao= new DeudaAlquilerDao();
	
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
		else if (ae.getActionCommand().equalsIgnoreCase("Deuda"))
	    {
			System.out.println("deudaaaaa");
	      //  deuda = new ControladorDeuda();
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
			System.out.println("boton subsidio");
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
	
	public int mayorMes(){
		int mayor=0, mes,otroMes, cant;
		try {
				if(deudaDao.obtenerTodos().size()==1)
					mayor= deudaDao.obtenerTodos().get(0).getFecha().getMonth();
				
				else{
					cant=deudaDao.obtenerTodos().size();
				
					for(int i=0; i<cant;i++)
					{
							mes=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
							if(i+1<cant)
								otroMes= deudaDao.obtenerTodos().get(i+1).getFecha().getMonth();
							else
								otroMes=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
						if(mes>otroMes)
							 mayor=mes;
						else if(mes<otroMes)
							mayor=otroMes;
						else
							mayor=mes;	
					}
					return mayor;
					
				}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mayor;
	}
	
	public int mayorAnno(){
		int mayor=0, anno,otroAnno, cant;
		try {
				if(deudaDao.obtenerTodos().size()==1)
				mayor= deudaDao.obtenerTodos().get(0).getFecha().getYear();
				else{
					cant=deudaDao.obtenerTodos().size();
				for(int i=0; i<cant;i++)
				{
						anno=deudaDao.obtenerTodos().get(i).getFecha().getYear();
						if(i+1<cant)
							otroAnno= deudaDao.obtenerTodos().get(i+1).getFecha().getYear();
						else
							otroAnno=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
					if(anno>otroAnno)
						 mayor=anno;
					else if(anno<otroAnno)
						mayor=otroAnno;
					else
						mayor=anno;	
				}
				return mayor;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mayor;
	}

	public void cargarDeudaTodosSocios(){
		try {
		Date fecha = new Date(System.currentTimeMillis());
		Deuda deuda= new Deuda();
		Ingresos ing= new Ingresos();
		int cont=0;		
		int fin=socioDao.obtenerTodos().size();
		this.mayorMes();
		ing=ingDao.buscarPorCodIngreso("I0001");
		//System.out.println("ing "+ ing.getDescripcion());
		if(fecha.getMonth()>this.mayorMes())
		{	
			if(fecha.getYear()>=this.mayorAnno())
			{
				while(cont<fin){
					Socio socio=new Socio();
					socio=socioDao.obtenerTodos().get(cont);
					//System.out.println(socio.getNombre()+ " " +socio.getNroSocio());
					
						deuda.setFecha(fecha);
						deuda.setMonto(ing.getMonto());
						deuda.setSocio(socio);
						deuda.setCodigo(this.GenerarCodigoDeuda());
						deuda.setDescripcion(ing.getDescripcion());
						deuda.setStatus("A");
						
						deudaDao.agregarDeuda(deuda);
						
					cont++;
					//System.out.println(cont);
				}this.DeudaConductorSoc();
			}		
		}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	
	public void DeudaConductorSoc(){
		System.out.println("deudas soc");
		Deuda deuda= new Deuda();
		Date f= new Date();
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
						System.out.println(contador);
					}
					if(contador>0)
					{
						//System.out.println("AxS"+ contador+ " "+ socioDao.obtenerTodos().get(i).getNroSocio());
						deuda.setFecha(f);
						deuda.setMonto(ing.getMonto()*contador);
						deuda.setSocio(socio);
						deuda.setCodigo(this.GenerarCodigoDeuda());
						deuda.setDescripcion(ing.getDescripcion());
						deuda.setStatus("A");
						
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
	public int mayorMesAlq(){
		int mayor=0, mes,otroMes, cant;
		try {
				if(deudaAlqDao.obtenerTodos().size()==1)
					mayor= deudaAlqDao.obtenerTodos().get(0).getFecha().getMonth();
				
				else{
					cant=deudaAlqDao.obtenerTodos().size();
				
					for(int i=0; i<cant;i++)
					{
							mes=deudaAlqDao.obtenerTodos().get(i).getFecha().getMonth();
							if(i+1<cant)
								otroMes= deudaAlqDao.obtenerTodos().get(i+1).getFecha().getMonth();
							else
								otroMes=deudaAlqDao.obtenerTodos().get(i).getFecha().getMonth();
						if(mes>otroMes)
							 mayor=mes;
						else if(mes<otroMes)
							mayor=otroMes;
						else
							mayor=mes;	
					}
					return mayor;
					
				}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mayor;
	}
	
	public int mayorAnnoAlq(){
		int mayor=0, anno,otroAnno, cant;
		try {
				if(deudaAlqDao.obtenerTodos().size()==1)
				mayor= deudaAlqDao.obtenerTodos().get(0).getFecha().getYear();
				else{
					cant=deudaAlqDao.obtenerTodos().size();
				for(int i=0; i<cant;i++)
				{
						anno=deudaAlqDao.obtenerTodos().get(i).getFecha().getYear();
						if(i+1<cant)
							otroAnno= deudaAlqDao.obtenerTodos().get(i+1).getFecha().getYear();
						else
							otroAnno=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
					if(anno>otroAnno)
						 mayor=anno;
					else if(anno<otroAnno)
						mayor=otroAnno;
					else
						mayor=anno;	
				}
				return mayor;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mayor;
	}
	public void cargarDeudaAlquileres(){
		try {
			System.out.println("alquileres");
		Date fecha = new Date(System.currentTimeMillis());
		DeudaAlquiler deuda= new DeudaAlquiler();
		Ingresos ing, ing2, ing3= new Ingresos();
		int cont=0;		
		int fin=inqDao.obtenerTodos().size();
		
		ing=ingDao.buscarPorCodIngreso("I0026");
		ing2=ingDao.buscarPorCodIngreso("I0027");
		ing3=ingDao.buscarPorCodIngreso("I0028");
	
		if(fecha.getMonth()>this.mayorMesAlq())
		{	
			if(fecha.getYear()>=this.mayorAnnoAlq())
			{
				while(cont<fin){
					System.out.println("entrando por inquilino");
					Inquilino inq= new Inquilino();
					inq=inqDao.obtenerTodos().get(cont);
					
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing.getClasifIngreso(), fecha, inq, ing.getMonto(), "A");
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing2.getClasifIngreso(), fecha, inq, ing2.getMonto(), "A");
					this.alquileres(deudaAlqDao.buscarUltimoNumeroDeudaA(), ing3.getClasifIngreso(), fecha, inq, ing3.getMonto(), "A");
					cont++;
				}
			}		
		}		
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
		System.out.println(deudaAlqDao.buscarUltimoNumeroDeudaA()+"  antes ultimo nro deuda   " + descripcion);
		try {
			deudaAlqDao.agregarDeuda(d);
			System.out.println(deudaAlqDao.buscarUltimoNumeroDeudaA()+"  ultimo nro deuda");
			deudaAlqDao= new DeudaAlquilerDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;








import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import Modelos.Local;
import Modelos.Hibernate.Daos.LocalDao;
import Vistas.*;

public class ControladorMenu implements ActionListener{

	mnuPrincipal menu;
	
	//Controladores
	ControladorAlquiler alquiler;
	ControladorAvance avance;
	ControladorInquilino inquilino;
	ControladorPrestamo prestamo;
	ControladorRegistrarLocal local;
	ControladorSocio socio;
	ControladorDeuda deuda;
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
			avance = new ControladorAvance(resp);
	      
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
	        deuda = new ControladorDeuda();
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
   
	

	
	
}

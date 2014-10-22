package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ControladorReportes.ControladorReporte;
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
	
	
	//PARA LOS REPORTES
	ControladorReporte controReporSocio;
	
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
			controReporSocio= new ControladorReporte();
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

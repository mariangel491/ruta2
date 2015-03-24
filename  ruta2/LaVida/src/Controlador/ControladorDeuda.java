package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelos.Deuda;
import Modelos.Ingresos;
import Modelos.Socio;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.DeudaDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaDeuda;

public class ControladorDeuda {


	private VistaDeuda vDeuda = new VistaDeuda();
	private SocioDao socioDao = new SocioDao();
	private IngresosDao ingDao= new IngresosDao();
	private DeudaDao deudaDao= new DeudaDao();
	private AvanceDao avanceDao= new AvanceDao();
	//private Deuda deuda= new Deuda();

	public ControladorDeuda() {
		
	}

	

}

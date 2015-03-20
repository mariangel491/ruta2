package Vistas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;

public class menuAlquiler  extends javax.swing.JFrame {
	private JMenuBar mnuBar;
	private JMenu mnuConsulta;
	private JMenuItem itmVehiculo;
	private JMenuItem itmSocio;
	private JMenuItem itmPrestamo;
	private JMenuItem jMenuItem1;
	private JMenuItem itmDepCaja;
	private JMenuItem mnuItmCargarSubsidio;
	private JMenuItem itmAvanceArren;
	private JMenuItem itemSub;
	private JMenu mnuSubsidio;
	private JMenuItem itemSubsidio;
	private JLabel lblImagen;
	private JButton jButton2;
	private JButton jButton1;
	private JButton btnRuta;
	private JMenuItem itmArrendatario;
	private JMenuItem itmBeneficiario;
	private JMenuItem itmLocal;
	private JSeparator jSeparator1;
	private JMenuItem itmIngresos;
	private JMenuItem itmFactura;
	private JMenuItem itemEgresos;
	private JMenuItem itmCargarIngresos;
	private JMenuItem itmAvance;
	private JMenuItem itmAlquiler;
	private JMenu mnuFondoChoq;
	private JMenu Registrar;
	private JMenuItem itmInquilino;
	private JMenuItem itmReporteSocio;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mnuPrincipal inst = new mnuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	//arrendamiento de cauchos, incluir cuentas, y tomar en cuenta arrendatarios
	//
	public menuAlquiler() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			{
				btnRuta = new JButton();
				getContentPane().add(btnRuta);
				btnRuta.setText("Ruta");
				btnRuta.setBounds(10, 334, 250, 62);
				btnRuta.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				btnRuta.setBackground(new java.awt.Color(206,221,225));
				btnRuta.setFont(new java.awt.Font("Segoe UI",2,20));
				btnRuta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/bus.png")));
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Alquiler");
				jButton1.setBounds(270, 334, 250, 62);
				jButton1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jButton1.setActionCommand("Alquiler");
				jButton1.setBackground(new java.awt.Color(206,221,225));
				jButton1.setFont(new java.awt.Font("Segoe UI",2,20));
				//
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/homeFolder.png")));
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Fondo de Choque");
				jButton2.setBounds(535, 334, 250, 62);
				jButton2.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jButton2.setBackground(new java.awt.Color(206,221,225));
				jButton2.setFont(new java.awt.Font("Segoe UI",2,20));
			
				/*String ruta_logo="Imagenes/tyres.png";
				ImageIcon img = new ImageIcon("Imagenes/tyres.png");
				jButton2.setIcon(new ImageIcon(img.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));*/
				
				jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/tyres.png")));
			}
			{
				lblImagen = new JLabel();
				getContentPane().add(lblImagen);
				lblImagen.setBounds(95, 12, 792, 316);
				lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Pendrive 16gb/logo.jpg")));
			}
			{
				mnuBar = new JMenuBar();
				setJMenuBar(mnuBar);
				mnuBar.setBackground(new java.awt.Color(206,221,225));
				{
					Registrar = new JMenu();
					mnuBar.add(Registrar);
					Registrar.setText("Registrar");
					{
						itmAlquiler = new JMenuItem();
						Registrar.add(itmAlquiler);
						itmAlquiler.setText("Alquiler");
						itmAlquiler.setActionCommand("Alquiler");
					}
					{
						itemEgresos = new JMenuItem();
						Registrar.add(itemEgresos);
						itemEgresos.setText("Egresos");
						itemEgresos.setActionCommand("Egresos");
					}
					{
						itmFactura = new JMenuItem();
						Registrar.add(itmFactura);
						itmFactura.setText("Factura");
						itmFactura.setActionCommand("Factura");
					}
					
					{
						itmInquilino = new JMenuItem();
						Registrar.add(itmInquilino);
						itmInquilino.setText("Inquilino");
						itmInquilino.setActionCommand("Inquilino");
					}
					{
						itmLocal = new JMenuItem();
						Registrar.add(itmLocal);
						itmLocal.setText("Local");
						itmLocal.setActionCommand("Local");
					}
					{
						jMenuItem1 = new JMenuItem();
						Registrar.add(jMenuItem1);
						jMenuItem1.setText("Facturación");
					}
				}
				{
					mnuConsulta = new JMenu();
					mnuBar.add(mnuConsulta);
					mnuConsulta.setText("Reportes");
					{
						jSeparator1 = new JSeparator();
						mnuConsulta.add(jSeparator1);
					}
				}
				{
					itmReporteSocio = new JMenuItem();
					mnuConsulta.add(itmReporteSocio);
					itmReporteSocio.setText("Reporte Socios");
					itmReporteSocio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
                          String consulta="SELECT * from socio";
                         //  ControladorReporte jasper = new ControladorReporte();
                          //  jasper.runReporte();
				
						/*//	String sourceFileName =System.getProperty("user.dir") +"/src/Reportes/ReporteSocios.jrxml";

						      try {
						       //  JasperFillManager.fillReportToFile(sourceFileName, null,
						 //           new JREmptyDataSource());
						      } catch (JRException e) {
						         // TODO Auto-generated catch block
						         e.printStackTrace();
						      }*/
						}});
					itmReporteSocio.setActionCommand("ReporteSocio");
				}
								
			}
			pack();
			this.setSize(797, 456);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
	
	}
	public void agregarListener(ActionListener evento){
		
	
		 this.itemEgresos.addActionListener(evento);
		 this.itmAvance.addActionListener(evento);
		 this.itmCargarIngresos.addActionListener(evento);
		 this.itmIngresos.addActionListener(evento);
		 this.itmPrestamo.addActionListener(evento);
		 this.itmSocio.addActionListener(evento);
		 this.itmVehiculo.addActionListener(evento);
		 this.itmAlquiler.addActionListener(evento);
		 this.itmLocal.addActionListener(evento);
		 this.itmInquilino.addActionListener(evento);
		 this.itmBeneficiario.addActionListener(evento);
		 this.itmArrendatario.addActionListener(evento);
		 this.itmAvanceArren.addActionListener(evento);
		 this.itmReporteSocio.addActionListener(evento);
		 this.mnuItmCargarSubsidio.addActionListener(evento);
		 this.itmDepCaja.addActionListener(evento);
		 this.itmFactura.addActionListener(evento);
	}

}


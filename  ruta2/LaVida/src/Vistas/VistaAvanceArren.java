package Vistas;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.AvanceArrendatario;
import Modelos.Ruta;
import Modelos.Socio;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaSocio;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VistaAvanceArren extends javax.swing.JFrame {
	
	private JPanel jpAvance;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JTextField txtCedula;
	private JLabel lblCedula;
	private JTextField txtApellido;
	private JButton btnAgregar;
	private JButton btnEliminarAvance;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JButton btnBuscarArren;
	private JButton btnLimpiar;
	private JTable tblListadoAvance;
	private JScrollPane spListadoAvance;
	private JPanel jpAvancexArren;
	private JTextField txtNomArrendatario;
	private JLabel lblNomSocio;
	private JTextField txtNroArrendatario;
	private JLabel lblNroArrendatario;
	private JPanel jpDatosSocio;
	private JButton btnBuscarAvance;
	private JTextField txtTelefono;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblImagen;
	private JPanel jpImagen;
	private JButton btnRV;
	private JButton btnRAA;
	private JButton btnRA;
	private JLabel lblAvance;

	//Socio socioprueba= new Socio();
	Arrendatario arrenPrueba = new Arrendatario();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaAvance inst = new VistaAvance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaAvanceArren vAvanceArren=null;
	
	public static VistaAvanceArren obtenerInstancia(){
		if(vAvanceArren==null)
			vAvanceArren= new VistaAvanceArren();
		return vAvanceArren;
	}
	
	//MIS DATOS 
	private List<Avance> avancesT;
	private VistaSocio vSocio;
	private Socio socio;
	
	List<Avance> AvancesPorSocio= new ArrayList();
	private Avance ListaAvan;
	
	public VistaAvanceArren() {
		super();
		initGUI();
		}


	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Registrar Avance");
			{
				jpAvance = new JPanel();
				getContentPane().add(jpAvance, "Center");
				jpAvance.setLayout(null);
				jpAvance.setBounds(12, 181, 295, 248);
				jpAvance.setBorder(BorderFactory.createTitledBorder("Datos del Avance"));
				{
					lblNombre = new JLabel();
					jpAvance.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(17, 59, 62, 16);
					lblNombre.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNombre = new JTextField();
					jpAvance.add(txtNombre);
					txtNombre.setBounds(91, 56, 187, 23);
				}
				{
					lblApellido = new JLabel();
					jpAvance.add(lblApellido);
					lblApellido.setText("Apellido:");
					lblApellido.setBounds(17, 90, 62, 16);
					lblApellido.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtApellido = new JTextField();
					jpAvance.add(txtApellido);
					txtApellido.setBounds(91, 87, 187, 23);
				}
				{
					lblCedula = new JLabel();
					jpAvance.add(lblCedula);
					lblCedula.setText("C�dula:");
					lblCedula.setBounds(17, 30, 62, 16);
					lblCedula.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtCedula = new JTextField();
					jpAvance.add(txtCedula);
					txtCedula.setBounds(89, 26, 134, 23);
					txtCedula.setActionCommand("BCedAvanArrendTecla");
				}
				{
					lblDireccion = new JLabel();
					jpAvance.add(lblDireccion);
					lblDireccion.setText("Direcci�n:");
					lblDireccion.setBounds(17, 134, 69, 15);
					lblDireccion.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtDireccion = new JTextField();
					jpAvance.add(txtDireccion);
					txtDireccion.setBounds(91, 117, 187, 50);
				}
				{
					lblTelefono = new JLabel();
					jpAvance.add(lblTelefono);
					lblTelefono.setText("Tel�fono:");
					lblTelefono.setBounds(17, 178, 62, 16);
					lblTelefono.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtTelefono = new JTextField();
					jpAvance.add(txtTelefono);
					txtTelefono.setBounds(91, 175, 187, 23);
				}
				{
					btnAgregar = new JButton();
					jpAvance.add(btnAgregar);
					btnAgregar.setText("Agregar Avance");
					btnAgregar.setBounds(62, 212, 161, 23);
					btnAgregar.setFont(new java.awt.Font("Century Gothic",0,12));
					btnAgregar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
					btnAgregar.setActionCommand("AgregarAvanceArrendatario");
				}
				{
					btnBuscarAvance = new JButton();
					jpAvance.add(btnBuscarAvance);
					btnBuscarAvance.setBounds(230, 21, 31, 30);
					btnBuscarAvance.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarAvance.setActionCommand("BuscarAvanceArrendatario");
				}
			}
			{
				lblAvance = new JLabel();
				getContentPane().add(lblAvance);
				lblAvance.setText("Registrar Avance");
				lblAvance.setBounds(328, 17, 183, 23);
				lblAvance.setFont(new java.awt.Font("Century Gothic",2,20));
			}
			{
				jpDatosSocio = new JPanel();
				getContentPane().add(jpDatosSocio);
				//jpDatosSocio.setLayout(jpDatosSocioLayout);
				jpDatosSocio.setBounds(12, 90, 295, 88);
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
				jpDatosSocio.setLayout(null);
				{
					lblNroArrendatario = new JLabel();
					jpDatosSocio.add(lblNroArrendatario);
					lblNroArrendatario.setText("Nro de Arrendatario:");
					lblNroArrendatario.setBounds(17, 24, 112, 16);
					lblNroArrendatario.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNroArrendatario = new JTextField();
					jpDatosSocio.add(txtNroArrendatario);
					txtNroArrendatario.setBounds(134, 21, 94, 23);
					txtNroArrendatario.setActionCommand("BArrendatTecla");

				}
				{
					btnBuscarArren = new JButton();
					jpDatosSocio.add(btnBuscarArren);
					btnBuscarArren.setBounds(247, 17, 30, 29);
					btnBuscarArren.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarArren.setActionCommand("BuscarArrendatario");
				}
				{
					lblNomSocio = new JLabel();
					jpDatosSocio.add(lblNomSocio);
					lblNomSocio.setText("Nombre:");
					lblNomSocio.setBounds(17, 52, 63, 16);
					lblNomSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNomArrendatario = new JTextField();
					jpDatosSocio.add(txtNomArrendatario);
					txtNomArrendatario.setBounds(79, 49, 150, 23);
				}
			}
			{
				jpAvancexArren = new JPanel();
				getContentPane().add(jpAvancexArren);
				//jpAvancexSocio.setLayout(jpAvancexSocioLayout);
				jpAvancexArren.setBounds(319, 116, 395, 313);
				jpAvancexArren.setBorder(BorderFactory.createTitledBorder("Listado de Avances por Arrendatario"));
				jpAvancexArren.setLayout(null);
				{
					spListadoAvance = new JScrollPane();
					jpAvancexArren.add(spListadoAvance);
					spListadoAvance.setBounds(10, 48, 374, 196);
					{
						TableModel tblListadoAvanceModel = 
								new DefaultTableModel(
										new String[][] { {}, {} },
										new String[] { "Nombre", "Apellido", "C�dula", "Direcci�n", "Tel�fono" });
						tblListadoAvance = new JTable();
						spListadoAvance.setViewportView(tblListadoAvance);
						tblListadoAvance.setModel(tblListadoAvanceModel);
						
						
					}
				}
				{
					btnEliminarAvance = new JButton();
					jpAvancexArren.add(btnEliminarAvance);
					btnEliminarAvance.setText("Eliminar Avance");
					btnEliminarAvance.setBounds(121, 257, 155, 23);
					btnEliminarAvance.setFont(new java.awt.Font("Century Gothic",0,12));
					btnEliminarAvance.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/remove.png")));
					btnEliminarAvance.setActionCommand("EliminarAvanceArrendatario");
				}
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(343, 445, 125, 29);
				btnLimpiar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(201, 445, 125, 29);
				btnCancelar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
			}
			{
				btnSiguiente = new JButton();
				getContentPane().add(btnSiguiente);
				btnSiguiente.setText("Siguiente");
				btnSiguiente.setBounds(483, 445, 125, 29);
				btnSiguiente.setFont(new java.awt.Font("Century Gothic",0,12));
				btnSiguiente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sig.png")));
				
			}
			{
				btnAtras = new JButton();
				getContentPane().add(btnAtras);
				btnAtras.setText("Atras");
				btnAtras.setBounds(60, 445, 125, 29);
				btnAtras.setFont(new java.awt.Font("Century Gothic",0,12));
				btnAtras.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/atras_.png")));
				
			}
			{
				btnRA = new JButton();
				getContentPane().add(btnRA);
				btnRA.setText("Registrar Arrendatario");
				btnRA.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRA.setBounds(0, 58, 243, 29);
				btnRA.setActionCommand("RegistrarSocio");
			}
			{
				btnRAA = new JButton();
				getContentPane().add(btnRAA);
				btnRAA.setText("Registrar Avance");
				btnRAA.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRAA.setBounds(243, 58, 239, 29);
				btnRAA.setActionCommand("RegistrarAvance");
			}
			{
				btnRV = new JButton();
				getContentPane().add(btnRV);
				getContentPane().add(getJpImagen());
				btnRV.setText("Registrar Veh�culo");
				btnRV.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRV.setBounds(482, 58, 243, 29);
				btnRV.setActionCommand("RegistrarVehiculo");
			}
			pack();
			this.setSize(742, 526);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	

public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String Nombre) {
		txtNombre.setText(Nombre);
	}

	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public void setTxtDireccion(String Direccion) {
		txtDireccion.setText(Direccion);
	}

	public String getTxtCedula() {
		return txtCedula.getText();
	}

	public void setTxtCedula(String Cedula) {
		txtCedula.setText(Cedula);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String Apellido) {
		txtApellido.setText(Apellido);
	}

	public String getTxtNomSocio() {
		return txtNomArrendatario.getText();
	}

	public void setTxtNomSocio(String NomSocio) {
		txtNomArrendatario.setText(NomSocio); 
	}

	public String getTxtNroSocio() {
		return txtNroArrendatario.getText();
	}

	public void setTxtNroSocio(String NroSocio) {
		txtNroArrendatario.setText(NroSocio);
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String Telefono) {
		txtTelefono.setText(Telefono);
	}


	public void agregarFila(/*String cod, */String apellido, String nombre, String ced,
			String telefono, String direccion, String fecha)
	{
		Vector<String> avance = new Vector<String>();

	//	avance.add(cod);
		avance.add(nombre);
		avance.add(apellido);
		avance.add(ced);
		avance.add(direccion);
		avance.add(telefono);
		avance.add(fecha);
		
		DefaultTableModel dtm = (DefaultTableModel) tblListadoAvance.getModel();
		dtm.addRow(avance);	
	}

	public void removerFila(){
		 DefaultTableModel miTableModel = (DefaultTableModel) tblListadoAvance.getModel();
	     int indFil = tblListadoAvance.getSelectedRow();
	     if (indFil >= 0)
	          miTableModel.removeRow(indFil);
	}
	
	public int filaSeleccionada(){
		return tblListadoAvance.getSelectedRow()+1;
	}
	
	

public List<AvanceArrendatario> LlenarListaAvancesArren(){
		
		int column= tblListadoAvance.getColumnCount();
		int fila= tblListadoAvance.getRowCount();
		List<AvanceArrendatario> a = new ArrayList<AvanceArrendatario>();
		String ced,codAvance, nombre, apellido,direc,telefono;
		Date f= new Date();
		
		
		
		for(int i=0; i<fila;i++)
		{		
				AvanceArrendatario avance= new AvanceArrendatario();
			//	codAvance=(String) tblListadoAvance.getValueAt(i, 0);
				nombre=(String) tblListadoAvance.getValueAt(i, 0);
				apellido=(String) tblListadoAvance.getValueAt(i, 1);
				ced=(String) tblListadoAvance.getValueAt(i, 2);
				direc=(String) tblListadoAvance.getValueAt(i, 3);
				telefono=(String) tblListadoAvance.getValueAt(i, 4);
										
			//	avance.setCodAvance(codAvance);
				avance.setCedula(ced);
				avance.setNombre(nombre);
				avance.setApellido(apellido);
				avance.setTelefono(Integer.parseInt(telefono));
				avance.setDireccion(direc);
				avance.setFechaIngreso(f);
				
				a.add(avance);
				
		}
		
		return a;
	}

	public String llenarCodigo() {
		
		VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNroSocio(this.getTxtNroSocio());
		
		
	return vvehiculo.getTxtNroSocio();
	}
	
	public String llenarNombre() {
		
		VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNomSocio(this.getTxtNomSocio());
	return vvehiculo.getTxtNomSocio();
	}
	
	
	//ME PARECE QUE ESTE METODO ESTA DE MAS.. SE PUEDE HACER DIRECTAMENTE EN EL CONSTRUCTOR!
	public String LLenarComboAvanceSocio() {
		VistaVehiculo vv= new VistaVehiculo();
		
		for(int i=0; i<this.LlenarListaAvancesArren().size();i++){
			vv.setCmbConductor(this.LlenarListaAvancesArren().get(i).getNombre());
		}
		return vv.getCmbConductor();
	}
	
	public int RemoverAvance() {
		
			     int indFil = tblListadoAvance.getSelectedRow();
			     System.out.println(indFil);
	return indFil;
	}
		
public JTable getTblListadoAvance() {
		return tblListadoAvance;
	}

public void setTblListadoAvance(JTable tblListadoAvance) {
		this.tblListadoAvance = tblListadoAvance;
	}

//Agregar listeners
public void agregarListener(ActionListener accion) {
	this.btnCancelar.addActionListener(accion);
	this.btnAtras.addActionListener(accion);
	this.btnSiguiente.addActionListener(accion);
	this.btnBuscarArren.addActionListener(accion);
	this.btnAgregar.addActionListener(accion);
	this.btnBuscarAvance.addActionListener(accion);
	this.btnEliminarAvance.addActionListener(accion);
	this.btnRAA.addActionListener(accion);
	this.btnRA.addActionListener(accion);
	this.btnRV.addActionListener(accion);
	this.btnLimpiar.addActionListener(accion);
	this.txtNroArrendatario.addActionListener(accion);
	this.txtCedula.addActionListener(accion);

}

//LimpiarCampos
public void limpiarCampos() {
	txtApellido.setText("");
	txtCedula.setText("");
	txtDireccion.setText("");
	txtNombre.setText("");
	txtTelefono.setText("");	
}

//validar que todos los campos esten llenos

	public boolean CamposllenosArrendatario() {

		boolean CamposLLenos = false;

		if (this.txtNroArrendatario.getText().equals("")) {
			// si falta el nro socio
			JOptionPane.showMessageDialog(null, "Debe ingresar el numero del arrendatario",
					"Error", 0);
			this.txtNroArrendatario.requestFocus();
			CamposLLenos = false;
		} else if (this.txtNomArrendatario.equals("")) {
			// si falta el nombre del socio
			JOptionPane.showMessageDialog(null,
					"Debe ingresar el nombre del Arrendatario", "Error", 0);
			this.txtNomArrendatario.requestFocus();
			CamposLLenos = false;
		} else {
			// sino falta nada
			CamposLLenos = true;
		}
		// retornamos el valor de la validaci�n
		return CamposLLenos;
	}
	
public boolean CamposllenosAvance() {

	boolean CamposLLenos = false;

	if (this.txtCedula.getText().equals("")) {
		// si falta la cedula
		JOptionPane.showMessageDialog(null, "Debe ingresar una cedula",
				"Error", 0);
		this.txtCedula.requestFocus();
		CamposLLenos = false;
	}else if (this.txtNombre.getText().equals("")) {
		// si falta el nombre
		JOptionPane.showMessageDialog(null, "Debe ingresar el nombre",
				"Error", 0);
		this.txtNombre.requestFocus();
		CamposLLenos = false;
	} else if (this.txtApellido.getText().equals("")) {
		// si falta el apellido
		JOptionPane.showMessageDialog(null, "Debe ingresar el apellido",
				"Error", 0);
		this.txtApellido.requestFocus();
		CamposLLenos = false;
	} else if (this.txtDireccion.getText().equals("")) {
		// si falta la direcc�n
		JOptionPane.showMessageDialog(null,
				"Debe ingresar la direcci�n", "Error", 0);
		this.txtDireccion.requestFocus();
		CamposLLenos = false;
	} else if (this.txtTelefono.getText().equals("")) {
		// si falta el telefono
		JOptionPane.showMessageDialog(null, "Debe ingresar el telefono",
				"Error", 0);
		this.txtTelefono.requestFocus();
		CamposLLenos = false;
	} else {
		// sino falta nada
		CamposLLenos = true;
	}
	// retornamos el valor de la validaci�n
	return CamposLLenos;
}

// Limpiar Tabla Avances
public void limpiarTablaAvances() {
TableModel tblListadoModel = 
new DefaultTableModel(
		new String[] { "Nombre", "Apellido", "C�dula", "Direcci�n", "Tel�fono" },0);
tblListadoAvance.setModel(tblListadoModel);

}	

// cerrar Ventana
public void cerrarVentana() {
	// TODO Auto-generated method stub
	int ValorDevuelto = JOptionPane.showConfirmDialog(null,
			"�Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
	if (ValorDevuelto == 0) {
		this.dispose();
	}
}

private JPanel getJpImagen() {
	if(jpImagen == null) {
		jpImagen = new JPanel();
		jpImagen.setBounds(2, 2, 721, 57);
		jpImagen.setBackground(new java.awt.Color(255,255,255));
		jpImagen.setLayout(null);
		jpImagen.add(getLblImagen());
	}
	return jpImagen;
}

private JLabel getLblImagen() {
	if(lblImagen == null) {
		lblImagen = new JLabel();
		lblImagen.setBounds(2, 1, 307, 56);
		lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
	}
	return lblImagen;
}

/*public void CambiarNombrePanel(){
	jpAvancexSocio.setBorder(BorderFactory.createTitledBorder("Listado de Avances por Arrendatario"));
	jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
	btnGuardar.setActionCommand("GuardarArrendatario");
	btnBuscarSocio.setActionCommand("BuscarArrendatario");
	this.btnBuscarAvance.setActionCommand("BuscarAvanceArrendatario");
	btnAgregar.setActionCommand("AgregarAvanceArrend");
	lblNroSocio.setText("C�digo");
	btnRS.setText("Registrar Arrendatario");
	txtNroSocio.setActionCommand("BArrendatTecla");
	txtCedula.setActionCommand("BCedAvanArrendTecla");

	//btnRS.setActionCommand("RS");
	
	
}*/



public Arrendatario GuardarArrendatario(Arrendatario a) {
	Arrendatario arren= new Arrendatario();
	Date f= new Date();
//	VistaArrendatario va = new VistaArrendatario();
	
	arren.setCedula(a.getCedula());
	arren.setApellido(a.getApellido());
	arren.setDireccion(a.getDireccion());
	arren.setFechaIngreso(f);
	arren.setTiene(a.isTiene());
	/*if(va.Seleccion()==1)
	arren.setTiene(true);
	else
		arren.setTiene(false);*/
	
	arren.setMonto(a.getMonto());
	
	arren.setNombre(a.getNombre());
	arren.setStatus("Activo");
	
	arren.setTelefono(a.getTelefono());
	try {
		arren.setRuta(a.getRuta());
		arrenPrueba = a;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return a;
}

public Arrendatario RetornaArrendatario(){
	System.out.println("arrendatario vista "+ arrenPrueba.getNombre()+"    "+ arrenPrueba.getApellido());
	return arrenPrueba;
}


public void agregarKeyTel(KeyListener a) {
	txtTelefono.addKeyListener(a);
	txtNroArrendatario.addKeyListener(a);
	txtCedula.addKeyListener(a);
}

}
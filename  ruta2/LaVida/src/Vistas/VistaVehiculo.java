package Vistas;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import Modelos.Avance;
import Modelos.Beneficiario;
import Modelos.Marca;
import Modelos.Vehiculo;
import Modelos.VehiculoArrendatario;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.MarcaDao;
import Modelos.Hibernate.Daos.VehiculoDao;


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
public class VistaVehiculo extends javax.swing.JFrame {
	private JPanel jpVehiculoxSocio;
	private JLabel lblVehiculo;
	private JPanel jpDatosVehiculo;
	private JButton btnModificar;
	private JLabel lblImagen;
	private JPanel jpImagen;
	private JTextField txtNroPuestos;
	private JLabel lblNroPuestos;
	private JComboBox cmbConductor;
	private JLabel lblConductor;
	private JButton btnBusPlaca;
	private JButton btnRV;
	private JButton btnRA;
	private JButton btnRS;
	private JButton btnBusSocio;
	private JLabel lblTexto;
	private JTextField txtAnno;
	private JButton btnAgregar;
	private JButton btnEliminarVehiculo;
	private JButton btnAtras;
	private JButton btnGuardar;
	private JTextField txtSerial;
	private JLabel lblSerial;
	private JButton btnSiguiente;
	private JButton btnLimpiar;
	private JTable tblListadoVehiculo;
	private JScrollPane spListado;
	private JLabel lblAnno;
	private JComboBox cmbMarca;
	private JLabel lblMarca;
	private JTextField txtNomSocio;
	private JLabel lblPlaca;
	private JTextField txtPlaca;
	private JLabel lblNomSocio;
	private JLabel lblNroSocio;
	private JTextField txtNroSocio;
	private JPanel jpDatosSocio;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaVehiculo inst = new VistaVehiculo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaVehiculo vVehic=null;
	
	public static VistaVehiculo obtenerInstancia(){
		if(vVehic==null)
			vVehic= new VistaVehiculo();
		return vVehic;
	}
	
	private MarcaDao marcaDao = new MarcaDao();
	private AvanceDao avanceDao = new AvanceDao();
	
	public VistaVehiculo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Registrar Veh�culo");
			{
				jpVehiculoxSocio = new JPanel();
				getContentPane().add(jpVehiculoxSocio, "Center");
				jpVehiculoxSocio.setLayout(null);
				jpVehiculoxSocio.setBounds(319, 120, 394, 300);
				jpVehiculoxSocio.setBorder(BorderFactory.createTitledBorder("Listado de Veh�culos por Socio"));
				{
					spListado = new JScrollPane();
					jpVehiculoxSocio.add(spListado);
					spListado.setBounds(14, 55, 367, 129);
					{
						TableModel tblListadoVehiculoModel = 
								new DefaultTableModel(
										new String[][] { {}, {} },
										new String[] { "Placa", "Serial", "Marca", "A�o" , "Puestos ", "Avance"});
						tblListadoVehiculo = new JTable();
						spListado.setViewportView(tblListadoVehiculo);
						tblListadoVehiculo.setModel(tblListadoVehiculoModel);
					}
				}
				{
					lblTexto = new JLabel();
					jpVehiculoxSocio.add(lblTexto);
					lblTexto.setText("El socio no tiene Vehiculos!!");
					lblTexto.setBounds(98, 121, 264, 16);
					lblTexto.setFont(new java.awt.Font("Segoe UI",2,16));
				}
				{
					btnEliminarVehiculo = new JButton();
					jpVehiculoxSocio.add(btnEliminarVehiculo);
					btnEliminarVehiculo.setText("Eliminar Veh�culo");
					btnEliminarVehiculo.setBounds(96, 196, 173, 24);
					btnEliminarVehiculo.setFont(new java.awt.Font("Century Gothic",0,12));
					btnEliminarVehiculo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/remove.png")));
					btnEliminarVehiculo.setActionCommand("EliminarVehiculo");
				}
				//jpVehiculoxSocio.setLayout(jpVehiculoLayout);
			}
			{
				lblVehiculo = new JLabel();
				getContentPane().add(lblVehiculo);
				lblVehiculo.setText("Registrar Veh�culo");
				lblVehiculo.setBounds(254, 12, 186, 22);
				lblVehiculo.setFont(new java.awt.Font("Century Gothic",2,20));
			}
			{
				jpDatosSocio = new JPanel();
				getContentPane().add(jpDatosSocio);
				//jpDatosSocio.setLayout(jpDatosSocioLayout);
				jpDatosSocio.setBounds(12, 91, 295, 90);
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				jpDatosSocio.setLayout(null);
				{
					txtNroSocio = new JTextField();
					jpDatosSocio.add(txtNroSocio);
					txtNroSocio.setBounds(136, 23, 80, 23);
					txtNroSocio.setActionCommand("BSocTecla");
				}
				{
					lblNroSocio = new JLabel();
					jpDatosSocio.add(lblNroSocio);
					lblNroSocio.setText("N�mero de Socio:");
					lblNroSocio.setFont(new java.awt.Font("Verdana",0,12));
					lblNroSocio.setBounds(11, 26, 113, 16);
				}
				{
					lblNomSocio = new JLabel();
					jpDatosSocio.add(lblNomSocio);
					lblNomSocio.setText("Nombre: ");
					lblNomSocio.setBounds(11, 58, 61, 16);
					lblNomSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNomSocio = new JTextField();
					jpDatosSocio.add(txtNomSocio);
					txtNomSocio.setBounds(79, 55, 186, 23);
				}
				{
					btnBusSocio = new JButton();
					jpDatosSocio.add(btnBusSocio);
					btnBusSocio.setBounds(228, 19, 37, 29);
					btnBusSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBusSocio.setActionCommand("BuscarSocio");
				}
			}
			{
				jpDatosVehiculo = new JPanel();
				getContentPane().add(jpDatosVehiculo);
				//jpDatosVehiculo.setLayout(jpDatosVehiculoLayout);
				jpDatosVehiculo.setBounds(12, 188, 295, 248);
				jpDatosVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del Veh�culo"));
				jpDatosVehiculo.setLayout(null);
				{
					lblPlaca = new JLabel();
					jpDatosVehiculo.add(lblPlaca);
					lblPlaca.setText("Placa:");
					lblPlaca.setBounds(17, 23, 45, 16);
					lblPlaca.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtPlaca = new JTextField();
					jpDatosVehiculo.add(txtPlaca);
					txtPlaca.setBounds(62, 20, 167, 23);
					txtPlaca.setActionCommand("BPlacVehSocTecla");
				}
				{
					lblMarca = new JLabel();
					jpDatosVehiculo.add(lblMarca);
					lblMarca.setText("Marca:");
					lblMarca.setBounds(17, 86, 50, 16);
					lblMarca.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					ComboBoxModel cmbMarcaModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccionar opci�n"});
					cmbMarca = new JComboBox();
					jpDatosVehiculo.add(cmbMarca);
					cmbMarca.setModel(cmbMarcaModel);
					cmbMarca.setBounds(65, 83, 210, 23);
				}
				{
					lblAnno = new JLabel();
					jpDatosVehiculo.add(lblAnno);
					lblAnno.setText("A�o:");
					lblAnno.setBounds(17, 117, 38, 16);
					lblAnno.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtAnno = new JTextField();
					jpDatosVehiculo.add(txtAnno);
					txtAnno.setBounds(63, 114, 212, 23);
				}
				{
					lblConductor = new JLabel();
					jpDatosVehiculo.add(lblConductor);
					lblConductor.setText("Conductor:");
					lblConductor.setBounds(18, 177, 73, 16);
					lblConductor.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					ComboBoxModel cmbConductorModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccionar opci�n" });
					cmbConductor = new JComboBox();
					jpDatosVehiculo.add(cmbConductor);
					cmbConductor.setModel(cmbConductorModel);
					cmbConductor.setBounds(101, 174, 177, 23);
				}
				{
					btnAgregar = new JButton();
					jpDatosVehiculo.add(btnAgregar);
					btnAgregar.setText("Agregar Veh�culo");
					btnAgregar.setBounds(70, 209, 161, 24);
					btnAgregar.setFont(new java.awt.Font("Century Gothic",0,12));
					btnAgregar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
					btnAgregar.setActionCommand("AgregarVehiculo");
				}
				{
					lblSerial = new JLabel();
					jpDatosVehiculo.add(lblSerial);
					lblSerial.setText("Serial Carrocer�a:");
					lblSerial.setBounds(20, 55, 114, 16);
					lblSerial.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtSerial = new JTextField();
					jpDatosVehiculo.add(txtSerial);
					txtSerial.setBounds(133, 52, 140, 23);
				}
				{
					btnBusPlaca = new JButton();
					jpDatosVehiculo.add(btnBusPlaca);
					jpDatosVehiculo.add(getLblNroPuestos());
					jpDatosVehiculo.add(getTxtNroPuestos());
					jpDatosVehiculo.add(getBtnModificar());
					btnBusPlaca.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBusPlaca.setBounds(240, 15, 37, 29);
					btnBusPlaca.setActionCommand("BuscarPlaca");
				}
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(369, 448, 115, 29);
				btnLimpiar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setActionCommand("Limpiar");
			}
			{
				btnSiguiente = new JButton();
				getContentPane().add(btnSiguiente);
				btnSiguiente.setText("Cancelar");
				btnSiguiente.setBounds(238, 448, 115, 29);
				btnSiguiente.setFont(new java.awt.Font("Century Gothic",0,12));
				btnSiguiente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnSiguiente.setActionCommand("Siguiente");
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setBounds(503, 448, 115, 29);
				btnGuardar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setActionCommand("Guardar");
			}
			{
				btnAtras = new JButton();
				getContentPane().add(btnAtras);
				btnAtras.setText("Atras");
				btnAtras.setBounds(105, 448, 115, 29);
				btnAtras.setFont(new java.awt.Font("Century Gothic",0,12));
				btnAtras.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/atras_.png")));
				btnAtras.setActionCommand("Atras");
			}
			{
				btnRS = new JButton();
				getContentPane().add(btnRS);
				btnRS.setText("Registrar Socio");
				btnRS.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRS.setBounds(0, 58, 241, 29);
				btnRS.setActionCommand("RegistrarSocio");
			}
			{
				btnRA = new JButton();
				getContentPane().add(btnRA);
				btnRA.setText("Registrar Avance");
				btnRA.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRA.setBounds(241, 58, 243, 29);
				btnRA.setActionCommand("RegistrarAvance");
			}
			{
				btnRV = new JButton();
				getContentPane().add(btnRV);
				getContentPane().add(getJpImagen());
				btnRV.setText("Registrar Veh�culo");
				btnRV.setFont(new java.awt.Font("Century Gothic",0,12));
				btnRV.setBounds(484, 58, 241, 29);
				btnRV.setActionCommand("RegistrarVehiculo");
			}
			pack();
			this.setSize(741, 520);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	public JTable getTblListadoVehiculo() {
		return tblListadoVehiculo;
	}

	public void setTblListadoVehiculo(JTable tblListadoVehiculo) {
		this.tblListadoVehiculo = tblListadoVehiculo;
	}

	public String getTxtAnno() {
		return txtAnno.getText();
	}	
	
	public String getTxtSerial() {
		return txtSerial.getText();
	}

	public void setTxtSerial(String Serial) {
		this.txtSerial.setText(Serial);
	}

	public String getTxtNomSocio() {
		return txtNomSocio.getText();
	}

	public void setTxtNomSocio(String NomSocio) {
		this.txtNomSocio.setText(NomSocio);
	}

	public String getTxtPlaca() {
		return txtPlaca.getText();
	}

	public void setTxtPlaca(String Placa) {
		this.txtPlaca.setText(Placa);
	}

	public String getTxtNroSocio() {
		return txtNroSocio.getText();
	}

	public void setTxtNroSocio(String txtNroSocio) {
		this.txtNroSocio.setText(txtNroSocio);
	}

	public void setTxtAnno(String Anno) {
		this.txtAnno.setText(Anno);
	}
	

	public void setCmbConductor(String cmbConductor) {
		this.cmbConductor.addItem(cmbConductor);
	}

	public void setCmbMarca(JComboBox cmbMarca) {
		this.cmbMarca = cmbMarca;
	}
	
	
	public String getNroPuestos(){
		return this.txtNroPuestos.getText();
	}
	
	public void setNroPuestos(String nro){
		this.txtNroPuestos.setText(nro);
	}

	private JLabel getLblNroPuestos() {
		if(lblNroPuestos == null) {
			lblNroPuestos = new JLabel();
			lblNroPuestos.setText("N�mero de Puestos:");
			lblNroPuestos.setBounds(17, 147, 143, 16);
			lblNroPuestos.setFont(new java.awt.Font("Verdana",0,12));
		}
		return lblNroPuestos;
	}
	

	
	private JTextField getTxtNroPuestos() {
		if(txtNroPuestos == null) {
			txtNroPuestos = new JTextField();
			txtNroPuestos.setBounds(159, 144, 116, 23);
		}
		return txtNroPuestos;
	}
			//AGREGAR LISTENERS
			public void agregarListener(ActionListener accion) {
				this.btnAgregar.addActionListener(accion);
				this.btnModificar.addActionListener(accion);
				this.btnAtras.addActionListener(accion);
				this.btnBusPlaca.addActionListener(accion);
				this.btnBusSocio.addActionListener(accion);
				this.btnSiguiente.addActionListener(accion);
				this.btnEliminarVehiculo.addActionListener(accion);
				this.btnGuardar.addActionListener(accion);
				this.btnLimpiar.addActionListener(accion);
				this.btnRA.addActionListener(accion);
				this.btnRS.addActionListener(accion);
				this.btnRV.addActionListener(accion);
				this.txtNroSocio.addActionListener(accion);
				this.txtPlaca.addActionListener(accion);
	
			}

		//LimpiarCampos
		public void limpiarCampos() {
			
			txtNomSocio.setText("");
			txtNroSocio.setText("");
			txtAnno.setText("");
			txtPlaca.setText("");
			txtSerial.setText("");
			cmbMarca.setSelectedIndex(0);
			cmbConductor.setSelectedIndex(0);
			txtNroPuestos.setText("");
			this.limpiarTablaVehiculos();
			this.lblTexto.setVisible(false);
			this.spListado.setVisible(true);
		}
				
		public void limpiarCamposVehiculo() {
			txtAnno.setText("");
			txtPlaca.setText("");
			txtSerial.setText("");
			cmbMarca.setSelectedIndex(0);
			cmbConductor.setSelectedIndex(0);
			txtNroPuestos.setText("");
		}

		
		public void OcultarBotones() {
			
		 	this.btnModificar.setVisible(false);
		 	this.btnAgregar.setVisible(true);
		}


		public void MostarBotones() {
			
		 	this.btnModificar.setVisible(true);
		 	this.txtPlaca.setEditable(false);
		 	this.txtNomSocio.setEditable(false);
		 	this.txtNroSocio.setEditable(false);
		 	this.cmbMarca.setEnabled(false);
		 	this.txtSerial.setEditable(false);
		 	this.txtAnno.setEditable(false);
		 	this.txtNroPuestos.setEditable(false);
		 	this.btnAgregar.setVisible(false);
		}


		public void regresar(){

			this.btnAgregar.setVisible(true);
			this.btnModificar.setVisible(false);
			this.txtPlaca.setEditable(true);
		 	this.txtSerial.setEditable(true);
		 	this.cmbMarca.setEnabled(true);
		 	this.txtAnno.setEditable(true);
		 	this.txtNroPuestos.setEditable(true);
			this.txtNomSocio.setEditable(true);
		 	this.txtNroSocio.setEditable(true);
			
		}
		
		
		public boolean CamposllenosSocio() {

			boolean CamposLLenos = false;

			if (this.txtNroSocio.getText().equals("")) {
				// si falta el nro socio
				JOptionPane.showMessageDialog(null, "Debe ingresar el numero del socio",
						"Error", 0);
				this.txtNroSocio.requestFocus();
				CamposLLenos = false;
			} else if (this.txtNomSocio.equals("")) {
				// si falta el nombre del socio
				JOptionPane.showMessageDialog(null,
						"Debe ingresar el nombre del socio", "Error", 0);
				this.txtNomSocio.requestFocus();
				CamposLLenos = false;
			} else {
				// sino falta nada
				CamposLLenos = true;
			}
			// retornamos el valor de la validaci�n
			return CamposLLenos;
		}
		
	public boolean CamposllenosVehiculo() {

		boolean CamposLLenos = false;

		if (this.txtPlaca.getText().equals("")) {
			// si falta la placa
			JOptionPane.showMessageDialog(null, "Debe ingresar una placa",
					"Error", 0);
			this.txtPlaca.requestFocus();
			CamposLLenos = false;
		} else if (this.txtSerial.getText().equals("")) {
			// si falta el serial
			JOptionPane.showMessageDialog(null,
					"Debe ingresar el serial de la carrocer�a", "Error", 0);
			this.txtSerial.requestFocus();
			CamposLLenos = false;
		} else if (this.cmbMarca.getSelectedItem().toString().equals("Seleccionar opci�n")) {
			// si falta la marca
			JOptionPane.showMessageDialog(null, "Debe ingresar la marca",
					"Error", 0);
			this.cmbMarca.requestFocus();
			CamposLLenos = false;
		} else if (this.txtAnno.getText().equals("")) {
			// si falta el a�o
			JOptionPane.showMessageDialog(null, "Debe ingresar el a�o del veh�culo",
					"Error", 0);
			this.txtAnno.requestFocus();
			CamposLLenos = false;
		} else if (this.txtNroPuestos.getText().equals("")) {
			// si falta el a�o
			JOptionPane.showMessageDialog(null, "Debe ingresar el n�mero de puestos del veh�culo",
					"Error", 0);
			this.txtNroPuestos.requestFocus();
			CamposLLenos = false;
		} else if (this.cmbConductor.getSelectedItem().toString().equals("Seleccionar opci�n")) {
			// si falta la marca
			JOptionPane.showMessageDialog(null, "Debe ingresar el conductor del vehiculo",
					"Error", 0);
			this.cmbConductor.requestFocus();
			CamposLLenos = false;
			}
			else {
			// sino falta nada
			CamposLLenos = true;
		}
		// retornamos el valor de la validaci�n
		return CamposLLenos;
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
	
		//**Retorna la marca del vehiculo*//*
	    public int getCmbMarca(){
	    	return cmbMarca.getSelectedIndex()-1;
	    }
	    //**Asigna la marca del vehiculo*//*
	    public void setCmbMarca(int i){
	    	cmbMarca.setSelectedIndex(i);
	    }
	    
	    public void setCmbMarcaP(String marca) {
	    	cmbMarca.setSelectedItem(marca);
	    	//cmbConductor.setSelectedItem(marca);
	    }
	    
	    public void setCmbConductorP(String conductor) {
	    	System.out.println("cmb"+conductor);
	    	cmbConductor.setSelectedItem(conductor);
	    	System.out.println(cmbConductor.getSelectedItem());
	    }
	  
	    
	    //**Retorna el conductor*//*
	    public String getCmbConductor(){
	    	return cmbConductor.getSelectedItem().toString();
	    }
	    //Retorna la posicion del conductor en el combo
	    public int getCmbConductorInt(){
	    	return cmbConductor.getSelectedIndex();
	    }
	    public void setCmbConductor(int i){
	    	cmbConductor.setSelectedIndex(i);
	    }
	 
	    public void eliminarConductorCombo(){
	    	//this.setCmbConductor("Seleccione una opci�n");
	    	cmbConductor.removeItemAt(cmbConductor.getSelectedIndex());
	    }
		
		public void agregarItem(ItemListener item) {
			cmbMarca.addItemListener(item);	
		}
		
		public void LlenarComboMarca() throws Exception{
			for(int i=0; i < marcaDao.obtenerTodos().size();i++)
					this.cmbMarca.addItem(marcaDao.obtenerTodos().get(i).getDescripcion());
			}
		
		public void LlenarComboAvance() throws Exception{
			for(int i=0; i < avanceDao.obtenerTodos().size();i++) {
					this.cmbConductor.addItem(avanceDao.obtenerTodos().get(i).getNombre());
			}	
		}
		
		
		/*public void eliminarConductores() throws Exception {
			
			VehiculoDao vehiculoDao = new VehiculoDao();
			String este = null;
			for(int i=0; i<vehiculoDao.obtenerTodos().size(); i++) {
				
			if (vehiculoDao.encontrarPorSocio(this.getTxtNroSocio()))
		 		este = vehiculoDao.obtenerTodos().get(i).getAvance();
		 	//	boolean aqui = avanceDao.encontrar(este);
		 		avanceDao.buscarPorCodAvance(este);
		 		int fila= tblListadoVehiculo.getRowCount();
		 		for(int j=0; j<fila;j++){
		 			String f = (String)this.tblListadoVehiculo.getValueAt(j, 5).equals(vehiculoDao.encontrarPorSocio);
		 			
		 		}
		 		
	    	cmbConductor.removeItemAt(cmbConductor.getSelectedIndex());
		    //  cmbConductor.removeItem(este);
			}
	    }*/
		
	
		public int RemoverVehiculo() {
			int selec = tblListadoVehiculo.getSelectedRow();
		    	return selec;
		}	
		
		public int filaSeleccionada(){
		//	return tblListadoVehiculo.getSelectedRow()+1;
			return tblListadoVehiculo.getSelectedColumn()+1;
		}
		
		public void agregarFila(String placa, String serial, String marca,
				String a�o,String nroPuestos, String avance /*String codAvance AQUII NECESITO PASARLE AL CONDUCTOR*/)
		{
			Vector<String> vehiculo = new Vector<String>();

			vehiculo.add(placa);
			vehiculo.add(serial);
			vehiculo.add(marca);
			vehiculo.add(a�o);
			vehiculo.add(nroPuestos);
			vehiculo.add(avance);
			//this.eliminarConductorCombo();
			
			DefaultTableModel dtm = (DefaultTableModel) tblListadoVehiculo.getModel();
			dtm.addRow(vehiculo);
		}
		
		// Limpiar Tabla Avances
		public void limpiarTablaVehiculos() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] {  "Placa", "Serial", "Marca", "A�o" , "Puestos", "Avance" },0);
		tblListadoVehiculo.setModel(tblListadoModel);

		}	
		
		public List<Vehiculo> LlenarListaVehiculos()
		 {
			int fila= tblListadoVehiculo.getRowCount();
			List<Vehiculo> a = new ArrayList<Vehiculo>();
			String placa,serial,marca,anno,puestos,avance;
			MarcaDao md= new MarcaDao();
			
			for(int i=0; i<fila;i++)
			{		
					Vehiculo veh= new Vehiculo();
					
					placa=(String) tblListadoVehiculo.getValueAt(i, 0);
					serial=(String) tblListadoVehiculo.getValueAt(i, 1);
					marca=(String) tblListadoVehiculo.getValueAt(i, 2);
					anno=(String) tblListadoVehiculo.getValueAt(i, 3);
					puestos=(String) tblListadoVehiculo.getValueAt(i, 4);
					avance=(String) tblListadoVehiculo.getValueAt(i, 5);
								
					veh.setPlaca(placa);
					veh.setSerialCarroceria(serial);
					
					//Setear la marca
					try {
						for(int j=0; j<md.obtenerTodos().size();j++)
						{
							//if(veh.getCodMarca().getDescripcion().equals(marca))
							if(md.obtenerTodos().get(j).getDescripcion().equalsIgnoreCase(marca))
								veh.setMarca(md.obtenerTodos().get(j));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					veh.setAnno(Integer.parseInt(anno));
					veh.setNropuestos(Integer.parseInt(puestos));				
					veh.setAvance(avance);
					
					a.add(veh);		
			}
		
		return a;
	}
		 
		public String Nombre() {
			String avan="";
			 VistaArrendatario vA = new VistaArrendatario();
				if(vA.Selec()==2)
					avan = this.getCmbConductor();
				return avan;
		}
		
		 
		 
		 public List<VehiculoArrendatario> LlenarListaVehiculosArren()
		 {
			int fila= tblListadoVehiculo.getRowCount();
			List<VehiculoArrendatario> v = new ArrayList<VehiculoArrendatario>();
			String placa,serial,marca,anno,puestos,avance;
			MarcaDao md= new MarcaDao();
			
			for(int i=0; i<fila;i++)
			{		
					VehiculoArrendatario veh= new VehiculoArrendatario();
					
					placa=(String) tblListadoVehiculo.getValueAt(i, 0);
					serial=(String) tblListadoVehiculo.getValueAt(i, 1);
					marca=(String) tblListadoVehiculo.getValueAt(i, 2);
					anno=(String) tblListadoVehiculo.getValueAt(i, 3);
					puestos=(String) tblListadoVehiculo.getValueAt(i, 4);
					avance=(String) tblListadoVehiculo.getValueAt(i, 5);
								
					veh.setPlaca(placa);
					veh.setSerialCarroceria(serial);
					//Setear la marca
					try {
						for(int j=0; j<md.obtenerTodos().size();j++)
						{
							if(md.obtenerTodos().get(j).getDescripcion().equalsIgnoreCase(marca))
								veh.setCodMarca(md.obtenerTodos().get(j));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					veh.setAnno(Integer.parseInt(anno));
					veh.setNropuestos(Integer.parseInt(puestos));
					veh.setAvance(avance);
					v.add(veh);		
			}
		
		return v;
	}
					
				/*	 VistaArrendatario vA = new VistaArrendatario();
					 //	String avan="";
						if(vA.Selec()==2) 
							veh.setAvance(getCmbConductor());
						
						else {
				
							for(int j=0; j< va.LlenarListaAvancesArren().size();j++)
							{
								if((va.LlenarListaAvancesArren().get(i).getNombre()+" "+
										va.LlenarListaAvancesArren().get(i).getApellido()).equals(avance));
								veh.setAvance(va.LlenarListaAvancesArren().get(i).getNombre()+" "+
										va.LlenarListaAvancesArren().get(i).getApellido());
							}
					
				}
					v.add(veh);		
			}
		
		return v;
	}
		 */
		 
		 private JPanel getJpImagen() {
			 if(jpImagen == null) {
				 jpImagen = new JPanel();
				 jpImagen.setBounds(2, 0, 721, 58);
				 jpImagen.setBackground(new java.awt.Color(255,255,255));
				 jpImagen.setLayout(null);
				 jpImagen.add(getLblImagen());
			 }
			 return jpImagen;
		 }
		 
		 private JLabel getLblImagen() {
			 if(lblImagen == null) {
				 lblImagen = new JLabel();
				 lblImagen.setBounds(5, 0, 242, 58);
				 lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			 }
			 return lblImagen;
		 }
		 
		 
		 public void MostarListado() {
				
			 	this.spListado.setVisible(true);
			 	this.tblListadoVehiculo.setVisible(true);
				this.btnEliminarVehiculo.setVisible(true);
				this.lblTexto.setVisible(false);
			}
		 
		 public void OcultarListado(List<Vehiculo> listVehiculo) throws Exception {
				if(listVehiculo.size() != 0) {
					
					this.jpVehiculoxSocio.setVisible(true);
					this.tblListadoVehiculo.setVisible(true);
					this.btnAgregar.setVisible(true);
					this.btnEliminarVehiculo.setVisible(true);
			
				}
				else {
					this.tblListadoVehiculo.setVisible(false);
					this.spListado.setVisible(false);
					this.lblTexto.setVisible(true);
					this.btnEliminarVehiculo.setVisible(false);
							
				}
			}
		 
		 public void CambiarNombrePanel(){
				jpVehiculoxSocio.setBorder(BorderFactory.createTitledBorder("Listado de Vehiculo por Arrendatario"));
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
				btnGuardar.setActionCommand("GuardarArrendatario");
				btnBusSocio.setActionCommand("BuscarArrendatario");
				btnAgregar.setActionCommand("AgregarVehiculoArrend");
				lblNroSocio.setText("C�digo");
				btnRS.setText("Registrar Arrendatario");
				txtNroSocio.setActionCommand("BArrendTecl");
				txtPlaca.setActionCommand("BVehArrenTecl");

				//btnRS.setActionCommand("RS");
				
				
			}
		 
		 public void agregarKeyTel(KeyListener a) {
				txtNroSocio.addKeyListener(a);
				txtNroPuestos.addKeyListener(a);
				txtAnno.addKeyListener(a);
			}
		 
		 private JButton getBtnModificar() {
			 if(btnModificar == null) {
				 btnModificar = new JButton();
				 btnModificar.setText("Modificar");
				 btnModificar.setBounds(80, 209, 147, 24);
				 btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Modify.png")));
			 }
			 return btnModificar;
		 }

}

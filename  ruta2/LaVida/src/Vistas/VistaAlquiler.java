package Vistas;


import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Controlador.ControladorInquilino;
import Modelos.Local;
import Modelos.Hibernate.Daos.AlquilerDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.LocalDao;


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
public class VistaAlquiler extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JPanel jpanelTitulo;
	private JLabel lblCodAlquiler;
	private JButton btnBuscar;
	private JLabel lblTitulo;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JTextField txtMontoCanon;
	private JLabel lblMonto;
	private JComboBox cmbNombreLocal;
	private JLabel lblNomLocal;
	private JDateChooser FechaFin;
	private JLabel lblFechaFin;
	private JDateChooser FechaIni;
	private JLabel lblFechaInicio;
	private JLabel lblImagen;
	private JButton btnCancelarVigi;
	private JButton btnCancelarCanon;
	private JButton btnModVigilancia;
	private JTextField txtGastosVigi;
	private JLabel lblVigilancia;
	private JTextField txtServicioGastosCom;
	private JLabel lblServiciosGastosCom;
	private JTextField txtNroTransaccion;
	private JLabel lblNroTrans;
	private JTextField txtMontoDeposito;
	private JLabel lblDeposito;
	private JButton btnModCanon;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroupTipo;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JRadioButton rbtnTipoJuridico;
	private JRadioButton rbtnTipoNatural;
	private JLabel lblTipoInquilino;
	private ButtonGroup btnGTipoNatural;
	private JButton btnBuscarInq;
	private JTextField txtCedRifInq;
	private JLabel lblCedRifInqui;
	private JPanel jPanelInquilino;
	private JTextField txtCodAlquiler;
	private JPanel jPanelVentana;

	//Mis datos
	private LocalDao dao=new LocalDao();
	private InquilinoDao daoInq= new InquilinoDao();
	private AlquilerDao daoAlq=new AlquilerDao();
	private IngresosDao daoIngreso= new IngresosDao();

	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaAlquiler inst = new VistaAlquiler();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
				
			}
		});
	}
	
	private static VistaAlquiler vAlquiler = null;
	private static VistaInquilino vInquilino= null;

	public static VistaAlquiler obtenerInstancia(){
		if (vAlquiler == null)
			vAlquiler = new VistaAlquiler();
		return vAlquiler;
	}
	
	public VistaAlquiler() {
		super();
		initGUI();
		try {
			this.GenerarCodigo();
			this.txtCodAlquiler.setEnabled(false);
			this.btnCancelarCanon.setVisible(false);
			this.btnCancelarVigi.setVisible(false);
			this.txtGastosVigi.setEnabled(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Registrar Alquiler");
			getContentPane().setLayout(null);
			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("Salir");
				btnSalir.setBounds(336, 400, 113, 29);
				btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
			}
			{
				jPanelVentana = new JPanel();
				getContentPane().add(jPanelVentana);
				jPanelVentana.setBounds(12, 159, 487, 235);
				jPanelVentana.setBorder(BorderFactory.createTitledBorder("Datos del Alquiler"));
				jPanelVentana.setAutoscrolls(true);
				jPanelVentana.setLayout(null);
				{
					lblCodAlquiler = new JLabel();
					jPanelVentana.add(lblCodAlquiler);
					lblCodAlquiler.setText("Código del Alquiler");
					lblCodAlquiler.setBounds(17, 32, 104, 16);
				}
				{
					txtCodAlquiler = new JTextField();
					jPanelVentana.add(txtCodAlquiler);
					txtCodAlquiler.setBounds(134, 28, 86, 22);
				}
				{
					lblFechaInicio = new JLabel();
					jPanelVentana.add(lblFechaInicio);
					lblFechaInicio.setText("Fecha Inicio: ");
					lblFechaInicio.setBounds(16, 91, 107, 20);
				}
				{
					FechaIni = new JDateChooser(new Date(),"DD/MM/YYYY");
					jPanelVentana.add(FechaIni);
					FechaIni.setBounds(87, 90, 146, 23);
					FechaIni.setDateFormatString("XX/XX/XXXX");
					FechaIni.setLocale(Locale.getDefault());
				}
				{
					lblFechaFin = new JLabel();
					jPanelVentana.add(lblFechaFin);
					lblFechaFin.setText("Fecha Fin:");
					lblFechaFin.setBounds(246, 93, 61, 16);
				}
				{
					FechaFin = new JDateChooser(new Date(),"DD/MM/YYYY");
					jPanelVentana.add(FechaFin);
					FechaFin.setBounds(311, 89, 147, 23);
					FechaFin.setDateFormatString("XX/XX/XXXX");
					FechaFin.setLocale(Locale.getDefault());
				}
				{
					lblNomLocal = new JLabel();
					jPanelVentana.add(lblNomLocal);
					lblNomLocal.setText("Nombre del Local: ");
					lblNomLocal.setBounds(17, 61, 104, 16);
				}
				{
					ComboBoxModel cmbNombreLocalModel = 
							new DefaultComboBoxModel(
									new String[] {"Seleccione una opción"});
					cmbNombreLocal = new JComboBox();
					jPanelVentana.add(cmbNombreLocal);
					cmbNombreLocal.setModel(cmbNombreLocalModel);
					cmbNombreLocal.setBounds(133, 58, 325, 23);
					cmbNombreLocal.addActionListener(new ActionListener() {	
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//InforSelecCombo(e);
							//CargarMontoVigilancia();	
							
						}
					});
					
					cmbNombreLocal.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							System.out.println("evento click");
							InforSelecCombo(e);
							CargarMontoVigilancia();
						}
					});
				}
				{
					lblMonto = new JLabel();
					jPanelVentana.add(lblMonto);
					lblMonto.setText("Canón de Arrendamiento: ");
					lblMonto.setBounds(17, 124, 152, 16);
				}
				{
					txtMontoCanon = new JTextField();
					jPanelVentana.add(txtMontoCanon);
					txtMontoCanon.setBounds(169, 120, 235, 23);
					txtMontoCanon.setEnabled(false);
				}
				{
					btnBuscar = new JButton();
					jPanelVentana.add(btnBuscar);
					jPanelVentana.add(getBtnModCanon());
					jPanelVentana.add(getLblDeposito());
					jPanelVentana.add(getTxtMontoDeposito());
					jPanelVentana.add(getLblNroTrans());
					jPanelVentana.add(getTxtNroTransaccion());
					jPanelVentana.add(getLblServiciosGastosCom());
					jPanelVentana.add(getTxtServicioGastosCom());
					jPanelVentana.add(getLblVigilancia());
					jPanelVentana.add(getTxtGastosVigi());
					jPanelVentana.add(getBtnModVigilancia());
					jPanelVentana.add(getBtnCancelarCanon());
					jPanelVentana.add(getBtnCancelarVigi());
					btnBuscar.setText("");
					btnBuscar.setBounds(227, 27, 35, 23);
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
				}
			}
			{
				jpanelTitulo = new JPanel();
				getContentPane().add(jpanelTitulo);
				jpanelTitulo.setLayout(null);
				jpanelTitulo.setBounds(12, 4, 487, 70);
				jpanelTitulo.setBorder(BorderFactory.createTitledBorder(""));
				jpanelTitulo.setBackground(new java.awt.Color(255,255,255));
				{
					lblTitulo = new JLabel();
					jpanelTitulo.add(lblTitulo);
					jpanelTitulo.add(getLblImagen());
					lblTitulo.setText("Registrar Alquiler");
					lblTitulo.setBounds(208, 21, 159, 24);
					lblTitulo.setFont(new java.awt.Font("Century Gothic",2,18));
					lblTitulo.setBackground(new java.awt.Color(0,64,128));
					
				}
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setBounds(70, 400, 113, 29);
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				getContentPane().add(getJPanelInquilino());
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(203, 400, 116, 29);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
			}
			pack();
			this.setSize(527, 479);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private JPanel getJPanelInquilino() {
		if(jPanelInquilino == null) {
			jPanelInquilino = new JPanel();
			jPanelInquilino.setBounds(12, 74, 487, 83);
			jPanelInquilino.setLayout(null);
			jPanelInquilino.setBorder(BorderFactory.createTitledBorder("Datos del inquilino"));
			jPanelInquilino.add(getLblCedRifInqui());
			jPanelInquilino.add(getTxtCedRifInq());
			jPanelInquilino.add(getBtnBuscarInq());
			jPanelInquilino.add(getLblTipoInquilino());
			jPanelInquilino.add(getRbtnTipoNatural());
			jPanelInquilino.add(getRbtnTipoJuridico());
			jPanelInquilino.add(getLblNombre());
			jPanelInquilino.add(getTxtNombre());
		}
		return jPanelInquilino;
	}
	
	private JLabel getLblCedRifInqui() {
		if(lblCedRifInqui == null) {
			lblCedRifInqui = new JLabel();
			lblCedRifInqui.setText("Cédula o Rif:");
			lblCedRifInqui.setBounds(239, 20, 74, 16);
		}
		return lblCedRifInqui;
	}
	
	private JTextField getTxtCedRifInq() {
		if(txtCedRifInq == null) {
			txtCedRifInq = new JTextField();
			txtCedRifInq.setBounds(317, 16, 103, 23);
			
			//txtCedRifInq.addKeyListener();
			txtCedRifInq.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						BuscarInquilino();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return txtCedRifInq;
	}
	
	public String getCedRif(){
		return this.txtCedRifInq.getText();
	}
	
	public JButton getBtnBuscarInq() {
		if(btnBuscarInq == null) {
			btnBuscarInq = new JButton();
			btnBuscarInq.setBounds(426, 17, 35, 23);
			btnBuscarInq.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
			btnBuscarInq.setActionCommand("BuscarInq");
		}
		btnBuscarInq.setActionCommand("BuscarInq");
		return btnBuscarInq;
	}
	
	private ButtonGroup getBtnGTipoNatural() {
		if(btnGTipoNatural == null) {
			btnGTipoNatural = new ButtonGroup();
		}
		return btnGTipoNatural;
	}
	
	private JLabel getLblTipoInquilino() {
		if(lblTipoInquilino == null) {
			lblTipoInquilino = new JLabel();
			lblTipoInquilino.setText("Tipo de Persona:");
			lblTipoInquilino.setBounds(6, 19, 92, 16);
		}
		return lblTipoInquilino;
	}
	
	private JRadioButton getRbtnTipoNatural() {
		if(rbtnTipoNatural == null) {
			rbtnTipoNatural = new JRadioButton();
			rbtnTipoNatural.setText("Natural");
			rbtnTipoNatural.setBounds(102, 18, 71, 20);
			getButtonGroupTipo().add(rbtnTipoNatural);
			rbtnTipoNatural.setContentAreaFilled(false);
		}
		return rbtnTipoNatural;
	}
	
	private JRadioButton getRbtnTipoJuridico() {
		if(rbtnTipoJuridico == null) {
			rbtnTipoJuridico = new JRadioButton();
			rbtnTipoJuridico.setText("Jurídica");
			rbtnTipoJuridico.setBounds(173, 18, 73, 20);
			getButtonGroupTipo().add(rbtnTipoJuridico);
			rbtnTipoJuridico.setContentAreaFilled(false);
			getButtonGroupTipo().add(rbtnTipoJuridico);
			
		}
		return rbtnTipoJuridico;
	}
	
	private JLabel getLblNombre() {
		if(lblNombre == null) {
			lblNombre = new JLabel();
			lblNombre.setText("Nombre y Apellido:");
			lblNombre.setBounds(8, 48, 127, 16);
		}
		return lblNombre;
	}
	
	private JTextField getTxtNombre() {
		if(txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(117, 45, 346, 23);
		}
		return txtNombre;
	}
	
	private JButton getBtnModCanon() {
		if(btnModCanon == null) {
			btnModCanon = new JButton();
			btnModCanon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Modify.png")));
			btnModCanon.setBounds(407, 120, 30, 23);
			btnModCanon.setActionCommand("ModificarCanon");
		}
		return btnModCanon;
	}
	
	private JLabel getLblDeposito() {
		if(lblDeposito == null) {
			lblDeposito = new JLabel();
			lblDeposito.setText("Monto Deposito: ");
			lblDeposito.setBounds(17, 152, 106, 16);
		}
		return lblDeposito;
	}
	
	private JTextField getTxtMontoDeposito() {
		if(txtMontoDeposito == null) {
			txtMontoDeposito = new JTextField();
			txtMontoDeposito.setBounds(110, 149, 88, 23);
		}
		return txtMontoDeposito;
	}
	
	private JLabel getLblNroTrans() {
		if(lblNroTrans == null) {
			lblNroTrans = new JLabel();
			lblNroTrans.setText("Nº Transacción:");
			lblNroTrans.setBounds(213, 152, 88, 16);
		}
		return lblNroTrans;
	}
	
	private JTextField getTxtNroTransaccion() {
		if(txtNroTransaccion == null) {
			txtNroTransaccion = new JTextField();
			txtNroTransaccion.setBounds(306, 149, 152, 23);
		}
		return txtNroTransaccion;
	}
	
	private JLabel getLblServiciosGastosCom() {
		if(lblServiciosGastosCom == null) {
			lblServiciosGastosCom = new JLabel();
			lblServiciosGastosCom.setText("Servicio de Gastos Comunes:");
			lblServiciosGastosCom.setBounds(17, 180, 152, 16);
		}
		return lblServiciosGastosCom;
	}
	
	private JTextField getTxtServicioGastosCom() {
		if(txtServicioGastosCom == null) {
			txtServicioGastosCom = new JTextField();
			txtServicioGastosCom.setBounds(187, 177, 271, 23);
		}
		return txtServicioGastosCom;
	}
	
	private JLabel getLblVigilancia() {
		if(lblVigilancia == null) {
			lblVigilancia = new JLabel();
			lblVigilancia.setText("Gastos de Vigilancia:");
			lblVigilancia.setBounds(17, 208, 108, 16);
		}
		return lblVigilancia;
	}
	
	private JTextField getTxtGastosVigi() {
		if(txtGastosVigi == null) {
			txtGastosVigi = new JTextField();
			txtGastosVigi.setBounds(143, 205, 261, 23);
		}
		return txtGastosVigi;
	}
	
	private JButton getBtnModVigilancia() {
		if(btnModVigilancia == null) {
			btnModVigilancia = new JButton();
			btnModVigilancia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Modify.png")));
			btnModVigilancia.setBounds(408, 205, 30, 23);
			btnModVigilancia.setActionCommand("ModificarMontoVigi");
		}
		return btnModVigilancia;
	}
	

	private JButton getBtnCancelarCanon() {
		if(btnCancelarCanon == null) {
			btnCancelarCanon = new JButton();
			btnCancelarCanon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
			btnCancelarCanon.setBounds(440, 120, 25, 23);
			btnCancelarCanon.setActionCommand("CancelarCanon");
		}
		return btnCancelarCanon;
	}
	
	private JButton getBtnCancelarVigi() {
		if(btnCancelarVigi == null) {
			btnCancelarVigi = new JButton();
			btnCancelarVigi.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
			btnCancelarVigi.setBounds(439, 205, 27, 23);
			btnCancelarVigi.setActionCommand("CancelarVigi");
		}
		return btnCancelarVigi;
	}
	
	public String getTxtMontoCanon() {
		return txtMontoCanon.getText();
	}

	public void setTxtMontoCanon(String txtMonto) {
		txtMontoCanon.setText(txtMonto);
	}

    public JComboBox getCmbNombreLocal() {
		return cmbNombreLocal;
	}

    public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}
    
   public String getTxtNombreInqui() {
		return txtNombre.getText();
	}

    
	public void setCmbNombreLocal(JComboBox cmbNombreLocal) {
		this.cmbNombreLocal = cmbNombreLocal;
	}

	public Date getFechaIni(){
    	return FechaIni.getDate();
    }
   
    public void setFechaIni(Date fecha){
    	FechaIni.setDate(fecha);
    }
	public Date getFechaFin() {
		return FechaFin.getDate();
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin.setDate(fechaFin);;
	}

	public String getTxtCodAlquiler() {
		return txtCodAlquiler.getText();
	}

	public void setTxtCodAlquiler(String txtCodAlq) {
		txtCodAlquiler.setText(txtCodAlq);
	}
	
	public String getTxtMontoDepositoS(){
		return txtMontoDeposito.getText();
	}
	
	public String getTxtMontoVigi(){
		return txtGastosVigi.getText();
	}

	
	public void setTxtCedRifInq(String txtCedRifInq) {
		this.txtCedRifInq.setText(txtCedRifInq);;
	}
	
	public String getTxtCedRifInqui(){
		return this.txtCedRifInq.getText();
	}

	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnSalir.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		this.btnBuscarInq.addActionListener(accion);
		this.btnModCanon.addActionListener(accion);
		this.btnModVigilancia.addActionListener(accion);
		this.btnCancelarCanon.addActionListener(accion);
		this.btnCancelarVigi.addActionListener(accion);
	}
		// limpia todos los campos de la ventana
		public void limpiarCampos() {
			txtMontoCanon.setText("");
			txtCodAlquiler.setText("");
			cmbNombreLocal.setSelectedIndex(0);
			FechaFin.setDate(new Date());
			FechaIni.setDate(new Date());
			txtCedRifInq.setText("");
			txtNombre.setText("");
			rbtnTipoJuridico.setEnabled(true);
			rbtnTipoNatural.setEnabled(true);
			txtGastosVigi.setText("");
			txtMontoDeposito.setText("");
			txtNroTransaccion.setText("");
			txtServicioGastosCom.setText("");
			try {
				this.GenerarCodigo();
				this.EliminarDatosCombo();
				this.LlenarCombos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void Bloquear() {
			this.txtCedRifInq.setEditable(false);
			this.txtNombre.setEditable(false);
			
		}
		
		
		// cerrar Ventana
		public void cerrarVentana() {
			// TODO Auto-generated method stub
			int ValorDevuelto = JOptionPane.showConfirmDialog(null,
					"¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
			if (ValorDevuelto == 0) {
				this.limpiarCampos();
				this.dispose();
			}
		}
		
		//Validar las fechas
		public int validarFechas(){		
			if(FechaIni.getDate().equals(getFechaFin()))
			{
				if(FechaIni.getDate().getMonth()==FechaIni.getDate().getDay()
						|| FechaIni.getDate().getDay()==FechaFin.getDate().getDay() || 
						FechaIni.getDate().getYear()==FechaFin.getDate().getYear())
					return 1;
			}else
			if(FechaIni.getDate().after(FechaFin.getDate()))
			{
				return 2;
			}else if(FechaIni.getDate().before(FechaFin.getDate())){
				return 3;
			} 
			  return 0;
			}
	
		//Vaciar todos los datos del combo para llenarlo con la infor
		//actualizada del status del local
		
		public void EliminarDatosCombo(){
			DefaultComboBoxModel model = (DefaultComboBoxModel) cmbNombreLocal.getModel();
			model.removeAllElements();
			cmbNombreLocal.addItem("Seleccione una opción");
		}

		//Llenar los combos
		
		public void LlenarCombos() throws Exception{
			List<String> locales= new ArrayList<>();
			
			for(int i=0; i<dao.obtenerTodos().size();i++){
		
				if(dao.obtenerTodos().get(i).getStatus().equals("Disponible")){
						//this.cmbNombreLocal.addItem(dao.obtenerTodos().get(i).getNombre());
					locales.add(dao.obtenerTodos().get(i).getNombre());
					}
			}
			HashSet<String> hashSet = new HashSet<String>(locales);
			locales.clear();
			locales.addAll(hashSet);
		
			for(String cadena :locales){
				System.out.println(cadena);
				this.cmbNombreLocal.addItem(cadena);
			}
		}
		
		public void GenerarCodigo() throws Exception
		{
			int cantAlquileres= daoAlq.obtenerTodos().size()+1;
			if(cantAlquileres<10)
			{
				this.setTxtCodAlquiler("A000"+cantAlquileres);
			}else if(cantAlquileres<100){
				this.setTxtCodAlquiler("A00"+cantAlquileres);
			}else if(cantAlquileres<1000)
			{
				this.setTxtCodAlquiler("A0"+cantAlquileres);
			}
			else 
				this.setTxtCodAlquiler("A"+cantAlquileres);
		}
		
		private ButtonGroup getButtonGroupTipo() {
			if(buttonGroupTipo == null) {
				buttonGroupTipo = new ButtonGroup();
			}
			return buttonGroupTipo;
		}
		
		public void BuscarInquilino() throws Exception
		{
			boolean encontro=false;
			boolean natural= false;
			boolean juridico=false;
			if(this.txtCedRifInq.getText()!=null || this.rbtnTipoNatural.isSelected())
			{
				for(int i=0; i<daoInq.obtenerTodos().size();i++){
					if(daoInq.obtenerTodos().get(i).getCedula().equals(txtCedRifInq.getText()))
					{
						this.txtNombre.setEnabled(false);
						this.txtNombre.setText(daoInq.obtenerTodos().get(i).getNombre()+" "+daoInq.obtenerTodos().get(i).getApellido());
						this.rbtnTipoJuridico.setEnabled(false);
						this.rbtnTipoNatural.setEnabled(false);
						this.rbtnTipoNatural.setSelected(true);
						encontro=true;
						natural=true;
					}else if(daoInq.obtenerTodos().get(i).getRif().equals(txtCedRifInq.getText()))
						{
							this.txtNombre.setText(daoInq.obtenerTodos().get(i).getNombre());
							this.txtNombre.setEnabled(false);
							this.rbtnTipoJuridico.setEnabled(false);
							this.rbtnTipoNatural.setEnabled(false);
							this.rbtnTipoJuridico.setSelected(true);
							encontro=true;
							juridico=true;
						}
				}			
				if(encontro==false)
				{
					if(this.txtCedRifInq.getText().equals("") || (this.rbtnTipoNatural.isSelected()==true
							&& this.rbtnTipoJuridico.isSelected()==true)){
						JOptionPane.showMessageDialog(null,"Introduzca la informacíon que desea buscar","Atencion!",
								JOptionPane.ERROR_MESSAGE);
					}else{
					int ValorDevuelto = JOptionPane.showConfirmDialog(null,
							"Este inquilino no existe, ¿Desea registrarlo?", "Advertencia", JOptionPane.YES_NO_OPTION);
						this.txtNombre.setText("");
					if (ValorDevuelto == 0) {
						this.dispose();
						ControladorInquilino contro= new ControladorInquilino(vAlquiler);
						vInquilino.obtenerInstancia();
					}
					}
				}
			}
		}
		
		
		
	/*	for ( Enumeration e=buttonGroup1.getElements();  e.hasMoreElements(); ) { 
		    JRadioButton b = (JRadioButton)e.nextElement(); 
		    ButtonModel modelo = b.getModel(); 
		    buttonGroup1.setSelected(modelo, false)  
		};*/
		 
		
		//El actionlistener del combo esta en la declaracion arriba :S
		//Esto es para que cuando seleccione una opcion del combo llene 
		//los campos de la vista :D
		public void InforSelecCombo(MouseEvent ae){
			Local loc = new Local();
			boolean enc=false;
			this.txtServicioGastosCom.setEnabled(false);
			if(this.cmbNombreLocal.getSelectedIndex()==0){
				this.txtMontoCanon.setText("");
				this.txtServicioGastosCom.setText("");
				this.txtGastosVigi.setText("");
			}else 
			{
				try {
					for(int i=0; i<dao.obtenerTodos().size();i++)
					{				
					 	
					 if(dao.obtenerTodos().get(i).getNombre().equals(cmbNombreLocal.getSelectedItem().toString()))
					 {
						 loc = dao.obtenerTodos().get(i);
						 enc=true;
					 }
					 } 
					 	if(enc==true)
					 	{
					  	String canon= Float.toString(loc.getCanon());
					  	this.txtMontoCanon.setText(canon);
					  	float monto= (float) (loc.getCanon()*0.25);
					  	String servi= Float.toString(monto);
					  	this.txtServicioGastosCom.setText(servi);
					  	}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public boolean DevolverTipo(){
			if(rbtnTipoNatural.isSelected())
			{
				return true;
			}else
				return false;
		}
		
		public void DesbloquearCanon(){
			this.btnCancelarCanon.setVisible(true);
			this.txtMontoCanon.setEnabled(true);
			this.txtMontoCanon.setEditable(true);
			this.btnModCanon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/check.png")));
			this.btnModCanon.setActionCommand("GuardarModCanon");
		}
		
		public void BotonGuardar(){
			this.btnModCanon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Modify.png")));
			this.btnModCanon.setActionCommand("ModificarCanon");
			this.btnCancelarCanon.setVisible(false);
			this.txtMontoCanon.setEnabled(false);
		}
		
		public void DesbloquearMontoVigi(){
			this.btnCancelarVigi.setVisible(true);
			this.txtGastosVigi.setEnabled(true);
			this.btnModVigilancia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/check.png")));
			this.btnModVigilancia.setActionCommand("GuardarVigi");
		}
		
		public void GuardarMontoVigi(){
			this.btnModVigilancia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Modify.png")));
			this.btnModVigilancia.setActionCommand("ModificarMontoVigi");
			this.txtGastosVigi.setEnabled(false);
			this.btnCancelarVigi.setVisible(false);
		}
		
		public void ActualizarValores(){
			this.txtMontoCanon.setEnabled(false);
			  float canon= Float.parseFloat(txtMontoCanon.getText());
			  float monto= (float) (canon*0.25);
			  String servi= Float.toString(monto);
			  this.txtServicioGastosCom.setText(servi);
		}
		
		public void CargarMontoVigilancia(){
			try {
				for(int i=0; i< daoIngreso.obtenerTodos().size();i++){
					String tipo= daoIngreso.obtenerTodos().get(i).getClasifIngreso();
					if(tipo.equals("Alquiler")){
						if(daoIngreso.obtenerTodos().get(i).getDescripcion().equals("Vigilancia"))
						{
							this.txtGastosVigi.setText(Float.toString(daoIngreso.obtenerTodos().get(i).getMonto()));
						}
					}}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		public void agregarKey(KeyListener a) {
			txtGastosVigi.addKeyListener(a);
			txtMontoCanon.addKeyListener(a);
			txtMontoDeposito.addKeyListener(a);
			txtCedRifInq.addKeyListener(a);
			txtNombre.addKeyListener(a);
		}
		
		public void agregarMouse(MouseListener m){
			txtGastosVigi.addMouseListener(m);
			txtMontoCanon.addMouseListener(m);
			txtMontoDeposito.addMouseListener(m);
		}
		
		private JLabel getLblImagen() {
			if(lblImagen == null) {
				lblImagen = new JLabel();
				lblImagen.setBounds(2, 2, 483, 68);
				lblImagen.setBackground(new java.awt.Color(255,255,255));
				lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			}
			return lblImagen;
		}	
				
		
		
		public void ValidarCampos(){
			if(getTxtCodAlquiler().equals("") ||
					getTxtMontoCanon().equals("")){	
				JOptionPane.showMessageDialog(null,"Asegúrese que no hayan campos vacios","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			} 
			if(getTxtCedRifInqui().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Debe buscar un inquilino","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}
			if(validarFechas()==1)
			{
				JOptionPane.showMessageDialog(null,"Las fechas deben ser diferentes","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}else if(validarFechas()==2)
			{
				JOptionPane.showMessageDialog(null,"La fecha fin del contrato, "
						+ "debe ser mayor que la fecha de inicio","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
}

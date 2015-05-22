package Vistas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingUtilities;

import Modelos.Arrendatario;
import Modelos.Deuda;
import Modelos.Egresos;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Prestamos;
import Modelos.Socio;
import Modelos.Hibernate.Daos.EgresosDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.PrestamosDao;
import Modelos.Hibernate.Daos.SubsidioDao;

import com.jgoodies.common.collect.LinkedListModel;
//import com.jgoodies.forms.layout.FormLayout;

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

public class VistaFac extends javax.swing.JFrame {

	private JPanel jPanelVentana;
	private JPanel jPanelTitulo;
	private JPanel jPanelContenido;
	private JScrollPane jScrollPaneFactura;
	private JScrollPane jScrollPrestFactura;
	private JLabel lblNroFactura;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JButton btnBuscarCedSoc;
	private JTextField txtCedulaSocio;
	private JLabel lblCedSocio;
	private JTextField txtEfectivo;
	private JButton btnAnnadirPrestamo;
	private JTable jTableDeudasPorSocio;
	private JButton btnAnnadirDeuda;
	private JScrollPane deudasSocio;
	private JPanel jPanelDeudasSocio;
	private JTextField txtMontoDisp;
	private JLabel lblMontoDispo;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JLabel lblPendiente;
	private JLabel lblPrestamos;
	private JLabel lblModulo;
	private JTextField txtCheque;
	private JTextField txtTransferencia;
	private JTextField txtDeposito;
	private JTextField txtSubsidio;
	
	private JCheckBox checkCheque;
	private JCheckBox checkTransferencia;
	private JCheckBox checkDeposito;
	private JCheckBox checkSubsidio;
	private JCheckBox checkEfectivo;
	private JLabel lblCantidad;
	private JSpinner jSpinnerCantidad;
	private JComboBox cmbTipoFacturado;
	private JLabel lblTipoFacturado;
	private JLabel lblLogo;
	private JComboBox cmbTipoFactu;
	private JLabel lblTipoFact;
	private JTextField txtResponsableFactura;
	private JLabel lblResponsable;
	private JTextField txtNroFactura;
	private JButton btnQuitar;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnProcesar;
	private JPanel jPanelFormaPago;
	private JTextField txtMontoTotal;
	private JToggleButton jToggleButton1;
	private JButton btnanadir;
	private JTable jTableIngresosXFactura;
	private JTable jTablePrestamosXFactura;
	
	private JPanel jPanelInfFactura;
	private JLabel lblMontoAbonar;
	private JTextField txtMontoAdeudado;
	private JLabel lblMontoAdeudado;
	
	private JScrollPane jScrollingresos;
	private JList jListIngresos;
	private JLabel lblNombreSocio;
	private JTextField txtNombSocio;
	//private JTextField txtMontoAbonar;
	private JLabel lblNombIngreso;
	private JPanel jPanelIngresos;
	private JButton btnBuscar;
	private JTextField txtNroSocio;
	private JLabel lblNroSocio;
	private JPanel jPanelDatosPersonales;
	private JLabel lblRif;
	private JLabel lblTitulo;
	private ButtonGroup buttonGroupFP;

	private JTextField txtMontoIngresoEgreso;
	private JLabel jLabelMontoIngresoEgreso;
	ArrayList<String> full_datos = new ArrayList<String>();

	static public String TIPO_DE_FACTURA_EGRESOS = "Egresos";	
	static public String OPCION_COMBO_SELECCIONE = "Seleccione....";	
	static public String TIPO_FACTURADO_SOCIO = "SOCIO";
	static public String TIPO_FACTURADO_INQUILINO = "INQUILINO";
	static public String TIPO_FACTURADO_ARRENDATARIO = "ARRENDATARIO";	
	static public String TIPO_DE_FACTURA_INGRESOS = "Ingresos";
	static public String TIPO_DE_FACTURA_PRESTAMOS = "Prestamos";
	private JList jListPrestamosPendientes;

	//Mis datos 
		private IngresosDao ingDao= new IngresosDao();
		private EgresosDao egDao= new EgresosDao();
		private SubsidioDao subDao= new SubsidioDao();
		LinkedListModel<String> listaModeloIngresoEgreso=new LinkedListModel<>();
		private DefaultTableModel defaultTableModelIngresoXfactura = new DefaultTableModel();
		LinkedListModel<String> listaModeloAux=new LinkedListModel<>();
		private String filaSeleccionada="";
		private String filaDeudaSelec="";
		private String filaMontoDeuda="";
		private ArrayList<Prestamos> listaPrestamos=new ArrayList<Prestamos>();
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaFac inst = new VistaFac();
				inst.setLocationRelativeTo(null);
			inst.setVisible(true);
			}
		});
	}
private static VistaFac vFactura=null;
	
	public static VistaFac obtenerInstancia(){
		if(vFactura==null)
			vFactura= new VistaFac();
		return vFactura;
	}
	
	public VistaFac() {
		super();
		initGUI();
	}

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Factura");
			{
				jPanelVentana = new JPanel();
				getContentPane().add(jPanelVentana, "Center");
				jPanelVentana.setBounds(0, 0, 965, 639);
				jPanelVentana.setLayout(null);
				jPanelVentana.setFocusable(false);
				{
					jPanelTitulo = new JPanel();
					jPanelVentana.add(jPanelTitulo);
					jPanelTitulo.setLayout(null);
					jPanelTitulo.setBounds(0, 0, 959, 85);
					jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
					{
						lblTitulo = new JLabel();
						jPanelTitulo.add(lblTitulo);
						lblTitulo.setText("SOCIEDAD CIVIL RUTA 2");
						lblTitulo.setBounds(18, 59, 194, 16);
						lblTitulo.setFont(new java.awt.Font("Century Gothic",3,12));
					}
					{
						lblRif = new JLabel();
						jPanelTitulo.add(lblRif);
						jPanelTitulo.add(getLblLogo());
						lblRif.setText("RIF J-306-902686");
						lblRif.setBounds(45, 71, 184, 16);
						lblRif.setFont(new java.awt.Font("Century Gothic",3,10));
					}
					{
						lblModulo = new JLabel();
						jPanelTitulo.add(lblModulo);
						jPanelTitulo.add(getLblLogo());
						lblModulo.setText("Modulo de Facturación");
						lblModulo.setBounds(306, 32, 380, 40);
						lblModulo.setFont(new java.awt.Font("Century Gothic",3,32));
					}
				}
				{
					jPanelContenido = new JPanel();
					jPanelVentana.add(jPanelContenido);
					jPanelContenido.setBounds(12, 88, 933, 552);
					jPanelContenido.setBorder(BorderFactory.createTitledBorder("Factura"));
					jPanelContenido.setLayout(null);
					{
						lblTipoFacturado = new JLabel();
						jPanelContenido.add(lblTipoFacturado);
						lblTipoFacturado.setText("Tipo:");
						lblTipoFacturado.setBounds(23, 46, 36, 16);
					}
					{
							ComboBoxModel cmbTipoFacturadoModel = 
									new DefaultComboBoxModel(
											new String[] { OPCION_COMBO_SELECCIONE,"Socio", "Inquilino", "Arrendatario" });
							cmbTipoFacturado = new JComboBox();
							jPanelContenido.add(cmbTipoFacturado);
							cmbTipoFacturado.setModel(cmbTipoFacturadoModel);
							cmbTipoFacturado.setBounds(81, 43, 365, 23);
							cmbTipoFacturado.setEditable(false);
							cmbTipoFacturado.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if(cmbTipoFacturado.getSelectedItem().toString().equalsIgnoreCase(TIPO_FACTURADO_INQUILINO)){
									lblNroSocio.setText("Rif Inquilino:");
									txtNroSocio.setText("");
									txtNroSocio.setEnabled(true);
									txtNroSocio.setEditable(true);
									btnBuscar.setEnabled(true);
									jPanelDatosPersonales.setBorder(BorderFactory.createTitledBorder("Datos del Inquilino"));
									btnAnnadirDeuda.setEnabled(false);
									jSpinnerCantidad.setVisible(false);
									lblCantidad.setVisible(false);
								
									
								}
								else if(cmbTipoFacturado.getSelectedItem().toString().equalsIgnoreCase(TIPO_FACTURADO_SOCIO)){
									lblNroSocio.setText("Código de Socio:");
									txtNroSocio.setText("");
									txtNroSocio.setEnabled(true);
									txtNroSocio.setEditable(true);
									btnBuscar.setEnabled(true);
									jPanelDatosPersonales.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
									jSpinnerCantidad.setVisible(true);
									lblCantidad.setVisible(true);
								}
								else if(cmbTipoFacturado.getSelectedItem().toString().equalsIgnoreCase(TIPO_FACTURADO_ARRENDATARIO)){
									lblNroSocio.setText("Código de Arrendatario:");
									txtNroSocio.setText("");
									txtNroSocio.setEnabled(false);
									txtNroSocio.setEditable(false);
									btnBuscar.setEnabled(false);
									jPanelDatosPersonales.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
									jSpinnerCantidad.setVisible(true);
									lblCantidad.setVisible(true);
									btnAnnadirDeuda.setEnabled(false);
								}

								
							}
						});
					}
					{
						jPanelDatosPersonales = new JPanel();
						jPanelContenido.add(jPanelDatosPersonales);
						jPanelDatosPersonales.setBounds(17, 69, 435, 130);
						jPanelDatosPersonales.setLayout(null);
						jPanelDatosPersonales.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
						{
							lblNombreSocio = new JLabel();
							jPanelDatosPersonales.add(lblNombreSocio);
							lblNombreSocio.setText("Nombre:");
							lblNombreSocio.setBounds(11, 74, 53, 16);
						}
						{
							txtNombSocio = new JTextField();
							jPanelDatosPersonales.add(txtNombSocio);
							txtNombSocio.setBounds(145, 71, 189, 23);
							txtNombSocio.setEnabled(false);
							txtNombSocio.setEditable(false);
							txtNombSocio.setOpaque(false);
						}
						{
							lblNroSocio = new JLabel();
							jPanelDatosPersonales.add(lblNroSocio);
							lblNroSocio.setText("Número de Socio:");
							lblNroSocio.setBounds(12, 21, 122, 16);
						}
						{
							txtNroSocio = new JTextField();
							jPanelDatosPersonales.add(txtNroSocio);
							txtNroSocio.setBounds(146, 18, 72, 23);
							txtNroSocio.setActionCommand("BuscarXNroSocio");
						}
						{
							lblCedSocio = new JLabel();
							jPanelDatosPersonales.add(lblCedSocio);
							lblCedSocio.setText("Cedula de Identidad:");
							lblCedSocio.setBounds(12, 47, 134, 16);
						}
						{
							txtCedulaSocio = new JTextField();
							jPanelDatosPersonales.add(txtCedulaSocio);
							txtCedulaSocio.setBounds(146, 44, 126, 23);
							txtCedulaSocio.setActionCommand("BuscarCedSocTeclado");
						}
						{
							btnBuscarCedSoc = new JButton();
							jPanelDatosPersonales.add(btnBuscarCedSoc);
							btnBuscarCedSoc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
							btnBuscarCedSoc.setBounds(278, 44, 30, 23);
							btnBuscarCedSoc.setActionCommand("BuscarCedula");
						}
						{
							lblApellido = new JLabel();
							jPanelDatosPersonales.add(lblApellido);
							lblApellido.setText("Apellido:");
							lblApellido.setBounds(11, 101, 103, 16);
						}
						{
							txtApellido = new JTextField();
							jPanelDatosPersonales.add(txtApellido);
							txtApellido.setBounds(145, 98, 189, 23);
							txtApellido.setEditable(false);
							txtApellido.setOpaque(false);
						}
						{
							btnBuscar = new JButton();
							jPanelDatosPersonales.add(btnBuscar);
							btnBuscar.setBounds(225, 18, 30, 23);
							btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
							btnBuscar.setActionCommand("Buscar");
							
						}
					}
					{
						jPanelIngresos = new JPanel();
						jPanelContenido.add(jPanelIngresos);
						jPanelIngresos.setBounds(17, 205, 435, 331);
						jPanelIngresos.setBorder(BorderFactory.createTitledBorder("Contenido"));
						jPanelIngresos.setLayout(null);
						{
							lblNombIngreso = new JLabel();
							jPanelIngresos.add(lblNombIngreso);
							lblNombIngreso.setText("Nombre: ");
							lblNombIngreso.setBounds(18, 83, 68, 16);
						}
						{
							jLabelMontoIngresoEgreso = new JLabel();
							jPanelIngresos.add(jLabelMontoIngresoEgreso);
							jLabelMontoIngresoEgreso.setText("Monto");
							jLabelMontoIngresoEgreso.setBounds(17, 259, 39, 15);
						}
						{
							lblMontoAbonar = new JLabel();
							jPanelIngresos.add(lblMontoAbonar);
							lblMontoAbonar.setText("Monto Abono");
							lblMontoAbonar.setBounds(17, 259, 90, 15);
							lblMontoAbonar.setVisible(false);
						}
						{
							lblMontoAdeudado = new JLabel();
							jPanelIngresos.add(lblMontoAdeudado);
							lblMontoAdeudado.setText("Monto Deuda");
							lblMontoAdeudado.setBounds(220, 259, 90, 15);
							lblMontoAdeudado.setVisible(false);
						}
						{
							txtMontoIngresoEgreso = new JTextField();
							jPanelIngresos.add(txtMontoIngresoEgreso);
							txtMontoIngresoEgreso.setBounds(103, 256, 100, 22);
							txtMontoIngresoEgreso.setActionCommand("MontoDeudaP");
						}
					/*	{
							txtMontoAbonar = new JTextField();
							jPanelIngresos.add(txtMontoAbonar);
							txtMontoAbonar.setBounds(103, 256, 100, 22);
							txtMontoAbonar.setVisible(false);
						}*/
						{
							txtMontoAdeudado = new JTextField();
							jPanelIngresos.add(txtMontoAdeudado);
							txtMontoAdeudado.setBounds(300, 256, 100, 22);
							txtMontoAdeudado.setVisible(false);
							txtMontoAdeudado.setEnabled(false);
						}
						{
							jScrollPrestFactura = new JScrollPane();
							jPanelIngresos.add(jScrollPrestFactura);
							jScrollPrestFactura.setBounds(104, 57, 296, 165);
							jScrollPrestFactura.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							{
								TableModel jTablePrestamosXFacturaModel = 
										new DefaultTableModel(
												new String[][] {},
												new String[] { "Descripción", "Monto", "Monto Deuda"});
								jTablePrestamosXFactura = new JTable();
								jScrollPrestFactura.setViewportView(jTablePrestamosXFactura);
								jTablePrestamosXFactura.setModel(jTablePrestamosXFacturaModel);
								jTablePrestamosXFactura.getTableHeader().setFont(new java.awt.Font("Verdana",0,11));
								jTablePrestamosXFactura.setFont(new java.awt.Font("Verdana",0,11));
								jTablePrestamosXFactura.setDragEnabled(false);
								jTablePrestamosXFactura.setCellSelectionEnabled(false);
								jTablePrestamosXFactura.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										//TODO add your code for jTablePrestamosXFactura.mouseClicked
										jTableIngresosXFactura.clearSelection();
										jTableDeudasPorSocio.clearSelection();
										agregarPrestamos();
										montoDeuda();
																				}
								});
								
							}
								/*ListModel jList1Model = 
										new DefaultComboBoxModel(
												new String[] {});
								jListPrestamosPendientes = new JList();
								jPanelIngresos.add(jListPrestamosPendientes);
								jListPrestamosPendientes.setModel(jList1Model);
								jListPrestamosPendientes.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
								jListPrestamosPendientes.setBounds(103, 174, 296, 65);
								jListPrestamosPendientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
						}
						{
							jScrollingresos = new JScrollPane();
							jPanelIngresos.add(jScrollingresos);
							jScrollingresos.setBounds(104, 55, 295, 180);
							{
								ListModel jListIngresosModel = 
										new DefaultComboBoxModel(
												new String[] { });
								jListIngresos = new JList();
								jScrollingresos.setViewportView(jListIngresos);
								jListIngresos.setModel(jListIngresosModel);
								jListIngresos.setBounds(60, -36, 310, 110);
								jListIngresos.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
								jListIngresos.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										//TODO add your code for jListIngresos.mouseClicked
											llenartxtMontIng();	
									}
								});
							}
						}
						{
							btnanadir = new JButton();
							jPanelIngresos.add(btnanadir);
							btnanadir.setText("Añadir");
							btnanadir.setBounds(174, 291, 100, 23);
							btnanadir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
							btnanadir.setFont(new java.awt.Font("Verdana",0,11));
							btnanadir.setActionCommand("Añadir");
						
						}
						{
							lblTipoFact = new JLabel();
							jPanelIngresos.add(lblTipoFact);
							lblTipoFact.setText("Tipo de Factura");
							lblTipoFact.setBounds(13, 25, 100, 16);
							lblTipoFact.setFont(new java.awt.Font("Verdana",0,11));
						}
						{
							ComboBoxModel cmbTipoFactuModel = 
									new DefaultComboBoxModel(
											new String[] { OPCION_COMBO_SELECCIONE,this.TIPO_DE_FACTURA_INGRESOS, this.TIPO_DE_FACTURA_EGRESOS, this.TIPO_DE_FACTURA_PRESTAMOS});
							cmbTipoFactu = new JComboBox();
							cmbTipoFactu.setModel(cmbTipoFactuModel);
							jPanelIngresos.add(cmbTipoFactu);
							jPanelIngresos.add(getJSpinnerCantidad());
							jPanelIngresos.add(getLblCantidad());
							jPanelIngresos.add(getLblPrestamos());
							jPanelIngresos.add(getLblPendiente());
							jPanelIngresos.add(getBtnAnnadirPrestamo());
							
							cmbTipoFactu.setBounds(118, 21, 230, 23);
							cmbTipoFactu.setEditable(false);
							cmbTipoFactu.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								limpiarTablaIngresoXFactura();
								if(cmbTipoFacturado.getSelectedItem().toString().equalsIgnoreCase(OPCION_COMBO_SELECCIONE)){
									JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo. Ej: Socio, Inquilino, Arrendatario");
								}
								else{
									if(cmbTipoFactu.getSelectedItem().toString().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_INGRESOS)){
										llenarIngresos(cmbTipoFacturado.getSelectedItem().toString());
										jListIngresos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										limpiarTablaIngresos();
										jSpinnerCantidad.setVisible(true);
										lblCantidad.setVisible(true);
										jListIngresos.setVisible(true);
										jScrollingresos.setVisible(true);
										jScrollPrestFactura.setVisible(false);
										lblPrestamos.setVisible(false);
										lblPendiente.setVisible(false);
										btnAnnadirPrestamo.setVisible(false);
										btnAnnadirDeuda.setEnabled(true);
										
									}
									else if(cmbTipoFactu.getSelectedItem().toString().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_EGRESOS)){
									
										listaModeloAux.clear();
										llenarEgresos(cmbTipoFacturado.getSelectedItem().toString());
										jListIngresos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										jSpinnerCantidad.setVisible(false);
										lblCantidad.setVisible(false);
										limpiarTablaEgresos();
										jListIngresos.setVisible(true);
										jScrollingresos.setVisible(true);
										jScrollPrestFactura.setVisible(false);
										lblPrestamos.setVisible(false);
										lblPendiente.setVisible(false);
										btnAnnadirPrestamo.setVisible(false);
										btnAnnadirDeuda.setEnabled(false);

									}else if(cmbTipoFactu.getSelectedItem().toString().equalsIgnoreCase(vFactura.TIPO_DE_FACTURA_PRESTAMOS)){
										jListIngresos.setVisible(false);
										jScrollingresos.setVisible(false);
										lblNombIngreso.setVisible(false);
										jSpinnerCantidad.setVisible(false);
										lblCantidad.setVisible(false);
										limpiarTablaPrestamos();
									    btnAnnadirDeuda.setEnabled(false);
									    jScrollPrestFactura.setVisible(true);
										lblPrestamos.setVisible(true);
										lblPendiente.setVisible(true);
										btnAnnadirPrestamo.setVisible(true);
										
										
									}
								}
								
							}
						});
							
						}
					}
					{
						jPanelInfFactura = new JPanel();
						jPanelContenido.add(jPanelInfFactura);
						jPanelInfFactura.setBounds(469, 205, 447, 194);
						jPanelInfFactura.setBorder(BorderFactory.createTitledBorder("Información de la factura"));
						jPanelInfFactura.setLayout(null);
						{
							jScrollPaneFactura = new JScrollPane();
							jPanelInfFactura.add(jScrollPaneFactura);
							jScrollPaneFactura.setBounds(13, 25, 417, 131);
							jScrollPaneFactura.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							{
								TableModel jTableIngresosXFacturaModel = 
										new DefaultTableModel(
												new String[][] {},
												new String[] { "Codigo","Nombre", "Monto","Clasif","Cantidad" });
								jTableIngresosXFactura = new JTable();
								jScrollPaneFactura.setViewportView(jTableIngresosXFactura);
								jTableIngresosXFactura.setModel(jTableIngresosXFacturaModel);
								jTableIngresosXFactura.getTableHeader().setFont(new java.awt.Font("Verdana",0,11));
								jTableIngresosXFactura.setFont(new java.awt.Font("Verdana",0,11));
								jTableIngresosXFactura.setDragEnabled(false);
								jTableIngresosXFactura.setCellSelectionEnabled(false);
							
								
							}
						}
						{
							jToggleButton1 = new JToggleButton();
							jPanelInfFactura.add(jToggleButton1);
							jToggleButton1.setText("Total");
							jToggleButton1.setBounds(128, 162, 87, 25);
							jToggleButton1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							jToggleButton1.setFont(new java.awt.Font("Verdana",0,11));
						}
						{
							txtMontoTotal = new JTextField();
							jPanelInfFactura.add(txtMontoTotal);
							txtMontoTotal.setBounds(225, 163, 205, 22);
							txtMontoTotal.setEditable(false);
							txtMontoTotal.setFont(new java.awt.Font("Verdana",0,11));
						}
						{
							btnQuitar = new JButton();
							jPanelInfFactura.add(btnQuitar);
							btnQuitar.setBounds(25, 162, 30, 25);
							btnQuitar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/black_delete_16x16.gif")));
							btnQuitar.setActionCommand("Quitar");
						
						}
					}
					{
						jPanelFormaPago = new JPanel();
						jPanelContenido.add(jPanelFormaPago);
						jPanelFormaPago.setBounds(469, 403, 447, 133);
						jPanelFormaPago.setBorder(BorderFactory.createTitledBorder("Forma de Pago"));
						jPanelFormaPago.setLayout(null);
						jPanelFormaPago.setFocusable(false);
						jPanelFormaPago.add(getCheckEfectivo());
						jPanelFormaPago.add(getCheckSubsidio());
						jPanelFormaPago.add(getCheckDeposito());
						jPanelFormaPago.add(getCheckTransferencia());
						jPanelFormaPago.add(getCheckCheque());
					//	jPanelFormaPago.add(getLblMonto());
						jPanelFormaPago.add(getTxtEfectivo());
						jPanelFormaPago.add(getTxtSubsidio());
						jPanelFormaPago.add(getTxtDeposito());
						jPanelFormaPago.add(getTxtTransferencia());
						jPanelFormaPago.add(getTxtCheque());
						jPanelFormaPago.add(getLblTotal());
						jPanelFormaPago.add(getTxtTotal());
						jPanelFormaPago.add(getLblMontoDispo());
						jPanelFormaPago.add(getTxtMontoDisp());
					}
					{
						lblNroFactura = new JLabel();
						jPanelContenido.add(lblNroFactura);
						lblNroFactura.setText("Factura Nro.");
						lblNroFactura.setBounds(511, 18, 85, 16);
					}
					{
						txtNroFactura = new JTextField();
						jPanelContenido.add(txtNroFactura);
						txtNroFactura.setBounds(596, 15, 103, 23);
						txtNroFactura.setEditable(false);
					}
					{
						lblResponsable = new JLabel();
						jPanelContenido.add(lblResponsable);
						lblResponsable.setText("Responsable");
						lblResponsable.setBounds(23, 18, 93, 16);
					}
					{
						txtResponsableFactura = new JTextField();
						jPanelContenido.add(txtResponsableFactura);
						jPanelContenido.add(getJPanelDeudasSocio());
						txtResponsableFactura.setBounds(116, 15, 330, 23);
					}
				}
			}
			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("Salir");
				btnSalir.setBounds(585, 645, 117, 32);
				//btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit_16x16 (1).png")));
				btnSalir.setFont(new java.awt.Font("Verdana",0,11));
				btnSalir.setActionCommand("Salir");
				btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(399, 645, 136, 32);
				btnLimpiar.setFont(new java.awt.Font("Verdana",0,11));
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setActionCommand("Limpiar");
			}
			{
				btnProcesar = new JButton();
				getContentPane().add(btnProcesar);
				btnProcesar.setText("Procesar");
				btnProcesar.setBounds(200, 645, 145, 32);
				btnProcesar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnProcesar.setFont(new java.awt.Font("Verdana",0,11));
				btnProcesar.setActionCommand("Procesar");
				
			}
			pack();
			this.setSize(975, 727);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JLabel getLblLogo() {
		if(lblLogo == null) {
			lblLogo = new JLabel();
			lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			lblLogo.setBounds(7, -4, 168, 70);
		}
		return lblLogo;
	}

	
	
	public void setTxtTotal(String txtTotal) {
		this.txtTotal.setText(txtTotal);
	}

	public String getTxtCed(){
		return txtCedulaSocio.getText();
	}
	
	public String getTxtResponsableFactura() {
		return txtResponsableFactura.getText();
	}

	public void setTxtResponsableFactura(String ResponsableFactura) {
		this.txtResponsableFactura.setText(ResponsableFactura);;
	}

	public String getTxtNroFactura() {
		return txtNroFactura.getText();
	}

	public void setTxtNroFactura(String NroFactura) {
		this.txtNroFactura.setText(NroFactura);
	}
	
	public String getTxtMontoTotal() {
		return txtMontoTotal.getText();
	}

	public void setTxtMontoIngresoEgreso(String txtMontoIngresoEgreso) {
		this.txtMontoIngresoEgreso.setText(txtMontoIngresoEgreso);
	}

	public String getTxtMontoIngresoEgreso() {
		return txtMontoIngresoEgreso.getText();
	}

	public void setTxtMontoTotal(String txtMontoTotal) {
		this.txtMontoTotal.setText(txtMontoTotal);
	}

	public String getTxtNombSocio() {
		return txtNombSocio.getText();
	}

	public void setTxtNombSocio(String txtNombSocio) {
		this.txtNombSocio.setText(txtNombSocio);
	}

	public String getTxtNroSocio() {
		return txtNroSocio.getText();
	}
	
	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}

	public void setTxtNroSocio(String txtNroSocio) {
		this.txtNroSocio.setText(txtNroSocio);
	}
	
	public void setTxtCedulaSocio(String ced){
		this.txtCedulaSocio.setText(ced);
	}
	
	
	/*public List<String> getListaPrestamosIngresos() {
		return listaPrestamosIngresos;
	}*/
	

	public String getCmbTipoFacturado() {
		return cmbTipoFacturado.getSelectedItem().toString();
	}
	

	public void setCmbTipoFacturado(String cmbTipoFacturado) {
		this.cmbTipoFacturado.addItem(cmbTipoFacturado);
	}

	public String getCmbTipoFactu() {
		return cmbTipoFactu.getSelectedItem().toString();
	}

	public void setCmbTipoFactu(String cmbTipoFactu) {
		this.cmbTipoFactu.addItem(cmbTipoFactu);
		}

	/*public void setListaPrestamosIngresos(List<String> listaPrestamosIngresos) {
		this.listaPrestamosIngresos = listaPrestamosIngresos;
	}*/

	public JList getjListIngresos() {
		return jListIngresos;
	}

	public void setjListIngresos(JList jListIngresos) {
		this.jListIngresos = jListIngresos;
		jListIngresos.setPreferredSize(new java.awt.Dimension(310, 110));
	}

	public void setjListPrestamosModel(LinkedListModel<String> model)
	{
		jListPrestamosPendientes.setModel(model);
	}
	public JList getjListPrestamosPendientes() {
		return jListPrestamosPendientes;
	}

	public void setjListPrestamosPendientes(JList jListPrestamosPendientes) {
		this.jListPrestamosPendientes = jListPrestamosPendientes;
	}
	
	
	public JTable getjTableIngresosXFactura() {
		return jTableIngresosXFactura;
	}

	public void setjTableIngresosXFactura(JTable jTableIngresosXFactura) {
		this.jTableIngresosXFactura = jTableIngresosXFactura;
	}

	//agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnanadir.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnProcesar.addActionListener(accion);
		this.btnQuitar.addActionListener(accion);
		this.btnSalir.addActionListener(accion);
		this.btnBuscarCedSoc.addActionListener(accion);
		this.btnAnnadirDeuda.addActionListener(accion);
		this.btnAnnadirPrestamo.addActionListener(accion);
		
		
		//CHECKBUTTON
		this.checkCheque.addActionListener(accion);
		this.checkDeposito.addActionListener(accion);
		this.checkEfectivo.addActionListener(accion);
		this.checkSubsidio.addActionListener(accion);
		this.checkTransferencia.addActionListener(accion);
		
		//TXT
		txtCheque.addActionListener(accion);
		txtCedulaSocio.addActionListener(accion);
		txtTransferencia.addActionListener(accion);
		txtDeposito.addActionListener(accion);
		txtEfectivo.addActionListener(accion);
		txtSubsidio.addActionListener(accion);
		txtNroSocio.addActionListener(accion);
		
		txtMontoIngresoEgreso.addActionListener(accion);
		
	 
		
	}
	
	public void agregarFocusListener(FocusListener fl){
		this.txtCheque.addFocusListener(fl);
		this.txtDeposito.addFocusListener(fl);
		this.txtEfectivo.addFocusListener(fl);
		this.txtTransferencia.addFocusListener(fl);
		this.txtSubsidio.addFocusListener(fl);
		this.txtMontoTotal.addFocusListener(fl);
	}

/*	//LimpiarCampos
	public void limpiarCampos() {
		txtMontoTotal.setText("");
		txtNombSocio.setText("");
		txtNroFactura.setText("");
		txtNroSocio.setText("");
		txtResponsableFactura.setText("");
		txtCedulaSocio.setText("");
		txtApellido.setText("");
	}*/
	
	//LimpiarTodo
	public void limpiarTodo() {
	//	txtDescripcion.setText("");
		txtMontoTotal.setText("");
		txtNombSocio.setText("");
		txtNroSocio.setText("");
		txtCedulaSocio.setText("");
		txtApellido.setText("");
		
		txtCheque.setText("");
		txtDeposito.setText("");
		txtEfectivo.setText("");
		txtSubsidio.setText("");
		txtTransferencia.setText("");
		txtMontoTotal.setText("");
		
		cmbTipoFactu.setSelectedIndex(0);
		cmbTipoFacturado.setSelectedIndex(0);
		listaModeloIngresoEgreso.clear();
		listaModeloAux.clear();
		jListIngresos.removeAll();
		

		limpiarTablaDeudas();
		limpiarTablaEgresos();
		limpiarTablaIngresos();
		limpiarTablaIngresoXFactura();
		limpiarTablaPrestamos();
		limpiarTablaListPrestamos();
		
		
		
	}


	// cerrar Ventana
	public void cerrarVentana() {
		// TODO Auto-generated method stub
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,"¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (ValorDevuelto == 0) {
			this.dispose();
		}
	}
	
	// cerrar Ventana
	public void mensajeAlerta(String mensaje) {
		// TODO Auto-generated method stub
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,mensaje, "Advertencia", JOptionPane.CLOSED_OPTION);
		if (ValorDevuelto == -1) {
			this.dispose();
		}
	}
	
	public void BloquearCampos(){
		txtApellido.setEnabled(false);
	}
	
	public void VaciarLista(){
			listaModeloIngresoEgreso.clear();
			jListIngresos.removeAll();

	}
	
	public void llenarIngresos(String tipoFacturado){	
		VaciarLista();
		try {
			for (Iterator iterator = ingDao.obtenerIngresosPorTipos(tipoFacturado).iterator(); iterator.hasNext();) {
				Ingresos ingre = (Ingresos)iterator.next();
				
			 if(!ingre.getDescripcion().equals("Aporte Conductor") && !ingre.getDescripcion().equals("Aporte Socio"))
				{
					listaModeloIngresoEgreso.add(ingre.getDescripcion());
				}
					
				
			}
			jListIngresos.setModel(listaModeloIngresoEgreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarEgresos(String tipoFacturado){
		VaciarLista();
		try {
			for (Iterator iterator = egDao.obtenerEgresosPorTipo(tipoFacturado).iterator(); iterator.hasNext();) {
				Egresos egre = (Egresos)iterator.next();
				listaModeloIngresoEgreso.add(egre.getDescripcion());
			}
			jListIngresos.setModel(listaModeloIngresoEgreso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarCamposSocio(Socio socio){
		if(null!=socio){
			txtNroSocio.setText(socio.getNroSocio());
			txtCedulaSocio.setText(socio.getCedula());
			txtNombSocio.setText(socio.getNombre());
			txtApellido.setText(socio.getApellido());
		}
		else{
			txtNroSocio.setText("");
			txtCedulaSocio.setText("");
			txtNombSocio.setText("");
			txtApellido.setText("");
			JOptionPane.showMessageDialog(this, "Debe completar el campo");
		}
	}
	
	public void llenarCamposInquilino(Inquilino inquilino){
		if(null!=inquilino){
			if(inquilino.getRif().equals("null")){
			    txtNroSocio.setText("");
			    txtNroSocio.setEditable(false);
			    txtCedulaSocio.setText(inquilino.getCedula());
				txtNombSocio.setText(inquilino.getNombre());
				txtApellido.setText(inquilino.getApellido());
				}
			else if(inquilino.getCedula().equals("null"))
			{
				txtCedulaSocio.setText("");
				txtCedulaSocio.setEditable(false);
				txtNroSocio.setText(inquilino.getRif());
				txtNombSocio.setText(inquilino.getNombre());
				txtApellido.setText(inquilino.getApellido());
			}
	
			
		}
		else{
			txtNroSocio.setText("");
			txtCedulaSocio.setText("");
			txtNombSocio.setText("");
			txtApellido.setText("");
			JOptionPane.showMessageDialog(this, "No se encontró resultado");
		}
	}
	
	public void llenarCamposArrendatario(Arrendatario arrendatario){
		if(null!=arrendatario){

			txtCedulaSocio.setText(arrendatario.getCedula());
			txtNombSocio.setText(arrendatario.getNombre());
			txtApellido.setText(arrendatario.getApellido());
		}
		else{
			txtNroSocio.setText("");
			txtCedulaSocio.setText("");
			txtNombSocio.setText("");
			txtApellido.setText("");
			JOptionPane.showMessageDialog(this, "No se encontró resultado");
		}
	}
	
	public void agregarKey(KeyListener a) {
		txtCedulaSocio.addKeyListener(a);
		txtNroSocio.addKeyListener(a);
		txtCheque.addKeyListener(a);
		txtDeposito.addKeyListener(a);
		txtEfectivo.addKeyListener(a);
		txtSubsidio.addKeyListener(a);
		txtTransferencia.addKeyListener(a);
		txtMontoIngresoEgreso.addKeyListener(a);
		//txtMontoAbonar.addKeyListener(a);
		
	}
	
	public void ocultarTablas(){
		jScrollPrestFactura.setVisible(false);
		lblPrestamos.setVisible(false);
		lblPendiente.setVisible(false);
		btnAnnadirPrestamo.setVisible(false);
	}
	public void removerElementoTablaIngresoXFactura(){
		 defaultTableModelIngresoXfactura = (DefaultTableModel) jTableIngresosXFactura.getModel();
		
		int[] arreglo =jTableIngresosXFactura.getSelectedRows();
		for (int i = 0; i < arreglo.length; i++) {
			int arrAux = arreglo[i];
			defaultTableModelIngresoXfactura.removeRow(arrAux);		
			
			defaultTableModelIngresoXfactura = (DefaultTableModel) jTableIngresosXFactura.getModel();
			defaultTableModelIngresoXfactura.fireTableDataChanged();
			arreglo =jTableIngresosXFactura.getSelectedRows();
		}
	}
	
	public void limpiarTablaIngresoXFactura(){
		 defaultTableModelIngresoXfactura = (DefaultTableModel) jTableIngresosXFactura.getModel();
		
		int a =defaultTableModelIngresoXfactura.getRowCount()-1;  
        for(int i=a;i>=0;i--){ 
        	
        	defaultTableModelIngresoXfactura.removeRow(i);
        }
        defaultTableModelIngresoXfactura.fireTableDataChanged();
        defaultTableModelIngresoXfactura = (DefaultTableModel) jTableIngresosXFactura.getModel();
	}
	
	public void sumarMontoTablaIngresoXFactura(){
		Double sumatoria=0.0;
		 defaultTableModelIngresoXfactura = (DefaultTableModel) jTableIngresosXFactura.getModel();
		
		 int totalRow= defaultTableModelIngresoXfactura.getRowCount();
	        totalRow-=1; 
	        for(int i=0;i<=(totalRow);i++)
	        {
	        	//System.out.println("de la tabla deudas por socio  "+defaultTableModelIngresoXfactura.getValueAt(i,2));
	             sumatoria = sumatoria +  (Double.parseDouble(String.valueOf(defaultTableModelIngresoXfactura.getValueAt(i,2)))*Double.parseDouble(String.valueOf(jSpinnerCantidad.getValue())));
	             
	        }
	     txtMontoTotal.setText(String.valueOf(sumatoria));

	}
	
	
	public  void getDatos(){    /////******REVISAR QUE HACE***/////
		 String valor="";
		 String monto="";
		 full_datos = new ArrayList<>();
		for(int i=0; i<jTableIngresosXFactura.getRowCount(); i++) //recorro las filas
		{
			for(int a=0; a<jTableIngresosXFactura.getColumnCount(); a++) //recorro las columnas
			{
				full_datos.add(jTableIngresosXFactura.getValueAt(i ,a).toString()); 
				if (a==0){
					//valor =
				}
				
			}
		}
		
		for (Iterator iterator = full_datos.iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			System.err.println("el tipo: "+type);
			
		}
		
		jTableIngresosXFactura.getModel();
	}
	
	public JSpinner getJSpinnerCantidad() {
		if(jSpinnerCantidad == null) {
			SpinnerNumberModel jSpinnerCantidadModel = 
					new SpinnerNumberModel(1, 1, 100, 1);
			jSpinnerCantidad = new JSpinner();
			jSpinnerCantidad.setModel(jSpinnerCantidadModel);
			jSpinnerCantidad.setBounds(312, 256, 87, 23);
		}
		return jSpinnerCantidad;
	}
	
	private JLabel getLblCantidad() {
		if(lblCantidad == null) {
			lblCantidad = new JLabel();
			lblCantidad.setText("Cantidad:");
			lblCantidad.setBounds(255, 259, 82, 16);
		}
		return lblCantidad;
	}
	
	public JCheckBox getCheckEfectivo() {
		if(checkEfectivo == null) {
			checkEfectivo = new JCheckBox();
			checkEfectivo.setText("Efectivo");
			checkEfectivo.setBounds(17, 23, 75, 15);
			checkEfectivo.setActionCommand("CheckEfectivo");
		}
		return checkEfectivo;
	}
	
	public JCheckBox getCheckSubsidio() {
		if(checkSubsidio == null) {
			checkSubsidio = new JCheckBox();
			checkSubsidio.setText("Subsidio");
			checkSubsidio.setBounds(17, 79, 105, 15);
			checkSubsidio.setActionCommand("CheckSubsidio");
		}
		return checkSubsidio;
	}
	
	public JCheckBox getCheckDeposito() {
		if(checkDeposito == null) {
			checkDeposito = new JCheckBox();
			checkDeposito.setText("Deposito");
			checkDeposito.setBounds(220, 23, 80, 15);
			checkDeposito.setActionCommand("CheckDeposito");
		}
		return checkDeposito;
	}
	
	public JCheckBox getCheckTransferencia() {
		if(checkTransferencia == null) {
			checkTransferencia = new JCheckBox();
			checkTransferencia.setText("Transferencia");
			checkTransferencia.setBounds(17, 50, 105, 15);
			checkTransferencia.setActionCommand("CheckTransferencia");
		
		}
		return checkTransferencia;
	}
	
	public JCheckBox getCheckCheque() {
		if(checkCheque == null) {
			checkCheque = new JCheckBox();
			checkCheque.setText("Cheque");
			checkCheque.setBounds(220, 50, 75, 15);
			checkCheque.setActionCommand("CheckCheque");
			
		}
		return checkCheque;
	}
	
	public JTextField getTxtEfectivo() {
		if(txtEfectivo == null) {
			txtEfectivo = new JTextField();
			txtEfectivo.setBounds(125, 23, 71, 23);
			txtEfectivo.setActionCommand("total");
		}
		return txtEfectivo;
	}
	
	public String getEfectivo(){
		return txtEfectivo.toString();
	}
	
	public JTextField getTxtSubsidio() {
		if(txtSubsidio == null) {
			txtSubsidio = new JTextField();
			txtSubsidio.setBounds(125, 75, 71, 23);
			txtSubsidio.setActionCommand("total");
		}
		return txtSubsidio;
	}
	
	public JTextField getTxtDeposito() {
		if(txtDeposito == null) {
			txtDeposito = new JTextField();
			txtDeposito.setBounds(300, 23, 100, 23);
			txtDeposito.setActionCommand("total");
		}
		return txtDeposito;
	}
	
	public JTextField getTxtTransferencia() {
		if(txtTransferencia == null) {
			txtTransferencia = new JTextField();
			txtTransferencia.setBounds(125, 50, 71, 23);
			txtTransferencia.setActionCommand("total");
		}
		return txtTransferencia;
	}
	
	public JTextField getTxtCheque() {
		if(txtCheque == null) {
			txtCheque = new JTextField();
			txtCheque.setBounds(300, 48,100, 23);
			txtCheque.setActionCommand("total");
		}
		return txtCheque;
	}
	
	public JLabel getLblPrestamos() {
		if(lblPrestamos == null) {
			lblPrestamos = new JLabel();
			lblPrestamos.setText("Prestamos");
			lblPrestamos.setBounds(19, 191, 84, 16);
		}
		return lblPrestamos;
	}
	
	public JLabel getLblPendiente() {
		if(lblPendiente == null) {
			lblPendiente = new JLabel();
			lblPendiente.setText("pendientes:");
			lblPendiente.setBounds(17, 207, 79, 16);
		}
		return lblPendiente;
	}
	
	public JLabel getLblTotal() {
		if(lblTotal == null) {
			lblTotal = new JLabel();
			lblTotal.setText("TOTAL:");
			lblTotal.setBounds(91, 104, 56, 19);
			lblTotal.setFont(new java.awt.Font("Segoe UI",1,12));
		}
		return lblTotal;
	}
	
	public JTextField getTxtTotal() {
		if(txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setBounds(140, 104, 121, 23);
		}
		return txtTotal;
	}
	
	public JLabel getLblMontoDispo() {
		if(lblMontoDispo == null) {
			lblMontoDispo = new JLabel();
			lblMontoDispo.setText("Monto Disponible:");
			lblMontoDispo.setBounds(220, 81, 116, 11);
		}
		return lblMontoDispo;
	}
	
	public JTextField getTxtMontoDisp() {
		if(txtMontoDisp == null) {
			txtMontoDisp = new JTextField();
			txtMontoDisp.setBounds(330, 75, 71, 23);
		}
		return txtMontoDisp;
	}
	
	
	
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtCedulaSocio() {
		return txtCedulaSocio;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public void setTxtCedulaSocio(JTextField txtCedulaSocio) {
		this.txtCedulaSocio = txtCedulaSocio;
	}

	public void setTxtEfectivo(JTextField txtEfectivo) {
		this.txtEfectivo = txtEfectivo;
	}

	public void setTxtMontoDisp(JTextField txtMontoDisp) {
		this.txtMontoDisp = txtMontoDisp;
	}

	public void setTxtTotal(JTextField txtTotal) {
		this.txtTotal = txtTotal;
	}

	public void setTxtCheque(JTextField txtCheque) {
		this.txtCheque = txtCheque;
	}

	public void setTxtTransferencia(JTextField txtTransferencia) {
		this.txtTransferencia = txtTransferencia;
	}

	public void setTxtDeposito(JTextField txtDeposito) {
		this.txtDeposito = txtDeposito;
	}

	public void setTxtSubsidio(JTextField txtSubsidio) {
		this.txtSubsidio = txtSubsidio;
	}

	public void setTxtResponsableFactura(JTextField txtResponsableFactura) {
		this.txtResponsableFactura = txtResponsableFactura;
	}

	public void setTxtNroFactura(JTextField txtNroFactura) {
		this.txtNroFactura = txtNroFactura;
	}

	public void setTxtMontoTotal(JTextField txtMontoTotal) {
		this.txtMontoTotal = txtMontoTotal;
	}

	public void setTxtNombSocio(JTextField txtNombSocio) {
		this.txtNombSocio = txtNombSocio;
	}

	public void setTxtNroSocio(JTextField txtNroSocio) {
		this.txtNroSocio = txtNroSocio;
	}

	public void setTxtMontoIngresoEgreso(JTextField txtMontoIngresoEgreso) {
		this.txtMontoIngresoEgreso = txtMontoIngresoEgreso;
	}
	
	

	public void OcultarCamposFormaPago(){
		this.txtCheque.setEditable(false);
		this.txtDeposito.setEditable(false);
		this.txtEfectivo.setEditable(false);
		this.txtMontoDisp.setEditable(false);
		this.txtTransferencia.setEditable(false);
		this.txtSubsidio.setEditable(false);
		this.lblMontoDispo.setVisible(false);
		//this.lblMonto.setVisible(false);
		txtTotal.setEditable(false);
		//txtTotal.setVisible(false);
		this.lblTotal.setVisible(false);
		txtMontoDisp.setVisible(false);
	}
	public void Check(){
		//lblMonto.setVisible(true);
		txtTotal.setVisible(true);
		this.lblTotal.setVisible(true);
	}
	
	public void OcultarCheck(){
		//lblMonto.setVisible(false);
		txtTotal.setVisible(false);
		this.lblTotal.setVisible(false);
	}
	public void CheckEfectivo(){
		txtEfectivo.setEditable(true);
		txtEfectivo.setVisible(true);
		this.Check();
		this.checkEfectivo.setActionCommand("OcultarCheck");
	}
	
	public void OcultarCheckEfectivo(){
		txtEfectivo.setEditable(false);
		txtEfectivo.setText("");
		//this.OcultarCheck();
		this.checkEfectivo.setActionCommand("CheckEfectivo");
	}

	public void CheckSubsidio(){
		
		txtMontoDisp.setEditable(true);
		lblMontoDispo.setVisible(true);
		txtMontoDisp.setEditable(false);
		txtMontoDisp.setVisible(true);
		this.Check();
	
		if(Float.parseFloat(txtMontoDisp.getText())==0.0 || "".equals(txtMontoDisp.getText()) || null== txtMontoDisp.getText())
		{
			this.txtSubsidio.setEditable(false);
			//checkSubsidio.disable();
			checkSubsidio.setSelected(false);
		}
		else
			txtSubsidio.setEditable(true);
		this.checkSubsidio.setActionCommand("OcultarCheckSubsidio");
	}

	public void OcultarCheckSubsidio(){
		txtSubsidio.setEditable(false);
		txtSubsidio.setText("");
		txtMontoDisp.setVisible(false);
	
		lblMontoDispo.setVisible(false);
		//this.OcultarCheck();
		checkSubsidio.setActionCommand("CheckSubsidio");
	}
	
	public void CheckDeposito(){
		txtDeposito.setVisible(true);
		txtDeposito.setEditable(true);
		this.Check();
		this.checkDeposito.setActionCommand("OcultarCheckDeposito");
	}

	public void OcultarCheckDeposito(){
		txtDeposito.setEditable(false);
		txtDeposito.setText("");
		//this.OcultarCheck();
		checkDeposito.setActionCommand("CheckDeposito");
	}
	
	public void CheckTransferencia(){
		txtTransferencia.setVisible(true);
		txtTransferencia.setEditable(true);
		txtTransferencia.setText("");
		this.Check();
		this.checkDeposito.setActionCommand("OcultarCheckTransferencia");
	}

	public void OcultarCheckTransferencia(){
		txtTransferencia.setEditable(false);
		txtTransferencia.setText("");
		checkTransferencia.setActionCommand("CheckTrasnferencia");
		
	}
	
	public void CheckCheque(){
		txtCheque.setEditable(true);
		this.Check();
		this.checkCheque.setActionCommand("OcultarCheckCheque");
	}

	public void OcultarCheckCheque(){
		txtCheque.setEditable(false);
		txtCheque.setText("");
		checkCheque.setActionCommand("CheckCheque");
	}
	
	
	public void QuitarSeleccionSub(){
		checkSubsidio.setSelected(false);
	}

	public void limpiarTablaEgresos() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] {"Codigo","Nombre", "Monto","Clasif"},0);
		jTableIngresosXFactura.setModel(tblListadoModel);

		}	

	public void limpiarCantSplit(){
		this.jSpinnerCantidad.setValue(1);
	}
	public void limpiarTablaPrestamos() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] {"Codigo","Nombre", "Monto"},0);
		jTableIngresosXFactura.setModel(tblListadoModel);

		}
	
	public void limpiarTablaDeudas() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] {"Codigo","Descripciòn", "Monto","Fecha"},0);
		jTableDeudasPorSocio.setModel(tblListadoModel);
		

		}	
	
	public void limpiarTablaIngresos(){
		TableModel tblListadoModel = 
				new DefaultTableModel(
						new String[] {"Codigo","Nombre", "Monto","Clasif","Cantidad"},0);
				jTableIngresosXFactura.setModel(tblListadoModel);

	}
	
	public void limpiarTablaListPrestamos(){
		TableModel tblListadoModel = 
				new DefaultTableModel(
						new String[] {"Descripción", "Monto", "Monto Deuda"},0);
				jTablePrestamosXFactura.setModel(tblListadoModel);
	}
	
	
	//Para Los ingresos
	public void agregarFilaIngresos(String cod, String nombre, String monto, String clasif, String cantidad)
	{
		Vector<String> ingresos = new Vector<String>();

		ingresos.add(cod);
		ingresos.add(nombre);
		ingresos.add(monto);
		ingresos.add(clasif);
		ingresos.add(cantidad);
		
		DefaultTableModel dtm = (DefaultTableModel) jTableIngresosXFactura.getModel();
		dtm.addRow(ingresos);	
	}
	
	//Para Los ingresos
		public void agregarFilaPrestIng(String cod, String nombre, String monto)
		{
			Vector<String> prestamos = new Vector<String>();

			prestamos.add(cod);
			prestamos.add(nombre);
			prestamos.add(monto);
		
			DefaultTableModel dtm = (DefaultTableModel) jTableIngresosXFactura.getModel();
			dtm.addRow(prestamos);	
		}
	
	public void agregarFilaEgresos(String cod, String nombre, String monto, String clasif){
		Vector<String> egresos = new Vector<String>();

		egresos.add(cod);
		egresos.add(nombre);
		egresos.add(monto);
		egresos.add(clasif);
		
		DefaultTableModel dtm = (DefaultTableModel) jTableIngresosXFactura.getModel();
		dtm.addRow(egresos);	
	}
	
	public void agregarFilaPrestamos(String descripcion, String monto, String montoDeuda){
		Vector<String>prestamos = new Vector<String>();

		prestamos.add(descripcion);
		prestamos.add(monto);
		prestamos.add(montoDeuda);
		
		DefaultTableModel dtm = (DefaultTableModel) jTablePrestamosXFactura.getModel();
		dtm.addRow(prestamos);	
	}
	
	public void agregarFilaDeudas(String cod,String descripcion,String fecha, String monto){
		Vector<String>deudas = new Vector<String>();
		deudas.add(cod);
		deudas.add(descripcion);
		deudas.add(monto);
		deudas.add(fecha);
		
		DefaultTableModel dtm = (DefaultTableModel) jTableDeudasPorSocio.getModel();
		dtm.addRow(deudas);	
	}
	


	public void llenartxtMontIng(){
		
		if(this.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_INGRESOS)){
			txtMontoIngresoEgreso.setVisible(true);
			jLabelMontoIngresoEgreso.setVisible(true);
			lblCantidad.setVisible(true);
			jSpinnerCantidad.setVisible(true);
			Ingresos ing= new Ingresos();
			try {
				ing = ingDao.obtenerIngresosPorDescripcion(this.getjListIngresos().getSelectedValue().toString());
				if(ing.getMonto()!=0){
					txtMontoIngresoEgreso.setText(Float.toString(ing.getMonto()));
					txtMontoIngresoEgreso.disable();
				}else{
					txtMontoIngresoEgreso.setText("");
					txtMontoIngresoEgreso.enable();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(this.getCmbTipoFactu().equals(vFactura.TIPO_DE_FACTURA_EGRESOS)){
			txtMontoIngresoEgreso.setText("");
			txtMontoIngresoEgreso.enable();
		}
	}
	
	
	public void agregarPrestamos(){
		filaSeleccionada="";
		
		txtMontoIngresoEgreso.setEnabled(true);
		jLabelMontoIngresoEgreso.setVisible(false);
		lblCantidad.setVisible(false);
		jSpinnerCantidad.setVisible(false);
		
		lblMontoAbonar.setVisible(true);
		//txtMontoAbonar.setVisible(true);
		lblMontoAdeudado.setVisible(true);
		txtMontoAdeudado.setVisible(true);
		
		 int f=jTablePrestamosXFactura.getSelectionModel().getLeadSelectionIndex();
	     // int c=jTablePrestamosXFactura.getColumnModel().getSelectionModel().getLeadSelectionIndex();
		//System.out.println(this.getjTablePrestamosXFactura().getSelectionModel());
		filaSeleccionada= (String) this.jTablePrestamosXFactura.getValueAt(f,0);
		
	}
	
	public void montoDeuda(){
		filaMontoDeuda="";
		 int f=jTablePrestamosXFactura.getSelectionModel().getLeadSelectionIndex();
		filaMontoDeuda= (String) this.jTablePrestamosXFactura.getValueAt(f, 2);
	}
	
	
	
	
	
	
	public void agregarDeuda(){
		filaDeudaSelec="";
		 int f=jTableDeudasPorSocio.getSelectionModel().getLeadSelectionIndex();
		filaDeudaSelec= (String) this.jTableDeudasPorSocio.getValueAt(f,0);
		
	
		
	}
	
	
	public String filaDeuda(){
		return filaDeudaSelec;
	}
	
	public String filaPrestamos(){
		return filaSeleccionada;
	}
	
	
	public String filaMontoDeuda(){
		return filaMontoDeuda;
	}
	
	public JTable getjTablePrestamosXFactura() {
		return jTablePrestamosXFactura;
	}

	public void setjTablePrestamosXFactura(JTable jTablePrestamosXFactura) {
		this.jTablePrestamosXFactura = jTablePrestamosXFactura;
	}

	public String getTxtMontoAdeudado() {
		return txtMontoAdeudado.getText();
	}

	public void setTxtMontoAdeudado(String txtMontoAdeudado) {
		this.txtMontoAdeudado.setText(txtMontoAdeudado);
	}
	
	private JPanel getJPanelDeudasSocio() {
		if(jPanelDeudasSocio == null) {
			jPanelDeudasSocio = new JPanel();
			jPanelDeudasSocio.setLayout(null);
			jPanelDeudasSocio.setBounds(474, 46, 442, 153);
			jPanelDeudasSocio.setBorder(BorderFactory.createTitledBorder("Deudas"));
			jPanelDeudasSocio.add(getDeudasSocio());
			jPanelDeudasSocio.add(getBtnAnnadirDeuda());
		}
		return jPanelDeudasSocio;
	}
	
	private JScrollPane getDeudasSocio() {
		if(deudasSocio == null) {
			deudasSocio = new JScrollPane();
			deudasSocio.setBounds(17, 16, 408, 101);
			deudasSocio.setViewportView(getJTableDeudasPorSocio());
		}
		return deudasSocio;
	}
	
	private JButton getBtnAnnadirDeuda() {
		if(btnAnnadirDeuda == null) {
			btnAnnadirDeuda = new JButton();
			btnAnnadirDeuda.setText("Añadir");
			btnAnnadirDeuda.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
			btnAnnadirDeuda.setBounds(173, 119, 110, 28);
			btnAnnadirDeuda.setActionCommand("annadirDeuda");
		}
		return btnAnnadirDeuda;
	}
	
	public JTable getJTableDeudasPorSocio() {
		if(jTableDeudasPorSocio == null) {
			TableModel jTableDeudasPorSocioModel = 
					new DefaultTableModel(
							new String[][] {},
							new String[] {"Codigo", "Descripción","Monto" ,"Fecha" });
			jTableDeudasPorSocio = new JTable();
			jTableDeudasPorSocio.setModel(jTableDeudasPorSocioModel);
			jTableDeudasPorSocio.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					//TODO add your code for jTablePrestamosXFactura.mouseClicked
					jTableIngresosXFactura.clearSelection();
					jTablePrestamosXFactura.clearSelection();
					agregarDeuda();
															}
			});
		}
		return jTableDeudasPorSocio;
	}
	
	private JButton getBtnAnnadirPrestamo() {
		if(btnAnnadirPrestamo == null) {
			btnAnnadirPrestamo = new JButton();
			btnAnnadirPrestamo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
			btnAnnadirPrestamo.setBounds(400, 131, 30, 23);
			btnAnnadirPrestamo.setActionCommand("AnnadirPrestamos");
		}
		
		return btnAnnadirPrestamo;
	}

	public void LlenarLista(Prestamos p){
		listaPrestamos.add(p);
		System.out.println(listaPrestamos.size());
	}

	public ArrayList<Prestamos> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamos> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}
}

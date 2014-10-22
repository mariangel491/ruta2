package Vistas;

import Modelos.Prestamos;
import Modelos.Hibernate.Daos.PrestamosDao;

import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
public class VistaPrestamo extends javax.swing.JFrame {
	private JPanel jpPrestamo;
	private JLabel lblPrestamos;
	private JTextField txtNomSocio;
	private JTextField txtMonto;
	private JLabel lblTexto;
	private JTextField txtDescripcion;
	private JLabel lblDescripcion;
	private JTable jTable1;
	private JScrollPane spListadoPrestamos;
	private JTable jtPrestamos;
	private JPanel jpListadoPrestamos;
	private JLabel lblLogo;
	private JPanel pnelEncabezado;
	private JButton btnAgregar;
	private JLabel lblMonto;
	private JLabel lblNomSocio;
	private JTextField txtNroSocio;
	private JLabel lblNroSocio;
	private JPanel jpDatosSocio;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnModificar;
	private JButton btnBuscarSocio;
	private JLabel lblBSF;
	private JTextField txtCodPrestamo;
	private JLabel lblCodPrestamo;

	
	private PrestamosDao prestamosDao = new PrestamosDao();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaPrestamo inst = new VistaPrestamo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaPrestamo vPrest=null;
	
	public static VistaPrestamo obtenerInstancia(){
		if(vPrest==null)
			vPrest= new VistaPrestamo();
		return vPrest;
	}
	
	
	public VistaPrestamo() {
		super();
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Registrar Préstamos");
			{
				jpDatosSocio = new JPanel();
				getContentPane().add(jpDatosSocio);
				//jpDatosSocio.setLayout(jpDatosSocioLayout);
				jpDatosSocio.setBounds(12, 71, 568, 69);
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				jpDatosSocio.setLayout(null);
				{
					lblNroSocio = new JLabel();
					jpDatosSocio.add(lblNroSocio);
					lblNroSocio.setText("Número de Socio:");
					lblNroSocio.setFont(new java.awt.Font("Verdana",0,12));
					lblNroSocio.setBounds(11, 26, 119, 16);
				}
				{
					txtNroSocio = new JTextField();
					jpDatosSocio.add(txtNroSocio);
					txtNroSocio.setBounds(126, 23, 88, 23);
					txtNroSocio.setActionCommand("BSocioTecla");
				}
				{
					lblNomSocio = new JLabel();
					jpDatosSocio.add(lblNomSocio);
					lblNomSocio.setText("Nombre:");
					lblNomSocio.setBounds(291, 26, 59, 16);
					lblNomSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNomSocio = new JTextField();
					jpDatosSocio.add(txtNomSocio);
					txtNomSocio.setBounds(362, 23, 166, 23);
				}
				{
					btnBuscarSocio = new JButton();
					jpDatosSocio.add(btnBuscarSocio);
					btnBuscarSocio.setBounds(220, 16, 31, 33);
					btnBuscarSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarSocio.setActionCommand("BuscarSocio");
				}
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Modificar");
				btnModificar.setBounds(239, 290, 125, 29);
				btnModificar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Lists.gif")));
				btnModificar.setActionCommand("Modificar");
			}
			{
				btnSalir = new JButton();
				getContentPane().add(btnSalir);
				btnSalir.setText("Salir");
				btnSalir.setBounds(386, 290, 125, 29);
				btnSalir.setFont(new java.awt.Font("Century Gothic",0,12));
				btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
				btnSalir.setActionCommand("Salir");
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setBounds(87, 290, 125, 29);
				btnGuardar.setFont(new java.awt.Font("Century Gothic",0,12));
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setActionCommand("Guardar");
			}
			{
				jpListadoPrestamos = new JPanel();
				getContentPane().add(jpListadoPrestamos);
				jpListadoPrestamos.setBounds(23, 122, 544, 153);
				jpListadoPrestamos.setBorder(BorderFactory.createTitledBorder("Listado de Prestamos"));
				jpListadoPrestamos.setLayout(null);
				{
					spListadoPrestamos = new JScrollPane();
					jpListadoPrestamos.add(spListadoPrestamos);
					jpListadoPrestamos.add(getLblTexto());
					spListadoPrestamos.setBounds(30, 30, 497, 66);
					{
						TableModel jtPrestamosModel = 
								new DefaultTableModel(
										new String[][] { { "One", "Two" } },
										new String[] { "Código", "Descripción", "Fecha Emisión", "Monto" });
						jtPrestamos = new JTable();
						spListadoPrestamos.setViewportView(jtPrestamos);
						jtPrestamos.setModel(jtPrestamosModel);
					}
				}
				{
					btnAgregar = new JButton();
					jpListadoPrestamos.add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(228, 114, 106, 23);
					btnAgregar.setFont(new java.awt.Font("Century Gothic",0,12));
					btnAgregar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
					btnAgregar.setActionCommand("Agregar");
				}
			}
			{
				jpPrestamo = new JPanel();
				getContentPane().add(jpPrestamo);
				jpPrestamo.setLayout(null);
				jpPrestamo.setBounds(12, 141, 568, 133);
				jpPrestamo.setBorder(BorderFactory.createTitledBorder("Datos del Préstamo"));
				//jpPrestamo.setLayout(jpPrestamoLayout);
				{
					lblCodPrestamo = new JLabel();
					jpPrestamo.add(lblCodPrestamo);
					lblCodPrestamo.setText("Código de Prestamo:");
					lblCodPrestamo.setBounds(17, 26, 142, 16);
					lblCodPrestamo.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtCodPrestamo = new JTextField();
					jpPrestamo.add(txtCodPrestamo);
					txtCodPrestamo.setBounds(158, 23, 69, 23);
				}
				{
					lblPrestamos = new JLabel();
					getContentPane().add(lblPrestamos);
					getContentPane().add(getPnelEncabezado());
					lblPrestamos.setText("Préstamos");
					lblPrestamos.setBounds(230, 12, 114, 20);
					lblPrestamos.setFont(new java.awt.Font("Century Gothic",3,20));
				}
				{
					lblDescripcion = new JLabel();
					jpPrestamo.add(lblDescripcion);
					lblDescripcion.setText("Descripción :");
					lblDescripcion.setBounds(17, 57, 85, 16);
					lblDescripcion.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtDescripcion = new JTextField();
					jpPrestamo.add(txtDescripcion);
					txtDescripcion.setBounds(114, 54, 190, 23);
				}
				{
					lblMonto = new JLabel();
					jpPrestamo.add(lblMonto);
					lblMonto.setText("Monto Prestado:");
					lblMonto.setBounds(17, 89, 106, 16);
					lblMonto.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtMonto = new JTextField();
					jpPrestamo.add(txtMonto);
					txtMonto.setBounds(135, 86, 79, 23);
				}
				{
					lblBSF = new JLabel();
					jpPrestamo.add(lblBSF);
					lblBSF.setText("BsF.");
					lblBSF.setBounds(218, 89, 31, 16);
					lblBSF.setFont(new java.awt.Font("Verdana",0,12));
				}
			}
			pack();
			this.setSize(608, 380);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	
	public String getTxtNomSocio() {
		return txtNomSocio.getText();
	}
	public void setTxtNomSocio(String NomSocio)	{
		txtNomSocio.setText(NomSocio);
	}

	public void setTxtMonto(String Monto) {
		txtMonto.setText(Monto);
	}
	public String getTxtMonto() {
		return txtMonto.getText();
	}

	public String getTxtNroSocio() {
		return txtNroSocio.getText();
	}
	public void setTxtNroSocio(String NroSocio)	{
		txtNroSocio.setText(NroSocio);
	}

	
	public String getTxtDescripcion() {
		return txtDescripcion.getText();
	}
	public void setTxtDescripcion(String Descripcion)	{
		txtDescripcion.setText(Descripcion);
	}


	public String getTxtCodPrestamo() {
		return txtCodPrestamo.getText();
	}

	public void setTxtCodPrestamo(String CodPrestamo) {
		txtCodPrestamo.setText(CodPrestamo);
	}

	//agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnModificar.addActionListener(accion);
		this.btnSalir.addActionListener(accion);
		this.btnBuscarSocio.addActionListener(accion);
		this.btnAgregar.addActionListener(accion);
		this.txtNroSocio.addActionListener(accion);
		
	}

	//LimpiarCampos
	public void limpiarCampos() {
		txtCodPrestamo.setText("");
		txtDescripcion.setText("");
		txtMonto.setText("");
		txtNomSocio.setText("");
		txtNroSocio.setText("");
		this.limpiarTabla();

	}
	
	// Limpiar Tabla 
	public void limpiarTabla() {
	TableModel tblListadoModel = 
	new DefaultTableModel(
			new String[] { "Código", "Descripción", "Fecha", "Monto"},0);
	jtPrestamos.setModel(tblListadoModel);

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
		// retornamos el valor de la validación
		return CamposLLenos;
	}
	
	public boolean CamposllenosPrestamos() {

		boolean CamposLLenos = false;

		if (this.txtMonto.getText().equals("")) {
			// si falta el monto
			JOptionPane.showMessageDialog(null, "Debe ingresar el monto",
					"Error", 0);
			this.txtMonto.requestFocus();
			CamposLLenos = false;
		} else if (this.txtDescripcion.getText().equals("")) {
			// si falta la descripcion
			JOptionPane.showMessageDialog(null,
					"Debe ingresar la descripcion", "Error", 0);
			this.txtDescripcion.requestFocus();
			CamposLLenos = false;
		} else {
			// sino falta nada
			CamposLLenos = true;
		}
		// retornamos el valor de la validación
		return CamposLLenos;
	}


	public void OcultarTodo(){
		
		this.jpPrestamo.setVisible(false);
		this.jpListadoPrestamos.setVisible(false);
		this.jpDatosSocio.setVisible(true);
		this.spListadoPrestamos.setVisible(false);
		this.lblTexto.setVisible(false);
		this.btnAgregar.setVisible(false);
		this.btnGuardar.setVisible(false);
		this.btnModificar.setVisible(false);
		
	}
	
	
	public void OcultarListado(List<Prestamos> listPrest) throws Exception {
		if(listPrest.size() != 0) {
			
			this.jpListadoPrestamos.setVisible(true);
			this.btnAgregar.setVisible(true);
	
		}
		else {
			this.jpListadoPrestamos.setVisible(true);
			this.lblTexto.setVisible(true);
			this.btnAgregar.setVisible(true);
					
		}
	}
	
	
	public void Habilitar() {
		
		this.jpListadoPrestamos.setVisible(false);
		this.lblTexto.setVisible(false);
		this.btnAgregar.setVisible(false);
		this.jpPrestamo.setVisible(true);
		this.btnGuardar.setVisible(true);
		
	}
	
	
	// cerrar Ventana
	public void cerrarVentana() {
		// TODO Auto-generated method stub
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (ValorDevuelto == 0) {
			this.dispose();
		}
	}
	
	private JLabel getLblTexto() {
		if(lblTexto == null) {
			lblTexto = new JLabel();
			lblTexto.setText("El Socio no tiene prestamos!!");
			lblTexto.setBounds(170, 53, 179, 16);
			lblTexto.setFont(new java.awt.Font("Calibri",2,14));
		}
		return lblTexto;
	}
	
	
	public void asignarCod(){
		int codPrestamo;
		
		try {
			
			codPrestamo = prestamosDao.obtenerTodos().size()+1;
			if(codPrestamo<10)
			{
			 this.setTxtCodPrestamo("P-"+"000"+codPrestamo);
			}else if(codPrestamo<1000)
			{
				this.setTxtCodPrestamo("P-"+"00"+codPrestamo);
			}else
				this.setTxtCodPrestamo("P-"+"0"+codPrestamo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public void LlenarListaPrestamos(List<Prestamos> a){
		
		int column= jtPrestamos.getColumnCount();
		int fila= jtPrestamos.getRowCount();
		//List<Prestamos> a = new ArrayList<Prestamos>();
		String cod="", descrip="", monto="";
		Date fecha = new Date();
		String fecha1 = fecha.toString();
		
		
		for(int i=0; i<fila;i++)
		{		
			for(int j=0; j<a.size();j++){
				Prestamos pres= new Prestamos();
				
				cod=a.get(j).getCodPrestamo();
				descrip=a.get(j).getDescripcion();
				monto=Float.toString(a.get(j).getMonto());
				fecha=a.get(j).getFechaEmision();
				
				jtPrestamos.setValueAt(cod, i, 0);
				jtPrestamos.setValueAt(descrip, i, 1);
				jtPrestamos.setValueAt(fecha,i, 2);
				jtPrestamos.setValueAt(monto,i, 3);
				
			}
				
		}
	}

	private JPanel getPnelEncabezado() {
		if(pnelEncabezado == null) {
			pnelEncabezado = new JPanel();
			pnelEncabezado.setBounds(19, 4, 555, 62);
			pnelEncabezado.setBackground(new java.awt.Color(255,255,255));
			pnelEncabezado.setLayout(null);
			pnelEncabezado.add(getLblLogo());
		}
		return pnelEncabezado;
	}
	
	private JLabel getLblLogo() {
		if(lblLogo == null) {
			lblLogo = new JLabel();
			lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			lblLogo.setBounds(12, 0, 152, 61);
		}
		return lblLogo;
	}

}

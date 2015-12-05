package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import com.toedter.calendar.JDateChooser;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import org.joda.time.DateTime;

import Modelos.Beneficiario;
import Modelos.Prestamos;
import Modelos.Socio;
import Modelos.Vehiculo;

import com.toedter.calendar.JDateChooser;

import Modelos.Hibernate.Daos.BeneficiarioDao;
import Modelos.Hibernate.Daos.MarcaDao;
import Modelos.Hibernate.Daos.SocioDao;


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
public class VistaBeneficiario extends javax.swing.JFrame {

	private JPanel jpDatosBeneficiario;
	private JTextField txtCedulaRif;
	private JLabel lblNombre;
	private JTextField txtNombreSocio;
	private JButton btnBuscarSocio;
	private JLabel lblNombreSocio;
	private JTextField txtNroSocio;
	private JLabel lblNroSocio;
	private JPanel jpDatosSocio;
	private JLabel lblTitulo;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JButton btnBuscar;
	private JLabel lblCedulaRif;
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	//Mis DATOS
	private SocioDao socioDao= new SocioDao();
	private JComboBox cmbEstado;
	private JLabel lblEstado;
	private JLabel lblaños;
	private JLabel lblFecha;
	private JLabel lblTexto;
	private JLabel lblParentesco;
	private JComboBox cmbParentesco;
	private JTextField txtEdad;
	private JLabel lblEdad;
	private JTable tblListadoBenef;
	private JScrollPane spListadoBeneficiario;
	private JButton btnEliminarB;
	private JButton btnAgregar;
	private JPanel jpListadoBeneficiario;
	private JLabel lblImagen;
	private JPanel jpImagen;
	private BeneficiarioDao benDao=new BeneficiarioDao();
	private JDateChooser FechaNaci;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaBeneficiario inst = new VistaBeneficiario();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VistaBeneficiario() {
		super();
		initGUI();
	}
	
	
private static VistaBeneficiario vBeneficiario=null;
	
	public static VistaBeneficiario obtenerInstancia(){
		if(vBeneficiario==null)
			vBeneficiario= new VistaBeneficiario();
		return vBeneficiario;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jpDatosBeneficiario = new JPanel();
				getContentPane().add(jpDatosBeneficiario);
				jpDatosBeneficiario.setBounds(17, 147, 272, 334);
				jpDatosBeneficiario.setBorder(BorderFactory.createTitledBorder("Datos del Beneficiario"));
				jpDatosBeneficiario.setLayout(null);
				{
					lblCedulaRif = new JLabel();
					jpDatosBeneficiario.add(lblCedulaRif);
					lblCedulaRif.setText("Cédula:");
					lblCedulaRif.setBounds(10, 26, 48, 16);
				}
				{
					txtCedulaRif = new JTextField();
					jpDatosBeneficiario.add(txtCedulaRif);
					txtCedulaRif.setBounds(70, 23, 121, 23);
					txtCedulaRif.setActionCommand("BuscarBenefTecl");
				}
				{
					btnBuscar = new JButton();
					jpDatosBeneficiario.add(btnBuscar);
					btnBuscar.setBounds(204, 18, 34, 28);
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscar.setActionCommand("Buscar");
				}
				{
					lblNombre = new JLabel();
					jpDatosBeneficiario.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(11, 54, 54, 16);
				}
				{
					txtNombre = new JTextField();
					jpDatosBeneficiario.add(txtNombre);
					txtNombre.setBounds(71, 51, 174, 23);
				}
				{
					lblApellido = new JLabel();
					jpDatosBeneficiario.add(lblApellido);
					lblApellido.setText("Apellido:");
					lblApellido.setBounds(11, 82, 56, 16);
				}
				{
					txtApellido = new JTextField();
					jpDatosBeneficiario.add(txtApellido);
					txtApellido.setBounds(71, 79, 174, 23);
				}
				{
					lblDireccion = new JLabel();
					jpDatosBeneficiario.add(lblDireccion);
					lblDireccion.setText("Dirección:");
					lblDireccion.setBounds(11, 205, 58, 20);
				}
				{
					txtDireccion = new JTextField();
					jpDatosBeneficiario.add(txtDireccion);
					txtDireccion.setBounds(72, 198, 172, 35);
				}
				{
					lblTelefono = new JLabel();
					jpDatosBeneficiario.add(lblTelefono);
					lblTelefono.setText("Teléfono:");
					lblTelefono.setBounds(11, 236, 57, 29);
				}
				{
					txtTelefono = new JTextField();
					jpDatosBeneficiario.add(txtTelefono);
					txtTelefono.setBounds(72, 239, 172, 23);
				}
				{
					lblFecha = new JLabel();
					jpDatosBeneficiario.add(lblFecha);
					lblFecha.setText("Fecha Nacimiento: ");
					lblFecha.setBounds(11, 109, 118, 16);
				}
				{
					FechaNaci = new JDateChooser(new Date(),"DD/MM/YYYY");
					jpDatosBeneficiario.add(FechaNaci);
					FechaNaci.setLocale(Locale.getDefault());
					FechaNaci.setDateFormatString("XX/XX/XXXX");
					FechaNaci.setBounds(115, 107, 129, 23);
					FechaNaci.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
	  
				
							@Override
							public void propertyChange(PropertyChangeEvent arg0) {
								// TODO Auto-generated method stub
									edad();
							}
					});
				}
				{
					lblEdad = new JLabel();
					jpDatosBeneficiario.add(lblEdad);
					lblEdad.setText("Edad :");
					lblEdad.setBounds(18, 138, 36, 21);
				}
				{
					txtEdad = new JTextField();
					jpDatosBeneficiario.add(txtEdad);
					txtEdad.setBounds(71, 138, 36, 21);
				}
				{
					lblaños = new JLabel();
					jpDatosBeneficiario.add(lblaños);
					lblaños.setText("años");
					lblaños.setBounds(115, 140, 34, 13);
				}
				{
					lblParentesco = new JLabel();
					jpDatosBeneficiario.add(lblParentesco);
					lblParentesco.setText("Parentesco:");
					lblParentesco.setBounds(10, 169, 62, 20);
				}
				{				
					ComboBoxModel cmbParentescoModel = 
							new DefaultComboBoxModel(
									new String[] {"Seleccione una opción", "Madre", "Padre", "Hijo(a)", "Esposa(o)" });
					cmbParentesco = new JComboBox();
					jpDatosBeneficiario.add(cmbParentesco);
					cmbParentesco.setModel(cmbParentescoModel);
					cmbParentesco.setBounds(81, 165, 159, 26);
				}
				{
					lblEstado = new JLabel();
					jpDatosBeneficiario.add(lblEstado);
					lblEstado.setText("Estado: ");
					lblEstado.setBounds(11, 269, 47, 16);
				}
				{
					ComboBoxModel cmbEstadoModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccione una opción", "Activo", "Inactivo" });
					cmbEstado = new JComboBox();
					jpDatosBeneficiario.add(cmbEstado);
					cmbEstado.setModel(cmbEstadoModel);
					cmbEstado.setBounds(70, 268, 170, 23);
				}
				{					
					btnAgregar = new JButton();
					jpDatosBeneficiario.add(btnAgregar);
					btnAgregar.setText("Agregar Beneficiario");
					btnAgregar.setBounds(53, 283, 176, 24);
					btnAgregar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/add.png")));
					btnAgregar.setActionCommand("AgregarBeneficiario");
				}
				{
					btnModificar = new JButton();
					jpDatosBeneficiario.add(btnModificar);
					btnModificar.setText("Modifcar");
					btnModificar.setBounds(72, 300, 133, 25);
					btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/kwrite_22x22.png")));
					btnModificar.setActionCommand("Modificar");
				}
			}
			{
					jpListadoBeneficiario = new JPanel();
					getContentPane().add(jpListadoBeneficiario);
					jpListadoBeneficiario.setBounds(301, 170, 457, 276);
					jpListadoBeneficiario.setBorder(BorderFactory.createTitledBorder("Listado de Beneficiarios por Socio"));
					jpListadoBeneficiario.setLayout(null);
					{
						spListadoBeneficiario = new JScrollPane();
						jpListadoBeneficiario.add(spListadoBeneficiario);
						spListadoBeneficiario.setBounds(17, 35, 423, 169);
						{
							TableModel tblListadoBenefModel = 
									new DefaultTableModel(
											new String[][] {  },
											new String[] { "Cédula", "Nombre", "Edad", "Parentesco", "Telefono" });
							tblListadoBenef = new JTable();
							spListadoBeneficiario.setViewportView(tblListadoBenef);
							tblListadoBenef.setModel(tblListadoBenefModel);
						}
						
					}
					{
						lblTexto = new JLabel();
						jpListadoBeneficiario.add(lblTexto);
						lblTexto.setText("El socio no tiene Beneficiarios!!");
						lblTexto.setBounds(98, 121, 264, 16);
						lblTexto.setFont(new java.awt.Font("Segoe UI",2,16));
					}
					{
						btnEliminarB = new JButton();
						jpListadoBeneficiario.add(btnEliminarB);
						btnEliminarB.setText("Eliminar Beneficiario");
						btnEliminarB.setBounds(141, 237, 176, 24);
						btnEliminarB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/remove.png")));
						btnEliminarB.setActionCommand("EliminarBenef");
					}
			}
			{
				jpDatosSocio = new JPanel();
				getContentPane().add(jpDatosSocio);
				jpDatosSocio.setBounds(17, 84, 741, 57);
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				jpDatosSocio.setLayout(null);
				{					
					lblNroSocio = new JLabel();
					jpDatosSocio.add(lblNroSocio);
					lblNroSocio.setText("Número de Socio :");
					lblNroSocio.setBounds(17, 23, 119, 16);
				}
				{
					txtNroSocio = new JTextField();
					jpDatosSocio.add(txtNroSocio);
					txtNroSocio.setBounds(154, 20, 91, 23);
					txtNroSocio.setActionCommand("BuscarSocioTeclado");
				}
				{
					lblNombreSocio = new JLabel();
					jpDatosSocio.add(lblNombreSocio);
					lblNombreSocio.setText("Nombre :");
					lblNombreSocio.setBounds(367, 23, 53, 16);
				}
				{
					txtNombreSocio = new JTextField();
					jpDatosSocio.add(txtNombreSocio);
					txtNombreSocio.setBounds(432, 20, 195, 23);
				}
				{
					btnBuscarSocio = new JButton();
					jpDatosSocio.add(btnBuscarSocio);
					btnBuscarSocio.setBounds(250, 18, 29, 26);
					btnBuscarSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarSocio.setActionCommand("BuscarSocio");
				}
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(139, 488, 125, 27);
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setActionCommand("Cancelar");
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(313, 488, 125, 27);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setActionCommand("Limpiar");
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setBounds(485, 488, 125, 27);
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setActionCommand("Guardar");
			}
			{
				lblTitulo = new JLabel();
				getContentPane().add(lblTitulo);
				getContentPane().add(getJpImagen());
				lblTitulo.setText("Registrar Beneficiario");
				lblTitulo.setBounds(204, 39, 205, 24);
				lblTitulo.setFont(new java.awt.Font("Dialog",2,20));
			}
			pack();
			this.setSize(791, 567);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
public void Ocultar(){
		
		this.txtNombreSocio.setEditable(false);
		this.txtEdad.setEditable(false);
		this.txtEdad.setText("");
		
	}

public void editar(){
	
	this.txtCedulaRif.setEditable(false);
	this.txtNroSocio.setEditable(false);
	
}


public void regresar(){
	
	this.btnModificar.setVisible(false);
	this.cmbEstado.setVisible(false);
	this.btnAgregar.setVisible(true);
	this.lblEstado.setVisible(false);
	this.txtCedulaRif.setEditable(true);
	this.txtNroSocio.setEditable(true);
	
}


	
	
	
	public void setTxtEdad(String txtEdad) {
		this.txtEdad.setText(txtEdad);
	}
	public String getTxtEdad() {
		return txtEdad.getText();
	}

	public void setTxtNombreSocio(String txtNombreSocio) {
		this.txtNombreSocio.setText(txtNombreSocio);
	}
	public String getTxtNombreSocio() {
		return txtNombreSocio.getText();
	}

	public void setTxtNroSocio(String txtNroSocio) {
		this.txtNroSocio.setText(txtNroSocio);
	}
	public String getTxtNroSocio() {
		return txtNroSocio.getText();
	}

	public String getTxtCedulaRif() {
		return txtCedulaRif.getText();
	}

	public void setTxtCedulaRif(String txtCedulaRif) {
		this.txtCedulaRif.setText(txtCedulaRif);;
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public void setTxtDireccion(String txtDireccion) {
		this.txtDireccion.setText(txtDireccion);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}
	
	public Date getFechaNaci() {
		return FechaNaci.getDate();
	}
   	
	public void setFechaNaci(Date fechaNaci) {
		FechaNaci.setDate(fechaNaci);
	}

	//agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnModificar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		this.btnCancelar.addActionListener(accion);
		this.btnBuscarSocio.addActionListener(accion);
		this.btnAgregar.addActionListener(accion);
		this.btnEliminarB.addActionListener(accion);
		this.txtNroSocio.addActionListener(accion);
		this.txtCedulaRif.addActionListener(accion);
	}

	
	public void limpiarCamposSocio() {
		txtNroSocio.setText("");
		txtNombreSocio.setText("");
	}
	
	//LimpiarCampos
	public void limpiarCamposBenef() {
		txtApellido.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtCedulaRif.setText("");
		this.FechaNaci.setDate(new Date());
		this.cmbParentesco.setSelectedIndex(0);
		this.cmbEstado.setSelectedIndex(0);
		this.txtEdad.setText("");
	
	}

	
	public boolean CamposllenosSocio() {

		boolean CamposLLenos = false;

		if (this.txtNroSocio.getText().equals("")) {
			// si falta el nro socio
			JOptionPane.showMessageDialog(null, "Debe ingresar el numero del socio",
					"Error", 0);
			this.txtNroSocio.requestFocus();
			CamposLLenos = false;
		} else if (this.txtNombreSocio.equals("")) {
			// si falta el nombre del socio
			JOptionPane.showMessageDialog(null,
					"Debe ingresar el nombre del socio", "Error", 0);
			this.txtNombreSocio.requestFocus();
			CamposLLenos = false;
		} else {
			// sino falta nada
			CamposLLenos = true;
		}
		// retornamos el valor de la validación
		return CamposLLenos;
	}
	
	
	public boolean CamposLlenosBenef(){
		boolean CamposLLenos= false;
		
		if(txtCedulaRif.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar la cedula",
					"Error", 0);
			this.txtCedulaRif.requestFocus();
			CamposLLenos=false;
		}else if(txtApellido.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar el apellido",
					"Error", 0);
			this.txtApellido.requestFocus();
			CamposLLenos=false;
		}else if(txtDireccion.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar la dirección",
					"Error", 0);
			this.txtDireccion.requestFocus();
			CamposLLenos=false;
		}else if(txtEdad.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar la edad",
					"Error", 0);
			this.txtEdad.requestFocus();
			CamposLLenos=false;
		}else if(cmbParentesco.getSelectedItem().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar el parentesco",
					"Error", 0);
			this.cmbParentesco.requestFocus();
			CamposLLenos=false;
		}else if(txtNombre.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar el nombre",
					"Error", 0);
			this.txtNombre.requestFocus();
			CamposLLenos=false;
		}else if(txtTelefono.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar el numero de telefono",
					"Error", 0);
			this.txtTelefono.requestFocus();
			CamposLLenos=false;
		}else if(this.FechaNaci.equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar la fecha de nacimiento",
					"Error", 0);
			this.FechaNaci.requestFocus();
			CamposLLenos=false;
		}
		else 
			CamposLLenos=true;
		
		return CamposLLenos;
		
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

	
	
	public Socio SocioBusc(){
		int numSoc= Integer.parseInt(txtNroSocio.getText());
		Socio soc= new Socio();
		try {
			for(int i=0; i<socioDao.obtenerTodos().size(); i++){
				int num = Integer.parseInt(socioDao.obtenerTodos().get(i).getNroSocio());
				if(num==numSoc){
					soc= socioDao.obtenerTodos().get(i);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soc;
	}
	
	
	
	
	
	public void agregarFila(String cedula, String nombre,String edad, String parentesco,
			String direccion,String telefono)
	{
		Vector<String> beneficiario = new Vector<String>();

		beneficiario.add(cedula);
		beneficiario.add(nombre);
		beneficiario.add(edad);
		beneficiario.add(parentesco);
	//	beneficiario.add(direccion);
		beneficiario.add(telefono);
		
		
		DefaultTableModel dtm = (DefaultTableModel) tblListadoBenef.getModel();
		dtm.addRow(beneficiario);
	}
	
	public void removerFila(){
		 DefaultTableModel miTableModel = (DefaultTableModel) tblListadoBenef.getModel();
	     int indFil = tblListadoBenef.getSelectedRow();
	     System.out.println((String) miTableModel.getValueAt(indFil, 0));
	     if (indFil >= 0)
	          miTableModel.removeRow(indFil);
	}
	
	
	public int filaSeleccionada(){
		return tblListadoBenef.getSelectedRow()+1;
	}
	
	public String cedula(){
		String a="null";
		 DefaultTableModel miTableModel = (DefaultTableModel) tblListadoBenef.getModel();
	     int indFil = tblListadoBenef.getSelectedRow();
		 if(indFil>=0)   
			a= (String) miTableModel.getValueAt(indFil, 0);
		
		 return a;
	     
	}
	 public List<Beneficiario> LlenarListaBene()
	 {
		int fila= tblListadoBenef.getRowCount();
		List<Beneficiario> a = new ArrayList<Beneficiario>();
		String cedula,nombre,edad,parentesco,direccion,telefono;

		
		for(int i=0; i<fila;i++)
		{		
				Beneficiario b= new Beneficiario();
				
				cedula=(String) tblListadoBenef.getValueAt(i, 0);
				nombre=(String) tblListadoBenef.getValueAt(i, 1);
				edad=(String) tblListadoBenef.getValueAt(i, 2);
				parentesco=(String) tblListadoBenef.getValueAt(i, 3);
				//direccion=(String) tblListadoBenef.getValueAt(i, 4);
				telefono=(String) tblListadoBenef.getValueAt(i, 4);
							
				b.setCedBeneficiario(cedula);
				b.setNombre(nombre);
				b.setEdad(Integer.parseInt(edad));
				b.setParentesco(parentesco);
			//	b.setDireccion(direccion);
				b.setTelefono(Integer.parseInt(telefono));

				
				a.add(b);		
		}
	
	return a;
}
	
	 public void OcultarBotones() {
			
		 	this.btnModificar.setVisible(false);
		 	this.cmbEstado.setVisible(false);
		 	this.lblEstado.setVisible(false);
		 	this.btnAgregar.setVisible(true);
		}
	 
	 
	 public void MostarBotones() {
			
		 	this.btnModificar.setVisible(true);
		 	this.cmbEstado.setVisible(true);
		 	this.lblEstado.setVisible(true);
		 	this.btnAgregar.setVisible(false);
		}
	 
	 public void MostarListado() { 
		 	this.spListadoBeneficiario.setVisible(true);
		 	this.tblListadoBenef.setVisible(true);
			this.btnEliminarB.setVisible(true);
			this.lblTexto.setVisible(false);
		}
	 
	
	 public void OcultarListado(List<Beneficiario> listBenef) throws Exception {
			if(listBenef.size() != 0) {
				
				this.jpDatosBeneficiario.setVisible(true);
				this.jpListadoBeneficiario.setVisible(true);
				this.btnAgregar.setVisible(true);
				this.btnEliminarB.setVisible(true);
		
			}
			else {
				this.tblListadoBenef.setVisible(false);
				this.spListadoBeneficiario.setVisible(false);
				this.lblTexto.setVisible(true);
				this.btnEliminarB.setVisible(false);
						
			}
		}
	 
	
	// Limpiar Tabla Beneficiarios
			public void limpiarTablaBeneficiarios() {
			TableModel tblListadoModel = 
			new DefaultTableModel(
					new String[] {  "Cédula", "Nombre",  "Edad", "Parentesco", "Telefono" },0);
			tblListadoBenef.setModel(tblListadoModel);

			}	
			
	
	public void agregarKey(KeyListener a) {
		txtNroSocio.addKeyListener(a);
		txtTelefono.addKeyListener(a);
		txtCedulaRif.addKeyListener(a);
	}
	
	private JPanel getJpImagen() {
		if(jpImagen == null) {
			jpImagen = new JPanel();
			jpImagen.setBounds(17, 12, 746, 66);
			jpImagen.setBackground(new java.awt.Color(255,255,255));
			jpImagen.setLayout(null);
			jpImagen.add(getLblImagen());
		}
		return jpImagen;
	}
	
	private JLabel getLblImagen() {
		if(lblImagen == null) {
			lblImagen = new JLabel();
			lblImagen.setBounds(0, 0, 187, 66);
			lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
		}
		return lblImagen;
	}
	
	
	
	 //**Retorna el parentesco*//*
    public String getCmbParentesco(){
    	return cmbParentesco.getSelectedItem().toString();
    }
	
	public void setCmbParentesco(String cmbParentesco) {
		this.cmbParentesco.setSelectedItem(cmbParentesco);
	}
	
	
	 public String getCmbEstado() {
		return cmbEstado.getSelectedItem().toString();
	}

	public void setCmbEstado(String cmbEstado) {
		this.cmbEstado.setSelectedItem(cmbEstado);
	}

	public Integer calcularEdad(Date fecha){
		   Date fechaA=new Date();
		   if (fechaA.after(getFechaNaci()) == true){
		    		int anno=fechaA.getYear()-FechaNaci.getDate().getYear();
		        	int mes= fechaA.getMonth()- this.FechaNaci.getDate().getMonth();
		        	int dia= fechaA.getDay()- this.FechaNaci.getDate().getDay();
		        if(mes<0 || (mes==0 && dia<0)){
		            anno--;
		        }
		    
		        //Regresa la edad en base a la fecha de nacimiento
		        return anno;
		   }else 
			   this.validarEdad();
		return 0;
	 }
	
	public void validarEdad (/*int anno*/){
		
		//if (anno<0 )
		JOptionPane.showMessageDialog(null, "La fecha seleccionada no puede ser mayor a la actual ", "Atención!", JOptionPane.ERROR_MESSAGE);
	}
 
	 public void edad(){
		 
		Date fecha =  new Date();
		this.txtEdad.setText(this.calcularEdad(fecha).toString());
		 
	 }

}

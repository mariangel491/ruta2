package Vistas;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.common.collect.LinkedListModel;

import Controlador.ControladorRegistrarLocal;
import Modelos.Local;
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
public class VistaLocal extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	//Mis datos
	private LocalDao localdao=new LocalDao();
	DefaultListModel mod= new DefaultListModel ();
	private JScrollPane jScrollPaneMostrar;
	private JLabel lblLogo;
	private JPanel pnlEncabezado;
	
	
	private JPanel jpDatosLocal;
	private JLabel lblCodLocal;
	private JLabel lblNombreLocal;
	private JTextField txtNombre;
	private JLabel lblTitulo;
	private JButton btnModificar;
	private JButton btnLimpiar;
	private JList jListBusqueda;
	private JLabel lblBs;
	private JTextField txtCanon;
	private JLabel lblCanon;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JComboBox cmbTipo;
	private JTextField txtCodigo;
	private JLabel lblTipo;
	private JPanel jPanelMostrar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaLocal inst = new VistaLocal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaLocal vLocal=null;
	
	public static VistaLocal obtenerInstancia(){
		if(vLocal==null)
			vLocal= new VistaLocal();
		return vLocal;
	}
	
	
	public VistaLocal() {
		super();
		initGUI();	
		this.asignarCod();
		this.txtCodigo.setEnabled(false);
		this.jListBusqueda.setVisible(false);
		this.jPanelMostrar.setVisible(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFont(new java.awt.Font("Century Gothic",0,10));
			{
				jpDatosLocal = new JPanel();
				getContentPane().add(getJPanelMostrar());
				getContentPane().add(jpDatosLocal);
				jpDatosLocal.setBounds(16, 97, 429, 143);
				jpDatosLocal.setLayout(null);
				jpDatosLocal.setBorder(BorderFactory.createTitledBorder("Datos del Local"));
				{
					lblCodLocal = new JLabel();
					jpDatosLocal.add(lblCodLocal);
					lblCodLocal.setText("Código ");
					lblCodLocal.setBounds(37, 36, 42, 16);
				}
				{
					lblNombreLocal = new JLabel();
					jpDatosLocal.add(lblNombreLocal);
					lblNombreLocal.setText("Nombre");
					lblNombreLocal.setBounds(37, 64, 55, 16);
				}
				{
					lblTipo = new JLabel();
					jpDatosLocal.add(lblTipo);
					lblTipo.setText("Tipo");
					lblTipo.setBounds(37, 92, 32, 16);
				}
				{
					txtCodigo = new JTextField();
					jpDatosLocal.add(txtCodigo);
					txtCodigo.setBounds(91, 33, 139, 22);
				}
				{
					txtNombre = new JTextField();
					jpDatosLocal.add(txtNombre);
					txtNombre.setBounds(97, 61, 246, 23);
				}
				{
					ComboBoxModel cmbTipoModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccione una opción","Local Comercial", "Oficina" });
					cmbTipo = new JComboBox();
					jpDatosLocal.add(cmbTipo);
					cmbTipo.setModel(cmbTipoModel);
					cmbTipo.setBounds(91, 89, 252, 23);
				}
				{
					btnBuscar = new JButton();
					jpDatosLocal.add(btnBuscar);
					jpDatosLocal.add(getLblCanon());
					jpDatosLocal.add(getTxtCanon());
					jpDatosLocal.add(getLblBs());
					btnBuscar.setBounds(242, 30, 27, 26);
					btnBuscar.setToolTipText("Buscar");
					btnBuscar.setActionCommand("Buscar");
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
				}
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setActionCommand("Guardar");
				btnGuardar.setBounds(220, 255, 104, 28);
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setFont(new java.awt.Font("Segoe UI",0,11));
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setActionCommand("Cancelar");
				btnCancelar.setBounds(12, 255, 96, 28);
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setFont(new java.awt.Font("Segoe UI",0,11));
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setActionCommand("Limpiar");
				btnLimpiar.setBounds(113, 255, 100, 28);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setFont(new java.awt.Font("Segoe UI",0,11));
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				getContentPane().add(getPnlEncabezado());
				btnModificar.setText("Modificar");
				btnModificar.setActionCommand("Modificar");
				btnModificar.setBounds(335, 255, 113, 28);
				btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/kwrite_22x22.png")));
				btnModificar.setFont(new java.awt.Font("Segoe UI",0,11));
			}
			pack();
			this.setSize(514, 332);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public JPanel getJPanelMostrar() {
		if(jPanelMostrar == null) {
			jPanelMostrar = new JPanel();
			jPanelMostrar.setBounds(12, 92, 446, 157);
			jPanelMostrar.setLayout(null);
			jPanelMostrar.setBorder(BorderFactory.createTitledBorder("Listado de Locales"));
			jPanelMostrar.add(getJScrollPaneMostrar());
			jPanelMostrar.addMouseListener(new MouseAdapter() {
			});
			
		}
		return jPanelMostrar;
	}
	private JLabel getLblCanon() {
		if(lblCanon == null) {
			lblCanon = new JLabel();
			lblCanon.setText("Canón de Arrendamiento: ");
			lblCanon.setBounds(35, 123, 151, 14);
		}
		return lblCanon;
	}
	
	private JTextField getTxtCanon() {
		if(txtCanon == null) {
			txtCanon = new JTextField();
			txtCanon.setBounds(183, 120, 133, 20);
		}
		return txtCanon;
	}
	
	private JLabel getLblBs() {
		if(lblBs == null) {
			lblBs = new JLabel();
			lblBs.setText("Bs.");
			lblBs.setBounds(326, 123, 25, 14);
		}
		return lblBs;
	}

	public String getCanon(){
		return this.txtCanon.getText();
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombreLocal) {
		txtNombre.setText(txtNombreLocal);
	}

	public String getTxtCodigo() {
		return txtCodigo.getText();
	}

	public void setTxtCodigo(String txtCodigoLocal) {
		txtCodigo.setText(txtCodigoLocal);
	}

	public JComboBox getCmbTipo() {
		return cmbTipo;
	}

	public void setCmbTipo(JComboBox cmbTipo) {
		this.cmbTipo = cmbTipo;
	}


	public void agregarListener(ActionListener accion) {
		this.btnBuscar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnCancelar.addActionListener(accion);
		this.btnGuardar.addActionListener(accion);
		this.btnModificar.addActionListener(accion);
	}
	
	public void LimpiarCampos(){
		txtCodigo.setText("");
		txtNombre.setText("");
		cmbTipo.setSelectedItem("Seleccione una opción");
		txtCanon.setText("");
		//Para que cada vez que limpie la ventana, aparezca el nuevo codigo;
		this.asignarCod();
		this.ActivarComponentes();
		jListBusqueda.clearSelection();
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
	
	public void asignarCod(){
		int nro_local;
		
		try {
			nro_local = localdao.obtenerTodos().size()+1;
			if(nro_local<10)
			{
			 this.setTxtCodigo("L"+"000"+nro_local);
			}else if(nro_local<1000)
			{
				this.setTxtCodigo("L"+"00"+nro_local);
			}else
				this.setTxtCodigo("L"+"0"+nro_local);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JList getJListBusqueda() {
		if(jListBusqueda == null) {
			ListModel jListBusquedaModel = 
					new DefaultComboBoxModel(
							new String[] { });
			jListBusqueda = new JList();
			jListBusqueda.setModel(jListBusquedaModel);
			jListBusqueda.setBounds(16, 19, 400, 108);
			jListBusqueda.setPreferredSize(new java.awt.Dimension(498, 365));
			jListBusqueda.addMouseListener(mouseListener);
		}
		return jListBusqueda;
	}
	
	public void DesactivarComponentes(){
		this.lblBs.setVisible(false);
		this.lblCanon.setVisible(false);
		this.lblCodLocal.setVisible(false);
		this.lblNombreLocal.setVisible(false);
		this.lblTipo.setVisible(false);
		this.txtCanon.setVisible(false);
		this.txtCodigo.setVisible(false);
		this.txtNombre.setVisible(false);
		this.cmbTipo.setVisible(false);
		this.jPanelMostrar.setVisible(true);
		this.jListBusqueda.setVisible(true);
		this.jpDatosLocal.setVisible(false);
	}
	public void ActivarComponentes(){
		this.lblBs.setVisible(true);
		this.lblCanon.setVisible(true);
		this.lblCodLocal.setVisible(true);
		this.lblNombreLocal.setVisible(true);
		this.lblTipo.setVisible(true);
		this.txtCanon.setVisible(true);
		this.txtCodigo.setVisible(true);
		this.txtNombre.setVisible(true);
		this.cmbTipo.setVisible(true);
		this.jpDatosLocal.setVisible(true);
		this.jPanelMostrar.setVisible(false);
		this.jListBusqueda.setVisible(false);
		this.btnGuardar.setEnabled(true);
		
	}
	public void llenarLista(){
		this.DesactivarComponentes();
		this.btnGuardar.setEnabled(false);
		LinkedListModel<String> locales=new LinkedListModel<>();
		try {
			for(int i=0; i<localdao.obtenerTodos().size();i++){
				locales.add(localdao.obtenerTodos().get(i).getNombre());
			}
			jListBusqueda.setModel(locales);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int ItemSelec(){
		int selection;
		return selection=jListBusqueda.getSelectedIndex();
	}
	

	//EVENTO
	MouseListener mouseListener = new MouseAdapter() {
	      public void mouseClicked(MouseEvent mouseEvent) {
	        JList theList = (JList) mouseEvent.getSource();
	        if (mouseEvent.getClickCount() == 2) {
	          int index = theList.locationToIndex(mouseEvent.getPoint());
	          if (index >= 0) {
	            Object o = theList.getModel().getElementAt(index);
	            ItemSeleccionado();
	            ActivarComponentes();
	          }
	        }
	      }
	    };


	public void ItemSeleccionado(){
		try {
				
				Local loc= localdao.obtenerTodos().get(jListBusqueda.getSelectedIndex());
			
				this.txtNombre.setText(loc.getNombre());
				String canon= Float.toString(loc.getCanon());
				this.txtCanon.setText(canon);
				this.txtCodigo.setText(loc.getCodLocal());
				this.cmbTipo.setSelectedItem(loc.getTipo());
				this.btnGuardar.setEnabled(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void agregarKey(KeyListener a) {
		txtCanon.addKeyListener(a);
		
	}
	
	private JPanel getPnlEncabezado() {
		if(pnlEncabezado == null) {
			pnlEncabezado = new JPanel();
			pnlEncabezado.setBounds(12, 12, 446, 68);
			pnlEncabezado.setBackground(new java.awt.Color(255,255,255));
			pnlEncabezado.setLayout(null);
			pnlEncabezado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			{
				lblTitulo = new JLabel();
				pnlEncabezado.add(lblTitulo);
				pnlEncabezado.add(getLblLogo());
				lblTitulo.setText("Registrar Local");
				lblTitulo.setBounds(182, 21, 175, 27);
				lblTitulo.setFont(new java.awt.Font("Century Gothic",1,20));
			}
		}
		return pnlEncabezado;
	}
	
	private JLabel getLblLogo() {
		if(lblLogo == null) {
			lblLogo = new JLabel();
			lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			lblLogo.setBounds(4, 2, 152, 61);
		}
		return lblLogo;
	}
	
	private JScrollPane getJScrollPaneMostrar() {
		if(jScrollPaneMostrar == null) {
			jScrollPaneMostrar = new JScrollPane();
			jScrollPaneMostrar.setBounds(10, 18, 413, 129);
			jScrollPaneMostrar.setViewportView(getJListBusqueda());
		}
		return jScrollPaneMostrar;
	}

}

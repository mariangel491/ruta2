package Vistas;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.jgoodies.common.collect.LinkedListModel;

import Modelos.Egresos;
import Modelos.Local;
import Modelos.Hibernate.Daos.EgresosDao;


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
public class VistaEgresos extends javax.swing.JFrame {
	private JPanel jPanelVentana;
	private JPanel jPanelTitulo;
	private JPanel jPanelCargarDatos;
	private JTextField txtCodEgresO;
	private JLabel lblDescripEgreso;
	private JLabel lblClasificacion;
	private JComboBox cmbClasificacion;
	private JList jListBusqueda;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JTextField txtDescripcion;
	private JLabel lblCodigo;
	private JLabel lblTitulo;
	private JLabel lblimagen;
	private JButton btnBuscar;
	private JPanel jPanelLista;
	private JScrollPane jScrollPanelLista;

	//Mis datos
	private EgresosDao daoEg = new EgresosDao();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaEgresos inst = new VistaEgresos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static VistaEgresos vEg=null;
	
	public static VistaEgresos obtenerInstancia(){
		if(vEg==null)
			vEg= new VistaEgresos();
		return vEg;
	}
	public VistaEgresos() {
		super();
		initGUI();
		try {
			//System.out.println("cantidad egresos:   "+ daoEg.obtenerTodos().size());
			this.GenerarCodigo();
			this.txtCodEgresO.setEditable(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelVentana = new JPanel();
				getContentPane().add(jPanelVentana, "Center");
				jPanelVentana.setBounds(0, 0, 437, 274);
				jPanelVentana.setLayout(null);
				{
					jPanelTitulo = new JPanel();
					jPanelVentana.add(jPanelTitulo);
					jPanelTitulo.setBounds(0, 0, 437, 72);
					jPanelTitulo.setLayout(null);
					jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
					{
						lblTitulo = new JLabel();
						jPanelTitulo.add(lblTitulo);
						jPanelTitulo.add(getLblimagen());
						lblTitulo.setText("Registrar Egresos");
						lblTitulo.setBounds(162, 19, 192, 41);
						lblTitulo.setFont(new java.awt.Font("Century Gothic",2,20));
					}
				}
				{
					jPanelCargarDatos = new JPanel();
					jPanelVentana.add(jPanelCargarDatos);
					jPanelCargarDatos.setBounds(31, 84, 360, 127);
					jPanelCargarDatos.setBorder(BorderFactory.createTitledBorder("Datos del Egreso"));
					jPanelCargarDatos.setLayout(null);
					{
						lblCodigo = new JLabel();
						jPanelCargarDatos.add(lblCodigo);
						lblCodigo.setText("Código");
						lblCodigo.setBounds(47, 29, 47, 16);
						lblCodigo.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						txtCodEgresO = new JTextField();
						jPanelCargarDatos.add(txtCodEgresO);
						txtCodEgresO.setBounds(107, 27, 63, 23);
						txtCodEgresO.setEditable(true);
						txtCodEgresO.setFont(new java.awt.Font("Verdana",0,11));
						txtCodEgresO.setActionCommand("BEgreTecla");
					}
					{
						lblDescripEgreso = new JLabel();
						jPanelCargarDatos.add(lblDescripEgreso);
						lblDescripEgreso.setText("Descripción");
						lblDescripEgreso.setBounds(22, 62, 78, 16);
						lblDescripEgreso.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						txtDescripcion = new JTextField();
						jPanelCargarDatos.add(txtDescripcion);
						txtDescripcion.setBounds(107, 59, 236, 23);
						txtDescripcion.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						lblClasificacion = new JLabel();
						jPanelCargarDatos.add(lblClasificacion);
						lblClasificacion.setText("Clasificación");
						lblClasificacion.setBounds(17, 96, 83, 16);
						lblClasificacion.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						ComboBoxModel cmbClasificacionModel = 
								new DefaultComboBoxModel(
										new String[] { "Ruta","Alquiler", "Fondo Choque" });
						cmbClasificacion = new JComboBox();
						jPanelCargarDatos.add(cmbClasificacion);
						jPanelCargarDatos.add(getBtnBuscar());
						cmbClasificacion.setModel(cmbClasificacionModel);
						cmbClasificacion.setBounds(107, 93, 186, 23);
						cmbClasificacion.setFont(new java.awt.Font("Verdana",0,11));
					}
				}
				{
					btnGuardar = new JButton();
					jPanelVentana.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(21, 228, 123, 29);
					btnGuardar.setFont(new java.awt.Font("Verdana",0,11));
					btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
					btnGuardar.setActionCommand("Guardar");
				}
				{
					btnLimpiar = new JButton();
					jPanelVentana.add(btnLimpiar);
					btnLimpiar.setText("Limpiar");
					btnLimpiar.setBounds(151, 228, 123, 29);
					btnLimpiar.setFont(new java.awt.Font("Verdana",0,11));
					btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
					btnLimpiar.setText("Limpiar");
				}
				{
					btnSalir = new JButton();
					jPanelVentana.add(btnSalir);
					jPanelVentana.add(getJPanelLista());
					btnSalir.setText("Salir");
					btnSalir.setBounds(280, 228, 123, 29);
					btnSalir.setFont(new java.awt.Font("Verdana",0,11));
					btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
					btnSalir.setActionCommand("Salir");
				}
			}
			pack();
			this.setSize(438, 320);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JComboBox getCmbClasificacion() {
		return cmbClasificacion;
	}
	public void setCmbClasificacion(JComboBox cmbClasificacion) {
		this.cmbClasificacion = cmbClasificacion;
	}
	public String getTxtCodEgresO() {
		return txtCodEgresO.getText();
	}
	public void setTxtCodEgresO(String CodEgreso) {
		txtCodEgresO.setText(CodEgreso);
	}
	public String getTxtDescripcion() {
		return txtDescripcion.getText();
	}
	public void setTxtDescripcion(String Descripcion) {
		this.txtDescripcion.setText(Descripcion);
	}
	//agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnSalir.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		this.txtCodEgresO.addActionListener(accion);
	}

	//LimpiarCampos
	public void limpiarCampos() {
		txtCodEgresO.setText("");
		txtDescripcion.setText("");
		try {
			this.GenerarCodigo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DesactivarComponentes(){
		this.jPanelCargarDatos.setVisible(false);
	}
	
	public void ActivarComponentes(){
		this.jPanelCargarDatos.setVisible(true);
	}
	
	public void llenarLista(){
		this.DesactivarComponentes();
		this.btnGuardar.setEnabled(false);
		LinkedListModel<String> egresos=new LinkedListModel<>();
		try {
			for(int i=0; i<daoEg.obtenerTodos().size();i++){
				if(daoEg.obtenerTodos().get(i).getClasificacion().equalsIgnoreCase(this.getCmbClasificacion().getSelectedItem().toString())==true)
					egresos.add(daoEg.obtenerTodos().get(i).getDescripcion());
				else
					egresos.add(daoEg.obtenerTodos().get(i).getDescripcion());
			}
			jListBusqueda.setModel(egresos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GenerarCodigo() 
	{		
		//int cantEgresos=0;
		try {
		int	cantEgresos = daoEg.obtenerTodos().size()+1;
		//	System.out.println("cant egresos"+ cantEgresos);
			if(cantEgresos<10)
			{
				this.setTxtCodEgresO("E000"+cantEgresos);
			}else if(cantEgresos<100){
				this.setTxtCodEgresO("E00"+cantEgresos);
			}else if(cantEgresos<1000)
			{
				this.setTxtCodEgresO("E0"+cantEgresos);
			}
			else 
				this.setTxtCodEgresO("E"+cantEgresos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List<Egresos> prueba= daoEg.obtenerTodos();
		//System.out.println(prueba.size());
		
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
	
	private JButton getBtnBuscar() {
		if(btnBuscar == null) {
			btnBuscar = new JButton();
			btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
			btnBuscar.setBounds(176, 26, 30, 23);
			btnBuscar.setActionCommand("Buscar");
		}
		btnBuscar.setActionCommand("Buscar");
		return btnBuscar;
		
	}
	
	private JLabel getLblimagen() {
		if(lblimagen == null) {
			lblimagen = new JLabel();
			lblimagen.setBounds(2, 7, 154, 65);
			lblimagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
		}
		return lblimagen;
	}
	
	private JPanel getJPanelLista() {
		if(jPanelLista == null) {
			jPanelLista = new JPanel();
			//jPanelLista.setLayout(jPanelListaLayout);
			jPanelLista.setBounds(16, 83, 387, 130);
			jPanelLista.setBorder(BorderFactory.createTitledBorder("Listado de Egresos"));
			jPanelLista.add(getJScrollPanelLista());
			jPanelLista.addMouseListener(new MouseAdapter() {
			});
		}
		return jPanelLista;
	}
	
	private JScrollPane getJScrollPanelLista() {
		if(jScrollPanelLista == null) {
			jScrollPanelLista = new JScrollPane();
			jScrollPanelLista.setPreferredSize(new java.awt.Dimension(353, 96));
			jScrollPanelLista.setViewportView(getJListBusqueda());
		}
		return jScrollPanelLista;
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
					
					Egresos egreso= daoEg.obtenerTodos().get(jListBusqueda.getSelectedIndex());
				
					this.txtDescripcion.setText(egreso.getDescripcion());
					this.txtCodEgresO.setText(egreso.getCodEgreso());
					this.cmbClasificacion.setSelectedItem(egreso.getClasificacion());
					this.btnGuardar.setEnabled(true);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		private JList getJListBusqueda() {
			if(jListBusqueda == null) {
				ListModel jListBusquedaModel = 
						new DefaultComboBoxModel(
								new String[] { });
				jListBusqueda = new JList();
				jListBusqueda.addMouseListener(mouseListener);
			}
			return jListBusqueda;
		}
}

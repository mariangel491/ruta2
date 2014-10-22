package Vistas;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import Modelos.Socio;

import com.jgoodies.common.collect.LinkedListModel;


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
public class VistaCaja extends javax.swing.JFrame {
	private JPanel jPanelTitulo;
	private JLabel lblLogo;
	private JTextField txtMontoCaja;
	private JTextField txtMontoADepositar;
	private JButton btnCancelar;
	private JButton btnDepositar;
	private JTable jTableDeposito;
	private JScrollPane jScrollPaneDeposito;
	private JTable jTableCaja;
	private JScrollPane jScrollPaneCaja;
	private JButton btnQuitarTodos;
	private JButton btnQuitarUno;
	private JButton btnAgregarTodos;
	private JButton btnAgregarUno;
	private JLabel lblBsCaja;
	private JLabel lblBsDep;
	private JLabel lblTotal;
	private JPanel jPanelADepositar;
	private JPanel jPanelEnCaja;
	private JPanel jPanelCaja;
	private JLabel lblTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaCaja inst = new VistaCaja();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static VistaCaja vCaja=null;
	public static VistaCaja obtenerInstancia(){
		if(vCaja==null)
			vCaja=new VistaCaja();
		return vCaja;
	}
	public VistaCaja() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelTitulo = new JPanel();
				getContentPane().add(jPanelTitulo, "Center");
				getContentPane().add(getJPanelCaja());
				getContentPane().add(getBtnDepositar());
				getContentPane().add(getBtnCancelar());
				jPanelTitulo.setBounds(9, 7, 715, 68);
				jPanelTitulo.setLayout(null);
				jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
				{
					lblLogo = new JLabel();
					jPanelTitulo.add(lblLogo);
					lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
					lblLogo.setBounds(12, 4, 153, 61);
				}
				{
					lblTitulo = new JLabel();
					jPanelTitulo.add(lblTitulo);
					lblTitulo.setText("Registrar Deposito de la Caja");
					lblTitulo.setBounds(207, 19, 321, 29);
					lblTitulo.setFont(new java.awt.Font("Segoe UI",2,22));
				}
			}
			pack();
			this.setSize(748, 490);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getJPanelCaja() {
		if(jPanelCaja == null) {
			jPanelCaja = new JPanel();
			jPanelCaja.setBounds(12, 99, 708, 309);
			jPanelCaja.setBorder(BorderFactory.createTitledBorder("Información de los depositos de la caja"));
			jPanelCaja.setLayout(null);
			jPanelCaja.add(getJPanelEnCaja());
			jPanelCaja.add(getJPanelADepositar());
			jPanelCaja.add(getLblTotal());
			jPanelCaja.add(getTxtMontoCaja());
			jPanelCaja.add(getTxtMontoADepositar());
			jPanelCaja.add(getLblBsDep());
			jPanelCaja.add(getLblBsCaja());
			jPanelCaja.add(getBtnAgregarUno());
			jPanelCaja.add(getBtnAgregarTodos());
			jPanelCaja.add(getBtnQuitarUno());
			jPanelCaja.add(getBtnQuitarTodos());
		}
		return jPanelCaja;
	}
	
	private JPanel getJPanelEnCaja() {
		if(jPanelEnCaja == null) {
			jPanelEnCaja = new JPanel();
			jPanelEnCaja.setBounds(27, 29, 271, 238);
			jPanelEnCaja.setLayout(null);
			jPanelEnCaja.setBorder(BorderFactory.createTitledBorder("En caja"));
			jPanelEnCaja.add(getJScrollPaneCaja());
		}
		return jPanelEnCaja;
	}
	
	private JPanel getJPanelADepositar() {
		if(jPanelADepositar == null) {
			jPanelADepositar = new JPanel();
			jPanelADepositar.setBounds(387, 30, 294, 238);
			jPanelADepositar.setLayout(null);
			jPanelADepositar.setBorder(BorderFactory.createTitledBorder("A Depositar"));
			jPanelADepositar.add(getJScrollPaneDeposito());
		}
		return jPanelADepositar;
	}

	private JLabel getLblTotal() {
		if(lblTotal == null) {
			lblTotal = new JLabel();
			lblTotal.setText("TOTAL");
			lblTotal.setBounds(315, 278, 50, 16);
			lblTotal.setFont(new java.awt.Font("Segoe UI",1,14));
		}
		return lblTotal;
	}
	
	private JTextField getTxtMontoCaja() {
		if(txtMontoCaja == null) {
			txtMontoCaja = new JTextField();
			txtMontoCaja.setBounds(67, 274, 170, 23);
		}
		return txtMontoCaja;
	}
	
	private JTextField getTxtMontoADepositar() {
		if(txtMontoADepositar == null) {
			txtMontoADepositar = new JTextField();
			txtMontoADepositar.setBounds(444, 276, 180, 23);
		}
		return txtMontoADepositar;
	}
	
	private JLabel getLblBsDep() {
		if(lblBsDep == null) {
			lblBsDep = new JLabel();
			lblBsDep.setText("Bs.");
			lblBsDep.setBounds(636, 279, 15, 16);
		}
		return lblBsDep;
	}
	
	private JLabel getLblBsCaja() {
		if(lblBsCaja == null) {
			lblBsCaja = new JLabel();
			lblBsCaja.setText("Bs.");
			lblBsCaja.setBounds(245, 279, 25, 16);
		}
		return lblBsCaja;
	}
	
	private JButton getBtnAgregarUno() {
		if(btnAgregarUno == null) {
			btnAgregarUno = new JButton();
			btnAgregarUno.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/agregar.png")));
			btnAgregarUno.setBounds(324, 67, 38, 31);
			btnAgregarUno.setActionCommand("AgregarUno");
		}
		return btnAgregarUno;
	}
	
	private JButton getBtnAgregarTodos() {
		if(btnAgregarTodos == null) {
			btnAgregarTodos = new JButton();
			btnAgregarTodos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/agrergarTodos.png")));
			btnAgregarTodos.setBounds(324, 113, 38, 31);
			btnAgregarTodos.setActionCommand("AgregarTodos");
		}
		return btnAgregarTodos;
	}
	
	private JButton getBtnQuitarUno() {
		if(btnQuitarUno == null) {
			btnQuitarUno = new JButton();
			btnQuitarUno.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/quitarUno.png")));
			btnQuitarUno.setBounds(324, 160, 38, 31);
			btnQuitarUno.setActionCommand("QuitarUno");
		}
		return btnQuitarUno;
	}
	
	private JButton getBtnQuitarTodos() {
		if(btnQuitarTodos == null) {
			btnQuitarTodos = new JButton();
			btnQuitarTodos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/quitarTodos.png")));
			btnQuitarTodos.setBounds(324, 206, 38, 31);
			btnQuitarTodos.setActionCommand("QuitarTodos");
		}
		return btnQuitarTodos;
	}
	
	private JScrollPane getJScrollPaneCaja() {
		if(jScrollPaneCaja == null) {
			jScrollPaneCaja = new JScrollPane();
			jScrollPaneCaja.setBounds(17, 30, 237, 184);
			jScrollPaneCaja.setViewportView(getJTableCaja());
		}
		return jScrollPaneCaja;
	}
	
	private JTable getJTableCaja() {
		if(jTableCaja == null) {
			TableModel jTableCajaModel = 
					new DefaultTableModel(
							new String[][] { { "", "" }, { "", "" } },
							new String[] { "Descripción", "Monto" });
			jTableCaja = new JTable();
			jTableCaja.setModel(jTableCajaModel);
		}
		return jTableCaja;
	}
	
	private JScrollPane getJScrollPaneDeposito() {
		if(jScrollPaneDeposito == null) {
			jScrollPaneDeposito = new JScrollPane();
			jScrollPaneDeposito.setBounds(17, 30, 260, 181);
			jScrollPaneDeposito.setViewportView(getJTableDeposito());
		}
		return jScrollPaneDeposito;
	}
	
	private JTable getJTableDeposito() {
		if(jTableDeposito == null) {
			TableModel jTableDepositoModel = 
					new DefaultTableModel(
							new String[][] { { "", "" }, { "", "" } },
							new String[] { "Descripción", "Monto" });
			jTableDeposito = new JTable();
			jTableDeposito.setModel(jTableDepositoModel);	
		}
		return jTableDeposito;
	}
	
	private JButton getBtnDepositar() {
		if(btnDepositar == null) {
			btnDepositar = new JButton();
			btnDepositar.setText("Depositar");
			btnDepositar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/money.png")));
			btnDepositar.setBounds(192, 416, 133, 31);
			btnDepositar.setActionCommand("Depositar");
		}
		return btnDepositar;
	}
	
	private JButton getBtnCancelar() {
		if(btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
			btnCancelar.setBounds(384, 416, 116, 29);
			btnCancelar.setActionCommand("Cancelar");
		}
		return btnCancelar;
	}
	
	
	
	public JTable getjTableDeposito() {
		return jTableDeposito;
	}

	public JTable getjTableCaja() {
		return jTableCaja;
	}

	public void setTxtMontoCaja(String txtMontoCaja) {
		this.txtMontoCaja.setText(txtMontoCaja);;
	}

	public void setTxtMontoADepositar(String txtMontoADepositar) {
		this.txtMontoADepositar.setText(txtMontoADepositar);
	}

	public void setjTableDeposito(JTable jTableDeposito) {
		this.jTableDeposito = jTableDeposito;
	}

	public void setjTableCaja(JTable jTableCaja) {
		this.jTableCaja = jTableCaja;
	}

	//LIMPIAR CAMPOS	
	public void limpiarCampos(){
		this.setTxtMontoADepositar("");
		this.setTxtMontoCaja("");
		this.jTableCaja.removeAll();
		this.jTableDeposito.removeAll();
	}
	
	public void agregarKey(KeyListener a) {
		txtMontoADepositar.addKeyListener(a);
		txtMontoCaja.addKeyListener(a);
	}
	
	public void agregarListener(ActionListener accion) 
	{
		btnAgregarTodos.addActionListener(accion);
		btnAgregarUno.addActionListener(accion);
		btnCancelar.addActionListener(accion);
		btnDepositar.addActionListener(accion);
		btnQuitarTodos.addActionListener(accion);
		btnQuitarUno.addActionListener(accion);
	}

	public void agregarFilaCaja(String descripcion, String monto)
	{
		Vector<String> caja = new Vector<String>();

		caja.add(descripcion);
		caja.add(monto);
		
		DefaultTableModel dtm = (DefaultTableModel) jTableCaja.getModel();
		dtm.addRow(caja);	
	}

	public void removerFilaCaja(){
		 DefaultTableModel miTableModel = (DefaultTableModel) jTableCaja.getModel();
	     int indFil = jTableCaja.getSelectedRow();
	     if (indFil >= 0)
	          miTableModel.removeRow(indFil);
	}
	
	public int filaSeleccionadaCaja(){
		return jTableCaja.getSelectedRow()+1;
	}
	
	public void agregarFilaDeposito(String descripcion, String monto)
	{
		Vector<String> cajaDep = new Vector<String>();

		cajaDep.add(descripcion);
		cajaDep.add(monto);
		
		DefaultTableModel dtm = (DefaultTableModel) jTableDeposito.getModel();
		dtm.addRow(cajaDep);	
	}

	public void removerFilaDeposito(){
		 DefaultTableModel miTableModel = (DefaultTableModel) jTableDeposito.getModel();
	     int indFil = jTableDeposito.getSelectedRow();
	     if (indFil >= 0)
	          miTableModel.removeRow(indFil);
	}
	
	public int filaSeleccionadaDeposito(){
		return jTableDeposito.getSelectedRow()+1;
	}
	
	public void limpiarTablaCaja() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] { "Descripción", "Monto"},0);
		jTableCaja.setModel(tblListadoModel);

		}	
	
	public void limpiarTablaDeposito() {
		TableModel tblListadoModel = 
		new DefaultTableModel(
				new String[] { "Descripción", "Monto"},0);
		jTableDeposito.setModel(tblListadoModel);

		}
	
	public void CampoSeleccionado(MouseEvent me){
		System.out.println(jTableCaja.getSelectedRow());
	}
	
}

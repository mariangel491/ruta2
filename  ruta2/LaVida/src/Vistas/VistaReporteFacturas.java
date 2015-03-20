package Vistas;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import ControladorReportes.ControladorReporteFactura;

import com.toedter.calendar.JDateChooser;



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
public class VistaReporteFacturas extends javax.swing.JFrame {
	private JPanel jpCriterioBusqueda;
	private JComboBox cmbReportes;
	private JButton btnMostrar;
	private JButton btnLimpiar;
	private JDateChooser FechaFin;
	private JPanel jpImagen;
	private JDateChooser FechaIni;
	private JLabel lblTipoReporte;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JLabel lblTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			//	VistaReporteFacturas inst = new VistaReporteFacturas(null);
				//inst.setLocationRelativeTo(null);
				//inst.setVisible(true);
			}
		});
	}
	
	public VistaReporteFacturas(ControladorReporteFactura crf) {
		super();
		initGUI();
		cmbReportes.addItemListener(crf);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jpCriterioBusqueda = new JPanel();
				getContentPane().add(jpCriterioBusqueda);
				//jpCriterioBusqueda.setLayout(jpCriterioBusquedaLayout);
				jpCriterioBusqueda.setBounds(22, 87, 387, 128);
				jpCriterioBusqueda.setBorder(BorderFactory.createTitledBorder("Criterio de Busqueda"));
				jpCriterioBusqueda.setLayout(null);
				{
					ComboBoxModel cmbReportesModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccione una opción", "Diario", "Por rango de fecha" });
					cmbReportes = new JComboBox();
					jpCriterioBusqueda.add(cmbReportes);
					cmbReportes.setModel(cmbReportesModel);
					cmbReportes.setBounds(130, 30, 213, 24);
				}
				{
					lblTipoReporte = new JLabel();
					jpCriterioBusqueda.add(lblTipoReporte);
					lblTipoReporte.setText("Tipo de Reporte :");
					lblTipoReporte.setBounds(29, 34, 101, 16);
				}
				{
					lblDesde = new JLabel();
					jpCriterioBusqueda.add(lblDesde);
					lblDesde.setText("Desde: ");
					lblDesde.setBounds(30, 91, 57, 20);
				}
				{
					FechaIni = new JDateChooser(new Date(),"DD/MM/YYYY");
					jpCriterioBusqueda.add(FechaIni);
					FechaIni.setBounds(87, 90, 97, 23);
					FechaIni.setDateFormatString("XX/XX/XXXX");
					FechaIni.setLocale(Locale.getDefault());
				}
				{
					lblHasta = new JLabel();
					jpCriterioBusqueda.add(lblHasta);
					lblHasta.setText("Hasta: ");
					lblHasta.setBounds(215, 91, 51, 20);
				}
				{
					FechaFin = new JDateChooser(new Date(),"DD/MM/YYYY");
					jpCriterioBusqueda.add(FechaFin);
					FechaFin.setBounds(264, 88, 106, 23);
					FechaFin.setDateFormatString("XX/XX/XXXX");
					FechaFin.setLocale(Locale.getDefault());
				}
			}
			{
				btnMostrar = new JButton();
				getContentPane().add(btnMostrar);
				btnMostrar.setText("Mostrar");
				btnMostrar.setBounds(67, 232, 108, 32);
				btnMostrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Lists.gif")));
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(238, 234, 112, 30);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
			}
			{
				jpImagen = new JPanel();
				getContentPane().add(jpImagen);
				jpImagen.setBackground(new java.awt.Color(255,255,255));
				jpImagen.setBounds(0, 0, 434, 69);
				jpImagen.setLayout(null);
			}
			{
				lblTitulo = new JLabel();
				jpImagen.add(lblTitulo);
				lblTitulo.setBounds(255, 12, 90, 40);
				lblTitulo.setText("Reportes por Factura");
				lblTitulo.setBounds(0, 0, 434, 69);
				lblTitulo.setFont(new java.awt.Font("Century Gothic",2,18));
				lblTitulo.setBackground(new java.awt.Color(0,64,128));
				lblTitulo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			}
			pack();
			this.setSize(450, 321);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public int getClasificacion ()
	{
		return cmbReportes.getSelectedIndex();
	}

	
}

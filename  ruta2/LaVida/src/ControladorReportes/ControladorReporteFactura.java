package ControladorReportes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;






import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import Vistas.VistaReporteFacturas;

public class ControladorReporteFactura extends MouseAdapter implements ActionListener, ItemListener{
	
	private VistaReporteFacturas vrp;
	private Connection con;

	

	public ControladorReporteFactura() {
		super();
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDRuta2","postgres","postgres");
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		/*
		 * Si el usuario presiona el boton de mostrar primero se verifica que haya elegido un criterio de busqueda
		 * */
		if(ae.getActionCommand().equalsIgnoreCase("mostrar")){
			if(vrp.getClasificacion() == 0)
				JOptionPane.showMessageDialog(null,"Debe indicar un criterio de busqueda!");
			else{
				if(vrp.getClasificacion() == 1) {
					
					String ruta=new File("").getAbsolutePath() + "/src/Reportes/ReporteFacturaDiaria.jrxml";
					try {
						JasperReport reporte = JasperCompileManager.compileReport(ruta);
						JasperPrint print = JasperFillManager.fillReport(reporte, null, con);
						JasperViewer.viewReport(print, false);
					} catch (JRException JRException){
						JOptionPane.showMessageDialog(null, "Error al crear el reporte", "Advertencia!", 0);
					}
					
					
				}else{
					if(vrp.getClasificacion() == 2) {
						
						String ruta=new File("").getAbsolutePath() + "/src/Reportes/ReporteFactura.jrxml";
						try {
							JasperReport reporte = JasperCompileManager.compileReport(ruta);
							JasperPrint print = JasperFillManager.fillReport(reporte, null, con);
							JasperViewer.viewReport(print, false);
						} catch (JRException JRException){
							JOptionPane.showMessageDialog(null, "Error al crear el reporte", "Advertencia!", 0);
						}
						
					}
					else {	
				
				 //Si no es ninguna de las opciones es porque no se indico ninguna clasificacion
				 JOptionPane.showMessageDialog(null,"Debe indicar un criterio de busqueda!","Atencion!",JOptionPane.ERROR_MESSAGE);
				 		 // return;
				 		  
					}
				 }
			}
			
		}
	}

}

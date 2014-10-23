package ControladorReportes;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ControladorReporte {

	/*private Connection conn;
     private final String login = "postgres"; //usuario de acceso a MySQL
     private final String password = "postgres"; //contraseña de usuario
     private String url = "jdbc:postgresql://localhost:5432/BDRuta2";
     public ControladorReporte() {
		// TODO Auto-generated constructor stub      
         try 
         {
             Class.forName("org.postgresql.Driver"); //se carga el driver
             conn = DriverManager.getConnection(url,login,password);
         } 
         catch (ClassNotFoundException ex) 
         {
             ex.printStackTrace();
         } 
         catch (SQLException ex) 
         {
             ex.printStackTrace();
         }
     }
     
     public void runReporte(String consulta )
     {
         try
         {  
             String fileName = System.getProperty("user.dir") +"/src/Reportes/Prueba.jrxml";
            
             if (fileName == null) 
             {                
                 System.out.println("No encuentro el archivo del reporte.");
                 System.exit(2);
             }             
         File theFile = new File(fileName);
         JRDesignQuery newQuery = new JRDesignQuery();
         JasperDesign jasperDesign = JRXmlLoader.load(theFile);
         newQuery.setText("SELECT * FROM socio");
         jasperDesign.setQuery(newQuery);
         
          JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
          JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(),  new JREmptyDataSource());
          JasperViewer jviewer = new JasperViewer(jasperPrint,false);
          jviewer.setTitle("Sistema de gestión de Cartera");
          jviewer.setVisible(true);  
         }
         catch (Exception j)
         {
             System.out.println("Mensaje de Error:"+j.getMessage());
         }
         
     }
     
     public void cerrar()
     {
                 try 
                 {
                     conn.close();
                 } 
                 catch (SQLException ex) 
                 {
                     ex.printStackTrace();
                 }
     }
	*/
	
	
	  static Connection conn = null;
		 
		 
		  public void runReporte() {
		    // Cargamos el driver JDBC
			  
			  String ruta= System.getProperty("user.dir") +"/src/Reportes/ReporteSocios.jrxml";
		    try {
		      Class.forName("org.postgresql.Driver");
		    }
		    catch (ClassNotFoundException e) {
		      System.out.println("MySQL JDBC Driver not found.");
		      System.exit(1);
		    }
		    //Para iniciar el Logger.
		    //inicializaLogger();
		    try {
		      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDRuta2","postgres", "postgres");
		      //conn.setAutoCommit(false);
		    }
		    catch (SQLException e) {
		      System.out.println("Error de conexión: " + e.getMessage());
		      System.exit(4);
		    }
		 
		    try {
		      Map parameters = new HashMap();
		     // parameters.put("TITULO", "PAISES");
		     // parameters.put("FECHA", new java.util.Date());
		      JasperReport report = JasperCompileManager.compileReport(ruta);
		      JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
		      // Exporta el informe a PDF
		     // JasperExportManager.exportReportToPdfFile(print,ruta);
		      //Para visualizar el pdf directamente desde java
		      JasperViewer.viewReport(print, false);
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    finally {
		     
		      try {
		        if (conn != null) {
		          //conn.rollback();
		          System.out.println("ROLLBACK EJECUTADO");
		          conn.close();
		        }
		      }
		      catch (Exception e) {
		        e.printStackTrace();
		      }
		    }
		 
		  }
	
}



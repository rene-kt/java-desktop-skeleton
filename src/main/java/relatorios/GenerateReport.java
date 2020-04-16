/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ClasseFilhaDao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Informática
 */
public class GenerateReport {
    
    private static List lista; 
    
    
    public static void generate(Class clazz) {
        switch (clazz.getName()) {
            case "NOME DA SUA CLASSE":
                //INSTANCIE SUA CLASSE 
                ClasseFilhaDao dao = new ClasseFilhaDao();
                lista = dao.findAll(clazz);
                break;

        }
        try {

            JasperReport pathjrxml = JasperCompileManager.compileReport("relatorio/reportex.jrxml");
            JasperPrint print = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(lista));

            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

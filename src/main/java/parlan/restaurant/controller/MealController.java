package parlan.restaurant.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import parlan.restaurant.service.MealService;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/meals")
public class MealController {
    
    @Autowired
    private MealService service;
    
    @RequestMapping
    public String mealsPage(Model model) {
        return "meals";
    }
    
    @RequestMapping("/report")
    public void mealsReport(HttpServletResponse response,
            @RequestParam(name = "minPrice", defaultValue = "0") BigDecimal minPrice,
            @RequestParam(name = "maxPrice", defaultValue = "999999") BigDecimal maxPrice) throws Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(service.mealReport(minPrice, maxPrice));
        InputStream inputStream = this.getClass().getResourceAsStream("/reports/meals.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        
        HtmlExporter htmlExporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        htmlExporter.exportReport();
    }
    
}

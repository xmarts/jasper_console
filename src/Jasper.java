//import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


public class Jasper
{
    static Connection conn = null;


    public Jasper() {}

    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }


        try
        {
            conn = DriverManager.getConnection(args[2], args[3], args[4]);
            conn.setAutoCommit(false);
        }
        catch (SQLException e) {
            System.out.println("Error de conexi√≥n: " + e.getMessage());
            System.exit(4);
        }
        try
        {
            Map parameters = new HashMap();
            parameters.put("documentno", args[1]);
            JasperReport report = JasperCompileManager.compileReport(
                    "report/" + args[0] + ".jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

            JasperExportManager.exportReportToPdfFile(print,
                    "report/pdf/" + args[0] + "-" + args[1] + ".pdf");

        }
        catch (Exception e)
        {
            e.printStackTrace();




            try
            {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO 1");
                    conn.close();
                }
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        finally
        {
            try
            {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO 2");
                    conn.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
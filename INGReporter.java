package edu.reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

/**
 * Created by VISISHTA.
 */
public class INGReporter implements IReporter{
	private HTMLReport htmlreport;
	private String FileName="ING-Report.html";
	
	public INGReporter(){
		
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite, String outputDir) {
		// TODO Auto-generated method stub
		
	}

	
	public void printInitHTML(PrintWriter printer){
		htmlreport = new HTMLReport(printer);
		htmlreport.printHTMLhead();
		htmlreport.printSuiteSummaryTable();
		htmlreport.printHTMLtail();
		
	}
	
	public PrintWriter setDefaultPrinter(){
		String outDir = "C:\\Users\\bianjo\\desktop\\test-output";
		new File(outDir).mkdirs();
		try {
			return new PrintWriter(new BufferedWriter(new FileWriter(new File(outDir, FileName))), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
	}

	private class HTMLReport{
		private PrintWriter printer;
		
		public HTMLReport(PrintWriter printer){
			this.printer=printer;
		}
		
		
		
		public void printHTMLhead(){

			printer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			printer.println("<html>");
			printer.println("<head>");
			printer.println("<meta content=\"text/html; charset=ISO-8859-1\" http-equiv=\"content-type\">");
			printer.println("<title>Main Page</title>");
			printer.println("</head>");
			printer.println("<body>");

		}
		
		public void printHTMLtail(){
			printer.println("</body></html>");
			
		}
		
		public void printSuiteSummaryTable(){
			printer.println("<table style=\"background-color: #000000; width: 100%; height: 72px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
			printer.println("<tbody><tr style=\"color: rgb(255, 255, 255); height: 48px; text-align: center;\">");
			printer.println("<td style=\"width: 90%;\"><font face=\"VERDANA\" size=\"5\"><span style=\"font-weight: bold;\">NewJob College</span> - Selenium Automated Testing Solutions</font></td>");
			printer.println("<td><font face=\"Gill Sans Ultra Bold\" size=\"6\"><span style=\"font-weight: bold;\">SAMS</span></td>");
			printer.println("</tr><tr bgcolor=\"#D6E4FF\"><td style=\"text-align: center; height: 24px;\"><font face=\"VERDANA\" size=\"3\">Logs &amp; Reports - Selenium</font></td>");
			printer.println("<td></td></tr></tbody></table><br><table cellpadding=\"3\" width=\"100%\"></table><table style=\"color: rgb(39, 89, 155); background-color: WHITE; width: 100%;\"><tbody>");
			printer.println("<tr height=\"30\"><td><font face=\"VERDANA\" size=\"4\"><b>Test Case Execution Summary:</b></font></td></tr></tbody></table>");
			printer.println("<table style=\"width: 100%; font-family: Verdana; text-align: center; background-color: #EEEEEE;\" cellpadding=\"3\" cellspacing=\"1\"><tbody>");
			printer.println("<tr style=\"background-color: #A8CDFF; font-size:11px; font-weight: bold;\">");
			printer.println("<td style=\"width: 60px;\">Env</td>");
			printer.println("<td style=\"width: 100px;\">Current Build</td>");
			printer.println("<td style=\"width: 90px;\">Machine Name</td>");
			printer.println("<td style=\"width: 122px;\">Time Started</td>");
			printer.println("<td style=\"width: 122px;\">Time Finished</td>");
			printer.println("<td style=\"width: 60px;\">Total Running Time</td>");
			printer.println("<td style=\"width: 230px;\">Script Name</td>");
			printer.println("<td style=\"width: 200px;\">Task Name</td>");
			printer.println("<td style=\"width: 110px;\">First Name</td>");
			printer.println("<td style=\"width: 217px;\">Last Name</td>");
			printer.println("<td style=\"width: 70px;\">Execution Status</td></tr>");
			printer.println("<tr style=\"font-size:10px;\">");
			printer.println("<td>AIT</td>");
			printer.println("<td></td>");
			printer.println("<td>DMS1C01755</td>");
			printer.println("<td>15/04/2016 12:55:28 PM</td>");
			printer.println("<td>15/04/2016 1:08:32 PM</td>");
			printer.println("<td>784s.</td>");
			printer.println("<td>TC_FindPerson_ValidateTabs</td>");
			printer.println("<td>tca_sanity_search</td><td>BRAM</td><td>Sanity-TC-PPYYT</td>");
			printer.println("<td style=\"text-align: center; font-weight: bold; color: blue; font-size: 12px;\">FAIL</td></tr></tbody></table><br>");
		}
		
	}

}

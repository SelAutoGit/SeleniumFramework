package edu.reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
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
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuites, String outputDir) {
		// TODO Auto-generated method stub
		htmlreport = new HTMLReport(outputDir, FileName, iSuites);
		htmlreport.printHTMLhead();
		htmlreport.printSuiteSummaryTable();
		htmlreport.printHTMLtail();
	}

	


	private class HTMLReport{
		private PrintWriter printer;
		private List<ISuite> iSuites;
		private ResultProcessor result;
		
		public HTMLReport(String outputDir, String reportFileName, List<ISuite> iSuites){
			
				new File(outputDir).mkdirs();
				try {
					this.printer=new PrintWriter(new BufferedWriter(new FileWriter(new File(outputDir, reportFileName))), true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.iSuites=iSuites;
				this.result = new ResultProcessor(iSuites);
			
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
			Map<String, String> summary = result.getSuitesSummary();
			printer.println("<table style=\"background-color: #000000; width: 100%; height: 72px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
			printer.println("<tbody><tr style=\"color: rgb(255, 255, 255); height: 48px; text-align: center;\">");
			printer.println("<td style=\"width: 90%;\"><font face=\"VERDANA\" size=\"5\"><span style=\"font-weight: bold;\">NewJob College</span> - Selenium Automated Testing Solutions</font></td>");
			printer.println("<td><font face=\"Gill Sans Ultra Bold\" size=\"6\"><span style=\"font-weight: bold;\">SAMS</span></td>");
			printer.println("</tr><tr bgcolor=\"#D6E4FF\"><td style=\"text-align: center; height: 24px;\"><font face=\"VERDANA\" size=\"3\">Logs &amp; Reports - Selenium</font></td>");
			printer.println("<td></td></tr></tbody></table><br><table cellpadding=\"3\" width=\"100%\"></table><table style=\"color: rgb(39, 89, 155); background-color: WHITE; width: 100%;\"><tbody>");
			printer.println("<tr height=\"30\"><td><font face=\"VERDANA\" size=\"4\"><b>Test Suite Execution Summary:</b></font></td></tr></tbody></table>");
			printer.println("<table style=\"width: 100%; font-family: Verdana; text-align: center; background-color: #EEEEEE;\" cellpadding=\"3\" cellspacing=\"1\"><tbody>");
			printer.println("<tr style=\"background-color: #A8CDFF; font-size:11px; font-weight: bold;\">");
			printer.println("<td style=\"width: 60px;\">Env</td>");
			printer.println("<td style=\"width: 100px;\">Test Cases Passed</td>");
			printer.println("<td style=\"width: 90px;\">Test Case Failed</td>");
			printer.println("<td style=\"width: 155px;\">Time Started</td>");
			printer.println("<td style=\"width: 155px;\">Time Finished</td>");
			printer.println("<td style=\"width: 60px;\">Host</td>");
			printer.println("<td style=\"width: 230px;\">Script Name</td>");
			printer.println("<td style=\"width: 200px;\">Task Name</td>");
			printer.println("<td style=\"width: 110px;\">First Name</td>");
			printer.println("<td style=\"width: 217px;\">Last Name</td>");
			printer.println("<td style=\"width: 70px;\">Execution Status</td></tr>");
			printer.println("<tr style=\"font-size:10px;\">");
			printer.println("<td>AIT</td>");
			printer.println("<td>"+summary.get("PassedNum")+"</td>");
			printer.println("<td>"+summary.get("FailedNum")+"</td>");
			printer.println("<td>"+summary.get("StartTime")+"</td>");
			printer.println("<td>"+summary.get("EndTime")+"</td>");
			printer.println("<td>"+summary.get("Host")+"</td>");
			printer.println("<td>"+summary.get("SuiteName")+"</td>");
			printer.println("<td>tca_sanity_search</td><td>BRAM</td><td>Sanity-TC-PPYYT</td>");
			printer.println("<td style=\"text-align: center; font-weight: bold; color: blue; font-size: 12px;\">"+summary.get("ExecutionStatus")+"</td></tr></tbody></table><br>");			
			printer.println("<table style=\"color: rgb(39, 89, 155); background-color: WHITE; width: 100%;\"><tbody><tr height=\"30\"><td><font face=\"VERDANA\" size=\"4\"><b>Test Case Execution Details:</b></font></td></tr></tbody></table>");
			printer.println("<table style=\"background-color: rgb(255, 255, 255); width: 100%; font-family: Verdana;\" cellpadding=\"3\" cellspacing=\"1\"><tbody>");
			printer.println("<tr style=\"font-size: 11px; background-color: #FFCC66; font-weight: bold; text-align: center;\">");
			printer.println("<td style=\"width: 60px;\">Step #</td>");
			printer.println("<td style=\"width: 299px;\">Step Name</td>");
			printer.println("<td style=\"width: 477px;\">Expected Results</td>");
			printer.println("<td style=\"width: 477px;\">Actual Results</td>");
			printer.println("<td style=\"width: 70px;\">Execution Status</td></tr>");
		}
		
	}
	
	private class ResultProcessor{
		private List<ISuite> iSuites;
		public ResultProcessor(List<ISuite> iSuites){
			this.iSuites=iSuites;
		}
		
		public Map<String, String> getSuitesSummary(){
			
			Map<String, String> summaryMap= new HashMap<>();
			if (iSuites.size()>=1){
				for (ISuite iSuite : iSuites){
					Map<String,ISuiteResult> iSuiteResults = iSuite.getResults();
					for (ISuiteResult iSuiteResult : iSuiteResults.values() ){
						ITestContext context = iSuiteResult.getTestContext();
						summaryMap.put("SuiteName", context.getName());
						summaryMap.put("EndTime", context.getEndDate().toString());
						summaryMap.put("StartTime", context.getStartDate().toString());
						summaryMap.put("Host", context.getHost());
						summaryMap.put("ResultDirectory", context.getOutputDirectory());
						summaryMap.put("PassedNum", String.valueOf(context.getPassedTests().size()));
						summaryMap.put("FailedNum", String.valueOf(context.getFailedTests().size()));
						
						if (context.getFailedTests().size()>0){
							summaryMap.put("ExecutionStatus", "Failed");
						}else{
							summaryMap.put("ExecutionStatus", "Passed");
						}
					}
				}
			} else{
				return null;
			}
			return summaryMap;
			
		}
		
		public void getTestContext(){
			
		}
	}

}

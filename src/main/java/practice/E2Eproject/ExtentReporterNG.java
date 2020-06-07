package practice.E2Eproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
public static ExtentReports getReports()
    {
	String path= System.getProperty("user.dir")+"\\report\\index.html";
	ExtentSparkReporter spark= new ExtentSparkReporter(path);
	spark.config().setReportName("AUtomation Results");
	spark.config().setDocumentTitle("Test Charts");
	
	
	extent= new ExtentReports();
	extent.attachReporter(spark);
	extent.setSystemInfo("Report Created By : ", "Apoorva Deshpande");
	return extent;
	
	
	}
}

package paytm.paytmmoney.ApiUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.Reporter;

import io.restassured.RestAssured;

public class BaseUtils {
	public static Properties config = new Properties();
	
	
	public static void log(String message) {
		Reporter.log(message, true);
	}
	 
	

	static {
		String filename = "";
		try {
			filename = new File(new File(".").getAbsolutePath()).getCanonicalPath()
					+ "/resouces/config.properties";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			final FileInputStream fileInput = new FileInputStream(filename);
			config.load(fileInput);
			fileInput.close();
																																																																																																																																																																																																																																																																																																																																																																																																																																																														
		} catch (IOException e) {
			System.out.println("file not found "+e.getLocalizedMessage());
		}

	}
	
	
	
	  public void configure() {
		 log("*****CONFIGURING*****");
		  RestAssured.baseURI=config.getProperty("baseUrl");
		  RestAssured.basePath="/api";
	  }
	 
	  /**
	   * @author kirankumar
	   * Converts String to date format MM/dd/yyyy
	   * @param dateMMDDYYY
	   * @return
	   */
	public static Date parseStringTodate(String dateMMDDYYY) {
		Date date = new Date();
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		 try {
			date = df.parse("01/07/2019");
		} catch (ParseException e) {
			log(e.getLocalizedMessage());
		}
		 return date;
	}
	
}

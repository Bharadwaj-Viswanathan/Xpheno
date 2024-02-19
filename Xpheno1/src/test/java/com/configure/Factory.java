package com.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



import com.browser.Browser;


public class Factory extends Browser {
		/**
	 * page factory init elements classes
	 */
	

	private static final String exentreportfolder= System.getProperty("user.dir") + "/extent-report/";
	private static String extentreportfilepath = "";

	public static String getExtentReportFilePath()  {
		if (extentreportfilepath.isEmpty()) {
			try {
				extentreportfilepath = createReportPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return extentreportfilepath;
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String createReportPath() throws IOException {
		File file=new File("./src/test/resources/config/data.properties");
		FileInputStream fis= new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		if (props.getProperty("overridereports").equalsIgnoreCase("no")) {
			return exentreportfolder + config.getcurrenttime() + "/index.html";
		} else {
			return exentreportfolder+ "/index.html";
		}
	}


}

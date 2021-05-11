package com.coreWrapper;


import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by gaggarwal on 3/20/19
 */

public class LoggerInfo {
	String dateFormat = "dd/MM/yyyy HH:mm:ss";
	static volatile LoggerInfo logger;
    private static Logger log = Logger.getLogger(LoggerInfo.class.getName());

	private LoggerInfo() {
		log = Logger.getLogger("Log4JLogs");
	}

	public static LoggerInfo getInstance() {
		if(logger == null) {
			synchronized(LoggerInfo.class) {
				if(logger == null) {
					logger = new LoggerInfo();
				}
			}
		}
		return logger;
	}

	//We can use it when starting tests
    public static void startLog (String testClassName){
    	log.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (String testClassName){
    	log.info("Test is Ending...");
    }


	public void Info(String TESTID, String sMessage){
		log.info(TESTID +"->"+ sMessage);
		System.out.println(this.getDateAndTime() + "##INFO## " + sMessage);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.info(sMessage);
	}
	public void Info(String sMessage){
		log.info(sMessage);
		System.out.println(this.getDateAndTime() + "##INFO## " + sMessage);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.info(sMessage);
	}

	public void Debug(String TESTID, String sMessage){
		log.debug(TESTID +"->"+ sMessage);
		System.out.println(this.getDateAndTime() + "##DEBUG## " + sMessage);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.debug(sMessage);
	}

	public void Debug(String sMessage){
		log.debug(sMessage);
		System.out.println(this.getDateAndTime() + "##DEBUG## " + sMessage);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.debug(sMessage);
	}

	public void Skip(String TESTID, String message){
		log.debug(TESTID +"->"+ message);
		System.out.println(this.getDateAndTime() + "##SKIP## " + message);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.skip(message);
	}
	public void Error(String message){
		log.error(message);
		System.out.println(this.getDateAndTime() + "##ERROR## " + message);
		//ExtentTest extentLogger  = ExtentReportUtils.getTest();
		//if(extentLogger != null) extentLogger.error(message);
	}

	private String getDateAndTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String dateAndTime = sdf.format(date);
		return "["+ dateAndTime + "]";
    }
}

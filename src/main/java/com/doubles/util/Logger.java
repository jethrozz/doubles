package com.doubles.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;

public class Logger {

	private org.slf4j.Logger logger = null;

	public static Logger getLogger(Class<?> classname) {
		return new Logger(classname);
	}

	private Logger(Class<?> classname) {

		logger = LoggerFactory.getLogger(classname);
	}

	// PID{7156}-09:23:20.120 logback [http-nio-11080-exec-9] TRACE
	// r.m.server.web.RecognizeController [RecognizeController.java : 67
	public void info(String value) {
		logger.info(format(value, "INFO"));
	}

	public void trace(String value) {
		logger.info(format(value, "TRACE"));
	}

	public void debug(String value) {
		logger.info(format(value, "DEBUG"));
	}

	public void error(String value) {
		logger.error(format(value, "ERROR"));
	}

	public void warn(String value) {
		logger.warn(format(value, "WARN"));
	}

	private String format(String value, String level) {
		return value;
		// String result = String.format("%s log4j [%s] %s %s [%s:%d] - %s",
		// getCurrentTime(), Thread.currentThread().getName(),
		// level, getCallClassName(), getCallFileName(),
		// getCallFileLineNumber(),value);
		// return result;
	}

	public String getCurrentTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}

	public String getCallClassName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		int index = 0;
		for (int i = 1; i < stackTrace.length; ++i) {

			if (stackTrace[i].getClassName().compareToIgnoreCase(Logger.class.getName()) != 0) {
				index = i;
				break;
			}
		}
		return Thread.currentThread().getStackTrace()[index].getClassName();
	}

	public String getCallFileName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		int index = 0;
		for (int i = 1; i < stackTrace.length; ++i) {

			if (stackTrace[i].getClassName().compareToIgnoreCase(Logger.class.getName()) != 0) {
				index = i;
				break;
			}
		}
		return Thread.currentThread().getStackTrace()[index].getFileName();
	}

	public int getCallFileLineNumber() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		int index = 0;
		for (int i = 1; i < stackTrace.length; ++i) {

			if (stackTrace[i].getClassName().compareToIgnoreCase(Logger.class.getName()) != 0) {
				index = i;
				break;
			}
		}
		return Thread.currentThread().getStackTrace()[index].getLineNumber();
	}

}

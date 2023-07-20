package com.apcfss.reports;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

import com.apcfss.enums.LogType;

public class FrameworkLogger {
	
	private FrameworkLogger() {}
	
	private static Consumer<String> PASS=(message)->ExtentManager.getExtentTest().pass(message);
	private static Consumer<String> FAIL=(message)->ExtentManager.getExtentTest().fail(message);
	private static Consumer<String> SKIP=(message)->ExtentManager.getExtentTest().skip(message);
	private static Consumer<String> INFO=(message)->ExtentManager.getExtentTest().info(message);
	private static Consumer<String> CONSOLE=(message)->System.out.println("INFO--->"+message);
	private static Consumer<String> EXTENTANDCONSOLE=PASS.andThen(CONSOLE);
	
	
	private static Map<LogType, Consumer<String>>MAP=new EnumMap(LogType.class);
	
	static {
		MAP.put(LogType.PASS, PASS);
		MAP.put(LogType.FAIL, FAIL);
		MAP.put(LogType.SKIP, SKIP);
		MAP.put(LogType.INFO, INFO);
		MAP.put(LogType.CONSOLE, CONSOLE);
		MAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
	}
	
	public static void log(LogType status,String message) {
		MAP.get(status).accept(message);
	}
	
}

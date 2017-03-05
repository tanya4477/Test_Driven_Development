package com.ubs.opsit.interviews;

public interface TimeConverter {

	public static final String SPLITTER = ":";
	public static final String LINE_BREAK = "\n";
	public static final int GENERAL_LAMP_COUNT = 4;
	public static final int LONG_ROW_LAMP_COUNT = 11;
	
    String convertTime(String aTime);

}

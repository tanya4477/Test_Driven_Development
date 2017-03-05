package com.ubs.opsit.interviews;

import java.util.stream.Stream;

/**
 * Implementation of {@link TimeConverter}
 * 
 * @author Tanya
 *
 */
public class TimeConverterImpl implements TimeConverter {

	/**
	 * STATE enum for the clock
	 */
	public enum STATE {
		YELLOW("Y"), RED("R"), OFF("O");

		private String state;

		STATE(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	};

	@Override
	public String convertTime(String aTime) {
		//Split the time[HH:MM:SS] into three parts (HH, MM, SS)
		int[] timeParts = Stream.of(aTime.split(SPLITTER)).mapToInt(Integer::parseInt).toArray();

		StringBuilder clockBuilder = new StringBuilder();
		clockBuilder.append(getYellowTopLampState(timeParts[2]));
		clockBuilder.append(LINE_BREAK);
		clockBuilder.append(get5hoursRowLampState(timeParts[0]));
		clockBuilder.append(LINE_BREAK);
		clockBuilder.append(get1hourRowLampState(timeParts[0]));
		clockBuilder.append(LINE_BREAK);
		clockBuilder.append(get5MinutesRowLampState(timeParts[1]));
		clockBuilder.append(LINE_BREAK);
		clockBuilder.append(get1MinuteRowLampState(timeParts[1]));

		return clockBuilder.toString();
	}

	/**
	 * This method returns the state of the yellow top lamp
	 * 
	 * @param seconds
	 *            time in seconds
	 * @return state of top lamp
	 */
	public String getYellowTopLampState(int seconds) {
		if (seconds % 2 == 0) {
			return STATE.YELLOW.getState();
		} else {
			return STATE.OFF.getState();
		}
	}

	/**
	 * This gives the lamp state in the second row with 4 lamps each
	 * representing 5 hours
	 * 
	 * @param hours
	 *            time in hours
	 * @return state of 5 hour row of lamps
	 */
	public String get5hoursRowLampState(int hours) {
		int count5Hour = hours / 5;
		return getOnOffLampForGeneralRow(count5Hour, STATE.RED);
	}

	/**
	 * This gives the lamp state in the third row with 4 lamps each representing
	 * 1 hour
	 * 
	 * @param hours
	 *            time in hours
	 * @return state of 1 hour row of lamps
	 */
	public String get1hourRowLampState(int hours) {
		int count1Hour = hours % 5;
		return getOnOffLampForGeneralRow(count1Hour, STATE.RED);
	}

	/**
	 * This gives the lamp state in the fourth row with 11 lamps, each
	 * representing 5 minutes
	 * 
	 * @param minutes
	 * @return state of 5 minutes row of lamps
	 */
	public String get5MinutesRowLampState(int minutes) {
		int count5Min = minutes / 5;
		return getOnOffLampForLongRow(count5Min);
	}

	/**
	 * This gives the lamp state in the fifth row with 4 lamps, each
	 * representing 1 minute
	 * 
	 * @param minutes
	 * @return state of 1 minute row of lamps
	 */
	public String get1MinuteRowLampState(int minutes) {
		int count1Min = minutes % 5;
		return getOnOffLampForGeneralRow(count1Min, STATE.YELLOW);
	}

	/**
	 * This is an utility method to return on and off lamp states in String form
	 * for shorter row with 4 lamps
	 * 
	 * @param onLampCount
	 * @param state
	 * @return lamp state in String format
	 */
	public String getOnOffLampForGeneralRow(int onLampCount, STATE state) {
		StringBuilder lampState = new StringBuilder();

		for (int count = 0; count < onLampCount; count++) {
			lampState.append(state.getState());
		}

		for (int i = 0; i < GENERAL_LAMP_COUNT - onLampCount; i++) {
			lampState.append(STATE.OFF.getState());
		}
		return lampState.toString();
	}

	/**
	 * This is an utility method to return on and off lamp states in String form
	 * for Long row with 11 lamps
	 * 
	 * @param totalLampCount
	 * @param onLampCount
	 * @return lamp state in String format
	 */
	public String getOnOffLampForLongRow(int onLampCount) {
		StringBuilder lampState = new StringBuilder();
		for (int count = 0; count < onLampCount; count++) {
			if ((count + 1) % 3 == 0) {// Every third 'on' light is Red
				lampState.append(STATE.RED.getState());
			} else {
				lampState.append(STATE.YELLOW.getState());
			}
		}
		for (int i = 0; i < LONG_ROW_LAMP_COUNT - onLampCount; i++) {
			lampState.append(STATE.OFF.getState());
		}
		return lampState.toString();
	}
}

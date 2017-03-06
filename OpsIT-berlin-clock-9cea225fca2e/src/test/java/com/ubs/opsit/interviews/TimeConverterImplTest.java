package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverterImpl.STATE;

/**
 * Test class for {@link TimeConverterImpl}
 * 
 * @author Tanya
 *
 */
public class TimeConverterImplTest {

	private TimeConverterImpl timerConverter;
	
	@Before
	public void setUp() {
		timerConverter = new TimeConverterImpl();
	}
	
	@After
    public void tearDown() {
	    timerConverter = null;
    }

	/**
	 * For top yellow lamp
	 */
	//testing for top yellow lamp on even second
	@Test
	public void testYellowTopLampForEvenSecond() {
		assertEquals(STATE.YELLOW.getState(), timerConverter.getYellowTopLampState(0));
		assertEquals(STATE.YELLOW.getState(), timerConverter.getYellowTopLampState(6));
		assertEquals(STATE.YELLOW.getState(), timerConverter.getYellowTopLampState(14));
		assertEquals(STATE.YELLOW.getState(), timerConverter.getYellowTopLampState(30));
		assertEquals(STATE.YELLOW.getState(), timerConverter.getYellowTopLampState(58));
	}
	
	//testing for top yellow lamp on odd second
	@Test
	public void testYellowTopLampForOddSecond() {
		assertEquals(STATE.OFF.getState(), timerConverter.getYellowTopLampState(1));
		assertEquals(STATE.OFF.getState(), timerConverter.getYellowTopLampState(9));
		assertEquals(STATE.OFF.getState(), timerConverter.getYellowTopLampState(17));
		assertEquals(STATE.OFF.getState(), timerConverter.getYellowTopLampState(35));
		assertEquals(STATE.OFF.getState(), timerConverter.getYellowTopLampState(59));
	}

	/**
	 * For Red 5 hours lamp
	 */
	// testing 4 red lamps of 5 hours Row when no red lights ON
	@Test
	public void testFor5HoursRowNoRedLightOn() {
		final String expectedOutputState = "OOOO";
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(0));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(1));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(2));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(3));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(4));
	}

	// testing 4 red lamps of 5 hours Row when One red lights ON
	@Test
	public void testFor5HoursRowOneRedLightOn() {
		final String expectedOutputState = "ROOO";
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(5));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(6));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(7));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(8));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(9));
	}

	// testing 4 red lamps of 5 hours Row when two red lights ON
	@Test
	public void testFor5HoursRowTwoRedLightOn() {
		final String expectedOutputState = "RROO";
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(10));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(11));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(12));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(13));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(14));
	}

	// testing 4 red lamps of 5 hours Row when three red lights ON
	@Test
	public void testFor5HoursRowThreeRedLightOn() {
		final String expectedOutputState = "RRRO";
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(15));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(16));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(17));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(18));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(19));
	}

	// testing 4 red lamps of 5 hours Row when four red lights ON
	@Test
	public void testFor5HoursRowFourRedLightOn() {
		final String expectedOutputState = "RRRR";
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(20));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(21));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(22));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(23));
		assertEquals(expectedOutputState, timerConverter.get5hoursRowLampState(24));
	}

	/**
	 * For Red 1 hour lamps
	 */
	// testing 4 red lamps of 1 hour Row when no red lights ON
	@Test
	public void testFor1HourRowNoRedLightOn() {
		final String expectedOutputState = "OOOO";
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(0));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(5));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(10));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(15));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(20));

	}

	// testing 4 red lamps of 1 hour Row when One red lights ON
	@Test
	public void testFor1HourRowOneRedLightOn() {
		final String expectedOutputState = "ROOO";
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(1));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(6));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(11));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(16));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(21));
	}

	// testing 4 red lamps of 1 hour Row when two red lights ON
	@Test
	public void testFor1HourRowTwoRedLightOn() {
		final String expectedOutputState = "RROO";
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(2));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(7));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(12));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(17));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(22));
	}

	// testing 4 red lamps of 1 hour Row when three red lights ON
	@Test
	public void testFor1HourRowThreeRedLightOn() {
		final String expectedOutputState = "RRRO";
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(3));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(8));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(13));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(18));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(23));
	}

	// testing 4 red lamps of 1 hour Row when four red lights ON
	@Test
	public void testFor1HourRowFourRedLightOn() {
		final String expectedOutputState = "RRRR";
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(4));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(9));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(14));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(19));
		assertEquals(expectedOutputState, timerConverter.get1hourRowLampState(24));
	}

	/**
	 * For 5 minutes 11 lamps
	 */
	// testing 11 lamps of 5 minutes Row when no lights ON
	@Test
	public void testFor5MinsRowNoLightOn() {
		final String expectedOutputState = "OOOOOOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(0));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(1));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(2));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(3));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(4));
	}

	// testing 11 lamps of 5 minutes Row when one lights ON
	@Test
	public void testFor5MinsRowOneLightOn() {
		final String expectedOutputState = "YOOOOOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(5));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(6));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(7));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(8));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(9));
	}

	// testing 11 lamps of 5 minutes Row when two lights ON
	@Test
	public void testFor5MinsRowTwoLightOn() {
		final String expectedOutputState = "YYOOOOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(10));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(11));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(12));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(13));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(14));
	}

	// testing 11 lamps of 5 minutes Row when three lights ON
	@Test
	public void testFor5MinsRowThreeLightOn() {
		final String expectedOutputState = "YYROOOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(15));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(16));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(17));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(18));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(19));
	}

	// testing 11 lamps of 5 minutes Row when four lights ON
	@Test
	public void testFor5MinsRowFourLightOn() {
		final String expectedOutputState = "YYRYOOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(20));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(21));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(22));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(23));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(24));
	}

	// testing 11 lamps of 5 minutes Row when five lights ON
	@Test
	public void testFor5MinsRowFiveLightOn() {
		final String expectedOutputState = "YYRYYOOOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(25));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(26));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(27));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(28));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(29));
	}

	// testing 11 lamps of 5 minutes Row when six lights ON
	@Test
	public void testFor5MinsRowSixLightOn() {
		final String expectedOutputState = "YYRYYROOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(30));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(31));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(32));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(33));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(34));
	}

	// testing 11 lamps of 5 minutes Row when seven lights ON
	@Test
	public void testFor5MinsRowSevenLightOn() {
		final String expectedOutputState = "YYRYYRYOOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(35));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(36));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(37));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(38));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(39));
	}

	// testing 11 lamps of 5 minutes Row when eight lights ON
	@Test
	public void testFor5MinsRowEightLightOn() {
		final String expectedOutputState = "YYRYYRYYOOO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(40));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(41));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(42));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(43));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(44));
	}

	// testing 11 lamps of 5 minutes Row when nine lights ON
	@Test
	public void testFor5MinsRowNineLightOn() {
		final String expectedOutputState = "YYRYYRYYROO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(45));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(46));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(47));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(48));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(49));
	}

	// testing 11 lamps of 5 minutes Row when ten lights ON
	@Test
	public void testFor5MinsRowTenLightOn() {
		final String expectedOutputState = "YYRYYRYYRYO";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(50));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(51));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(52));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(53));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(54));
	}

	// testing 11 lamps of 5 minutes Row when eleven lights ON
	@Test
	public void testFor5MinsRowElevenLightOn() {
		final String expectedOutputState = "YYRYYRYYRYY";
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(55));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(56));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(57));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(58));
		assertEquals(expectedOutputState, timerConverter.get5MinutesRowLampState(59));
	}

	/**
	 * For Yellow 1 minute lamps
	 */
	// testing 4 lamps of 1 minute Row when no yellow lights ON
	@Test
	public void testFor1MinRowNoYellowLightOn() {
		final String expectedOutputState = "OOOO";
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(0));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(20));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(30));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(45));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(55));
	}

	// testing 4 lamps of 1 minute Row when one yellow lights ON
	@Test
	public void testFor1MinRowOneYellowLightOn() {
		final String expectedOutputState = "YOOO";
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(1));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(16));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(21));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(46));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(56));
	}

	// testing 4 lamps of 1 minute Row when two yellow lights ON
	@Test
	public void testFor1MinRowTwoYellowLightOn() {
		final String expectedOutputState = "YYOO";
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(2));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(12));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(27));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(32));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(57));
	}

	// testing 4 lamps of 1 minute Row when three yellow lights ON
	@Test
	public void testFor1MinRowThreeYellowLightOn() {
		final String expectedOutputState = "YYYO";
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(3));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(8));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(18));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(33));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(58));
	}

	// testing 4 lamps of 1 minute Row when four yellow lights ON
	@Test
	public void testFor1MinRowFourYellowLightOn() {
		final String expectedOutputState = "YYYY";
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(4));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(29));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(34));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(44));
		assertEquals(expectedOutputState, timerConverter.get1MinuteRowLampState(59));
	}
	
	//testing general row for yellow state of lamp
	@Test
	public void testGetOnOffLampForGeneralRow_Yellow(){
		assertEquals("OOOO", timerConverter.getOnOffLampForGeneralRow(0, STATE.YELLOW));
		assertEquals("YOOO", timerConverter.getOnOffLampForGeneralRow(1, STATE.YELLOW));
		assertEquals("YYOO", timerConverter.getOnOffLampForGeneralRow(2, STATE.YELLOW));
		assertEquals("YYYO", timerConverter.getOnOffLampForGeneralRow(3, STATE.YELLOW));
		assertEquals("YYYY", timerConverter.getOnOffLampForGeneralRow(4, STATE.YELLOW));
	}
	
	//testing general row for red state of lamp
	@Test
	public void testGetOnOffLampForGeneralRow_Red(){
		assertEquals("OOOO", timerConverter.getOnOffLampForGeneralRow(0, STATE.RED));
		assertEquals("ROOO", timerConverter.getOnOffLampForGeneralRow(1, STATE.RED));
		assertEquals("RROO", timerConverter.getOnOffLampForGeneralRow(2, STATE.RED));
		assertEquals("RRRO", timerConverter.getOnOffLampForGeneralRow(3, STATE.RED));
		assertEquals("RRRR", timerConverter.getOnOffLampForGeneralRow(4, STATE.RED));
	}
	
	//testing long row for 11 lamps
	@Test
	public void testGetOnOffLampForLongRow(){
		assertEquals("OOOOOOOOOOO", timerConverter.getOnOffLampForLongRow(0));
		assertEquals("YYRYOOOOOOO", timerConverter.getOnOffLampForLongRow(4));
		assertEquals("YYRYYROOOOO", timerConverter.getOnOffLampForLongRow(6));
		assertEquals("YYRYYRYYOOO", timerConverter.getOnOffLampForLongRow(8));
		assertEquals("YYRYYRYYRYY", timerConverter.getOnOffLampForLongRow(11));
	}
	
	// Testing the Berlin Clock output for Midnight
	@Test
	public void testConvertTime_for_Midnight(){
		String expectedBerlinClockOutput = 	"Y"+TimeConverter.LINE_BREAK+
											"OOOO"+TimeConverter.LINE_BREAK+
											"OOOO"+TimeConverter.LINE_BREAK+
											"OOOOOOOOOOO"+TimeConverter.LINE_BREAK+
											"OOOO";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("00:00:00"));

	}

	// Testing the Berlin Clock output for Mid Morning
	@Test
	public void testConvertTime_for_MidMorning(){
		String expectedBerlinClockOutput = 	"O"+TimeConverter.LINE_BREAK+
											"ROOO"+TimeConverter.LINE_BREAK+
											"RRRO"+TimeConverter.LINE_BREAK+
											"YYOOOOOOOOO"+TimeConverter.LINE_BREAK+
											"YYYO";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("08:13:09"));
	}

	// Testing the Berlin Clock output for Mid Afternoon
	@Test
	public void testConvertTime_for_MidAfternoon(){
		String expectedBerlinClockOutput = 	"O"+TimeConverter.LINE_BREAK+
											"RROO"+TimeConverter.LINE_BREAK+
											"RRRO"+TimeConverter.LINE_BREAK+
											"YYROOOOOOOO"+TimeConverter.LINE_BREAK+
											"YYOO";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("13:17:01"));
	}
	
	// Testing the Berlin Clock output for Mid Evening
	@Test
	public void testConvertTime_for_MidEvening(){
		String expectedBerlinClockOutput = 	"O"+TimeConverter.LINE_BREAK+
											"RRRO"+TimeConverter.LINE_BREAK+
											"RRRR"+TimeConverter.LINE_BREAK+
											"YYRYYRYOOOO"+TimeConverter.LINE_BREAK+
											"YYOO";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("19:37:43"));
	}	
	
	// Testing the Berlin Clock output for a time Just Before Midnight	
	@Test
	public void testConvertTime_for_JustBeforeMidnight(){
		String expectedBerlinClockOutput = 	"O"+TimeConverter.LINE_BREAK+
											"RRRR"+TimeConverter.LINE_BREAK+
											"RRRO"+TimeConverter.LINE_BREAK+
											"YYRYYRYYRYY"+TimeConverter.LINE_BREAK+
											"YYYY";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("23:59:59"));
	}
	
	// Testing the Berlin Clock output for 24 hour Midnight time
	@Test
	public void testConvertTime_for_24HourMidnight(){
		String expectedBerlinClockOutput = 	"Y"+TimeConverter.LINE_BREAK+
											"RRRR"+TimeConverter.LINE_BREAK+
											"RRRR"+TimeConverter.LINE_BREAK+
											"OOOOOOOOOOO"+TimeConverter.LINE_BREAK+
											"OOOO";
		assertEquals(expectedBerlinClockOutput, timerConverter.convertTime("24:00:00"));
	}
}

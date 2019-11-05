package com.num.word.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class NumberToWordConverterTest {

	NumberToWordConverter instance;
	@After
    public void tearDown() throws Exception {
        instance = null;
    }
	  @Rule
	    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	  @Rule
	    public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();
	  @Rule
	    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream() ;

	    @Test
	    public void testMainSuccessScenarioTwoDigitNumber() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("23\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nTwenty Three\r\n"));
	    }
	    
	    @Test
	    public void testMainErrorScenario() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("null\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nEnterend Wrong input. Please Enter only numbers or Enter lesser Number\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioZero() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("000\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nZero\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioSingleDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("1\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nOne\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioThreeDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("1001\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nOne Thousand One\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioFourDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("10015\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nTen Thousand Fifteen\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioFiveDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("12315\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nTwelve Thousand Three Hundred Fifteen\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioSixDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("999999\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nNine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioSevenDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("1999999\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nOne Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioEightDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("17999999\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nSeventeen Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioNineDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("170999999\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nOne Hundred Seventy Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine\r\n"));
	    }
	    
	    @Test
	    public void testMainSuccessScenarioTenDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("1700999999\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nOne Billion Seven Hundred Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine\r\n"));
	    }
	    
	    @Test
	    public void testMainErrorScenarioMoreThanTenDigit() {
	        instance = new NumberToWordConverter();
	        String [] args = null;
	        systemInMock.provideText("17009999990\n");
	        NumberToWordConverter.main(args);
	        assertThat(stdOutLog.getLog(), is("Enter Number to convert to Word:(Supports upto 10 Digits)\r\nEnterend Wrong input. Please Enter only numbers or Enter lesser Number\r\n"));
	    }
	
}

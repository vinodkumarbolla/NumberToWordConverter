package com.num.word.converter;

import java.util.Optional;
import java.util.Scanner;

import com.num.word.converter.utils.Constants;

public class NumberToWordConverter {
	
		    
		    /**
		     * Converting to string for the number less than 1000
		     * Derives the words for each and every digit and concatenating them.
		     * @param number
		     * @return
		     */
		    private String convertLessThanOneThousand(int number) {
		        String current;
		        // All Less than 20 values are comes from BELOW_TWENTY_NAMES 
		        if (number % 100 < 20){
		            current = Constants.BELOW_TWENTY_NAMES[number % 100];
		            number /= 100;
		        }
		        else {
		            current = Constants.BELOW_TWENTY_NAMES[number % 10];
		            number /= 10;
		            
		            current = Constants.TENS_NAMES[number % 10] + current;
		            number /= 10;
		        }
		        if (number == 0) return current;
		        return Constants.BELOW_TWENTY_NAMES[number] + Constants.HUNDRED + current;
		    }
		    
		    /**
		     * This method converts the number to Word string and returns
		     * @param number - Number that needs to be converted
		     * @return converted String
		     */
		    public String convert(int number) {
		    	String prefix = "";
		    	String current = "";
		        int position = 0;
		        if (number == 0) { return Constants.ZERO; }
		        else if (number < 0) {        
		            number = -number;
		            prefix = Constants.NEGATIVE;
		        }
		        
		        do {
		            int n = number % 1000;
		            if (n != 0){
		                String s = convertLessThanOneThousand(n);
		                current = s + Constants.LARGE_VAL_NAMES[position] + current;
		            }
		            position++;
		            number /= 1000;
		        } while (number > 0);
		        
		        return (prefix + current).trim();
		    }
		    
		    public static void main(String[] args) {
		    	System.out.println(Constants.ENTRY_MESSAGE);
		    	Scanner s = new Scanner(System.in);
		    	String val = s.next();
				try {
					String result = Optional.of(val).isPresent() ? new NumberToWordConverter().convert(Integer.parseInt(val))
							:Constants.WRONG_MESSAGE;
					System.out.println(result);
				} catch (NumberFormatException ex) {
					System.out.println(Constants.WRONG_MESSAGE);
				} catch(Exception e) {
					System.out.println(Constants.EXCEPTION_MESSAGE);
				}
		    }
}

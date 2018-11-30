package com.simon;

import java.util.Random;
import java.util.function.Function;

import com.grid_tools.products.datamasker.IMaskFunction;

public class SimonCCMaskingFunction implements IMaskFunction {

	public static int counter = 0;
	
	@Override
	public Object mask(Object... args) {
		String originalCCNumber = (String) args[0];		
		String argTest = (String) args[1];
		return argTest.concat(generateCCNumberOfLength(originalCCNumber.length())).concat(argTest);
	}

	private String generateCCNumberOfLength(int ccNumberLength) {
		String ccString = "";
		Random randInt = new Random();
		for(int i=1 ; i<ccNumberLength+1; i++) {
			ccString += (i%5==0) ? "-" : String.valueOf(randInt.nextInt(9));
		}
		counter++;
		return ccString+counter;

	}

}

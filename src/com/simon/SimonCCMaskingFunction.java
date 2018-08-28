package com.simon;

import java.util.Random;
import java.util.function.Function;

import com.grid_tools.products.datamasker.IMaskFunction;

public class SimonCCMaskingFunction implements IMaskFunction {

	@Override
	public Object mask(Object... arg0) {
		String originalCCNumber = (String) arg0[0];
		
//		works - doesn't throw error with no param1 entered
		String argTest = (String) arg0[1];
//		only works when param1 is entered
//		int argtestTwo =  Integer.parseInt(arg0[1].toString());
//		doesn't work even with param1 entered
//		int argtestTwo = (int) arg0[1];


		return argTest.concat(generateCCNumberOfLength(originalCCNumber.length())).concat(argTest);
	}

	private String generateCCNumberOfLength(int ccNumberLength) {

		String ccString = "";
		Random randInt = new Random();
		for(int i=1 ; i<ccNumberLength+1; i++) {
			if(i%5==0) {
				ccString += "-";
			}else {
				String concatValue = String.valueOf(randInt.nextInt(9));
				ccString += concatValue;
			}
		}
		return ccString;

	}

}

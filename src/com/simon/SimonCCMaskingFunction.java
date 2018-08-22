package com.simon;

import java.util.Random;

import com.grid_tools.products.datamasker.IMaskFunction;

public class SimonCCMaskingFunction implements IMaskFunction {

	@Override
	public Object mask(Object... arg0) {
		String originalCCNumber = (String) arg0[0];
		return generateCCNumber(originalCCNumber.length());
	}

	private String generateCCNumber(int ccNumberLength) {

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

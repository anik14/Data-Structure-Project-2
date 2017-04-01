/*
File: Term.java
Author: Mohammad Islam
Date: 10/04/16
HW: 2
Description: Term class.
Worked with ZJ Zhang, Abdullah Alkhudhayr
*/

public class Term {
	private int coefficients;
	private int exponent;
	
	public Term(){
		coefficients = 0;
		exponent = 0;
	}
	
	public Term(int coef, int expo){
		this.coefficients = coef;
		this.exponent = expo;
	}

	public int getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(int coefficients) {
		this.coefficients = coefficients;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	
	
	
	
}

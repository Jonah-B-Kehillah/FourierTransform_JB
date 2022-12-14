package com.numbers;

public class Polynomial {
	
	public Complex[] terms;
	
	/**
	 * @param terms An array of the complex numbers. Given an array [a, b, c, d...], assuming
	 *              all items are complex numbers, produces a polynomial ax^0 + bx^1 + cx^2 + dx^3 + ...
	 */
	public Polynomial(Complex[] terms) {
		this.terms = terms;
		for(Complex term : this.terms){
			if(term == null) term = new Complex(0,0);
		}
	}
	
	/**
	 * Evaluates the polynomial at value x
	 * @param x The x value to evaluate at
	 * @return The result of evaluating the polynomial at x
	 */
	public Complex evaluate(Complex x) {
		Complex retVal = new Complex(0,0);
		retVal.add(terms[0]);
		for(int k = 1; k < terms.length; k++) {
			retVal.add(Complex.mult(terms[k],
					Complex.pow(
							x,
							new Complex(k, 0)
					)));
		}
		return retVal;
	}
	
	/**
	 * @see Polynomial#evaluate(Complex) 
	 */
	public Complex evaluate(Number x) {
		return this.evaluate(new Complex(x));
	}
	
	/**
	 * @see Polynomial#evaluate(Complex)
	 */
	@SuppressWarnings("unused")
	public Complex evaluate(Number r, Number i) {
		return this.evaluate(new Complex(r,i));
	}
	
}

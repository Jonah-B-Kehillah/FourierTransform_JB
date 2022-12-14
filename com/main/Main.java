package com.main;
import com.numbers.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
	
	static int passes = 0, fails = 0, testNum = 0;
	
	public static void main(String[] args) {
		
		System.out.println("All values checked against for Complex are generated from `complex_nums.py`");
		
		Complex a = new Complex(2, 7);
		Complex b = new Complex(3,-4);
		Complex c = new Complex(9, 3);
		Complex d = new Complex(0,-6);
		Complex e = new Complex(-2,0);
		
		System.out.println("Addition tests");
		testC(Complex.add(a,b), new Complex(5,3));
		testC(Complex.add(c,e), new Complex(7,3));
		testC(Complex.add(d,a), new Complex(2,1));
		testC(Complex.add(d,e), new Complex(-2,-6));
		
		System.out.println("Subtraction tests");
		testC(Complex.sub(a,b), new Complex(-1,11));
		testC(Complex.sub(c,e), new Complex(11,3));
		testC(Complex.sub(d,a), new Complex(-2,-13));
		testC(Complex.sub(d,e), new Complex(2,-6));
		
		System.out.println("Multiplication tests");
		testC(Complex.mult(a,b), new Complex(34,13));
		testC(Complex.mult(c,e), new Complex(-18,-6));
		testC(Complex.mult(d,a), new Complex(42,-12));
		testC(Complex.mult(d,e), new Complex(0,12));
		
		System.out.println("Division tests");
		testC(Complex.div(a,b), new Complex(-0.88,1.16));
		testC(Complex.div(c,e), new Complex(-4.5,-1.5));
		testC(roundToThree(Complex.div(d,a)), new Complex(-0.792,-0.226));
		testC(Complex.div(d,e), new Complex(0,3));
		
		System.out.println("Power tests");
		testC(Complex.pow(a,b), new Complex(-41038.992,54063.208));
		testC(Complex.pow(c,e), new Complex(0.009,-0.007));
		testC(Complex.pow(d,a), new Complex(-2145329.889,51614.428));
		testC(Complex.pow(d,e), new Complex(-0.028,0));
		
		System.out.println("Polynomial tests");
		Polynomial pn1 = new Polynomial(new Complex[]{a,e,d});
		testC(pn1.evaluate(2), new Complex(-2, -17)); // https://www.wolframalpha.com/input?i=evaluate+%282%2B7i%29%2B%28-2%29x%2B%28-6i%29x%5E2+when+x%3D2
		testC(pn1.evaluate(c), new Complex(308, -431));  // https://www.wolframalpha.com/input?i=evaluate+%282%2B7i%29%2B%28-2%29x%2B%28-6i%29x%5E2+when+x%3D%289%2B3i%29
		
		System.out.printf("%s tests passed and %s tests failed. Total tests: %s", passes, fails, testNum);
		
	}
	
	public static void testC(Complex in, Complex expected){
		testNum++;
		if(in.equals(expected)) {
			passes++;
			System.out.printf("Test #%s passed%n", testNum);
		} else {
			passes++;
			System.err.printf("Test #%s failed%n", testNum);
		}
	}
	public static Complex roundToThree(Complex in) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double r = Double.parseDouble(df.format(in.real));
		double i = Double.parseDouble(df.format(in.imag));
		return new Complex(r,i);
	}
}

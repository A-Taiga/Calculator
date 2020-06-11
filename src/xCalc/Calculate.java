package xCalc;

public class Calculate {
	
	private double solution = 0;
	
	public Calculate() {
		
	}
	
	public void divide(double x, double y) {
		solution = x/y;
	}
	
	public void multiply(double x, double y) {
		solution = x*y;
	}
	
	public void subtract(double x, double y) {
		solution = x - y;
	}
	
	public void add(double x, double y) {
		solution = x + y;
	}

	public double getSolution() {
		
		return solution;
	}
	
}

package util;

public class Point {

	private double x;
	
	private double y;
	
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sum this point values with a other one and updates x and y attribute with the result
	 * @param p point to sum
	 */
	public void plus(Point p) {
		this.x += p.x;
		this.y += p.y;
	}
	
	public void minus(Point p) {
		this.x -= p.x;
		this.y -= p.y;
	}
	
	public void divide(double d) {
		this.x /= d;
		this.y /= d;
	}
	
	public void multiply(double m) {
		this.x *= m;
		this.y *= m;
	}
	
	public void absoluteValue() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
	}
	
	public String toString() {
		return String.format("%.2fx%.2f", this.x, this.y);
	}
	
	public Point clone() {
		return new Point(this.x, this.y);
	}
}

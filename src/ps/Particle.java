package ps;

import java.awt.Color;
import util.Point;

public class Particle {
	
	private static final int EXPLOSION_POWER = 30;
	
	/**
	 * Each iteration acceleration
	 */
	private Point acceleration;

	/**
	 * Particle's position
	 */
	private Point position;

	/**
	 * Particle's velocity
	 */
	private Point velocity;
	
	/**
	 * Particle's direction 
	 */
	private double direction;

	/**
	 * Particle explosion time
	 */
	private int explosionTime;
	
	/**
	 * Particle radius
	 */
	private double size;
	
	/**
	 * Particle's age
	 */
	private int age;	
	
	/**
	 * Particle color
	 */
	private Color color;
	
	/**
	 * Instantiates a particle within a Fireworks Particle System
	 * @param explosionTime time before particle explode
	 * @param firstColor particle initial color
	 * @param firstSize particle initial size
	 * @param velocity particle initial velocity
	 * @param position particle initial position
	 * @param direction particle initial direction
	 * @param acceleration simulation acceleration
	 */
	public Particle(int explosionTime, Color firstColor, double firstSize, Point velocity, Point position, Point acceleration, double direction) {
		this.setExplosionTime(explosionTime);
		this.setColor(firstColor);
		this.setSize(firstSize);
		this.setVelocity(velocity);
		this.setPosition(position);
		this.setDirection(direction);
		this.setAcceleration(acceleration);
		this.setAge(0);
	}

	private void move() {
		Point movementPoint;
		double nX, nY;
		if((this.getDirection() > 180) &&(this.getDirection()<360)) {
			nX = Math.abs(this.getVelocity().getX())*Math.cos(this.getDirectionRad());
			nY = Math.abs(this.getVelocity().getY())*Math.sin(this.getDirectionRad());
		} else {
			nX = this.getVelocity().getX()*Math.cos(this.getDirectionRad());
			nY = this.getVelocity().getY()*Math.sin(this.getDirectionRad());
		}
		movementPoint = new Point(nX, nY);
		this.getPosition().plus(movementPoint);
	}
	
	/**
	 * Calls particle's next iteration
	 */
	public void nextIteration() {
		
		this.getVelocity().plus(this.getAcceleration());
		this.move();

		if(this.getAge() == this.getExplosionTime()) {
			double maxInc;
			float r,g,b;
			
			this.setDirection(Math.random()*360);
			this.setSize(this.getSize()/4);

			
			if((this.getDirection() > 180) &&(this.getDirection()<360)) {
				this.getVelocity().absoluteValue();
				this.getVelocity().multiply(-1);
				maxInc = -Particle.EXPLOSION_POWER;
			} else {
				maxInc = Particle.EXPLOSION_POWER;
			}

			
			this.getVelocity().plus(new Point(Math.random()*maxInc,Math.random()*maxInc));
			r = (float)Math.random();
			g = (float)Math.random();
			b = (float)Math.random();
			this.setColor(new Color(r,g,b));
		}
		
		this.incAge();
	}
	
	public double getSize() {
		return size;
	}

	private void setSize(double size) {
		this.size = size;
	}

	private int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	private void incAge() {
		this.age++;
	}

	public double getX() {
		return position.getX();
	}

	public double getY() {
		return position.getY();
	}

	private void setPosition(Point position) {
		this.position = position.clone();
	}
	/**
	 * @return the direction angle converted to rad
	 */
	private double getDirectionRad() {
		return (this.direction/360*(Math.PI*2));
	}
		
	/**
	 * @param direction The direction angle  to set (in grades)
	 */
	private void setDirection(double direction) {
		this.direction = direction;
	}

	private Point getVelocity() {
		return velocity;
	}

	private void setVelocity(Point velocity) {
		this.velocity = velocity.clone();
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		this.color = color;
	}

	private int getExplosionTime() {
		return explosionTime;
	}

	private void setExplosionTime(int explosionTime) {
		this.explosionTime = explosionTime;
	}

	private Point getAcceleration() {
		return acceleration;
	}

	private Point getPosition() {
		return this.position;
	}
	
	private void setAcceleration(Point acceleration) {
		this.acceleration = acceleration.clone();
	}
	
	private double getDirection() {
		return this.direction;
	}
	
}

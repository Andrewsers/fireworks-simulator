package ps;

import java.awt.Color;
import util.Point;
import java.util.LinkedList;

import ps.view.FireworksParticleSystemFrame;

public class ParticleSystem {
	
	private static final int FPS = 30;
	
	/**
	 * Time to wait between iterations
	 */
	private int delay;

	/**
	 * The particles
	 */
	LinkedList<Particle> particles;
	
	/**
	 * The frame where the animation is shown 
	 */
	private FireworksParticleSystemFrame frame;
	
	/**
	 * Instantiates the particles using default direction (70 grades) and default acceleration ( gravity = 10 m/s^2)
	 * @param particlesAmount particles quantity
	 * @param explosionTime the time (iterations) that the particle will move before explode
	 * @param firstColor particles first color
	 * @param firstSize particles first size
	 * @param velocity particles velocity
	 * @param position particles start position
	 */
	public ParticleSystem(int particlesAmount, int explosionTime, Color firstColor, int firstSize, Point velocity, Point position) {
		this(particlesAmount, explosionTime, firstColor, firstSize, velocity, position, new Point(0,-9.8),70.0f);
	}
	
	
	/**
	 * Instantiate the Fireworks Particle System simulation
	 * @param particlesAmount particles quantity
	 * @param explosionTime the time ( seconds ) that the particle will move before explode
	 * @param firstColor particles first color
	 * @param firstSize particles first size
	 * @param velocity particles velocity
	 * @param position particles start position
	 * @param aceleration particles acceleration on each iteration
	 * @param direction particles direction
	 */
	public ParticleSystem(int particlesAmount, int explosionTime, Color firstColor, double firstSize, Point velocity, Point position, Point acceleration, double direction) {
		this.particles = new LinkedList<Particle>();
		acceleration.divide(ParticleSystem.FPS);
		explosionTime = explosionTime * ParticleSystem.FPS; // Seconds to Iterations conversion
		for(int i=0;i<particlesAmount;i++) {
			this.particles.add(new Particle(explosionTime, firstColor, firstSize, velocity, position, acceleration, direction));
		}
		this.setFrame(new FireworksParticleSystemFrame(particles));
		this.getFrame().setSize(800, 600);
		this.setDelay(1000/ParticleSystem.FPS);
 	}
	
	/**
	 * Starts simulation
	 */
	public void run() {
		this.getFrame().setVisible(true);
		
		while(true) {
			
			for(Particle p: this.particles) {
				p.nextIteration();
			}
			
			this.getFrame().update();
			
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private FireworksParticleSystemFrame getFrame() {
		return frame;
	}


	private void setFrame(FireworksParticleSystemFrame frame) {
		this.frame = frame;
	}
	
	public void setSize(int width, int height) {
		this.getFrame().setSize(width, height);
	}


	public int getDelay() {
		return delay;
	}


	public void setDelay(int delay) {
		this.delay = delay;
	}

}

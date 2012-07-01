package ps.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import ps.Particle;

public class FireworksParticleSystemCanvas extends java.awt.Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3541179482227852509L;

	/**
	 * 
	 */
	private LinkedList<Particle> particles;
	
	/**
	 * Second buffer image
	 */
	private Image offscreen;
	
	/**
	 * Second buffer 
	 */
	private Graphics outbuffer;
	
	/**
	 * 
	 * @param particles
	 */
	public FireworksParticleSystemCanvas(LinkedList<Particle> particles) {
		this.setParticles(particles);
		this.outbuffer = null;
	}
	
	/**
	 * Setup second buffer
	 */
	private void setup() {
		this.offscreen = this.createImage(this.getWidth(), this.getHeight());
		this.outbuffer = this.offscreen.getGraphics();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		int x, y, size;
		if(this.outbuffer == null) {
			this.setup();
		}
		
		outbuffer.setColor(Color.BLACK);
		outbuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(Particle p: this.getParticles()) {
			outbuffer.setColor(p.getColor());
			x = (int)Math.round(p.getX());
			y = (int)(this.getHeight()-Math.round(p.getY()));
			size = (int)Math.round(p.getSize());
			outbuffer.fillArc(x, y, size, size, 0, 360);
		}
		
		g.drawImage(offscreen, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	private LinkedList<Particle> getParticles() {
		return particles;
	}

	private void setParticles(LinkedList<Particle> particles) {
		this.particles = particles;
	}

}

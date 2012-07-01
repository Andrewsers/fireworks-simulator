package ps.view;

import java.util.LinkedList;

import javax.swing.JFrame;

import ps.Particle;

public class FireworksParticleSystemFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5827522877501605150L;
	
	/**
	 * The canvas
	 */
	private FireworksParticleSystemCanvas canvas;
	
	/**
	 * 
	 * @param particles
	 */
	public FireworksParticleSystemFrame(LinkedList<Particle> particles) {
		super("Fireworks Particle System Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.canvas = new FireworksParticleSystemCanvas(particles);
		this.add("Center", this.canvas);
	}
	
	public void update() {
		this.canvas.repaint();
	}

	FireworksParticleSystemCanvas getCanvas() {
		return canvas;
	}

	void setCanvas(FireworksParticleSystemCanvas canvas) {
		this.canvas = canvas;
	}

}

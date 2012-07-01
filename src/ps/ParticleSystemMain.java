package ps;

import java.awt.Color;
import util.Point;

public class ParticleSystemMain {
	
	public static void main(String[] args) {
		ParticleSystem ps = new ParticleSystem(1000, 2, Color.ORANGE, 15, new Point(15,25), new Point(10,10), new Point(0, -9.8f), 45.0d);
		ps.setSize(1366, 768);
		ps.run();
	}

}

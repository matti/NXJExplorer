import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class ScanUpDown implements Behavior {

	int scanTime;
	boolean moving;
	boolean upwards;
	
	public ScanUpDown() {
		moving = false;
		upwards = false;
	}
	
	public boolean takeControl() {
		if ( moving )
		   return false;
		
		scanTime++;
		
		if (scanTime > 1250) {
			scanTime = 0;
			return(true);
		} else {
			return(false);
		}
	}

	public void action() {
		if (upwards) {
			upwards = false;
			down();			
		} else {
			upwards = true;
			up();
		}
		
		moving = false;
	}
	
	public void suppress() {}
	
	private void up() {
		moving = true;
		Motor.A.setSpeed(900);
		Motor.A.rotate(-20);
	}

	private void down() {
		Motor.A.setSpeed(900);
		Motor.A.rotate(20);
	}

}

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class DriveForward implements Behavior {
    int speed = 100;
	int turnTime = 0;
	int direction = 0;
	
   	public boolean takeControl() {
		turnTime++;
		return true;
	}
	
	public void suppress() {}

   	public void action() {

		speed = Motor.B.getSpeed();

		if ( turnTime > 700 ) {
		
			if ( direction == 0 ) {
				Motor.B.stop();
				try { Thread.sleep(150); } catch (Exception e) {}
				direction = 1;
			} else {
				Motor.C.stop();
				try { Thread.sleep(150); } catch(Exception e) {}
				direction = 0;
			}

			turnTime = 0;
		}
		
	
		if (speed < 400) {
			speed = speed + 1;
			Motor.B.setSpeed(speed);
			Motor.C.setSpeed(speed);
		}

		Motor.B.forward();
		Motor.C.forward();
	}
}

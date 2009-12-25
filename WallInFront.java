import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class WallInFront implements Behavior {

	UltrasonicSensor sonic;


	public WallInFront(UltrasonicSensor sonicSensor) {
		sonic = sonicSensor;
	}

	public boolean takeControl() {
		int distance = sonic.getDistance();
		return ( distance < 20 );
    }

	public void suppress() { }

	public void action() {
		
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(0);
		Motor.B.stop();
		Motor.C.stop();

		Sound.twoBeeps();

		Motor.B.setSpeed(400);
		Motor.C.setSpeed(400);

		Motor.B.backward();
		Motor.C.backward();
   
		try{Thread.sleep(1000);}catch(Exception e) {}
		Motor.B.stop();
		try{Thread.sleep(900);}catch(Exception e) {}
		Motor.C.stop();

		Motor.B.setSpeed(0);
		Motor.C.setSpeed(0);
   }
} 

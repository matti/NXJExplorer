import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class NXJExplorer {

	public static void main (String[] args) {

   	    LCD.clear();

		// Raise front fork
		Motor.A.rotate(-20);
		try{Thread.sleep(300);}catch(Exception e) {}
		
		Sound.beep();
		
        Behavior b1 = new DriveForward();
 	    Behavior b2 = new WallInFront(new UltrasonicSensor(SensorPort.S1));
		Behavior b3 = new ScanUpDown();
		Behavior b4 = new Listen(new SoundSensor(SensorPort.S2));
		Behavior b5 = new BackGuard(new TouchSensor(SensorPort.S3));
		
        Behavior [] bArray = {b1,b2,b3,b4,b5};

        Arbitrator arby = new Arbitrator(bArray);
        arby.start();
	}

}

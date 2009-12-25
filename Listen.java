import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class Listen implements Behavior {
	SoundSensor sensor;
	
	public Listen(SoundSensor soundSensor) {
		sensor = soundSensor;
	}

	public boolean takeControl() {
   		return((sensor.readValue() > 60) ? true : false);
	}

   	public void suppress() { }

   	public void action() {
		Motor.B.backward();
		Motor.C.backward();
   		try{Thread.sleep(900);}catch(Exception e) {}
	}
}

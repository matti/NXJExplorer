import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class BackGuard implements Behavior, SensorPortListener {

	TouchSensor touch;
	boolean hasCollided = false;

	public BackGuard(TouchSensor touchSensor) {
		touch = touchSensor;
		SensorPort.S3.addSensorPortListener(this);
	}


	public void stateChanged(SensorPort port, int oldValue, int newValue) {
		if (touch.isPressed())
			hasCollided = true;
    }

	public boolean takeControl() {
		if (hasCollided) {
			hasCollided = false;
			return true;
		} else {
			return false;
		}
	}
	
	public void suppress() { }

	public void action() {
		Motor.B.forward();
		Motor.C.forward();
   }
} 

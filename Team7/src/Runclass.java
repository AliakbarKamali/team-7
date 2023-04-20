import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runclassss extends Thread {

	public static void main(String[] args) {
		AtomicBoolean robotStop = new AtomicBoolean(false);
		AtomicBoolean robotrotate = new AtomicBoolean(false);
		Motors motorsObj = new Motors();
		LineFollow LFObj = new LineFollow(robotStop, robotrotate);
		Obstacle ODObj = new Obstacle(robotStop, robotrotate);
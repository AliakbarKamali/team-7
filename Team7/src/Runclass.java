import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runclassss extends Thread {

	public static void main(String[] args) {
		AtomicBoolean robotStop = new AtomicBoolean(false);
		AtomicBoolean robotrotate = new AtomicBoolean(false); //create new object for AtomicBoolean
		Motors motorsObj = new Motors();  //create new object for Motors
		LineFollow LFObj = new LineFollow(robotStop, robotrotate);  //create new object for LineFollow
		Obstacle ODObj = new Obstacle(robotStop, robotrotate); //create new object for Obstacle
		Thread thread1 = new Thread(LFObj);    //  creating a thread object to run in LineFollow class 
		Thread thread2 = new Thread(ODObj);    //  creating a thread object to run in Obstacle class 
		Thread thread3 = new Thread(motorsObj);//  creating a thread object to run in Motors class 

		thread1.start();  //For LineFollow
		thread2.start();  //For Obstacle
		thread3.start();  //For Motors
	}
}

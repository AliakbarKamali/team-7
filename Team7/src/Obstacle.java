
public class Obstacle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//HosseinaliTaheri
//taheri test1 
		//new test
//=======
//taheri test1
		//test2
// main
		import lejos.hardware.Button;
		import lejos.hardware.motor.EV3LargeRegulatedMotor;
		import lejos.hardware.port.MotorPort;
		import lejos.hardware.port.SensorPort;
		import lejos.hardware.sensor.EV3UltrasonicSensor;
		import lejos.robotics.RegulatedMotor;
		import lejos.robotics.SampleProvider;
		import lejos.utility.Delay;
		import java.util.concurrent.atomic.AtomicBoolean;
		import lejos.hardware.Sound;

		public class Obstacle implements Runnable {

		  AtomicBoolean robotStop;
		  AtomicBoolean robotrotate;
		  public Obstacle(AtomicBoolean robotStop, AtomicBoolean robotrotate) {
		    this.robotStop = robotStop;
		    this.robotrotate = robotrotate;
		  }

		  private static EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);
		  SampleProvider sp = us1.getDistanceMode(); // Create object for SampleProvider

		  int distanceValue = 0;

		  @Override
		  public void run() {

		    while (true) {
		      System.out.println("Distance: " + distanceValue);
		      float[] sample = new float[sp.sampleSize()];
		      sp.fetchSample(sample, 0);
		      distanceValue = (int) (sample[0] * 100);
		      if (distanceValue <= 20) {
		        robotStop.set(true);
//		        Sound.buzz();
		                int[] frequencies = { 440, 494, 523, 587, 659, 698, 784 }; // Frequencies in Hz
		                  int[] durations = { 100, 200, 300, 100, 200, 300, 1000 }; // Durations in milliseconds
		                  
		                  for (int i = 0; i < frequencies.length; i++) {
		                     Sound.playTone(frequencies[i], durations[i]);
		                     try {
		                        Thread.sleep(durations[i]);
		                     } catch (InterruptedException e) {
		                        e.printStackTrace();
		                     }
		                  }
		        robotrotate.set(true);
		      }
		      Delay.msDelay(10);
		      if (Button.getButtons() != 0) {
		        break;
		      }
		    }
		  }

		}
	}

}

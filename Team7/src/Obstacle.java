import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort; // javalejos library
import lejos.hardware.port.SensorPort; // javalejos library
import lejos.hardware.sensor.EV3UltrasonicSensor;// javalejos library
import lejos.robotics.RegulatedMotor;// javalejos library
import lejos.robotics.SampleProvider;// javalejos library
import lejos.utility.Delay;// javalejos library
import java.util.concurrent.atomic.AtomicBoolean;// javalejos library
import lejos.hardware.Sound;// javalejos library

public class Obstacle implements Runnable {

  AtomicBoolean robotStop; //AtomicBoolean for useing all class
  AtomicBoolean robotrotate; //AtomicBoolean for useing all class
  public Obstacle(AtomicBoolean robotStop, AtomicBoolean robotrotate) {
    this.robotStop = robotStop;
    this.robotrotate = robotrotate;
  }

  private static EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);
  SampleProvider sp = us1.getDistanceMode();

  int distanceValue = 0;

  @Override
  public void run() {

    while (true) {
      System.out.println("Distance: " + distanceValue);
      float[] sample = new float[sp.sampleSize()]; //create array sample
      sp.fetchSample(sample, 0);
      distanceValue = (int) (sample[0] * 100);
      if (distanceValue <= 20) {
        robotStop.set(true);
//        Sound.buzz();
                int[] frequencies = { 440, 494, 523, 587, 659, 698, 784 }; // Frequencies in Hz
                  int[] durations = { 300, 500, 200, 500, 200, 300, 1000 }; // Durations in milliseconds
                  
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

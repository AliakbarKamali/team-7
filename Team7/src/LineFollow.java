import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import java.util.concurrent.atomic.AtomicBoolean;

public class LineFollow implements Runnable {
  AtomicBoolean robotStop;
  AtomicBoolean robotrotate;

  public LineFollow(AtomicBoolean robotStop, AtomicBoolean robotrotate) {
    this.robotStop = robotStop;
    this.robotrotate = robotrotate;
  }

  EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
  SampleProvider colorProvider = colorSensor.getRedMode();
  float[] sample = new float[colorProvider.sampleSize()];

  @Override
  public void run() {
    while (true) {
      colorProvider.fetchSample(sample, 0);
      float redValue = sample[0];
      if (redValue < 0.2) {
        Motors.run1();
      } else {
        Motors.run2();
      }
      if (robotStop.get() && !robotrotate.get()) {
        Motors.run3();

        boolean forStopWhile = false;
        while (!forStopWhile) {
          colorProvider.fetchSample(sample, 0);
          float redValue1 = sample[0];
          if (redValue1 < 0.2) {
            forStopWhile = true;
            Motors.run4();
            robotStop.set(false);
          }
        }
      }
      while (robotStop.get() && robotrotate.get()) {
        Motors.run5();
        if (Button.getButtons() != 0) {
          break;
        }
      }

      if (Button.getButtons() != 0) {
        break;
      }

    }
  }
}
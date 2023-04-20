

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Testing review

		public class Motors extends Thread {
		  static EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		  static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

		  public EV3LargeRegulatedMotor getMotorA() {
		    return motorA;
		  }

		  public EV3LargeRegulatedMotor getMotorD() {
		    return motorD;
		  }

		  public static void run1() {
		    motorA.setSpeed(200);
		    motorD.setSpeed(100);
		    motorA.forward();
		    motorD.forward();
		  }

		  public static void run2() {
		    motorA.setSpeed(100);
		    motorD.setSpeed(200);
		    motorA.forward();
		    motorD.forward();
		  }

		  public static void run3() {
		    motorA.stop();
		    motorD.stop();
		    Delay.msDelay(1);
		    motorA.setSpeed(90);
		    motorD.setSpeed(90);
		    motorA.backward();
		    motorD.forward();
		    Delay.msDelay(1000);
		    motorA.setSpeed(250);
		    motorD.setSpeed(150);
		    motorA.forward();
		    motorD.forward();
		    Delay.msDelay(100);
		  }

		  public static void run4() {
		    motorA.stop();
		    motorD.stop();
		    Delay.msDelay(100);
		  }

		  public static void run5() {
		    motorA.setSpeed(500);
		    motorD.setSpeed(100);
		    motorA.forward();
		    motorD.backward();

		  }
		  public static void run6(float output) {


				Motors.motorA.setSpeed(450 + output);
				Motors.motorD.setSpeed(450 - output);
				Motors.motorA.forward();
				Motors.motorD.forward();
			  }
		  public static void run7() {
			    motorA.setSpeed(50);
			    motorD.setSpeed(50);
			    motorA.backward();
			    motorD.forward();
			    Delay.msDelay(10);
		  }
		}
		  
	}

}

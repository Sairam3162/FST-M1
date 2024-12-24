
public class Activity6 {

	public static <exception> void main(String[] args) throws InterruptedException {

		Plane plane = new Plane(10);

		plane.onboard("Sairam");
		plane.onboard("Pawan Kalyan");
		plane.onboard("Sai Pallavi");

		System.out.println("The plane took off at: " + plane.takeOff());

		System.out.println("The people on the plane: " + plane.getPassesngers());

		Thread.sleep(5000);

		plane.land();

		System.out.println("The plane landed at: " + plane.getLastTimeLanded());

		System.out.println("The people of the plane after landing: " + plane.getPassesngers());

	}

}

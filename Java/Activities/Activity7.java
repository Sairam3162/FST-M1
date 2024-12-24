
public class Activity7 {
	
	public static void main(String[] args) {
		
		MountainBike MB = new MountainBike(5, 0, 50);
		System.out.println(MB.bicycleDesc());
		MB.speedUp(50);
		MB.applyBrake(10);
		
	}

}

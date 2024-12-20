
public class Activity3 {

	public static void main(String[] args) {

		double seconds = 1000000000;

		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;

		double earthAge = seconds / EarthSeconds;
		MercurySeconds = seconds / EarthSeconds / MercurySeconds;
		VenusSeconds = seconds / EarthSeconds / VenusSeconds;
		MarsSeconds = seconds / EarthSeconds / MarsSeconds;
		JupiterSeconds = seconds / EarthSeconds / JupiterSeconds;
		SaturnSeconds = seconds / EarthSeconds / SaturnSeconds;
		UranusSeconds = seconds / EarthSeconds / UranusSeconds;
		NeptuneSeconds = seconds / EarthSeconds / NeptuneSeconds;

		System.out.println("Age of Earth : " + earthAge + " years ");
		System.out.println("Age of Mercury : " + MercurySeconds + " years ");
		System.out.println("Age of Mercury : " + VenusSeconds + " years ");
		System.out.println("Age of Mercury : " + MarsSeconds + " years ");
		System.out.println("Age of Mercury : " + JupiterSeconds + " years ");
		System.out.println("Age of Mercury : " + SaturnSeconds + " years ");
		System.out.println("Age of Mercury : " + UranusSeconds + " years ");
		System.out.println("Age of Mercury : " + NeptuneSeconds + " years ");
		

//		System.out.println("Age of Earth : " + seconds / EarthSeconds + " years ");
//		System.out.println("Age of Mercury : " + seconds / EarthSeconds / MercurySeconds + " years ");
//		System.out.println("Age of Venus : " + seconds / EarthSeconds / VenusSeconds + " years ");
//		System.out.println("Age of Mars : " + seconds / EarthSeconds / MarsSeconds + " years ");
//		System.out.println("Age of Jupiter : " + seconds / EarthSeconds / JupiterSeconds + " years ");
//		System.out.println("Age of Saturn : " + seconds / EarthSeconds / SaturnSeconds + " years ");
//		System.out.println("Age of Uranus : " + seconds / EarthSeconds / UranusSeconds + " years ");
//		System.out.println("Age of Neptune : " + seconds / EarthSeconds / NeptuneSeconds + " years ");

	}

}

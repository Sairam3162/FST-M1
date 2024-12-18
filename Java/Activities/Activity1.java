
public class Activity1 {

	public static void main(String[] args) {

		Car carName = new Car();

		carName.make = 2014;
		carName.color = "Black";
		carName.transmission = "Manual";

		carName.displayCharacterstics();
		carName.accelarate();
		carName.brake();
		
		Car BMW = new Car();
		
		carName.make = 2015;
		carName.color = "White";
		carName.transmission = "Automatic";

		carName.displayCharacterstics();
		carName.accelarate();
		carName.brake();
	}

}

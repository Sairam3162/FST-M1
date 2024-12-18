
public class Car {

	// Class variavles

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	// Constructors

	Car() {

		tyres = 4;
		doors = 4;
	}

	// Class Methods

	public void displayCharacterstics() {
		System.out.println("Color of the Car is : " + color);
		System.out.println("Transmission of the Car is : " + transmission);
		System.out.println("Make of the Car is : " + make);
		System.out.println("Tyres of the Car are : " + tyres);
		System.out.println("Doors of the Car are : " + doors);
	}

	public void accelarate() {

		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car has stopped.");
	}

}

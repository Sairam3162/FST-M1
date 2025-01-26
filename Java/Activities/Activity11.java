import java.util.HashMap;

public class Activity11 {
	public static void main(String[] args) {

		HashMap<Integer, String> colours = new HashMap<Integer, String>();

		colours.put(1, "Green");
		colours.put(2, "Red");
		colours.put(3, "Yellow");
		colours.put(4, "Violet");
		colours.put(5, "Pink");

		System.out.println(colours);
		colours.remove(5);

		if (colours.containsValue("Green")) {
			System.out.println("Green colour is present in the Map");
		} else {
			System.out.println("Green colour is not present in the Map");
		}

		System.out.println("The size of the MAP is : " + colours.size());

	}
}
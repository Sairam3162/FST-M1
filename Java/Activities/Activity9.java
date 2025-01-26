import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<String>();

		myList.add("Sairam");
		myList.add("James");
		myList.add("Honey");
		myList.add("Beans");
		myList.add("Henry");

		System.out.println("Print All the Object:");
		for (String s : myList) {
			System.out.println(s);
		}

		System.out.println("3rd name of the list is : " + myList.get(2));
		System.out.println("Checking Ajay name is present : " + myList.contains("Ajay"));
		System.out.println("Size of the array list is : " + myList.size());

		myList.remove("Beans");

		System.out.println("Size of the array list is : " + myList.size());
	}

}

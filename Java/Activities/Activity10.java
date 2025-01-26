import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();

		hs.add("Sairam");
		hs.add("Honey");
		hs.add("James");
		hs.add("Ajay");
		hs.add("Jimmy");
		hs.add("Pat");

		System.out.println("The size of the HashSet is : " + hs.size());

		hs.remove("Ajay");
		hs.remove("Raju");

		if (hs.remove("Raju")) {
			System.out.println("Raju removed from the Set");
		} else {
			System.out.println("Raju is not present in the Set");
		}

		System.out.println("Checking is Jimmy name is present in HashSet : " + hs.contains("Jimmy"));

		System.out.println("Print All the Object:");
		for (String s : hs) {
			System.out.println(s);
		}
	}

}

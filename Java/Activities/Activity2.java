
public class Activity2 {

	public static void main(String[] args) {

		int[] numbers = { 10, 77, 10, 54, -11, 10 };

		int sum = 0;

		for (int num : numbers) {
			if (num == 10) {

				sum += num;
			}
		}
		System.out.println(sum);

		if (sum == 30) {
			System.out.println("The Sum of all 10's is : " + sum + " Equal to 30");

		} else {
			System.out.println("The sum of all 10's is: " + sum + " Not equal to 30");
		}
	}
}

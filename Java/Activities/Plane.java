
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane<passengers> {

	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>();
	}

	public void onboard(String passenger) {
		this.passengers.add(passenger);
	}

	public Date takeOff() {
		this.lastTimeTookOf = new Date(maxPassengers, maxPassengers, maxPassengers);
		return lastTimeTookOf;
	}

	public void land() {
		this.lastTimeLanded = new Date(maxPassengers, maxPassengers, maxPassengers);
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassesngers() {
		return passengers;
	}
}

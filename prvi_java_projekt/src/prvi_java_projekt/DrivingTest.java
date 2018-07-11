package prvi_java_projekt;

public class DrivingTest {
	
	public static void main(String[] args) {
		
		Car myCar = new Car();
		/**
		 * Initialize the starting state of my car
		 */
		myCar.tankCapacity=55;
		myCar.fuelEfficiency=6.5;
		myCar.fuelLevel=10;
		myCar.totalKilometers=56000;
		
		/**
		 * Start the driving simulation
		 */
		
		myCar.addFuel(60.0);
		myCar.drive(500);
		
	}

}

class Car {
	double fuelEfficiency; // l/100km
	double totalKilometers; // km
	double tankCapacity; // l
	double fuelLevel; // l
	
	public void drive(double distance) {
		double possibleDistance=fuelLevel/(fuelEfficiency/100);
		
		if (possibleDistance>=distance) {
			totalKilometers=totalKilometers+distance;
			double fuelSpent=distance*fuelEfficiency/100;
			fuelLevel=fuelLevel-fuelSpent;
			
			System.out.println("Great, you have driven "+distance+" km and spent "+fuelSpent+" liters of fuel.");
		}
		else {
			System.out.println("You do not have enough fuel for your trip!");
		}
	}
	
	public void addFuel(double amount) {
		fuelLevel=fuelLevel+amount;
		
		if (fuelLevel>tankCapacity) {
			double fuelReallyAdded=amount-(fuelLevel-tankCapacity);
			fuelLevel=tankCapacity;
			System.out.println("You have exceeded the tank capacity of "+ tankCapacity +" liters, and have added only "+ fuelReallyAdded +" instead of " + amount +" liters to the tank.");
		}
	}
}
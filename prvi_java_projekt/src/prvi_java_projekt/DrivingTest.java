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
		 * Report the initial state to the user
		 */
		System.out.println("Your car has started with "+myCar.totalKilometers+" km in total and the status of your tank is "+myCar.fuelLevel+" liters.");
		
		
		/**
		 * Start the driving simulation
		 */
		
		myCar.drive(100);
		myCar.addFuel(60.0);
		myCar.drive(500);
		
		/**
		 * Report the end state
		 */
		
		System.out.println("Your car now has "+myCar.totalKilometers+" km in total and the status of your tank is "+myCar.fuelLevel+" liters.");
		
	}

}

class Car {
	double fuelEfficiency; // l/100km
	double totalKilometers; // km
	double tankCapacity; // l
	double fuelLevel; // l
	
	Car() {
		// Default values when a new car is constructed.
		fuelEfficiency=5; totalKilometers=0; tankCapacity=50; fuelLevel=0;
	}
	
	public void drive(double distance) {
		double possibleDistance=fuelLevel/(fuelEfficiency/100);
		
		if (possibleDistance>=distance) {
			totalKilometers=totalKilometers+distance;
			double fuelSpent=distance*fuelEfficiency/100;
			fuelLevel=fuelLevel-fuelSpent;
			
			System.out.println("You have driven "+distance+" km and spent "+fuelSpent+" liters of fuel.");
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
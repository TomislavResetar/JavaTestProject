package prvi_java_projekt;

public class DrivingTest {
	
	public static void main(String[] args) {
		
		Car myCar = new Car(5.5, 56000, 55, 20);
		
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
	
	Car(){
		fuelEfficiency=5; totalKilometers=0; tankCapacity=50; fuelLevel=0;
		System.out.println("New car is being created with DEFAULT values:\n"
				+ "Fuel efficiency of "+fuelEfficiency+" L/100km, "+totalKilometers+" kilometers,"
				+ " "+fuelLevel+" liters of fuel in the tank and a tank capacity "
				+ "of "+tankCapacity+" liters.");
	}
	
	Car(double feff,double totkm,double tankc,double fuellev){
		fuelEfficiency=feff; totalKilometers=totkm; tankCapacity=tankc; fuelLevel=fuellev;
		System.out.println("New car is being created with CUSTOM values:\n"
				+ "Fuel efficiency of "+fuelEfficiency+" L/100km, "+totalKilometers+" kilometers,"
				+ " "+fuelLevel+" liters of fuel in the tank and a tank capacity "
				+ "of "+tankCapacity+" liters.");
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
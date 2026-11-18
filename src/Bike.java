//  Person 1 - manish

public class Bike extends Vehicle {

    public Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public int getHourlyRate() {
        return 10;
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}
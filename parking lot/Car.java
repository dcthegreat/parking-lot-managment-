//  Person 1 - manish

public class Car extends Vehicle {

    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public int getHourlyRate() {
        return 20;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}
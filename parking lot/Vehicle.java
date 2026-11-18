//  Person 1 - manish

public abstract class Vehicle {

    private String vehicleNumber;
    private String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract int getHourlyRate();

    public abstract String getVehicleType();

    @Override
    public String toString() {
        return getVehicleType() + " " + vehicleNumber +
               " (Owner: " + ownerName + ")";
    }
}
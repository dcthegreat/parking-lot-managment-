//  Person 2 - afrin

public class ParkingSpot {

    private String spotId;
    private String spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getSpotType() {
        return spotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public boolean canFit(Vehicle v) {
        return spotType.equals(v.getVehicleType());
    }

    public void park(Vehicle v) {
        parkedVehicle = v;
    }

    public void removeVehicle() {
        parkedVehicle = null;
    }

    @Override
    public String toString() {

        if (isFree()) {
            return spotId + " (" + spotType + ") - Free";
        }

        return spotId + " (" + spotType + ") - " +
               parkedVehicle.getVehicleNumber();
    }
}
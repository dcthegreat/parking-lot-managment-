//  Person 4 - divyanshu

public class ParkingFullException extends Exception {

    public ParkingFullException() {
        super("No free spot for this vehicle type");
    }
}
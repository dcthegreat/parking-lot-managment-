//  Person 3 - nandani

public class Ticket {

    private static int counter = 0;

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private double entryHour;

    public Ticket(Vehicle vehicle, ParkingSpot spot, double entryHour) {

        counter++;

        this.ticketId = "T" + counter;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryHour = entryHour;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public double getEntryHour() {
        return entryHour;
    }

    public void printTicket() {

        System.out.println("\n========== PARKING TICKET ==========");
        System.out.println("Ticket ID     : " + ticketId);
        System.out.println("Vehicle       : " + vehicle.getVehicleNumber());
        System.out.println("Owner         : " + vehicle.getOwnerName());
        System.out.println("Vehicle Type  : " + vehicle.getVehicleType());
        System.out.println("Parking Spot  : " + spot.getSpotId());
        System.out.println("Entry Hour    : " + entryHour);
        System.out.println("Hourly Rate   : Rs. " + vehicle.getHourlyRate());
        System.out.println("====================================\n");
    }
}
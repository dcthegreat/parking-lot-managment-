// Person 4 - divyanshu

public class ParkingLot {

    private static final int CAR_SPOTS = 5;
    private static final int BIKE_SPOTS = 3;
    private static final int TOTAL_SPOTS = CAR_SPOTS + BIKE_SPOTS;

    private ParkingSpot[] spots;
    private Ticket[] tickets;
    private int ticketCount;

    public ParkingLot() {

        spots = new ParkingSpot[TOTAL_SPOTS];

        tickets = new Ticket[TOTAL_SPOTS];

        ticketCount = 0;

        for (int i = 0; i < CAR_SPOTS; i++) {
            spots[i] = new ParkingSpot("C" + (i + 1), "CAR");
        }

        for (int i = 0; i < BIKE_SPOTS; i++) {
            spots[CAR_SPOTS + i] =
                new ParkingSpot("B" + (i + 1), "BIKE");
        }
    }

    public void parkVehicle(Vehicle v, double entryHour)
            throws ParkingFullException {

        if (entryHour < 0 || entryHour > 24) {
            throw new IllegalArgumentException(
                "Entry hour must be between 0 and 24."
            );
        }

        if (ticketCount >= tickets.length) {
            throw new ParkingFullException();
        }

        for (int i = 0; i < spots.length; i++) {

            if (spots[i].isFree() && spots[i].canFit(v)) {

                spots[i].park(v);

                Ticket ticket = new Ticket(v, spots[i], entryHour);

                tickets[ticketCount] = ticket;

                ticketCount++;

                ticket.printTicket();

                return;
            }
        }

        throw new ParkingFullException();
    }

    public void exitVehicle(String ticketId, double exitHour)
            throws InvalidTicketException {

        if (exitHour < 0 || exitHour > 24) {
            throw new IllegalArgumentException(
                "Exit hour must be between 0 and 24."
            );
        }

        for (int i = 0; i < ticketCount; i++) {

            if (tickets[i].getTicketId().equalsIgnoreCase(ticketId)) {

                Ticket ticket = tickets[i];

                Payment payment = new Payment();

                payment.printReceipt(ticket, exitHour);

                ticket.getSpot().removeVehicle();

                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }

                tickets[ticketCount - 1] = null;

                ticketCount--;

                System.out.println("Vehicle exited successfully!");
                System.out.println("Parking spot " +
                                   ticket.getSpot().getSpotId() +
                                   " is now free.");

                return;
            }
        }

        throw new InvalidTicketException();
    }

    public void showAvailableSpots() {

        System.out.println("\n========== AVAILABLE SPOTS ==========");

        boolean found = false;

        for (ParkingSpot spot : spots) {

            if (spot.isFree()) {
                System.out.println(spot);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available parking spots.");
        }

        System.out.println("=====================================\n");
    }

    public void showParkedVehicles() {

        System.out.println("\n========== PARKED VEHICLES ==========");

        boolean found = false;

        for (ParkingSpot spot : spots) {

            if (!spot.isFree()) {
                System.out.println(spot);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles currently parked.");
        }

        System.out.println("=====================================\n");
    }
}
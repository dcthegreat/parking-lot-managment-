//  Person 3 - nandani

public class Payment {

    public int calculateAmount(Ticket ticket, double exitHour) {

        double entryHour = ticket.getEntryHour();

        if (exitHour < entryHour) {
            throw new IllegalArgumentException(
                "Exit time cannot be earlier than entry time."
            );
        }

        double duration = exitHour - entryHour;

        int chargedHours = Math.max(1, (int) Math.ceil(duration));

        return chargedHours * ticket.getVehicle().getHourlyRate();
    }

    public void printReceipt(Ticket ticket, double exitHour) {

        double entryHour = ticket.getEntryHour();

        int hours = Math.max(
            1,
            (int) Math.ceil(exitHour - entryHour)
        );

        int amount = calculateAmount(ticket, exitHour);

        System.out.println("\n========== PAYMENT RECEIPT ==========");
        System.out.println("Ticket ID    : " + ticket.getTicketId());
        System.out.println("Vehicle      : " +
                           ticket.getVehicle().getVehicleNumber());
        System.out.println("Parking Spot : " + ticket.getSpot().getSpotId());
        System.out.println("Entry Time   : " + entryHour);
        System.out.println("Exit Time    : " + exitHour);
        System.out.println("Hours Charged: " + hours);
        System.out.println("Hourly Rate  : Rs. " +
                           ticket.getVehicle().getHourlyRate());
        System.out.println("-------------------------------------");
        System.out.println("Amount to Pay: Rs. " + amount);
        System.out.println("=====================================\n");
    }
}
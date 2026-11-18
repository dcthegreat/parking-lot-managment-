//  Person 4 - divyanshu

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot();

        boolean running = true;

        System.out.println("======================================");
        System.out.println("       PARKING LOT MANAGEMENT");
        System.out.println("======================================");

        while (running) {

            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Available Spots");
            System.out.println("4. Show Parked Vehicles");
            System.out.println("5. Stop Program");

            System.out.print("\nEnter your choice: ");

            String input = sc.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            try {

                switch (choice) {

                    case 1:

                        System.out.println("\n1. Car");
                        System.out.println("2. Bike");

                        System.out.print("Select vehicle type: ");

                        String type = sc.nextLine();

                        Vehicle vehicle;

                        if (type.equals("1")) {

                            System.out.print("Enter car number: ");
                            String carNumber = sc.nextLine();

                            System.out.print("Enter owner name: ");
                            String carOwner = sc.nextLine();

                            vehicle = new Car(carNumber, carOwner);

                        } else if (type.equals("2")) {

                            System.out.print("Enter bike number: ");
                            String bikeNumber = sc.nextLine();

                            System.out.print("Enter owner name: ");
                            String bikeOwner = sc.nextLine();

                            vehicle = new Bike(bikeNumber, bikeOwner);

                        } else {

                            System.out.println("Invalid vehicle type!");
                            break;
                        }

                        System.out.print("Enter entry hour (0-24): ");

                        double entryHour = Double.parseDouble(sc.nextLine());

                        parkingLot.parkVehicle(vehicle, entryHour);

                        break;

                    case 2:

                        System.out.print("Enter ticket ID: ");

                        String ticketId = sc.nextLine();

                        System.out.print("Enter exit hour (0-24): ");

                        double exitHour = Double.parseDouble(sc.nextLine());

                        parkingLot.exitVehicle(ticketId, exitHour);

                        break;

                    case 3:

                        parkingLot.showAvailableSpots();

                        break;

                    case 4:

                        parkingLot.showParkedVehicles();

                        break;

                    case 5:

                        running = false;

                        System.out.println("\nThank you for using Parking Lot Management!");

                        break;

                    default:

                        System.out.println("Invalid choice! Enter 1 to 5.");
                }

            } catch (ParkingFullException |
                     InvalidTicketException |
                     IllegalArgumentException e) {

                System.out.println("\nERROR: " + e.getMessage());
            }
        }

        sc.close();
    }
}
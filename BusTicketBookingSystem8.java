import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusTicketBookingSystem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSeats;

        try {
            System.out.print("Enter the total number of seats available: ");
            totalSeats = scanner.nextInt();

            if (totalSeats <= 0) {
                System.out.println("Invalid input. Number of seats must be greater than 0.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        ArrayList<Integer> bookedSeats = new ArrayList<>();

        while (true) {
            System.out.println("\nBus Ticket Booking System");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. View Booked Seats");
            System.out.println("4. View Available Seats");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    bookTicket(bookedSeats, totalSeats, scanner);
                    break;
                case 2:
                    cancelTicket(bookedSeats, scanner);
                    break;
                case 3:
                    viewBookedSeats(bookedSeats);
                    break;
                case 4:
                    viewAvailableSeats(bookedSeats, totalSeats);
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookTicket(ArrayList<Integer> bookedSeats, int totalSeats, Scanner scanner) {
        System.out.print("Enter the seat number to book: ");
        int seatNumber;

        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid seat number.");
            scanner.next(); // Consume the invalid input
            return;
        }

        if (seatNumber < 1 || seatNumber > totalSeats) {
            System.out.println("Invalid seat number. Please enter a seat within the range.");
        } else if (bookedSeats.contains(seatNumber)) {
            System.out.println("Seat already booked. Choose another seat.");
        } else {
            bookedSeats.add(seatNumber);
            System.out.println("Ticket booked successfully for seat number " + seatNumber);
        }
    }

    private static void cancelTicket(ArrayList<Integer> bookedSeats, Scanner scanner) {
        System.out.print("Enter the seat number to cancel: ");
        int seatNumber;

        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid seat number.");
            scanner.next(); // Consume the invalid input
            return;
        }

        if (bookedSeats.contains(seatNumber)) {
            bookedSeats.remove(Integer.valueOf(seatNumber));
            System.out.println("Ticket canceled successfully for seat number " + seatNumber);
        } else {
            System.out.println("Seat not booked. Please enter a valid seat number.");
        }
    }

    private static void viewBookedSeats(ArrayList<Integer> bookedSeats) {
        if (bookedSeats.isEmpty()) {
            System.out.println("No seats booked yet.");
        } else {
            System.out.println("Booked Seats: " + bookedSeats);
        }
    }

    private static void viewAvailableSeats(ArrayList<Integer> bookedSeats, int totalSeats) {
        ArrayList<Integer> availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            if (!bookedSeats.contains(i)) {
                availableSeats.add(i);
            }
        }

        if (availableSeats.isEmpty()) {
            System.out.println("All seats are booked.");
        } else {
            System.out.println("Available Seats: " + availableSeats);
        }
    }
}

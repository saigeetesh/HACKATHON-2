import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private double penaltyRate; // percentage penalty

    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets, double penaltyRate) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.penaltyRate = penaltyRate;
    }

    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    public double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        } else {
            return 0.0;
        }
    }

    public double calculateFinalAmount() {
        double discountedAmount = calculateTotal() - calculateDiscount();
        double penalty = discountedAmount * (penaltyRate / 100.0);
        return discountedAmount + penalty;
    }

    public void displayBill() {
        double total = calculateTotal();
        double discount = calculateDiscount();
        double discountedAmount = total - discount;
        double penalty = discountedAmount * (penaltyRate / 100.0);
        double finalAmount = discountedAmount + penalty;

        System.out.println("\n----- Cinema Ticket Booking Bill -----");
        System.out.println("Movie Name       : " + movieName);
        System.out.printf("Ticket Price     : Rs.%.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Total Amount     : Rs.%.2f%n", total);
        System.out.printf("Discount         : Rs.%.2f%n", discount);
        System.out.printf("Penalty (%.0f%%)   : Rs.%.2f%n", penaltyRate, penalty);
        System.out.printf("Final Amount     : Rs.%.2f%n", finalAmount);
        System.out.println("--------------------------------------");
    }
}

public class CinemaTicketBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movieName = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double ticketPrice = sc.nextDouble();

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = sc.nextInt();

        System.out.print("Enter penalty percentage (e.g., 10, 20): ");
        double penaltyRate = sc.nextDouble();

        MovieTicket ticket = new MovieTicket(movieName, ticketPrice, numberOfTickets, penaltyRate);

        ticket.displayBill();

        sc.close();
    }
}

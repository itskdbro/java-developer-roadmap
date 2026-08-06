package Projects.TicketBookingSystem;

public class TicketBooking {
    private int availableTickets;

    public TicketBooking(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public synchronized void bookTicket(int ticket) {
        System.out.println(Thread.currentThread().getName() + " is trying to book " + ticket + " tickets.......\n");
        if (ticket <= 0) {
            System.out.println("Please enter valid no. of tickets");
            return;
        }
        if (availableTickets < ticket) {
            System.out.println("Sorry! Not enough tickets");
            System.out.println("Remaining Tickets -> " + availableTickets + "\n");
            return;
        }
        availableTickets -= ticket;
        System.out.println("Booking Successfull");
        System.out.println("Remaining Tickets -> " + availableTickets + "\n");
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}

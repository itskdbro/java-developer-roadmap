package Projects.TicketBookingSystem;

public class BookingThread extends Thread {
    private TicketBooking booking;
    private int tickets;

    public BookingThread(TicketBooking booking, int tickets) {
        this.booking = booking;
        this.tickets = tickets;
    }

    @Override
    public void run() {

        booking.bookTicket(tickets);
    }
}

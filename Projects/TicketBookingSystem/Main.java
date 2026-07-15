package Projects.TicketBookingSystem;

public class Main {
    public static void main(String[] args) {

        TicketBooking ticketBooking = new TicketBooking(3);
        BookingThread rahul = new BookingThread(ticketBooking, 4);
        BookingThread keshav = new BookingThread(ticketBooking, 3);
        rahul.setName("rahul");
        keshav.setName("keshav");

        System.out.println("Available tickets -> " + ticketBooking.getAvailableTickets());
        rahul.start();
        keshav.start();


    }
}

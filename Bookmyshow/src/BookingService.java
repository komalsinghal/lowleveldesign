import java.util.ArrayList;
import java.util.List;

public class BookingService {
    long LOCK_TIMEOUT_MILLIS = 60000;
    PaymentService paymentService = new PaymentService();

    public Booking createBooking(User user, Show show, List<Integer> seatNumbers) {
        List<Seat> selectedSeats = new ArrayList<>();

        // Clean expired locks first
        for (Seat seat : show.getSeats()) {
            seat.unlockIfExpired(LOCK_TIMEOUT_MILLIS);
        }

        // Try to lock selected seats
        for (Integer seatNumber : seatNumbers) {
            Seat seat = show.getSeats().get(seatNumber - 1); // Assuming seat numbers start from 1
            synchronized (seat) {
                if (!seat.lock()) {
                    throw new RuntimeException("Seat " + seatNumber + " Not available");
                }
                selectedSeats.add(seat);
            }
        }
        return new Booking(user, show, selectedSeats);
    }

    public boolean completeBooking(Booking booking, Double amount)
    {
        if(paymentService.processPayment(booking.user, amount)){
            for(Seat seat: booking.getSeatList()){
                seat.book();
            }
            booking.completePayment();
            return  true;
        }
        return  false;

    }

}

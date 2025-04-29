import java.time.LocalDateTime;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Screen screen = new Screen("Screen1", 10);
        Movie movie = new Movie("Inception");
        Show show = new Show("Show1", movie,  screen, LocalDateTime.now().plusHours(1), 2);
        BookingService bookingService = new BookingService();

        User user1 = new User("U1", "Alice");
        User user2 = new User("U2", "Bob");

        int seatToBook = 5;

        Runnable user1Booking = () -> {
            try {
                System.out.println(user1.getName() + " trying to book seat " + seatToBook);
                Booking booking = bookingService.createBooking(user1, show, Arrays.asList(seatToBook));
                boolean success = bookingService.completeBooking(booking, 200.0);
                if (success) {
                    System.out.println(user1.getName() + " successfully booked seat " + seatToBook);
                } else {
                    System.out.println(user1.getName() + " failed to book seat " + seatToBook);
                }
            } catch (Exception e) {
                System.out.println(user1.getName() + " failed: " + e.getMessage());
            }
        };

        Runnable user2Booking = () -> {
            try {
                System.out.println(user2.getName() + " trying to book seat " + seatToBook);
                Booking booking = bookingService.createBooking(user2, show, Arrays.asList(seatToBook));
                boolean success = bookingService.completeBooking(booking, 200.0);
                if (success) {
                    System.out.println(user2.getName() + " successfully booked seat " + seatToBook);
                } else {
                    System.out.println(user2.getName() + " failed to book seat " + seatToBook);
                }
            } catch (Exception e) {
                System.out.println(user2.getName() + " failed: " + e.getMessage());
            }
        };

       /*
       When a program calls the start() method, a new thread is created and then the run() method is executed.
        But if we directly call the run() method then no new thread will be created
        and run() method will be executed as a normal method call on the current calling thread itself and no multi-threading will take place.

       user1Booking.run();
        user2Booking.run();*/

        Thread thread1 = new Thread(user1Booking);
        Thread thread2 = new Thread(user2Booking);

        thread1.start();
        thread2.start();
    }
}
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

import java.util.ArrayList;
import java.util.List;

public class Screen {
    String screenId;

    List<Seat> seats;

    public Screen(String screenId, int noOfSeats) {
        this.screenId = screenId;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= noOfSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

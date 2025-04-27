import java.util.List;

public class Booking {
    User user;
    List<Seat> seatList;
    Show show;
    boolean PaymentCompleted;

    public Booking(User user, Show show, List<Seat> seatList) {
        this.user = user;
        this.seatList = seatList;
        this.show = show;
        PaymentCompleted = false;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public Show getShow() {
        return show;
    }

    public boolean isPaymentCompleted() {
        return PaymentCompleted;
    }

    public void completePayment(){
        this.PaymentCompleted = true;
    }
}

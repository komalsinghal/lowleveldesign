import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class BillingService {
    BillingStrategy billingStrategy;
    private final int ratePerHour = 10;

    public int calculateCharges(ParkingTicket ticket, LocalDateTime exitTime)
    {
        //get time difference
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long hours = Math.max(1, duration.toHours()); // charge at least 1 hour
        return (int) (hours * ratePerHour);
    }

}

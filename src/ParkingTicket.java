import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketId;
    private final String spotId;

    public String getTicketId() {
        return ticketId;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    private final String vehicleNumber;
    private final LocalDateTime entryTime;

    public ParkingTicket(String spotId, String vehicleNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = LocalDateTime.now();
    }

}

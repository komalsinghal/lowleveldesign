import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingSpotManager {

    private final Queue<ParkingSpot> availableSpots = new ConcurrentLinkedQueue<>();
    private final Map<String, ParkingSpot> occupiedSpots = new ConcurrentHashMap<>();
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();

    public ParkingSpotManager(List<ParkingSpot> allSpots) {
        availableSpots.addAll(allSpots);
    }

    public synchronized ParkingTicket assignSpot(Vehicle vehicle) {
        ParkingSpot spot = availableSpots.poll();
        if (spot == null) {
            throw new RuntimeException("No spots available");
        }
        spot.occupy(vehicle);
        occupiedSpots.put(spot.getParkingSpotId(), spot);
        ParkingTicket ticket = new ParkingTicket(spot.ParkingSpotId, vehicle.getVehicleNo());
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public synchronized int releaseSpot(String ticketId, BillingService billingService) {
        ParkingTicket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        ParkingSpot spot = occupiedSpots.remove(ticket.getSpotId());
        if (spot != null) {
            spot.vacate();
            availableSpots.offer(spot);
        }

        return billingService.calculateCharges(ticket, LocalDateTime.now());
    }

}


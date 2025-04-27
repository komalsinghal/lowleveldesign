import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> allSpots = new ArrayList<>();
        allSpots.add(new ParkingSpot("123"));
        allSpots.add(new ParkingSpot("345"));

        ParkingSpotManager lot = new ParkingSpotManager(allSpots);
        BillingService billing = new BillingService();

        EntryGate entry = new EntryGate("E1", lot);
        ExitGate exit = new ExitGate("X1", lot, billing);

        Vehicle car = new Vehicle("KA01AB1234");
        ParkingTicket ticket = entry.handleVehicleEntry(car);

// ... some time passes ...

        int charges = exit.handleVehicleExit(ticket.getTicketId());
        System.out.println("Please pay: Rs. " + charges);
    }
}
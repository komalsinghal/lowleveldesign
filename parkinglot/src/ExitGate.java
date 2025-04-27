public class ExitGate {
    private final String gateId;
    private final ParkingSpotManager parkingLot;
    private final BillingService billingService;

    public ExitGate(String gateId, ParkingSpotManager parkingLot, BillingService billingService) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
        this.billingService = billingService;
    }

    public int handleVehicleExit(String ticketId) {
        return parkingLot.releaseSpot(ticketId, billingService);
    }
}

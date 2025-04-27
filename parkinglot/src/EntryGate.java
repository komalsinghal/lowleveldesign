public class EntryGate {
    private final String gateId;
    private final ParkingSpotManager parkingSpotManager;

    public EntryGate(String gateId, ParkingSpotManager parkingSpotManager) {
        this.gateId = gateId;
        this.parkingSpotManager = parkingSpotManager;
    }

    public ParkingTicket handleVehicleEntry(Vehicle vehicle) {
        return parkingSpotManager.assignSpot(vehicle);
    }
}

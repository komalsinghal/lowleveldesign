public class ParkingSpot {


    String ParkingSpotId;
    boolean occupied;
    Vehicle currentVehicle;

    public ParkingSpot(String parkingSpotId) {
        ParkingSpotId = parkingSpotId;
        occupied = false;
        currentVehicle = null;
    }


    public boolean isOccupied() { return occupied; }
    public String getParkingSpotId() {
        return ParkingSpotId;
    }

    public void occupy(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.occupied = true;
    }

    public void vacate() {
        this.currentVehicle = null;
        this.occupied = false;
    }

}

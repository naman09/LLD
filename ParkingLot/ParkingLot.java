import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private Integer currTicketId;

    ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
        this.currTicketId = 1;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    private synchronized ParkingSpot getParkingSpot(VehicleType vehicleType) {
        // find available parking spot
        if (parkingSpots.size() > 0) {
            return parkingSpots.get(0);
        }
        return null;
    }

    public synchronized ParkingTicket bookParkingSpot(VehicleType vehicleType) {
        ParkingSpot parkingSpot = this.getParkingSpot(vehicleType);
        if (parkingSpot == null) {
            System.out.println("no parking spot");
            return null;
            // throw new NoParkingException("No parknig spot available at moment");
        }
        parkingSpot.setIsAvailable(false);
        return new ParkingTicket(currTicketId++, vehicleType, parkingSpot);
    }
}

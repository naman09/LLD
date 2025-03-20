import java.time.LocalDateTime;

public class ParkingTicket {
    private Integer ticketId;
    private VehicleType vehicleType;
    private LocalDateTime timestamp;
    private ParkingSpot parkingSpot;

    ParkingTicket(Integer ticketId, VehicleType vehicleType, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicleType = vehicleType;
        this.parkingSpot = parkingSpot;
    }

    public Integer getTicketId() {
        return this.ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
}

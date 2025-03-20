public class ParkingSpot {
    private ParkingSpotType parkingSpotType;
    private Boolean isAvailable;
    private String location; // build no, floor no, area no, landmark hint

    ParkingSpot(ParkingSpotType parkingSpotType, String location) {
        this.parkingSpotType = parkingSpotType;
        this.location = location;
        this.isAvailable = true;
    }

    public Boolean getIsAvailble() {
        return this.isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

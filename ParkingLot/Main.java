import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         * Parking Lot
         * Parking Spots
         * Multiple type of cars
         * Multiple types of spots
         * Track availablity
         * Generate ticket
         * Payment
         */

        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new ParkingSpot(ParkingSpotType.LARGE, "floor 1 area 1"));
        ParkingLot myParkingLot = new ParkingLot(parkingSpots);

        myParkingLot.addParkingSpot(new ParkingSpot(ParkingSpotType.MEDIUM, "floor 1 area 2"));

        ParkingTicket parkingTicket = myParkingLot.bookParkingSpot(VehicleType.SEDAN);
        System.out.println("Parking ticket: " + parkingTicket.getTicketId().toString());

        ExitPanel exitPanel = new ExitPanel(new FixedPricingStrategy());
        
        try {
            exitPanel.payTicket(parkingTicket, new CreditCardPaymentStrategy("credit card details"));
        } catch (PaymentException e) {
            System.out.println("Payment unsuccessful");
        }
    }
}
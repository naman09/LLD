public class ExitPanel {
    private PricingStrategy pricingStrategy;
    
    ExitPanel(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    private void vacateSpot(ParkingTicket parkingTicket) {
        parkingTicket.getParkingSpot().setIsAvailable(true);
    } 

    public void payTicket(ParkingTicket parkingTicket, PaymentStrategy paymentStrategy) throws PaymentException {
        Double amount = this.pricingStrategy.calculatePrice(parkingTicket);
        paymentStrategy.makePayment(amount);
        this.vacateSpot(parkingTicket);

        System.out.println("Payment successful for parking ticket: " + parkingTicket.getTicketId().toString());
    }
}

public class CreditCardPaymentStrategy implements PaymentStrategy{
    CreditCardPaymentStrategy(String CreditCardDetails) {

    }

    public void makePayment(Double amount) {
        System.out.println("Made payment using credit card of amount: " + amount);
    }
}

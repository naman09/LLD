public interface PaymentStrategy {
    public void makePayment(Double amount) throws PaymentException;
}

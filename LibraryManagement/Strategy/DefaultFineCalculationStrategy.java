package Strategy;

import Models.BookLoan;

public class DefaultFineCalculationStrategy implements FineCalculationStrategy {
    public Double calculateFine(BookLoan bookLoan) {
        return 0.0;
    }
}
